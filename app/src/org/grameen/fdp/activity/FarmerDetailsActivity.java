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

import org.grameen.fdp.adapter.FarmerListAdapter;
import org.grameen.fdp.object.Form;
import org.grameen.fdp.object.Plot;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.PlotsListAdapter;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    List<RealPlot> plots  = new ArrayList<>();
    String message = "";

    String TAG = "FarmerDetailsActivity";


    RecyclerView plotsRecyclerView;
    private ImageView editFarmerDetails;
    private TextView noOfPlots;
    boolean monitoringMode = false;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);
        Toolbar toolbar = setToolbar("Farmer Details");


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
        if(prefs.getString("flag", "").equals(Constants.MONITORING)){

            //Todo add the rest of the views to hide
            monitoringMode = true;

            findViewById(R.id.edit).setVisibility(View.GONE);
            findViewById(R.id.addPlot).setVisibility(View.GONE);





        }

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);

        if(farmer != null){

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




        }else{

            Toast.makeText(this, "There was an error attempting to retrieve farmer info", Toast.LENGTH_SHORT).show();
        }



        onBackClicked();
    }


    void initializeViews(Boolean loadButtons){

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


        if(farmer.getImageUrl() != null && !farmer.getImageUrl().equals("")){
            Log.d(TAG, "IMAGE URL    " + farmer.getImageUrl() + "");



            Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

        }else{

            try {
                String[] valueArray = farmer.getFarmerName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                initials.setText(value);

            }catch(Exception e){

                initials.setText(farmer.getFarmerName().substring(0, 1));


            }

            int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(randomColor);
            circleImageView.setBackground(drawable);
        }





        if(loadButtons) {
            LinearLayout dynamicButtonsLayout = (LinearLayout) findViewById(R.id.dynamicButtons);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);


            for (Form f : databaseHelper.getAllForms()) {

                final Button btn = (Button) getLayoutInflater().inflate(R.layout.dynamic_button, null);
                //btn.setId(f.getId());

                btn.setText(f.getName());
                dynamicButtonsLayout.addView(btn, params);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Log.d(TAG, "BUTTON CLICKED WAS " + btn.getText().toString().toLowerCase());

                        Intent intent = new Intent(FarmerDetailsActivity.this, Add_EditFarmerDetailsActivity.class);
                        intent.putExtra("farmer", new Gson().toJson(farmer));
                        intent.putExtra("flag", "edit");

                        intent.putExtra("formType", btn.getText().toString().toLowerCase());
                        startActivity(intent);
                        //finish();

                    }
                });

            }

        }



        findViewById(R.id.pandl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean shouldGoNext = true;

                StringBuilder msg = new StringBuilder();


                if(plots != null && plots.size() > 0) {

                    for (RealPlot plot : plots) {

                        if (plot.getRecommendationId() == null || plot.getRecommendationId().equals("") || plot.getRecommendationId().equals("null") || plot.getRecommendationId().equals("empty")) {

                            msg.append(plot.getName());

                            if (plots.size() > 1) {

                                if (plot != plots.get(plots.size() - 1 ) && plot != plots.get(plots.size() - 2 ))
                                    msg.append(", ");

                                if (plot == plots.get(plots.size() - 2))
                                    msg.append(" and ");
                            }
                            shouldGoNext = false;
                        }

                    }


                    if (shouldGoNext) {

                        Intent intent = new Intent(FarmerDetailsActivity.this, PandLActivity.class);
                        intent.putExtra("farmer", new Gson().toJson(farmer));
                        startActivity(intent);

                    } else {
                        message = "Please enter all Adoption Observation and Plot Info values for " + msg.toString();

                        showAlertDialog(true, "Missing data", message, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        }, "OK", null, "", 0);

                    }
                }else{

                    showAlertDialog(true, "No Plots Added!", "Please add a plot to access P & L", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    }, "OK", null, "", 0);




                }



            }
        });



    }


    void setUpPlotsAdapter(){

        if(plots == null)
         plots =  databaseHelper.getAllFarmerPlots(farmer.getCode());

        if(plots!= null) {
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


                        Intent intent = new Intent(FarmerDetailsActivity.this, PlotDetailsActivity.class);
                        intent.putExtra("plot", new Gson().toJson(plots.get(position)));
                        startActivity(intent);

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


        }else noOfPlots.setText("Plot Adoption Observations");


    }


    @Override
    protected void onResume() {
       // setUpPlotsAdapter();

        plots =  databaseHelper.getAllFarmerPlots(farmer.getCode());

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


    @Override
    protected void onStop() {

        super.onStop();
    }
}
