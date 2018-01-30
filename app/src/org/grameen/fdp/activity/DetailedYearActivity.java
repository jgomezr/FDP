package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.DetailedYearTableViewAdapter;
import org.grameen.fdp.adapter.MyTableHearderAdapter;
import org.grameen.fdp.adapter.MyTableViewAdapter;
import org.grameen.fdp.object.Data;
import org.grameen.fdp.object.DetailedYearData;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.object.RecommendationsPlusActivity;
import org.grameen.fdp.utility.Constants;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngineManager;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;

/**
 * Created by aangjnr on 27/01/2018.
 */

public class DetailedYearActivity extends BaseActivity {

    String TAG = "DETAILED ACTIVITY";
    RealFarmer farmer;
    TextView farmerName;
    TextView farmerCode;
    TableView tableView;
    DetailedYearTableViewAdapter myTableViewAdapter;


    int year;

    List<RealPlot> plotList;

    List<DetailedYearData>  TABLE_DATA_LIST = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_year);
        Toolbar toolbar = setToolbar("Year Details");

        engine = new ScriptEngineManager().getEngineByName("rhino");


        farmerName = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);


        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        year = getIntent().getIntExtra("year", -1);


        if (farmer != null) {


            farmerName.setText(farmer.getFarmerName());
            farmerCode.setText(farmer.getCode());



            tableView = findViewById(R.id.tableView);
            //tableView.setColumnCount(13);
            String[] TABLE_HEADERS = { "Year "+ year, "January", "February", "March", "April", "May", "June", "July", "August",  "September", "October", "November", "December" };
            tableView.setHeaderAdapter(new MyTableHearderAdapter(this, TABLE_HEADERS));



            plotList = databaseHelper.getAllFarmerPlots(farmer.getCode());
            for(RealPlot plot : plotList) {

                String recommendationId = plot.getRecommendationId().split(",")[1];

                List<Data> dataList = new ArrayList<>();
                dataList.add(getMonthlyData(recommendationId, "Jan"));
                dataList.add(getMonthlyData(recommendationId, "Feb"));
                dataList.add(getMonthlyData(recommendationId, "Mar"));
                dataList.add(getMonthlyData(recommendationId, "Apr"));
                dataList.add(getMonthlyData(recommendationId, "May"));
                dataList.add(getMonthlyData(recommendationId, "Jun"));
                dataList.add(getMonthlyData(recommendationId, "Jul"));
                dataList.add(getMonthlyData(recommendationId, "Aug"));
                dataList.add(getMonthlyData(recommendationId, "Sep"));
                dataList.add(getMonthlyData(recommendationId, "Oct"));
                dataList.add(getMonthlyData(recommendationId, "Nov"));
                dataList.add(getMonthlyData(recommendationId, "Dec"));


                DetailedYearData detailedYearData = new DetailedYearData();
                detailedYearData.setName(plot.getName());
                detailedYearData.setDataList(dataList);


                TABLE_DATA_LIST.add(detailedYearData);
            }




            myTableViewAdapter = new DetailedYearTableViewAdapter(DetailedYearActivity.this, TABLE_DATA_LIST, tableView);
            tableView.setDataAdapter(myTableViewAdapter);




        }
        onBackClicked();
    }




    Data getMonthlyData(String id, String month){

        Data data = new Data("", "");
        try {

            List<RecommendationsPlusActivity> recommendationsPlusActivities = databaseHelper.getRecommendationPlusAcivityByRecommendationIdMonthAndYear(id, month, year + "");

            StringBuilder activities = new StringBuilder();

            StringBuilder cost = new StringBuilder();


            for (RecommendationsPlusActivity ra : recommendationsPlusActivities) {

                String activity = databaseHelper.getActivityPlusInput(ra.getActivityId()).getName();

                if(activity == null) activity = "";

                activities.append(activity).append(", ");
                cost.append(ra.getSuppliesCost()).append("+");

                if (ra == recommendationsPlusActivities.get(recommendationsPlusActivities.size() - 1)) {

                    activities.append(ra.getActivityName());
                    cost.append(ra.getSuppliesCost()).append("0");

                }
            }


            Log.i(TAG, "Appended Activities are = " + activities.toString());
            Log.i(TAG, "Appended Supplies cost are = " + cost.toString());


            data =  new Data(activities.toString(), applyCalculation(cost.toString()));

        }catch(Exception e){e.printStackTrace();}



        return data;

    }


}
