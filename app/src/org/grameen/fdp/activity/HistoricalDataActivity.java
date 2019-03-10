package org.grameen.fdp.activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.HistoricalTableDataAdapter;
import org.grameen.fdp.adapter.HistoricalTableHeaderAdapter;
import org.grameen.fdp.adapter.HistoricalTableViewPagerAdapter;
import org.grameen.fdp.adapter.PlotMonitoringTableViewAdapter;
import org.grameen.fdp.object.Form;
import org.grameen.fdp.object.HistoricalData;
import org.grameen.fdp.object.HistoricalTableViewData;
import org.grameen.fdp.object.HistoricalViewPagerTableData;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;

/**
 * Created by AangJnr on 23, November, 2018 @ 10:59 AM
 * Work Mail cibrahim@grameenfoundation.org
 * Personal mail aang.jnr@gmail.com
 */

public class HistoricalDataActivity extends BaseActivity {


    int CURRENT_SELECTED_ITEM = 0;
    Button editCurrentData;
    Button addNewData;
    TextView farmerNameTV;
    TextView farmerCode;
    TextView formNameTV;
    TextView titleTV;
    ViewPager viewPager;

    boolean isTranslation;

    RealFarmer FARMER;
    Form FORM;
    private TableView diagnosticsTableView;

    List<Question> QUESTIONS;
    private JSONObject ANSWERS_JSON_OBJECT;

    List<HistoricalViewPagerTableData> historicalViewPagerTableDataList;
    List<HistoricalData> HISTORICAL_DATALIST = new ArrayList<>();
    HistoricalTableViewPagerAdapter historicalTableViewPagerAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_historical_view);

        isTranslation = prefs.getBoolean("toggleTranslation", false);
        prefs.edit().putBoolean("refreshViewPager", false).apply();


        if (getIntent() != null) {


            FARMER = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
            FORM = databaseHelper.getFormBasedOnId(getIntent().getStringExtra("formId"));

            Log.i("HISTORICAL DATA ACT", new Gson().toJson(FORM));

            QUESTIONS = databaseHelper.getSpecificSetOfQuestions(FORM.getName());


            Log.i("HISTORICAL DATA ACT", QUESTIONS.size() + "");

            String jsonValue = databaseHelper.getAllAnswersJson(FARMER.getId());

            try {
                ANSWERS_JSON_OBJECT = new JSONObject(jsonValue);
            } catch (JSONException ignore) {
                ANSWERS_JSON_OBJECT = new JSONObject();
            }
        }


        setUpViews();

        setupDiagnosticsTableView();


        new Thread(new Runnable() {
            @Override
            public void run() {

                setupViewPager();

            }
        }).start();


    }


    void setUpViews() {
        addNewData = findViewById(R.id.add_record);
        editCurrentData = findViewById(R.id.edit_record);
        farmerNameTV = findViewById(R.id.name);
        farmerCode = findViewById(R.id.code);
        formNameTV = findViewById(R.id.form_name);
        titleTV = findViewById(R.id.title_view);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(100, 0, 100, 0);
        viewPager.setPageMargin(40);


        farmerNameTV.setText(FARMER.getFarmerName());
        farmerCode.setText(FARMER.getCode());
        formNameTV.setText((isTranslation) ? FORM.getTranslation() : FORM.getDiaplayName());


        addNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(HistoricalDataActivity.this, AddEditHistoricalData.class);
                intent.putExtra("farmer", new Gson().toJson(FARMER));
                intent.putExtra("formName", FORM.getName());
                intent.putExtra("formId", FORM.getId());

                intent.putExtra("mode", Constants.RECORD_NEW);
                intent.putExtra("size", HISTORICAL_DATALIST.size());


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);

                    }
                }, 500);

            }
        });


        editCurrentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(HISTORICAL_DATALIST != null && HISTORICAL_DATALIST.size() > 0) {

                    final Intent intent = new Intent(HistoricalDataActivity.this, AddEditHistoricalData.class);
                    intent.putExtra("farmer", new Gson().toJson(FARMER));
                    intent.putExtra("formName", FORM.getName());
                    intent.putExtra("formId", FORM.getId());
                    intent.putExtra("mode", Constants.RECORD_EDIT);
                    intent.putExtra("size", HISTORICAL_DATALIST.size());
                    intent.putExtra("historicalData", new Gson().toJson(HISTORICAL_DATALIST.get(CURRENT_SELECTED_ITEM)));

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                        }
                    }, 500);

                }else{
                    CustomToast.makeToast(HistoricalDataActivity.this, "No data to edit!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void setupDiagnosticsTableView() {

        String[] TABLE_HEADERS = {getResources(R.string.questions), getResources(R.string.diagnostic)};
        diagnosticsTableView = findViewById(R.id.diagnostics_table_view);

       /* TableColumnWeightModel columnModel = new TableColumnWeightModel(diagnosticsTableView.getColumnCount());
        columnModel.setColumnWeight(0, 1);
        columnModel.setColumnWeight(1, 1);
        diagnosticsTableView.setColumnModel(columnModel);*/


        HistoricalTableHeaderAdapter headerAdapter = new HistoricalTableHeaderAdapter(this, TABLE_HEADERS);
        diagnosticsTableView.setHeaderAdapter(headerAdapter);


        List<List<String>> historicalTableViewDataList = new ArrayList<>();
        for (Question q : QUESTIONS) {

            List<String> values = new ArrayList<>();
            values.add((isTranslation) ? q.getTranslation__c() : q.getCaption__c());
            values.add(getValue(q.getId(), ANSWERS_JSON_OBJECT));

            //Todo get results
            historicalTableViewDataList.add(values);
        }


        HistoricalTableDataAdapter historicalTableDataAdapter = new HistoricalTableDataAdapter(this, historicalTableViewDataList, diagnosticsTableView);
        diagnosticsTableView.setDataAdapter(historicalTableDataAdapter);

    }

    private void setupViewPager() {
        historicalViewPagerTableDataList = new ArrayList<>();


        updateTableData();


        historicalTableViewPagerAdapter = new HistoricalTableViewPagerAdapter(this, historicalViewPagerTableDataList);


        if (historicalViewPagerTableDataList.size() > 0) {
            viewPager.setAdapter(historicalTableViewPagerAdapter);


            //titleTextView.setText(plotMonitoringTableDataList.get(0).getTitle());

            CURRENT_SELECTED_ITEM = 0;

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {


                    CURRENT_SELECTED_ITEM = position;
                    //titleTextView.setText(plotMonitoringTableDataList.get(position).getTitle());


                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            findViewById(R.id.place_holder).setVisibility(View.GONE);
            findViewById(R.id.edit_record).setVisibility(View.VISIBLE);

        } else {
            findViewById(R.id.place_holder).setVisibility(View.VISIBLE);
            findViewById(R.id.edit_record).setVisibility(View.GONE);
        }

    }

    void updateTableData() {
        HISTORICAL_DATALIST = databaseHelper.getAllHistoricalDataForForm(FORM.getId());

        for (HistoricalData historicalData : HISTORICAL_DATALIST) {


            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(historicalData.getAnswersJson());
            } catch (JSONException e) {
                e.printStackTrace();
                jsonObject = new JSONObject();
            }


            List<List<String>> historicalTableViewDataList = new ArrayList<>();


            for (Question q : QUESTIONS) {

                List<String> values = new ArrayList<>();
                values.add(getValue(q.getId(), jsonObject));

                historicalTableViewDataList.add(values);

            }


            historicalViewPagerTableDataList.add(new HistoricalViewPagerTableData(historicalData.getName() + "\t - " + historicalData.getDateTime(), historicalTableViewDataList));

        }
    }


    @Override
    public void onResume() {

        Log.i(TAG, "On RESUME");

        if (prefs.getBoolean("refreshViewPager", false)) {

            Log.i(TAG, "refreshViewPager");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {



                    if(findViewById(R.id.place_holder).getVisibility() == View.VISIBLE)
                        setupViewPager();
                    else
                        updateTableData();


                    if (historicalTableViewPagerAdapter != null) {

                        Log.i(TAG, "Changing dataset");

                        viewPager.removeAllViews();
                        viewPager.invalidate();

                        viewPager.setAdapter(null);


                        //historicalTableViewPagerAdapter = new HistoricalTableViewPagerAdapter(HistoricalDataActivity.this, historicalViewPagerTableDataList);
                        //viewPager.setAdapter(historicalTableViewPagerAdapter);

                        historicalTableViewPagerAdapter.setData(historicalViewPagerTableDataList);
                        historicalTableViewPagerAdapter.notifyDataSetChanged();
                        viewPager.setAdapter(historicalTableViewPagerAdapter);


                        viewPager.setCurrentItem(CURRENT_SELECTED_ITEM, true);

                    }
                    prefs.edit().putBoolean("refreshViewPager", false).apply();


                }
            }, 300);

        }

        super.onResume();

    }


}
