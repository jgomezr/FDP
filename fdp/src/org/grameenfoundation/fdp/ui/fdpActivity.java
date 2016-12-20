package org.grameenfoundation.fdp.ui;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.MainActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class fdpActivity  extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: fdpActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    public static final String YEAR_LAUNCH = "year_launch";
    private GridLayout p1,p2,p3,p4,p5;
    private Spinner st1,st2,st3,st4,st5;
    private TextView gaplp1,grflp1,replp1,exslp1,limlp1,dralp1,fillp1,lablp1,gaplp2,grflp2,replp2,exslp2,limlp2,dralp2,fillp2,lablp2,gaplp3,grflp3,replp3,exslp3,limlp3,dralp3,fillp3,lablp3,gaplp4,grflp4,replp4,exslp4,limlp4,dralp4,fillp4,lablp4,gaplp5,grflp5,replp5,exslp5,limlp5,dralp5,fillp5,lablp5,found1,found2,found3,found4,found5,found6,found7,pyl1,pyl2,pyl3,pyl4,pyl5,pyl6,pyl7,plp1y1,plp1y2,plp1y3,plp1y4,plp1y5,plp1y6,plp1y7,plp2y1,plp2y2,plp2y3,plp2y4,plp2y5,plp2y6,plp2y7,plp3y1,plp3y2,plp3y3,plp3y4,plp3y5,plp3y6,plp3y7,plp4y1,plp4y2,plp4y3,plp4y4,plp4y5,plp4y6,plp4y7,plp5y1,plp5y2,plp5y3,plp5y4,plp5y5,plp5y6,plp5y7,lnp1,lcp1,lnp2,lcp2,lnp3,lcp3,lnp4,lcp4,lnp5,lcp5,lnp1y1,lcp1y1,lnp2y1,lcp2y1,lnp3y1,lcp3y1,lnp4y1,lcp4y1,lnp5y1,lcp5y1,lnp1y2,lcp1y2,lnp2y2,lcp2y2,lnp3y2,lcp3y2,lnp4y2,lcp4y2,lnp5y2,lcp5y2,lnp1y3,lcp1y3,lnp2y3,lcp2y3,lnp3y3,lcp3y3,lnp4y3,lcp4y3,lnp5y3,lcp5y3,lnp1y4,lcp1y4,lnp2y4,lcp2y4,lnp3y4,lcp3y4,lnp4y4,lcp4y4,lnp5y4,lcp5y4,lnp1y5,lcp1y5,lnp2y5,lcp2y5,lnp3y5,lcp3y5,lnp4y5,lcp4y5,lnp5y5,lcp5y5,lnp1y6,lcp1y6,lnp2y6,lcp2y6,lnp3y6,lcp3y6,lnp4y6,lcp4y6,lnp5y6,lcp5y6,lnp1y7,lcp1y7,lnp2y7,lcp2y7,lnp3y7,lcp3y7,lnp4y7,lcp4y7,lnp5y7,lcp5y7;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fdp);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(R.string.fdpActivityTitle);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(plotActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(plotActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(plotActivity.OBJECT_NAME_KEY);
        }
        st1 = (Spinner)findViewById(R.id.startP1_field);
        st2 = (Spinner)findViewById(R.id.startP2_field);
        st3 = (Spinner)findViewById(R.id.startP3_field);
        st4 = (Spinner)findViewById(R.id.startP4_field);
        st5 = (Spinner)findViewById(R.id.startP5_field);
        p1 = (GridLayout) findViewById(R.id.p1Grid);
        p2 = (GridLayout)findViewById(R.id.p2Grid);
        p3 = (GridLayout)findViewById(R.id.p3Grid);
        p4 = (GridLayout)findViewById(R.id.p4Grid);
        p5 = (GridLayout)findViewById(R.id.p5Grid);
        gaplp1 = (TextView)findViewById(R.id.gapLabelP1_field);
        grflp1 = (TextView)findViewById(R.id.graftLabelP1_field);
        replp1 = (TextView)findViewById(R.id.replantLabelP1_field);
        exslp1 = (TextView)findViewById(R.id.extraSoilLabelP1_field);
        limlp1 = (TextView)findViewById(R.id.limeLabelP1_field);
        dralp1 = (TextView)findViewById(R.id.drainageLabelP1_field);
        fillp1 = (TextView)findViewById(R.id.fillingLabelP1_field);
        lablp1 = (TextView)findViewById(R.id.laborLabelP1_field);
        gaplp2 = (TextView)findViewById(R.id.gapLabelP2_field);
        grflp2 = (TextView)findViewById(R.id.graftLabelP2_field);
        replp2 = (TextView)findViewById(R.id.replantLabelP2_field);
        exslp2 = (TextView)findViewById(R.id.extraSoilLabelP2_field);
        limlp2 = (TextView)findViewById(R.id.limeLabelP2_field);
        dralp2 = (TextView)findViewById(R.id.drainageLabelP2_field);
        fillp2 = (TextView)findViewById(R.id.fillingLabelP2_field);
        lablp2 = (TextView)findViewById(R.id.laborLabelP2_field);
        gaplp3 = (TextView)findViewById(R.id.gapLabelP3_field);
        grflp3 = (TextView)findViewById(R.id.graftLabelP3_field);
        replp3 = (TextView)findViewById(R.id.replantLabelP3_field);
        exslp3 = (TextView)findViewById(R.id.extraSoilLabelP3_field);
        limlp3 = (TextView)findViewById(R.id.limeLabelP3_field);
        dralp3 = (TextView)findViewById(R.id.drainageLabelP3_field);
        fillp3 = (TextView)findViewById(R.id.fillingLabelP3_field);
        lablp3 = (TextView)findViewById(R.id.laborLabelP3_field);
        gaplp4 = (TextView)findViewById(R.id.gapLabelP4_field);
        grflp4 = (TextView)findViewById(R.id.graftLabelP4_field);
        replp4 = (TextView)findViewById(R.id.replantLabelP4_field);
        exslp4 = (TextView)findViewById(R.id.extraSoilLabelP4_field);
        limlp4 = (TextView)findViewById(R.id.limeLabelP4_field);
        dralp4 = (TextView)findViewById(R.id.drainageLabelP4_field);
        fillp4 = (TextView)findViewById(R.id.fillingLabelP4_field);
        lablp4 = (TextView)findViewById(R.id.laborLabelP4_field);
        gaplp5 = (TextView)findViewById(R.id.gapLabelP5_field);
        grflp5 = (TextView)findViewById(R.id.graftLabelP5_field);
        replp5 = (TextView)findViewById(R.id.replantLabelP5_field);
        exslp5 = (TextView)findViewById(R.id.extraSoilLabelP5_field);
        limlp5 = (TextView)findViewById(R.id.limeLabelP5_field);
        dralp5 = (TextView)findViewById(R.id.drainageLabelP5_field);
        fillp5 = (TextView)findViewById(R.id.fillingLabelP5_field);
        lablp5 = (TextView)findViewById(R.id.laborLabelP5_field);
        found1 = (TextView)findViewById(R.id.netFamilyY1_field);
        found2 = (TextView)findViewById(R.id.netFamilyY2_field);
        found3 = (TextView)findViewById(R.id.netFamilyY3_field);
        found4 = (TextView)findViewById(R.id.netFamilyY4_field);
        found5 = (TextView)findViewById(R.id.netFamilyY5_field);
        found6 = (TextView)findViewById(R.id.netFamilyY6_field);
        found7 = (TextView)findViewById(R.id.netFamilyY7_field);
        pyl1 = (TextView)findViewById(R.id.profitOrLostY1_field);
        pyl2 = (TextView)findViewById(R.id.profitOrLostY2_field);
        pyl3 = (TextView)findViewById(R.id.profitOrLostY3_field);
        pyl4 = (TextView)findViewById(R.id.profitOrLostY4_field);
        pyl5 = (TextView)findViewById(R.id.profitOrLostY5_field);
        pyl6 = (TextView)findViewById(R.id.profitOrLostY6_field);
        pyl7 = (TextView)findViewById(R.id.profitOrLostY7_field);
        plp1y1= (TextView)findViewById(R.id.plY1P1);
        plp1y2= (TextView)findViewById(R.id.plY2P1);
        plp1y3= (TextView)findViewById(R.id.plY3P1);
        plp1y4= (TextView)findViewById(R.id.plY4P1);
        plp1y5= (TextView)findViewById(R.id.plY5P1);
        plp1y6= (TextView)findViewById(R.id.plY6P1);
        plp1y7= (TextView)findViewById(R.id.plY7P1);
        plp2y1= (TextView)findViewById(R.id.plY1P2);
        plp2y2= (TextView)findViewById(R.id.plY2P2);
        plp2y3= (TextView)findViewById(R.id.plY3P2);
        plp2y4= (TextView)findViewById(R.id.plY4P2);
        plp2y5= (TextView)findViewById(R.id.plY5P2);
        plp2y6= (TextView)findViewById(R.id.plY6P2);
        plp2y7= (TextView)findViewById(R.id.plY7P2);
        plp3y1= (TextView)findViewById(R.id.plY1P3);
        plp3y2= (TextView)findViewById(R.id.plY2P3);
        plp3y3= (TextView)findViewById(R.id.plY3P3);
        plp3y4= (TextView)findViewById(R.id.plY4P3);
        plp3y5= (TextView)findViewById(R.id.plY5P3);
        plp3y6= (TextView)findViewById(R.id.plY6P3);
        plp3y7= (TextView)findViewById(R.id.plY7P3);
        plp4y1= (TextView)findViewById(R.id.plY1P4);
        plp4y2= (TextView)findViewById(R.id.plY2P4);
        plp4y3= (TextView)findViewById(R.id.plY3P4);
        plp4y4= (TextView)findViewById(R.id.plY4P4);
        plp4y5= (TextView)findViewById(R.id.plY5P4);
        plp4y6= (TextView)findViewById(R.id.plY6P4);
        plp4y7= (TextView)findViewById(R.id.plY7P4);
        plp5y1= (TextView)findViewById(R.id.plY1P5);
        plp5y2= (TextView)findViewById(R.id.plY2P5);
        plp5y3= (TextView)findViewById(R.id.plY3P5);
        plp5y4= (TextView)findViewById(R.id.plY4P5);
        plp5y5= (TextView)findViewById(R.id.plY5P5);
        plp5y6= (TextView)findViewById(R.id.plY6P5);
        plp5y7= (TextView)findViewById(R.id.plY7P5);
        lnp1= (TextView)findViewById(R.id.lnp1);
        lcp1= (TextView)findViewById(R.id.lcp1);
        lnp1y1 = (TextView)findViewById(R.id.manDaysY1P1);
        lnp1y2 = (TextView)findViewById(R.id.manDaysY2P1);
        lnp1y3 = (TextView)findViewById(R.id.manDaysY3P1);
        lnp1y4 = (TextView)findViewById(R.id.manDaysY4P1);
        lnp1y5 = (TextView)findViewById(R.id.manDaysY5P1);
        lnp1y6 = (TextView)findViewById(R.id.manDaysY6P1);
        lnp1y7 = (TextView)findViewById(R.id.manDaysY7P1);
        lcp1y1= (TextView)findViewById(R.id.laborY1P1);
        lcp1y2= (TextView)findViewById(R.id.laborY2P1);
        lcp1y3= (TextView)findViewById(R.id.laborY3P1);
        lcp1y4= (TextView)findViewById(R.id.laborY4P1);
        lcp1y5= (TextView)findViewById(R.id.laborY5P1);
        lcp1y6= (TextView)findViewById(R.id.laborY6P1);
        lcp1y7= (TextView)findViewById(R.id.laborY7P1);
        lnp2= (TextView)findViewById(R.id.lnp2);
        lcp2= (TextView)findViewById(R.id.lcp2);
        lnp2y1 = (TextView)findViewById(R.id.manDaysY1P2);
        lnp2y2 = (TextView)findViewById(R.id.manDaysY2P2);
        lnp2y3 = (TextView)findViewById(R.id.manDaysY3P2);
        lnp2y4 = (TextView)findViewById(R.id.manDaysY4P2);
        lnp2y5 = (TextView)findViewById(R.id.manDaysY5P2);
        lnp2y6 = (TextView)findViewById(R.id.manDaysY6P2);
        lnp2y7 = (TextView)findViewById(R.id.manDaysY7P2);
        lcp2y1= (TextView)findViewById(R.id.laborY1P2);
        lcp2y2= (TextView)findViewById(R.id.laborY2P2);
        lcp2y3= (TextView)findViewById(R.id.laborY3P2);
        lcp2y4= (TextView)findViewById(R.id.laborY4P2);
        lcp2y5= (TextView)findViewById(R.id.laborY5P2);
        lcp2y6= (TextView)findViewById(R.id.laborY6P2);
        lcp2y7= (TextView)findViewById(R.id.laborY7P2);
        lnp3= (TextView)findViewById(R.id.lnp3);
        lcp3= (TextView)findViewById(R.id.lcp3);
        lnp3y1 = (TextView)findViewById(R.id.manDaysY1P3);
        lnp3y2 = (TextView)findViewById(R.id.manDaysY2P3);
        lnp3y3 = (TextView)findViewById(R.id.manDaysY3P3);
        lnp3y4 = (TextView)findViewById(R.id.manDaysY4P3);
        lnp3y5 = (TextView)findViewById(R.id.manDaysY5P3);
        lnp3y6 = (TextView)findViewById(R.id.manDaysY6P3);
        lnp3y7 = (TextView)findViewById(R.id.manDaysY7P3);
        lcp3y1= (TextView)findViewById(R.id.laborY1P3);
        lcp3y2= (TextView)findViewById(R.id.laborY2P3);
        lcp3y3= (TextView)findViewById(R.id.laborY3P3);
        lcp3y4= (TextView)findViewById(R.id.laborY4P3);
        lcp3y5= (TextView)findViewById(R.id.laborY5P3);
        lcp3y6= (TextView)findViewById(R.id.laborY6P3);
        lcp3y7= (TextView)findViewById(R.id.laborY7P3);
        lnp4= (TextView)findViewById(R.id.lnp4);
        lcp4= (TextView)findViewById(R.id.lcp4);
        lnp4y1 = (TextView)findViewById(R.id.manDaysY1P4);
        lnp4y2 = (TextView)findViewById(R.id.manDaysY2P4);
        lnp4y3 = (TextView)findViewById(R.id.manDaysY3P4);
        lnp4y4 = (TextView)findViewById(R.id.manDaysY4P4);
        lnp4y5 = (TextView)findViewById(R.id.manDaysY5P4);
        lnp4y6 = (TextView)findViewById(R.id.manDaysY6P4);
        lnp4y7 = (TextView)findViewById(R.id.manDaysY7P4);
        lcp4y1= (TextView)findViewById(R.id.laborY1P4);
        lcp4y2= (TextView)findViewById(R.id.laborY2P4);
        lcp4y3= (TextView)findViewById(R.id.laborY3P4);
        lcp4y4= (TextView)findViewById(R.id.laborY4P4);
        lcp4y5= (TextView)findViewById(R.id.laborY5P4);
        lcp4y6= (TextView)findViewById(R.id.laborY6P4);
        lcp4y7= (TextView)findViewById(R.id.laborY7P4);
        lnp5= (TextView)findViewById(R.id.lnp5);
        lcp5= (TextView)findViewById(R.id.lcp5);
        lnp5y1 = (TextView)findViewById(R.id.manDaysY1P5);
        lnp5y2 = (TextView)findViewById(R.id.manDaysY2P5);
        lnp5y3 = (TextView)findViewById(R.id.manDaysY3P5);
        lnp5y4 = (TextView)findViewById(R.id.manDaysY4P5);
        lnp5y5 = (TextView)findViewById(R.id.manDaysY5P5);
        lnp5y6 = (TextView)findViewById(R.id.manDaysY6P5);
        lnp5y7 = (TextView)findViewById(R.id.manDaysY7P5);
        lcp5y1= (TextView)findViewById(R.id.laborY1P5);
        lcp5y2= (TextView)findViewById(R.id.laborY2P5);
        lcp5y3= (TextView)findViewById(R.id.laborY3P5);
        lcp5y4= (TextView)findViewById(R.id.laborY4P5);
        lcp5y5= (TextView)findViewById(R.id.laborY5P5);
        lcp5y6= (TextView)findViewById(R.id.laborY6P5);
        lcp5y7= (TextView)findViewById(R.id.laborY7P5);
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    @Override
    public Loader<ContactObject> onCreateLoader(int id, Bundle args) {
        return new ContactDetailLoader(this, curAccount, objectId);
    }

    @Override
    public void onLoadFinished(Loader<ContactObject> loader, ContactObject data) {
        sObject = data;
        refreshScreen();
    }

    @Override
    public void onLoaderReset(Loader<ContactObject> loader) {
        sObject = null;
        refreshScreen();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        save();
        Intent plotIntent = new Intent(getApplicationContext(), plotActivity.class);
        plotIntent.addCategory(Intent.CATEGORY_DEFAULT);
        plotIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        plotIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        plotIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivityForResult(plotIntent, 0);
        return true;

    }

    public void launchYear1(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "1");
        startActivity(yearIntent);
    }
    public void launchYear2(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "2");
        startActivity(yearIntent);
    }
    public void launchYear3(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity1.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "3");
        startActivity(yearIntent);
    }

    public void launchYear4(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity1.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "4");
        startActivity(yearIntent);
    }
    public void launchYear5(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity2.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "5");
        startActivity(yearIntent);
    }
    public void launchYear6(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity2.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "6");
        startActivity(yearIntent);
    }
    public void launchYear7(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity3.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "7");
        startActivity(yearIntent);
    }

    public void onFinishClicked(View view) {
        save();
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    private void refreshScreen() {
        if (sObject != null) {

            //Set Agree with recomendations field
            if (sObject.getAgreeRecomendations().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getAgreeRecomendations().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                spinner.setAdapter(adapter);
            }

            //Set start year

            if (sObject.getStartYearP1().contentEquals("Year 1")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 2")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 3")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 4")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 5")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 6")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 7")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.startP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            if (sObject.getStartYearP2().contentEquals("Year 1")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 2")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 3")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 4")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 5")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 6")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 7")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.startP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            if (sObject.getStartYearP3().contentEquals("Year 1")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 2")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 3")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 4")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 5")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 6")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 7")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.startP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            if (sObject.getStartYearP4().contentEquals("Year 1")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 2")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 3")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 4")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 5")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 6")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 7")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.startP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            if (sObject.getStartYearP5().contentEquals("Year 1")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 2")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 3")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 4")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 5")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 6")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 7")) {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.startP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            double plot1Area = Double.valueOf(sObject.getPlot1Area().toString());
            double plot2Area = Double.valueOf(sObject.getPlot2Area().toString());
            double plot3Area = Double.valueOf(sObject.getPlot3Area().toString());
            double plot4Area = Double.valueOf(sObject.getPlot4Area().toString());
            double plot5Area = Double.valueOf(sObject.getPlot5Area().toString());
            double avgCost = Double.parseDouble(sObject.getAveragecocoaprice().toString());
            DecimalFormat dec = new DecimalFormat("IDR ###,###,###");

            int income11 =0;
            int income12 =0;
            int income13 =0;
            int income14 =0;
            int income15 =0;
            int income16 =0;
            int income17 =0;
            int cost11=0;
            int cost12=0;
            int cost13=0;
            int cost14=0;
            int cost15=0;
            int cost16=0;
            int cost17=0;
            int laborD11=0;
            int laborD12=0;
            int laborD13=0;
            int laborD14=0;
            int laborD15=0;
            int laborD16=0;
            int laborD17=0;
            int labor11=0;
            int labor12=0;
            int labor13=0;
            int labor14=0;
            int labor15=0;
            int labor16=0;
            int labor17=0;
            int pl11=0;
            int pl12=0;
            int pl13=0;
            int pl14=0;
            int pl15=0;
            int pl16=0;
            int pl17=0;
            int income21 =0;
            int income22 =0;
            int income23 =0;
            int income24 =0;
            int income25 =0;
            int income26 =0;
            int income27 =0;
            int cost21=0;
            int cost22=0;
            int cost23=0;
            int cost24=0;
            int cost25=0;
            int cost26=0;
            int cost27=0;
            int laborD21=0;
            int laborD22=0;
            int laborD23=0;
            int laborD24=0;
            int laborD25=0;
            int laborD26=0;
            int laborD27=0;
            int labor21=0;
            int labor22=0;
            int labor23=0;
            int labor24=0;
            int labor25=0;
            int labor26=0;
            int labor27=0;
            int pl21=0;
            int pl22=0;
            int pl23=0;
            int pl24=0;
            int pl25=0;
            int pl26=0;
            int pl27=0;
            int income31 =0;
            int income32 =0;
            int income33 =0;
            int income34 =0;
            int income35 =0;
            int income36 =0;
            int income37 =0;
            int cost31=0;
            int cost32=0;
            int cost33=0;
            int cost34=0;
            int cost35=0;
            int cost36=0;
            int cost37=0;
            int laborD31=0;
            int laborD32=0;
            int laborD33=0;
            int laborD34=0;
            int laborD35=0;
            int laborD36=0;
            int laborD37=0;
            int labor31=0;
            int labor32=0;
            int labor33=0;
            int labor34=0;
            int labor35=0;
            int labor36=0;
            int labor37=0;
            int pl31=0;
            int pl32=0;
            int pl33=0;
            int pl34=0;
            int pl35=0;
            int pl36=0;
            int pl37=0;
            int income41 =0;
            int income42 =0;
            int income43 =0;
            int income44 =0;
            int income45 =0;
            int income46 =0;
            int income47 =0;
            int cost41=0;
            int cost42=0;
            int cost43=0;
            int cost44=0;
            int cost45=0;
            int cost46=0;
            int cost47=0;
            int laborD41=0;
            int laborD42=0;
            int laborD43=0;
            int laborD44=0;
            int laborD45=0;
            int laborD46=0;
            int laborD47=0;
            int labor41=0;
            int labor42=0;
            int labor43=0;
            int labor44=0;
            int labor45=0;
            int labor46=0;
            int labor47=0;
            int pl41=0;
            int pl42=0;
            int pl43=0;
            int pl44=0;
            int pl45=0;
            int pl46=0;
            int pl47=0;
            int income51 =0;
            int income52 =0;
            int income53 =0;
            int income54 =0;
            int income55 =0;
            int income56 =0;
            int income57 =0;
            int cost51=0;
            int cost52=0;
            int cost53=0;
            int cost54=0;
            int cost55=0;
            int cost56=0;
            int cost57=0;
            int laborD51=0;
            int laborD52=0;
            int laborD53=0;
            int laborD54=0;
            int laborD55=0;
            int laborD56=0;
            int laborD57=0;
            int labor51=0;
            int labor52=0;
            int labor53=0;
            int labor54=0;
            int labor55=0;
            int labor56=0;
            int labor57=0;
            int pl51=0;
            int pl52=0;
            int pl53=0;
            int pl54=0;
            int pl55=0;
            int pl56=0;
            int pl57=0;

            //plot1
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                p1.setVisibility(View.VISIBLE);

                if (sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())>25)){
                    //Replant
                    replp1.setVisibility(View.VISIBLE);
                    gaplp1.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG1().equals("B")){
                        exslp1.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD12 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD13 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD14 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD15 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD16 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD17 = (int) ((plot1Area * (getResources().getInteger(R.integer.replantY7Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor11 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor12 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor13 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor14 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor15 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor16 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor17 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost11 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost12 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost13 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost14 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost15 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost16 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost17 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY1Total)));
                            laborD12 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY2Total)));
                            laborD13 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY3Total)));
                            laborD14 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY4Total)));
                            laborD15 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY5Total)));
                            laborD16 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY6Total)));
                            laborD17 = (int) (plot1Area * (getResources().getInteger(R.integer.replantY7Total)));
                            labor11 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                            labor12 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                            labor13 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                            labor14 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                            labor15 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                            labor16 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                            labor17 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                        }
                        cost11 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                        cost12 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                        cost13 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                        cost14 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                        cost15 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                        cost16 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                        cost17 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
                    }

                    income11 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
                    income12 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
                    income13 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
                    income14 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
                    income15 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
                    income16 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
                    income17 =(int) ((plot1Area * (getResources().getInteger(R.integer.replantingY7))*avgCost));

                } else if((sObject.getFarmCondition1().equals("G")&&sObject.getGENETIC1().equals("B"))||(sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())<25))){
                    //Graft
                    grflp1.setVisibility(View.VISIBLE);
                    gaplp1.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG1().equals("B")){
                        exslp1.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD12 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD13 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD14 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD15 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD16 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD17 = (int) ((plot1Area * (getResources().getInteger(R.integer.graftY7Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor11 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor12 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor13 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor14 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor15 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor16 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor17 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost11 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost12 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost13 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost14 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost15 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost16 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost17 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else {
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY1Total)));
                            laborD12 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY2Total)));
                            laborD13 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY3Total)));
                            laborD14 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY4Total)));
                            laborD15 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY5Total)));
                            laborD16 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY6Total)));
                            laborD17 = (int) (plot1Area * (getResources().getInteger(R.integer.graftY7Total)));
                            labor11 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                            labor12 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                            labor13 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                            labor14 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                            labor15 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                            labor16 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                            labor17 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                        }
                        cost11 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                        cost12 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                        cost13 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                        cost14 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                        cost15 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                        cost16 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                        cost17 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                    }
                    income11 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                    income12 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                    income13 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                    income14 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                    income15 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                    income16 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                    income17 =(int) ((plot1Area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

                }else if (sObject.getSOILMNG1().equals("B")){
                    //Extra Soil Management
                    exslp1.setVisibility(View.VISIBLE);
                    gaplp1.setVisibility(View.VISIBLE);
                    if (sObject.getHireLabor1().equals("Yes")) {
                        laborD11 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                        laborD12 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                        laborD13 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                        laborD14 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                        laborD15 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                        laborD16 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                        laborD17 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                        labor11 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                        labor12 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                        labor13 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                        labor14 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                        labor15 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                        labor16 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                        labor17 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
                    }
                    cost11 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
                    cost12 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
                    cost13 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
                    cost14 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
                    cost15 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
                    cost16 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
                    cost17 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
                    income11 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
                    income12 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
                    income13 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
                    income14 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
                    income15 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
                    income16 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
                    income17 =(int) ((plot1Area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
                }else{
                    //GAP
                    gaplp1.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG1().equals("B")){
                        exslp1.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD12 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD13 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD14 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD15 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD16 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD17 = (int) ((plot1Area * (getResources().getInteger(R.integer.gapY7Total))) + (plot1Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor11 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor12 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor13 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor14 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor15 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor16 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor17 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot1Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost11 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost12 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost13 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost14 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost15 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost16 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost17 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(plot1Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")) {
                            laborD11 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY1Total)));
                            laborD12 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY2Total)));
                            laborD13 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY3Total)));
                            laborD14 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY4Total)));
                            laborD15 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY5Total)));
                            laborD16 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY6Total)));
                            laborD17 = (int) (plot1Area * (getResources().getInteger(R.integer.gapY7Total)));
                            labor11 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                            labor12 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                            labor13 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                            labor14 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                            labor15 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                            labor16 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                            labor17 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                        }
                        cost11 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                        cost12 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                        cost13 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                        cost14 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                        cost15 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                        cost16 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                        cost17 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

                    }
                    income11 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
                    income12 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
                    income13 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
                    income14 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
                    income15 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
                    income16 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
                    income17 =(int) ((plot1Area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
                }

                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    lnp1.setVisibility(View.VISIBLE);
                    lcp1.setVisibility(View.VISIBLE);
                    lnp1y1.setVisibility(View.VISIBLE);
                    lnp1y2.setVisibility(View.VISIBLE);
                    lnp1y3.setVisibility(View.VISIBLE);
                    lnp1y4.setVisibility(View.VISIBLE);
                    lnp1y5.setVisibility(View.VISIBLE);
                    lnp1y6.setVisibility(View.VISIBLE);
                    lnp1y7.setVisibility(View.VISIBLE);
                    lcp1y1.setVisibility(View.VISIBLE);
                    lcp1y2.setVisibility(View.VISIBLE);
                    lcp1y3.setVisibility(View.VISIBLE);
                    lcp1y4.setVisibility(View.VISIBLE);
                    lcp1y5.setVisibility(View.VISIBLE);
                    lcp1y6.setVisibility(View.VISIBLE);
                    lcp1y7.setVisibility(View.VISIBLE);
                }

                if (sObject.getLimeNeed1().equals("Yes")) {
                    limlp1.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed1().equals("Yes")) {
                    dralp1.setVisibility(View.VISIBLE);
                }

                pl11= income11-(cost11+labor11);
                pl12= income12-(cost12+labor12);
                pl13= income13-(cost13+labor13);
                pl14= income14-(cost14+labor14);
                pl15= income15-(cost15+labor15);
                pl16= income16-(cost16+labor16);
                pl17= income17-(cost17+labor17);
                if(pl11 > 0){
                    plp1y1.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y1.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl12 > 0){
                    plp1y2.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y2.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl13 > 0){
                    plp1y3.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y3.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl14 > 0){
                    plp1y4.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y4.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl15 > 0){
                    plp1y5.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y5.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl16 > 0){
                    plp1y6.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y6.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl17 > 0){
                    plp1y7.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp1y7.setTextColor(Color.parseColor("#cc0000"));
                }

                setText2((TextView) findViewById(R.id.incomeY1P1), String.valueOf(dec.format(income11)));
                setText2((TextView) findViewById(R.id.incomeY2P1), String.valueOf(dec.format(income12)));
                setText2((TextView) findViewById(R.id.incomeY3P1), String.valueOf(dec.format(income13)));
                setText2((TextView) findViewById(R.id.incomeY4P1), String.valueOf(dec.format(income14)));
                setText2((TextView) findViewById(R.id.incomeY5P1), String.valueOf(dec.format(income15)));
                setText2((TextView) findViewById(R.id.incomeY6P1), String.valueOf(dec.format(income16)));
                setText2((TextView) findViewById(R.id.incomeY7P1), String.valueOf(dec.format(income17)));
                setText2((TextView) findViewById(R.id.costY1P1), String.valueOf(dec.format(cost11)));
                setText2((TextView) findViewById(R.id.costY2P1), String.valueOf(dec.format(cost12)));
                setText2((TextView) findViewById(R.id.costY3P1), String.valueOf(dec.format(cost13)));
                setText2((TextView) findViewById(R.id.costY4P1), String.valueOf(dec.format(cost14)));
                setText2((TextView) findViewById(R.id.costY5P1), String.valueOf(dec.format(cost15)));
                setText2((TextView) findViewById(R.id.costY6P1), String.valueOf(dec.format(cost16)));
                setText2((TextView) findViewById(R.id.costY7P1), String.valueOf(dec.format(cost17)));
                setText2((TextView) findViewById(R.id.manDaysY1P1), String.valueOf(laborD11));
                setText2((TextView) findViewById(R.id.manDaysY2P1), String.valueOf(laborD12));
                setText2((TextView) findViewById(R.id.manDaysY3P1), String.valueOf(laborD13));
                setText2((TextView) findViewById(R.id.manDaysY4P1), String.valueOf(laborD14));
                setText2((TextView) findViewById(R.id.manDaysY5P1), String.valueOf(laborD15));
                setText2((TextView) findViewById(R.id.manDaysY6P1), String.valueOf(laborD16));
                setText2((TextView) findViewById(R.id.manDaysY7P1), String.valueOf(laborD17));
                setText2((TextView) findViewById(R.id.laborY1P1), String.valueOf(dec.format(labor11)));
                setText2((TextView) findViewById(R.id.laborY2P1), String.valueOf(dec.format(labor12)));
                setText2((TextView) findViewById(R.id.laborY3P1), String.valueOf(dec.format(labor13)));
                setText2((TextView) findViewById(R.id.laborY4P1), String.valueOf(dec.format(labor14)));
                setText2((TextView) findViewById(R.id.laborY5P1), String.valueOf(dec.format(labor15)));
                setText2((TextView) findViewById(R.id.laborY6P1), String.valueOf(dec.format(labor16)));
                setText2((TextView) findViewById(R.id.laborY7P1), String.valueOf(dec.format(labor17)));
                setText2((TextView) findViewById(R.id.plY1P1), String.valueOf(dec.format(pl11)));
                setText2((TextView) findViewById(R.id.plY2P1), String.valueOf(dec.format(pl12)));
                setText2((TextView) findViewById(R.id.plY3P1), String.valueOf(dec.format(pl13)));
                setText2((TextView) findViewById(R.id.plY4P1), String.valueOf(dec.format(pl14)));
                setText2((TextView) findViewById(R.id.plY5P1), String.valueOf(dec.format(pl15)));
                setText2((TextView) findViewById(R.id.plY6P1), String.valueOf(dec.format(pl16)));
                setText2((TextView) findViewById(R.id.plY7P1), String.valueOf(dec.format(pl17)));
            }

            //plot2
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                p2.setVisibility(View.VISIBLE);

                if (sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())>25)){
                    //Replant
                    replp2.setVisibility(View.VISIBLE);
                    gaplp2.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG2().equals("B")){
                        exslp2.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD22 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD23 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD24 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD25 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD26 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD27 = (int) ((plot2Area * (getResources().getInteger(R.integer.replantY7Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor21 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor22 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor23 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor24 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor25 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor26 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor27 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost21 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost22 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost23 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost24 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost25 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost26 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost27 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY1Total)));
                            laborD22 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY2Total)));
                            laborD23 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY3Total)));
                            laborD24 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY4Total)));
                            laborD25 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY5Total)));
                            laborD26 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY6Total)));
                            laborD27 = (int) (plot2Area * (getResources().getInteger(R.integer.replantY7Total)));
                            labor21 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                            labor22 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                            labor23 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                            labor24 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                            labor25 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                            labor26 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                            labor27 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                        }
                        cost21 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                        cost22 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                        cost23 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                        cost24 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                        cost25 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                        cost26 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                        cost27 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
                    }

                    income21 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
                    income22 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
                    income23 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
                    income24 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
                    income25 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
                    income26 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
                    income27 =(int) ((plot2Area * (getResources().getInteger(R.integer.replantingY7))*avgCost));

                } else if((sObject.getFarmCondition2().equals("G")&&sObject.getGENETIC2().equals("B"))||(sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())<25))){
                    //Graft
                    grflp2.setVisibility(View.VISIBLE);
                    gaplp2.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG2().equals("B")){
                        exslp2.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD22 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD23 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD24 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD25 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD26 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD27 = (int) ((plot2Area * (getResources().getInteger(R.integer.graftY7Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor21 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor22 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor23 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor24 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor25 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor26 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor27 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost21 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost22 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost23 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost24 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost25 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost26 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost27 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else {
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY1Total)));
                            laborD22 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY2Total)));
                            laborD23 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY3Total)));
                            laborD24 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY4Total)));
                            laborD25 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY5Total)));
                            laborD26 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY6Total)));
                            laborD27 = (int) (plot2Area * (getResources().getInteger(R.integer.graftY7Total)));
                            labor21 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                            labor22 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                            labor23 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                            labor24 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                            labor25 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                            labor26 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                            labor27 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                        }
                        cost21 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                        cost22 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                        cost23 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                        cost24 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                        cost25 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                        cost26 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                        cost27 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                    }
                    income21 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                    income22 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                    income23 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                    income24 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                    income25 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                    income26 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                    income27 =(int) ((plot2Area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

                }else if (sObject.getSOILMNG2().equals("B")){
                    //Extra Soil Management
                    exslp2.setVisibility(View.VISIBLE);
                    gaplp2.setVisibility(View.VISIBLE);
                    if (sObject.getHireLabor2().equals("Yes")) {
                        laborD21 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                        laborD22 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                        laborD23 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                        laborD24 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                        laborD25 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                        laborD26 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                        laborD27 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                        labor21 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                        labor22 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                        labor23 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                        labor24 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                        labor25 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                        labor26 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                        labor27 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
                    }
                    cost21 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
                    cost22 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
                    cost23 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
                    cost24 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
                    cost25 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
                    cost26 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
                    cost27 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
                    income21 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
                    income22 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
                    income23 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
                    income24 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
                    income25 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
                    income26 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
                    income27 =(int) ((plot2Area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
                }else{
                    //GAP
                    gaplp2.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG2().equals("B")){
                        exslp2.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD22 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD23 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD24 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD25 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD26 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD27 = (int) ((plot2Area * (getResources().getInteger(R.integer.gapY7Total))) + (plot2Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor21 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor22 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor23 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor24 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor25 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor26 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor27 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot2Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost21 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost22 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost23 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost24 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost25 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost26 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost27 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(plot2Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor2().equals("Yes")) {
                            laborD21 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY1Total)));
                            laborD22 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY2Total)));
                            laborD23 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY3Total)));
                            laborD24 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY4Total)));
                            laborD25 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY5Total)));
                            laborD26 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY6Total)));
                            laborD27 = (int) (plot2Area * (getResources().getInteger(R.integer.gapY7Total)));
                            labor21 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                            labor22 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                            labor23 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                            labor24 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                            labor25 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                            labor26 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                            labor27 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                        }
                        cost21 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                        cost22 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                        cost23 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                        cost24 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                        cost25 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                        cost26 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                        cost27 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

                    }
                    income21 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
                    income22 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
                    income23 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
                    income24 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
                    income25 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
                    income26 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
                    income27 =(int) ((plot2Area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
                }

                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    lnp2.setVisibility(View.VISIBLE);
                    lcp2.setVisibility(View.VISIBLE);
                    lnp2y1.setVisibility(View.VISIBLE);
                    lnp2y2.setVisibility(View.VISIBLE);
                    lnp2y3.setVisibility(View.VISIBLE);
                    lnp2y4.setVisibility(View.VISIBLE);
                    lnp2y5.setVisibility(View.VISIBLE);
                    lnp2y6.setVisibility(View.VISIBLE);
                    lnp2y7.setVisibility(View.VISIBLE);
                    lcp2y1.setVisibility(View.VISIBLE);
                    lcp2y2.setVisibility(View.VISIBLE);
                    lcp2y3.setVisibility(View.VISIBLE);
                    lcp2y4.setVisibility(View.VISIBLE);
                    lcp2y5.setVisibility(View.VISIBLE);
                    lcp2y6.setVisibility(View.VISIBLE);
                    lcp2y7.setVisibility(View.VISIBLE);
                }

                if (sObject.getLimeNeed2().equals("Yes")) {
                    limlp2.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed2().equals("Yes")) {
                    dralp2.setVisibility(View.VISIBLE);
                }

                pl21= income21-(cost21+labor21);
                pl22= income22-(cost22+labor22);
                pl23= income23-(cost23+labor23);
                pl24= income24-(cost24+labor24);
                pl25= income25-(cost25+labor25);
                pl26= income26-(cost26+labor26);
                pl27= income27-(cost27+labor27);
                if(pl21 > 0){
                    plp2y1.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y1.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl22 > 0){
                    plp2y2.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y2.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl23 > 0){
                    plp2y3.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y3.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl24 > 0){
                    plp2y4.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y4.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl25 > 0){
                    plp2y5.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y5.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl26 > 0){
                    plp2y6.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y6.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl27 > 0){
                    plp2y7.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp2y7.setTextColor(Color.parseColor("#cc0000"));
                }

                setText2((TextView) findViewById(R.id.incomeY1P2), String.valueOf(dec.format(income21)));
                setText2((TextView) findViewById(R.id.incomeY2P2), String.valueOf(dec.format(income22)));
                setText2((TextView) findViewById(R.id.incomeY3P2), String.valueOf(dec.format(income23)));
                setText2((TextView) findViewById(R.id.incomeY4P2), String.valueOf(dec.format(income24)));
                setText2((TextView) findViewById(R.id.incomeY5P2), String.valueOf(dec.format(income25)));
                setText2((TextView) findViewById(R.id.incomeY6P2), String.valueOf(dec.format(income26)));
                setText2((TextView) findViewById(R.id.incomeY7P2), String.valueOf(dec.format(income27)));
                setText2((TextView) findViewById(R.id.costY1P2), String.valueOf(dec.format(cost21)));
                setText2((TextView) findViewById(R.id.costY2P2), String.valueOf(dec.format(cost22)));
                setText2((TextView) findViewById(R.id.costY3P2), String.valueOf(dec.format(cost23)));
                setText2((TextView) findViewById(R.id.costY4P2), String.valueOf(dec.format(cost24)));
                setText2((TextView) findViewById(R.id.costY5P2), String.valueOf(dec.format(cost25)));
                setText2((TextView) findViewById(R.id.costY6P2), String.valueOf(dec.format(cost26)));
                setText2((TextView) findViewById(R.id.costY7P2), String.valueOf(dec.format(cost27)));
                setText2((TextView) findViewById(R.id.manDaysY1P2), String.valueOf(laborD21));
                setText2((TextView) findViewById(R.id.manDaysY2P2), String.valueOf(laborD22));
                setText2((TextView) findViewById(R.id.manDaysY3P2), String.valueOf(laborD23));
                setText2((TextView) findViewById(R.id.manDaysY4P2), String.valueOf(laborD24));
                setText2((TextView) findViewById(R.id.manDaysY5P2), String.valueOf(laborD25));
                setText2((TextView) findViewById(R.id.manDaysY6P2), String.valueOf(laborD26));
                setText2((TextView) findViewById(R.id.manDaysY7P2), String.valueOf(laborD27));
                setText2((TextView) findViewById(R.id.laborY1P2), String.valueOf(dec.format(labor21)));
                setText2((TextView) findViewById(R.id.laborY2P2), String.valueOf(dec.format(labor22)));
                setText2((TextView) findViewById(R.id.laborY3P2), String.valueOf(dec.format(labor23)));
                setText2((TextView) findViewById(R.id.laborY4P2), String.valueOf(dec.format(labor24)));
                setText2((TextView) findViewById(R.id.laborY5P2), String.valueOf(dec.format(labor25)));
                setText2((TextView) findViewById(R.id.laborY6P2), String.valueOf(dec.format(labor26)));
                setText2((TextView) findViewById(R.id.laborY7P2), String.valueOf(dec.format(labor27)));
                setText2((TextView) findViewById(R.id.plY1P2), String.valueOf(dec.format(pl21)));
                setText2((TextView) findViewById(R.id.plY2P2), String.valueOf(dec.format(pl22)));
                setText2((TextView) findViewById(R.id.plY3P2), String.valueOf(dec.format(pl23)));
                setText2((TextView) findViewById(R.id.plY4P2), String.valueOf(dec.format(pl24)));
                setText2((TextView) findViewById(R.id.plY5P2), String.valueOf(dec.format(pl25)));
                setText2((TextView) findViewById(R.id.plY6P2), String.valueOf(dec.format(pl26)));
                setText2((TextView) findViewById(R.id.plY7P2), String.valueOf(dec.format(pl27)));
            }

            //plot3
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                p3.setVisibility(View.VISIBLE);

                if (sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())>25)){
                    //Replant
                    replp3.setVisibility(View.VISIBLE);
                    gaplp3.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG3().equals("B")){
                        exslp3.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD32 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD33 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD34 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD35 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD36 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD37 = (int) ((plot3Area * (getResources().getInteger(R.integer.replantY7Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor31 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor32 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor33 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor34 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor35 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor36 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor37 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost31 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost32 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost33 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost34 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost35 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost36 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost37 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY1Total)));
                            laborD32 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY2Total)));
                            laborD33 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY3Total)));
                            laborD34 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY4Total)));
                            laborD35 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY5Total)));
                            laborD36 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY6Total)));
                            laborD37 = (int) (plot3Area * (getResources().getInteger(R.integer.replantY7Total)));
                            labor31 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                            labor32 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                            labor33 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                            labor34 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                            labor35 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                            labor36 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                            labor37 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                        }
                        cost31 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                        cost32 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                        cost33 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                        cost34 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                        cost35 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                        cost36 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                        cost37 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
                    }

                    income31 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
                    income32 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
                    income33 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
                    income34 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
                    income35 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
                    income36 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
                    income37 =(int) ((plot3Area * (getResources().getInteger(R.integer.replantingY7))*avgCost));

                } else if((sObject.getFarmCondition3().equals("G")&&sObject.getGENETIC3().equals("B"))||(sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())<25))){
                    //Graft
                    grflp3.setVisibility(View.VISIBLE);
                    gaplp3.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG3().equals("B")){
                        exslp3.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD32 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD33 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD34 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD35 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD36 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD37 = (int) ((plot3Area * (getResources().getInteger(R.integer.graftY7Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor31 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor32 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor33 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor34 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor35 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor36 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor37 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost31 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost32 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost33 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost34 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost35 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost36 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost37 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else {
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY1Total)));
                            laborD32 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY2Total)));
                            laborD33 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY3Total)));
                            laborD34 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY4Total)));
                            laborD35 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY5Total)));
                            laborD36 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY6Total)));
                            laborD37 = (int) (plot3Area * (getResources().getInteger(R.integer.graftY7Total)));
                            labor31 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                            labor32 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                            labor33 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                            labor34 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                            labor35 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                            labor36 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                            labor37 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                        }
                        cost31 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                        cost32 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                        cost33 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                        cost34 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                        cost35 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                        cost36 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                        cost37 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                    }
                    income31 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                    income32 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                    income33 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                    income34 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                    income35 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                    income36 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                    income37 =(int) ((plot3Area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

                }else if (sObject.getSOILMNG3().equals("B")){
                    //Extra Soil Management
                    exslp3.setVisibility(View.VISIBLE);
                    gaplp3.setVisibility(View.VISIBLE);
                    if (sObject.getHireLabor3().equals("Yes")) {
                        laborD31 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                        laborD32 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                        laborD33 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                        laborD34 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                        laborD35 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                        laborD36 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                        laborD37 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                        labor31 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                        labor32 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                        labor33 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                        labor34 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                        labor35 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                        labor36 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                        labor37 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
                    }
                    cost31 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
                    cost32 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
                    cost33 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
                    cost34 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
                    cost35 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
                    cost36 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
                    cost37 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
                    income31 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
                    income32 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
                    income33 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
                    income34 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
                    income35 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
                    income36 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
                    income37 =(int) ((plot3Area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
                }else{
                    //GAP
                    gaplp3.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG3().equals("B")){
                        exslp3.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD32 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD33 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD34 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD35 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD36 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD37 = (int) ((plot3Area * (getResources().getInteger(R.integer.gapY7Total))) + (plot3Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor31 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor32 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor33 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor34 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor35 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor36 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor37 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot3Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost31 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost32 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost33 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost34 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost35 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost36 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost37 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(plot3Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor3().equals("Yes")) {
                            laborD31 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY1Total)));
                            laborD32 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY2Total)));
                            laborD33 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY3Total)));
                            laborD34 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY4Total)));
                            laborD35 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY5Total)));
                            laborD36 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY6Total)));
                            laborD37 = (int) (plot3Area * (getResources().getInteger(R.integer.gapY7Total)));
                            labor31 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                            labor32 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                            labor33 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                            labor34 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                            labor35 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                            labor36 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                            labor37 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                        }
                        cost31 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                        cost32 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                        cost33 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                        cost34 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                        cost35 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                        cost36 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                        cost37 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

                    }
                    income31 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
                    income32 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
                    income33 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
                    income34 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
                    income35 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
                    income36 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
                    income37 =(int) ((plot3Area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
                }

                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    lnp3.setVisibility(View.VISIBLE);
                    lcp3.setVisibility(View.VISIBLE);
                    lnp3y1.setVisibility(View.VISIBLE);
                    lnp3y2.setVisibility(View.VISIBLE);
                    lnp3y3.setVisibility(View.VISIBLE);
                    lnp3y4.setVisibility(View.VISIBLE);
                    lnp3y5.setVisibility(View.VISIBLE);
                    lnp3y6.setVisibility(View.VISIBLE);
                    lnp3y7.setVisibility(View.VISIBLE);
                    lcp3y1.setVisibility(View.VISIBLE);
                    lcp3y2.setVisibility(View.VISIBLE);
                    lcp3y3.setVisibility(View.VISIBLE);
                    lcp3y4.setVisibility(View.VISIBLE);
                    lcp3y5.setVisibility(View.VISIBLE);
                    lcp3y6.setVisibility(View.VISIBLE);
                    lcp3y7.setVisibility(View.VISIBLE);
                }

                if (sObject.getLimeNeed3().equals("Yes")) {
                    limlp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed3().equals("Yes")) {
                    dralp3.setVisibility(View.VISIBLE);
                }

                pl31= income31-(cost31+labor31);
                pl32= income32-(cost32+labor32);
                pl33= income33-(cost33+labor33);
                pl34= income34-(cost34+labor34);
                pl35= income35-(cost35+labor35);
                pl36= income36-(cost36+labor36);
                pl37= income37-(cost37+labor37);
                if(pl31 > 0){
                    plp3y1.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y1.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl32 > 0){
                    plp3y2.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y2.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl33 > 0){
                    plp3y3.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y3.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl34 > 0){
                    plp3y4.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y4.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl35 > 0){
                    plp3y5.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y5.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl36 > 0){
                    plp3y6.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y6.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl37 > 0){
                    plp3y7.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp3y7.setTextColor(Color.parseColor("#cc0000"));
                }

                setText2((TextView) findViewById(R.id.incomeY1P3), String.valueOf(dec.format(income31)));
                setText2((TextView) findViewById(R.id.incomeY2P3), String.valueOf(dec.format(income32)));
                setText2((TextView) findViewById(R.id.incomeY3P3), String.valueOf(dec.format(income33)));
                setText2((TextView) findViewById(R.id.incomeY4P3), String.valueOf(dec.format(income34)));
                setText2((TextView) findViewById(R.id.incomeY5P3), String.valueOf(dec.format(income35)));
                setText2((TextView) findViewById(R.id.incomeY6P3), String.valueOf(dec.format(income36)));
                setText2((TextView) findViewById(R.id.incomeY7P3), String.valueOf(dec.format(income37)));
                setText2((TextView) findViewById(R.id.costY1P3), String.valueOf(dec.format(cost31)));
                setText2((TextView) findViewById(R.id.costY2P3), String.valueOf(dec.format(cost32)));
                setText2((TextView) findViewById(R.id.costY3P3), String.valueOf(dec.format(cost33)));
                setText2((TextView) findViewById(R.id.costY4P3), String.valueOf(dec.format(cost34)));
                setText2((TextView) findViewById(R.id.costY5P3), String.valueOf(dec.format(cost35)));
                setText2((TextView) findViewById(R.id.costY6P3), String.valueOf(dec.format(cost36)));
                setText2((TextView) findViewById(R.id.costY7P3), String.valueOf(dec.format(cost37)));
                setText2((TextView) findViewById(R.id.manDaysY1P3), String.valueOf(laborD31));
                setText2((TextView) findViewById(R.id.manDaysY2P3), String.valueOf(laborD32));
                setText2((TextView) findViewById(R.id.manDaysY3P3), String.valueOf(laborD33));
                setText2((TextView) findViewById(R.id.manDaysY4P3), String.valueOf(laborD34));
                setText2((TextView) findViewById(R.id.manDaysY5P3), String.valueOf(laborD35));
                setText2((TextView) findViewById(R.id.manDaysY6P3), String.valueOf(laborD36));
                setText2((TextView) findViewById(R.id.manDaysY7P3), String.valueOf(laborD37));
                setText2((TextView) findViewById(R.id.laborY1P3), String.valueOf(dec.format(labor31)));
                setText2((TextView) findViewById(R.id.laborY2P3), String.valueOf(dec.format(labor32)));
                setText2((TextView) findViewById(R.id.laborY3P3), String.valueOf(dec.format(labor33)));
                setText2((TextView) findViewById(R.id.laborY4P3), String.valueOf(dec.format(labor34)));
                setText2((TextView) findViewById(R.id.laborY5P3), String.valueOf(dec.format(labor35)));
                setText2((TextView) findViewById(R.id.laborY6P3), String.valueOf(dec.format(labor36)));
                setText2((TextView) findViewById(R.id.laborY7P3), String.valueOf(dec.format(labor37)));
                setText2((TextView) findViewById(R.id.plY1P3), String.valueOf(dec.format(pl31)));
                setText2((TextView) findViewById(R.id.plY2P3), String.valueOf(dec.format(pl32)));
                setText2((TextView) findViewById(R.id.plY3P3), String.valueOf(dec.format(pl33)));
                setText2((TextView) findViewById(R.id.plY4P3), String.valueOf(dec.format(pl34)));
                setText2((TextView) findViewById(R.id.plY5P3), String.valueOf(dec.format(pl35)));
                setText2((TextView) findViewById(R.id.plY6P3), String.valueOf(dec.format(pl36)));
                setText2((TextView) findViewById(R.id.plY7P3), String.valueOf(dec.format(pl37)));
            }

            //plot4
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                p4.setVisibility(View.VISIBLE);

                if (sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())>25)){
                    //Replant
                    replp4.setVisibility(View.VISIBLE);
                    gaplp4.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG4().equals("B")){
                        exslp4.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD42 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD43 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD44 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD45 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD46 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD47 = (int) ((plot4Area * (getResources().getInteger(R.integer.replantY7Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor41 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor42 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor43 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor44 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor45 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor46 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor47 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost41 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost42 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost43 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost44 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost45 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost46 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost47 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY1Total)));
                            laborD42 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY2Total)));
                            laborD43 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY3Total)));
                            laborD44 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY4Total)));
                            laborD45 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY5Total)));
                            laborD46 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY6Total)));
                            laborD47 = (int) (plot4Area * (getResources().getInteger(R.integer.replantY7Total)));
                            labor41 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                            labor42 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                            labor43 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                            labor44 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                            labor45 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                            labor46 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                            labor47 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                        }
                        cost41 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                        cost42 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                        cost43 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                        cost44 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                        cost45 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                        cost46 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                        cost47 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
                    }

                    income41 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
                    income42 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
                    income43 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
                    income44 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
                    income45 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
                    income46 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
                    income47 =(int) ((plot4Area * (getResources().getInteger(R.integer.replantingY7))*avgCost));

                } else if((sObject.getFarmCondition4().equals("G")&&sObject.getGENETIC4().equals("B"))||(sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())<25))){
                    //Graft
                    grflp4.setVisibility(View.VISIBLE);
                    gaplp4.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG4().equals("B")){
                        exslp4.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD42 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD43 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD44 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD45 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD46 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD47 = (int) ((plot4Area * (getResources().getInteger(R.integer.graftY7Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor41 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor42 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor43 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor44 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor45 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor46 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor47 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost41 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost42 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost43 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost44 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost45 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost46 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost47 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else {
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY1Total)));
                            laborD42 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY2Total)));
                            laborD43 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY3Total)));
                            laborD44 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY4Total)));
                            laborD45 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY5Total)));
                            laborD46 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY6Total)));
                            laborD47 = (int) (plot4Area * (getResources().getInteger(R.integer.graftY7Total)));
                            labor41 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                            labor42 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                            labor43 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                            labor44 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                            labor45 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                            labor46 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                            labor47 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                        }
                        cost41 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                        cost42 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                        cost43 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                        cost44 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                        cost45 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                        cost46 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                        cost47 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                    }
                    income41 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                    income42 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                    income43 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                    income44 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                    income45 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                    income46 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                    income47 =(int) ((plot4Area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

                }else if (sObject.getSOILMNG4().equals("B")){
                    //Extra Soil Management
                    exslp4.setVisibility(View.VISIBLE);
                    gaplp4.setVisibility(View.VISIBLE);
                    if (sObject.getHireLabor4().equals("Yes")) {
                        laborD41 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                        laborD42 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                        laborD43 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                        laborD44 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                        laborD45 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                        laborD46 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                        laborD47 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                        labor41 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                        labor42 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                        labor43 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                        labor44 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                        labor45 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                        labor46 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                        labor47 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
                    }
                    cost41 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
                    cost42 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
                    cost43 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
                    cost44 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
                    cost45 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
                    cost46 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
                    cost47 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
                    income41 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
                    income42 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
                    income43 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
                    income44 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
                    income45 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
                    income46 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
                    income47 =(int) ((plot4Area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
                }else{
                    //GAP
                    gaplp4.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG4().equals("B")){
                        exslp4.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD42 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD43 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD44 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD45 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD46 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD47 = (int) ((plot4Area * (getResources().getInteger(R.integer.gapY7Total))) + (plot4Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor41 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor42 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor43 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor44 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor45 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor46 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor47 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot4Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost41 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost42 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost43 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost44 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost45 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost46 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost47 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(plot4Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor4().equals("Yes")) {
                            laborD41 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY1Total)));
                            laborD42 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY2Total)));
                            laborD43 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY3Total)));
                            laborD44 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY4Total)));
                            laborD45 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY5Total)));
                            laborD46 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY6Total)));
                            laborD47 = (int) (plot4Area * (getResources().getInteger(R.integer.gapY7Total)));
                            labor41 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                            labor42 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                            labor43 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                            labor44 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                            labor45 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                            labor46 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                            labor47 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                        }
                        cost41 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                        cost42 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                        cost43 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                        cost44 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                        cost45 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                        cost46 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                        cost47 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

                    }
                    income41 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
                    income42 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
                    income43 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
                    income44 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
                    income45 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
                    income46 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
                    income47 =(int) ((plot4Area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
                }

                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    lnp4.setVisibility(View.VISIBLE);
                    lcp4.setVisibility(View.VISIBLE);
                    lnp4y1.setVisibility(View.VISIBLE);
                    lnp4y2.setVisibility(View.VISIBLE);
                    lnp4y3.setVisibility(View.VISIBLE);
                    lnp4y4.setVisibility(View.VISIBLE);
                    lnp4y5.setVisibility(View.VISIBLE);
                    lnp4y6.setVisibility(View.VISIBLE);
                    lnp4y7.setVisibility(View.VISIBLE);
                    lcp4y1.setVisibility(View.VISIBLE);
                    lcp4y2.setVisibility(View.VISIBLE);
                    lcp4y3.setVisibility(View.VISIBLE);
                    lcp4y4.setVisibility(View.VISIBLE);
                    lcp4y5.setVisibility(View.VISIBLE);
                    lcp4y6.setVisibility(View.VISIBLE);
                    lcp4y7.setVisibility(View.VISIBLE);
                }

                if (sObject.geLimeNeed4().equals("Yes")) {
                    limlp4.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed4().equals("Yes")) {
                    dralp4.setVisibility(View.VISIBLE);
                }

                pl41= income41-(cost41+labor41);
                pl42= income42-(cost42+labor42);
                pl43= income43-(cost43+labor43);
                pl44= income44-(cost44+labor44);
                pl45= income45-(cost45+labor45);
                pl46= income46-(cost46+labor46);
                pl47= income47-(cost47+labor47);
                if(pl41 > 0){
                    plp4y1.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y1.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl42 > 0){
                    plp4y2.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y2.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl43 > 0){
                    plp4y3.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y3.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl44 > 0){
                    plp4y4.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y4.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl45 > 0){
                    plp4y5.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y5.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl46 > 0){
                    plp4y6.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y6.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl47 > 0){
                    plp4y7.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp4y7.setTextColor(Color.parseColor("#cc0000"));
                }

                setText2((TextView) findViewById(R.id.incomeY1P4), String.valueOf(dec.format(income41)));
                setText2((TextView) findViewById(R.id.incomeY2P4), String.valueOf(dec.format(income42)));
                setText2((TextView) findViewById(R.id.incomeY3P4), String.valueOf(dec.format(income43)));
                setText2((TextView) findViewById(R.id.incomeY4P4), String.valueOf(dec.format(income44)));
                setText2((TextView) findViewById(R.id.incomeY5P4), String.valueOf(dec.format(income45)));
                setText2((TextView) findViewById(R.id.incomeY6P4), String.valueOf(dec.format(income46)));
                setText2((TextView) findViewById(R.id.incomeY7P4), String.valueOf(dec.format(income47)));
                setText2((TextView) findViewById(R.id.costY1P4), String.valueOf(dec.format(cost41)));
                setText2((TextView) findViewById(R.id.costY2P4), String.valueOf(dec.format(cost42)));
                setText2((TextView) findViewById(R.id.costY3P4), String.valueOf(dec.format(cost43)));
                setText2((TextView) findViewById(R.id.costY4P4), String.valueOf(dec.format(cost44)));
                setText2((TextView) findViewById(R.id.costY5P4), String.valueOf(dec.format(cost45)));
                setText2((TextView) findViewById(R.id.costY6P4), String.valueOf(dec.format(cost46)));
                setText2((TextView) findViewById(R.id.costY7P4), String.valueOf(dec.format(cost47)));
                setText2((TextView) findViewById(R.id.manDaysY1P4), String.valueOf(laborD41));
                setText2((TextView) findViewById(R.id.manDaysY2P4), String.valueOf(laborD42));
                setText2((TextView) findViewById(R.id.manDaysY3P4), String.valueOf(laborD43));
                setText2((TextView) findViewById(R.id.manDaysY4P4), String.valueOf(laborD44));
                setText2((TextView) findViewById(R.id.manDaysY5P4), String.valueOf(laborD45));
                setText2((TextView) findViewById(R.id.manDaysY6P4), String.valueOf(laborD46));
                setText2((TextView) findViewById(R.id.manDaysY7P4), String.valueOf(laborD47));
                setText2((TextView) findViewById(R.id.laborY1P4), String.valueOf(dec.format(labor41)));
                setText2((TextView) findViewById(R.id.laborY2P4), String.valueOf(dec.format(labor42)));
                setText2((TextView) findViewById(R.id.laborY3P4), String.valueOf(dec.format(labor43)));
                setText2((TextView) findViewById(R.id.laborY4P4), String.valueOf(dec.format(labor44)));
                setText2((TextView) findViewById(R.id.laborY5P4), String.valueOf(dec.format(labor45)));
                setText2((TextView) findViewById(R.id.laborY6P4), String.valueOf(dec.format(labor46)));
                setText2((TextView) findViewById(R.id.laborY7P4), String.valueOf(dec.format(labor47)));
                setText2((TextView) findViewById(R.id.plY1P4), String.valueOf(dec.format(pl41)));
                setText2((TextView) findViewById(R.id.plY2P4), String.valueOf(dec.format(pl42)));
                setText2((TextView) findViewById(R.id.plY3P4), String.valueOf(dec.format(pl43)));
                setText2((TextView) findViewById(R.id.plY4P4), String.valueOf(dec.format(pl44)));
                setText2((TextView) findViewById(R.id.plY5P4), String.valueOf(dec.format(pl45)));
                setText2((TextView) findViewById(R.id.plY6P4), String.valueOf(dec.format(pl46)));
                setText2((TextView) findViewById(R.id.plY7P4), String.valueOf(dec.format(pl47)));
            }

            //plot5
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                p5.setVisibility(View.VISIBLE);

                if (sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())>25)){
                    //Replant
                    replp5.setVisibility(View.VISIBLE);
                    gaplp5.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG5().equals("B")){
                        exslp5.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD52 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD53 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD54 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD55 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD56 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD57 = (int) ((plot5Area * (getResources().getInteger(R.integer.replantY7Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor51 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor52 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor53 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor54 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor55 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor56 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor57 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost51 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost52 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost53 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost54 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost55 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost56 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost57 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY1Total)));
                            laborD52 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY2Total)));
                            laborD53 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY3Total)));
                            laborD54 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY4Total)));
                            laborD55 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY5Total)));
                            laborD56 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY6Total)));
                            laborD57 = (int) (plot5Area * (getResources().getInteger(R.integer.replantY7Total)));
                            labor51 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                            labor52 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                            labor53 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                            labor54 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                            labor55 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                            labor56 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                            labor57 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                        }
                        cost51 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                        cost52 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                        cost53 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                        cost54 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                        cost55 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                        cost56 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                        cost57 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
                    }

                    income51 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
                    income52 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
                    income53 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
                    income54 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
                    income55 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
                    income56 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
                    income57 =(int) ((plot5Area * (getResources().getInteger(R.integer.replantingY7))*avgCost));

                } else if((sObject.getFarmCondition5().equals("G")&&sObject.getGENETIC5().equals("B"))||(sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())<25))){
                    //Graft
                    grflp5.setVisibility(View.VISIBLE);
                    gaplp5.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG5().equals("B")){
                        exslp5.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD52 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD53 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD54 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD55 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD56 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD57 = (int) ((plot5Area * (getResources().getInteger(R.integer.graftY7Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor51 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor52 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor53 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor54 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor55 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor56 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor57 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost51 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost52 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost53 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost54 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost55 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost56 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost57 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else {
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY1Total)));
                            laborD52 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY2Total)));
                            laborD53 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY3Total)));
                            laborD54 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY4Total)));
                            laborD55 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY5Total)));
                            laborD56 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY6Total)));
                            laborD57 = (int) (plot5Area * (getResources().getInteger(R.integer.graftY7Total)));
                            labor51 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                            labor52 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                            labor53 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                            labor54 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                            labor55 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                            labor56 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                            labor57 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                        }
                        cost51 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                        cost52 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                        cost53 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                        cost54 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                        cost55 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                        cost56 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                        cost57 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                    }
                    income51 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                    income52 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                    income53 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                    income54 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                    income55 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                    income56 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                    income57 =(int) ((plot5Area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

                }else if (sObject.getSOILMNG5().equals("B")){
                    //Extra Soil Management
                    exslp5.setVisibility(View.VISIBLE);
                    gaplp5.setVisibility(View.VISIBLE);
                    if (sObject.getHireLabor5().equals("Yes")) {
                        laborD51 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                        laborD52 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                        laborD53 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                        laborD54 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                        laborD55 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                        laborD56 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                        laborD57 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                        labor51 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                        labor52 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                        labor53 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                        labor54 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                        labor55 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                        labor56 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                        labor57 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
                    }
                    cost51 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
                    cost52 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
                    cost53 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
                    cost54 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
                    cost55 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
                    cost56 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
                    cost57 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
                    income51 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
                    income52 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
                    income53 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
                    income54 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
                    income55 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
                    income56 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
                    income57 =(int) ((plot5Area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
                }else{
                    //GAP
                    gaplp5.setVisibility(View.VISIBLE);
                    if (sObject.getSOILMNG5().equals("B")){
                        exslp5.setVisibility(View.VISIBLE);
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY1Total))));
                            laborD52 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY2Total))));
                            laborD53 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY3Total))));
                            laborD54 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY4Total))));
                            laborD55 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY5Total))));
                            laborD56 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY6Total))));
                            laborD57 = (int) ((plot5Area * (getResources().getInteger(R.integer.gapY7Total))) + (plot5Area * (getResources().getInteger(R.integer.difDaysY7Total))));
                            labor51 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY1Total))));
                            labor52 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY2Total))));
                            labor53 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY3Total))));
                            labor54 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY4Total))));
                            labor55 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY5Total))));
                            labor56 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY6Total))));
                            labor57 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (plot5Area * (getResources().getInteger(R.integer.difLaborY7Total))));
                        }
                        cost51 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY1Total))));
                        cost52 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY2Total))));
                        cost53 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY3Total))));
                        cost54 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY4Total))));
                        cost55 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY5Total))));
                        cost56 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY6Total))));
                        cost57 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(plot5Area * (getResources().getInteger(R.integer.difInputY7Total))));
                    }else{
                        if (sObject.getHireLabor5().equals("Yes")) {
                            laborD51 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY1Total)));
                            laborD52 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY2Total)));
                            laborD53 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY3Total)));
                            laborD54 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY4Total)));
                            laborD55 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY5Total)));
                            laborD56 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY6Total)));
                            laborD57 = (int) (plot5Area * (getResources().getInteger(R.integer.gapY7Total)));
                            labor51 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                            labor52 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                            labor53 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                            labor54 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                            labor55 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                            labor56 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                            labor57 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                        }
                        cost51 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                        cost52 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                        cost53 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                        cost54 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                        cost55 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                        cost56 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                        cost57 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

                    }
                    income51 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
                    income52 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
                    income53 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
                    income54 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
                    income55 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
                    income56 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
                    income57 =(int) ((plot5Area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
                }

                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    lnp5.setVisibility(View.VISIBLE);
                    lcp5.setVisibility(View.VISIBLE);
                    lnp5y1.setVisibility(View.VISIBLE);
                    lnp5y2.setVisibility(View.VISIBLE);
                    lnp5y3.setVisibility(View.VISIBLE);
                    lnp5y4.setVisibility(View.VISIBLE);
                    lnp5y5.setVisibility(View.VISIBLE);
                    lnp5y6.setVisibility(View.VISIBLE);
                    lnp5y7.setVisibility(View.VISIBLE);
                    lcp5y1.setVisibility(View.VISIBLE);
                    lcp5y2.setVisibility(View.VISIBLE);
                    lcp5y3.setVisibility(View.VISIBLE);
                    lcp5y4.setVisibility(View.VISIBLE);
                    lcp5y5.setVisibility(View.VISIBLE);
                    lcp5y6.setVisibility(View.VISIBLE);
                    lcp5y7.setVisibility(View.VISIBLE);
                }
                if (sObject.getLimeNeed5().equals("Yes")) {
                    limlp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed5().equals("Yes")) {
                    dralp5.setVisibility(View.VISIBLE);
                }
                pl51= income51-(cost51+labor51);
                pl52= income52-(cost52+labor52);
                pl53= income53-(cost53+labor53);
                pl54= income54-(cost54+labor54);
                pl55= income55-(cost55+labor55);
                pl56= income56-(cost56+labor56);
                pl57= income57-(cost57+labor57);
                if(pl51 > 0){
                    plp5y1.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y1.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl52 > 0){
                    plp5y2.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y2.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl53 > 0){
                    plp5y3.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y3.setTextColor(Color.parseColor("#cc0000"));
                }

                if(pl54 > 0){
                    plp5y4.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y4.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl55 > 0){
                    plp5y5.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y5.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl56 > 0){
                    plp5y6.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y6.setTextColor(Color.parseColor("#cc0000"));
                }
                if(pl57 > 0){
                    plp5y7.setTextColor(Color.parseColor("#29a329"));
                }else{
                    plp5y7.setTextColor(Color.parseColor("#cc0000"));
                }

                setText2((TextView) findViewById(R.id.incomeY1P5), String.valueOf(dec.format(income51)));
                setText2((TextView) findViewById(R.id.incomeY2P5), String.valueOf(dec.format(income52)));
                setText2((TextView) findViewById(R.id.incomeY3P5), String.valueOf(dec.format(income53)));
                setText2((TextView) findViewById(R.id.incomeY4P5), String.valueOf(dec.format(income54)));
                setText2((TextView) findViewById(R.id.incomeY5P5), String.valueOf(dec.format(income55)));
                setText2((TextView) findViewById(R.id.incomeY6P5), String.valueOf(dec.format(income56)));
                setText2((TextView) findViewById(R.id.incomeY7P5), String.valueOf(dec.format(income57)));
                setText2((TextView) findViewById(R.id.costY1P5), String.valueOf(dec.format(cost51)));
                setText2((TextView) findViewById(R.id.costY2P5), String.valueOf(dec.format(cost52)));
                setText2((TextView) findViewById(R.id.costY3P5), String.valueOf(dec.format(cost53)));
                setText2((TextView) findViewById(R.id.costY4P5), String.valueOf(dec.format(cost54)));
                setText2((TextView) findViewById(R.id.costY5P5), String.valueOf(dec.format(cost55)));
                setText2((TextView) findViewById(R.id.costY6P5), String.valueOf(dec.format(cost56)));
                setText2((TextView) findViewById(R.id.costY7P5), String.valueOf(dec.format(cost57)));
                setText2((TextView) findViewById(R.id.manDaysY1P5), String.valueOf(laborD51));
                setText2((TextView) findViewById(R.id.manDaysY2P5), String.valueOf(laborD52));
                setText2((TextView) findViewById(R.id.manDaysY3P5), String.valueOf(laborD53));
                setText2((TextView) findViewById(R.id.manDaysY4P5), String.valueOf(laborD54));
                setText2((TextView) findViewById(R.id.manDaysY5P5), String.valueOf(laborD55));
                setText2((TextView) findViewById(R.id.manDaysY6P5), String.valueOf(laborD56));
                setText2((TextView) findViewById(R.id.manDaysY7P5), String.valueOf(laborD57));
                setText2((TextView) findViewById(R.id.laborY1P5), String.valueOf(dec.format(labor51)));
                setText2((TextView) findViewById(R.id.laborY2P5), String.valueOf(dec.format(labor52)));
                setText2((TextView) findViewById(R.id.laborY3P5), String.valueOf(dec.format(labor53)));
                setText2((TextView) findViewById(R.id.laborY4P5), String.valueOf(dec.format(labor54)));
                setText2((TextView) findViewById(R.id.laborY5P5), String.valueOf(dec.format(labor55)));
                setText2((TextView) findViewById(R.id.laborY6P5), String.valueOf(dec.format(labor56)));
                setText2((TextView) findViewById(R.id.laborY7P5), String.valueOf(dec.format(labor57)));
                setText2((TextView) findViewById(R.id.plY1P5), String.valueOf(dec.format(pl51)));
                setText2((TextView) findViewById(R.id.plY2P5), String.valueOf(dec.format(pl52)));
                setText2((TextView) findViewById(R.id.plY3P5), String.valueOf(dec.format(pl53)));
                setText2((TextView) findViewById(R.id.plY4P5), String.valueOf(dec.format(pl54)));
                setText2((TextView) findViewById(R.id.plY5P5), String.valueOf(dec.format(pl55)));
                setText2((TextView) findViewById(R.id.plY6P5), String.valueOf(dec.format(pl56)));
                setText2((TextView) findViewById(R.id.plY7P5), String.valueOf(dec.format(pl57)));
            }

            //net income cocoa
            int totalIncomeY1 = income11+income21+income31+income41+income51;
            int totalIncomeY2 = income12+income22+income32+income42+income52;
            int totalIncomeY3 = income13+income23+income33+income43+income53;
            int totalIncomeY4 = income14+income24+income34+income44+income54;
            int totalIncomeY5 = income15+income25+income35+income45+income55;
            int totalIncomeY6 = income16+income26+income36+income46+income56;
            int totalIncomeY7 = income17+income27+income37+income47+income57;
            setText2((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(dec.format(totalIncomeY1)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(dec.format(totalIncomeY2)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(dec.format(totalIncomeY3)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(dec.format(totalIncomeY4)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(dec.format(totalIncomeY5)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(dec.format(totalIncomeY6)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(dec.format(totalIncomeY7)));

            //net income other crops
            double otherCrops = Double.parseDouble(sObject.getIncomeothercrops().toString());
            setText2((TextView) findViewById(R.id.otherCropY1_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY2_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY3_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY4_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY5_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY6_field), String.valueOf(dec.format(otherCrops)));
            setText2((TextView) findViewById(R.id.otherCropY7_field), String.valueOf(dec.format(otherCrops)));

            //net income farming
            int farmingy1 = (int) (totalIncomeY1+otherCrops);
            int farmingy2 = (int) (totalIncomeY2+otherCrops);
            int farmingy3 = (int) (totalIncomeY3+otherCrops);
            int farmingy4 = (int) (totalIncomeY4+otherCrops);
            int farmingy5 = (int) (totalIncomeY5+otherCrops);
            int farmingy6 = (int) (totalIncomeY6+otherCrops);
            int farmingy7 = (int) (totalIncomeY7+otherCrops);
            setText2((TextView) findViewById(R.id.netFarmingY1_field), String.valueOf(dec.format(farmingy1)));
            setText2((TextView) findViewById(R.id.netFarmingY2_field), String.valueOf(dec.format(farmingy2)));
            setText2((TextView) findViewById(R.id.netFarmingY3_field), String.valueOf(dec.format(farmingy3)));
            setText2((TextView) findViewById(R.id.netFarmingY4_field), String.valueOf(dec.format(farmingy4)));
            setText2((TextView) findViewById(R.id.netFarmingY5_field), String.valueOf(dec.format(farmingy5)));
            setText2((TextView) findViewById(R.id.netFarmingY6_field), String.valueOf(dec.format(farmingy6)));
            setText2((TextView) findViewById(R.id.netFarmingY7_field), String.valueOf(dec.format(farmingy7)));

            //net other income sources
            double moneyBack = Double.parseDouble(sObject.getLoanmoneygetback().toString());
            double hhSavings = Double.parseDouble(sObject.getHouseholdsavings().toString());
            double farmWork = Double.parseDouble(sObject.getIncomefarmlabor().toString());
            double spouseWork = Double.parseDouble(sObject.getSpouseincome().toString());
            double familyWork = Double.parseDouble(sObject.getFamilymembersincome().toString());
            int totalOtherIncome = (int) (moneyBack + hhSavings+farmWork+spouseWork+familyWork);
            setText2((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(dec.format(totalOtherIncome)));

            //total income
            int totalIncomeAllY1 = farmingy1 + totalOtherIncome;
            int totalIncomeAllY2 = farmingy2 + totalOtherIncome;
            int totalIncomeAllY3 = farmingy3 + totalOtherIncome;
            int totalIncomeAllY4 = farmingy4 + totalOtherIncome;
            int totalIncomeAllY5 = farmingy5 + totalOtherIncome;
            int totalIncomeAllY6 = farmingy6 + totalOtherIncome;
            int totalIncomeAllY7 = farmingy7 + totalOtherIncome;
            setText2((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(dec.format(totalIncomeAllY1)));
            setText2((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(dec.format(totalIncomeAllY2)));
            setText2((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(dec.format(totalIncomeAllY3)));
            setText2((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(dec.format(totalIncomeAllY4)));
            setText2((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(dec.format(totalIncomeAllY5)));
            setText2((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(dec.format(totalIncomeAllY6)));
            setText2((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(dec.format(totalIncomeAllY7)));

            //total family costs
            double anLivExpen = Double.parseDouble(sObject.getAnnuallivingexpenses().toString());
            double anOtherExp = Double.parseDouble(sObject.getAnnualotherexpenses().toString());
            double expEducExp = Double.parseDouble(sObject.getExpectededucationexpenses().toString());
            double credPay = Double.parseDouble(sObject.getHowmuchpayforcredit().toString());
            int totalExpenses = (int) (anLivExpen+anOtherExp+expEducExp+credPay);
            setText2((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(dec.format(totalExpenses)));

            // net family income
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
            setText2((TextView) findViewById(R.id.netFamilyY1_field), String.valueOf(dec.format(availableY1)));
            if(availableY1 > 0){
                found1.setTextColor(Color.parseColor("#29a329"));
            }else{
                found1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY2_field), String.valueOf(dec.format(availableY2)));
            if(availableY2 > 0){
                found2.setTextColor(Color.parseColor("#29a329"));
            }else{
                found2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY3_field), String.valueOf(dec.format(availableY3)));
            if(availableY3 > 0){
                found3.setTextColor(Color.parseColor("#29a329"));
            }else{
                found3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY4_field), String.valueOf(dec.format(availableY4)));
            if(availableY4 > 0){
                found4.setTextColor(Color.parseColor("#29a329"));
            }else{
                found4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY5_field), String.valueOf(dec.format(availableY5)));
            if(availableY5 > 0){
                found5.setTextColor(Color.parseColor("#29a329"));
            }else{
                found5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY6_field), String.valueOf(dec.format(availableY6)));
            if(availableY6 > 0){
                found6.setTextColor(Color.parseColor("#29a329"));
            }else{
                found6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.netFamilyY7_field), String.valueOf(dec.format(availableY7)));
            if(availableY7 > 0){
                found7.setTextColor(Color.parseColor("#29a329"));
            }else{
                found7.setTextColor(Color.parseColor("#cc0000"));
            }

            //found needed
            int totalY1 = cost11+labor11+cost21+labor21+cost31+labor31+cost41+labor41+cost51+labor51;
            int totalY2 = cost12+labor12+cost22+labor22+cost32+labor32+cost42+labor42+cost52+labor52;
            int totalY3 = cost13+labor13+cost23+labor23+cost33+labor33+cost43+labor43+cost53+labor53;
            int totalY4 = cost14+labor14+cost24+labor24+cost34+labor34+cost44+labor44+cost54+labor54;
            int totalY5 = cost15+labor15+cost25+labor25+cost35+labor35+cost45+labor45+cost55+labor55;
            int totalY6 = cost16+labor16+cost26+labor26+cost36+labor36+cost46+labor46+cost56+labor56;
            int totalY7 = cost17+labor17+cost27+labor27+cost37+labor37+cost47+labor47+cost57+labor57;
            setText2((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(dec.format(totalY1)));
            setText2((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(dec.format(totalY2)));
            setText2((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(dec.format(totalY3)));
            setText2((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(dec.format(totalY4)));
            setText2((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(dec.format(totalY5)));
            setText2((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(dec.format(totalY6)));
            setText2((TextView) findViewById(R.id.foundsNeededY7_field), String.valueOf(dec.format(totalY7)));

            //profit or lost
            int pl1 = availableY1-totalY1;
            int pl2 = availableY2-totalY2;
            int pl3 = availableY3-totalY3;
            int pl4 = availableY4-totalY4;
            int pl5 = availableY5-totalY5;
            int pl6 = availableY6-totalY6;
            int pl7 = availableY7-totalY7;
            setText2((TextView) findViewById(R.id.profitOrLostY1_field), String.valueOf(dec.format(pl1)));
            if(pl1 > 0){
                pyl1.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY2_field), String.valueOf(dec.format(pl2)));
            if(pl2 > 0){
                pyl2.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY3_field), String.valueOf(dec.format(pl3)));
            if(pl3 > 0){
                pyl3.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY4_field), String.valueOf(dec.format(pl4)));
            if(pl4 > 0){
                pyl4.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY5_field), String.valueOf(dec.format(pl5)));
            if(pl5 > 0){
                pyl5.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY6_field), String.valueOf(dec.format(pl6)));
            if(pl6 > 0){
                pyl6.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.profitOrLostY7_field), String.valueOf(dec.format(pl7)));
            if(pl7 > 0){
                pyl7.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl7.setTextColor(Color.parseColor("#cc0000"));
            }
        }
    }

    private void setText2(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String start1 = ((Spinner) findViewById(R.id.startP1_field)).getSelectedItem().toString();
        final String start2 = ((Spinner) findViewById(R.id.startP2_field)).getSelectedItem().toString();
        final String start3 = ((Spinner) findViewById(R.id.startP3_field)).getSelectedItem().toString();
        final String start4 = ((Spinner) findViewById(R.id.startP4_field)).getSelectedItem().toString();
        final String start5 = ((Spinner) findViewById(R.id.startP5_field)).getSelectedItem().toString();
        final String agree = ((Spinner) findViewById(R.id.farmerAgree_field)).getSelectedItem().toString();
        final String coments = ((EditText) findViewById(R.id.reasonNotAgree_field)).getText().toString();
        final SmartStore smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
        JSONObject contact;
        try {
            boolean isCreate = TextUtils.isEmpty(objectId);
            if (!isCreate) {
                contact = smartStore.retrieve(ContactListLoader.CONTACT_SOUP,
                        smartStore.lookupSoupEntryId(ContactListLoader.CONTACT_SOUP,
                                Constants.ID, objectId)).getJSONObject(0);
            } else {
                contact = new JSONObject();
                contact.put(Constants.ID, "local_" + System.currentTimeMillis()
                        + Constants.EMPTY_STRING);
                final JSONObject attributes = new JSONObject();
                attributes.put(Constants.TYPE.toLowerCase(), Constants.SUBMISSION);
                contact.put(Constants.ATTRIBUTES, attributes);
            }
            contact.put(ContactObject.STARTYEARP1, start1);
            contact.put(ContactObject.STARTYEARP2, start2);
            contact.put(ContactObject.STARTYEARP3, start3);
            contact.put(ContactObject.STARTYEARP4, start4);
            contact.put(ContactObject.STARTYEARP5, start5);
            contact.put(ContactObject.AGREERECOMENDATIONS,agree);
            contact.put(ContactObject.REASONSNOTAGREED,coments);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Save successful!", Toast.LENGTH_LONG).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}
