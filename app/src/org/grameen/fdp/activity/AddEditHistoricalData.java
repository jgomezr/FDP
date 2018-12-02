package org.grameen.fdp.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.DynamicFormFragment;
import org.grameen.fdp.object.HistoricalData;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DateUtil;
import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by AangJnr on 27, November, 2018 @ 8:31 PM
 * Work Mail cibrahim@grameenfoundation.org
 * Personal mail aang.jnr@gmail.com
 */

public class AddEditHistoricalData extends BaseActivity {

    HistoricalData HISTORICAL_DATA;

    boolean loadOldValues = false;
    RealFarmer farmer;
    String FORM_NAME;
    String FORM_ID;

    TextView name;
    TextView code;
    CircleImageView circleImageView;
    TextView initials;
    TextView villageName;
    TextView landArea;
    TextView lastVisitDate;
    TextView lastSyncDate;
    TextView addPlot;
    ImageView syncIndicator;

    int noOfHistoricalData;

    DynamicFormFragment dynamicFormFragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);

        Toolbar toolbar;

        if (getIntent() != null) {

            if (getIntent().getStringExtra("mode") != null && getIntent().getStringExtra("mode").equalsIgnoreCase(Constants.RECORD_EDIT)) {
                toolbar = setToolbar(getResources(R.string.edit_current_record));
                loadOldValues = true;
            } else
                toolbar = setToolbar(getResources(R.string.add_new_record));


            farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
            FORM_NAME = getIntent().getStringExtra("formName");
            FORM_ID = getIntent().getStringExtra("formId");

            HISTORICAL_DATA = new Gson().fromJson(getIntent().getStringExtra("historicalData"), HistoricalData.class);
            noOfHistoricalData = getIntent().getIntExtra("size", -1);

            if (farmer != null) {
                setupViews();


            }
        } else
            Toast.makeText(this, getResources(R.string.error_getting_farmer_info), Toast.LENGTH_SHORT).show();


    }

    private void setupViews() {


        name = (TextView) findViewById(R.id.name);
        code = (TextView) findViewById(R.id.code);
        initials = (TextView) findViewById(R.id.initials);
        villageName = (TextView) findViewById(R.id.villageName);
        landArea = (TextView) findViewById(R.id.landSize);
        lastSyncDate = findViewById(R.id.lastSyncDate);
        lastVisitDate = (TextView) findViewById(R.id.lastVisitDate);
        syncIndicator = findViewById(R.id.syncIndicator);


        name.setText(farmer.getFarmerName());
        code.setText(farmer.getCode());
        villageName.setText(farmer.getVillage());
        landArea.setText(farmer.getLandArea());
        if (farmer.getSyncStatus() != null) {

            if (farmer.getSyncStatus() == 0) {
                syncIndicator.setImageResource(R.drawable.ic_sync_problem_black_24dp);
                syncIndicator.setColorFilter(ContextCompat.getColor(this, R.color.cpb_red));

            } else if (farmer.getSyncStatus() == 1) {
                syncIndicator.setImageResource(R.drawable.ic_check_circle_black_24dp);
                syncIndicator.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent));
            }
        }


        lastSyncDate.setText(farmer.getLastVisitDate());
        lastVisitDate.setText(farmer.getLastModifiedDate());


        FragmentManager fm = getSupportFragmentManager();

        dynamicFormFragment = DynamicFormFragment.newInstance(FORM_NAME, loadOldValues, HISTORICAL_DATA.getAnswersJsonObject(), farmer.getId(), true);

        loadDynamicView(fm, dynamicFormFragment, FORM_NAME);


        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveOrUpdateData();


            }
        });


    }


    void loadDynamicView(FragmentManager fm, Fragment fragment, String formName) {

        //Todo add parameter to load data from the database, if is in editing mode else display default forms with their resp values

        try {
            // if (fm.getFragments().contains(formFragment)) {

            fm.beginTransaction()
                    .replace(R.id.dynamicLayout, fragment, formName)
                    .addToBackStack(null)
                    .commit();
            //Log.i(TAG, "^^^^^^^^^   FRAGMENT FOUND! RECYCLING....  ^^^^^^^^^^^^^^^");

//            }else{
//
//
//                fm.beginTransaction()
//                        .add(R.id.dynamicLayout, formFragment, formFragment.getClass().getSimpleName())
//                        .commit();
//
//                Log.i(TAG, "^^^^^^^^^  NEW FRAGMENT ....  ^^^^^^^^^^^^^^^");
//
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    void saveOrUpdateData() {


        JSONObject newJsonValue = dynamicFormFragment.getAllAnswersInJSONObject();

        Log.d(TAG, "JSON VALUE IS + \n" + newJsonValue + "\n");

        if (!loadOldValues) {//New data

            HistoricalData data = new HistoricalData();
            data.setId(DateUtil.getDateInMillisToString());
            data.setName("Data " + (noOfHistoricalData + 1));
            data.setFormId(FORM_ID);
            data.setAnswersJson(newJsonValue.toString());

            if (databaseHelper.addNewHistoricalData(data)) {
                prefs.edit().putBoolean("shouldRestartMainActivity", true).apply();

                CustomToast.makeToast(this, getResources(R.string.new_data_saved), Toast.LENGTH_SHORT).show();
                supportFinishAfterTransition();
            } else
                CustomToast.makeToast(this, getResources(R.string.could_not_save_data), Toast.LENGTH_SHORT).show();


        } else {//Editing old Data
            if (databaseHelper.editHistoricalData(HISTORICAL_DATA.getId(), newJsonValue.toString())) {
                prefs.edit().putBoolean("shouldRestartMainActivity", true).apply();


                CustomToast.makeToast(this, getResources(R.string.new_data_updated), Toast.LENGTH_SHORT).show();
                supportFinishAfterTransition();
            } else
                CustomToast.makeToast(this, getResources(R.string.could_not_save_data), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {

        //Todo Prompt to save before closing activity


        super.onBackPressed();
    }
}
