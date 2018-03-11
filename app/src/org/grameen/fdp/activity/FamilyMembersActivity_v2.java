package org.grameen.fdp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.evrencoskun.tableview.TableView;
import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.FineTableViewAdapter;
import org.grameen.fdp.object.Cell;
import org.grameen.fdp.object.ColumnHeader;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RowHeader;
import org.grameen.fdp.utility.Callbacks;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.TableViewListener;
import org.grameen.fdp.viewholder.CellViewHolder;
import org.grameen.fdp.viewholder.CheckBoxViewHolder;
import org.grameen.fdp.viewholder.SpinnerViewHolder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aangjnr on 08/02/2018.
 */

public class FamilyMembersActivity_v2 extends BaseActivity implements Callbacks.UpdateJsonArray{

    static  int COLUMN_SIZE;
    static int ROW_SIZE = 1;

    private List<RowHeader> mRowHeaderList;
    private List<ColumnHeader> mColumnHeaderList;
    private List<List<Cell>> mCellList;
    JSONObject ALL_ANSWERS_JSON_OBJECT;
    private List<List<Question>> mQuestionsList;


    // Columns indexes
    public static final int MOOD_COLUMN_INDEX = 3;
    public static final int GENDER_COLUMN_INDEX = 4;

    // Constant values for icons
    public static final int SAD = 0;
    public static final int HAPPY = 1;
    public static final int BOY = 0;
    public static final int GIRL = 1;

    TableView tableView;



    RealFarmer farmer;

    List<Question> INITIALIZED_QUESTIONS;

    Button save;

    JSONObject objMainList = new JSONObject();

    JSONArray jsonArray = new JSONArray();

    static JSONArray oldValuesArray ;

    String nameIdInFamilyMembersTable = "";


     private boolean monitoringMode = false;
    private FineTableViewAdapter mTableViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);


        tableView = findViewById(R.id.table_view);

        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

            //Todo add the rest of the views to hide
            monitoringMode = true;


        }

        save = findViewById(R.id.save);

        if(monitoringMode) {
             save.setVisibility(View.GONE);
        }

        nameIdInFamilyMembersTable = databaseHelper.getQuestionIdByTranslationName("Name");

        INITIALIZED_QUESTIONS = databaseHelper.getSpecificSetOfQuestions(Constants.FAMILY_MEMBERS);

        COLUMN_SIZE = INITIALIZED_QUESTIONS.size();

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        try {
            ROW_SIZE = Integer.parseInt(getIntent().getStringExtra("familyMembers"));
        }catch(Exception e){
            e.printStackTrace();
            ROW_SIZE = 1;
        }

        initData();


        for(int i = 0; i < ROW_SIZE; i++){

            JSONObject jsonObject = new JSONObject();
            try {
                jsonArray.put(i, jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.i(TAG, "JSON ARRAY IS " + jsonArray + " WITH SIZE " + jsonArray.length());


        Log.i("FM ACTIVITY", "NO FAM MEMBERS " +  ROW_SIZE );
        Log.i("FM ACTIVITY", "NO QUESTIONS " +  COLUMN_SIZE );




        if (farmer != null) {

            Toolbar toolbar = setToolbar(getResources(R.string.family_members));

            TextView name = findViewById(R.id.name);
            TextView code = findViewById(R.id.code);

            name.setText(farmer.getFarmerName());
            code.setText(farmer.getCode());


            String familyMembersArray = "[]";


            try{
                ALL_ANSWERS_JSON_OBJECT = new JSONObject(databaseHelper.getAllAnswersJson(farmer.getCode()));
                familyMembersArray = ALL_ANSWERS_JSON_OBJECT.getString("familyMembers");
            }catch(Exception e){ e.printStackTrace();}

            Log.i("FM ACTIVITY", "FAMILY MEMBERS OLD ARRAY IS " +  familyMembersArray );

            try{

                if(familyMembersArray != null && !familyMembersArray.equalsIgnoreCase("null") && !familyMembersArray.equalsIgnoreCase(""))
                 oldValuesArray = new JSONArray(familyMembersArray);

                else
                    oldValuesArray = new JSONArray();

            }catch(JSONException e){
                e.printStackTrace();
                oldValuesArray = new JSONArray();

            }

            Log.i("FM ACTIVITY", "FAMILY MEMBERS OLD ARRAY IS " +  oldValuesArray.toString() );

            if(oldValuesArray != null && oldValuesArray.length() == ROW_SIZE) {
                jsonArray = oldValuesArray;

                Log.i("FM ACTIVITY", "ASSIGNED OLD ARRAY TO NEW ARRAY ");

            }


            mTableViewAdapter = new FineTableViewAdapter(this, INITIALIZED_QUESTIONS);
            tableView.setAdapter(mTableViewAdapter);
            tableView.setTableViewListener(new TableViewListener());

            loadData();




        }


        onBackClicked();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(monitoringMode)
                    onBackClicked();
                else {

                    String idForIncome = databaseHelper.getQuestionIdByTranslationName("How much income contribute in a year");
                    if (idForIncome == null || idForIncome.equalsIgnoreCase("null"))
                        idForIncome = databaseHelper.getQuestionIdByTranslationName("How much income contributed in a year from work outside own farm");


                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < ROW_SIZE; i++){

                        String value = "";

                        try {
                            value = jsonArray.getJSONObject(i).get(idForIncome).toString();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            value = "0";
                        }

                        stringBuilder.append(value).append("+");


                    }

                    stringBuilder.append("0");


                    Log.i(TAG, "STRING BUILDER = " + stringBuilder.toString());






                    Question q = databaseHelper.getQuestionByTranslation("Total Family Income");

                    String socioJson = databaseHelper.getAllAnswersJson(farmer.getCode());

                    JSONObject socioJsonObject = new JSONObject();
                    try {

                        if(socioJson != null && !socioJson.equalsIgnoreCase("null") && !socioJson.equalsIgnoreCase("")) {
                            socioJsonObject = new JSONObject(socioJson);
                            if (socioJsonObject.has(q.getId())) {

                                socioJsonObject.remove(q.getId());
                                socioJsonObject.put(q.getId(), applyCalculation(stringBuilder.toString()));


                            } else {

                                socioJsonObject.put(q.getId(), applyCalculation(stringBuilder.toString()));
                            }

                        }else{

                            socioJsonObject = new JSONObject();
                            socioJsonObject.put(q.getId(), "0.0");
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();


                    }

                    databaseHelper.editAllAnswersJson(farmer.getCode(), socioJsonObject);



                    Log.i(TAG, "JSON ARRAY STRING IS " + jsonArray.toString());

                    JSONObject newJson = new JSONObject();
                    try {
                        newJson.put("familyMembers", jsonArray.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (databaseHelper.editAllAnswersJson(farmer.getCode(),newJson)) {
                        CustomToast.makeToast(FamilyMembersActivity_v2.this, "Data has been saved", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        CustomToast.makeToast(FamilyMembersActivity_v2.this, "Uh oh! Data was not saved", Toast.LENGTH_SHORT).show();




                }
            }
        });


        SpinnerViewHolder.UpdateJsonArrayListener(this);
        CellViewHolder.UpdateJsonArrayListener(this);
        CheckBoxViewHolder.UpdateJsonArrayListener(this);





    }













    private void loadData() {
        List<RowHeader> rowHeaders = getRowHeaderList();
        List<ColumnHeader> columnHeaders = getColumnHeaderList(); //getRandomColumnHeaderList(); //
        List<List<Cell>> cellList =  getCellList(); //getCellListForSortingTest();

        mRowHeaderList.addAll(rowHeaders);
        mColumnHeaderList.addAll(columnHeaders);

        //mCellList.addAll(cellList);
/*
         for (int i = 0; i < ROW_SIZE; i++) {
             mCellList.add(getCells(i));
         }*/


        Log.i(TAG, "########  CELL LIST SIZE IS " + mCellList.size());

        Log.i(TAG, "########  ROW SIZE IS STILL " + ROW_SIZE);

         for (int i = 0; i < ROW_SIZE; i++) {
             Log.i(TAG, "########  GETTING CELLS LIST FOR ROW " + i);

             mCellList.get(i).addAll(cellList.get(i));
        }

        // Load all data


        Log.i(TAG, "HEADERS SIZE IS " + mColumnHeaderList.size());
        Log.i(TAG, "ROWS HEADERS SIZE " + mRowHeaderList.size());
        Log.i(TAG, "DATA ARRAY LIST SIZE IS " + mCellList.size() + " OF ROW SIZE " + ROW_SIZE);


        // Load all data
        mTableViewAdapter.setAllItems(mColumnHeaderList, mRowHeaderList, mCellList);

    }


    private List<List<Cell>> getCellList() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {

            Log.i(TAG, "ROW INDEX " + i);

            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < COLUMN_SIZE; j++) {

                Log.i(TAG, "COLUMN INDEX " + j);


                Question q = mQuestionsList.get(i).get(j);

               /* if(i == 0){
                    if(q.getTranslation__c().equalsIgnoreCase("name"))
                        q.setDefault_value__c(farmer.getFarmerName());
                }*/

                String value = getValue(i, q.getId());

                if(value != null)
                    q.setDefault_value__c(value);

                Cell cell = new Cell(q.getId(), q);
                cellList.add(cell);
            }
            list.add(cellList);
        }

        Log.i(TAG, "########  CELL LIST SIZE IS " + list.size());

        return list;
    }



    private List<RowHeader> getRowHeaderList() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {

            int rowNumber = i + 1;

            RowHeader header = new RowHeader(String.valueOf(i), String.valueOf(rowNumber));
            list.add(header);
        }

        return list;
    }




    private List<ColumnHeader> getColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        for (int i = 0; i < COLUMN_SIZE; i++) {


            if(prefs.getBoolean("toggleTranslation", false)) {
                String title = INITIALIZED_QUESTIONS.get(i).getTranslation__c();
                ColumnHeader header = new ColumnHeader(String.valueOf(i), title);
                list.add(header);

            }else{

                     String title = INITIALIZED_QUESTIONS.get(i).getCaption__c();
                    ColumnHeader header = new ColumnHeader(String.valueOf(i), title);
                    list.add(header);


            }


        }

        return list;
    }






    private void initData() {
        mRowHeaderList = new ArrayList<>();
        mColumnHeaderList = new ArrayList<>();
        mCellList = new ArrayList<>();
        mQuestionsList = new ArrayList<>();

        for (int i = 0; i < ROW_SIZE; i++) {
            mCellList.add(new ArrayList<Cell>());
        }

        for (int i = 0; i < ROW_SIZE; i++) {
            mQuestionsList.add(INITIALIZED_QUESTIONS);
        }

        Log.i(TAG, "********* ON INITIALIZATION ......... mCELL LIST SIZE IS " + mCellList.size());


    }


    @Override
    public void onItemValueChanged(int index, String uid, String value) {

        Log.i(TAG, "ITEM VALUE CHANGED FROM " + index + " WITH VALUE " + value + " AND UID " + uid);


        try {
            JSONObject object = jsonArray.getJSONObject(index);
            if(object != null){

                if(object.has(uid)){

                    Log.i(TAG, "OLD VALUE WAS " + object.get(uid).toString());

                    object.remove(uid);
                    object.put(uid, value);

                    Log.i(TAG, "VALUE UPDATED WITH " + object.get(uid).toString());
                }else{


                    object.put(uid, value);

                    Log.i(TAG, "VALUE UPDATED WITH " + object.get(uid).toString());
                }


                Log.i(TAG, "JSON ARRAY IS " + jsonArray.toString());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }



    public static String getValue(int index, String uid){

        Log.i(TAG, "GETTING OLD VALUE FOE INDEX " + index);

        String value = null;

        try {
             JSONObject object = oldValuesArray.getJSONObject(index);

            if(object.has(uid))
                value = object.getString(uid);

            else value = null;


        } catch (JSONException e) {
            //e.printStackTrace();

            Log.i(TAG, "*** EXCEPTION *** " + e.getMessage());


            value = null;
        }
        Log.i(TAG, "*** VALUE IS  *** " + value);

        return value;
    }
}
