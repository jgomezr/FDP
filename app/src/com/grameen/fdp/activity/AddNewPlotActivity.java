package com.grameen.fdp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.grameen.fdp.R;
import com.grameen.fdp.object.Plot;
import com.jaredrummler.materialspinner.MaterialSpinner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class AddNewPlotActivity extends BaseActivity {

    boolean isEditMode = false;
    Plot plot;


    EditText plotName;
    MaterialSpinner plotSizeSpinner;
    MaterialSpinner plotSizeUnitSpinner;
    MaterialSpinner estimatedProductionSpinner;
    MaterialSpinner estimatedProductionUnitSpinner;
    MaterialSpinner phSpinner;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_a_plot);


        plotName = (EditText) findViewById(R.id.plotNameEdittext);
        plotSizeSpinner = (MaterialSpinner) findViewById(R.id.plotSizeSpinner);
        plotSizeUnitSpinner = (MaterialSpinner) findViewById(R.id.plotSizeUnitSpinner);
        plotSizeUnitSpinner.setItems("Ha", "acres");
        estimatedProductionSpinner = (MaterialSpinner) findViewById(R.id.productionSizeSpinner);
        estimatedProductionUnitSpinner = (MaterialSpinner) findViewById(R.id.productionSizeUnitSpinner);
        estimatedProductionUnitSpinner.setItems("kg", "qq", "bags");
        phSpinner = (MaterialSpinner) findViewById(R.id.phSpinner);

        List<String> values = new ArrayList<>();

        for (int i = 0; i <= 20; ++i) {

            values.add(i + "");

        }


        plotSizeSpinner.setItems(values);








        Intent intent = getIntent();


        if(intent.getStringExtra("flag") != null && intent.getStringExtra("flag").equals("edit")){
            isEditMode = true;

            plot = new Gson().fromJson(getIntent().getStringExtra("plot"), Plot.class);
            plotSizeSpinner.setText(plot.getArea());
            plotName.setText(plot.getName());
            phSpinner.setText(plot.getPh());
            estimatedProductionSpinner.setText(plot.getEstimatedProductionSize());

        }

        Toolbar toolbar;
        if(isEditMode)
         toolbar = setToolbar("Edit plot details");
        else setToolbar("Add plot details");


        findViewById(R.id.plotMapping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Todo go to Map Activity
                Intent intent = new Intent(AddNewPlotActivity.this, MapActivity.class);
                intent.putExtra("plot", new Gson().toJson(plot));
                startActivity(intent);




            }
        });




    }
}
