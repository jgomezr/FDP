package org.grameen.fdp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.DetailedYearTableHearderAdapter;
import org.grameen.fdp.adapter.DetailedYearTableViewAdapter;
import org.grameen.fdp.adapter.FamilyMembersTableHearderAdapter;
import org.grameen.fdp.adapter.FamilyMembersTableViewAdapter;
import org.grameen.fdp.object.FamilyMembersData;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by aangjnr on 08/02/2018.
 */

public class FamilyMembersActivity extends BaseActivity {


    Boolean hasFamilyMembersData = false;
    RealFarmer farmer;
    TableView tableView;
    List<Question> questions;
    Button save;
    List<FamilyMembersData> familyMembersData = new ArrayList<>();
    JSONObject ALL_ANSWERS_JSON_OBJECT;
    JSONArray jsonArray = null;


    int noOfFamilyMembers = 1;
    private FamilyMembersTableViewAdapter myTableViewAdapter;
    private boolean monitoringMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_year);


        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

            //Todo add the rest of the views to hide
            monitoringMode = true;


        }

        save = findViewById(R.id.save);

        if(monitoringMode) {
             save.setVisibility(View.GONE);
        }

        findViewById(R.id.currencyLayout).setVisibility(View.GONE);

        questions = databaseHelper.getSpecificSetOfQuestions(Constants.FAMILY_MEMBERS);


        String[] TABLE_HEADERS = new String[questions.size()];

        for(int i = 0; i < questions.size(); i++){

            TABLE_HEADERS[i] = questions.get(i).getCaption__c();


        }




        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        try {
            noOfFamilyMembers = Integer.parseInt(getIntent().getStringExtra("familyMembers"));
        }catch(Exception e){
            e.printStackTrace();
            noOfFamilyMembers = 1;
        }

        Log.i("FM ACTIVITY", "NO FAM MEMBERS " +  noOfFamilyMembers );



        if (farmer != null) {

            String familyMembersArray = "[]";

            Toolbar toolbar = setToolbar("Name " + farmer.getFarmerName() + "\tCode " + farmer.getCode());

            try{
                ALL_ANSWERS_JSON_OBJECT = new JSONObject(databaseHelper.getAllAnswersJson(farmer.getCode()));
                familyMembersArray = ALL_ANSWERS_JSON_OBJECT.getString("familyMembers");
            }catch(Exception e){ e.printStackTrace();}



            Log.i("FM ACTIVITY", "ARRAY IS " +  familyMembersArray );

            try{

                if(familyMembersArray != null)
                 jsonArray = new JSONArray(familyMembersArray);

            }catch(JSONException e){ e.printStackTrace();

            }

            Log.i("FM ACTIVITY", "ACTUAL ARRAY IS " +  jsonArray );




            tableView = findViewById(R.id.tableView);
            tableView.setColumnCount(TABLE_HEADERS.length);


            tableView.setHeaderAdapter(new FamilyMembersTableHearderAdapter(FamilyMembersActivity.this, TABLE_HEADERS));


            for (int i = 0; i < noOfFamilyMembers; i++) {

                familyMembersData.add(new FamilyMembersData(i, questions, new JSONObject()));


            }


            myTableViewAdapter = new FamilyMembersTableViewAdapter(FamilyMembersActivity.this, familyMembersData, jsonArray);

            tableView.setDataAdapter(myTableViewAdapter);




        }


        onBackClicked();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question q = databaseHelper.getQuestionByTranslation("How much income contribute in a year");

                if(monitoringMode)
                    onBackClicked();
                else {
                    JSONArray jsonArray = myTableViewAdapter.getAllAnswers();


                    StringBuilder stringBuilder = new StringBuilder();
                    try {
                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);


                            stringBuilder.append(jsonObject.getString(q.getCaption__c())).append("+");

                        }


                        stringBuilder.append("0");

                        Log.i(TAG, "STRING BUILDER FOR FAM MEMBERS INCOME IS " + stringBuilder.toString());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                    Log.i(TAG, "JSON ARRAY STRING IS " + jsonArray.toString());

                    JSONObject newJson = new JSONObject();
                    try {
                        newJson.put("familyMembers", jsonArray.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (databaseHelper.editAllAnswersJson(farmer.getCode(),newJson)) {
                        CustomToast.makeToast(FamilyMembersActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        CustomToast.makeToast(FamilyMembersActivity.this, "Uh oh! Data was not saved", Toast.LENGTH_SHORT).show();





                }
            }
        });


    }
}
