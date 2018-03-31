package org.grameen.fdp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.DetailedYearTableHearderAdapter;
import org.grameen.fdp.adapter.FamilyMembersTableHearderAdapter;
import org.grameen.fdp.adapter.FarmAssessmentTableViewAdapter;
import org.grameen.fdp.adapter.MyTableHearderAdapter;
import org.grameen.fdp.object.Data2;
import org.grameen.fdp.object.FarmResult;
import org.grameen.fdp.object.PlotAssessment;
import org.grameen.fdp.object.RealFarmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;

/**
 * Created by aangjnr on 15/02/2018.
 */

public class FarmAssessmentActivity extends BaseActivity {

    FarmResult farmResult;
    RealFarmer farmer;
    TextView farmerName;
    TextView farmerCode;

    TableView tableView;
    Button save;
    Button submit;
    String TAG = FarmAssessmentActivity.class.getSimpleName();

    TextView farmStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_assessment);
        farmStatus = findViewById(R.id.farm_status);

        farmerName = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        if (farmer != null) {
            farmerName.setText(farmer.getFarmerName());
            farmerCode.setText(farmer.getCode());
        }


        farmResult = new Gson().fromJson(getIntent().getStringExtra("farmResults"), FarmResult.class);
        if(farmResult != null){

            farmStatus.setText(farmResult.getStatus());

            tableView = findViewById(R.id.tableView);
            tableView.setColumnCount(2);
            String[] TABLE_HEADERS = {"PLOT NAME", "ASSESSMENT"};
            TableColumnWeightModel columnModel = new TableColumnWeightModel(tableView.getColumnCount());
            columnModel.setColumnWeight(0, 1);
            columnModel.setColumnWeight(1, 1);
            tableView.setColumnModel(columnModel);
            DetailedYearTableHearderAdapter tableHearderAdapter = new DetailedYearTableHearderAdapter(this, TABLE_HEADERS);
            tableView.setHeaderAdapter(tableHearderAdapter);


            List<Data2> dataList = new ArrayList<>();


            Log.i(TAG, "PLOT ASSESSMENT RESULTS " + farmResult.getPlotAssessmentList().size());

            for(PlotAssessment plotAssessment : farmResult.getPlotAssessmentList()){

                dataList.add(new Data2(plotAssessment.getPlotName(), plotAssessment.getResults()));

            }


            tableView.setDataAdapter(new FarmAssessmentTableViewAdapter(FarmAssessmentActivity.this, dataList, tableView));










        }



        onBackClicked();
    }



 }