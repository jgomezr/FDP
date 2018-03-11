package org.grameen.fdp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.MyFormFragment;
import org.grameen.fdp.object.Logic;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.utility.Constants;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class PlotDetailsActivity extends BaseActivity {

    String TAG = "PLOT DETAILS ACTIVITY";
    RealPlot plot;
    MyFormFragment plotAOFragment;
    TextView plotName;
    TextView plotSize;
    TextView ph;
    TextView estimatedProductionSize;
    TextView recommendedIntervention;
    TextView limeNeeded;
    ProgressBar recommendationProgress;
    boolean isMonitoringMode = false;
    JSONObject AOR_VALUES = new JSONObject();
    JSONObject AI_VALUES = new JSONObject();
    private JSONObject PLOT_AO_JSON_OBJECT = new JSONObject();
    private List<Recommendation> recommendations;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plot_v2);

        Toolbar toolbar = setToolbar(getResources(R.string.plot_info));

        engine = new ScriptEngineManager().getEngineByName("rhino");


        plotName = (TextView) findViewById(R.id.plotName);
        plotSize = (TextView) findViewById(R.id.landSize);
        ph = (TextView) findViewById(R.id.ph);
        estimatedProductionSize = (TextView) findViewById(R.id.estimatedProductionSize);

        recommendedIntervention = findViewById(R.id.recommended_intervention);
        limeNeeded = findViewById(R.id.lime_needed);

        recommendationProgress = findViewById(R.id.recommendationProgress);


        plot = new Gson().fromJson(getIntent().getStringExtra("plot"), RealPlot.class);


        if (plot != null) {

            plotName.setText(plot.getName());

            String plotInfo = plot.getPlotInformationJson();


            try {
                JSONObject jsonObject = new JSONObject(plotInfo);

                plotSize.setText(jsonObject.get("size").toString());
                estimatedProductionSize.setText(jsonObject.get("estimatedProduction").toString());
                ph.setText(jsonObject.get("ph").toString());

                AI_VALUES = new JSONObject(plot.getAdditionalInterventionJson());
                AOR_VALUES = new JSONObject(plot.getAdoptionObservationResultsJson());
                PLOT_AO_JSON_OBJECT = new JSONObject(plot.getAdoptionObservationsJson());

                String limeNeededValue = AI_VALUES.get(databaseHelper.getQuestionIdByTranslationName("Lime need")).toString();

                Log.i(TAG, "^^^^^^^^^^^^ LIME NEED ^^^^^^^^^^^^^^^" + limeNeededValue);


                if (limeNeededValue.equalsIgnoreCase("yes")) {
                    limeNeeded.setText(limeNeededValue);
                    limeNeeded.setTextColor(ContextCompat.getColor(this, R.color.cpb_red));

                } else {

                    limeNeeded.setText("No");
                    limeNeeded.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                }


                Log.i(TAG, "AO VALUES =  " + PLOT_AO_JSON_OBJECT);
                Log.i(TAG, "AOR VALUES =  " + AOR_VALUES);
                Log.i(TAG, "AI VALUES =  " + AI_VALUES);


            } catch (JSONException e) {
                e.printStackTrace();
            }


            Log.i("ACTION TYPE", prefs.getString("flag", ""));
            if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

                //Todo add the rest of the views to hide

                findViewById(R.id.editButton).setVisibility(View.GONE);

                plotAOFragment = MyFormFragment.newInstance(Constants.ADOPTION_OBSERVATIONS, true, plot.getFarmerCode() + "_" + plot.getId(), true);


            } else {

                plotAOFragment = MyFormFragment.newInstance(Constants.ADOPTION_OBSERVATIONS, true, plot.getFarmerCode() + "_" + plot.getId(), true);


            }

            loadDynamicView(plotAOFragment, R.id.aosLayout);


            if (prefs.getBoolean("shouldReapplyRecommendation", true)) {


                recommendedIntervention.setText("");
                recommendationProgress.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        loadRecommendation();

                    }
                }, 2000);
            } else {
                Log.i(TAG, "GETTING RECOMMENDATION FROM DB");

                String ids = plot.getRecommendationId();

                if (ids != null)
                    if (!ids.equalsIgnoreCase("null") && !ids.equalsIgnoreCase("empty") && !ids.isEmpty()) {
                        String[] GAPS_PLOT_RECOMMENDATION_IDS = ids.split(",");

                        Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
                        Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);

                        String recNames = "";
                        if (!GAPS_RECOMENDATION_FOR_START_YEAR.getName().equalsIgnoreCase(PLOT_RECOMMENDATION.getName()))
                            recNames = GAPS_RECOMENDATION_FOR_START_YEAR.getName() + ", " + PLOT_RECOMMENDATION.getName();
                        else
                            recNames = GAPS_RECOMENDATION_FOR_START_YEAR.getName();


                        recommendedIntervention.setText(recNames);
                        recommendedIntervention.setTextColor(ContextCompat.getColor(PlotDetailsActivity.this, R.color.colorAccent));

                    } else recommendedIntervention.setText("--");


            }


        }


        findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Todo go to add edit plot activity, set plot parameters

                Intent intent = new Intent(PlotDetailsActivity.this, AddNewPlotActivity.class);
                intent.putExtra("flag", "edit");
                intent.putExtra("plot", new Gson().toJson(plot));

                startActivity(intent);
                finish();

            }
        });


        onBackClicked();


    }


    void loadRecommendation() {

        Log.i("\n\n" + TAG, "############    REAPPLYING LOGIC TO RECOMMENDATION    ##################\n\n");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                recommendations = databaseHelper.getAllRecommendations();

              /*  try {
                    PLOT_AO_JSON_OBJECT = new JSONObject(databaseHelper.getFarmerPlotAdoptionObservationJson(plot.getFarmerCode() + "_" + plot.getId()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                Log.i(TAG, "AO VALUES =  " + PLOT_AO_JSON_OBJECT);
                Log.i(TAG, "AOR VALUES =  " + AOR_VALUES);
                Log.i(TAG, "AI VALUES =  " + AI_VALUES);


                int sizeOfAO = databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATIONS).size();
                boolean hasIncompleteData = false;

                Iterator iterator = PLOT_AO_JSON_OBJECT.keys();
                while (iterator.hasNext()){
                    String tmp_key = (String) iterator.next();

                    try {
                        if(PLOT_AO_JSON_OBJECT.getString(tmp_key).equalsIgnoreCase("--")){
                            hasIncompleteData = true;
                            break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }



                if (PLOT_AO_JSON_OBJECT.length() >= sizeOfAO && !hasIncompleteData) {

                    Log.i(TAG, "START YEAR IS " + plot.getStartYear());


                    Recommendation PLOT_RECOMMENDATION = null;
                    Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = null;


                    for (Recommendation rec : recommendations) {

                        Log.i("\n\n" + TAG, "@@@@@@@@@@@     RECOMMENDATION NAME  " + rec.getName() + "   @@@@@@@@@@@");
                        Log.i(TAG, "\n\n@@@@@@@@@@@     HIERARCHY   " + rec.getHierarchy() + "   @@@@@@@@@@@\n\n");

                        if (!rec.getHierarchy().equals("0")) {


                            Boolean logicResult = compareAndEvaluateCascadedLogics(databaseHelper.getLogic(rec.getLogicId()));

                            if (logicResult != null && logicResult) {


                                if (rec.getName().equalsIgnoreCase("replant") || rec.getName().equalsIgnoreCase("replant + extra soil"))
                                    GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Minimal GAPs");

                                else if (rec.getName().equalsIgnoreCase("grafting") || rec.getName().equalsIgnoreCase("grafting + extra soil"))
                                    GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Modest GAPs");
                                else
                                    GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Maintenance (GAPs)");

                                PLOT_RECOMMENDATION = rec;

                                break;
                            }

                        }
                    }


                    if (GAPS_RECOMENDATION_FOR_START_YEAR == null)
                        GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendationBasedOnName("Maintenance (GAPs)");

                    if (PLOT_RECOMMENDATION == null)
                        PLOT_RECOMMENDATION = databaseHelper.getRecommendationBasedOnName("Maintenance (GAPs)");


                    Log.i(TAG, "\n\n");
                    Log.i(TAG, "GAPS for this plot is " + GAPS_RECOMENDATION_FOR_START_YEAR.getName());
                    Log.i(TAG, "Plot recommendation is " + PLOT_RECOMMENDATION.getName());


                    Log.i(TAG, "\n\n");

                    if (databaseHelper.editFarmerPlotRecommendationId(
                            plot.getFarmerCode(),
                            plot.getId(),
                            GAPS_RECOMENDATION_FOR_START_YEAR.getId() + "," + PLOT_RECOMMENDATION.getId())
                            ) {

                        databaseHelper.editPlotStartYear(plot.getId(), 1);


                        final String recNames;
                        recNames = PLOT_RECOMMENDATION.getName();


                       /* if (GAPS_RECOMENDATION_FOR_START_YEAR.getName().equalsIgnoreCase(PLOT_RECOMMENDATION.getName()))
                            recNames = PLOT_RECOMMENDATION.getName();

                        else if(PLOT_RECOMMENDATION.getName().equalsIgnoreCase("no fdp"))
                            recNames = PLOT_RECOMMENDATION.getName();

                        else
                            recNames = GAPS_RECOMENDATION_FOR_START_YEAR.getName() + ", " + PLOT_RECOMMENDATION.getName();
*/




                        prefs.edit().putBoolean("shouldReapplyRecommendation", false).apply();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                recommendationProgress.setVisibility(View.GONE);
                                recommendedIntervention.setText(recNames);
                                recommendedIntervention.setTextColor(ContextCompat.getColor(PlotDetailsActivity.this, R.color.colorAccent));


                            }
                        });
                    }

                } else {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            recommendationProgress.setVisibility(View.GONE);
                            recommendedIntervention.setText("Please fill out all Adoption Observations data!");
                            recommendedIntervention.setTextColor(ContextCompat.getColor(PlotDetailsActivity.this, R.color.cpb_red));


                        }
                    });


                }

            }
        });

        thread.start();


    }


    Boolean getLogicValue(Logic logic) {


        if (logic == null)
            return null;

        else {
            if (logic.getQuestion10() != null && !logic.getQuestion10().equals("null")) {


                Log.i(TAG, "LOGIC WITH 10 QUESTIONS! WITH QUESTION !) VALUE = " + logic.getQuestion10() + "\n\n");

                if (logic.getQuestion10().equals(""))
                    return null;


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

                    String equation = ((((((((compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2))
                            + logic.getQuestionLogicOperation2() + compareValues(l3))
                            + logic.getQuestionLogicOperation3() + compareValues(l4))
                            + logic.getQuestionLogicOperation4() + compareValues(l5))
                            + logic.getQuestionLogicOperation5() + compareValues(l6))
                            + logic.getQuestionLogicOperation6() + compareValues(l7))
                            + logic.getQuestionLogicOperation7() + compareValues(l8))
                            + logic.getQuestionLogicOperation8() + compareValues(l9))
                            + logic.getQuestionLogicOperation9() + compareValues(l10);


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value + "\n");

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion9() != null && !logic.getQuestion9().equals("null")) {


                Log.i(TAG, "LOGIC WITH 9 QUESTIONS!\n\n");


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


                    String equation = ((((((((compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2))
                            + logic.getQuestionLogicOperation2() + compareValues(l3))
                            + logic.getQuestionLogicOperation3() + compareValues(l4))
                            + logic.getQuestionLogicOperation4() + compareValues(l5))
                            + logic.getQuestionLogicOperation5() + compareValues(l6))
                            + logic.getQuestionLogicOperation6() + compareValues(l7))
                            + logic.getQuestionLogicOperation7() + compareValues(l8))
                            + logic.getQuestionLogicOperation8() + compareValues(l9));


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion8() != null && !logic.getQuestion8().equals("null")) {


                Log.i(TAG, "LOGIC WITH 8 QUESTIONS!\n\n");


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


                    String equation = (
                            ((((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6))
                                    + logic.getQuestionLogicOperation6() + compareValues(l7))
                                    + logic.getQuestionLogicOperation7() + compareValues(l8)
                    );


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;

            } else if (logic.getQuestion7() != null && !logic.getQuestion7().equals("null")) {


                Log.i(TAG, "LOGIC WITH 7 QUESTIONS!\n\n");


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


                    String equation = (
                            (((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6))
                                    + logic.getQuestionLogicOperation6() + compareValues(l7)
                    );


                    System.out.println("  EQUATION  =  " + equation);


                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion6() != null && !logic.getQuestion6().equals("null")) {


                Log.i(TAG, "LOGIC WITH 6 QUESTIONS!\n\n");


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


                    String equation = (
                            ((((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5))
                                    + logic.getQuestionLogicOperation5() + compareValues(l6)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);

                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion5() != null && !logic.getQuestion5().equals("null")) {

                Log.i(TAG, "LOGIC WITH 5 QUESTIONS!\n\n");


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


                    String equation = (
                            (((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4))
                                    + logic.getQuestionLogicOperation4() + compareValues(l5)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion4() != null && !logic.getQuestion4().equals("null")) {

                Log.i(TAG, "LOGIC WITH 4 QUESTIONS!\n\n");


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


                    String equation = (
                            ((compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3))
                                    + logic.getQuestionLogicOperation3() + compareValues(l4)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion3() != null && !logic.getQuestion3().equals("null")) {


                Log.i(TAG, "LOGIC WITH 3 QUESTIONS!\n\n");


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


                    String equation = (
                            (compareValues(l1)
                                    + logic.getQuestionLogicOperation1() + compareValues(l2))
                                    + logic.getQuestionLogicOperation2() + compareValues(l3)
                    );


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion2() != null && !logic.getQuestion2().equals("null")) {

                Log.i(TAG, "LOGIC WITH 2 QUESTIONS!\n\n");


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

                    String equation = (compareValues(l1)
                            + logic.getQuestionLogicOperation1() + compareValues(l2));


                    System.out.println("  EQUATION  =  " + equation);

                    value = (Boolean) engine.eval(equation);


                    System.out.println("COMPARE QUESTION VALUES Object value: " + value);

                } catch (ScriptException e) {
                    e.printStackTrace();

                    value = null;
                }


                return value;


            } else if (logic.getQuestion1() != null && !logic.getQuestion1().equals("null")) {

                Log.i(TAG, "LOGIC WITH 1 QUESTIONS!\n\n");

                Logic l = new Logic();
                l.setQUESTION(logic.getQuestion1());
                l.setLOGICAL_OPERATOR(logic.getLogicalOperator1());
                l.setVALUE(logic.getValue1());

                return compareValues(l);

            } else
                return null;


        }
    }

    Boolean compareValues(Logic logic) {

        Boolean value = null;
        String inputValue = getAnswerValue2(logic.getQUESTION());
        Log.i(TAG, "EQUATION IS    ");


        Log.i(TAG, inputValue + "  " + logic.getLOGICAL_OPERATOR() + "  " + logic.getVALUE() + "\n\n");


        if (inputValue != null) {

            try {
                Double.parseDouble(inputValue.trim());

                value = (Boolean) engine.eval(inputValue + logic.getLOGICAL_OPERATOR() + logic.getVALUE());

                return value;

            } catch (ScriptException | NumberFormatException e) {

                System.out.println("**********EXCEPTION******************" + e.getMessage());

                value = inputValue.equalsIgnoreCase(logic.getVALUE());
                return value;
            } finally {
                System.out.println("*****************************LOGIC VALUE IS: " + value);

            }
        } else return null;


    }



    Boolean compareAndEvaluateCascadedLogics(Logic logic) {


        StringBuilder equation = new StringBuilder();

        String equationValue = "";


        Log.i("\n" + TAG, "------ CASCADED LOGICS  ------- \n");

        //level 1
        Log.i(TAG, " ------  LEVEL 1  ------- ");
        Boolean value1 = getLogicValue(logic);
        Log.i(TAG, "\n");
        Log.i(TAG, " Value  " + value1);
        Log.i(TAG, "\n");


        //level 2
        Log.i(TAG, " ------  LEVEL 2  ------- ");
        Log.i(TAG, "\n");


        Logic logic2 = databaseHelper.getLogic(logic.getParentLogic());
        Boolean value2 = getLogicValue(logic2);
        Log.i(TAG, "\n");
        Log.i(TAG, " Value  " + value2);
        Log.i(TAG, "\n");


        //level 3
        Log.i(TAG, " ------  LEVEL 3  ------- ");
        Log.i(TAG, "\n");

        Logic logic3 = databaseHelper.getLogic(logic2.getParentLogic());
        Boolean value3 = getLogicValue(logic3);

        Log.i(TAG, "\n");

        Log.i(TAG, " Value  " + value3);
        Log.i(TAG, "\n");


        //level 4
        Log.i(TAG, " ------  LEVEL 4  ------- ");
        Log.i(TAG, "\n");


        Logic logic4 = databaseHelper.getLogic(logic3.getParentLogic());
        Boolean value4 = getLogicValue(logic4);
        Log.i(TAG, "\n");

        Log.i(TAG, " Value  " + value4);
        Log.i(TAG, "\n");


        //level 5
        Log.i(TAG, " ------  LEVEL 5  ------- ");
        Log.i(TAG, "\n");


        Logic logic5 = databaseHelper.getLogic(logic4.getParentLogic());
        Boolean value5 = getLogicValue(logic5);
        Log.i(TAG, "\n");

        Log.i(TAG, " Value  " + value5);
        Log.i(TAG, "\n");


        equation.append(value1)
                .append(logic.getParentLogicalOperator())
                .append(value2).append(logic2.getParentLogicalOperator())
                .append(value3).append(logic3.getParentLogicalOperator())
                .append(value4).append(logic4.getParentLogicalOperator())
                .append(value5);


        equationValue = equation.toString().replace("null", "");


        Log.i(TAG, "STRING BUILDER EQUATION IS " + equation.toString());
        Log.i(TAG, "FILTERED EQUATION IS " + equationValue);


        Boolean value = null;


        try {

            value = (Boolean) engine.eval(equationValue);


        } catch (ScriptException e) {
            System.out.println("*****  Exception  *****   " + e.getMessage());


        } finally {
            System.out.println("************  LOGIC VALUE IS: " + value);

        }
        return value;


    }

    String getAnswerValue2(String s) {

        String defVal = "--";
        try {
            defVal = PLOT_AO_JSON_OBJECT.getString(s);
        } catch (JSONException e) {
            Log.i(TAG, e.getMessage());
            try {
                defVal = AOR_VALUES.getString(s);

            } catch (JSONException f) {
                Log.i(TAG, f.getMessage());
                try {
                    defVal = AI_VALUES.getString(s);
                } catch (JSONException g) {
                    Log.i(TAG, g.getMessage());
                }
            }
        }

        return defVal;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }




}
