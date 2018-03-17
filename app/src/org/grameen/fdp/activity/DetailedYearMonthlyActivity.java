package org.grameen.fdp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.DetailedYearTableHearderAdapter;
import org.grameen.fdp.adapter.DetailedYearTableViewAdapter;
import org.grameen.fdp.object.Data;
import org.grameen.fdp.object.Data2;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.RecommendationsPlusActivity;
import org.grameen.fdp.utility.CustomToast;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngineManager;

import de.codecrafters.tableview.TableView;

import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_TITLE_TEXT_VIEW;

/**
 * Created by aangjnr on 27/01/2018.
 */

public class DetailedYearMonthlyActivity extends BaseActivity {

    String TAG = "DETAILED ACTIVITY";
    RealFarmer farmer;
    TextView farmerName;
    TextView farmerCode;
    TableView tableView;
    DetailedYearTableViewAdapter myTableViewAdapter;
    TextView currency;
    Boolean DID_LABOUR = false;
    String LABOUR_TYPE;


    int year;

    List<RealPlot> plotList;

    List<Data> TABLE_DATA_LIST = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_year);

        engine = new ScriptEngineManager().getEngineByName("rhino");
        currency = findViewById(R.id.currency);
        currency.setText(prefs.getString("currency", ""));


        farmerName = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);


        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        year = getIntent().getIntExtra("year", -1);

        DID_LABOUR = getIntent().getBooleanExtra("labour", false);
        LABOUR_TYPE = getIntent().getStringExtra("labourType");

        Toolbar toolbar = setToolbar(getResources(R.string.year) + year);

        Log.i(TAG, "^^^^^^^^ LABOUR? " + DID_LABOUR + " TYPE = " + LABOUR_TYPE);


        if (farmer != null) {


            farmerName.setText(farmer.getFarmerName());
            farmerCode.setText(farmer.getCode());


            tableView = findViewById(R.id.tableView);



            tableView.setColumnCount(12);


            String[] TABLE_HEADERS = {getResources(R.string.jan), getResources(R.string.feb), getResources(R.string.mar), getResources(R.string.apr), getResources(R.string.may), getResources(R.string.jun), getResources(R.string.jul),getResources(R.string.aug), getResources(R.string.sep), getResources(R.string.oct), getResources(R.string.nov), getResources(R.string.dec)};
            tableView.setHeaderAdapter(new DetailedYearTableHearderAdapter(DetailedYearMonthlyActivity.this, TABLE_HEADERS));


            plotList = databaseHelper.getAllFarmerPlots(farmer.getCode());
            for (RealPlot plot : plotList) {

                String recommendationId = plot.getRecommendationId().split(",")[1];

                List<Data2> dataList = new ArrayList<>();


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


                List<String> activities = new ArrayList<>();
                List<String> labourCost = new ArrayList<>();
                List<String> suppliesCost = new ArrayList<>();

                for(Data2 data : dataList){

                    activities.add(data.getLabel());
                    suppliesCost.add(data.getV1());

                    if(DID_LABOUR)
                    labourCost.add(data.getV2());


                }


                TABLE_DATA_LIST.add(new Data(plot.getName(), null, TAG_TITLE_TEXT_VIEW));
               // TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


                TABLE_DATA_LIST.add(new Data(getResources(R.string.activities), activities, TAG_OTHER_TEXT_VIEW));
                TABLE_DATA_LIST.add(new Data(getResources(R.string.supplies), suppliesCost, TAG_OTHER_TEXT_VIEW));

                if(DID_LABOUR)
                    TABLE_DATA_LIST.add(new Data(getResources(R.string.labour), labourCost, TAG_OTHER_TEXT_VIEW));



            }

            myTableViewAdapter = new DetailedYearTableViewAdapter(DetailedYearMonthlyActivity.this, TABLE_DATA_LIST, tableView);
            tableView.setDataAdapter(myTableViewAdapter);


        }
        onBackClicked();
    }


    Data2 getMonthlyData(String id, String month) {

        List<RecommendationsPlusActivity> recommendationsPlusActivities = new ArrayList<>();
        Data2 data = new Data2("", "", "");
        try {

            if(DID_LABOUR)
                if(LABOUR_TYPE.equalsIgnoreCase("seasonal"))
                    recommendationsPlusActivities = databaseHelper.getSeasonalRecommendationPlusAcivityByRecommendationIdMonthAndYear(id, month, year + "", "true");
                else
                    recommendationsPlusActivities = databaseHelper.getRecommendationPlusAcivityByRecommendationIdMonthAndYear(id, month, year + "");

                else
                recommendationsPlusActivities = databaseHelper.getRecommendationPlusAcivityByRecommendationIdMonthAndYear(id, month, year + "");




            StringBuilder activities = new StringBuilder() ;
            StringBuilder labourCost = new StringBuilder() ;
            StringBuilder suppliesCost = new StringBuilder();


            for (RecommendationsPlusActivity ra : recommendationsPlusActivities) {

                try {
                        if(ra.getActivityName() != null && !ra.getActivityName().equals("null"))
                            if (!activities.toString().toLowerCase().contains(ra.getActivityName().toLowerCase()))

                                activities.append(toCamelCase(ra.getActivityName())).append(", ");

                        suppliesCost.append(ra.getSuppliesCost()).append("+");

                        labourCost.append(ra.getLaborCost()).append("+");




                } catch (Exception ignored) {
                    ignored.printStackTrace();


                }


            }



            suppliesCost.append("0.0");
            labourCost.append("0.0");


            Log.i(TAG, "Appended Activities are = " + activities.toString());
            Log.i(TAG, "Appended Supplies cost are = " + suppliesCost.toString());
            Log.i(TAG, "Appended labor cost are = " + labourCost.toString());


            data = new Data2(activities.toString(), applyCalculation(suppliesCost.toString()), applyCalculation(labourCost.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }


        return data;

    }


}
