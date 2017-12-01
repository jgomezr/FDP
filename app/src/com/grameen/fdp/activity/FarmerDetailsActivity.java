package com.grameen.fdp.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import com.grameen.fdp.R;
import com.grameen.fdp.adapter.PlotsListAdapter;
import com.grameen.fdp.object.Farmer;
import com.grameen.fdp.utility.Constants;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class FarmerDetailsActivity extends BaseActivity {

    Farmer farmer;
    TextView name;
    TextView code;
    CircleImageView circleImageView;
    TextView initials;
    TextView villageName;
    TextView landArea;
    TextView lastVisitDate;
    TextView addPlot;
    View syncIndicator;


    RecyclerView plotsRecyclerView;
    private ImageView editFarmerDetails;
    private TextView noOfPlots;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);
        Toolbar toolbar = setToolbar("Farmer Details");

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), Farmer.class);

        if(farmer != null){

            initializeViews();



            editFarmerDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Todo go to Edit farmer details activity

                    Intent intent = new Intent(FarmerDetailsActivity.this, EditFarmerDetailsActivity.class);
                    intent.putExtra("farmer", new Gson().toJson(farmer));
                    intent.putExtra("flag", "edit");

                    startActivity(intent);

                }
            });



            addPlot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Todo go to add plot activity
                    startActivity(new Intent(FarmerDetailsActivity.this, AddNewPlotActivity.class));


                }
            });




        }else{

            Toast.makeText(this, "There was an error attempting to retrieve farmer info", Toast.LENGTH_SHORT).show();
        }
    }


    void initializeViews(){

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


        name.setText(farmer.getName());
        code.setText(farmer.getCode());
        villageName.setText(farmer.getVillageName());
        landArea.setText(farmer.getFarmArea());
        lastVisitDate.setText(farmer.getLastVisitDate());

        syncIndicator.setVisibility((farmer.getSyncStatus() == Constants.SYNC_OK) ? View.VISIBLE : View.GONE);

        int plotsSize = farmer.getPlotsList().size();
         noOfPlots.setText((plotsSize > 1) ? "Plots " + "(" + plotsSize + ")" : "Plot " + "(" + plotsSize + ")");







        if(farmer.getImageUrl() != null && !farmer.getId().equals("")){
            Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

        }else{
            String[] valueArray = farmer.getName().split(" ");
            String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
            initials.setText(value);

            int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(randomColor);
            circleImageView.setBackground(drawable);
        }


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        plotsRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        SpacesGridItemDecoration decoration = new SpacesGridItemDecoration(8);
        plotsRecyclerView.addItemDecoration(decoration);


        PlotsListAdapter plotsListAdapter = new PlotsListAdapter(this, farmer.getPlotsList());

        plotsRecyclerView.setAdapter(plotsListAdapter);

        plotsListAdapter.setOnItemClickListener(new PlotsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //Todo go to plot details



                Intent intent = new Intent(FarmerDetailsActivity.this, PlotDetailsActivity.class);
                intent.putExtra("plot", new Gson().toJson(farmer.getPlotsList().get(position)));
                startActivity(intent);






            }
        });







    }

}
