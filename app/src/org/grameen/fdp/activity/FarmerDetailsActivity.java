package org.grameen.fdp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.PlotsListAdapter;
import org.grameen.fdp.object.ComplexCalculation;
import org.grameen.fdp.object.FarmResult;
import org.grameen.fdp.object.Form;
import org.grameen.fdp.object.Logic;
import org.grameen.fdp.object.Monitoring;
import org.grameen.fdp.object.PlotAssessment;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class FarmerDetailsActivity extends BaseActivity {

    boolean itemsLoaded = false;
    RealFarmer farmer;
    TextView name;
    TextView code;
    CircleImageView circleImageView;
    TextView initials;
    TextView villageName;
    TextView landArea;
    TextView lastVisitDate;
    TextView addPlot;
    View syncIndicator;
    PlotsListAdapter plotsListAdapter;

    List<RealPlot> plots = new ArrayList<>();
    List<String> PLOT_ASSESSMENT_LIST = new ArrayList<>();
    List<Monitoring> MONITORING_LIST;
    List<PlotAssessment> PLOT_ASSESSMENTS = new ArrayList<>();

    String CURRENT_FARMER_MONITORING_JSON = "";

    int MAX_NO_OF_MONITORING = 0;
    String message = "";
    int monitoringYear;

    String TAG = "FarmerDetailsActivity";

    JSONObject FARM_RESULTS;


    RecyclerView plotsRecyclerView;
    boolean monitoringMode = false;
    private ImageView editFarmerDetails;
    private TextView noOfPlots;


    String correspondingMessage = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);
        Toolbar toolbar = setToolbar(getResources(R.string.farmer_details));


        name = (TextView) findViewById(R.id.name);
        code = (TextView) findViewById(R.id.code);
        initials = (TextView) findViewById(R.id.initials);
        villageName = (TextView) findViewById(R.id.villageName);
        landArea = (TextView) findViewById(R.id.landSize);
        lastVisitDate = (TextView) findViewById(R.id.lastVisitDate);
        syncIndicator = findViewById(R.id.sync);
        editFarmerDetails = (ImageView) findViewById(R.id.edit);
        plotsRecyclerView = (RecyclerView) findViewById(R.id.plotsRecyclerView);
        addPlot = (TextView) findViewById(R.id.addPlot);
        noOfPlots = (TextView) findViewById(R.id.noOfPlots);
        circleImageView = (CircleImageView) findViewById(R.id.photo);


        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

            //Todo add the rest of the views to hide
            monitoringMode = true;

            findViewById(R.id.edit).setVisibility(View.GONE);
            findViewById(R.id.addPlot).setVisibility(View.GONE);



        }else
            findViewById(R.id.farm_assessment_layout).setVisibility(View.GONE);


        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);

        if (farmer != null) {

            initializeViews(true);


            addPlot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Todo go to add plot activity
                    Intent intent = new Intent(FarmerDetailsActivity.this, AddNewPlotActivity.class);
                    intent.putExtra("farmerCode", farmer.getCode());
                    startActivity(intent);


                }
            });


        } else {

            Toast.makeText(this, getResources(R.string.error_getting_farmer_info), Toast.LENGTH_SHORT).show();
        }


        onBackClicked();
    }


    void initializeViews(Boolean loadButtons) {

        name.setText(farmer.getFarmerName());
        code.setText(farmer.getCode());
        villageName.setText(farmer.getVillage());
        landArea.setText(farmer.getLandArea());
        lastVisitDate.setText(farmer.getLastVisitDate());

//        syncIndicator.setVisibility((farmer.getSyncStatus() == Constants.SYNC_OK) ? View.VISIBLE : View.GONE);

        setUpPlotsAdapter();



       /* if(!itemsLoaded)
         setUpPlotsAdapter();
        else {
            plotsListAdapter.notifyDataSetChanged();
            Log.d(TAG, "PLOTS LIST ADAPTER NOT NULL");

        }*/


        Log.d(TAG, "IMAGE URL ###########   " + farmer.getImageUrl() + "");


        if (farmer.getImageUrl() != null && !farmer.getImageUrl().equals("")) {
            Log.d(TAG, "IMAGE URL    " + farmer.getImageUrl() + "");


            Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

        } else {

            try {
                String[] valueArray = farmer.getFarmerName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                initials.setText(value);

            } catch (Exception e) {

                initials.setText(farmer.getFarmerName().substring(0, 1));


            }

            int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(randomColor);
            circleImageView.setBackground(drawable);
        }


        if (loadButtons) {
            LinearLayout dynamicButtonsLayout = (LinearLayout) findViewById(R.id.dynamicButtons);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            List<Form> forms;
            if(monitoringMode) forms = databaseHelper.getAllForms();
            else forms = databaseHelper.getAllDiagnosticForms();

            for (final Form f : forms) {

                final Button btn = (Button) getLayoutInflater().inflate(R.layout.dynamic_button, null);
                //btn.setId(f.getId());

                btn.setText(f.getName());

                 dynamicButtonsLayout.addView(btn, params);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(f.getName().equalsIgnoreCase(Constants.FAMILY_MEMBERS)){

                            String familyMembers = "1";

                            String farmerProfileJsonString = databaseHelper.getSpecificFarmerDetails(Constants.FARMER_PROFILE, farmer.getCode());

                            if(farmerProfileJsonString == null){
                                Log.i(TAG, "FAMILY MEMBERS OF FARMER PROFILE IS NULL");



                                showAlertDialog(false, getResources(R.string.fill_data), getResources(R.string.enter_data_rationale) + farmer.getFarmerName() + getResources(R.string.before_proceed_suffux), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        dialog.dismiss();

                                    }
                                }, getResources(R.string.ok), null, "", 0);




                            }else{

                                Log.i(TAG, "FAMILY MEMBERS KEY " + prefs.getString("no_family_members_id", "null"));

                                try {
                                    JSONObject jsonObject;
                                    jsonObject = new JSONObject(farmerProfileJsonString);


                                    familyMembers = jsonObject.get(prefs.getString("no_family_members_id", "null")).toString();
                                    Log.i(TAG, "FAMILY MEMBERS OF FARMER " + farmer.getFarmerName() + " IS " + familyMembers);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    familyMembers = "1";
                                }

                                if(familyMembers.equalsIgnoreCase("null")){
                                    Log.i(TAG, "FAMILY MEMBERS OF FARMER NULL");

                                    //Please fill out Socio-Economic data first

                                    showAlertDialog(false, getResources(R.string.fill_data), getResources(R.string.enter_data_rationale) + farmer.getFarmerName() + getResources(R.string.before_proceed_suffux), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            dialog.dismiss();

                                        }
                                    }, getResources(R.string.ok), null, "", 0);

                                }else {

                                    try {
                                        JSONObject jsonObject;
                                        jsonObject = new JSONObject(farmerProfileJsonString);


                                        familyMembers = jsonObject.get(prefs.getString("no_family_members_id", "null")).toString();
                                        Log.i(TAG, "FAMILY MEMBERS OF FARMER " + farmer.getFarmerName() + " IS " + familyMembers);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                    Intent intent = new Intent(FarmerDetailsActivity.this, FamilyMembersActivity_v2.class);
                                    intent.putExtra("farmer", new Gson().toJson(farmer));
                                    intent.putExtra("familyMembers", familyMembers);
                                    startActivity(intent);


                                }


                            }




                        }else {


                            Log.d(TAG, "BUTTON CLICKED WAS " + btn.getText().toString().toLowerCase());

                            Intent intent = new Intent(FarmerDetailsActivity.this, Add_EditFarmerDetailsActivity.class);
                            intent.putExtra("farmer", new Gson().toJson(farmer));
                            intent.putExtra("flag", "edit");

                            intent.putExtra("formType", btn.getText().toString().toLowerCase());
                            startActivity(intent);
                            //finish();


                        }

                    }
                });

            }




        }


        findViewById(R.id.pandl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!checkIfFarmSizeCorresponds(farmer.getCode())){

                    showAlertDialog(true, getResources(R.string.no_access_to_pl), correspondingMessage, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    }, getResources(R.string.ok), null, "", 0);







                }else {


                    boolean shouldGoNext = true;

                    StringBuilder msg = new StringBuilder();


                    if (plots != null && plots.size() > 0) {

                        for (RealPlot plot : plots) {

                            if (plot.getRecommendationId() == null || plot.getRecommendationId().equals("") || plot.getRecommendationId().equals("null") || plot.getRecommendationId().equals("empty")) {

                                msg.append(plot.getName());

                                if (plots.size() > 1) {

                                    if (plot != plots.get(plots.size() - 1) && plot != plots.get(plots.size() - 2))
                                        msg.append(", ");

                                    if (plot == plots.get(plots.size() - 2))
                                        msg.append(getResources(R.string.and));
                                }
                                shouldGoNext = false;
                            }

                        }


                        if (shouldGoNext) {

                            Intent intent = new Intent(FarmerDetailsActivity.this, PandLActivity.class);
                            intent.putExtra("farmer", new Gson().toJson(farmer));
                            startActivity(intent);

                        } else {
                            message = getResources(R.string.enter_all_ao_data) + msg.toString();

                            showAlertDialog(true, getResources(R.string.missing_data), message, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    dialogInterface.dismiss();

                                }
                            }, getResources(R.string.ok), null, "", 0);

                        }
                    } else {

                        showAlertDialog(true, getResources(R.string.no_plots), getResources(R.string.add_plot), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        }, getResources(R.string.ok), null, "", 0);


                    }


                }
            }
        });






        findViewById(R.id.farm_assessment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PLOT_ASSESSMENTS = new ArrayList<>();
                FARM_RESULTS = new JSONObject();
                PLOT_ASSESSMENT_LIST = new ArrayList<>();

                //Check if farmer has same number of monitoring on all plots
                //Check if results of monitoring has been answered

                if(checkIfAllFarmPlotsHaveSameNumberOfMonitoring()) {
                    Log.d(TAG, "SAME NUMBER OF MONITORING? = true");

                    if(checkIfAllPlotsHaveBeenAssessed()){

                        CustomToast.makeToast(FarmerDetailsActivity.this, "All validations complete. Now you can access Farm Assessment!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "AO M FOR ALL PLOTS? = true");

                        for(int i = 0; i < plots.size(); i++) {

                            PLOT_ASSESSMENTS.add(new PlotAssessment(plots.get(i).getName(), PLOT_ASSESSMENT_LIST.get(i)));
                        }

                        Log.d(TAG, "NO OF PLOTS IS " + plots.size());
                        Log.d(TAG, "NO OF ASSESSMENTS FOR ALL PLOTS IS " + PLOT_ASSESSMENT_LIST.size());

                        Log.d(TAG, "SIZE OF PLOT ASSESSMENT IS " + PLOT_ASSESSMENTS.size());


                        List<ComplexCalculation> complexCalculationList = databaseHelper.getAllComplexCalculation();

                        int i = 1;
                        for(ComplexCalculation cc : complexCalculationList) {


                            String formula = cc.getCondition();

                            JSONObject jsonObject;
                            try {
                                jsonObject = new JSONObject(CURRENT_FARMER_MONITORING_JSON);
                            }catch(JSONException j){
                                j.printStackTrace();

                                jsonObject = new JSONObject();

                            }


                            if(formula.startsWith("IF(")) {
                                Log.d(TAG, "FORMULA NO. " + i++ + ". " + formula);


                                try {
                                    Log.i(TAG, "JSON STRING IS = " + CURRENT_FARMER_MONITORING_JSON);


                                    FARM_RESULTS.put(cc.getQuestionId(), parseIfFormula(formula.trim(), jsonObject));
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }


                            }else if(formula.startsWith("Collections.frequency(")){

                                String parsedAAnswer = parseCollectionsFormula(formula.trim());

                                try {
                                    FARM_RESULTS.put(cc.getQuestionId(), parsedAAnswer);
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }

                                if(formula.contains("Non-Critical Fail")) {

                                    Log.i(TAG, " ^^^^^^^^^^  FOUND NON CRITICAL FAIL PERCENT ^^^^^^^^^^^^");

                                    String percentagePlotsId = databaseHelper.getQuestionIdByTranslationName("Percentage non critical");

                                    double noNonCriticalFail = Double.parseDouble(parsedAAnswer);
                                    String dispose = String.valueOf(noNonCriticalFail/plots.size());

                                    Log.i(TAG, "% NON CRITICAL FAIL = " + dispose);


                                    try {
                                        FARM_RESULTS.put(percentagePlotsId, dispose);
                                    } catch (JSONException e) {
                                        e.printStackTrace();

                                    }
                                }



                            }else{
                                try {
                                    FARM_RESULTS.put(cc.getQuestionId(), "0");
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }
                            }
                        }






                        Log.i(TAG, "FARMER RESULTS IS " + FARM_RESULTS.toString());
                        Logic thisLogic = null;

                        String farmResultId = databaseHelper.getQuestionIdByTranslationName("Farm result");
                        List<Logic>  logicList = databaseHelper.getLogics(farmResultId);

                        Log.i(TAG, "LOGIC SIZE FOR FARMER RESULTS IS " + logicList.size());


                        for(Logic l : logicList){

                            Boolean booleanValue = getLogicValue(l);

                            if(booleanValue != null && booleanValue) {
                                thisLogic = l;
                                break;
                            }
                        }


                        FarmResult farmResult = new FarmResult();
                        farmResult.setCaption(getResources(R.string.farm_result));

                        if(thisLogic != null)
                        farmResult.setStatus(thisLogic.getResult());
                        farmResult.setPlotAssessmentList(PLOT_ASSESSMENTS);

                        Log.d(TAG, "***** FARM RESULTS = " + farmResult.getStatus());


                        Intent intent = new Intent(FarmerDetailsActivity.this, FarmAssessmentActivity.class);
                        intent.putExtra("farmResults", new Gson().toJson(farmResult));
                        intent.putExtra("farmer", new Gson().toJson(farmer));

                        startActivity(intent);






                    }else{
                        Log.d(TAG, "AO M FOR ALL PLOTS? = false");

                        showAlertDialog(true, getResources(R.string.incomplete_ao_monitoring), message, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        }, getResources(R.string.ok), null, "", 0);

                    }
                }else{
                    Log.d(TAG, "SAME NUMBER OF MONITORING? = false");



                    showAlertDialog(true, getResources(R.string.different_no_monitoring), message, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    }, getResources(R.string.ok), null, "", 0);


                }




            }
        });


    }


    void setUpPlotsAdapter() {

        if (plots == null)
            plots = databaseHelper.getAllFarmerPlots(farmer.getCode());

        if (plots != null) {
            int plotsSize = plots.size();

            noOfPlots.setText((plotsSize > 1) ? "Plot Adoption Observations " + "(" + plotsSize + ")" : "Plot Adoption Observation " + "(" + plotsSize + ")");


            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

            plotsRecyclerView.setLayoutManager(horizontalLayoutManagaer);
               /* SpacesGridItemDecoration decoration = new SpacesGridItemDecoration(4);
            plotsRecyclerView.removeItemDecoration(decoration);
            plotsRecyclerView.addItemDecoration(decoration);*/


            plotsListAdapter = new PlotsListAdapter(this, plots);
            plotsListAdapter.setHasStableIds(true);

            plotsRecyclerView.setAdapter(plotsListAdapter);

            plotsListAdapter.setOnItemClickListener(new PlotsListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    //Todo go to plot details

                    if(!monitoringMode) {


                        Intent intent = new Intent(FarmerDetailsActivity.this, PlotDetailsActivity.class);
                        intent.putExtra("plot", new Gson().toJson(plots.get(position)));
                        startActivity(intent);

                    }else{


                        Intent intent = new Intent(FarmerDetailsActivity.this, MonitoringYearSelectionActivity.class);
                        intent.putExtra("farmer", new Gson().toJson(farmer));

                        intent.putExtra("plot", new Gson().toJson(plots.get(position)));
                        startActivity(intent);

                    }

                }
            });


            if (!monitoringMode)
                plotsListAdapter.OnLongClickListener(new PlotsListAdapter.OnLongClickListener() {
                    @Override
                    public void onLongClick(View view, final int position) {

                        final RealPlot plot = plots.get(position);

                        showAlertDialog(true, "Delete Plot Info", "Do you want to delete data for " + plot.getName() + "?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                                if (databaseHelper.deletePlot(plot.getId())) {
                                    CustomToast.makeToast(FarmerDetailsActivity.this, "Data deleted!", Toast.LENGTH_LONG).show();
                                    plots.remove(position);
                                    plotsListAdapter.notifyItemRemoved(position);

                                }


                            }
                        }, "YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        }, "No", 0);


                    }

                });


            itemsLoaded = true;


        } else noOfPlots.setText("Plot Adoption Observations");


    }


    @Override
    protected void onResume() {
        // setUpPlotsAdapter();

        plots = databaseHelper.getAllFarmerPlots(farmer.getCode());

        Log.i("FARMER DETAILS", "ON RESUME!");

        farmer = databaseHelper.getFarmerBasicInfo(farmer.getCode());

        initializeViews(false);


        super.onResume();
    }

/*
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.i("FARMER DETAILS", "******    ON NEW INTENT!!!!! ******");


        farmer = databaseHelper.getFarmerBasicInfo(farmer.getCode());
        initializeViews(false);

    }*/

    @Override
    public void onBackPressed() {


        super.onBackPressed();

       /* Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();


*/


    }




    public boolean checkIfFarmSizeCorresponds(String farmerCode){

        Boolean booleanValue = true;

        Double farmAcre = null;
        //String totalUnit = "null";

        try{

            JSONObject productiveProfile = new JSONObject(databaseHelper.getProductiveProfileJson(farmerCode));
            farmAcre = Double.parseDouble(productiveProfile.get(prefs.getString("totalLandSize", "")).toString());

           // totalUnit = farmingEconomicProfileJson.getString(prefs.getString("totalAreaUnit", ""));

        }catch(Exception e){
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
       // StringBuilder stringUnitBuilder = new StringBuilder();


        List<RealPlot> plots = databaseHelper.getAllFarmerPlots(farmerCode);

        for(RealPlot plot : plots){

            try {
                JSONObject jsonObject = new JSONObject(plot.getPlotInformationJson());

                String[] value = jsonObject.get("size").toString().split(" ");

                stringBuilder.append(value[0]).append("+");

               // stringUnitBuilder.append(estimatedProductions[1]);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        stringBuilder.append("0");

        Double totalSizes = calculateDouble(stringBuilder.toString());


        Log.i(TAG, "$$$$$$$$$$$$$    TOTAL SIZES " + farmAcre + " AND TOTAL PLOTS SIZES " + totalSizes);

             if (farmAcre != null && totalSizes != null) {
                if (totalSizes > farmAcre){
                    booleanValue = false;

                    correspondingMessage = getResources(R.string.ensure_farm_acre_equal);
                    CustomToast.makeToast(this, correspondingMessage, Toast.LENGTH_LONG).show();

                }
             } else {

                 correspondingMessage = getResources(R.string.fill_in_plot_size_values);

                 booleanValue = false;
                 CustomToast.makeToast(this, correspondingMessage, Toast.LENGTH_LONG).show();

             }


             return booleanValue;


    }



    public boolean checkIfAllFarmPlotsHaveSameNumberOfMonitoring(){

        List<Integer> noOfPlotMonitorings = new ArrayList<>();
        int noOfPlots = 0;

        monitoringYear = prefs.getInt(farmer.getCode(), -1);

        plots = databaseHelper.getAllFarmerPlots(farmer.getCode());

        if(plots != null && plots.size() > 0){

            noOfPlots = plots.size();

            for (RealPlot plot : plots) {

                MONITORING_LIST = databaseHelper.getAllPlotMonitoringForYear(plot.getId(), String.valueOf(monitoringYear));
                noOfPlotMonitorings.add(MONITORING_LIST.size());

            }

            MAX_NO_OF_MONITORING = Collections.max(noOfPlotMonitorings);
            Log.i(TAG, "MAX NO OF MONITORING FOR A PLOT = " + MAX_NO_OF_MONITORING);


            int collections = Collections.frequency(noOfPlotMonitorings, MAX_NO_OF_MONITORING);
            Log.i(TAG, "NO OF OCCURRENCE = " + MAX_NO_OF_MONITORING + " AND PLOTS ARRAY SIZE IS " + noOfPlots);


            if(!Objects.equals(collections, noOfPlots)) {
                message =  getResources(R.string.monitoring_for_year)+ monitoringYear + getResources(R.string.for_) + farmer.getFarmerName() + getResources() + getResources(R.string.incorrect_no_plots_suffix);

                return false;
            }else {

                if(noOfPlotMonitorings.contains(0))
                {
                    message = getResources(R.string.farmer)+ farmer.getFarmerName() + getResources(R.string.no_monitoring_added) + monitoringYear + getResources(R.string.please_add_monitoring_suffix);

                    return false;

                }else {
                    return true;
                }

            }

        }else{
            message = getResources(R.string.farmer) + farmer.getFarmerName() + getResources(R.string.no_plots_added_suffix);
            return false;

        }

    }



    boolean checkIfAllPlotsHaveBeenAssessed(){

        MONITORING_LIST = null;
        PLOT_ASSESSMENT_LIST = new ArrayList<>();


        String plotAssessmentID = databaseHelper.getQuestionIdByTranslationName("Plot Assessment");

        for (RealPlot plot : plots) {

            MONITORING_LIST = databaseHelper.getAllPlotMonitoringForYear(plot.getId(), String.valueOf(monitoringYear));

            if(prefs.getString("monitoringToUse", "Last").equalsIgnoreCase("last")){

                String discardableString = "";

                try {

                    CURRENT_FARMER_MONITORING_JSON = MONITORING_LIST.get(MAX_NO_OF_MONITORING - 1).getJson();

                    JSONObject discardableJson = new JSONObject(CURRENT_FARMER_MONITORING_JSON);
                    discardableString = discardableJson.get(plotAssessmentID).toString();


                } catch (JSONException e) {
                    e.printStackTrace();

                    discardableString = Constants.NO_MONITORING_PLACE_HOLDER;
                }

                PLOT_ASSESSMENT_LIST.add(discardableString);
                Log.i(TAG, "LAST VALUES : DISCARDABLE STRING " + discardableString);


            }else{

                String discardableString = "";

                try {
                    CURRENT_FARMER_MONITORING_JSON = MONITORING_LIST.get(0).getJson();

                    JSONObject discardableJson = new JSONObject(CURRENT_FARMER_MONITORING_JSON);
                    discardableString = discardableJson.get(plotAssessmentID).toString();

                } catch (JSONException e) {
                    e.printStackTrace();

                    discardableString = Constants.NO_MONITORING_PLACE_HOLDER;
                }



                PLOT_ASSESSMENT_LIST.add(discardableString);
                Log.i(TAG, "FIRST VALUES : DISCARDABLE STRING " + discardableString);


            }
        }







        if(PLOT_ASSESSMENT_LIST.contains(Constants.NO_MONITORING_PLACE_HOLDER)){

            message = getResources(R.string.incomplete_monitoring_prefix) + monitoringYear + getResources(R.string.incomplete_monitoring_suffix);
            return  false;



        }else return true;

    }


    int getSizeOfList(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.length();
        } catch (JSONException e) {
            e.printStackTrace();
            return  0;
        }


    }








    String parseCollectionsFormula(String formula){
        int value = -1;

        String parsedEquation = formula.split( ",")[1];

        parsedEquation = parsedEquation.split(Pattern.quote(")"))[0];
        parsedEquation = parsedEquation.replace("\"", "");

        Log.i(TAG, "AFTER PARSING COLLEcTION TYPE CC " + parsedEquation);

        value = Collections.frequency(PLOT_ASSESSMENT_LIST, parsedEquation);

        Log.i(TAG, formula + " IS " + value);

        return String.valueOf(value);




    }





    String getValue(String questionId, JSONObject jsonObject){

        String answer = "--";

        try {
            answer =  jsonObject.get(questionId).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return answer;
    }





    Boolean getLogicValue(Logic logic) {


        if (logic == null)
            return null;

        else {
            if (logic.getQuestion10() != null && !logic.getQuestion10().equals("null")) {


                Log.i(TAG, "LOGIC WITH 10 QUESTIONS! WITH QUESTION !) VALUE = " + logic.getQuestion10() + "\n\n");

                if (logic.getQuestion10().equals(""))
                    return null;


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Logic l6 = new Logic();
                l6.setQUESTION(logic.getQuestion6());
                l6.setLOGICAL_OPERATOR(logic.getLogicalOperator6());
                l6.setVALUE(logic.getValue6());


                Logic l7 = new Logic();
                l7.setQUESTION(logic.getQuestion7());
                l7.setLOGICAL_OPERATOR(logic.getLogicalOperator7());
                l7.setVALUE(logic.getValue7());


                Logic l8 = new Logic();
                l8.setQUESTION(logic.getQuestion8());
                l8.setLOGICAL_OPERATOR(logic.getLogicalOperator8());
                l8.setVALUE(logic.getValue8());


                Logic l9 = new Logic();
                l9.setQUESTION(logic.getQuestion9());
                l9.setLOGICAL_OPERATOR(logic.getLogicalOperator9());
                l9.setVALUE(logic.getValue9());


                Logic l10 = new Logic();
                l10.setQUESTION(logic.getQuestion10());
                l10.setLOGICAL_OPERATOR(logic.getLogicalOperator10());
                l10.setVALUE(logic.getValue10());


                Boolean value;

                try {

                    String equation = ((((((((compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2))
                            + logic.getQuestionLogicOperation2() + compareValues(l3))
                            + logic.getQuestionLogicOperation3() + compareValues(l4))
                            + logic.getQuestionLogicOperation4() + compareValues(l5))
                            + logic.getQuestionLogicOperation5() + compareValues(l6))
                            + logic.getQuestionLogicOperation6() + compareValues(l7))
                            + logic.getQuestionLogicOperation7() + compareValues(l8))
                            + logic.getQuestionLogicOperation8() + compareValues(l9))
                            + logic.getQuestionLogicOperation9() + compareValues(l10);


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value + "\n");

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion9() != null && !logic.getQuestion9().equals("null")) {


                Log.i(TAG, "LOGIC WITH 9 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Logic l6 = new Logic();
                l6.setQUESTION(logic.getQuestion6());
                l6.setLOGICAL_OPERATOR(logic.getLogicalOperator6());
                l6.setVALUE(logic.getValue6());


                Logic l7 = new Logic();
                l7.setQUESTION(logic.getQuestion7());
                l7.setLOGICAL_OPERATOR(logic.getLogicalOperator7());
                l7.setVALUE(logic.getValue7());


                Logic l8 = new Logic();
                l8.setQUESTION(logic.getQuestion8());
                l8.setLOGICAL_OPERATOR(logic.getLogicalOperator8());
                l8.setVALUE(logic.getValue8());


                Logic l9 = new Logic();
                l9.setQUESTION(logic.getQuestion9());
                l9.setLOGICAL_OPERATOR(logic.getLogicalOperator9());
                l9.setVALUE(logic.getValue9());


                Boolean value;

                try {


                    String equation = ((((((((compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2))
                            + logic.getQuestionLogicOperation2() + compareValues(l3))
                            + logic.getQuestionLogicOperation3() + compareValues(l4))
                            + logic.getQuestionLogicOperation4() + compareValues(l5))
                            + logic.getQuestionLogicOperation5() + compareValues(l6))
                            + logic.getQuestionLogicOperation6() + compareValues(l7))
                            + logic.getQuestionLogicOperation7() + compareValues(l8))
                            + logic.getQuestionLogicOperation8() + compareValues(l9));


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion8() != null && !logic.getQuestion8().equals("null")) {


                Log.i(TAG, "LOGIC WITH 8 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Logic l6 = new Logic();
                l6.setQUESTION(logic.getQuestion6());
                l6.setLOGICAL_OPERATOR(logic.getLogicalOperator6());
                l6.setVALUE(logic.getValue6());


                Logic l7 = new Logic();
                l7.setQUESTION(logic.getQuestion7());
                l7.setLOGICAL_OPERATOR(logic.getLogicalOperator7());
                l7.setVALUE(logic.getValue7());


                Logic l8 = new Logic();
                l8.setQUESTION(logic.getQuestion8());
                l8.setLOGICAL_OPERATOR(logic.getLogicalOperator8());
                l8.setVALUE(logic.getValue8());


                Boolean value;

                try {


                    String equation = (
                            ((((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6))
                                    + logic.getQuestionLogicOperation6() + compareValues(l7))
                                    + logic.getQuestionLogicOperation7() + compareValues(l8)
                    );


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;

            } else if (logic.getQuestion7() != null && !logic.getQuestion7().equals("null")) {


                Log.i(TAG, "LOGIC WITH 7 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Logic l6 = new Logic();
                l6.setQUESTION(logic.getQuestion6());
                l6.setLOGICAL_OPERATOR(logic.getLogicalOperator6());
                l6.setVALUE(logic.getValue6());


                Logic l7 = new Logic();
                l7.setQUESTION(logic.getQuestion7());
                l7.setLOGICAL_OPERATOR(logic.getLogicalOperator7());
                l7.setVALUE(logic.getValue7());


                Boolean value;

                try {


                    String equation = (
                            (((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6))
                                    + logic.getQuestionLogicOperation6() + compareValues(l7)
                    );


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion6() != null && !logic.getQuestion6().equals("null")) {


                Log.i(TAG, "LOGIC WITH 6 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Logic l6 = new Logic();
                l6.setQUESTION(logic.getQuestion6());
                l6.setLOGICAL_OPERATOR(logic.getLogicalOperator6());
                l6.setVALUE(logic.getValue6());


                Boolean value;

                try {


                    String equation = (
                            ((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion5() != null && !logic.getQuestion5().equals("null")) {

                Log.i(TAG, "LOGIC WITH 5 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Logic l5 = new Logic();
                l5.setQUESTION(logic.getQuestion5());
                l5.setLOGICAL_OPERATOR(logic.getLogicalOperator5());
                l5.setVALUE(logic.getValue5());


                Boolean value;

                try {


                    String equation = (
                            (((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion4() != null && !logic.getQuestion4().equals("null")) {

                Log.i(TAG, "LOGIC WITH 4 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Logic l4 = new Logic();
                l4.setQUESTION(logic.getQuestion4());
                l4.setLOGICAL_OPERATOR(logic.getLogicalOperator4());
                l4.setVALUE(logic.getValue4());


                Boolean value;

                try {


                    String equation = (
                            ((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion3() != null && !logic.getQuestion3().equals("null")) {


                Log.i(TAG, "LOGIC WITH 3 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Logic l3 = new Logic();
                l3.setQUESTION(logic.getQuestion3());
                l3.setLOGICAL_OPERATOR(logic.getLogicalOperator3());
                l3.setVALUE(logic.getValue3());


                Boolean value;

                try {


                    String equation = (
                            (compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion2() != null && !logic.getQuestion2().equals("null")) {

                Log.i(TAG, "LOGIC WITH 2 QUESTIONS!\n\n");


                Logic l1 = new Logic();
                l1.setQUESTION(logic.getQuestion1());
                l1.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l1.setVALUE(logic.getValue1());


                Logic l2 = new Logic();
                l2.setQUESTION(logic.getQuestion2());
                l2.setLOGICAL_OPERATOR(logic.getLogicalOperator2());
                l2.setVALUE(logic.getValue2());


                Boolean value;

                try {

                    String equation = (compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2));


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion1() != null && !logic.getQuestion1().equals("null")) {

                Log.i(TAG, "LOGIC WITH 1 QUESTIONS!\n\n");

                Logic l = new Logic();
                l.setQUESTION(logic.getQuestion1());
                l.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l.setVALUE(logic.getValue1());

                return compareValues(l);

            } else
                return null;


        }
    }

    Boolean compareValues(Logic logic) {

        Boolean value = false;
        String inputValue = getValue(logic.getQUESTION(), FARM_RESULTS);
        Log.i(TAG, "EQUATION IS    ");


        Log.i(TAG, inputValue + "  " + logic.getLOGICAL_OPERATOR() + "  " + logic.getVALUE() + "\n\n");


        if (inputValue != null) {

            try {
                Double.parseDouble(inputValue.trim());

                value = (Boolean) engine.eval(inputValue + logic.getLOGICAL_OPERATOR() + logic.getVALUE());

                return value;

            } catch (ScriptException | NumberFormatException e) {

                System.out.println("**********EXCEPTION******************" + e.getMessage());

                value = inputValue.equalsIgnoreCase(logic.getVALUE());
                return value;
            } finally {
                System.out.println("*****************************LOGIC VALUE IS: " + value);

            }
        } else return null;


    }

}
