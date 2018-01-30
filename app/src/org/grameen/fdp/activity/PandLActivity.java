package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.MyTableHearderAdapter;
import org.grameen.fdp.adapter.MyTableViewAdapter;
import org.grameen.fdp.object.Calculation;
import org.grameen.fdp.object.Data;
import org.grameen.fdp.object.Form;
import org.grameen.fdp.object.LaborDaysLaborCostSupplies;
import org.grameen.fdp.object.Logic;
import org.grameen.fdp.object.MyTableData;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.utility.Constants;
import org.json.JSONException;
import org.json.JSONObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableHeaderClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.TableHeaderCollapseOnScrollListener;

import static org.grameen.fdp.utility.Constants.ADDITIONAL_INTERVENTION;
import static org.grameen.fdp.utility.Constants.ADOPTION_OBSERVATIONS;
import static org.grameen.fdp.utility.Constants.ADOPTION_OBSERVATION_RESULTS;
import static org.grameen.fdp.utility.Constants.AGGREGATE_ECONOMIC_RESULTS;
import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_RESULTS;
import static org.grameen.fdp.utility.Constants.TAG_TITLE_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_VIEW;

/**
 * Created by aangjnr on 20/12/2017.
 */

public class PandLActivity extends BaseActivity {


    String TAG = "P & L ACTIVITY";
    RealFarmer farmer;
    TextView farmerName;
    TextView farmerCode;
    TextInputLayout commentsTextInput;
    MaterialSpinner farmerAgreeSpinner;

    String farmerAgree = "No";
    TableView tableView;
    Button save;
    Button submit;

    JSONObject VALUES_JSON_OBJECT = new JSONObject();


    ProgressDialog progressDialog;
    List<String> calculationsList;



    List<RealPlot> realPlotList;
    List<Data>   TABLE_DATA_LIST = new ArrayList<>();

    List<String> TOTAL_LABOR_COST = new ArrayList<>();

    List<String> TOTAL_LABOR_DAYS = new ArrayList<>();

    List<String> TOTAL_MAINTENANCE_COST = new ArrayList<>();


    List<String> TOTAL_NET_INCOME_FROM_COCOA = new ArrayList<>();
    List<String> TOTAL_NET_INCOME_FROM_OTHER_CROPS = new ArrayList<>();
    List<String> TOTAL_FARMING_INCOME = new ArrayList<>();
    List<String> TOTAL_NET_INCOME_FROM_OTHER_SOURCES = new ArrayList<>();
    List<String> TOTAL_INCOME = new ArrayList<>();



    List<String> TOTAL_INVESTMENT_IN_FDP = new ArrayList<>();
    List<String> TOTAL_P_AND_L_LIST = new ArrayList<>();


    StringBuilder NET_INCOME_FROM_COCOA_YEAR_0 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_1 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_2 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_3 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_4 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_5 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_6 = new StringBuilder();
    StringBuilder NET_INCOME_FROM_COCOA_YEAR_7 = new StringBuilder();


    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_0 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_1 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_2 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_3 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_4 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_5 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_6 = new StringBuilder();
    StringBuilder TOTAL_MAINTENANCE_COST_YEAR_7 = new StringBuilder();

    StringBuilder TOTAL_LABOR_DAYS_YEAR_0 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_1 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_2 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_3 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_4 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_5 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_6 = new StringBuilder();
    StringBuilder TOTAL_LABOR_DAYS_YEAR_7 = new StringBuilder();


    StringBuilder TOTAL_LABOR_COST_YEAR_0 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_1 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_2 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_3 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_4 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_5 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_6 = new StringBuilder();
    StringBuilder TOTAL_LABOR_COST_YEAR_7 = new StringBuilder();


    MyTableViewAdapter myTableViewAdapter;
    private JSONObject PLOT_AO_JSON_OBJECT = new JSONObject();
    private JSONObject PLOT_INFO_JSON_OBJECT = new JSONObject();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_and_l);
        engine = new ScriptEngineManager().getEngineByName("rhino");
        save = findViewById(R.id.save);
        submit = findViewById(R.id.submitAgreement);
        submit.setEnabled(false);

        commentsTextInput = findViewById(R.id.commentsTextInputLayout);
        farmerName = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);
        farmerAgreeSpinner = findViewById(R.id.farmerAgreeSpinner);
        farmerAgreeSpinner.setItems("No", "Yes");


        farmerAgreeSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                farmerAgree = item.toString();
                if(farmerAgree.equalsIgnoreCase("yes")) submit.setEnabled(true);
                else submit.setEnabled(false);


            }
        });

        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if(prefs.getString("flag", "").equals(Constants.MONITORING)){

            //Todo add the rest of the views to hide

            findViewById(R.id.save).setVisibility(View.GONE);
            findViewById(R.id.submitAgreement).setVisibility(View.GONE);
            findViewById(R.id.agreeLayout).setVisibility(View.GONE);

            commentsTextInput.setEnabled(false);

        }

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);

        if(farmer != null) {


                    farmerName.setText(farmer.getFarmerName());
                    farmerCode.setText(farmer.getCode());


            getAllFarmerDataValues();
        }

        tableView = findViewById(R.id.tableView);
        tableView.setColumnCount(9);
        String[] TABLE_HEADERS = { "", "Year 0", "Year 1", "Year 2", "Year 3", "Year 4", "Year 5", "Year 6", "Year 7" };
        MyTableHearderAdapter tableHearderAdapter = new MyTableHearderAdapter(this, TABLE_HEADERS);
        tableView.setHeaderAdapter(tableHearderAdapter);

        tableHearderAdapter.setHeaderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = Integer.parseInt(view.getTag().toString());
                Log.i("P & L ACTIVITY", position + "");

                Intent intent = new Intent(PandLActivity.this, DetailedYearActivity.class);
                intent.putExtra("year",  position - 1);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);

            }
        });





        tableView.setSaveEnabled( true );



        progressDialog = showProgress(this, "Populating data", "Please wait a moment", false);



        showAlertDialog(false, "Hire Labour", "Did the farmer hire labour?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        prefs.edit().putBoolean("labour", true).apply();
                        dialogInterface.dismiss();


                        showAlertDialog(false, "Labour Type", "Which type of labour did the farmer hire?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                prefs.edit().putString("labourType", "Full").apply();
                                dialogInterface.dismiss();


                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        populateTableData();

                                    }
                                });

                                thread.start();

                            }
                        }, "Full", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                prefs.edit().putString("labourType", "Seasonal").apply();
                                dialogInterface.dismiss();


                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        populateTableData();

                                    }
                                });

                                thread.start();




                            }
                        }, "Seasonal", 0);




                    }
                }, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        prefs.edit().putBoolean("labour", false).apply();
                        dialogInterface.dismiss();

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                populateTableData();

                            }
                        });

                        thread.start();



                    }
                }, "No", 0);




        onBackClicked();

    }








    void populateTableData(){

        TABLE_DATA_LIST = new ArrayList<>();
        TOTAL_LABOR_COST = new ArrayList<>();
        TOTAL_LABOR_DAYS = new ArrayList<>();
        TOTAL_MAINTENANCE_COST = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_COCOA = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_OTHER_CROPS = new ArrayList<>();
        TOTAL_FARMING_INCOME = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_OTHER_SOURCES = new ArrayList<>();
        TOTAL_INCOME = new ArrayList<>();
        TOTAL_INVESTMENT_IN_FDP = new ArrayList<>();
        TOTAL_P_AND_L_LIST = new ArrayList<>();



        NET_INCOME_FROM_COCOA_YEAR_0 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_1 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_2 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_3 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_4 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_5 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_6 = new StringBuilder();
        NET_INCOME_FROM_COCOA_YEAR_7 = new StringBuilder();


        TOTAL_MAINTENANCE_COST_YEAR_0 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_1 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_2 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_3 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_4 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_5 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_6 = new StringBuilder();
        TOTAL_MAINTENANCE_COST_YEAR_7 = new StringBuilder();


        TOTAL_LABOR_DAYS_YEAR_0 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_1 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_2 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_3 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_4 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_5 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_6 = new StringBuilder();
        TOTAL_LABOR_DAYS_YEAR_7 = new StringBuilder();


        TOTAL_LABOR_COST_YEAR_0 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_1 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_2 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_3 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_4 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_5 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_6 = new StringBuilder();
        TOTAL_LABOR_COST_YEAR_7 = new StringBuilder();


        if(farmer != null) {
            realPlotList = databaseHelper.getAllFarmerPlots(farmer.getCode());



            for (RealPlot PLOT : realPlotList) {

                Log.d("P & L ACTIVITY", "START YEAR IS " +  PLOT.getStartYear());


                try{
                    PLOT_AO_JSON_OBJECT = new JSONObject(PLOT.getAdoptionObservationsJson());
                    PLOT_INFO_JSON_OBJECT = new JSONObject(PLOT.getPlotInformationJson());
                }catch(Exception e){e.printStackTrace();

                PLOT_INFO_JSON_OBJECT = new JSONObject();
                }


                    switch(PLOT.getStartYear()){

                        case -5:
                            loadDataForStartYearMinus5(PLOT);

                            break;

                        case -4:
                            loadDataForStartYearMinus4(PLOT);

                            break;

                        case -3:
                            loadDataForStartYearMinus3(PLOT);
                            break;

                        case -2:
                            loadDataForStartYearMinus2(PLOT);
                            break;


                        case -1:
                            loadDataForStartYearMinus1(PLOT);

                            break;


                        case 1:
                            loadDataForStartYear1(PLOT);
                            break;


                        case 2:
                            loadDataForStartYear2(PLOT);

                            break;


                        case 3:
                            loadDataForStartYear3(PLOT);

                            break;


                        case 4:

                            loadDataForStartYear4(PLOT);

                            break;


                        case 5:

                            loadDataForStartYear5(PLOT);

                            break;

                        default:
                            loadDataForStartYear1(PLOT);







                    }



            }// For Loop ends


            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_0.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_1.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_2.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_3.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_4.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_5.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_6.toString() + "0"));
            TOTAL_MAINTENANCE_COST.add(applyCalculation(TOTAL_MAINTENANCE_COST_YEAR_7.toString() + "0"));

            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_0.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_1.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_2.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_3.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_4.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_5.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_6.toString() + "0"));
            TOTAL_LABOR_DAYS.add(applyCalculation(TOTAL_LABOR_DAYS_YEAR_7.toString() + "0"));


            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_0.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_1.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_2.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_3.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_4.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_5.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_6.toString() + "0"));
            TOTAL_LABOR_COST.add(applyCalculation(TOTAL_LABOR_COST_YEAR_7.toString() + "0"));


            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_0.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_1.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_2.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_3.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_4.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_5.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_6.toString() + "0.0"));
            TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_INCOME_FROM_COCOA_YEAR_7.toString() + "0.0"));


            if (prefs.getBoolean("labour", false)) {


                //TABLE_DATA_LIST.add(new Data("Total Costs" + prefs.getString("labourType", ""), null, TAG_TITLE_TEXT_VIEW));

                TABLE_DATA_LIST.add(new Data("Total Maintenance Cost", TOTAL_MAINTENANCE_COST, TAG_RESULTS));

                TABLE_DATA_LIST.add(new Data("Total Labour Days", TOTAL_LABOR_DAYS, TAG_RESULTS));
                TABLE_DATA_LIST.add(new Data("Total Labour Cost", TOTAL_LABOR_COST, TAG_RESULTS));

            }

            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


            TABLE_DATA_LIST.add(new Data("Net Income From Cocoa", TOTAL_NET_INCOME_FROM_COCOA, TAG_RESULTS));


            for (Calculation calc : databaseHelper.sortCalculations(databaseHelper.getAllCalculations())) {

                Question q = databaseHelper.getQuestion(calc.getResultQuestion());
                if (q.getForm__r().getName().equalsIgnoreCase(AGGREGATE_ECONOMIC_RESULTS)) {

                    String value = applyCalculationToCalculationObject(calc);
                    calculationsList = new ArrayList<>();
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);
                    calculationsList.add(value);

                    if (q.getName().contains("net_income_other_crops")) {

                        TOTAL_NET_INCOME_FROM_OTHER_CROPS = calculationsList;
                        TABLE_DATA_LIST.add(new Data(q.getCaption__c(), calculationsList, TAG_RESULTS));

                    } else if (q.getName().contains("farming_income")) {

                        calculationsList = new ArrayList<>();
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(0) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(0)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(1) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(1)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(2) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(2)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(3) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(3)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(4) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(4)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(5) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(5)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(6) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(6)));
                        calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(7) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(7)));

                        TABLE_DATA_LIST.add(new Data(q.getCaption__c(), calculationsList, TAG_RESULTS));

                        TOTAL_FARMING_INCOME = calculationsList;


                    } else if (q.getName().contains("net_income_other_sources")) {

                        TOTAL_NET_INCOME_FROM_OTHER_SOURCES = calculationsList;
                        TABLE_DATA_LIST.add(new Data(q.getCaption__c(), calculationsList, TAG_RESULTS));


                    } else if (q.getName().contains("total_income")) {
                        calculationsList = new ArrayList<>();
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(0) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(0)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(1) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(1)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(2) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(2)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(3) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(3)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(4) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(4)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(5) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(5)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(6) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(6)));
                        calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(7) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(7)));

                        TABLE_DATA_LIST.add(new Data(q.getCaption__c(), calculationsList, TAG_RESULTS));

                        TOTAL_INCOME = calculationsList;


                    }
                }
            }


            calculationsList = new ArrayList<>();
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(0) + "+" + TOTAL_LABOR_COST.get(0)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(1) + "+" + TOTAL_LABOR_COST.get(1)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(2) + "+" + TOTAL_LABOR_COST.get(2)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(3) + "+" + TOTAL_LABOR_COST.get(3)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(4) + "+" + TOTAL_LABOR_COST.get(4)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(5) + "+" + TOTAL_LABOR_COST.get(5)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(6) + "+" + TOTAL_LABOR_COST.get(6)));
            calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(7) + "+" + TOTAL_LABOR_COST.get(7)));

            TABLE_DATA_LIST.add(new Data("Investment in FDP", calculationsList, TAG_RESULTS));
            TOTAL_INVESTMENT_IN_FDP = calculationsList;


            calculationsList = new ArrayList<>();
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(0) + "-" + TOTAL_INVESTMENT_IN_FDP.get(0)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(1) + "-" + TOTAL_INVESTMENT_IN_FDP.get(1)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(2) + "-" + TOTAL_INVESTMENT_IN_FDP.get(2)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(3) + "-" + TOTAL_INVESTMENT_IN_FDP.get(3)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(4) + "-" + TOTAL_INVESTMENT_IN_FDP.get(4)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(5) + "-" + TOTAL_INVESTMENT_IN_FDP.get(5)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(6) + "-" + TOTAL_INVESTMENT_IN_FDP.get(6)));
            calculationsList.add(applyCalculation(TOTAL_INCOME.get(7) + "-" + TOTAL_INVESTMENT_IN_FDP.get(7)));

            TABLE_DATA_LIST.add(new Data("P&L", calculationsList, TAG_RESULTS));
            TOTAL_P_AND_L_LIST = calculationsList;




            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


            try {
                TABLE_DATA_LIST.add(new Data("HouseHold Savings", VALUES_JSON_OBJECT.get(databaseHelper.getQuestionIdByTranslationName("Household Savings")).toString()));

                TABLE_DATA_LIST.add(new Data("Planned Investments", VALUES_JSON_OBJECT.get(databaseHelper.getQuestionIdByTranslationName("Does the household have any planned investments? If so, how much have they allocated for the investment")).toString()));

            } catch (JSONException e) {
                e.printStackTrace();
            }



            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));




            runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    myTableViewAdapter = new MyTableViewAdapter(PandLActivity.this, TABLE_DATA_LIST, tableView);
                    tableView.setDataAdapter(myTableViewAdapter);


                    myTableViewAdapter.setItemClickListener(new MaterialSpinner.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                            Log.i(TAG, "Spinner item selected with tag " + view.getTag());

                            Log.i(TAG, "Position is " + position);

                            if(databaseHelper.editPlotStartYear(String.valueOf(view.getTag().toString().split("_")[0]), position + 1)){

                                progressDialog.setMessage("Updating table data");
                                progressDialog.show();


                               /* if(tableView != null)
                                    tableView.removeAllViewsInLayout();*/


                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        populateTableData();

                                    }
                                });

                                thread.start();


                            }


                        }
                    });
                    progressDialog.dismiss();




                }
            });



        }

    }


    void getAllFarmerDataValues(){

        for(Form form : databaseHelper.getAllForms()){


                Log.d("\n\nP & L ACTIVITY", "GETTING DATA FOR FORM:" + form.getName());


                String jsonString = databaseHelper.getSpecificFarmerDetails(form.getName(), farmer.getCode());

                Log.d("P & L ACTIVITY", "FOUND STRING " + jsonString);

                if (jsonString != null && !jsonString.equals("null") && !jsonString.equals("") && !jsonString.equals("{}") && !jsonString.isEmpty() && !jsonString.equals("empty"))

                    try {
                        JSONObject dispersableJsonObject = new JSONObject(jsonString);

                        Iterator i1 = dispersableJsonObject.keys();


                        while (i1.hasNext()) {
                            String tmp_key = (String) i1.next();
                            VALUES_JSON_OBJECT.put(tmp_key, dispersableJsonObject.get(tmp_key));
                        }
                        Log.d("P & L ACTIVITY", "ADDING TO MAIN JSON OBJECT");

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("P & L ACTIVITY", "####### JSON ERROR" + e.getMessage());

                    }
        }

        Log.d("P & L ACTIVITY", "MAIN JSON OBJECT ITERATION COMPLETE. DATA IS \n" + VALUES_JSON_OBJECT);


    }



    String getAnswerValue(String s){

        String defVal = "0.0";
        try {
            System.out.println("******* FIRST TRY *******   " + s + " : " + defVal);
            defVal = VALUES_JSON_OBJECT.get(s).toString();


        } catch (JSONException e) {
            System.out.println("\n******* EXCEPTION *******   MESSAGE : "  + e.getMessage() + "\n\n");

            try {
                System.out.println("******* SECOND TRY *******   " + s + " : " + defVal);

                defVal = PLOT_AO_JSON_OBJECT.get(s).toString();

             } catch (JSONException f) {
                System.out.println("\n******* EXCEPTION *******   MESSAGE : "  + f.getMessage() + "\n\n");
             }
         }
        return defVal;
    }


    String replaceStringWithValues(String value, String stringToReplace){

        return stringToReplace.replace(value, getAnswerValue(databaseHelper.getQuestionId(value)));

    }


    String  applyCalculation(String equation){

        System.out.println("EQUATION IS " + equation);

        String calculatedValue = "0";
        try {

            calculatedValue = calculate(equation);


        } catch (ScriptException e) {
            e.printStackTrace();
        }

        System.out.println("####### NEW VALUE IS " + calculatedValue);

        return  calculatedValue;

    }


    String parseEquation(String unParsedEquation, String questionsInvolved){

        String parsedEquation = unParsedEquation;


        Log.i(TAG, "\n*********** BEFORE PARSING ********  " + unParsedEquation);

        String[] questionsInvolvedItems = questionsInvolved.trim().split(",");

            for (String aQuestionInvolved : questionsInvolvedItems) {

                Log.i(TAG, "\n*********** REPLACING STRING ********  " + aQuestionInvolved + "\n");

                parsedEquation = replaceStringWithValues(aQuestionInvolved, parsedEquation);

        }


        Log.i(TAG, "############ AFTER PARSING  ############  " + parsedEquation + "\n");


        return parsedEquation;


    }



    String applyCalculationToCalculationObject(final Calculation calculation){
        engine = new ScriptEngineManager().getEngineByName("rhino");

        String equation = "";

        if (calculation.getQuestion4() != null && !calculation.getQuestion4().equals("null")){

            System.out.println("***************************** CALCULATION WITH 4 DATA VALUES");
              equation =   getAnswerValue(calculation.getQuestion1()) +  calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2()) +  calculation.getOperator2()
                    + getAnswerValue(calculation.getQuestion3()) + calculation.getOperator3()
                    + getAnswerValue(calculation.getQuestion4());



        }else if (calculation.getQuestion3() != null && !calculation.getQuestion3().equals("null")){

            System.out.println("***************************** CALCULATION WITH 3 DATA VALUES");

            equation =   getAnswerValue(calculation.getQuestion1()) +  calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2()) +  calculation.getOperator2()
                    + getAnswerValue(calculation.getQuestion3());



        }else if (calculation.getQuestion2() != null && !calculation.getQuestion2().equals("null")){

            System.out.println("***************************** CALCULATION WITH 2 DATA VALUES");
            equation  =   getAnswerValue(calculation.getQuestion1()) +  calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2());


        }else{
            System.out.println("***************************** CALCULATION WITH 1 DATA VALUES");
            equation  =   getAnswerValue(calculation.getQuestion1()) +  "0";



        }

        System.out.println("EQUATION IS " + equation);

        String newValue = "";
        try {

            newValue = calculate(equation);


        } catch (ScriptException e) {
            Log.i("CALCULATION OBJ", e.getMessage());
            newValue = "0.0";
        }

        System.out.println("####### NEW CALC VALUE IS " + newValue);


        return newValue;
    }

    void loadDataForStartYear1(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear 1");

        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);





        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYear2(RealPlot PLOT){


        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_1",null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));











    }

    void loadDataForStartYear3(RealPlot PLOT){


        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_2",null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));

    }

    void loadDataForStartYear4(RealPlot PLOT){


        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_3", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYear5(RealPlot PLOT){




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_4",null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYearMinus1(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear MINUS 1");




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        // TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYearMinus2(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear MINUS 2");




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("2", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        // TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYearMinus3(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear MINUS 3");




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("3", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        // TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYearMinus4(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear MINUS 4");




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        // TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }

    void loadDataForStartYearMinus5(RealPlot PLOT){


        Log.i(TAG, "loadDataForStartYear MINUS 5");




        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);




        List<String> plotIncomes = new ArrayList<>();
        Log.i(TAG, "\nYEAR 0");
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_0.append(plotIncomes.get(0)).append("+");

        Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_1.append(plotIncomes.get(1)).append("+");

        Log.i(TAG, "\nYEAR 2" + PLOT_RECOMMENDATION.getIncome2());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_2.append(plotIncomes.get(2)).append("+");

        Log.i(TAG, "\nYEAR 3" + PLOT_RECOMMENDATION.getIncome3());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_3.append(plotIncomes.get(3)).append("+");

        Log.i(TAG, "\nYEAR 4" + PLOT_RECOMMENDATION.getIncome4());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_4.append(plotIncomes.get(4)).append("+");

        Log.i(TAG, "\nYEAR 5" + PLOT_RECOMMENDATION.getIncome5());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_5.append(plotIncomes.get(5)).append("+");

        Log.i(TAG, "\nYEAR 6" + PLOT_RECOMMENDATION.getIncome6());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_6.append(plotIncomes.get(6)).append("+");

        Log.i(TAG, "\nYEAR 7" + PLOT_RECOMMENDATION.getIncome7());
        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
        NET_INCOME_FROM_COCOA_YEAR_7.append(plotIncomes.get(7)).append("+");


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));
        TABLE_DATA_LIST.add(new Data("Plot Income", plotIncomes, TAG_OTHER_TEXT_VIEW));


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();

        List<String> labourDaysList = new ArrayList<>();


        List<String> pandlist = new ArrayList<>();


        //Todo get Supplies cost for start year

        LaborDaysLaborCostSupplies lls1;
        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("4", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_0.append(maintenanceCostList.get(0)).append("+");
        TOTAL_LABOR_COST_YEAR_0.append(labourCostList.get(0)).append("+");
        TOTAL_LABOR_DAYS_YEAR_0.append(labourDaysList.get(0)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("5", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_1.append(maintenanceCostList.get(1)).append("+");
        TOTAL_LABOR_COST_YEAR_1.append(labourCostList.get(1)).append("+");
        TOTAL_LABOR_DAYS_YEAR_1.append(labourDaysList.get(1)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("6", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_2.append(maintenanceCostList.get(2)).append("+");
        TOTAL_LABOR_COST_YEAR_2.append(labourCostList.get(2)).append("+");
        TOTAL_LABOR_DAYS_YEAR_2.append(labourDaysList.get(2)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_3.append(maintenanceCostList.get(3)).append("+");
        TOTAL_LABOR_COST_YEAR_3.append(labourCostList.get(3)).append("+");
        TOTAL_LABOR_DAYS_YEAR_3.append(labourDaysList.get(3)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_4.append(maintenanceCostList.get(4)).append("+");
        TOTAL_LABOR_COST_YEAR_4.append(labourCostList.get(4)).append("+");
        TOTAL_LABOR_DAYS_YEAR_4.append(labourDaysList.get(4)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_5.append(maintenanceCostList.get(5)).append("+");
        TOTAL_LABOR_COST_YEAR_5.append(labourCostList.get(5)).append("+");
        TOTAL_LABOR_DAYS_YEAR_5.append(labourDaysList.get(5)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }


        TOTAL_MAINTENANCE_COST_YEAR_6.append(maintenanceCostList.get(6)).append("+");
        TOTAL_LABOR_COST_YEAR_6.append(labourCostList.get(6)).append("+");
        TOTAL_LABOR_DAYS_YEAR_6.append(labourDaysList.get(6)).append("+");


        lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

        maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));
        if (prefs.getBoolean("labour", false)) {
            labourCostList.add(applyCalculation(lls1.getLaborCost()));
            labourDaysList.add(applyCalculation(lls1.getLaborDays()));
        } else {
            labourCostList.add("0.0");
            labourDaysList.add("0.0");

        }

        TOTAL_MAINTENANCE_COST_YEAR_7.append(maintenanceCostList.get(7)).append("+");
        TOTAL_LABOR_COST_YEAR_7.append(labourCostList.get(7)).append("+");
        TOTAL_LABOR_DAYS_YEAR_7.append(labourDaysList.get(7)).append("+");


        pandlist.add(applyCalculation(plotIncomes.get(0) + "-" + "(" + maintenanceCostList.get(0) + "+" + labourCostList.get(0) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(1) + "-" + "(" + maintenanceCostList.get(1) + "+" + labourCostList.get(1) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(2) + "-" + "(" + maintenanceCostList.get(2) + "+" + labourCostList.get(2) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(3) + "-" + "(" + maintenanceCostList.get(3) + "+" + labourCostList.get(3) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(4) + "-" + "(" + maintenanceCostList.get(4) + "+" + labourCostList.get(4) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(5) + "-" + "(" + maintenanceCostList.get(5) + "+" + labourCostList.get(5) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(6) + "-" + "(" + maintenanceCostList.get(6) + "+" + labourCostList.get(6) + ")"));
        pandlist.add(applyCalculation(plotIncomes.get(7) + "-" + "(" + maintenanceCostList.get(7) + "+" + labourCostList.get(7) + ")"));


        TABLE_DATA_LIST.add(new Data("Maintenance Cost", maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Labor Days", labourDaysList, TAG_OTHER_TEXT_VIEW));

        TABLE_DATA_LIST.add(new Data("Labor Cost", labourCostList, TAG_OTHER_TEXT_VIEW));


        TABLE_DATA_LIST.add(new Data("Plot P & L", pandlist, TAG_OTHER_TEXT_VIEW));




        // TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_0", null, TAG_VIEW));
        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));



    }





}

















