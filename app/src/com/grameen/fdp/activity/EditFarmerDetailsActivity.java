package com.grameen.fdp.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.grameen.fdp.fragment.MyFormFragment;
import com.grameen.fdp.utility.Constants;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.squareup.picasso.Picasso;

import com.grameen.fdp.R;
import com.grameen.fdp.object.Farmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class EditFarmerDetailsActivity extends BaseActivity {


    TextView farmerName;
    TextView farmerCode;
    TextView takePhoto;

    MaterialSpinner villageSpinner;
    MaterialSpinner educationLevelSpinner;
    MaterialSpinner genderSpinner;
    MaterialSpinner haveSpouseSpinner;
    MaterialSpinner noOfSpousesSpinner;
    MaterialSpinner spouseEducatonLevelSpinner;
    MaterialSpinner haveChildrenSpinner;
    MaterialSpinner numberOfChildrenSpinner;

    EditText birthYearEdittext;
    EditText spouseNameEdittext;


    CircleImageView circleImageView;
    TextView initials;


    Farmer farmer;
    boolean isEditMode = false;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_farmer_details);

        Intent intent = getIntent();

        if(intent.getStringExtra("flag") != null && intent.getStringExtra("flag").equals("edit")){

            Toolbar toolbar = setToolbar("Edit Farmer Details");
            farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), Farmer.class);

            isEditMode = true;


        }else{

             Toolbar toolbar = setToolbar("Add Farmer Details");


        }

        setUpViews();





    }






    void setUpViews(){


        farmerName = (TextView) findViewById(R.id.farmerName);
        farmerCode = (TextView) findViewById(R.id.farmerCode);
        takePhoto = (TextView) findViewById(R.id.takeImage);
        initials = (TextView) findViewById(R.id.initials);
        villageSpinner = (MaterialSpinner) findViewById(R.id.villageSpinner);
        educationLevelSpinner = (MaterialSpinner) findViewById(R.id.educationLevelSpinner);
        genderSpinner = (MaterialSpinner) findViewById(R.id.genderSpinner);
        haveSpouseSpinner = (MaterialSpinner) findViewById(R.id.haveSpouseSpinner);
        noOfSpousesSpinner = (MaterialSpinner) findViewById(R.id.noOfSpousesSpinner);
        spouseEducatonLevelSpinner = (MaterialSpinner) findViewById(R.id.spouseEducationLevelSpinner);
        haveChildrenSpinner = (MaterialSpinner) findViewById(R.id.childrenSpinner);
        numberOfChildrenSpinner = (MaterialSpinner) findViewById(R.id.noChildrenSpinner);

        birthYearEdittext = (EditText) findViewById(R.id.birthdayYearEdittext);
        spouseNameEdittext = (EditText) findViewById(R.id.spouseNameEdittext);
        circleImageView = (CircleImageView) findViewById(R.id.photo);




        if(isEditMode) {
            List<String> values = new ArrayList<>();

            for (int i = 0; i <= 20; ++i) {

                values.add(i + "");

            }

            birthYearEdittext.setText(farmer.getBirthYear());
            spouseNameEdittext.setText(farmer.getSpouseName());

            villageSpinner.setItems("Village A", "Village B", "Village C");
            villageSpinner.setText(farmer.getVillageName());

            educationLevelSpinner.setItems(getResources().getStringArray(R.array.educationLevel));
            genderSpinner.setItems(getResources().getStringArray(R.array.gender));

            haveSpouseSpinner.setItems(getResources().getStringArray(R.array.answer));

            noOfSpousesSpinner.setItems(values);

            spouseEducatonLevelSpinner.setItems(getResources().getStringArray(R.array.educationLevel));

            haveChildrenSpinner.setItems(getResources().getStringArray(R.array.answer));

            numberOfChildrenSpinner.setItems(values);
            noOfSpousesSpinner.setText(farmer.getNoOfSpouses());
            numberOfChildrenSpinner.setText(farmer.getNoOfChildren());


            if (farmer.getImageUrl() != null && !farmer.getId().equals("")) {
                Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

            } else {
                String[] valueArray = farmer.getName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                initials.setText(value);

                int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

                int randomColor = mColors[new Random().nextInt(mColors.length)];

                GradientDrawable drawable = new GradientDrawable();
                drawable.setCornerRadius(1000);
                drawable.setColor(randomColor);
                circleImageView.setBackground(drawable);
            }
        }else{

            MyFormFragment formFragment = MyFormFragment.newInstance(Constants.SOCIO_ECONOMIC_PROFILE);
            FragmentManager fm = getSupportFragmentManager();

            fm.beginTransaction()
                    .add(R.id.dynamicLayout, formFragment, formFragment.getClass().getSimpleName())
                    .commit();












        }








    }
}
