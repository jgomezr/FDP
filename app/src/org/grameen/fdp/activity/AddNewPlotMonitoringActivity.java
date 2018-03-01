package org.grameen.fdp.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.MonitoringFormFragment;
import org.grameen.fdp.fragment.MyFormFragment;
import org.grameen.fdp.object.ComplexCalculation;
import org.grameen.fdp.object.Logic;
import org.grameen.fdp.object.Monitoring;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.Recommendation;
import org.grameen.fdp.object.SkipLogic;
import org.grameen.fdp.utility.Callbacks;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.MyFormController;
import org.json.JSONException;
import org.json.JSONObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class AddNewPlotMonitoringActivity extends BaseActivity implements Callbacks.AnItemSelectedListener{

    String TAG = "PLOT DETAILS ACTIVITY";
    RealPlot plot;
    MonitoringFormFragment plotMonitoringAOFragment;
    TextView plotName;
    TextView plotSize;
    TextView ph;
    TextView estimatedProductionSize;
    TextView recommendedIntervention;


    ProgressBar recommendationProgress;
    
    List <View> ALL_VIEWS_LIST = new ArrayList<>();
    private List<Recommendation> recommendations;

    List<Question> aoMonitoringQuestions;

    Boolean IS_NEW_MONITORING;
    String selectedYear = "";
    int SELECTED_MONITORING_ID;
    private Toolbar toolbar;

    ViewGroup monitoringAOLayout;
    List<View> COMPETENCE_VIEWS = new ArrayList<>();

    JSONObject ALL_MONITORING_VALUES_JSON;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_plot_monitoring);

        engine = new ScriptEngineManager().getEngineByName("rhino");

        monitoringAOLayout = findViewById(R.id.monitoringAOLayout);
        monitoringAOLayout.setVisibility(View.INVISIBLE);

        plotName = (TextView) findViewById(R.id.plotName);
        plotSize = (TextView) findViewById(R.id.landSize);
        ph = (TextView) findViewById(R.id.ph);
        estimatedProductionSize = (TextView) findViewById(R.id.estimatedProductionSize);

        recommendedIntervention = findViewById(R.id.recommended_intervention);
        recommendationProgress = findViewById(R.id.recommendationProgress);

        aoMonitoringQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.AO_MONITORING);

        plot = new Gson().fromJson(getIntent().getStringExtra("plot"), RealPlot.class);

        MonitoringFormFragment.setMyItemSelectedListener(this);


        if (plot != null) {
            plotName.setText(plot.getName());

            String plotInfo = plot.getPlotInformationJson();


            try {
                JSONObject jsonObject = new JSONObject(plotInfo);

                plotSize.setText(jsonObject.get("size").toString());
                estimatedProductionSize.setText(jsonObject.get("estimatedProduction").toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }



            String[] GAPS_PLOT_RECOMMENDATION_IDS = plot.getRecommendationId().split(",");

            Recommendation GAPS_RECOMENDATION_FOR_START_YEAR = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[0]);
            Recommendation PLOT_RECOMMENDATION = databaseHelper.getRecommendation(GAPS_PLOT_RECOMMENDATION_IDS[1]);


            String value;

            if(!PLOT_RECOMMENDATION.getName().equalsIgnoreCase(GAPS_RECOMENDATION_FOR_START_YEAR.getName()))
             value = PLOT_RECOMMENDATION.getName() + ", " + GAPS_RECOMENDATION_FOR_START_YEAR.getName();
            else
                value = PLOT_RECOMMENDATION.getName();

            recommendedIntervention.setText(value);





            IS_NEW_MONITORING = getIntent().getBooleanExtra("isNewMonitoring", false);
            selectedYear = String.valueOf(getIntent().getIntExtra("year", -1));



            if(IS_NEW_MONITORING){

                toolbar = setToolbar(getResources(R.string.add_plot_monitoring));

                  SELECTED_MONITORING_ID = databaseHelper.getAllPlotMonitoringForYear(plot.getId(), selectedYear).size() + 1;


                ALL_MONITORING_VALUES_JSON = new JSONObject();




           plotMonitoringAOFragment = MonitoringFormFragment.newInstance(false,null, false);



            }else {
                SELECTED_MONITORING_ID = getIntent().getIntExtra("monitoringId", -1);
                toolbar = setToolbar(getResources(R.string.edit_plot_monitoring) + SELECTED_MONITORING_ID);



                //Todo get ALL MONITORING JSON OBJECT FROM DB, send to fragment
                Monitoring monitoring = databaseHelper.getPlotMonitoring(SELECTED_MONITORING_ID, plot.getId(), selectedYear);


                try {
                    ALL_MONITORING_VALUES_JSON  = new JSONObject(monitoring.getJson());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                plotMonitoringAOFragment = MonitoringFormFragment.newInstance(true, monitoring.getJson(), false);


            }





            loadDynamicView(plotMonitoringAOFragment, R.id.aosLayout);





        }


        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(saveData()) {

                    int year = Integer.parseInt(selectedYear);
                    int oldYear = prefs.getInt(plot.getFarmerCode(), -1);

                    if (!Objects.equals(oldYear, year)) {

                        if (year > oldYear)
                            prefs.edit().putInt(plot.getFarmerCode(), year).apply();

                    }

                    //Todo go to plot activity, reload vp

                    prefs.edit().putBoolean("refreshViewPager", true).apply();
                    finish();

              /*  Intent intent = new Intent(AddNewPlotMonitoringActivity.this, AddNewPlotActivity.class);
                intent.putExtra("flag", "edit");
                intent.putExtra("plot", new Gson().toJson(plot));

                startActivity(intent);
                finish();*/


                }




            }
        });


        onBackClicked();




        new Thread(new Runnable() {
            @Override
            public void run() {


                for(final Question q : aoMonitoringQuestions) {
                    q.setOptions__c(q.getOptions__c() + ",Select");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addViewsDynamically(q);

                        }
                    });
                }

                monitoringAOLayout.setVisibility(View.VISIBLE);


            }
        }).start();




        if(!IS_NEW_MONITORING)
        initiateSkipLogicsAndHideViews(aoMonitoringQuestions);




    }


/*
    String getAnswerValue(String s) {

        String defVal = "--";

            try {
                defVal = ALL_MONITORING_VALUES_JSON.get(s).toString();

            } catch (JSONException e) {

                Log.i(TAG, e.getMessage());


            }


        return defVal;
    }*/


    void addViewsDynamically(Question q){


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        labelParams.weight = 4;
        labelParams.gravity = Gravity.CENTER;

        View labelView = getViewAtLabel(q);
        linearLayout.addView(labelView, labelParams);

        ALL_VIEWS_LIST.add(labelView);




        LinearLayout.LayoutParams aoParam = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        aoParam.weight = 2;
        aoParam.gravity = Gravity.CENTER;
        aoParam.leftMargin = 10;
        aoParam.rightMargin = 10;

        View AOView = getAOView(q);
        linearLayout.addView(AOView, aoParam);
        ALL_VIEWS_LIST.add(AOView);





        String values[] = q.getRelated_Questions__c().split(",");
        String competenceName = values[0];
        String reasonForFailureName = values[1];


         LinearLayout.LayoutParams competenceParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        competenceParams.weight = 2;
        competenceParams.gravity = Gravity.CENTER;
        competenceParams.leftMargin = 10;
        competenceParams.rightMargin = 10;

        View competenceView = getCompetenceView(databaseHelper.getQuestionByName(competenceName));
        linearLayout.addView(competenceView, competenceParams);
        
        ALL_VIEWS_LIST.add(competenceView);
        COMPETENCE_VIEWS.add(competenceView);
        


        LinearLayout.LayoutParams reasonForFailureParam = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        reasonForFailureParam.weight = 3;
        reasonForFailureParam.gravity = Gravity.CENTER;
        reasonForFailureParam.leftMargin = 10;
        reasonForFailureParam.rightMargin = 10;

        View failureView = getReasonForFailureView(databaseHelper.getQuestionByName(reasonForFailureName));
        linearLayout.addView(failureView, reasonForFailureParam);
        ALL_VIEWS_LIST.add(failureView);


        monitoringAOLayout.addView(linearLayout);

    }
    View getViewAtLabel(Question q){
        View view;


        TextView textView = new TextView(this);
        textView.setText(q.getCaption__c());
        textView.setTextSize(12);
        textView.setTag(q.getId());
        textView.setPadding(10, 10, 10, 10);
        view = textView;
        return view;
    }
    View getAOView(final Question q){

        final View view;

        if(q.getType__c().equalsIgnoreCase(Constants.TYPE_NUMBER)){


            EditText editText = new EditText(this);
            editText.setHint(getValue(q.getId(), ALL_MONITORING_VALUES_JSON));
            editText.setTextSize(12);
            editText.setTag(q.getId());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setPadding(10, 10, 10, 10);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {


                    try {

                        if(ALL_MONITORING_VALUES_JSON.has(q.getId())) {
                            ALL_MONITORING_VALUES_JSON.remove(q.getId());
                            ALL_MONITORING_VALUES_JSON.put(q.getId(), s.toString());

                        }else  ALL_MONITORING_VALUES_JSON.put(q.getId(), s.toString());




                        setUpSkipLogics(q, s.toString());





                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
            view = editText;

        }else {

            final List<String>items = q.formatQuestionOptions();



            final Spinner spinner = new Spinner(this);
            spinner.setPrompt("Select");
            spinner.setTag(q.getId());

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(AddNewPlotMonitoringActivity.this, android.R.layout.simple_spinner_item, items) {
                @NonNull
                @Override
                public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    if (position == getCount()) {
                        TextView itemView = ((TextView) view.findViewById(android.R.id.text1));
                        itemView.setText("");
                        itemView.setHint(getItem(getCount()));
                    }
                    return view;
                }

                @Override
                public int getCount() {
                    return super.getCount() - 1; // don't display last item (it's used for the prompt)
                }
            };
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                    if (pos != items.size() - 1) {
                        try {

                            if (ALL_MONITORING_VALUES_JSON.has(q.getId())) {
                                ALL_MONITORING_VALUES_JSON.remove(q.getId());
                                ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());

                            } else
                                ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());


                            setUpSkipLogics(q, parent.getSelectedItem().toString());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.i(TAG, "ALL JSON IS " + ALL_MONITORING_VALUES_JSON.toString());
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {


                }
            });

            spinner.setSelection(items.size() - 1);
            refresh(spinner, getValue(q.getId(), ALL_MONITORING_VALUES_JSON), items);

            view = spinner;


        }

        return view;
    }
    View getCompetenceView(final Question q){
        View view;
        q.setOptions__c(q.getOptions__c() + ", Select");
        final List<String>items = q.formatQuestionOptions();

        final Spinner spinner = new Spinner(this);
        spinner.setPrompt("Select");
        spinner.setTag(q.getId());

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(AddNewPlotMonitoringActivity.this, android.R.layout.simple_spinner_item, items) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                if (position == getCount()) {
                    TextView itemView = ((TextView) view.findViewById(android.R.id.text1));
                    itemView.setText("");
                    itemView.setHint(getItem(getCount()));
                }
                return view;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // don't display last item (it's used for the prompt)
            }
        };
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                if (pos != items.size() - 1) {
                    try {

                        if (ALL_MONITORING_VALUES_JSON.has(q.getId())) {
                            ALL_MONITORING_VALUES_JSON.remove(q.getId());
                            ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());

                        } else
                            ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());

                        setUpSkipLogics(q, parent.getSelectedItem().toString());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.i(TAG, "ALL JSON IS " + ALL_MONITORING_VALUES_JSON.toString());
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        spinner.setSelection(items.size() - 1);
        refresh(spinner, getValue(q.getId(), ALL_MONITORING_VALUES_JSON), items);

        view = spinner;

        return view;
    }



    View getReasonForFailureView(final Question q){

        View view;
        q.setOptions__c(q.getOptions__c() + ", Select");

        final List<String>items = q.formatQuestionOptions();

        final Spinner spinner = new Spinner(this);
        spinner.setPrompt("Select");
        spinner.setTag(q.getId());

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(AddNewPlotMonitoringActivity.this, android.R.layout.simple_spinner_item, items) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                if (position == getCount()) {
                    TextView itemView = ((TextView) view.findViewById(android.R.id.text1));
                    itemView.setText("");
                    itemView.setHint(getItem(getCount()));
                }
                return view;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // don't display last item (it's used for the prompt)
            }
        };
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                if (pos != items.size() - 1) {
                    try {

                        if (ALL_MONITORING_VALUES_JSON.has(q.getId())) {
                            ALL_MONITORING_VALUES_JSON.remove(q.getId());
                            ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());

                        } else
                            ALL_MONITORING_VALUES_JSON.put(q.getId(), parent.getSelectedItem().toString());


                        setUpSkipLogics(q, parent.getSelectedItem().toString());



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.i(TAG, "ALL JSON IS " + ALL_MONITORING_VALUES_JSON.toString());
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        spinner.setSelection(items.size() - 1);
        refresh(spinner, getValue(q.getId(), ALL_MONITORING_VALUES_JSON), items);

        view = spinner;

        return view;
    }




    private void refresh(Spinner spinner, @Nullable String defValue, List<String>items ) {
         int selectionIndex = items.size() - 1;    // index of last item shows the 'prompt'



        if(defValue != null && !defValue.equals("--") && !defValue.equals("Select"))
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(defValue)) {
                    selectionIndex = i;
                    break;
                }

        }

        spinner.setSelection(selectionIndex);
    }


    public void putDynamicAnswersInMainJson() {

        for (Question q : plotMonitoringAOFragment.getQuestions()) {


            try {

                if(ALL_MONITORING_VALUES_JSON.has(q.getId())) {

                    ALL_MONITORING_VALUES_JSON.remove(q.getId());
                    ALL_MONITORING_VALUES_JSON.put(q.getId(), plotMonitoringAOFragment.getModel().getValue(q.getId()));

                }else
                    ALL_MONITORING_VALUES_JSON.put(q.getId(), plotMonitoringAOFragment.getModel().getValue(q.getId()));




            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        String valueAfterEvaluation = Constants.NO_MONITORING_PLACE_HOLDER;


        //Apply logic and get monitoring result, insert in json
        List<Question> monitoringResultsQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.AO_MONITORING_RESULT);

        for(Question q : monitoringResultsQuestions){


            if(q.getType__c().equalsIgnoreCase(Constants.TYPE_LOGIC_FORMULA)) {

                List<Logic> logics = databaseHelper.getLogics(q.getId());
                for (Logic logic : logics) {

                    Boolean value = compareAndEvaluateCascadedLogics(logic);

                    if (value != null && value) {
                        valueAfterEvaluation = logic.getResult();

                        Log.i(TAG, "LOGIC " + logic.getName() + " EVALUATED TO TRUE WITH RESULT VALUE " + valueAfterEvaluation);
                        break;

                    }
                }

            }else if (q.getType__c().equalsIgnoreCase(Constants.TYPE_COMPLEX_CALCULATION)) {

                ComplexCalculation  cc =   databaseHelper.getComplexCalculation(q.getId());

                if(cc != null)
                valueAfterEvaluation = parseIfFormula(cc.getCondition(), ALL_MONITORING_VALUES_JSON);

            }

                try {

                    if(ALL_MONITORING_VALUES_JSON.has(q.getId())) {

                        ALL_MONITORING_VALUES_JSON.remove(q.getId());
                        ALL_MONITORING_VALUES_JSON.put(q.getId(), valueAfterEvaluation);

                    }else  ALL_MONITORING_VALUES_JSON.put(q.getId(), valueAfterEvaluation);

                } catch (JSONException e) {
                    e.printStackTrace();
            }
        }
    }


    Boolean saveData(){

        Boolean value = false;

        putDynamicAnswersInMainJson();





        Log.i(TAG, "TOTAL JSON IS " + ALL_MONITORING_VALUES_JSON.toString());


        if(IS_NEW_MONITORING){

            Monitoring monitoring = new Monitoring();
            monitoring.setId(String.valueOf(SELECTED_MONITORING_ID));
            monitoring.setName("Monitoring " + SELECTED_MONITORING_ID);
            monitoring.setPlotId(plot.getId());
            monitoring.setJson(ALL_MONITORING_VALUES_JSON.toString());

            if(databaseHelper.addPlotMonitoring(monitoring, selectedYear)){
                value = true;

                CustomToast.makeToast(this, getResources(R.string.data_saved), Toast.LENGTH_SHORT).show();


            }else CustomToast.makeToast(this, getResources(R.string.data_not_saved), Toast.LENGTH_SHORT).show();



        }else{


            if(databaseHelper.editPlotMonitoringJson(String.valueOf(SELECTED_MONITORING_ID), plot.getId(), selectedYear, ALL_MONITORING_VALUES_JSON.toString())){
                value = true;

                CustomToast.makeToast(this, getResources(R.string.data_saved), Toast.LENGTH_SHORT).show();


            }else CustomToast.makeToast(this, getResources(R.string.data_not_saved), Toast.LENGTH_SHORT).show();


        }

        return value;

    }

    void setUpSkipLogics(Question q, String value) {


        final List<SkipLogic> skipLogics = databaseHelper.doesQuestionHaveSkipLogics(q.getId());

        if (skipLogics != null && skipLogics.size() > 0) {

            Log.i("SKIP LOCIC ", "SIZE FOR QUESTION " + q.getCaption__c() + " = " + skipLogics.size());

            final String caption = q.getCaption__c();
            Boolean skipLogicValue = null;

                    Log.i("PROPERTY CHANGE ", " FOR QUESTION " + caption + "Value is : " + value);

                    for (SkipLogic sl : skipLogics) {


                        try {
                            if (compareValues(sl, String.valueOf(value))) {
                                skipLogicValue = true;


                                if (sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE)) {

                                    Log.i("PROPERTY CHANGE ", "Looping... ");

                                    for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                        if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                            ALL_VIEWS_LIST.get(i).setVisibility(View.INVISIBLE);
                                            ALL_VIEWS_LIST.get(i).setEnabled(false);


                                            break;
                                        }
                                    }


                                }

                                else {
                                    for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                        if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                            ALL_VIEWS_LIST.get(i).setVisibility(View.VISIBLE);
                                            ALL_VIEWS_LIST.get(i).setEnabled(true);

                                            break;
                                        }
                                    }

                                }

                            } else {

                                if(skipLogicValue != null && skipLogicValue)
                                    break;


                                for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                    if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                        ALL_VIEWS_LIST.get(i).setVisibility(View.VISIBLE);
                                        ALL_VIEWS_LIST.get(i).setEnabled(true);

                                        break;
                                    }
                                }

/*
                                if (sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE)) {
                                    for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                        if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                            ALL_VIEWS_LIST.get(i).setVisibility(View.VISIBLE);
                                            ALL_VIEWS_LIST.get(i).setEnabled(true);

                                            break;
                                        }
                                    }
                                }
                                else {

                                    for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                        if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                            ALL_VIEWS_LIST.get(i).setVisibility(View.INVISIBLE);
                                            ALL_VIEWS_LIST.get(i).setEnabled(false);

                                            break;
                                        }
                                    }

                                }*/
                            }


                        } catch (Exception ignored) {
                            //skipLogicValue = false;
                        }

                       /* if(skipLogicValue != null && skipLogicValue)
                            break;*/
                    }


        }
    }

    void initiateSkipLogicsAndHideViews(List<Question> questions) {

        Log.i(TAG, "INITIALIZING SKIP LOGIC >> QUESTIONS SIZE IS " + questions.size());


        for (Question q : questions) {

            final List<SkipLogic> skipLogics = databaseHelper.doesQuestionHaveSkipLogics(q.getId());

            if (skipLogics != null && skipLogics.size() > 0) {


                final String caption = q.getCaption__c();

                Log.i(TAG, "Size of Skip Logic is " + skipLogics.size());


                for (final SkipLogic sl : skipLogics) {


                    try {
                        if (compareValues(sl, getValue(q.getId(), ALL_MONITORING_VALUES_JSON))) {


                            if (sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE)) {

                                Log.i("PROPERTY CHANGE ", "Looping... ");

                                for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                    if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                        ALL_VIEWS_LIST.get(i).setVisibility(View.INVISIBLE);
                                        ALL_VIEWS_LIST.get(i).setEnabled(false);


                                        break;
                                    }
                                }


                            }

                            else {
                                for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                    if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                        ALL_VIEWS_LIST.get(i).setVisibility(View.VISIBLE);
                                        ALL_VIEWS_LIST.get(i).setEnabled(true);

                                        break;
                                    }
                                }

                            }

                        } else {

                            if (sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE)) {
                                for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                    if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                        ALL_VIEWS_LIST.get(i).setVisibility(View.VISIBLE);
                                        ALL_VIEWS_LIST.get(i).setEnabled(true);

                                        break;
                                    }
                                }
                            }
                            else {

                                for(int i = 0; i < ALL_VIEWS_LIST.size(); i++){

                                    if(ALL_VIEWS_LIST.get(i).getTag().equals(sl.getQuestionShowHide())) {
                                        ALL_VIEWS_LIST.get(i).setVisibility(View.INVISIBLE);
                                        ALL_VIEWS_LIST.get(i).setEnabled(false);

                                        break;
                                    }
                                }

                            }
                        }


                    } catch (Exception ignored) {
                    }

                }
            }


        }
    }

    Boolean getLogicValue(Logic logic) {


        if (logic == null)
            return null;

        else {

            Log.i(TAG, "<<<<<<<<<<  LOGIC NAME IS = " + logic.getName() + ">>>>>>>>>>>>>>\n");



            if (logic.getQuestion10() != null && !logic.getQuestion10().equals("null")) {


                Log.i(TAG, "LOGIC WITH 10 QUESTIONS WITH QUESTION VALUE = " + logic.getQuestion10() + "\n\n");

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
        String inputValue = getValue(logic.getQUESTION(), ALL_MONITORING_VALUES_JSON);
        Log.i(TAG, "EQUATION IS    ");


        Log.i(TAG, inputValue + "  " + logic.getLOGICAL_OPERATOR() + "  " + logic.getVALUE() + "\n\n");


        if (inputValue != null) {

            try {
                Double.parseDouble(inputValue.trim());

                value = (Boolean) engine.eval(inputValue + logic.getLOGICAL_OPERATOR() + logic.getVALUE());

                return value;

            } catch (ScriptException | NumberFormatException e) {

                System.out.println("**********  EXCEPTION ******************" + e.getMessage());




                if(logic.getLOGICAL_OPERATOR().equalsIgnoreCase("=="))
                    value = inputValue.equalsIgnoreCase(logic.getVALUE());
                else value = !inputValue.equalsIgnoreCase(logic.getVALUE());



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

    @Override
    public void onItemSelected(String item) {


        Log.i(TAG, "*********** &&&&&&&& ***********  SELECTED ITEM IS " + item);


        if(item != null)
            if(item.equalsIgnoreCase("manager")){

                for(int i = 0; i < COMPETENCE_VIEWS.size(); i++){

                        COMPETENCE_VIEWS.get(i).setVisibility(View.VISIBLE);
                        COMPETENCE_VIEWS.get(i).setEnabled(true);

                }


            }else if(item.equalsIgnoreCase("coach")){

                for(int i = 0; i < COMPETENCE_VIEWS.size(); i++){

                    COMPETENCE_VIEWS.get(i).setVisibility(View.INVISIBLE);
                    COMPETENCE_VIEWS.get(i).setEnabled(false);

                }





            }

    }




}
