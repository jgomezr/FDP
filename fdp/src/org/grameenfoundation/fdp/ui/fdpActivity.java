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
import android.widget.LinearLayout;
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
    private LinearLayout p1,p2,p3,p4,p5;
    private Spinner st1,st2,st3,st4,st5;
    private TextView gaplp1,grflp1,replp1,exslp1,limlp1,dralp1,fillp1,lablp1,gaplp2,grflp2,replp2,exslp2,limlp2,dralp2,fillp2,lablp2,gaplp3,grflp3,replp3,exslp3,limlp3,dralp3,fillp3,lablp3,gaplp4,grflp4,replp4,exslp4,limlp4,dralp4,fillp4,lablp4,gaplp5,grflp5,replp5,exslp5,limlp5,dralp5,fillp5,lablp5,found1,found2,found3,found4,found5,found6,found7,pyl1,pyl2,pyl3,pyl4,pyl5,pyl6,pyl7;

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
        p1 = (LinearLayout)findViewById(R.id.P1_label);
        p2 = (LinearLayout)findViewById(R.id.P2_label);
        p3 = (LinearLayout)findViewById(R.id.P3_label);
        p4 = (LinearLayout)findViewById(R.id.P4_label);
        p5 = (LinearLayout)findViewById(R.id.P5_label);
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
        found1 = (TextView)findViewById(R.id.foundsAvailableY1_field);
        found2 = (TextView)findViewById(R.id.foundsAvailableY2_field);
        found3 = (TextView)findViewById(R.id.foundsAvailableY3_field);
        found4 = (TextView)findViewById(R.id.foundsAvailableY4_field);
        found5 = (TextView)findViewById(R.id.foundsAvailableY5_field);
        found6 = (TextView)findViewById(R.id.foundsAvailableY6_field);
        found7 = (TextView)findViewById(R.id.foundsAvailableY7_field);
        pyl1 = (TextView)findViewById(R.id.profitOrLostY1_field);
        pyl2 = (TextView)findViewById(R.id.profitOrLostY2_field);
        pyl3 = (TextView)findViewById(R.id.profitOrLostY3_field);
        pyl4 = (TextView)findViewById(R.id.profitOrLostY4_field);
        pyl5 = (TextView)findViewById(R.id.profitOrLostY5_field);
        pyl6 = (TextView)findViewById(R.id.profitOrLostY6_field);
        pyl7 = (TextView)findViewById(R.id.profitOrLostY7_field);
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
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "3");
        startActivity(yearIntent);
    }
    public void launchYear4(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity2.class);
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
        final Intent yearIntent = new Intent(this, YearDetailActivity2.class);
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

            int est11 = 0;
            int est12 = 0;
            int est13 = 0;
            int est14 = 0;
            int est15 = 0;
            int est16 = 0;
            int est17 = 0;
            int est21 = 0;
            int est22 = 0;
            int est23 = 0;
            int est24 = 0;
            int est25 = 0;
            int est26 = 0;
            int est27 = 0;
            int est31 = 0;
            int est32 = 0;
            int est33 = 0;
            int est34 = 0;
            int est35 = 0;
            int est36 = 0;
            int est37 = 0;
            int est41 = 0;
            int est42 = 0;
            int est43 = 0;
            int est44 = 0;
            int est45 = 0;
            int est46 = 0;
            int est47 = 0;
            int est51 = 0;
            int est52 = 0;
            int est53 = 0;
            int est54 = 0;
            int est55 = 0;
            int est56 = 0;
            int est57 = 0;
            int replantingY1 = 450;
            int replantingY2 = 0;
            int replantingY3 = 250;
            int replantingY4 = 1000;
            int replantingY5 = 1500;
            int replantingY6 = 2000;
            int replantingY7 = 2000;
            int graftingY1 = 450;
            int graftingY2 = 500;
            int graftingY3 = 1500;
            int graftingY4 = 2000;
            int graftingY5 = 2000;
            int graftingY6 = 2000;
            int graftingY7 = 2000;
            int extraSoilY1 = 1000;
            int extraSoilY2 = 1500;
            int extraSoilY3 = 2000;
            int extraSoilY4 = 2000;
            int extraSoilY5 = 2000;
            int extraSoilY6 = 2000;
            int extraSoilY7 = 2000;
            int gapsY1 = 2000;
            int gapsY2 = 2000;
            int gapsY3 = 2000;
            int gapsY4 = 2000;
            int gapsY5 = 2000;
            int gapsY6 = 2000;
            int gapsY7 = 2000;

            int gapP1Y1 = 0;
            int gapP1Y2 = 0;
            int gapP1Y3 = 0;
            int gapP1Y4 = 0;
            int gapP1Y5 = 0;
            int gapP1Y6 = 0;
            int gapP1Y7 = 0;
            int gapP2Y1 = 0;
            int gapP2Y2 = 0;
            int gapP2Y3 = 0;
            int gapP2Y4 = 0;
            int gapP2Y5 = 0;
            int gapP2Y6 = 0;
            int gapP2Y7 = 0;
            int gapP3Y1 = 0;
            int gapP3Y2 = 0;
            int gapP3Y3 = 0;
            int gapP3Y4 = 0;
            int gapP3Y5 = 0;
            int gapP3Y6 = 0;
            int gapP3Y7 = 0;
            int gapP4Y1 = 0;
            int gapP4Y2 = 0;
            int gapP4Y3 = 0;
            int gapP4Y4 = 0;
            int gapP4Y5 = 0;
            int gapP4Y6 = 0;
            int gapP4Y7 = 0;
            int gapP5Y1 = 0;
            int gapP5Y2 = 0;
            int gapP5Y3 = 0;
            int gapP5Y4 = 0;
            int gapP5Y5 = 0;
            int gapP5Y6 = 0;
            int gapP5Y7 = 0;

            int laborP1Y1 =0;
            int laborP1Y2 =0;
            int laborP1Y3 =0;
            int laborP1Y4 =0;
            int laborP1Y5 =0;
            int laborP1Y6 =0;
            int laborP1Y7 =0;
            int laborP2Y1 =0;
            int laborP2Y2 =0;
            int laborP2Y3 =0;
            int laborP2Y4 =0;
            int laborP2Y5 =0;
            int laborP2Y6 =0;
            int laborP2Y7 =0;
            int laborP3Y1 =0;
            int laborP3Y2 =0;
            int laborP3Y3 =0;
            int laborP3Y4 =0;
            int laborP3Y5 =0;
            int laborP3Y6 =0;
            int laborP3Y7 =0;
            int laborP4Y1 =0;
            int laborP4Y2 =0;
            int laborP4Y3 =0;
            int laborP4Y4 =0;
            int laborP4Y5 =0;
            int laborP4Y6 =0;
            int laborP4Y7 =0;
            int laborP5Y1 =0;
            int laborP5Y2 =0;
            int laborP5Y3 =0;
            int laborP5Y4 =0;
            int laborP5Y5 =0;
            int laborP5Y6 =0;
            int laborP5Y7 =0;

            int limeP1Y1 = 0;
            int limeP1Y2 = 0;
            int limeP1Y3 = 0;
            int limeP1Y4 = 0;
            int limeP1Y5 = 0;
            int limeP1Y6 = 0;
            int limeP1Y7 = 0;
            int limeP2Y1 = 0;
            int limeP2Y2 = 0;
            int limeP2Y3 = 0;
            int limeP2Y4 = 0;
            int limeP2Y5 = 0;
            int limeP2Y6 = 0;
            int limeP2Y7 = 0;
            int limeP3Y1 = 0;
            int limeP3Y2 = 0;
            int limeP3Y3 = 0;
            int limeP3Y4 = 0;
            int limeP3Y5 = 0;
            int limeP3Y6 = 0;
            int limeP3Y7 = 0;
            int limeP4Y1 = 0;
            int limeP4Y2 = 0;
            int limeP4Y3 = 0;
            int limeP4Y4 = 0;
            int limeP4Y5 = 0;
            int limeP4Y6 = 0;
            int limeP4Y7 = 0;
            int limeP5Y1 = 0;
            int limeP5Y2 = 0;
            int limeP5Y3 = 0;
            int limeP5Y4 = 0;
            int limeP5Y5 = 0;
            int limeP5Y6 = 0;
            int limeP5Y7 = 0;

            double plot1Area = Double.valueOf(sObject.getPlot1Area().toString());
            double plot2Area = Double.valueOf(sObject.getPlot2Area().toString());
            double plot3Area = Double.valueOf(sObject.getPlot3Area().toString());
            double plot4Area = Double.valueOf(sObject.getPlot4Area().toString());
            double plot5Area = Double.valueOf(sObject.getPlot5Area().toString());
            DecimalFormat dec = new DecimalFormat("IDR ###,###,###");

            if (sObject.getFarmCondition1().equals("N/A") || sObject.getTreeDensity1().equals("N/A") || sObject.getDebilitatingDisease1().equals("N/A")|| sObject.getPlantingMaterial1().equals("N/A")){
                p1.setVisibility(View.GONE);
                st1.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                //Replanting
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = (int) (plot1Area * 28412500);
                int rep2P1 = (int) (plot1Area * 19753000);
                int rep3P1 = (int) (plot1Area * 20640500);
                int rep4P1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*replantingY1);
                est12 = (int)(plot1Area*replantingY2);
                est13 = (int)(plot1Area*replantingY3);
                est14 = (int)(plot1Area*replantingY4);
                est15 = (int)(plot1Area*replantingY5);
                est16 = (int)(plot1Area*replantingY6);
                est17 = (int)(plot1Area*replantingY7);

                gapP1Y1 = rep1P1;
                gapP1Y2 = rep2P1;
                gapP1Y3 = rep3P1;
                gapP1Y4 = rep4P1;
                gapP1Y5 = rep4P1;
                gapP1Y6 = rep4P1;
                gapP1Y7 = rep4P1;

                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(dec.format(gapP1Y1)));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(dec.format(gapP1Y2)));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(dec.format(gapP1Y3)));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(dec.format(gapP1Y4)));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(dec.format(gapP1Y5)));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(dec.format(gapP1Y6)));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(dec.format(gapP1Y7)));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int labRep1P1 = (int) (plot1Area * 12150000);
                    int labRep2P1 = (int) (plot1Area * 6375000);
                    int labRep3P1 = (int) (plot1Area * 6975000);
                    int labRep4P1 = (int) (plot1Area * 11250000);
                    int labRep5P1 = (int) (plot1Area * 12075000);

                    laborP1Y1 =labRep1P1;
                    laborP1Y2 =labRep2P1;
                    laborP1Y3 =labRep3P1;
                    laborP1Y4 =labRep4P1;
                    laborP1Y5 =labRep5P1;
                    laborP1Y6 =labRep5P1;
                    laborP1Y7 =labRep5P1;

                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(dec.format(laborP1Y1)));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(dec.format(laborP1Y2)));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(dec.format(laborP1Y3)));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(dec.format(laborP1Y4)));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(dec.format(laborP1Y5)));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(dec.format(laborP1Y6)));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(dec.format(laborP1Y7)));
                }
                if (sObject.getLimeNeed1().equals("Yes")||sObject.getDrainageNeed1().equals("Yes")) {
                    limlp1.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed1().equals("Yes")) {
                    dralp1.setVisibility(View.VISIBLE);
                }
            } else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                //Grafting
                grflp1.setVisibility(View.VISIBLE);
                int graf1P1 = (int) (plot1Area * 24392500);
                int graf2P1 = (int) (plot1Area * 22358500);
                int graf3P1 = (int) (plot1Area * 23722000);
                int graf4P1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*graftingY1);
                est12 = (int)(plot1Area*graftingY2);
                est13 = (int)(plot1Area*graftingY3);
                est14 = (int)(plot1Area*graftingY4);
                est15 = (int)(plot1Area*graftingY5);
                est16 = (int)(plot1Area*graftingY6);
                est17 = (int)(plot1Area*graftingY7);

                gapP1Y1 = graf1P1;
                gapP1Y2 = graf2P1;
                gapP1Y3 = graf3P1;
                gapP1Y4 = graf4P1;
                gapP1Y5 = graf4P1;
                gapP1Y6 = graf4P1;
                gapP1Y7 = graf4P1;

                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(dec.format(gapP1Y1)));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(dec.format(gapP1Y2)));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(dec.format(gapP1Y3)));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(dec.format(gapP1Y4)));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(dec.format(gapP1Y5)));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(dec.format(gapP1Y6)));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(dec.format(gapP1Y7)));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int laborGraf1P1 = (int) (plot1Area * 12000000);
                    int laborGraf2P1 = (int) (plot1Area * 7200000);
                    int laborGraf3P1 = (int) (plot1Area * 12075000);

                    laborP1Y1 =laborGraf1P1;
                    laborP1Y2 =laborGraf2P1;
                    laborP1Y3 =laborGraf3P1;
                    laborP1Y4 =laborGraf3P1;
                    laborP1Y5 =laborGraf3P1;
                    laborP1Y6 =laborGraf3P1;
                    laborP1Y7 =laborGraf3P1;

                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(dec.format(laborP1Y1)));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(dec.format(laborP1Y2)));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(dec.format(laborP1Y3)));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(dec.format(laborP1Y4)));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(dec.format(laborP1Y5)));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(dec.format(laborP1Y6)));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(dec.format(laborP1Y7)));
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
            } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                 //Extra Soil Management
                 exslp1.setVisibility(View.VISIBLE);
                 int eSoil1P1 = (int) (plot1Area * 26472000);
                int eSoil1P2 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*extraSoilY1);
                est12 = (int)(plot1Area*extraSoilY2);
                est13 = (int)(plot1Area*extraSoilY3);
                est14 = (int)(plot1Area*extraSoilY4);
                est15 = (int)(plot1Area*extraSoilY5);
                est16 = (int)(plot1Area*extraSoilY6);
                est17 = (int)(plot1Area*extraSoilY7);
                gapP1Y1 = eSoil1P1;
                gapP1Y2 = eSoil1P1;
                gapP1Y3 = eSoil1P2;
                gapP1Y4 = eSoil1P2;
                gapP1Y5 = eSoil1P2;
                gapP1Y6 = eSoil1P2;
                gapP1Y7 = eSoil1P2;
                 setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(dec.format(gapP1Y1)));
                 setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(dec.format(gapP1Y2)));
                 setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(dec.format(gapP1Y3)));
                 setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(dec.format(gapP1Y4)));
                 setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(dec.format(gapP1Y5)));
                 setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(dec.format(gapP1Y6)));
                 setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(dec.format(gapP1Y7)));
                 if (sObject.getHireLabor1().equals("Yes")) {
                     lablp1.setVisibility(View.VISIBLE);
                     int laborS1P1 = (int) (plot1Area * 12825000);
                     int laborS2P1 = (int) (plot1Area * 13425000);
                     int laborS3P1 = (int) (plot1Area * 12075000);

                     laborP1Y1 =laborS1P1;
                     laborP1Y2 =laborS1P1;
                     laborP1Y3 =laborS2P1;
                     laborP1Y4 =laborS3P1;
                     laborP1Y5 =laborS3P1;
                     laborP1Y6 =laborS3P1;
                     laborP1Y7 =laborS3P1;

                     setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(dec.format(laborP1Y1)));
                     setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(dec.format(laborP1Y2)));
                     setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(dec.format(laborP1Y3)));
                     setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(dec.format(laborP1Y4)));
                     setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(dec.format(laborP1Y5)));
                     setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(dec.format(laborP1Y6)));
                     setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(dec.format(laborP1Y7)));
                 }
                 if (sObject.getLimeNeed1().equals("Yes")) {
                     limlp1.setVisibility(View.VISIBLE);
                 }
                 if (sObject.getFillingOption1().equals("Yes")) {
                     fillp1.setVisibility(View.VISIBLE);
                 }
             } else {
                //GAPS
                gaplp1.setVisibility(View.VISIBLE);
                int gapresultP1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*gapsY1);
                est12 = (int)(plot1Area*gapsY2);
                est13 = (int)(plot1Area*gapsY3);
                est14 = (int)(plot1Area*gapsY4);
                est15 = (int)(plot1Area*gapsY5);
                est16 = (int)(plot1Area*gapsY6);
                est17 = (int)(plot1Area*gapsY7);
                gapP1Y1 = gapresultP1;
                gapP1Y2 = gapresultP1;
                gapP1Y3 = gapresultP1;
                gapP1Y4 = gapresultP1;
                gapP1Y5 = gapresultP1;
                gapP1Y6 = gapresultP1;
                gapP1Y7 = gapresultP1;
                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(dec.format(gapP1Y1)));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(dec.format(gapP1Y2)));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(dec.format(gapP1Y3)));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(dec.format(gapP1Y4)));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(dec.format(gapP1Y5)));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(dec.format(gapP1Y6)));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(dec.format(gapP1Y7)));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int labor1P1 = (int) (plot1Area * 12075000);
                    laborP1Y1 =labor1P1;
                    laborP1Y2 =labor1P1;
                    laborP1Y3 =labor1P1;
                    laborP1Y4 =labor1P1;
                    laborP1Y5 =labor1P1;
                    laborP1Y6 =labor1P1;
                    laborP1Y7 =labor1P1;
                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(dec.format(laborP1Y1)));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(dec.format(laborP1Y2)));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(dec.format(laborP1Y3)));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(dec.format(laborP1Y4)));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(dec.format(laborP1Y5)));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(dec.format(laborP1Y6)));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(dec.format(laborP1Y7)));
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
            }

            //end plot
            if (sObject.getFarmCondition2().equals("N/A") || sObject.getTreeDensity2().equals("N/A") || sObject.getDebilitatingDisease2().equals("N/A")|| sObject.getPlantingMaterial2().equals("N/A")){
                p2.setVisibility(View.GONE);
                st2.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                //Replanting
                replp2.setVisibility(View.VISIBLE);
                int rep1P2 = (int) (plot2Area * 28412500);
                int rep2P2 = (int) (plot2Area * 19753000);
                int rep3P2 = (int) (plot2Area * 20640500);
                int rep4P2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*replantingY1);
                est22 = (int)(plot2Area*replantingY2);
                est23 = (int)(plot2Area*replantingY3);
                est24 = (int)(plot2Area*replantingY4);
                est25 = (int)(plot2Area*replantingY5);
                est26 = (int)(plot2Area*replantingY6);
                est27 = (int)(plot2Area*replantingY7);

                gapP2Y1 = rep1P2;
                gapP2Y2 = rep2P2;
                gapP2Y3 = rep3P2;
                gapP2Y4 = rep4P2;
                gapP2Y5 = rep4P2;
                gapP2Y6 = rep4P2;
                gapP2Y7 = rep4P2;

                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(dec.format(gapP2Y1)));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(dec.format(gapP2Y2)));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(dec.format(gapP2Y3)));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(dec.format(gapP2Y4)));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(dec.format(gapP2Y5)));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(dec.format(gapP2Y6)));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(dec.format(gapP2Y7)));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int labRep1P2 = (int) (plot2Area * 12150000);
                    int labRep2P2 = (int) (plot2Area* 6375000);
                    int labRep3P2 = (int) (plot2Area * 6975000);
                    int labRep4P2 = (int) (plot2Area * 11250000);
                    int labRep5P2 = (int) (plot2Area * 12075000);
                    laborP2Y1 = labRep1P2;
                    laborP2Y2 = labRep2P2;
                    laborP2Y3 = labRep3P2;
                    laborP2Y4 = labRep4P2;
                    laborP2Y5 = labRep5P2;
                    laborP2Y6 = labRep5P2;
                    laborP2Y7 = labRep5P2;

                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(dec.format(laborP2Y1)));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(dec.format(laborP2Y2)));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(dec.format(laborP2Y3)));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(dec.format(laborP2Y4)));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(dec.format(laborP2Y5)));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(dec.format(laborP2Y6)));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(dec.format(laborP2Y7)));
                }
                if (sObject.getLimeNeed2().equals("Yes")||sObject.getDrainageNeed2().equals("Yes")) {
                    limlp2.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }

                if (sObject.getDrainageNeed2().equals("Yes")) {
                    dralp2.setVisibility(View.VISIBLE);
                }
            } else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                //Grafting
                grflp2.setVisibility(View.VISIBLE);
                int graf1P2 = (int) (plot2Area * 24392500);
                int graf2P2 = (int) (plot2Area * 22358500);
                int graf3P2 = (int) (plot2Area * 23722000);
                int graf4P2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*graftingY1);
                est22 = (int)(plot2Area*graftingY2);
                est23 = (int)(plot2Area*graftingY3);
                est24 = (int)(plot2Area*graftingY4);
                est25 = (int)(plot2Area*graftingY5);
                est26 = (int)(plot2Area*graftingY6);
                est27 = (int)(plot2Area*graftingY7);
                gapP2Y1 = graf1P2;
                gapP2Y2 = graf2P2;
                gapP2Y3 = graf3P2;
                gapP2Y4 = graf4P2;
                gapP2Y5 = graf4P2;
                gapP2Y6 = graf4P2;
                gapP2Y7 = graf4P2;

                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(dec.format(gapP2Y1)));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(dec.format(gapP2Y2)));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(dec.format(gapP2Y3)));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(dec.format(gapP2Y4)));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(dec.format(gapP2Y5)));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(dec.format(gapP2Y6)));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(dec.format(gapP2Y7)));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int laborGraf1P2 = (int) (plot2Area * 12000000);
                    int laborGraf2P2 = (int) (plot2Area * 7200000);
                    int laborGraf3P2 = (int) (plot2Area * 12075000);
                    laborP2Y1 = laborGraf1P2;
                    laborP2Y2 = laborGraf2P2;
                    laborP2Y3 = laborGraf3P2;
                    laborP2Y4 = laborGraf3P2;
                    laborP2Y5 = laborGraf3P2;
                    laborP2Y6 = laborGraf3P2;
                    laborP2Y7 = laborGraf3P2;
                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(dec.format(laborP2Y1)));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(dec.format(laborP2Y2)));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(dec.format(laborP2Y3)));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(dec.format(laborP2Y4)));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(dec.format(laborP2Y5)));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(dec.format(laborP2Y6)));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(dec.format(laborP2Y7)));
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }
            } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                 //Extra Soil Management
                 exslp2.setVisibility(View.VISIBLE);
                 int eSoil1P2 = (int) (plot2Area * 26472000);
                int eSoil1P3 = (int) (plot1Area * 23622000);
                est21 = (int)(plot2Area*extraSoilY1);
                est22 = (int)(plot2Area*extraSoilY2);
                est23 = (int)(plot2Area*extraSoilY3);
                est24 = (int)(plot2Area*extraSoilY4);
                est25 = (int)(plot2Area*extraSoilY5);
                est26 = (int)(plot2Area*extraSoilY6);
                est27 = (int)(plot2Area*extraSoilY7);
                gapP2Y1 = eSoil1P2;
                gapP2Y2 = eSoil1P2;
                gapP2Y3 = eSoil1P3;
                gapP2Y4 = eSoil1P3;
                gapP2Y5 = eSoil1P3;
                gapP2Y6 = eSoil1P3;
                gapP2Y7 = eSoil1P3;
                 setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(dec.format(gapP2Y1)));
                 setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(dec.format(gapP2Y2)));
                 setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(dec.format(gapP2Y3)));
                 setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(dec.format(gapP2Y4)));
                 setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(dec.format(gapP2Y5)));
                 setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(dec.format(gapP2Y6)));
                 setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(dec.format(gapP2Y7)));
                 if (sObject.getHireLabor2().equals("Yes")) {
                     lablp2.setVisibility(View.VISIBLE);
                     int laborS1P2 = (int) (plot2Area* 12825000);
                     int laborS2P2 = (int) (plot2Area * 13425000);
                     int laborS3P2 = (int) (plot2Area * 12075000);
                     laborP2Y1 = laborS1P2;
                     laborP2Y2 = laborS1P2;
                     laborP2Y3 = laborS2P2;
                     laborP2Y4 = laborS3P2;
                     laborP2Y5 = laborS3P2;
                     laborP2Y6 = laborS3P2;
                     laborP2Y7 = laborS3P2;
                     setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(dec.format(laborP2Y1)));
                     setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(dec.format(laborP2Y2)));
                     setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(dec.format(laborP2Y3)));
                     setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(dec.format(laborP2Y4)));
                     setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(dec.format(laborP2Y5)));
                     setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(dec.format(laborP2Y6)));
                     setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(dec.format(laborP2Y7)));
                 }
                 if (sObject.getLimeNeed2().equals("Yes")) {
                     limlp2.setVisibility(View.VISIBLE);
                 }
                 if (sObject.getFillingOption2().equals("Yes")) {
                     fillp2.setVisibility(View.VISIBLE);
                 }
             } else {
                //GAPS
                gaplp2.setVisibility(View.VISIBLE);
                int gapresultP2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*gapsY1);
                est22 = (int)(plot2Area*gapsY2);
                est23 = (int)(plot2Area*gapsY3);
                est24 = (int)(plot2Area*gapsY4);
                est25 = (int)(plot2Area*gapsY5);
                est26 = (int)(plot2Area*gapsY6);
                est27 = (int)(plot2Area*gapsY7);
                gapP2Y1 = gapresultP2;
                gapP2Y2 = gapresultP2;
                gapP2Y3 = gapresultP2;
                gapP2Y4 = gapresultP2;
                gapP2Y5 = gapresultP2;
                gapP2Y6 = gapresultP2;
                gapP2Y7 = gapresultP2;
                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(dec.format(gapP2Y1)));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(dec.format(gapP2Y2)));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(dec.format(gapP2Y3)));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(dec.format(gapP2Y4)));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(dec.format(gapP2Y5)));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(dec.format(gapP2Y6)));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(dec.format(gapP2Y7)));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int labor1P2 = (int) (plot2Area * 12075000);
                    laborP2Y1 = labor1P2;
                    laborP2Y2 = labor1P2;
                    laborP2Y3 = labor1P2;
                    laborP2Y4 = labor1P2;
                    laborP2Y5 = labor1P2;
                    laborP2Y6 = labor1P2;
                    laborP2Y7 = labor1P2;
                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(dec.format(laborP2Y1)));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(dec.format(laborP2Y2)));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(dec.format(laborP2Y3)));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(dec.format(laborP2Y4)));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(dec.format(laborP2Y5)));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(dec.format(laborP2Y6)));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(dec.format(laborP2Y7)));
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }
            }

            //end plot
            if (sObject.getFarmCondition3().equals("N/A") || sObject.getTreeDensity3().equals("N/A") || sObject.getDebilitatingDisease3().equals("N/A")|| sObject.getPlantingMaterial3().equals("N/A")){
                p3.setVisibility(View.GONE);
                st3.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                //Replanting
                replp3.setVisibility(View.VISIBLE);
                int rep1P3 = (int) (plot3Area * 28412500);
                int rep2P3 = (int) (plot3Area * 19753000);
                int rep3P3 = (int) (plot3Area * 20640500);
                int rep4P3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*replantingY1);
                est32 = (int)(plot3Area*replantingY2);
                est33 = (int)(plot3Area*replantingY3);
                est34 = (int)(plot3Area*replantingY4);
                est35 = (int)(plot3Area*replantingY5);
                est36 = (int)(plot3Area*replantingY6);
                est37 = (int)(plot3Area*replantingY7);
                gapP3Y1 = rep1P3;
                gapP3Y2 = rep2P3;
                gapP3Y3 = rep3P3;
                gapP3Y4 = rep4P3;
                gapP3Y5 = rep4P3;
                gapP3Y6 = rep4P3;
                gapP3Y7 = rep4P3;
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(dec.format(gapP3Y1)));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(dec.format(gapP3Y2)));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(dec.format(gapP3Y3)));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(dec.format(gapP3Y4)));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(dec.format(gapP3Y5)));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(dec.format(gapP3Y6)));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(dec.format(gapP3Y7)));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int labRep1P3 = (int) (plot3Area * 12150000);
                    int labRep2P3 = (int) (plot3Area * 6375000);
                    int labRep3P3 = (int) (plot3Area * 6975000);
                    int labRep4P3 = (int) (plot3Area * 11250000);
                    int labRep5P3 = (int) (plot3Area * 12075000);
                    laborP3Y1 = labRep1P3;
                    laborP3Y2 = labRep2P3;
                    laborP3Y3 = labRep3P3;
                    laborP3Y4 = labRep4P3;
                    laborP3Y5 = labRep5P3;
                    laborP3Y6 = labRep5P3;
                    laborP3Y7 = labRep5P3;
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(dec.format(laborP3Y1)));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(dec.format(laborP3Y2)));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(dec.format(laborP3Y3)));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(dec.format(laborP3Y4)));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(dec.format(laborP3Y5)));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(dec.format(laborP3Y6)));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(dec.format(laborP3Y7)));
                }
                if (sObject.getDrainageNeed3().equals("Yes")) {
                    dralp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getLimeNeed3().equals("Yes")||sObject.getDrainageNeed3().equals("Yes")) {
                    limlp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
            } else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                //Grafting
                grflp3.setVisibility(View.VISIBLE);
                int graf1P3 = (int) (plot3Area* 24392500);
                int graf2P3 = (int) (plot3Area * 22358500);
                int graf3P3 = (int) (plot3Area * 23722000);
                int graf4P3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*graftingY1);
                est32 = (int)(plot3Area*graftingY2);
                est33 = (int)(plot3Area*graftingY3);
                est34 = (int)(plot3Area*graftingY4);
                est35 = (int)(plot3Area*graftingY5);
                est36 = (int)(plot3Area*graftingY6);
                est37 = (int)(plot3Area*graftingY7);
                gapP3Y1 = graf1P3;
                gapP3Y2 = graf2P3;
                gapP3Y3 = graf3P3;
                gapP3Y4 = graf4P3;
                gapP3Y5 = graf4P3;
                gapP3Y6 = graf4P3;
                gapP3Y7 = graf4P3;
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(dec.format(gapP3Y1)));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(dec.format(gapP3Y2)));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(dec.format(gapP3Y3)));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(dec.format(gapP3Y4)));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(dec.format(gapP3Y5)));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(dec.format(gapP3Y6)));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(dec.format(gapP3Y7)));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int laborGraf1P3 = (int) (plot3Area * 12000000);
                    int laborGraf2P3 = (int) (plot3Area * 7200000);
                    int laborGraf3P3 = (int) (plot3Area * 12075000);
                    laborP3Y1 = laborGraf1P3;
                    laborP3Y2 = laborGraf2P3;
                    laborP3Y3 = laborGraf3P3;
                    laborP3Y4 = laborGraf3P3;
                    laborP3Y5 = laborGraf3P3;
                    laborP3Y6 = laborGraf3P3;
                    laborP3Y7 = laborGraf3P3;
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(dec.format(laborP3Y1)));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(dec.format(laborP3Y2)));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(dec.format(laborP3Y3)));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(dec.format(laborP3Y4)));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(dec.format(laborP3Y5)));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(dec.format(laborP3Y6)));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(dec.format(laborP3Y7)));
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
            } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                //Extra Soil Management
                exslp3.setVisibility(View.VISIBLE);
                int eSoil1P3 = (int) (plot3Area * 26472000);
                int eSoil1P4 = (int) (plot1Area * 23622000);
                est31 = (int)(plot3Area*extraSoilY1);
                est32 = (int)(plot3Area*extraSoilY2);
                est33 = (int)(plot3Area*extraSoilY3);
                est34 = (int)(plot3Area*extraSoilY4);
                est35 = (int)(plot3Area*extraSoilY5);
                est36 = (int)(plot3Area*extraSoilY6);
                est37 = (int)(plot3Area*extraSoilY7);
                gapP3Y1 = eSoil1P3;
                gapP3Y2 = eSoil1P3;
                gapP3Y3 = eSoil1P4;
                gapP3Y4 = eSoil1P4;
                gapP3Y5 = eSoil1P4;
                gapP3Y6 = eSoil1P4;
                gapP3Y7 = eSoil1P4;
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(dec.format(gapP3Y1)));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(dec.format(gapP3Y2)));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(dec.format(gapP3Y3)));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(dec.format(gapP3Y4)));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(dec.format(gapP3Y5)));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(dec.format(gapP3Y6)));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(dec.format(gapP3Y7)));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int laborS1P3 = (int) (plot3Area * 12825000);
                    int laborS2P3 = (int) (plot3Area * 13425000);
                    int laborS3P3 = (int) (plot3Area * 12075000);
                    laborP3Y1 = laborS1P3;
                    laborP3Y2 = laborS1P3;
                    laborP3Y3 = laborS2P3;
                    laborP3Y4 = laborS3P3;
                    laborP3Y5 = laborS3P3;
                    laborP3Y6 = laborS3P3;
                    laborP3Y7 = laborS3P3;
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(dec.format(laborP3Y1)));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(dec.format(laborP3Y2)));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(dec.format(laborP3Y3)));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(dec.format(laborP3Y4)));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(dec.format(laborP3Y5)));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(dec.format(laborP3Y6)));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(dec.format(laborP3Y7)));
                }
                if (sObject.getLimeNeed3().equals("Yes")) {
                    limlp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
            } else  {
                //GAPS
                gaplp3.setVisibility(View.VISIBLE);
                int gapresultP3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*gapsY1);
                est32 = (int)(plot3Area*gapsY2);
                est33 = (int)(plot3Area*gapsY3);
                est34 = (int)(plot3Area*gapsY4);
                est35 = (int)(plot3Area*gapsY5);
                est36 = (int)(plot3Area*gapsY6);
                est37 = (int)(plot3Area*gapsY7);
                gapP3Y1 = gapresultP3;
                gapP3Y2 = gapresultP3;
                gapP3Y3 = gapresultP3;
                gapP3Y4 = gapresultP3;
                gapP3Y5 = gapresultP3;
                gapP3Y6 = gapresultP3;
                gapP3Y7 = gapresultP3;
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(dec.format(gapP3Y1)));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(dec.format(gapP3Y2)));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(dec.format(gapP3Y3)));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(dec.format(gapP3Y4)));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(dec.format(gapP3Y5)));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(dec.format(gapP3Y6)));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(dec.format(gapP3Y7)));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int labor1P3 = (int) (plot3Area * 12075000);
                    laborP3Y1 = labor1P3;
                    laborP3Y2 = labor1P3;
                    laborP3Y3 = labor1P3;
                    laborP3Y4 = labor1P3;
                    laborP3Y5 = labor1P3;
                    laborP3Y6 = labor1P3;
                    laborP3Y7 = labor1P3;

                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(dec.format(laborP3Y1)));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(dec.format(laborP3Y2)));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(dec.format(laborP3Y3)));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(dec.format(laborP3Y4)));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(dec.format(laborP3Y5)));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(dec.format(laborP3Y6)));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(dec.format(laborP3Y7)));
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
            }

            //end plot
            if (sObject.getFarmCondition4().equals("N/A") || sObject.getTreeDensity4().equals("N/A") || sObject.getDebilitatingDisease4().equals("N/A")|| sObject.getPlantingMaterial4().equals("N/A")){
                p4.setVisibility(View.GONE);
                st4.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                //Replanting
                replp4.setVisibility(View.VISIBLE);
                int rep1P4 = (int) (plot4Area* 28412500);
                int rep2P4 = (int) (plot4Area* 19753000);
                int rep3P4 = (int) (plot4Area * 20640500);
                int rep4P4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*replantingY1);
                est42 = (int)(plot4Area*replantingY2);
                est43 = (int)(plot4Area*replantingY3);
                est44 = (int)(plot4Area*replantingY4);
                est45 = (int)(plot4Area*replantingY5);
                est46 = (int)(plot4Area*replantingY6);
                est47 = (int)(plot4Area*replantingY7);
                gapP4Y1 = rep1P4;
                gapP4Y2 = rep2P4;
                gapP4Y3 = rep3P4;
                gapP4Y4 = rep4P4;
                gapP4Y5 = rep4P4;
                gapP4Y6 = rep4P4;
                gapP4Y7 = rep4P4;
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(dec.format(gapP4Y1)));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(dec.format(gapP4Y2)));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(dec.format(gapP4Y3)));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(dec.format(gapP4Y4)));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(dec.format(gapP4Y5)));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(dec.format(gapP4Y6)));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(dec.format(gapP4Y7)));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int labRep1P4 = (int) (plot4Area * 12150000);
                    int labRep2P4 = (int) (plot4Area * 6375000);
                    int labRep3P4 = (int) (plot4Area * 6975000);
                    int labRep4P4 = (int) (plot4Area* 11250000);
                    int labRep5P4 = (int) (plot4Area * 12075000);
                    laborP4Y1 = labRep1P4;
                    laborP4Y2 = labRep2P4;
                    laborP4Y3 = labRep3P4;
                    laborP4Y4 = labRep4P4;
                    laborP4Y5 = labRep5P4;
                    laborP4Y6 = labRep5P4;
                    laborP4Y7 = labRep5P4;
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(dec.format(laborP4Y1)));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(dec.format(laborP4Y2)));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(dec.format(laborP4Y3)));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(dec.format(laborP4Y4)));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(dec.format(laborP4Y5)));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(dec.format(laborP4Y6)));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(dec.format(laborP4Y7)));
                }
                if (sObject.getDrainageNeed4().equals("Yes")) {
                    dralp4.setVisibility(View.VISIBLE);
                }
                if (sObject.geLimeNeed4().equals("Yes")||sObject.getDrainageNeed4().equals("Yes")) {
                    limlp4.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
            } else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                //Grafting
                grflp4.setVisibility(View.VISIBLE);
                int graf1P4 = (int) (plot4Area * 24392500);
                int graf2P4 = (int) (plot4Area * 22358500);
                int graf3P4 = (int) (plot4Area * 23722000);
                int graf4P4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*graftingY1);
                est42 = (int)(plot4Area*graftingY2);
                est43 = (int)(plot4Area*graftingY3);
                est44 = (int)(plot4Area*graftingY4);
                est45 = (int)(plot4Area*graftingY5);
                est46 = (int)(plot4Area*graftingY6);
                est47 = (int)(plot4Area*graftingY7);
                gapP4Y1 = graf1P4;
                gapP4Y2 = graf2P4;
                gapP4Y3 = graf3P4;
                gapP4Y4 = graf4P4;
                gapP4Y5 = graf4P4;
                gapP4Y6 = graf4P4;
                gapP4Y7 = graf4P4;

                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(dec.format(gapP4Y1)));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(dec.format(gapP4Y2)));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(dec.format(gapP4Y3)));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(dec.format(gapP4Y4)));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(dec.format(gapP4Y5)));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(dec.format(gapP4Y6)));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(dec.format(gapP4Y7)));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int laborGraf1P4 = (int) (plot4Area * 12000000);
                    int laborGraf2P4 = (int) (plot4Area * 7200000);
                    int laborGraf3P4 = (int) (plot4Area * 12075000);

                    laborP4Y1 = laborGraf1P4;
                    laborP4Y2 = laborGraf2P4;
                    laborP4Y3 = laborGraf3P4;
                    laborP4Y4 = laborGraf3P4;
                    laborP4Y5 = laborGraf3P4;
                    laborP4Y6 = laborGraf3P4;
                    laborP4Y7 = laborGraf3P4;

                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(dec.format(laborP4Y1)));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(dec.format(laborP4Y2)));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(dec.format(laborP4Y3)));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(dec.format(laborP4Y4)));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(dec.format(laborP4Y5)));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(dec.format(laborP4Y6)));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(dec.format(laborP4Y7)));
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
            } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                //Extra Soil Management
                exslp4.setVisibility(View.VISIBLE);
                int eSoil1P4 = (int) (plot4Area * 26472000);
                int eSoil1P5 = (int) (plot1Area * 23622000);
                est41 = (int)(plot4Area*extraSoilY1);
                est42 = (int)(plot4Area*extraSoilY2);
                est43 = (int)(plot4Area*extraSoilY3);
                est44 = (int)(plot4Area*extraSoilY4);
                est45 = (int)(plot4Area*extraSoilY5);
                est46 = (int)(plot4Area*extraSoilY6);
                est47 = (int)(plot4Area*extraSoilY7);
                gapP4Y1 = eSoil1P4;
                gapP4Y2 = eSoil1P4;
                gapP4Y3 = eSoil1P5;
                gapP4Y4 = eSoil1P5;
                gapP4Y5 = eSoil1P5;
                gapP4Y6 = eSoil1P5;
                gapP4Y7 = eSoil1P5;
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(dec.format(gapP4Y1)));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(dec.format(gapP4Y2)));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(dec.format(gapP4Y3)));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(dec.format(gapP4Y4)));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(dec.format(gapP4Y5)));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(dec.format(gapP4Y6)));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(dec.format(gapP4Y7)));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int laborS1P4 = (int) (plot4Area * 12825000);
                    int laborS2P4 = (int) (plot4Area * 13425000);
                    int laborS3P4 = (int) (plot4Area * 12075000);
                    laborP4Y1 = laborS1P4;
                    laborP4Y2 = laborS1P4;
                    laborP4Y3 = laborS2P4;
                    laborP4Y4 = laborS3P4;
                    laborP4Y5 = laborS3P4;
                    laborP4Y6 = laborS3P4;
                    laborP4Y7 = laborS3P4;
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(dec.format(laborP4Y1)));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(dec.format(laborP4Y2)));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(dec.format(laborP4Y3)));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(dec.format(laborP4Y4)));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(dec.format(laborP4Y5)));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(dec.format(laborP4Y6)));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(dec.format(laborP4Y7)));
                }
                if (sObject.geLimeNeed4().equals("Yes")) {
                    limlp4.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
            } else {
                //GAPS
                gaplp4.setVisibility(View.VISIBLE);
                int gapresultP4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*gapsY1);
                est42 = (int)(plot4Area*gapsY2);
                est43 = (int)(plot4Area*gapsY3);
                est44 = (int)(plot4Area*gapsY4);
                est45 = (int)(plot4Area*gapsY5);
                est46 = (int)(plot4Area*gapsY6);
                est47 = (int)(plot4Area*gapsY7);
                gapP4Y1 = gapresultP4;
                gapP4Y2 = gapresultP4;
                gapP4Y3 = gapresultP4;
                gapP4Y4 = gapresultP4;
                gapP4Y5 = gapresultP4;
                gapP4Y6 = gapresultP4;
                gapP4Y7 = gapresultP4;
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(dec.format(gapP4Y1)));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(dec.format(gapP4Y2)));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(dec.format(gapP4Y3)));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(dec.format(gapP4Y4)));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(dec.format(gapP4Y5)));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(dec.format(gapP4Y6)));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(dec.format(gapP4Y7)));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int labor1P4 = (int) (plot4Area * 12075000);
                    laborP4Y1 = labor1P4;
                    laborP4Y2 = labor1P4;
                    laborP4Y3 = labor1P4;
                    laborP4Y4 = labor1P4;
                    laborP4Y5 = labor1P4;
                    laborP4Y6 = labor1P4;
                    laborP4Y7 = labor1P4;
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(dec.format(laborP4Y1)));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(dec.format(laborP4Y2)));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(dec.format(laborP4Y3)));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(dec.format(laborP4Y4)));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(dec.format(laborP4Y5)));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(dec.format(laborP4Y6)));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(dec.format(laborP4Y7)));
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
            }
            //end of plot

            if (sObject.getFarmCondition5().equals("N/A") || sObject.getTreeDensity5().equals("N/A") || sObject.getDebilitatingDisease5().equals("N/A")|| sObject.getPlantingMaterial5().equals("N/A")){
                p5.setVisibility(View.GONE);
                st5.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                //Replanting
                replp5.setVisibility(View.VISIBLE);
                int rep1P5 = (int) (plot5Area * 28412500);
                int rep2P5 = (int) (plot5Area * 19753000);
                int rep3P5 = (int) (plot5Area * 20640500);
                int rep4P5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*replantingY1);
                est52 = (int)(plot5Area*replantingY2);
                est53 = (int)(plot5Area*replantingY3);
                est54 = (int)(plot5Area*replantingY4);
                est55 = (int)(plot5Area*replantingY5);
                est56 = (int)(plot5Area*replantingY6);
                est57 = (int)(plot5Area*replantingY7);
                gapP5Y1 = rep1P5;
                gapP5Y2 = rep2P5;
                gapP5Y3 = rep3P5;
                gapP5Y4 = rep4P5;
                gapP5Y5 = rep4P5;
                gapP5Y6 = rep4P5;
                gapP5Y7 = rep4P5;
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(dec.format(gapP5Y1)));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(dec.format(gapP5Y2)));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(dec.format(gapP5Y3)));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(dec.format(gapP5Y4)));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(dec.format(gapP5Y5)));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(dec.format(gapP5Y6)));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(dec.format(gapP5Y7)));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int labRep1P5 = (int) (plot5Area * 12150000);
                    int labRep2P5 = (int) (plot5Area * 6375000);
                    int labRep3P5 = (int) (plot5Area * 6975000);
                    int labRep4P5 = (int) (plot5Area * 11250000);
                    int labRep5P5 = (int) (plot5Area * 12075000);
                    laborP5Y1 =labRep1P5 ;
                    laborP5Y2 = labRep2P5;
                    laborP5Y3 = labRep3P5;
                    laborP5Y4 = labRep4P5;
                    laborP5Y5 = labRep5P5;
                    laborP5Y6 = labRep5P5;
                    laborP5Y7 = labRep5P5;
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(dec.format(labRep1P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(dec.format(labRep2P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(dec.format(labRep3P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(dec.format(labRep4P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(dec.format(labRep5P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(dec.format(labRep5P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(dec.format(labRep5P5)));
                }
                if (sObject.getDrainageNeed5().equals("Yes")) {
                    dralp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getLimeNeed5().equals("Yes")||sObject.getDrainageNeed5().equals("Yes")) {
                    limlp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
            } else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                //Grafting
                grflp5.setVisibility(View.VISIBLE);
                int graf1P5 = (int) (plot5Area * 24392500);
                int graf2P5 = (int) (plot5Area * 22358500);
                int graf3P5 = (int) (plot5Area * 23722000);
                int graf4P5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*graftingY1);
                est52 = (int)(plot5Area*graftingY2);
                est53 = (int)(plot5Area*graftingY3);
                est54 = (int)(plot5Area*graftingY4);
                est55 = (int)(plot5Area*graftingY5);
                est56 = (int)(plot5Area*graftingY6);
                est57 = (int)(plot5Area*graftingY7);
                gapP5Y1 = graf1P5;
                gapP5Y2 = graf2P5;
                gapP5Y3 = graf3P5;
                gapP5Y4 = graf4P5;
                gapP5Y5 = graf4P5;
                gapP5Y6 = graf4P5;
                gapP5Y7 = graf4P5;
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(dec.format(gapP5Y1)));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(dec.format(gapP5Y2)));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(dec.format(gapP5Y3)));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(dec.format(gapP5Y4)));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(dec.format(gapP5Y5)));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(dec.format(gapP5Y6)));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(dec.format(gapP5Y7)));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int laborGraf1P5 = (int) (plot5Area * 12000000);
                    int laborGraf2P5 = (int) (plot5Area * 7200000);
                    int laborGraf3P5 = (int) (plot5Area * 12075000);
                    laborP5Y1 = laborGraf1P5;
                    laborP5Y2 = laborGraf2P5;
                    laborP5Y3 = laborGraf3P5;
                    laborP5Y4 = laborGraf3P5;
                    laborP5Y5 = laborGraf3P5;
                    laborP5Y6 = laborGraf3P5;
                    laborP5Y7 = laborGraf3P5;
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(dec.format(laborP5Y1)));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(dec.format(laborP5Y2)));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(dec.format(laborP5Y3)));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(dec.format(laborP5Y4)));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(dec.format(laborP5Y5)));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(dec.format(laborP5Y6)));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(dec.format(laborP5Y7)));
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
            } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                //Extra Soil Management
                exslp5.setVisibility(View.VISIBLE);
                int eSoil1P5 = (int) (plot5Area * 26472000);
                int eSoil1P6 = (int) (plot1Area * 23622000);
                est51 = (int)(plot5Area*extraSoilY1);
                est52 = (int)(plot5Area*extraSoilY2);
                est53 = (int)(plot5Area*extraSoilY3);
                est54 = (int)(plot5Area*extraSoilY4);
                est55 = (int)(plot5Area*extraSoilY5);
                est56 = (int)(plot5Area*extraSoilY6);
                est57 = (int)(plot5Area*extraSoilY7);
                gapP5Y1 = eSoil1P5;
                gapP5Y2 = eSoil1P5;
                gapP5Y3 = eSoil1P6;
                gapP5Y4 = eSoil1P6;
                gapP5Y5 = eSoil1P6;
                gapP5Y6 = eSoil1P6;
                gapP5Y7 = eSoil1P6;
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(dec.format(gapP5Y1)));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(dec.format(gapP5Y2)));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(dec.format(gapP5Y3)));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(dec.format(gapP5Y4)));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(dec.format(gapP5Y5)));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(dec.format(gapP5Y6)));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(dec.format(gapP5Y7)));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int laborS1P5 = (int) (plot5Area * 12825000);
                    int laborS2P5 = (int) (plot5Area * 13425000);
                    int laborS3P5 = (int) (plot5Area * 12075000);
                    laborP5Y1 = laborS1P5;
                    laborP5Y2 = laborS1P5;
                    laborP5Y3 = laborS2P5;
                    laborP5Y4 = laborS3P5;
                    laborP5Y5 = laborS3P5;
                    laborP5Y6 = laborS3P5;
                    laborP5Y7 = laborS3P5;
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(dec.format(laborS1P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(dec.format(laborS1P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(dec.format(laborS2P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(dec.format(laborS3P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(dec.format(laborS3P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(dec.format(laborS3P5)));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(dec.format(laborS3P5)));
                }
                if (sObject.getLimeNeed5().equals("Yes")) {
                    limlp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
            } else {
                //GAPS
                gaplp5.setVisibility(View.VISIBLE);
                int gapresultP5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*gapsY1);
                est52 = (int)(plot5Area*gapsY2);
                est53 = (int)(plot5Area*gapsY3);
                est54 = (int)(plot5Area*gapsY4);
                est55 = (int)(plot5Area*gapsY5);
                est56 = (int)(plot5Area*gapsY6);
                est57 = (int)(plot5Area*gapsY7);
                gapP5Y1 = gapresultP5;
                gapP5Y2 = gapresultP5;
                gapP5Y3 = gapresultP5;
                gapP5Y4 = gapresultP5;
                gapP5Y5 = gapresultP5;
                gapP5Y6 = gapresultP5;
                gapP5Y7 = gapresultP5;
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(dec.format(gapP5Y1)));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(dec.format(gapP5Y2)));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(dec.format(gapP5Y3)));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(dec.format(gapP5Y4)));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(dec.format(gapP5Y5)));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(dec.format(gapP5Y6)));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(dec.format(gapP5Y7)));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int labor1P5 = (int) (plot5Area * 12075000);
                    laborP5Y1 = labor1P5;
                    laborP5Y2 = labor1P5;
                    laborP5Y3 = labor1P5;
                    laborP5Y4 = labor1P5;
                    laborP5Y5 = labor1P5;
                    laborP5Y6 = labor1P5;
                    laborP5Y7 = labor1P5;
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(dec.format(laborP5Y1)));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(dec.format(laborP5Y2)));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(dec.format(laborP5Y3)));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(dec.format(laborP5Y4)));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(dec.format(laborP5Y5)));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(dec.format(laborP5Y6)));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(dec.format(laborP5Y7)));
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
            }

            //net income cocoa
            int avgCost = Integer.parseInt(sObject.getAveragecocoaprice().toString());
            int est1 = est11+est21+est31+est41+est51;
            int est2 = est12+est22+est32+est42+est52;
            int est3 = est13+est23+est33+est43+est53;
            int est4 = est14+est24+est34+est44+est54;
            int est5 = est15+est25+est35+est45+est55;
            int est6 = est16+est26+est36+est46+est56;
            int est7 = est17+est27+est37+est47+est57;
            int totalIncomeY1 = avgCost * est1;
            int totalIncomeY2 = avgCost * est2;
            int totalIncomeY3 = avgCost * est3;
            int totalIncomeY4 = avgCost * est4;
            int totalIncomeY5 = avgCost * est5;
            int totalIncomeY6 = avgCost * est6;
            int totalIncomeY7 = avgCost * est7;
            int totalIncome = totalIncomeY1+totalIncomeY2+totalIncomeY3+totalIncomeY4+totalIncomeY5+totalIncomeY6+totalIncomeY7;
            setText2((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(dec.format(totalIncomeY1)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(dec.format(totalIncomeY2)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(dec.format(totalIncomeY3)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(dec.format(totalIncomeY4)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(dec.format(totalIncomeY5)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(dec.format(totalIncomeY6)));
            setText2((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(dec.format(totalIncomeY7)));
            //net income farming
            int farmWork = Integer.parseInt(sObject.getIncomefarmlabor().toString());
            setText2((TextView) findViewById(R.id.netFarmingY1_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY2_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY3_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY4_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY5_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY6_field), String.valueOf(dec.format(farmWork)));
            setText2((TextView) findViewById(R.id.netFarmingY7_field), String.valueOf(dec.format(farmWork)));

            // net family income
            int spouseWork = Integer.parseInt(sObject.getSpouseincome().toString());
            int familyWork = Integer.parseInt(sObject.getFamilymembersincome().toString());
            int totalFincome;
            totalFincome = spouseWork + familyWork;
            setText2((TextView) findViewById(R.id.netFamilyY1_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY2_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY3_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY4_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY5_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY6_field), String.valueOf(dec.format(totalFincome)));
            setText2((TextView) findViewById(R.id.netFamilyY7_field), String.valueOf(dec.format(totalFincome)));

            //net other income
            int otherCrops = Integer.parseInt(sObject.getIncomeothercrops().toString());
            int moneyBack = Integer.parseInt(sObject.getLoanmoneygetback().toString());
            int hhSavings = Integer.parseInt(sObject.getHouseholdsavings().toString());
            int totalOtherIncome = otherCrops + moneyBack + hhSavings;
            setText2((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(dec.format(totalOtherIncome)));
            setText2((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(dec.format(totalOtherIncome)));

            //total income

            int totalIncomeAllY1 = totalIncomeY1 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY2 = totalIncomeY2 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY3 = totalIncomeY3 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY4 = totalIncomeY4 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY5 = totalIncomeY5 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY6 = totalIncomeY6 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY7 = totalIncomeY7 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAll = totalIncomeAllY1+totalIncomeAllY2+totalIncomeAllY3+totalIncomeAllY4+totalIncomeAllY5+totalIncomeAllY6+totalIncomeAllY7;
            setText2((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(dec.format(totalIncomeAllY1)));
            setText2((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(dec.format(totalIncomeAllY2)));
            setText2((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(dec.format(totalIncomeAllY3)));
            setText2((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(dec.format(totalIncomeAllY4)));
            setText2((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(dec.format(totalIncomeAllY5)));
            setText2((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(dec.format(totalIncomeAllY6)));
            setText2((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(dec.format(totalIncomeAllY7)));

            //total famili costs
            int expLY = Integer.parseInt(sObject.getExpensescocoaly().toString());
            int anLivExpen = Integer.parseInt(sObject.getAnnuallivingexpenses().toString());
            int anOtherExp = Integer.parseInt(sObject.getAnnualotherexpenses().toString());
            int expEducExp = Integer.parseInt(sObject.getExpectededucationexpenses().toString());
            int credPay = Integer.parseInt(sObject.getHowmuchpayforcredit().toString());
            int totalExpenses = expLY+anLivExpen+anOtherExp+expEducExp+credPay;
            setText2((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(dec.format(totalExpenses)));
            setText2((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(dec.format(totalExpenses)));
            //found available
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
            setText2((TextView) findViewById(R.id.foundsAvailableY1_field), String.valueOf(dec.format(availableY1)));
            if(availableY1 > 0){
                found1.setTextColor(Color.parseColor("#29a329"));
            }else{
                found1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY2_field), String.valueOf(dec.format(availableY2)));
            if(availableY2 > 0){
                found2.setTextColor(Color.parseColor("#29a329"));
            }else{
                found2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY3_field), String.valueOf(dec.format(availableY3)));
            if(availableY3 > 0){
                found3.setTextColor(Color.parseColor("#29a329"));
            }else{
                found3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY4_field), String.valueOf(dec.format(availableY4)));
            if(availableY4 > 0){
                found4.setTextColor(Color.parseColor("#29a329"));
            }else{
                found4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY5_field), String.valueOf(dec.format(availableY5)));
            if(availableY5 > 0){
                found5.setTextColor(Color.parseColor("#29a329"));
            }else{
                found5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY6_field), String.valueOf(dec.format(availableY6)));
            if(availableY6 > 0){
                found6.setTextColor(Color.parseColor("#29a329"));
            }else{
                found6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText2((TextView) findViewById(R.id.foundsAvailableY7_field), String.valueOf(dec.format(availableY7)));
            if(availableY7 > 0){
                found7.setTextColor(Color.parseColor("#29a329"));
            }else{
                found7.setTextColor(Color.parseColor("#cc0000"));
            }
            //found needed

            int totalY1 = gapP1Y1+gapP2Y1+gapP3Y1+gapP4Y1+gapP5Y1+laborP1Y1+laborP2Y1+laborP3Y1+laborP4Y1+laborP5Y1+limeP1Y1+limeP2Y1+limeP3Y1+limeP4Y1+limeP5Y1;
            setText2((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(dec.format(totalY1)));

            int totalY2 = gapP1Y2+gapP2Y2+gapP3Y2+gapP4Y2+gapP5Y2+laborP1Y2+laborP2Y2+laborP3Y2+laborP4Y2+laborP5Y2+limeP1Y2+limeP2Y2+limeP3Y2+limeP4Y2+limeP5Y2;

            setText2((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(dec.format(totalY2)));

            int totalY3 = gapP1Y3+gapP2Y3+gapP3Y3+gapP4Y3+gapP5Y3+laborP1Y3+laborP2Y3+laborP3Y3+laborP4Y3+laborP5Y3+limeP1Y3+limeP2Y3+limeP3Y3+limeP4Y3+limeP5Y3;

            setText2((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(dec.format(totalY3)));

            int totalY4 = gapP1Y4+gapP2Y4+gapP3Y4+gapP4Y4+gapP5Y4+laborP1Y4+laborP2Y4+laborP3Y4+laborP4Y4+laborP5Y4+limeP1Y4+limeP2Y4+limeP3Y4+limeP4Y4+limeP5Y4;

            setText2((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(dec.format(totalY4)));

            int totalY5 = gapP1Y5+gapP2Y5+gapP3Y5+gapP4Y5+gapP5Y5+laborP1Y5+laborP2Y5+laborP3Y5+laborP4Y5+laborP5Y5+limeP1Y5+limeP2Y5+limeP3Y5+limeP4Y5+limeP5Y5;
            setText2((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(dec.format(totalY5)));

            int totalY6 = gapP1Y6+gapP2Y6+gapP3Y6+gapP4Y6+gapP5Y6+laborP1Y6+laborP2Y6+laborP3Y6+laborP4Y6+laborP5Y6+limeP1Y6+limeP2Y6+limeP3Y6+limeP4Y6+limeP5Y6;
            setText2((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(dec.format(totalY6)));

            int totalY7 = gapP1Y7+gapP2Y7+gapP3Y7+gapP4Y7+gapP5Y7+laborP1Y7+laborP2Y7+laborP3Y7+laborP4Y7+laborP5Y7+limeP1Y7+limeP2Y7+limeP3Y7+limeP4Y7+limeP5Y7;
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

    private void setText(EditText textField, String text) {   if (textField != null) {
            textField.setText(text);
        }
    }

    private void setText2(TextView textField, String text) {
        if (textField != null) {
            textField.setVisibility(View.VISIBLE);
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
