package com.grameen.fdp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import com.grameen.fdp.R;
import com.grameen.fdp.object.Plot;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class PlotDetailsActivity extends BaseActivity {

    Plot plot;

    TextView plotName;
    TextView plotSize;
    TextView ph;
    TextView estimatedProductionSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plot);

        Toolbar toolbar = setToolbar("Plot Info");

        plotName = (TextView) findViewById(R.id.plotName);
        plotSize = (TextView) findViewById(R.id.landSize);
        ph = (TextView) findViewById(R.id.ph);
        estimatedProductionSize = (TextView) findViewById(R.id.estimatedProductionSize);


        Intent intent = getIntent();

        plot = new Gson().fromJson(getIntent().getStringExtra("plot"), Plot.class);


        if(plot != null){

            plotName.setText(plot.getName());
            plotSize.setText(plot.getArea());
            ph.setText( "PH " + plot.getPh());
            estimatedProductionSize.setText(plot.getEstimatedProductionSize());

        }




        findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Todo go to add edit plot activity, set plot parameters

                Intent intent = new Intent(PlotDetailsActivity.this, AddNewPlotActivity.class);
                intent.putExtra("flag", "edit");
                intent.putExtra("plot", new Gson().toJson(plot));

                startActivity(intent);



            }
        });







    }
}
