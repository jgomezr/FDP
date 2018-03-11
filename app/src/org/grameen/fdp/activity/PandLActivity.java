package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.MyTableHearderAdapter;
import org.grameen.fdp.adapter.MyTableViewAdapter;
import org.grameen.fdp.object.Calculation;
import org.grameen.fdp.object.ComplexCalculation;
import org.grameen.fdp.object.Data;
import org.grameen.fdp.object.LaborDaysLaborCostSupplies;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.object.SkipLogic;
import org.grameen.fdp.utility.Constants;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import de.codecrafters.tableview.TableView;

import static org.grameen.fdp.utility.Constants.AGGREGATE_ECONOMIC_RESULTS;
import static org.grameen.fdp.utility.Constants.BUTTON_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_RESULTS;
import static org.grameen.fdp.utility.Constants.TAG_TITLE_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_VIEW;
import static org.grameen.fdp.utility.Constants.TYPE_TEXT;

/**
 * Created by aangjnr on 20/12/2017.
 */

public class PandLActivity extends BaseActivity {

    String startYearId = "nil";
    String CSSV_ID = "nil";
    String CSSV_VALUE = "--";


    Boolean shouldHideStartYear = null;

    String TAG = "P & L ACTIVITY";
    RealFarmer farmer;
    TextView farmerName;
    TextView farmerCode;
    //TextInputLayout commentsTextInput;
    //MaterialSpinner farmerAgreeSpinner;

    String farmerAgree = "No";
    TableView tableView;
    Button save;
    Button submit;
    TextView fdpStatus;

    TextView currency;

    JSONObject VALUES_JSON_OBJECT;


    ProgressDialog progressDialog;

    List<String> calculationsList;

    List<RealPlot> realPlotList;


    List<Data> TABLE_DATA_LIST ;
    List<String> TOTAL_LABOR_COST;
    List<String> TOTAL_LABOR_DAYS ;
    List<String> TOTAL_MAINTENANCE_COST;
    List<String> TOTAL_NET_INCOME_FROM_COCOA;
    List<String> TOTAL_NET_INCOME_FROM_OTHER_CROPS;
    List<String> TOTAL_FARMING_INCOME;
    List<String> TOTAL_NET_INCOME_FROM_OTHER_SOURCES;
    List<String> TOTAL_INCOME;
    List<String> NET_FAMILY_INCOME;

    String TOTAL_FAMILY_EXPENSES = "";


    List<String> TOTAL_INVESTMENT_IN_FDP;
    List<String> TOTAL_P_AND_L_LIST;


    List<StringBuilder> NET_COCOA_STRING_BUILDERS = new ArrayList<>();
    List<StringBuilder> MAINTENANCE_COST_STRING_BUILDERS = new ArrayList<>();
    List<StringBuilder> LABOR_DAYS_STRING_BUILDERS = new ArrayList<>();
    List<StringBuilder> LABOR_COST_STRING_BUILDERS = new ArrayList<>();


    MyTableViewAdapter myTableViewAdapter;
    private JSONObject PLOT_AO_JSON_OBJECT = new JSONObject();
    private JSONObject PLOT_INFO_JSON_OBJECT = new JSONObject();
    private JSONObject PLOT_ADDITIONAL_INTERVENTION_JSON_OBJECT = new JSONObject();


    boolean isTranslation;

    static final int MAX_YEARS = 7;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_and_l);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        isTranslation = prefs.getBoolean("toggleTranslation", false);
        engine = new ScriptEngineManager().getEngineByName("rhino");
        save = findViewById(R.id.save);
        submit = findViewById(R.id.submitAgreement);
        submit.setEnabled(false);

        startYearId = databaseHelper.getQuestionIdByTranslationName("Start year");
        CSSV_ID = databaseHelper.getQuestionIdByTranslationNameAndFormType("CSSV", Constants.ADOPTION_OBSERVATIONS);



        currency = findViewById(R.id.currency);
        currency.setText(prefs.getString("currency", ""));

        farmerName = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);


        fdpStatus = findViewById(R.id.fdpStatus);
        fdpStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(PandLActivity.this, FDPStatusActivity.class);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);

            }
        });


        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

            //Todo add the rest of the views to hide

            findViewById(R.id.save).setVisibility(View.GONE);
            findViewById(R.id.submitAgreement).setVisibility(View.GONE);
            //findViewById(R.id.agreeLayout).setVisibility(View.GONE);

            //commentsTextInput.setEnabled(false);

        }

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);

        if (farmer != null) {


            farmerName.setText(farmer.getFarmerName());
            farmerCode.setText(farmer.getCode());


            getAllFarmerDataValues();
        }

        tableView = findViewById(R.id.tableView);
        tableView.setColumnCount(9);
        String[] TABLE_HEADERS = {"", "Year 0", "Year 1", "Year 2", "Year 3", "Year 4", "Year 5", "Year 6", "Year 7"};
        MyTableHearderAdapter tableHearderAdapter = new MyTableHearderAdapter(this, TABLE_HEADERS);
        tableView.setHeaderAdapter(tableHearderAdapter);

        tableHearderAdapter.setHeaderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = Integer.parseInt(view.getTag().toString());
                Log.i("P & L ACTIVITY", position + "");

                Intent intent = new Intent(PandLActivity.this, DetailedYearMonthlyActivity.class);
                intent.putExtra("year", position - 1);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);

            }
        });


        tableView.setSaveEnabled(true);


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


    void populateTableData() {

        TABLE_DATA_LIST = new ArrayList<>();
        TOTAL_LABOR_COST = new ArrayList<>();
        TOTAL_LABOR_DAYS = new ArrayList<>();
        TOTAL_MAINTENANCE_COST = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_COCOA = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_OTHER_CROPS = new ArrayList<>();
        TOTAL_FARMING_INCOME = new ArrayList<>();
        TOTAL_NET_INCOME_FROM_OTHER_SOURCES = new ArrayList<>();
        TOTAL_INCOME = new ArrayList<>();
        NET_FAMILY_INCOME = new ArrayList<>();

        TOTAL_INVESTMENT_IN_FDP = new ArrayList<>();
        TOTAL_P_AND_L_LIST = new ArrayList<>();


        NET_COCOA_STRING_BUILDERS = new ArrayList<>();
        MAINTENANCE_COST_STRING_BUILDERS = new ArrayList<>()  ;
        LABOR_DAYS_STRING_BUILDERS = new ArrayList<>();
        LABOR_COST_STRING_BUILDERS = new ArrayList<>();

        for(int i = 0; i <= MAX_YEARS; i++){

            NET_COCOA_STRING_BUILDERS.add(new StringBuilder());
            MAINTENANCE_COST_STRING_BUILDERS.add(new StringBuilder());
            LABOR_DAYS_STRING_BUILDERS.add(new StringBuilder());
            LABOR_COST_STRING_BUILDERS.add(new StringBuilder());
        }



        if (farmer != null) {
            realPlotList = databaseHelper.getAllFarmerPlots(farmer.getCode());


            for (RealPlot PLOT : realPlotList) {

                shouldHideStartYear = false;

                Log.d("P & L ACTIVITY", "START YEAR IS " + PLOT.getStartYear());

                try {
                    PLOT_AO_JSON_OBJECT = new JSONObject(PLOT.getAdoptionObservationsJson());
                    PLOT_INFO_JSON_OBJECT = new JSONObject(PLOT.getPlotInformationJson());
                } catch (Exception e) {
                    e.printStackTrace();

                    PLOT_INFO_JSON_OBJECT = new JSONObject();
                }

                try {
                     PLOT_ADDITIONAL_INTERVENTION_JSON_OBJECT = new JSONObject(PLOT.getAdditionalInterventionJson());
                } catch (Exception e) {
                    e.printStackTrace();

                    PLOT_ADDITIONAL_INTERVENTION_JSON_OBJECT =  new JSONObject();

                 }



                if(PLOT.getStartYear() > 0){
                        loadDataForYear(PLOT, PLOT.getStartYear());

                }else if(PLOT.getStartYear() < 0){
                    loadDataForInterventionMadeYear(PLOT, PLOT.getStartYear());
                }



            }// For Loop ends



            for(int i = 0; i < MAX_YEARS + 1; i++){
                TOTAL_MAINTENANCE_COST.add(applyCalculation(MAINTENANCE_COST_STRING_BUILDERS.get(i).toString() + "0"));
                TOTAL_LABOR_DAYS.add(applyCalculation(LABOR_DAYS_STRING_BUILDERS.get(i).toString() + "0"));
                TOTAL_LABOR_COST.add(applyCalculation(LABOR_COST_STRING_BUILDERS.get(i).toString() + "0"));
                TOTAL_NET_INCOME_FROM_COCOA.add(applyCalculation(NET_COCOA_STRING_BUILDERS.get(i).toString() + "0.0"));
            }

            if (prefs.getBoolean("labour", false)) {


                //TABLE_DATA_LIST.add(new Data("Total Costs" + prefs.getString("labourType", ""), null, TAG_TITLE_TEXT_VIEW));

                TABLE_DATA_LIST.add(new Data("Total Maintenance Cost", TOTAL_MAINTENANCE_COST, TAG_RESULTS));

                TABLE_DATA_LIST.add(new Data("Total Labour Days", TOTAL_LABOR_DAYS, TAG_RESULTS));
                TABLE_DATA_LIST.add(new Data("Total Labour Cost", TOTAL_LABOR_COST, TAG_RESULTS));

            }

            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


            Question nifc = databaseHelper.getQuestionByTranslation("Gross income from Cocoa");
            TABLE_DATA_LIST.add(new Data((isTranslation) ?  nifc.getTranslation__c() : nifc.getCaption__c(), TOTAL_NET_INCOME_FROM_COCOA, TAG_RESULTS));


            for (Calculation calc :  databaseHelper.sortCalculations()) {

                Question q = databaseHelper.getQuestion(calc.getResultQuestion());
                if (q.getForm__r().getName().equalsIgnoreCase(AGGREGATE_ECONOMIC_RESULTS)) {


                    if (q.getTranslation__c().equalsIgnoreCase("Net income from other crops")) {

                        String value = applyCalculationToCalculationObject(calc);
                        calculationsList = new ArrayList<>();

                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(value);
                        }

                        TOTAL_NET_INCOME_FROM_OTHER_CROPS = calculationsList;
                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));


                    } else if (q.getTranslation__c().equalsIgnoreCase("Total farming income")) {

                        calculationsList = new ArrayList<>();

                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(applyCalculation(TOTAL_NET_INCOME_FROM_COCOA.get(i) + "+" + TOTAL_NET_INCOME_FROM_OTHER_CROPS.get(i)));
                        }

                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));
                        TOTAL_FARMING_INCOME = calculationsList;


                    } else if (q.getTranslation__c().equalsIgnoreCase("Net income from all other sources")) {

                        String value = applyCalculationToCalculationObject(calc);
                        calculationsList = new ArrayList<>();

                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(value);
                        }

                        TOTAL_NET_INCOME_FROM_OTHER_SOURCES = calculationsList;
                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));


                    } else if (q.getTranslation__c().equalsIgnoreCase("Total income")) {
                        calculationsList = new ArrayList<>();

                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(applyCalculation(TOTAL_FARMING_INCOME.get(i) + "+" + TOTAL_NET_INCOME_FROM_OTHER_SOURCES.get(i)));
                        }

                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));

                        TOTAL_INCOME = calculationsList;


                    } else if (q.getTranslation__c().equalsIgnoreCase("Total family expenses")) {

                        String value = applyCalculationToCalculationObject(calc);
                        calculationsList = new ArrayList<>();

                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(value);
                        }

                        TOTAL_FAMILY_EXPENSES = value;

                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));


                    } else if (q.getTranslation__c().equalsIgnoreCase("Net family income")) {

                        calculationsList = new ArrayList<>();
                        for(int i = 0; i < MAX_YEARS + 1; i++) {
                            calculationsList.add(applyCalculation(TOTAL_INCOME.get(i) + "-" + TOTAL_FAMILY_EXPENSES));
                        }

                        TABLE_DATA_LIST.add(new Data((isTranslation) ?  q.getTranslation__c() : q.getCaption__c(), calculationsList, TAG_RESULTS));

                        NET_FAMILY_INCOME = calculationsList;


                    }
                }
            }


            calculationsList = new ArrayList<>();

            for(int i = 0; i < MAX_YEARS + 1; i++) {
                calculationsList.add(applyCalculation(TOTAL_MAINTENANCE_COST.get(i) + "+" + TOTAL_LABOR_COST.get(i)));
            }


            Question iIFDP = databaseHelper.getQuestionByTranslation("Investment in FDP");
            TABLE_DATA_LIST.add(new Data((isTranslation) ?  iIFDP.getTranslation__c() : iIFDP.getCaption__c(), calculationsList, TAG_RESULTS));
            TOTAL_INVESTMENT_IN_FDP = calculationsList;

            calculationsList = new ArrayList<>();

            try {

                for(int i = 0; i < MAX_YEARS + 1; i++) {
                    calculationsList.add(applyCalculation(NET_FAMILY_INCOME.get(i) + "-" + TOTAL_INVESTMENT_IN_FDP.get(i)));
                }

            } catch (Exception ignored) {

                calculationsList = new ArrayList<>();

                for(int i = 0; i < MAX_YEARS + 1; i++) {
                    calculationsList.add(applyCalculation(TOTAL_INCOME.get(i) + "-" + TOTAL_INVESTMENT_IN_FDP.get(i)));
                }


            }

            Question pL = databaseHelper.getQuestionByTranslation("Profit or Loss");
            TABLE_DATA_LIST.add(new Data((isTranslation) ?  pL.getTranslation__c() : pL.getCaption__c(), calculationsList, TAG_RESULTS));
            TOTAL_P_AND_L_LIST = calculationsList;


            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));

            Question hhs = databaseHelper.getQuestionByTranslation("Household Savings");
            Question pI =  databaseHelper.getQuestionByTranslation("Does the household have any planned investments? If so, how much have they allocated for the investment");

            try {

                TABLE_DATA_LIST.add(new Data((isTranslation) ?  hhs.getTranslation__c() : hhs.getCaption__c(), VALUES_JSON_OBJECT.get(hhs.getId()).toString()));

            } catch (JSONException e) {
                e.printStackTrace();

                TABLE_DATA_LIST.add(new Data((isTranslation) ?  hhs.getTranslation__c() : hhs.getCaption__c(), "0.00"));


            }



             try {

                 TABLE_DATA_LIST.add(new Data("Planned Investments", VALUES_JSON_OBJECT.get(pI.getId()).toString()));

            } catch (JSONException e) {
                e.printStackTrace();

                TABLE_DATA_LIST.add(new Data("Planned Investments", "0.00"));

            }







            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));
            TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


            runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    myTableViewAdapter = new MyTableViewAdapter(PandLActivity.this, TABLE_DATA_LIST, tableView);
                    tableView.setDataAdapter(myTableViewAdapter);


                    myTableViewAdapter.setItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                            Log.i(TAG, "Spinner item selected with tag " + view.getTag());

                            Log.i(TAG, "Position is " + position);

                            if (databaseHelper.editPlotStartYear(String.valueOf(view.getTag().toString().split("_")[0]), position + 1)) {

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


                    myTableViewAdapter.setClickistener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Recommendation PLOT_REC;
                            Recommendation GAPS_RECOMMENDATION_FOR_START_YEAR;

                            Log.i(TAG, "Button item clicked with tag " + view.getTag());

                            String[] values = view.getTag().toString().split("_");

                            String plotId = values[0];
                            String RecName = values[1];


                            if (RecName.equalsIgnoreCase("Thinning Out")) {

                                PLOT_REC = databaseHelper.getRecommendationBasedOnName("Thinning out");
                                GAPS_RECOMMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Maintenance (GAPs)");


                            } else if (RecName.equalsIgnoreCase("Filling In")) {

                                PLOT_REC = databaseHelper.getRecommendationBasedOnName("Filling in");
                                GAPS_RECOMMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Maintenance (GAPs)");


                            } else {
                                PLOT_REC = databaseHelper.getRecommendationBasedOnName("Replant");
                                GAPS_RECOMMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Minimal GAPs");
                            }

                            if (databaseHelper.editFarmerPlotRecommendationId(farmerCode.getText().toString(), plotId,
                                    GAPS_RECOMMENDATION_FOR_START_YEAR.getId() + "," + PLOT_REC.getId())) {

                                progressDialog.setMessage("Updating table data");
                                progressDialog.show();

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


    void getAllFarmerDataValues() {

            String jsonString = databaseHelper.getAllAnswersJson(farmer.getCode());

            Log.d("P & L ACTIVITY", "FOUND STRING " + jsonString);

            if (jsonString != null && !jsonString.equals("null") && !jsonString.equals("") && !jsonString.equals("{}") && !jsonString.isEmpty() && !jsonString.equals("empty"))

                try {
                    VALUES_JSON_OBJECT = new JSONObject(jsonString);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("P & L ACTIVITY", "####### JSON ERROR" + e.getMessage());

                }


        Log.d("P & L ACTIVITY", "MAIN JSON OBJECT ITERATION COMPLETE. DATA IS \n" + VALUES_JSON_OBJECT);


    }


    String getAnswerValue(String s) {

        String defVal = "0.0";
        try {
            defVal = VALUES_JSON_OBJECT.get(s).toString();

            System.out.println("******* FIRST TRY ALL FARMER VALUES *******   " + s + " : " + defVal);


        } catch (JSONException e) {
            System.out.println("\n******* EXCEPTION *******   MESSAGE : " + e.getMessage() + "\n\n");

            try {

                defVal = PLOT_AO_JSON_OBJECT.get(s).toString();
                System.out.println("******* SECOND TRY ******* PLOT'S AO VALUES  " + s + " : " + defVal);


            } catch (JSONException f) {
                System.out.println("\n******* EXCEPTION *******   MESSAGE : " + f.getMessage() + "\n\n");

                try {

                    defVal = PLOT_INFO_JSON_OBJECT.get(s).toString();
                    System.out.println("******* THIRD TRY *******  PLOT'S INFO VALUES  " + s + " : " + defVal);

                } catch (JSONException g) {
                System.out.println("\n******* EXCEPTION *******   MESSAGE : " + g.getMessage() + "\n\n");

                    try {

                        defVal = PLOT_ADDITIONAL_INTERVENTION_JSON_OBJECT.get(s).toString();
                        System.out.println("******* FOURTH TRY *******  PLOT'S AI VALUES  " + s + " : " + defVal);

                    } catch (JSONException h) {
                        System.out.println("\n******* EXCEPTION *******   MESSAGE : " + g.getMessage() + "\n\n");
                    }
            }

            }
        }

        System.out.println("\n******* VALUE IS *******   : " + defVal + "\n\n");


        return defVal;
    }



    String replaceStringWithValues(String name, String stringToReplace) {

        String id = databaseHelper.getQuestionId(name);

        //Todo complex calculation Application
        ComplexCalculation complexCalculation = databaseHelper.getComplexCalculation(id);
        if(complexCalculation != null){

            return stringToReplace.replace(name, applyComplexCalculation(complexCalculation));


        }else

        return stringToReplace.replace(name, getAnswerValue(id));
    }

    String applyCalculation(String equation) {

        System.out.println("EQUATION IS " + equation);

        String calculatedValue = "0";
        try {

            calculatedValue = calculate(equation);


        } catch (ScriptException e) {
            e.printStackTrace();
        }

        System.out.println("####### NEW VALUE IS " + calculatedValue);

        return calculatedValue;

    }

    String parseEquation(String unParsedEquation, String questionsInvolved) {

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

    String applyCalculationToCalculationObject(final Calculation calculation) {
        engine = new ScriptEngineManager().getEngineByName("rhino");

        String equation = "";

        if (calculation.getQuestion4() != null && !calculation.getQuestion4().equals("null")) {

            System.out.println("***************************** CALCULATION WITH 4 DATA VALUES");
            equation = getAnswerValue(calculation.getQuestion1()) + calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2()) + calculation.getOperator2()
                    + getAnswerValue(calculation.getQuestion3()) + calculation.getOperator3()
                    + getAnswerValue(calculation.getQuestion4());


        } else if (calculation.getQuestion3() != null && !calculation.getQuestion3().equals("null")) {

            System.out.println("***************************** CALCULATION WITH 3 DATA VALUES");

            equation = getAnswerValue(calculation.getQuestion1()) + calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2()) + calculation.getOperator2()
                    + getAnswerValue(calculation.getQuestion3());


        } else if (calculation.getQuestion2() != null && !calculation.getQuestion2().equals("null")) {

            System.out.println("***************************** CALCULATION WITH 2 DATA VALUES");
            equation = getAnswerValue(calculation.getQuestion1()) + calculation.getOperator1()
                    + getAnswerValue(calculation.getQuestion2());


        } else {
            System.out.println("***************************** CALCULATION WITH 1 DATA VALUES");
            equation = getAnswerValue(calculation.getQuestion1()) + " + 0";


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

    void loadDataForYear(RealPlot PLOT, int CONTROLLING_YEAR) {


        System.out.println("################################ \n CALCULATING INCOME \n ###################################");



        Log.i(TAG, "loadDataForYear " + CONTROLLING_YEAR);
        int TEMP = CONTROLLING_YEAR;
        int TEMP2 = CONTROLLING_YEAR;

        Log.i(TAG, "TEMP = " + TEMP);
        Log.i(TAG, "TEMP 2 =  " + TEMP2);

        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);


        List<String> plotIncomes = new ArrayList<>();


        for(int i = 0; i < CONTROLLING_YEAR; i++){

            if(i == 0){
                Log.i(TAG, "\nYEAR " + i);
                plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
                NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

            }else {

                Log.i(TAG, "\nYEAR " + i);
                plotIncomes.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getIncome0(), GAPS_RECOMENDATION_FOR_START_YEAR.getQuestionsInvolved())));
                NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

            }
        }


        for(int i = 1; i < MAX_YEARS + 1; i++){


            switch (i){

                case 1:
                    Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 2:

                    Log.i(TAG, "\nYEAR 2 " + PLOT_RECOMMENDATION.getIncome2());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");


                    break;
                case 3:
                    Log.i(TAG, "\nYEAR 3 " + PLOT_RECOMMENDATION.getIncome3());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 4:
                    Log.i(TAG, "\nYEAR 4 " + PLOT_RECOMMENDATION.getIncome4());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 5:

                    Log.i(TAG, "\nYEAR 5 " + PLOT_RECOMMENDATION.getIncome5());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");



                    break;
                case 6:

                    Log.i(TAG, "\nYEAR 6 " + PLOT_RECOMMENDATION.getIncome6());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");



                    break;
                case 7:
                    Log.i(TAG, "\nYEAR 7 " + PLOT_RECOMMENDATION.getIncome7());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;

            }


            if(TEMP == MAX_YEARS) break;

            TEMP += 1;

            Log.i(TAG, "^^^^^^^^^^^^^^    TEMP IS NOW " + TEMP);


        }



        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName(), null, TAG_TITLE_TEXT_VIEW));

        Question plotIncomeQuestion = databaseHelper.getQuestionByTranslation("Plot income");

        TABLE_DATA_LIST.add(new Data((isTranslation) ? plotIncomeQuestion.getTranslation__c() : plotIncomeQuestion.getCaption__c(), plotIncomes, TAG_OTHER_TEXT_VIEW));

        //Todo maintenance cost, labor codt and labor days * plot size in ha


        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();
        List<String> labourDaysList = new ArrayList<>();
        List<String> pandlist = new ArrayList<>();



        String plotSizeInHaValue = "0.0";
        try {
            Question plotSizeInHaQuestion = databaseHelper.getQuestionByTranslation("Plot area ha");

            //Todo complex calculation Application
            ComplexCalculation complexCalculation = databaseHelper.getComplexCalculation(plotSizeInHaQuestion.getId());
            if (complexCalculation != null) {
                plotSizeInHaValue = applyComplexCalculation(complexCalculation);
            }

        }catch(Exception e){e.printStackTrace();}


        Log.i(TAG, "^^^^^^^^^^^^^^   PLOT SIZE IN HA VALUE IS ^^^^^^^^^^^^^^^^^  " + plotSizeInHaValue);




        System.out.println("################################ \n CALCULATING MAINTENANCE COST \n ###################################");

        LaborDaysLaborCostSupplies lls1 = new LaborDaysLaborCostSupplies();

        System.out.println("################################ \n CALCULATING LABOUR DAYS AND COST FOR YEAR 0 to SELECTED START YEAR (1 = DEFAULT) \n ###################################");


        for(int i = 0; i < CONTROLLING_YEAR; i++){


            if(i == 0){
                Log.i(TAG, "\nYEAR " + i);
                maintenanceCostList.add(applyCalculation(parseEquation(GAPS_RECOMENDATION_FOR_START_YEAR.getCost0(), GAPS_RECOMENDATION_FOR_START_YEAR.getCostQuestions())));
                MAINTENANCE_COST_STRING_BUILDERS.get(i).append(maintenanceCostList.get(i)).append("+");

            }else {
                lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("1", GAPS_RECOMENDATION_FOR_START_YEAR.getId());
                maintenanceCostList.add(applyCalculation( "(" + lls1.getSuppliesCost() + ") * " + plotSizeInHaValue));
                MAINTENANCE_COST_STRING_BUILDERS.get(i).append(  maintenanceCostList.get(i)).append("+");
            }


            if (prefs.getBoolean("labour", false)) {
                labourCostList.add(applyCalculation( "(" + lls1.getLaborCost() + ") * " + plotSizeInHaValue));
                labourDaysList.add(applyCalculation( "(" + lls1.getLaborDays() + ") * " + plotSizeInHaValue));
            } else {
                labourCostList.add("0.0");
                labourDaysList.add("0.0");

            }

            LABOR_COST_STRING_BUILDERS.get(i).append(labourCostList.get(i)).append("+");
            LABOR_DAYS_STRING_BUILDERS.get(i).append(labourDaysList.get(i)).append("+");

        }




        System.out.println("################################ \n CALCULATING LABOUR DAYS AND COST \n ###################################");


        for(int i = 1; i < MAX_YEARS + 1; i++) {

                    lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear(String.valueOf(i), PLOT_RECOMMENDATION.getId());

                    maintenanceCostList.add(applyCalculation(lls1.getSuppliesCost()));

                    if (prefs.getBoolean("labour", false)) {
                        labourCostList.add(applyCalculation( "(" + lls1.getLaborCost() + ") * " + plotSizeInHaValue));
                        labourDaysList.add(applyCalculation( "(" + lls1.getLaborDays() + ") * " + plotSizeInHaValue));
                    } else {
                        labourCostList.add("0.0");
                        labourDaysList.add("0.0");

                    }

                    MAINTENANCE_COST_STRING_BUILDERS.get(TEMP2).append(maintenanceCostList.get(TEMP2)).append("+");
                    LABOR_COST_STRING_BUILDERS.get(TEMP2).append(labourCostList.get(TEMP2)).append("+");
                    LABOR_DAYS_STRING_BUILDERS.get(TEMP2).append(labourDaysList.get(TEMP2)).append("+");


            if(TEMP2 == MAX_YEARS) break;

            TEMP2 += 1;
        }


        for(int i = 0; i < MAX_YEARS + 1; i++){

            pandlist.add(applyCalculation(plotIncomes.get(i) + "-" + "(" + maintenanceCostList.get(i) + "+" + labourCostList.get(i) + ")"));


        }


        Log.i(TAG, "AFTER : TEMP = " + TEMP);
        Log.i(TAG, "AFTER : TEMP 2 =  " + TEMP2);


        Question mcQ = databaseHelper.getQuestionByTranslation("Cost of maintenance/investment");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? mcQ.getTranslation__c() : mcQ.getCaption__c(), maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        Question ldn = databaseHelper.getQuestionByTranslation("Labor needed in man days");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? ldn.getTranslation__c() : ldn.getCaption__c(), labourDaysList, TAG_OTHER_TEXT_VIEW));


        Question lc = databaseHelper.getQuestionByTranslation("Cost of labor");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? lc.getTranslation__c() : lc.getCaption__c(), labourCostList, TAG_OTHER_TEXT_VIEW));

        Question pl = databaseHelper.getQuestionByTranslation("Plot P&L");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? pl.getTranslation__c() : pl.getCaption__c(), pandlist, TAG_OTHER_TEXT_VIEW));




        List<Question> plotResultsQuestions = databaseHelper.getSpecificSetOfQuestions("plot results");
        if(plotResultsQuestions != null){

            for (Question q : plotResultsQuestions){

                if(q.getType__c().equalsIgnoreCase(TYPE_TEXT)){
                    try {
                        SkipLogic skipLogic = databaseHelper.doesQuestionHaveSkipLogic(q.getId());

                        if( skipLogic != null && !setupSkipLogicsAndHideViews(skipLogic))
                            TABLE_DATA_LIST.add(new Data((prefs.getBoolean("toggleTranslation", false)) ? q.getTranslation__c() : q.getCaption__c(), skipLogic.getAnswerValue()));

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


      /*//Question limeNeededQuestion = databaseHelper.getQuestionByTranslation("Lime");
        //Question drainageNeededQuestion = databaseHelper.getQuestionByTranslation("Drainage");

        try {

            SkipLogic skipLogic = databaseHelper.doesQuestionHaveSkipLogic(limeNeededQuestion.getId());

            if(skipLogic != null && !setupSkipLogicsAndHideViews(skipLogic))
                TABLE_DATA_LIST.add(new Data((prefs.getBoolean("toggleTranslation", false)) ? limeNeededQuestion.getTranslation__c() : limeNeededQuestion.getCaption__c(), skipLogic.getAnswerValue()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {

            SkipLogic skipLogic = databaseHelper.doesQuestionHaveSkipLogic(drainageNeededQuestion.getId());
            if( skipLogic != null && !setupSkipLogicsAndHideViews(skipLogic))
               TABLE_DATA_LIST.add(new Data((prefs.getBoolean("toggleTranslation", false)) ? drainageNeededQuestion.getTranslation__c() : drainageNeededQuestion.getCaption__c(), skipLogic.getAnswerValue()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }*/




        showOrHideStartYear(PLOT.getId(), PLOT.getStartYear() - 1);


        if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("grafting")) {

          /*  if (prefs.getString("ISO", "").equalsIgnoreCase("CIV") || prefs.getString("ISO", "").equalsIgnoreCase("GHA"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));

            else if (prefs.getString("ISO", "").equalsIgnoreCase("IDN")) {

                try {
                    JSONObject jsonObject = new JSONObject(PLOT.getAdoptionObservationsJson());
                    int treeAge = Integer.parseInt(jsonObject.get(prefs.getString("tree age", "")).toString());

                    Log.i(TAG, "^^^^^^^^ TREE AGE IS  ^^^^^^^^^" + treeAge);

                    if (treeAge >= 21 && treeAge <= 25)
                        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }*/



                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));
 




        } else if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Thinning Out") ||
                PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Filling In")) {

            prefs.edit().putString(PLOT.getId(), PLOT_RECOMMENDATION.getName()).apply();

            TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));


        } else if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Replant")) {


            if (prefs.getString(PLOT.getId(), "").equalsIgnoreCase("thinning out"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Thinning Out", null, BUTTON_VIEW));

            else if (prefs.getString(PLOT.getId(), "").equalsIgnoreCase("filling in"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Filling In", null, BUTTON_VIEW));


        }


        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


    }


    void loadDataForInterventionMadeYear(RealPlot PLOT, int CONTROLLING_YEAR) {


        Log.i(TAG, "loadDataForYear " + CONTROLLING_YEAR);

        String recommendationId = PLOT.getRecommendationId();
        String[] GAPS_PLOT_RECOMMENDATION_IDS = recommendationId.split(",");

        int TEMP = CONTROLLING_YEAR * -1;
        int TEMP2 = CONTROLLING_YEAR * -1;

        Log.i(TAG, "TEMP = " + TEMP);
        Log.i(TAG, "TEMP2 =  " + TEMP2);



        //Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);


        List<String> plotIncomes = new ArrayList<>();



        for(int i = 0; i <= MAX_YEARS; i++){

            switch (TEMP){//5

                case 1:
                    Log.i(TAG, "\nYEAR 1 " + PLOT_RECOMMENDATION.getIncome1());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome1(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 2:

                    Log.i(TAG, "\nYEAR 2 " + PLOT_RECOMMENDATION.getIncome2());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome2(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");


                    break;
                case 3:
                    Log.i(TAG, "\nYEAR 3 " + PLOT_RECOMMENDATION.getIncome3());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome3(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 4:
                    Log.i(TAG, "\nYEAR 4 " + PLOT_RECOMMENDATION.getIncome4());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome4(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 5:

                    Log.i(TAG, "\nYEAR 5 " + PLOT_RECOMMENDATION.getIncome5());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome5(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 6:

                    Log.i(TAG, "\nYEAR 6 " + PLOT_RECOMMENDATION.getIncome6());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome6(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;
                case 7:
                    Log.i(TAG, "\nYEAR 7 " + PLOT_RECOMMENDATION.getIncome7());
                    plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                    NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");

                    break;


                    default:
                         Log.i(TAG, "\nYEAR 7 " + PLOT_RECOMMENDATION.getIncome7());
                        plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
                        NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");


            }




            //if(TEMP == MAX_YEARS ) break;
            TEMP += 1;
            Log.i(TAG, "^^^^^^^^^^^^^^    TEMP IS NOW " + TEMP);




        }


/*
        for(int i = TEMP2 ; i <= MAX_YEARS; i++){

            Log.i(TAG, "\nYEAR " + i);
            plotIncomes.add(applyCalculation(parseEquation(PLOT_RECOMMENDATION.getIncome7(), PLOT_RECOMMENDATION.getQuestionsInvolved())));
            NET_COCOA_STRING_BUILDERS.get(i).append(plotIncomes.get(i)).append("+");


        }*/


        TABLE_DATA_LIST.add(new Data(PLOT.getName() + "\n" + PLOT_RECOMMENDATION.getName() + "\nYear " + -(PLOT.getStartYear()), null, TAG_TITLE_TEXT_VIEW));

        Question plotIncomeQuestion = databaseHelper.getQuestionByTranslation("Plot income");


        TABLE_DATA_LIST.add(new Data((isTranslation) ? plotIncomeQuestion.getTranslation__c() : plotIncomeQuestion.getCaption__c(), plotIncomes, TAG_OTHER_TEXT_VIEW));





        String plotSizeInHaValue = "0.0";
        try {
            Question plotSizeInHaQuestion = databaseHelper.getQuestionByTranslation("Plot area ha");

            //Todo complex calculation Application
            ComplexCalculation complexCalculation = databaseHelper.getComplexCalculation(plotSizeInHaQuestion.getId());
            if (complexCalculation != null) {
                plotSizeInHaValue = applyComplexCalculation(complexCalculation);
            }

        }catch(Exception e){e.printStackTrace();}



        Log.i(TAG, "^^^^^^^^^^^^^^   PLOT SIZE IN HA VALUE IS ^^^^^^^^^^^^^^^^^  " + plotSizeInHaValue);



        ////////

        //This is also known as Supplies cost. The selected year is always with   the (GAPS) recommendation obtained in conjunction with the plot recommendation attained
        List<String> maintenanceCostList = new ArrayList<>();

        List<String> labourCostList = new ArrayList<>();
        List<String> labourDaysList = new ArrayList<>();
        List<String> pandlist = new ArrayList<>();

        LaborDaysLaborCostSupplies lls1;


        TEMP = CONTROLLING_YEAR * -1;
        TEMP2 = TEMP;
        int LAST_INDEX = 0;


        for(int i = 0; i <= MAX_YEARS; i++) {

            if (TEMP <= MAX_YEARS) {

                lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear(String.valueOf(TEMP), PLOT_RECOMMENDATION.getId());

                maintenanceCostList.add(applyCalculation("(" + lls1.getSuppliesCost() + ") * " + plotSizeInHaValue));

                if (prefs.getBoolean("labour", false)) {
                    labourCostList.add(applyCalculation("(" + lls1.getLaborCost() + ") * " + plotSizeInHaValue));
                    labourDaysList.add(applyCalculation("(" + lls1.getLaborDays() + ") * " + plotSizeInHaValue));
                } else {
                    labourCostList.add("0.0");
                    labourDaysList.add("0.0");

                }

                MAINTENANCE_COST_STRING_BUILDERS.get(i).append(maintenanceCostList.get(i)).append("+");
                LABOR_COST_STRING_BUILDERS.get(i).append(labourCostList.get(i)).append("+");
                LABOR_DAYS_STRING_BUILDERS.get(i).append(labourDaysList.get(i)).append("+");


            } else {

                lls1 = databaseHelper.getTotalLaborDaysLaborCostAndSuppliesByYear("7", PLOT_RECOMMENDATION.getId());

                maintenanceCostList.add(applyCalculation("(" + lls1.getSuppliesCost() + ") * " + plotSizeInHaValue));

                if (prefs.getBoolean("labour", false)) {
                    labourCostList.add(applyCalculation("(" + lls1.getLaborCost() + ") * " + plotSizeInHaValue));
                    labourDaysList.add(applyCalculation("(" + lls1.getLaborDays() + ") * " + plotSizeInHaValue));
                } else {
                    labourCostList.add("0.0");
                    labourDaysList.add("0.0");
                }

                MAINTENANCE_COST_STRING_BUILDERS.get(i).append(maintenanceCostList.get(i)).append("+");
                LABOR_COST_STRING_BUILDERS.get(i).append(labourCostList.get(i)).append("+");
                LABOR_DAYS_STRING_BUILDERS.get(i).append(labourDaysList.get(i)).append("+");


            }

            //if(TEMP == MAX_YEARS) break;
            TEMP += 1;


        }


        for(int i = 0; i < MAX_YEARS + 1; i++){

            pandlist.add(applyCalculation(plotIncomes.get(i) + "-" + "(" + maintenanceCostList.get(i) + "+" + labourCostList.get(i) + ")"));


        }



        Question mcQ = databaseHelper.getQuestionByTranslation("Cost of maintenance/investment");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? mcQ.getTranslation__c() : mcQ.getCaption__c(), maintenanceCostList, TAG_OTHER_TEXT_VIEW));


        Question ldn = databaseHelper.getQuestionByTranslation("Labor needed in man days");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? ldn.getTranslation__c() : ldn.getCaption__c(), labourDaysList, TAG_OTHER_TEXT_VIEW));


        Question lc = databaseHelper.getQuestionByTranslation("Cost of labor");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? lc.getTranslation__c() : lc.getCaption__c(), labourCostList, TAG_OTHER_TEXT_VIEW));

        Question pl = databaseHelper.getQuestionByTranslation("Plot P&L");
        TABLE_DATA_LIST.add(new Data((isTranslation) ? pl.getTranslation__c() : pl.getCaption__c(), pandlist, TAG_OTHER_TEXT_VIEW));






        //showOrHideStartYear(PLOT.getId(), PLOT.getStartYear() - 1);


        if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("grafting")) {

            if (prefs.getString("ISO", "").equalsIgnoreCase("CIV") || prefs.getString("ISO", "").equalsIgnoreCase("GHA"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));

            else if (prefs.getString("ISO", "").equalsIgnoreCase("IDN")) {

                try {
                    JSONObject jsonObject = new JSONObject(PLOT.getAdoptionObservationsJson());
                    int treeAge = Integer.parseInt(jsonObject.get(prefs.getString("tree age", "")).toString());

                    Log.i(TAG, "^^^^^^^^ TREE AGE IS  ^^^^^^^^^" + treeAge);

                    if (treeAge >= 21 && treeAge <= 25)
                        TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } else if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Thinning Out") ||
                PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Filling In")) {

            prefs.edit().putString(PLOT.getId(), PLOT_RECOMMENDATION.getName()).apply();

            TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Replant", null, BUTTON_VIEW));


        } else if (PLOT_RECOMMENDATION.getName().equalsIgnoreCase("Replant")) {


            if (prefs.getString(PLOT.getId(), "").equalsIgnoreCase("thinning out"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Thinning Out", null, BUTTON_VIEW));

            else if (prefs.getString(PLOT.getId(), "").equalsIgnoreCase("filling in"))

                TABLE_DATA_LIST.add(new Data(PLOT.getId() + "_Filling In", null, BUTTON_VIEW));


        }


        TABLE_DATA_LIST.add(new Data("", null, TAG_OTHER_TEXT_VIEW));


    }


    void showOrHideStartYear(String plotId, int year){

        Log.i(TAG, "\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n");
        Boolean value  = false;



        CSSV_VALUE = "--";

        if(PLOT_AO_JSON_OBJECT != null){


            try {
                CSSV_VALUE = PLOT_AO_JSON_OBJECT.getString(CSSV_ID);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        List<SkipLogic> skipLogics = databaseHelper.doesQuestionHaveSkipLogics(CSSV_ID);

        if (skipLogics != null && skipLogics.size() > 0) {

            for (SkipLogic sl : skipLogics) {

                try {


                    if (compareValues(sl, CSSV_VALUE)) {
                        value = sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE);

                    } else {

                        value = !sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE);
                    }


                } catch (Exception ignored) {
                }
            }
        }


        if(!value)
            TABLE_DATA_LIST.add(new Data(plotId + "_" + year, null, TAG_VIEW));




    }

    boolean setupSkipLogicsAndHideViews(SkipLogic sl) {


        Boolean value = null;

                    try {
                        if (compareValues(sl, getAnswerValue(sl.getQuestionId()))) {

                            Log.i(TAG, "COMPARING VALUES EVALUATED TO " + true);

                            value = sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE);
                        }

                    } catch (Exception ignored) {
                        ignored.printStackTrace();
                        Log.i(TAG, "INITIALIZING SKIP LOGIC " + ignored.getMessage());

            }

            return value;
    }

    String applyComplexCalculation(ComplexCalculation complexCalculation) {

        String evaluatedValue = "0.0";


        System.out.println("####### COMPLEX CALCULATION ------ ");


        String formula = complexCalculation.getCondition();


        try {

            String questionName = "";
            String valueToCompare = "";
            String trueValueName = "";
            String falseValueEquation = "";
            String section = formula;


            section = section.replace("IF", "");
            section = section.replace("(", "");
            section = section.replace(")", "");
            section = section.replace(" ", "");


            //Log.i(TAG, "AFTER CLEANSING " + sections[i]);

            String[] discard = section.split("==");

            questionName = discard[0];
            //Log.i(TAG, "QUESTION NAME " + discard[0]);


            String[] values = discard[1].split(",");

            valueToCompare = values[0];
            //Log.i(TAG, "VALUE TO COMPARE " + values[0]);

            trueValueName = values[1];
            //Log.i(TAG, "TRUE VALUE " + values[1]);

            falseValueEquation = values[2];
            // Log.i(TAG, "FALSE VALUE " + values[2]);


            String value = getAnswerValue(databaseHelper.getQuestionByName(questionName).getId());

            System.out.println("####### COMPLEX CALCULATION ------ VALUE = " + value);
            System.out.println("####### COMPLEX CALCULATION ------ VALUE TO COMPARE = " + valueToCompare);


            if (!value.equals("--")) {

                if (value.equalsIgnoreCase(valueToCompare)) {

                    String trueValueId = databaseHelper.getQuestionByName(trueValueName).getId();

                    evaluatedValue =  getAnswerValue(trueValueId);


                } else {

                    engine = new ScriptEngineManager().getEngineByName("rhino");




                    String operator = "*";

                    if (falseValueEquation.contains("+")) operator = "+";
                    else if (falseValueEquation.contains("*")) operator = "*";
                    else if (falseValueEquation.contains("-")) operator = "-";
                    else if (falseValueEquation.contains("/")) operator = "/";

                    Log.i(TAG, "OPERATOR IS IS " + operator);


                    String[] vals = falseValueEquation.split("[-+*/]");


                    String falseName = vals[0];
                    String constant = vals[1];


                    String falseValueId = databaseHelper.getQuestionByName(falseName).getId();


                    evaluatedValue =  String.valueOf((Double) engine.eval(getAnswerValue(falseValueId) + operator + constant));


                }

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


        System.out.println("####### COMPLEX CALCULATION ------ EVALUATED VALUE = " + evaluatedValue);



        return  evaluatedValue;
    }


}

















