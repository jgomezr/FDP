package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
import org.w3c.dom.Text;

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
    private Spinner st1,st2,st3,st4,st5,st6,st7,st8,st9,st10;
    private TextView gaplp1,grflp1,replp1,exslp1,limlp1,dralp1,fillp1,lablp1,gaplp2,grflp2,replp2,exslp2,limlp2,dralp2,fillp2,lablp2,gaplp3,grflp3,replp3,exslp3,limlp3,dralp3,fillp3,lablp3,gaplp4,grflp4,replp4,exslp4,limlp4,dralp4,fillp4,lablp4,gaplp5,grflp5,replp5,exslp5,limlp5,dralp5,fillp5,lablp5,gaplp6,grflp6,replp6,exslp6,limlp6,dralp6,fillp6,lablp6,gaplp7,grflp7,replp7,exslp7,limlp7,dralp7,fillp7,lablp7,gaplp8,grflp8,replp8,exslp8,limlp8,dralp8,fillp8,lablp8,gaplp9,grflp9,replp9,exslp9,limlp9,dralp9,fillp9,lablp9,gaplp10,grflp10,replp10,exslp10,limlp10,dralp10,fillp10,lablp10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fdp);
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
        st6 = (Spinner)findViewById(R.id.startP6_field);
        st7 = (Spinner)findViewById(R.id.startP7_field);
        st8 = (Spinner)findViewById(R.id.startP8_field);
        st9 = (Spinner)findViewById(R.id.startP9_field);
        st10 = (Spinner)findViewById(R.id.startP10_field);
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
        gaplp6 = (TextView)findViewById(R.id.gapLabelP6_field);
        grflp6 = (TextView)findViewById(R.id.graftLabelP6_field);
        replp6 = (TextView)findViewById(R.id.replantLabelP6_field);
        exslp6 = (TextView)findViewById(R.id.extraSoilLabelP6_field);
        limlp6 = (TextView)findViewById(R.id.limeLabelP6_field);
        dralp6 = (TextView)findViewById(R.id.drainageLabelP6_field);
        fillp6 = (TextView)findViewById(R.id.fillingLabelP6_field);
        lablp6 = (TextView)findViewById(R.id.laborLabelP6_field);
        gaplp7 = (TextView)findViewById(R.id.gapLabelP7_field);
        grflp7 = (TextView)findViewById(R.id.graftLabelP7_field);
        replp7 = (TextView)findViewById(R.id.replantLabelP7_field);
        exslp7 = (TextView)findViewById(R.id.extraSoilLabelP7_field);
        limlp7 = (TextView)findViewById(R.id.limeLabelP7_field);
        dralp7 = (TextView)findViewById(R.id.drainageLabelP7_field);
        fillp7 = (TextView)findViewById(R.id.fillingLabelP7_field);
        lablp7 = (TextView)findViewById(R.id.laborLabelP7_field);
        gaplp8 = (TextView)findViewById(R.id.gapLabelP8_field);
        grflp8 = (TextView)findViewById(R.id.graftLabelP8_field);
        replp8 = (TextView)findViewById(R.id.replantLabelP8_field);
        exslp8 = (TextView)findViewById(R.id.extraSoilLabelP8_field);
        limlp8 = (TextView)findViewById(R.id.limeLabelP8_field);
        dralp8 = (TextView)findViewById(R.id.drainageLabelP8_field);
        fillp8 = (TextView)findViewById(R.id.fillingLabelP8_field);
        lablp8 = (TextView)findViewById(R.id.laborLabelP8_field);
        gaplp9 = (TextView)findViewById(R.id.gapLabelP9_field);
        grflp9 = (TextView)findViewById(R.id.graftLabelP9_field);
        replp9 = (TextView)findViewById(R.id.replantLabelP9_field);
        exslp9 = (TextView)findViewById(R.id.extraSoilLabelP9_field);
        limlp9 = (TextView)findViewById(R.id.limeLabelP9_field);
        dralp9 = (TextView)findViewById(R.id.drainageLabelP9_field);
        fillp9 = (TextView)findViewById(R.id.fillingLabelP9_field);
        lablp9 = (TextView)findViewById(R.id.laborLabelP9_field);
        gaplp10 = (TextView)findViewById(R.id.gapLabelP10_field);
        grflp10 = (TextView)findViewById(R.id.graftLabelP10_field);
        replp10 = (TextView)findViewById(R.id.replantLabelP10_field);
        exslp10 = (TextView)findViewById(R.id.extraSoilLabelP10_field);
        limlp10 = (TextView)findViewById(R.id.limeLabelP10_field);
        dralp10 = (TextView)findViewById(R.id.drainageLabelP10_field);
        fillp10 = (TextView)findViewById(R.id.fillingLabelP10_field);
        lablp10 = (TextView)findViewById(R.id.laborLabelP10_field);
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

    public void launchYear(View view) {
        save();
        Intent i = new Intent(this, YearDetailActivity.class );
        startActivity(i);
    }

    public void onFinishClicked(View view) {
        save();
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    private void refreshScreen() {
        if (sObject != null){
            if (sObject.getPlantingMaterial1().equals("G")||sObject.getPlantingMaterial1().equals("M")&&sObject.getFarmCondition1().equals("G")&&sObject.getTreeDensity1().equals("G")&&sObject.getTreeAge1().equals("G")&&sObject.getTreeHealth1().equals("G")&&sObject.getDebilitatingDisease1().equals("G")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("G")&&sObject.getOrganicMatter1().equals("G")&&sObject.getFertilizerFormulation1().equals("G")||sObject.getFertilizerFormulation1().equals("M")&&sObject.getFertilizerApplication1().equals("G")||sObject.getFertilizerApplication1().equals("M")) {
                //GAPS
                gaplp1.setVisibility(View.VISIBLE);
                int gapresultP1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.gapP1Y1_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y2_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y3_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y4_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y5_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y6_field),Integer.toString(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y7_field),Integer.toString(gapresultP1));
                lablp1.setVisibility(View.VISIBLE);
                int labor1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(labor1P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(labor1P1));
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                replp1.setVisibility(View.GONE);
                exslp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial1().equals("G")||sObject.getPlantingMaterial1().equals("M")&&sObject.getFarmCondition1().equals("G")&&sObject.getTreeDensity1().equals("G")&&sObject.getTreeAge1().equals("G")&&sObject.getTreeHealth1().equals("G")&&sObject.getDebilitatingDisease1().equals("G")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("B")&&sObject.getOrganicMatter1().equals("B")&&sObject.getFertilizerFormulation1().equals("B")&&sObject.getFertilizerApplication1().equals("B")) {
                //Extra Soil Management
                exslp1.setVisibility(View.VISIBLE);
                int eSoil1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*24622000;
                setText2((TextView) findViewById(R.id.extraSoilP1Y1_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y2_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y3_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y4_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y5_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y6_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y7_field),Integer.toString(eSoil1P1));
                lablp1.setVisibility(View.VISIBLE);
                int laborS1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12825000;
                int laborS2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*13425000;
                int laborS3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(laborS1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(laborS1P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(laborS2P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(laborS3P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(laborS3P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(laborS3P1));
                limlp1.setVisibility(View.VISIBLE);
                int lime1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*1850000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(lime1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),Integer.toString(lime1P1));
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial1().equals("M")&&sObject.getFarmCondition1().equals("G")&&sObject.getTreeDensity1().equals("G")&&sObject.getTreeAge1().equals("B")&&sObject.getTreeHealth1().equals("G")||sObject.getTreeHealth1().equals("B")&&sObject.getDebilitatingDisease1().equals("G")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("G")&&sObject.getOrganicMatter1().equals("G")&&sObject.getFertilizerFormulation1().equals("G")||sObject.getFertilizerFormulation1().equals("M")&&sObject.getFertilizerApplication1().equals("G")||sObject.getFertilizerApplication1().equals("M")) {
                //Grafting
                grflp1.setVisibility(View.VISIBLE);
                int graf1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23467500;
                int graf2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*22358500;
                int graf3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23722000;
                int graf4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.graftP1Y1_field),Integer.toString(graf1P1));
                setText2((TextView) findViewById(R.id.graftP1Y2_field),Integer.toString(graf2P1));
                setText2((TextView) findViewById(R.id.graftP1Y3_field),Integer.toString(graf3P1));
                setText2((TextView) findViewById(R.id.graftP1Y4_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y5_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y6_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y7_field),Integer.toString(graf4P1));
                lablp1.setVisibility(View.VISIBLE);
                int laborGraf1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12000000;
                int laborGraf2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*7200000;
                int laborGraf3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(laborGraf1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(laborGraf2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(laborGraf3P1));
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B")&&sObject.getFarmCondition1().equals("B")&&sObject.getTreeDensity1().equals("B")&&sObject.getTreeAge1().equals("B")||sObject.getTreeAge1().equals("G")&sObject.getTreeHealth1().equals("G")||sObject.getTreeHealth1().equals("B")&&sObject.getDebilitatingDisease1().equals("B")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("G")&&sObject.getOrganicMatter1().equals("G")&&sObject.getFertilizerFormulation1().equals("G")||sObject.getFertilizerFormulation1().equals("M")||sObject.getFertilizerFormulation1().equals("B")&&sObject.getFertilizerApplication1().equals("G")||sObject.getFertilizerApplication1().equals("M")||sObject.getFertilizerApplication1().equals("B")) {
                //Replanting
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*21372000;
                int rep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*19753000;
                int rep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*20640500;
                int rep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.replantP1Y1_field),Integer.toString(rep1P1));
                setText2((TextView) findViewById(R.id.replantP1Y2_field),Integer.toString(rep2P1));
                setText2((TextView) findViewById(R.id.replantP1Y3_field),Integer.toString(rep3P1));
                setText2((TextView) findViewById(R.id.replantP1Y4_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y5_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y6_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y7_field),Integer.toString(rep4P1));
                lablp1.setVisibility(View.VISIBLE);
                int labRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12150000;
                int labRep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6375000;
                int labRep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6975000;
                int labRep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*11250000;
                int labRep5P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(labRep1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(labRep2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(labRep3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(labRep4P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(labRep5P1));
                dralp1.setVisibility(View.VISIBLE);
                int drafRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*2250000;
                setText2((TextView) findViewById(R.id.drainageP1Y1_field),Integer.toString(drafRep1P1));
                setText2((TextView) findViewById(R.id.drainageP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y7_field),"0");
                limlp1.setVisibility(View.VISIBLE);
                int limRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*925000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(limRep1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial2().equals("G")||sObject.getPlantingMaterial2().equals("M")&&sObject.getFarmCondition2().equals("G")&&sObject.getTreeDensity2().equals("G")&&sObject.getTreeAge2().equals("G")&&sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("B")&&sObject.getPruning2().equals("G")||sObject.getPruning2().equals("M")||sObject.getPruning2().equals("B")&&sObject.getPestDiseaseSanitation2().equals("G")||sObject.getPestDiseaseSanitation2().equals("M")||sObject.getPestDiseaseSanitation2().equals("B")&&sObject.getWeeding2().equals("G")||sObject.getWeeding2().equals("B")&&sObject.getHarvesting2().equals("G")||sObject.getHarvesting2().equals("B")&&sObject.getShadeManagement2().equals("G")||sObject.getShadeManagement2().equals("B")&&sObject.getSoilCondition2().equals("G")&&sObject.getOrganicMatter2().equals("G")&&sObject.getFertilizerFormulation2().equals("G")||sObject.getFertilizerFormulation2().equals("M")&&sObject.getFartilizerApplication2().equals("G")||sObject.getFartilizerApplication2().equals("M")) {
                //replant2
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*21372000;
                int rep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*19753000;
                int rep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*20640500;
                int rep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.replantP1Y1_field),Integer.toString(rep1P1));
                setText2((TextView) findViewById(R.id.replantP1Y2_field),Integer.toString(rep2P1));
                setText2((TextView) findViewById(R.id.replantP1Y3_field),Integer.toString(rep3P1));
                setText2((TextView) findViewById(R.id.replantP1Y4_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y5_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y6_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y7_field),Integer.toString(rep4P1));
                lablp1.setVisibility(View.VISIBLE);
                int labRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12150000;
                int labRep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6375000;
                int labRep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6975000;
                int labRep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*11250000;
                int labRep5P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(labRep1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(labRep2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(labRep3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(labRep4P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(labRep5P1));
                dralp1.setVisibility(View.VISIBLE);
                int drafRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*2250000;
                setText2((TextView) findViewById(R.id.drainageP1Y1_field),Integer.toString(drafRep1P1));
                setText2((TextView) findViewById(R.id.drainageP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y7_field),"0");
                limlp1.setVisibility(View.VISIBLE);
                int limRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*925000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(limRep1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }
            //end plot
            if (sObject.getPlantingMaterial2().equals("G")||sObject.getPlantingMaterial2().equals("M")&&sObject.getFarmCondition2().equals("G")&&sObject.getTreeDensity2().equals("G")&&sObject.getTreeAge2().equals("G")&&sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("G")&&sObject.getPruning2().equals("G")||sObject.getPruning2().equals("M")||sObject.getPruning2().equals("B")&&sObject.getPestDiseaseSanitation2().equals("G")||sObject.getPestDiseaseSanitation2().equals("M")||sObject.getPestDiseaseSanitation2().equals("B")&&sObject.getWeeding2().equals("G")||sObject.getWeeding2().equals("B")&&sObject.getHarvesting2().equals("G")||sObject.getHarvesting2().equals("B")&&sObject.getShadeManagement2().equals("G")||sObject.getShadeManagement2().equals("B")&&sObject.getSoilCondition2().equals("G")&&sObject.getOrganicMatter2().equals("G")&&sObject.getFertilizerFormulation2().equals("G")||sObject.getFertilizerFormulation2().equals("M")&&sObject.getFartilizerApplication2().equals("G")||sObject.getFartilizerApplication2().equals("M")) {
                //GAPS
                gaplp2.setVisibility(View.VISIBLE);
                int gapresultP2 = Integer.parseInt(sObject.getPlot2Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.gapP2Y1_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y2_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y3_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y4_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y5_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y6_field),Integer.toString(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y7_field),Integer.toString(gapresultP2));
                lablp2.setVisibility(View.VISIBLE);
                int labor1P2 = Integer.parseInt(sObject.getPlot2Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP2Y1_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y2_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y3_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y4_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y5_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y6_field),Integer.toString(labor1P2));
                setText2((TextView) findViewById(R.id.laborP2Y7_field),Integer.toString(labor1P2));
                fillp2.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP2Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP2Y7_field),"0");
                replp2.setVisibility(View.GONE);
                exslp2.setVisibility(View.GONE);
                limlp2.setVisibility(View.GONE);
                dralp2.setVisibility(View.GONE);
                grflp2.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial2().equals("G")||sObject.getPlantingMaterial2().equals("M")&&sObject.getFarmCondition2().equals("G")&&sObject.getTreeDensity2().equals("G")&&sObject.getTreeAge2().equals("G")&&sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("G")&&sObject.getPruning2().equals("G")||sObject.getPruning2().equals("M")||sObject.getPruning2().equals("B")&&sObject.getPestDiseaseSanitation2().equals("G")||sObject.getPestDiseaseSanitation2().equals("M")||sObject.getPestDiseaseSanitation2().equals("B")&&sObject.getWeeding2().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("B")&&sObject.getOrganicMatter1().equals("B")&&sObject.getFertilizerFormulation1().equals("B")&&sObject.getFertilizerApplication1().equals("B")) {
                //Extra Soil Management
                exslp1.setVisibility(View.VISIBLE);
                int eSoil1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*24622000;
                setText2((TextView) findViewById(R.id.extraSoilP1Y1_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y2_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y3_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y4_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y5_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y6_field),Integer.toString(eSoil1P1));
                setText2((TextView) findViewById(R.id.extraSoilP1Y7_field),Integer.toString(eSoil1P1));
                lablp1.setVisibility(View.VISIBLE);
                int laborS1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12825000;
                int laborS2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*13425000;
                int laborS3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(laborS1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(laborS1P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(laborS2P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(laborS3P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(laborS3P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(laborS3P1));
                limlp1.setVisibility(View.VISIBLE);
                int lime1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*1850000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(lime1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),Integer.toString(lime1P1));
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial1().equals("M")&&sObject.getFarmCondition1().equals("G")&&sObject.getTreeDensity1().equals("G")&&sObject.getTreeAge1().equals("B")&&sObject.getTreeHealth1().equals("G")||sObject.getTreeHealth1().equals("B")&&sObject.getDebilitatingDisease1().equals("G")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("G")&&sObject.getOrganicMatter1().equals("G")&&sObject.getFertilizerFormulation1().equals("G")||sObject.getFertilizerFormulation1().equals("M")&&sObject.getFertilizerApplication1().equals("G")||sObject.getFertilizerApplication1().equals("M")) {
                //Grafting
                grflp1.setVisibility(View.VISIBLE);
                int graf1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23467500;
                int graf2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*22358500;
                int graf3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23722000;
                int graf4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.graftP1Y1_field),Integer.toString(graf1P1));
                setText2((TextView) findViewById(R.id.graftP1Y2_field),Integer.toString(graf2P1));
                setText2((TextView) findViewById(R.id.graftP1Y3_field),Integer.toString(graf3P1));
                setText2((TextView) findViewById(R.id.graftP1Y4_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y5_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y6_field),Integer.toString(graf4P1));
                setText2((TextView) findViewById(R.id.graftP1Y7_field),Integer.toString(graf4P1));
                lablp1.setVisibility(View.VISIBLE);
                int laborGraf1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12000000;
                int laborGraf2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*7200000;
                int laborGraf3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(laborGraf1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(laborGraf2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(laborGraf3P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(laborGraf3P1));
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B")&&sObject.getFarmCondition1().equals("B")&&sObject.getTreeDensity1().equals("B")&&sObject.getTreeAge1().equals("B")||sObject.getTreeAge1().equals("G")&sObject.getTreeHealth1().equals("G")||sObject.getTreeHealth1().equals("B")&&sObject.getDebilitatingDisease1().equals("B")&&sObject.getPruning1().equals("G")||sObject.getPruning1().equals("M")||sObject.getPruning1().equals("B")&&sObject.getPestDiseaseSanitation1().equals("G")||sObject.getPestDiseaseSanitation1().equals("M")||sObject.getPestDiseaseSanitation1().equals("B")&&sObject.getWeeding1().equals("G")||sObject.getWeeding1().equals("B")&&sObject.getHarvesting1().equals("G")||sObject.getHarvesting1().equals("B")&&sObject.getShadeManagement1().equals("G")||sObject.getShadeManagement1().equals("B")&&sObject.getSoilCondition1().equals("G")&&sObject.getOrganicMatter1().equals("G")&&sObject.getFertilizerFormulation1().equals("G")||sObject.getFertilizerFormulation1().equals("M")||sObject.getFertilizerFormulation1().equals("B")&&sObject.getFertilizerApplication1().equals("G")||sObject.getFertilizerApplication1().equals("M")||sObject.getFertilizerApplication1().equals("B")) {
                //Replanting
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*21372000;
                int rep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*19753000;
                int rep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*20640500;
                int rep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.replantP1Y1_field),Integer.toString(rep1P1));
                setText2((TextView) findViewById(R.id.replantP1Y2_field),Integer.toString(rep2P1));
                setText2((TextView) findViewById(R.id.replantP1Y3_field),Integer.toString(rep3P1));
                setText2((TextView) findViewById(R.id.replantP1Y4_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y5_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y6_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y7_field),Integer.toString(rep4P1));
                lablp1.setVisibility(View.VISIBLE);
                int labRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12150000;
                int labRep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6375000;
                int labRep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6975000;
                int labRep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*11250000;
                int labRep5P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(labRep1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(labRep2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(labRep3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(labRep4P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(labRep5P1));
                dralp1.setVisibility(View.VISIBLE);
                int drafRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*2250000;
                setText2((TextView) findViewById(R.id.drainageP1Y1_field),Integer.toString(drafRep1P1));
                setText2((TextView) findViewById(R.id.drainageP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y7_field),"0");
                limlp1.setVisibility(View.VISIBLE);
                int limRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*925000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(limRep1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }else if (sObject.getPlantingMaterial2().equals("G")||sObject.getPlantingMaterial2().equals("M")&&sObject.getFarmCondition2().equals("G")&&sObject.getTreeDensity2().equals("G")&&sObject.getTreeAge2().equals("G")&&sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("B")&&sObject.getPruning2().equals("G")||sObject.getPruning2().equals("M")||sObject.getPruning2().equals("B")&&sObject.getPestDiseaseSanitation2().equals("G")||sObject.getPestDiseaseSanitation2().equals("M")||sObject.getPestDiseaseSanitation2().equals("B")&&sObject.getWeeding2().equals("G")||sObject.getWeeding2().equals("B")&&sObject.getHarvesting2().equals("G")||sObject.getHarvesting2().equals("B")&&sObject.getShadeManagement2().equals("G")||sObject.getShadeManagement2().equals("B")&&sObject.getSoilCondition2().equals("G")&&sObject.getOrganicMatter2().equals("G")&&sObject.getFertilizerFormulation2().equals("G")||sObject.getFertilizerFormulation2().equals("M")&&sObject.getFartilizerApplication2().equals("G")||sObject.getFartilizerApplication2().equals("M")) {
                //replant2
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*21372000;
                int rep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*19753000;
                int rep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*20640500;
                int rep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*23622000;
                setText2((TextView) findViewById(R.id.replantP1Y1_field),Integer.toString(rep1P1));
                setText2((TextView) findViewById(R.id.replantP1Y2_field),Integer.toString(rep2P1));
                setText2((TextView) findViewById(R.id.replantP1Y3_field),Integer.toString(rep3P1));
                setText2((TextView) findViewById(R.id.replantP1Y4_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y5_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y6_field),Integer.toString(rep4P1));
                setText2((TextView) findViewById(R.id.replantP1Y7_field),Integer.toString(rep4P1));
                lablp1.setVisibility(View.VISIBLE);
                int labRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12150000;
                int labRep2P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6375000;
                int labRep3P1 = Integer.parseInt(sObject.getPlot1Area().toString())*6975000;
                int labRep4P1 = Integer.parseInt(sObject.getPlot1Area().toString())*11250000;
                int labRep5P1 = Integer.parseInt(sObject.getPlot1Area().toString())*12075000;
                setText2((TextView) findViewById(R.id.laborP1Y1_field),Integer.toString(labRep1P1));
                setText2((TextView) findViewById(R.id.laborP1Y2_field),Integer.toString(labRep2P1));
                setText2((TextView) findViewById(R.id.laborP1Y3_field),Integer.toString(labRep3P1));
                setText2((TextView) findViewById(R.id.laborP1Y4_field),Integer.toString(labRep4P1));
                setText2((TextView) findViewById(R.id.laborP1Y5_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y6_field),Integer.toString(labRep5P1));
                setText2((TextView) findViewById(R.id.laborP1Y7_field),Integer.toString(labRep5P1));
                dralp1.setVisibility(View.VISIBLE);
                int drafRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*2250000;
                setText2((TextView) findViewById(R.id.drainageP1Y1_field),Integer.toString(drafRep1P1));
                setText2((TextView) findViewById(R.id.drainageP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.drainageP1Y7_field),"0");
                limlp1.setVisibility(View.VISIBLE);
                int limRep1P1 = Integer.parseInt(sObject.getPlot1Area().toString())*925000;
                setText2((TextView) findViewById(R.id.limeP1Y1_field),Integer.toString(limRep1P1));
                setText2((TextView) findViewById(R.id.limeP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.limeP1Y7_field),"0");
                fillp1.setVisibility(View.VISIBLE);
                setText2((TextView) findViewById(R.id.fillingP1Y1_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y2_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y3_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y4_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y5_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y6_field),"0");
                setText2((TextView) findViewById(R.id.fillingP1Y7_field),"0");
                exslp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }
            //end plot

        }
    }

    private void setText(EditText textField, String text) {   if (textField != null) {
            textField.setText(text);
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
        final String start6 = ((Spinner) findViewById(R.id.startP6_field)).getSelectedItem().toString();
        final String start7 = ((Spinner) findViewById(R.id.startP7_field)).getSelectedItem().toString();
        final String start8 = ((Spinner) findViewById(R.id.startP8_field)).getSelectedItem().toString();
        final String start9 = ((Spinner) findViewById(R.id.startP9_field)).getSelectedItem().toString();
        final String start10 = ((Spinner) findViewById(R.id.startP10_field)).getSelectedItem().toString();
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
            contact.put(ContactObject.STARTYEARP6, start6);
            contact.put(ContactObject.STARTYEARP7, start7);
            contact.put(ContactObject.STARTYEARP8, start8);
            contact.put(ContactObject.STARTYEARP9, start9);
            contact.put(ContactObject.STARTYEARP10, start10);
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
