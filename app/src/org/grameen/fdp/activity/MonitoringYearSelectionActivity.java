package org.grameen.fdp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.PlotsListAdapter;
import org.grameen.fdp.object.Form;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class MonitoringYearSelectionActivity extends BaseActivity {

    RealFarmer farmer;
    TextView name;
    TextView code;
    CircleImageView circleImageView;
    TextView initials;
    TextView villageName;
    TextView landArea;
    TextView lastVisitDate;
    View syncIndicator;

    RealPlot PLOT;

    String TAG = "MonitoringActivity";

    TextView plot_name_text_view;



    RecyclerView plotsRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_year_selection);
        Toolbar toolbar = setToolbar("Farmer Details");


        name = (TextView) findViewById(R.id.name);
        code = (TextView) findViewById(R.id.code);
        initials = (TextView) findViewById(R.id.initials);
        villageName = (TextView) findViewById(R.id.villageName);
        landArea = (TextView) findViewById(R.id.landSize);
        lastVisitDate = (TextView) findViewById(R.id.lastVisitDate);
        syncIndicator = findViewById(R.id.sync);
        plotsRecyclerView = (RecyclerView) findViewById(R.id.plotsRecyclerView);
        circleImageView = (CircleImageView) findViewById(R.id.photo);

        plot_name_text_view = findViewById(R.id.list_item_section_text);



        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        PLOT = new Gson().fromJson(getIntent().getStringExtra("plot"), RealPlot.class);

        if (farmer != null) {

            initializeViews();




        } else {

            Toast.makeText(this, getResources(R.string.error_getting_farmer_info), Toast.LENGTH_SHORT).show();
        }


        onBackClicked();
    }


    void initializeViews() {

        name.setText(farmer.getFarmerName());
        code.setText(farmer.getCode());
        villageName.setText(farmer.getVillage());
        landArea.setText(farmer.getLandArea());
        lastVisitDate.setText(farmer.getLastVisitDate());

        plot_name_text_view.setText(PLOT.getName());


        Log.d(TAG, "IMAGE URL ###########   " + farmer.getImageUrl() + "");


        if (farmer.getImageUrl() != null && !farmer.getImageUrl().equals("")) {
            Log.d(TAG, "IMAGE URL    " + farmer.getImageUrl() + "");


            Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

        } else {

            try {
                String[] valueArray = farmer.getFarmerName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                initials.setText(value);

            } catch (Exception e) {

                initials.setText(farmer.getFarmerName().substring(0, 1));


            }

            int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(randomColor);
            circleImageView.setBackground(drawable);
        }


        setUpListAdapter();


    }


    void setUpListAdapter() {

        List<String> YEARS = new ArrayList<>();
        YEARS.add("Year 1");
        YEARS.add("Year 2");
        YEARS.add("Year 3");
        YEARS.add("Year 4");
        YEARS.add("Year 5");
        YEARS.add("Year 6");
        YEARS.add("Year 7");


        ListView listView = findViewById(R.id.list_view);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, YEARS);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(PLOT.getRecommendationId() != null) {


                    int year = position + 1;

                    Intent intent = new Intent(MonitoringYearSelectionActivity.this, PlotMonitoringActivity.class);
                    intent.putExtra("farmer", new Gson().toJson(farmer));
                    intent.putExtra("plot", new Gson().toJson(PLOT));
                    intent.putExtra("selectedYear", year);
                    startActivity(intent);

                }else{


                    showAlertDialog(true, getResources(R.string.incomplete_ao_monitoring), getResources(R.string.incomplete_ao_rational) + PLOT.getName(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    }, getResources(R.string.ok), null, "", 0);


                }




            }
        });





    }



    @Override
    public void onBackPressed() {


        super.onBackPressed();


    }


    @Override
    protected void onStop() {

        super.onStop();
    }
}
