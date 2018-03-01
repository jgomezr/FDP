package org.grameen.fdp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.MyFormFragment;
import org.grameen.fdp.object.Logic;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class AddNewPlotActivity extends BaseActivity {

    boolean isEditMode = false;
    boolean newDataSaved = false;
    RealPlot plot;
    //MyFormFragment plotInfoFragment;
    MyFormFragment plotAOFragment;
    String TAG = "Add New Plot Act";

    EditText plotName;
    EditText plotSizeEdittext;
    TextView plotSizeUnit;
    EditText estimatedProductionEdittext;
    TextView estimatedProductionUnit;
    EditText phEdittext;


    JSONObject JSON_OBJECT = null;
    JSONObject PLOT_INFO_JSON;


    Button save;
    String farmerCode;

    String plotSize = "";
    String estProductionSize = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_a_plot);


        prefs.edit().putBoolean("isInPlotInfoActivity", false).apply();

        Toolbar toolbar;

        plotSizeEdittext = findViewById(R.id.plotSizeEdittext);
        plotSizeUnit = findViewById(R.id.plotSizeUnitSpinner);



        estimatedProductionEdittext = findViewById(R.id.estimatedProductionEdittext);
        estimatedProductionUnit = findViewById(R.id.productionSizeUnitSpinner);

        phEdittext = findViewById(R.id.phEdittext);


        save = findViewById(R.id.saveButton);
        save.setEnabled(false);

        plotName = (EditText) findViewById(R.id.plotNameEdittext);
        plotName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() < 2) {
                    save.setEnabled(false);
                    CustomToast.makeToast(AddNewPlotActivity.this, getResources(R.string.enter_valid_plot_name), Toast.LENGTH_SHORT).show();

                } else save.setEnabled(true);
            }


        });


        Intent intent = getIntent();


        if (intent.getStringExtra("flag") != null && intent.getStringExtra("flag").equals("edit")) {
            isEditMode = true;
            toolbar = setToolbar(getResources(R.string.edit_plot));


            plot = new Gson().fromJson(getIntent().getStringExtra("plot"), RealPlot.class);
            plotName.setText(plot.getName());
            farmerCode = plot.getFarmerCode();


            String plotInfo = plot.getPlotInformationJson();

            try {
                JSONObject jsonObject = new JSONObject(plotInfo);

                String[] size = jsonObject.get("size").toString().split(" ");
                plotSizeEdittext.setText(size[0]);
                //plotSizeUnit.setText(size[1]);


                String[] estProd = jsonObject.get("estimatedProduction").toString().split(" ");
                estimatedProductionEdittext.setText(estProd[0]);
                //estimatedProductionUnit.setText(estProd[1]);

                phEdittext.setText(jsonObject.get("ph").toString());

            } catch (JSONException | ArrayIndexOutOfBoundsException | NullPointerException e ) {
                e.printStackTrace();
            }

            String farmingEconomicProfileJson = databaseHelper.getSpecificFarmerDetails(Constants.FARMING_ECONOMIC_PROFILE, farmerCode);

            Log.i(TAG, "FARMING ECO PROFILE " + farmingEconomicProfileJson);

            if(farmingEconomicProfileJson != null)

                try {

                JSONObject jsonObject = new JSONObject(farmingEconomicProfileJson);
                plotSizeUnit.setText(jsonObject.get(databaseHelper.getQuestionIdByTranslationName("Area units")).toString());
                estimatedProductionUnit.setText(jsonObject.get(databaseHelper.getQuestionIdByTranslationName("Weight units")).toString());

            } catch (JSONException | ArrayIndexOutOfBoundsException | NullPointerException e ) {
                e.printStackTrace();
                plotSizeUnit.setText("--");
                estimatedProductionUnit.setText("--");

            } else{
                plotSizeUnit.setText("--");
                estimatedProductionUnit.setText("--");
            }


            Log.i(TAG, "WEIGHT " + estimatedProductionUnit.getText().toString());
            Log.i(TAG, "AREA " + plotSizeUnit.getText().toString());





            plotAOFragment = MyFormFragment.newInstance(Constants.ADOPTION_OBSERVATIONS, true, plot.getFarmerCode() + "_" + plot.getId(), false);




            loadDynamicView(plotAOFragment, R.id.aosLayout);


        } else {

            setToolbar(getResources(R.string.add_new_plot));
            farmerCode = getIntent().getStringExtra("farmerCode");

            String farmingEconomicProfileJson = databaseHelper.getSpecificFarmerDetails(Constants.FARMING_ECONOMIC_PROFILE, farmerCode);

            Log.i(TAG, "FARMING ECO PROFILE " + farmingEconomicProfileJson);

            if(farmingEconomicProfileJson != null)
            try {

                JSONObject jsonObject = new JSONObject(farmingEconomicProfileJson);
                plotSizeUnit.setText(jsonObject.get(databaseHelper.getQuestionIdByTranslationName("Area units")).toString());
                estimatedProductionUnit.setText(jsonObject.get(databaseHelper.getQuestionIdByTranslationName("Weight units")).toString());

            } catch (JSONException e) {
                e.printStackTrace();

                plotSizeUnit.setText("--");
                estimatedProductionUnit.setText("--");

            }

            else{
                plotSizeUnit.setText("--");
                estimatedProductionUnit.setText("--");
            }



            int noOfPlots = databaseHelper.getAllFarmerPlots(farmerCode).size() + 1;
            String value = "Plot " + noOfPlots;
            plotName.setText(value);



            //    plotInfoFragment = MyFormFragment.newInstance(Constants.PLOT_INFORMATION, false, null);
            plotAOFragment = MyFormFragment.newInstance(Constants.ADOPTION_OBSERVATIONS, false, null, false);

            loadDynamicView(plotAOFragment, R.id.aosLayout);

        }


        findViewById(R.id.plot_mapping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Todo go to Map Activity
                if (!plotName.getText().toString().isEmpty() || !plotName.getText().toString().equals("")) {

                    Intent intent = new Intent(AddNewPlotActivity.this, MapActivity.class);


                    if (!isEditMode) {
                        plot = new RealPlot();
                        plot.setId(databaseHelper.getSystemTime());
                        plot.setFarmerCode(farmerCode);
                        plot.setName(plotName.getText().toString());

                    }

                    intent.putExtra("plot", new Gson().toJson(plot));
                    startActivity(intent);


                } else
                    Toast.makeText(AddNewPlotActivity.this, getResources(R.string.provide_plot_name), Toast.LENGTH_SHORT).show();

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                saveOrUpdateData(true);

            }
        });


        onBackClicked();

    }


    void saveOrUpdateData(boolean shouldMoveToNextActivity) {
        engine = new ScriptEngineManager().getEngineByName("rhino");

        if (!newDataSaved) {

            save.setEnabled(false);

            String plotRenovatedId = "plot_renovated", plotRenovationMadeId = "plot_renovationMade", plotInterventionAppliedId = "plotInterventionAppliedId";

            JSON_OBJECT = plotAOFragment.getAllAnswersInJSONObject();

            Log.d(TAG, "JSON OBJECT = " + JSON_OBJECT.toString());


            List<Question> plotInfoQues = databaseHelper.getSpecificSetOfQuestions(Constants.PLOT_INFORMATION);
            for (Question q : plotInfoQues) {
                if (q.getTranslation__c().equalsIgnoreCase("soil ph")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR Soil PH NEEDED!!!!" + q.getId());

                    try {
                        JSON_OBJECT.put(q.getId(), phEdittext.getText().toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (q.getTranslation__c().equalsIgnoreCase("estimated production size")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR  ESTIMATED PROD!!!!" + q.getId());

                    try {
                        JSON_OBJECT.put(q.getId(), estimatedProductionEdittext.getText().toString().trim());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (q.getTranslation__c().equalsIgnoreCase("plot size")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR PLOT SIZE!!!!" + q.getId());

                    try {
                        JSON_OBJECT.put(q.getId(), plotSizeEdittext.getText().toString().trim());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (q.getTranslation__c().equalsIgnoreCase("how was this plot renovated?")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR PLOT RENOVATED INTERVENTION!!!!" + q.getId());
                    plotInterventionAppliedId = q.getId();

                    /*try {
                        JSON_OBJECT.put(q.getId(), "");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                } else if (q.getTranslation__c().equalsIgnoreCase("How long ago was the renovation made?")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR PLOT RENOVATED YEARS!!!!" + q.getId());
                    plotRenovationMadeId = q.getId();
                   /* try {
                        JSON_OBJECT.put(q.getId(), "");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                } else if (q.getTranslation__c().equalsIgnoreCase("Was this plot recently renovated?")) {

                    Log.d(TAG, "************************** FOUND THE QUESTION ID FOR PLOT RENOVATED QUESTION!!!!" + q.getId());
                    plotRenovatedId = q.getId();
                   /* try {
                        JSON_OBJECT.put(q.getId(), "");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                }


            }

            String newPlotInfoJsonValue = "";

            PLOT_INFO_JSON = new JSONObject();
            try {

                PLOT_INFO_JSON.put("name", plotName.getText().toString());
                PLOT_INFO_JSON.put("size", plotSizeEdittext.getText().toString() + " " +  plotSizeUnit.getText().toString());
                PLOT_INFO_JSON.put("estimatedProduction", estimatedProductionEdittext.getText().toString() +
                        " " + estimatedProductionUnit.getText().toString());
                PLOT_INFO_JSON.put("ph", phEdittext.getText().toString());
                PLOT_INFO_JSON.put("plotRenovated", JSON_OBJECT.get(plotRenovatedId));
                PLOT_INFO_JSON.put("plotRenovatedIntervention", JSON_OBJECT.get(plotInterventionAppliedId));
                PLOT_INFO_JSON.put("plotRenovationMade", JSON_OBJECT.get(plotRenovationMadeId));
                newPlotInfoJsonValue = PLOT_INFO_JSON.toString();


            } catch (JSONException e) {
                e.printStackTrace();
                newPlotInfoJsonValue = PLOT_INFO_JSON.toString();
            }


            String jsonValue = JSON_OBJECT.toString();

            Log.d(TAG, "PLOT INFO VALUE IS + \n" + newPlotInfoJsonValue + "\n");
            Log.d(TAG, "PLOT AO VALUE IS + \n" + jsonValue + "\n");


            String AORJson = applyLogicAndGetValue(databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATION_RESULTS));
            String AIJson = applyLogicAndGetValue(databaseHelper.getSpecificSetOfQuestions(Constants.ADDITIONAL_INTERVENTION));


            // Todo Here, calculate for the AOS and AI adding logic to it


            Log.d(TAG, "ADOPTION OBSERVATION RESULTS VALUE IS + \n" + AORJson + "\n");
            Log.d(TAG, "ADDITIONAL INTERVENTION VALUE IS + \n" + AIJson + "\n");


            if (!isEditMode) {


                RealPlot realPlot = new RealPlot();
                realPlot.setId(databaseHelper.getSystemTime());
                realPlot.setName(plotName.getText().toString());
                realPlot.setFarmerCode(farmerCode);
                realPlot.setPlotInformationJson(newPlotInfoJsonValue);
                realPlot.setAdoptionObservationsJson(jsonValue);
                realPlot.setAdoptionObservationResultsJson(AORJson);
                realPlot.setAdditionalInterventionJson(AIJson);


                if (databaseHelper.addNewPlot(realPlot)) {
                    newDataSaved = true;
                    plot = realPlot;


                    checkIfFarmProductionCorresponds(farmerCode);

                    checkIfPlotWasRenovatedRecently(plot);
                    CustomToast.makeToast(AddNewPlotActivity.this, getResources(R.string.new_plot_added), Toast.LENGTH_SHORT).show();

                    if (shouldMoveToNextActivity) {

                        Intent intent = new Intent(AddNewPlotActivity.this, PlotDetailsActivity.class);
                        intent.putExtra("plot", new Gson().toJson(realPlot));
                        intent.putExtra("farmerCode", farmerCode);

                        startActivity(intent);
                        finish();

                    }

                } else
                    CustomToast.makeToast(AddNewPlotActivity.this, getResources(R.string.could_not_add_plot), Toast.LENGTH_SHORT).show();


            } else {  //Todo save details finish this activity and go back to farmer details activity


                plot.setName(plotName.getText().toString());
                plot.setPlotInformationJson(newPlotInfoJsonValue);
                plot.setAdoptionObservationsJson(jsonValue);
                plot.setAdoptionObservationResultsJson(AORJson);
                plot.setAdditionalInterventionJson(AIJson);


                if (databaseHelper.editFarmerPlotInfoAndAO(plot)) {
                    newDataSaved = true;

                    checkIfPlotWasRenovatedRecently(plot);
                    CustomToast.makeToast(AddNewPlotActivity.this, getResources(R.string.new_data_updated), Toast.LENGTH_SHORT).show();

                    checkIfFarmProductionCorresponds(farmerCode);

                    if (shouldMoveToNextActivity) {
                        Intent intent = new Intent(AddNewPlotActivity.this, PlotDetailsActivity.class);
                        intent.putExtra("plot", new Gson().toJson(plot));

                        startActivity(intent);
                        finish();

                    }

                } else
                    CustomToast.makeToast(AddNewPlotActivity.this, getResources(R.string.could_not_add_plot), Toast.LENGTH_SHORT).show();
            }

            save.setEnabled(true);


        } else {

            prefs.edit().putBoolean("shouldReapplyRecommendation", false).apply();


            Intent intent = new Intent(AddNewPlotActivity.this, PlotDetailsActivity.class);
            intent.putExtra("plot", new Gson().toJson(plot));

            startActivity(intent);
            finish();


        }


    }


    String applyLogicAndGetValue(List<Question> questions) {

        String resultQuestionId = "", logicId = "";
        Boolean result = false;


        JSONObject jsonObject = new JSONObject();
        try {


            for (Question question : questions) {
                Log.i(TAG, "***************************************************************\n\n");
                Log.i(question.getId(), question.getCaption__c());

                List<Logic> logics = databaseHelper.doesQuestionHaveLogics(question.getId());

                if (logics.size() > 0) {

                    Log.i(TAG, "HAS LOGIC with size  " + logics.size() + "\n");

                    Log.i(TAG, "\n");

                    for (Logic logic : logics) {
                        Log.i(TAG, "Logic Name : " + logic.getName());


                        resultQuestionId = logic.getResultQuestions();
                        logicId = logic.getId();


                        result = getLogicValue(logic);


                        if (result != null) {


                            if (result) {
                                jsonObject.put(resultQuestionId, logic.getResult());

                                Log.i(TAG, "LOGIC EVALUATED TO TRUE \n");

                                Log.i(TAG, "BREAK OUT OF LOGIC LOOP");

                                databaseHelper.editLogicEvaluatedValue(logicId, result.toString());

                                break;


                            }


                        } else Log.i(TAG, "CHILD LOGIC EVALUATED TO NULL \n");
                    }


                    if (result != null && !result) {
                        if (question.getTranslation__c().equalsIgnoreCase("lime need")) {
                            jsonObject.put(resultQuestionId, "No");
                            Log.i(TAG, "ALL LOGIC FOR " + question.getName() + " EVALUATED TO FALSE DEFAULT VALUE IS G\n\n");
                            // Log.i(TAG, "\nJSON VALUE IS " +  jsonObject.toString() +  "\n" );
                            databaseHelper.editLogicEvaluatedValue(logicId, result.toString());

                        } else {
                            jsonObject.put(resultQuestionId, "G");
                            Log.i(TAG, "ALL LOGIC FOR " + question.getName() + " EVALUATED TO FALSE DEFAULT VALUE IS G\n\n");
                            // Log.i(TAG, "\nJSON VALUE IS " +  jsonObject.toString() +  "\n" );
                            databaseHelper.editLogicEvaluatedValue(logicId, result.toString());


                        }

                    }


                    Log.i(TAG, "\n");


                } else Log.i(TAG, "DOES NOT HAVE LOGIC \n\n");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jsonObject.toString();

    }

    Boolean getLogicValue(Logic logic) {


        if (logic.getQuestion10() != null && !logic.getQuestion10().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 10 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        ((((((((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5))
                                + logic.getQuestionLogicOperation5() + compareValues(l6))
                                + logic.getQuestionLogicOperation6() + compareValues(l7))
                                + logic.getQuestionLogicOperation7() + compareValues(l8))
                                + logic.getQuestionLogicOperation8() + compareValues(l9))
                                + logic.getQuestionLogicOperation9() + compareValues(l10)

                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion9() != null && !logic.getQuestion9().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 9 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        (((((((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5))
                                + logic.getQuestionLogicOperation5() + compareValues(l6))
                                + logic.getQuestionLogicOperation6() + compareValues(l7))
                                + logic.getQuestionLogicOperation7() + compareValues(l8))
                                + logic.getQuestionLogicOperation8() + compareValues(l9)


                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion8() != null && !logic.getQuestion8().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 8 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        ((((((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5))
                                + logic.getQuestionLogicOperation5() + compareValues(l6))
                                + logic.getQuestionLogicOperation6() + compareValues(l7))
                                + logic.getQuestionLogicOperation7() + compareValues(l8)

                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;

        } else if (logic.getQuestion7() != null && !logic.getQuestion7().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 7 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        (((((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5))
                                + logic.getQuestionLogicOperation5() + compareValues(l6))
                                + logic.getQuestionLogicOperation6() + compareValues(l7)
                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion6() != null && !logic.getQuestion6().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 6 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        ((((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5))
                                + logic.getQuestionLogicOperation5() + compareValues(l6)
                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion5() != null && !logic.getQuestion5().equals("null")) {

            Log.i(TAG, "*************************************** LOGIC WITH 5 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        (((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4))
                                + logic.getQuestionLogicOperation4() + compareValues(l5)
                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion4() != null && !logic.getQuestion4().equals("null")) {

            Log.i(TAG, "*************************************** LOGIC WITH 4 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        ((compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3))
                                + logic.getQuestionLogicOperation3() + compareValues(l4)
                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion3() != null && !logic.getQuestion3().equals("null")) {


            Log.i(TAG, "*************************************** LOGIC WITH 3 QUESTIONS!");


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
                value = (Boolean) engine.eval(
                        (compareValues(l1)
                                + logic.getQuestionLogicOperation1() + compareValues(l2))
                                + logic.getQuestionLogicOperation2() + compareValues(l3)
                );

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion2() != null && !logic.getQuestion2().equals("null")) {

            Log.i(TAG, "*************************************** LOGIC WITH 2 QUESTIONS!");


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
                value = (Boolean) engine.eval(compareValues(l1)
                        + logic.getQuestionLogicOperation1() + compareValues(l2));

                System.out.println("***************************** COMPARE QUESTION VALUES Object value: " + value);

            } catch (ScriptException e) {
                e.printStackTrace();

                value = null;
            }


            return value;


        } else if (logic.getQuestion1() != null && !logic.getQuestion1().equals("null")) {

            Log.i(TAG, "*************************************** LOGIC WITH 1 QUESTIONS!");

            Logic l = new Logic();
            l.setQUESTION(logic.getQuestion1());
            l.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
            l.setVALUE(logic.getValue1());

            return compareValues(l);

        } else
            return null;


    }


    Boolean compareValues(Logic logic) {

        Boolean value = null;
        String inputValue = getAnswerValue(logic.getQUESTION());
        Log.i(TAG, "EQUATION IS\n\n");


        Log.i(TAG, inputValue + "  " + logic.getLOGICAL_OPERATOR() + "  " + logic.getVALUE() + "\n\n");


        if (inputValue != null) {

            try {
                Double.parseDouble(inputValue.trim());

                value = (Boolean) engine.eval(inputValue + logic.getLOGICAL_OPERATOR() + logic.getVALUE());

                return value;

            } catch (ScriptException | NumberFormatException e) {

                System.out.println("****  EXCEPTION  ****  " + e.getMessage());

                value = inputValue.equalsIgnoreCase(logic.getVALUE());
                return value;
            } finally {
                System.out.println("*** LOGIC VALUE IS: " + value);

            }
        } else return null;

    }


    String getAnswerValue(String s) {

        String defVal;
        try {
            defVal = JSON_OBJECT.get(s).toString();

            return defVal;

        } catch (JSONException e) {
            System.out.println("\n ***** EXCEPTION ***** " + e.getMessage() + "\n");

            return null;
        }
    }


    @Override
    protected void onPause() {


        Log.i(TAG, "ON PAUSE");


        if (!newDataSaved && save.isEnabled())
            saveOrUpdateData(true);


        super.onPause();


    }


    void checkIfPlotWasRenovatedRecently(RealPlot plot) {

        try {
            Recommendation GAPS_RECOMENDATION_FOR_START_YEAR;

            if (PLOT_INFO_JSON.get("plotRenovated").toString().equalsIgnoreCase("yes")) {
                int year = 0;
                String recommendationName = PLOT_INFO_JSON.get("plotRenovatedIntervention").toString();
                try {
                    year = Integer.parseInt(PLOT_INFO_JSON.get("plotRenovationMade").toString());

                    if (!recommendationName.equalsIgnoreCase("") && !recommendationName.isEmpty() && !recommendationName.equals("null") && !recommendationName.equals("--")) {

                        if (recommendationName.equalsIgnoreCase("replanting"))
                            GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Replant");

                        else if (recommendationName.equalsIgnoreCase("grafting"))
                            GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Grafting");
                        else
                            GAPS_RECOMENDATION_FOR_START_YEAR = null;


                        if (GAPS_RECOMENDATION_FOR_START_YEAR != null) {
                            if (databaseHelper.editFarmerPlotRecommendationId(plot.getFarmerCode(), plot.getId(), GAPS_RECOMENDATION_FOR_START_YEAR.getId() + "," + GAPS_RECOMENDATION_FOR_START_YEAR.getId()))

                                databaseHelper.editPlotStartYear(plot.getId(), -year);

                            this.plot.setStartYear(-year);
                            this.plot.setRecommendationId(GAPS_RECOMENDATION_FOR_START_YEAR.getId() + "," + GAPS_RECOMENDATION_FOR_START_YEAR.getId());

                            prefs.edit().putBoolean("shouldReapplyRecommendation", false).apply();

                        } else {
                            prefs.edit().putBoolean("shouldReapplyRecommendation", true).apply();

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    prefs.edit().putBoolean("shouldReapplyRecommendation", false).apply();

                }

            } else {
                prefs.edit().putBoolean("shouldReapplyRecommendation", true).apply();


            }
        } catch (JSONException e) {
            e.printStackTrace();
            prefs.edit().putBoolean("shouldReapplyRecommendation", false).apply();

        }
    }












}
