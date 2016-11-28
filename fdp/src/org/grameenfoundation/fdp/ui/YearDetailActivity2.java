package org.grameenfoundation.fdp.ui;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.objects.ContactObject;

import java.text.DecimalFormat;


/**
 * Created by julian_Gf on 7/8/2016.
 */
public class YearDetailActivity2 extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: YearDetailActivity2";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private String yearLaunch;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private TextView p1,p2,p3,p4,p5;
    private LinearLayout p1jan,p1feb,p1mar,p1apr,p1may,p1jun,p1jul,p1aug,p1sep,p1oct,p1nov,p1dec,p2jan,p2feb,p2mar,p2apr,p2may,p2jun,p2jul,p2aug,p2sep,p2oct,p2nov,p2dec,p3jan,p3feb,p3mar,p3apr,p3may,p3jun,p3jul,p3aug,p3sep,p3oct,p3nov,p3dec,p4jan,p4feb,p4mar,p4apr,p4may,p4jun,p4jul,p4aug,p4sep,p4oct,p4nov,p4dec,p5jan,p5feb,p5mar,p5apr,p5may,p5jun,p5jul,p5aug,p5sep,p5oct,p5nov,p5dec;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeardetail);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(R.string.yearDetailActivityTitle);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(fdpActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(fdpActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(fdpActivity.OBJECT_NAME_KEY);
            yearLaunch = launchIntent.getStringExtra(fdpActivity.YEAR_LAUNCH);
        }
        p1 = (TextView)findViewById(R.id.pt1);
        p2 = (TextView)findViewById(R.id.pt2);
        p3 = (TextView)findViewById(R.id.pt3);
        p4 = (TextView)findViewById(R.id.pt4);
        p5 = (TextView)findViewById(R.id.pt5);
        p1jan = (LinearLayout) findViewById(R.id.p1j);
        p1feb = (LinearLayout) findViewById(R.id.p1f);
        p1mar = (LinearLayout) findViewById(R.id.p1mr);
        p1apr = (LinearLayout) findViewById(R.id.p1a);
        p1may = (LinearLayout) findViewById(R.id.p1my);
        p1jun = (LinearLayout) findViewById(R.id.p1jn);
        p1jul = (LinearLayout) findViewById(R.id.p1jl);
        p1aug = (LinearLayout) findViewById(R.id.p1ag);
        p1sep = (LinearLayout) findViewById(R.id.p1sp);
        p1oct = (LinearLayout) findViewById(R.id.p1oc);
        p1nov = (LinearLayout) findViewById(R.id.p1nv);
        p1dec = (LinearLayout) findViewById(R.id.p1dc);
        p2jan = (LinearLayout) findViewById(R.id.p2j);
        p2feb = (LinearLayout) findViewById(R.id.p2f);
        p2mar = (LinearLayout) findViewById(R.id.p2mr);
        p2apr = (LinearLayout) findViewById(R.id.p2a);
        p2may = (LinearLayout) findViewById(R.id.p2my);
        p2jun = (LinearLayout) findViewById(R.id.p2jn);
        p2jul = (LinearLayout) findViewById(R.id.p2jl);
        p2aug = (LinearLayout) findViewById(R.id.p2ag);
        p2sep = (LinearLayout) findViewById(R.id.p2sp);
        p2oct = (LinearLayout) findViewById(R.id.p2oc);
        p2nov = (LinearLayout) findViewById(R.id.p2nv);
        p2dec = (LinearLayout) findViewById(R.id.p2dc);
        p3jan = (LinearLayout) findViewById(R.id.p3j);
        p3feb = (LinearLayout) findViewById(R.id.p3f);
        p3mar = (LinearLayout) findViewById(R.id.p3mr);
        p3apr = (LinearLayout) findViewById(R.id.p3a);
        p3may = (LinearLayout) findViewById(R.id.p3my);
        p3jun = (LinearLayout) findViewById(R.id.p3jn);
        p3jul = (LinearLayout) findViewById(R.id.p3jl);
        p3aug = (LinearLayout) findViewById(R.id.p3ag);
        p3sep = (LinearLayout) findViewById(R.id.p3sp);
        p3oct = (LinearLayout) findViewById(R.id.p3oc);
        p3nov = (LinearLayout) findViewById(R.id.p3nv);
        p3dec = (LinearLayout) findViewById(R.id.p3dc);
        p4jan = (LinearLayout) findViewById(R.id.p4j);
        p4feb = (LinearLayout) findViewById(R.id.p4f);
        p4mar = (LinearLayout) findViewById(R.id.p4mr);
        p4apr = (LinearLayout) findViewById(R.id.p4a);
        p4may = (LinearLayout) findViewById(R.id.p4my);
        p4jun = (LinearLayout) findViewById(R.id.p4jn);
        p4jul = (LinearLayout) findViewById(R.id.p4jl);
        p4aug = (LinearLayout) findViewById(R.id.p4ag);
        p4sep = (LinearLayout) findViewById(R.id.p4sp);
        p4oct = (LinearLayout) findViewById(R.id.p4oc);
        p4nov = (LinearLayout) findViewById(R.id.p4nv);
        p4dec = (LinearLayout) findViewById(R.id.p4dc);
        p5jan = (LinearLayout) findViewById(R.id.p5j);
        p5feb = (LinearLayout) findViewById(R.id.p5f);
        p5mar = (LinearLayout) findViewById(R.id.p5mr);
        p5apr = (LinearLayout) findViewById(R.id.p5a);
        p5may = (LinearLayout) findViewById(R.id.p5my);
        p5jun = (LinearLayout) findViewById(R.id.p5jn);
        p5jul = (LinearLayout) findViewById(R.id.p5jl);
        p5aug = (LinearLayout) findViewById(R.id.p5ag);
        p5sep = (LinearLayout) findViewById(R.id.p5sp);
        p5oct = (LinearLayout) findViewById(R.id.p5oc);
        p5nov = (LinearLayout) findViewById(R.id.p5nv);
        p5dec = (LinearLayout) findViewById(R.id.p5dc);
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent fdpIntent = new Intent(getApplicationContext(), fdpActivity.class);
        fdpIntent.addCategory(Intent.CATEGORY_DEFAULT);
        fdpIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        fdpIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        fdpIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivityForResult(fdpIntent, 0);
        return true;

    }

    public void onBackClicked(View view) {
        final Intent fdpIntent = new Intent(this, fdpActivity.class);
        fdpIntent.addCategory(Intent.CATEGORY_DEFAULT);
        fdpIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        fdpIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        fdpIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivity(fdpIntent);
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

    private void refreshScreen() {
        if (sObject != null) {

            //visibility of plots
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                p1.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);

            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                p2.setVisibility(View.VISIBLE);
                p2jan.setVisibility(View.VISIBLE);
                p2feb.setVisibility(View.VISIBLE);
                p2mar.setVisibility(View.VISIBLE);
                p2apr.setVisibility(View.VISIBLE);
                p2may.setVisibility(View.VISIBLE);
                p2jun.setVisibility(View.VISIBLE);
                p2jul.setVisibility(View.VISIBLE);
                p2aug.setVisibility(View.VISIBLE);
                p2sep.setVisibility(View.VISIBLE);
                p2oct.setVisibility(View.VISIBLE);
                p2nov.setVisibility(View.VISIBLE);
                p2dec.setVisibility(View.VISIBLE);

            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                p3.setVisibility(View.VISIBLE);
                p3jan.setVisibility(View.VISIBLE);
                p3feb.setVisibility(View.VISIBLE);
                p3mar.setVisibility(View.VISIBLE);
                p3apr.setVisibility(View.VISIBLE);
                p3may.setVisibility(View.VISIBLE);
                p3jun.setVisibility(View.VISIBLE);
                p3jul.setVisibility(View.VISIBLE);
                p3aug.setVisibility(View.VISIBLE);
                p3sep.setVisibility(View.VISIBLE);
                p3oct.setVisibility(View.VISIBLE);
                p3nov.setVisibility(View.VISIBLE);
                p3dec.setVisibility(View.VISIBLE);

            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                p4.setVisibility(View.VISIBLE);
                p4jan.setVisibility(View.VISIBLE);
                p4feb.setVisibility(View.VISIBLE);
                p4mar.setVisibility(View.VISIBLE);
                p4apr.setVisibility(View.VISIBLE);
                p4may.setVisibility(View.VISIBLE);
                p4jun.setVisibility(View.VISIBLE);
                p4jul.setVisibility(View.VISIBLE);
                p4aug.setVisibility(View.VISIBLE);
                p4sep.setVisibility(View.VISIBLE);
                p4oct.setVisibility(View.VISIBLE);
                p4nov.setVisibility(View.VISIBLE);
                p4dec.setVisibility(View.VISIBLE);

            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                p5.setVisibility(View.VISIBLE);
                p5jan.setVisibility(View.VISIBLE);
                p5feb.setVisibility(View.VISIBLE);
                p5mar.setVisibility(View.VISIBLE);
                p5apr.setVisibility(View.VISIBLE);
                p5may.setVisibility(View.VISIBLE);
                p5jun.setVisibility(View.VISIBLE);
                p5jul.setVisibility(View.VISIBLE);
                p5aug.setVisibility(View.VISIBLE);
                p5sep.setVisibility(View.VISIBLE);
                p5oct.setVisibility(View.VISIBLE);
                p5nov.setVisibility(View.VISIBLE);
                p5dec.setVisibility(View.VISIBLE);
            }

            int janP1 = 0;
            int febP1 = 0;
            int marP1 = 0;
            int aprP1 = 0;
            int mayP1 = 0;
            int junP1 = 0;
            int julP1 = 0;
            int augP1 = 0;
            int sepP1 = 0;
            int octP1 = 0;
            int novP1 = 0;
            int decP1 = 0;
            int janP2 = 0;
            int febP2 = 0;
            int marP2 = 0;
            int aprP2 = 0;
            int mayP2 = 0;
            int junP2 = 0;
            int julP2 = 0;
            int augP2 = 0;
            int sepP2 = 0;
            int octP2 = 0;
            int novP2 = 0;
            int decP2 = 0;
            int janP3 = 0;
            int febP3 = 0;
            int marP3 = 0;
            int aprP3 = 0;
            int mayP3 = 0;
            int junP3 = 0;
            int julP3 = 0;
            int augP3 = 0;
            int sepP3 = 0;
            int octP3 = 0;
            int novP3 = 0;
            int decP3 = 0;
            int janP4 = 0;
            int febP4 = 0;
            int marP4 = 0;
            int aprP4 = 0;
            int mayP4 = 0;
            int junP4 = 0;
            int julP4 = 0;
            int augP4 = 0;
            int sepP4 = 0;
            int octP4 = 0;
            int novP4 = 0;
            int decP4 = 0;
            int janP5 = 0;
            int febP5 = 0;
            int marP5 = 0;
            int aprP5 = 0;
            int mayP5 = 0;
            int junP5 = 0;
            int julP5 = 0;
            int augP5 = 0;
            int sepP5 = 0;
            int octP5 = 0;
            int novP5 = 0;
            int decP5 = 0;

            double plot1Area = Double.valueOf(sObject.getPlot1Area().toString());
            double plot2Area = Double.valueOf(sObject.getPlot2Area().toString());
            double plot3Area = Double.valueOf(sObject.getPlot3Area().toString());
            double plot4Area = Double.valueOf(sObject.getPlot4Area().toString());
            double plot5Area = Double.valueOf(sObject.getPlot5Area().toString());

            DecimalFormat dec = new DecimalFormat("IDR ###,###,###");
            //conditions to show info per plot

            if (yearLaunch.equals("5")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 5");
                if (sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p1jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p1aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p1splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p1oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p1dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)));
                    }
                }else if((sObject.getFarmCondition1().equals("G")&&sObject.getGENETIC1().equals("B"))||(sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p1jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)));
                    }
                } else if (sObject.getSOILMNG1().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p1jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p1jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)));
                    }
                }


                //plot 2
                if (sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p2jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p2aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p2splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p2oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p2dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)));
                    }
                }else if((sObject.getFarmCondition2().equals("G")&&sObject.getGENETIC2().equals("B"))||(sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p2jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)));
                    }
                } else if (sObject.getSOILMNG2().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p2jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p2jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)));
                    }
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p3jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p3aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p3splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p3oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p3dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)));
                    }
                }else if((sObject.getFarmCondition3().equals("G")&&sObject.getGENETIC3().equals("B"))||(sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p3jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)));
                    }
                } else if (sObject.getSOILMNG3().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p3jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p3jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)));
                    }
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p4jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p4aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p4splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p4oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p4dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)));
                    }
                }else if((sObject.getFarmCondition4().equals("G")&&sObject.getGENETIC4().equals("B"))||(sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p4jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)));
                    }
                } else if (sObject.getSOILMNG4().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p4jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p4jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)));
                    }
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p5jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p5aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p5splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p5oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p5dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)));
                    }
                }else if((sObject.getFarmCondition5().equals("G")&&sObject.getGENETIC5().equals("B"))||(sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p5jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY5Dec)));
                    }
                } else if (sObject.getSOILMNG5().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p5jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p5jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY5Dec)));
                    }
                }
                setText((TextView) findViewById(R.id.p1jcs),String.valueOf(dec.format(janP1)));
                setText((TextView) findViewById(R.id.p1fcs), String.valueOf(dec.format(febP1)));
                setText((TextView) findViewById(R.id.p1mrcs), String.valueOf(dec.format(marP1)));
                setText((TextView) findViewById(R.id.p1acs), String.valueOf(dec.format(aprP1)));
                setText((TextView) findViewById(R.id.p1mycs), String.valueOf(dec.format(mayP1)));
                setText((TextView) findViewById(R.id.p1jncs), String.valueOf(dec.format(junP1)));
                setText((TextView) findViewById(R.id.p1jlcs), String.valueOf(dec.format(julP1)));
                setText((TextView) findViewById(R.id.p1agcs), String.valueOf(dec.format(augP1)));
                setText((TextView) findViewById(R.id.p1spcs), String.valueOf(dec.format(sepP1)));
                setText((TextView) findViewById(R.id.p1occs), String.valueOf(dec.format(octP1)));
                setText((TextView) findViewById(R.id.p1nvcs), String.valueOf(dec.format(novP1)));
                setText((TextView) findViewById(R.id.p1dccs), String.valueOf(dec.format(decP1)));

                setText((TextView) findViewById(R.id.p2jcs),String.valueOf(dec.format(janP2)));
                setText((TextView) findViewById(R.id.p2fcs), String.valueOf(dec.format(febP2)));
                setText((TextView) findViewById(R.id.p2mrcs), String.valueOf(dec.format(marP2)));
                setText((TextView) findViewById(R.id.p2acs), String.valueOf(dec.format(aprP2)));
                setText((TextView) findViewById(R.id.p2mycs), String.valueOf(dec.format(mayP2)));
                setText((TextView) findViewById(R.id.p2jncs), String.valueOf(dec.format(junP2)));
                setText((TextView) findViewById(R.id.p2jlcs), String.valueOf(dec.format(julP2)));
                setText((TextView) findViewById(R.id.p2agcs), String.valueOf(dec.format(augP2)));
                setText((TextView) findViewById(R.id.p2spcs), String.valueOf(dec.format(sepP2)));
                setText((TextView) findViewById(R.id.p2occs), String.valueOf(dec.format(octP2)));
                setText((TextView) findViewById(R.id.p2nvcs), String.valueOf(dec.format(novP2)));
                setText((TextView) findViewById(R.id.p2dccs), String.valueOf(dec.format(decP2)));

                setText((TextView) findViewById(R.id.p3jcs),String.valueOf(dec.format(janP3)));
                setText((TextView) findViewById(R.id.p3fcs), String.valueOf(dec.format(febP3)));
                setText((TextView) findViewById(R.id.p3mrcs), String.valueOf(dec.format(marP3)));
                setText((TextView) findViewById(R.id.p3acs), String.valueOf(dec.format(aprP3)));
                setText((TextView) findViewById(R.id.p3mycs), String.valueOf(dec.format(mayP3)));
                setText((TextView) findViewById(R.id.p3jncs), String.valueOf(dec.format(junP3)));
                setText((TextView) findViewById(R.id.p3jlcs), String.valueOf(dec.format(julP3)));
                setText((TextView) findViewById(R.id.p3agcs), String.valueOf(dec.format(augP3)));
                setText((TextView) findViewById(R.id.p3spcs), String.valueOf(dec.format(sepP3)));
                setText((TextView) findViewById(R.id.p3occs), String.valueOf(dec.format(octP3)));
                setText((TextView) findViewById(R.id.p3nvcs), String.valueOf(dec.format(novP3)));
                setText((TextView) findViewById(R.id.p3dccs), String.valueOf(dec.format(decP3)));

                setText((TextView) findViewById(R.id.p4jcs),String.valueOf(dec.format(janP4)));
                setText((TextView) findViewById(R.id.p4fcs), String.valueOf(dec.format(febP4)));
                setText((TextView) findViewById(R.id.p4mrcs), String.valueOf(dec.format(marP4)));
                setText((TextView) findViewById(R.id.p4acs), String.valueOf(dec.format(aprP4)));
                setText((TextView) findViewById(R.id.p4mycs), String.valueOf(dec.format(mayP4)));
                setText((TextView) findViewById(R.id.p4jncs), String.valueOf(dec.format(junP4)));
                setText((TextView) findViewById(R.id.p4jlcs), String.valueOf(dec.format(julP4)));
                setText((TextView) findViewById(R.id.p4agcs), String.valueOf(dec.format(augP4)));
                setText((TextView) findViewById(R.id.p4spcs), String.valueOf(dec.format(sepP4)));
                setText((TextView) findViewById(R.id.p4occs), String.valueOf(dec.format(octP4)));
                setText((TextView) findViewById(R.id.p4nvcs), String.valueOf(dec.format(novP4)));
                setText((TextView) findViewById(R.id.p4dccs), String.valueOf(dec.format(decP4)));

                setText((TextView) findViewById(R.id.p5jcs),String.valueOf(dec.format(janP5)));
                setText((TextView) findViewById(R.id.p5fcs), String.valueOf(dec.format(febP5)));
                setText((TextView) findViewById(R.id.p5mrcs), String.valueOf(dec.format(marP5)));
                setText((TextView) findViewById(R.id.p5acs), String.valueOf(dec.format(aprP5)));
                setText((TextView) findViewById(R.id.p5mycs), String.valueOf(dec.format(mayP5)));
                setText((TextView) findViewById(R.id.p5jncs), String.valueOf(dec.format(junP5)));
                setText((TextView) findViewById(R.id.p5jlcs), String.valueOf(dec.format(julP5)));
                setText((TextView) findViewById(R.id.p5agcs), String.valueOf(dec.format(augP5)));
                setText((TextView) findViewById(R.id.p5spcs), String.valueOf(dec.format(sepP5)));
                setText((TextView) findViewById(R.id.p5occs), String.valueOf(dec.format(octP5)));
                setText((TextView) findViewById(R.id.p5nvcs), String.valueOf(dec.format(novP5)));
                setText((TextView) findViewById(R.id.p5dccs), String.valueOf(dec.format(decP5)));
            }

            if (yearLaunch.equals("6")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 6");
                if (sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p1jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p1aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p1splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p1oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p1dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)));
                    }
                }else if((sObject.getFarmCondition1().equals("G")&&sObject.getGENETIC1().equals("B"))||(sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p1jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)));
                    }
                } else if (sObject.getSOILMNG1().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p1jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p1jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p1dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor1().equals("Yes")) {
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY6Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)));
                    }
                }


                //plot 2
                if (sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p2jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p2aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p2splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p2oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p2dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)));
                    }
                }else if((sObject.getFarmCondition2().equals("G")&&sObject.getGENETIC2().equals("B"))||(sObject.getFarmCondition2().equals("B")&&(Integer.parseInt(sObject.getPlot2Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p2jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)));
                    }
                } else if (sObject.getSOILMNG2().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p2jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p2jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p2dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor2().equals("Yes")) {
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY6Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)));
                    }
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p3jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p3aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p3splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p3oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p3dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)));
                    }
                }else if((sObject.getFarmCondition3().equals("G")&&sObject.getGENETIC3().equals("B"))||(sObject.getFarmCondition3().equals("B")&&(Integer.parseInt(sObject.getPlot3Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p3jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)));
                    }
                } else if (sObject.getSOILMNG3().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p3jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p3jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p3dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor3().equals("Yes")) {
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY6Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)));
                    }
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p4jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p4aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p4splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p4oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p4dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)));
                    }
                }else if((sObject.getFarmCondition4().equals("G")&&sObject.getGENETIC4().equals("B"))||(sObject.getFarmCondition4().equals("B")&&(Integer.parseInt(sObject.getPlot4Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p4jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)));
                    }
                } else if (sObject.getSOILMNG4().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p4jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p4jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p4dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor4().equals("Yes")) {
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY6Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)));
                    }
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())>25)){
                    //Replanting
                    setText((TextView) findViewById(R.id.p5jlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Harvest, ferment, dry, sell + Clearing");
                    setText((TextView) findViewById(R.id.p5aglb), "Lining-cocoa and shade");
                    setText((TextView) findViewById(R.id.p5splb), "Drainage");//conditional
                    setText((TextView) findViewById(R.id.p5oclb), "Cocoa Planting + Shade Planting");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText((TextView) findViewById(R.id.p5dclb), "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY6Dec)));
                    }
                }else if((sObject.getFarmCondition5().equals("G")&&sObject.getGENETIC5().equals("B"))||(sObject.getFarmCondition5().equals("B")&&(Integer.parseInt(sObject.getPlot5Age().toString())<25))){
                    //Grafting
                    setText((TextView) findViewById(R.id.p5jlb), "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY6Dec)));
                    }
                } else if (sObject.getSOILMNG5().equals("B")){
                    //Extra Soil Management
                    setText((TextView) findViewById(R.id.p5jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY6Dec)));
                    }
                } else {
                    //GAPS
                    setText((TextView) findViewById(R.id.p5jlb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5flb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mrlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5alb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5mylb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jnlb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5jllb), "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5aglb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5splb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5oclb), "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5nvlb), "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText((TextView) findViewById(R.id.p5dclb), "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (sObject.getHireLabor5().equals("Yes")) {
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY6Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY6Dec)));
                    }
                }
                setText((TextView) findViewById(R.id.p1jcs),String.valueOf(dec.format(janP1)));
                setText((TextView) findViewById(R.id.p1fcs), String.valueOf(dec.format(febP1)));
                setText((TextView) findViewById(R.id.p1mrcs), String.valueOf(dec.format(marP1)));
                setText((TextView) findViewById(R.id.p1acs), String.valueOf(dec.format(aprP1)));
                setText((TextView) findViewById(R.id.p1mycs), String.valueOf(dec.format(mayP1)));
                setText((TextView) findViewById(R.id.p1jncs), String.valueOf(dec.format(junP1)));
                setText((TextView) findViewById(R.id.p1jlcs), String.valueOf(dec.format(julP1)));
                setText((TextView) findViewById(R.id.p1agcs), String.valueOf(dec.format(augP1)));
                setText((TextView) findViewById(R.id.p1spcs), String.valueOf(dec.format(sepP1)));
                setText((TextView) findViewById(R.id.p1occs), String.valueOf(dec.format(octP1)));
                setText((TextView) findViewById(R.id.p1nvcs), String.valueOf(dec.format(novP1)));
                setText((TextView) findViewById(R.id.p1dccs), String.valueOf(dec.format(decP1)));

                setText((TextView) findViewById(R.id.p2jcs),String.valueOf(dec.format(janP2)));
                setText((TextView) findViewById(R.id.p2fcs), String.valueOf(dec.format(febP2)));
                setText((TextView) findViewById(R.id.p2mrcs), String.valueOf(dec.format(marP2)));
                setText((TextView) findViewById(R.id.p2acs), String.valueOf(dec.format(aprP2)));
                setText((TextView) findViewById(R.id.p2mycs), String.valueOf(dec.format(mayP2)));
                setText((TextView) findViewById(R.id.p2jncs), String.valueOf(dec.format(junP2)));
                setText((TextView) findViewById(R.id.p2jlcs), String.valueOf(dec.format(julP2)));
                setText((TextView) findViewById(R.id.p2agcs), String.valueOf(dec.format(augP2)));
                setText((TextView) findViewById(R.id.p2spcs), String.valueOf(dec.format(sepP2)));
                setText((TextView) findViewById(R.id.p2occs), String.valueOf(dec.format(octP2)));
                setText((TextView) findViewById(R.id.p2nvcs), String.valueOf(dec.format(novP2)));
                setText((TextView) findViewById(R.id.p2dccs), String.valueOf(dec.format(decP2)));

                setText((TextView) findViewById(R.id.p3jcs),String.valueOf(dec.format(janP3)));
                setText((TextView) findViewById(R.id.p3fcs), String.valueOf(dec.format(febP3)));
                setText((TextView) findViewById(R.id.p3mrcs), String.valueOf(dec.format(marP3)));
                setText((TextView) findViewById(R.id.p3acs), String.valueOf(dec.format(aprP3)));
                setText((TextView) findViewById(R.id.p3mycs), String.valueOf(dec.format(mayP3)));
                setText((TextView) findViewById(R.id.p3jncs), String.valueOf(dec.format(junP3)));
                setText((TextView) findViewById(R.id.p3jlcs), String.valueOf(dec.format(julP3)));
                setText((TextView) findViewById(R.id.p3agcs), String.valueOf(dec.format(augP3)));
                setText((TextView) findViewById(R.id.p3spcs), String.valueOf(dec.format(sepP3)));
                setText((TextView) findViewById(R.id.p3occs), String.valueOf(dec.format(octP3)));
                setText((TextView) findViewById(R.id.p3nvcs), String.valueOf(dec.format(novP3)));
                setText((TextView) findViewById(R.id.p3dccs), String.valueOf(dec.format(decP3)));

                setText((TextView) findViewById(R.id.p4jcs),String.valueOf(dec.format(janP4)));
                setText((TextView) findViewById(R.id.p4fcs), String.valueOf(dec.format(febP4)));
                setText((TextView) findViewById(R.id.p4mrcs), String.valueOf(dec.format(marP4)));
                setText((TextView) findViewById(R.id.p4acs), String.valueOf(dec.format(aprP4)));
                setText((TextView) findViewById(R.id.p4mycs), String.valueOf(dec.format(mayP4)));
                setText((TextView) findViewById(R.id.p4jncs), String.valueOf(dec.format(junP4)));
                setText((TextView) findViewById(R.id.p4jlcs), String.valueOf(dec.format(julP4)));
                setText((TextView) findViewById(R.id.p4agcs), String.valueOf(dec.format(augP4)));
                setText((TextView) findViewById(R.id.p4spcs), String.valueOf(dec.format(sepP4)));
                setText((TextView) findViewById(R.id.p4occs), String.valueOf(dec.format(octP4)));
                setText((TextView) findViewById(R.id.p4nvcs), String.valueOf(dec.format(novP4)));
                setText((TextView) findViewById(R.id.p4dccs), String.valueOf(dec.format(decP4)));

                setText((TextView) findViewById(R.id.p5jcs),String.valueOf(dec.format(janP5)));
                setText((TextView) findViewById(R.id.p5fcs), String.valueOf(dec.format(febP5)));
                setText((TextView) findViewById(R.id.p5mrcs), String.valueOf(dec.format(marP5)));
                setText((TextView) findViewById(R.id.p5acs), String.valueOf(dec.format(aprP5)));
                setText((TextView) findViewById(R.id.p5mycs), String.valueOf(dec.format(mayP5)));
                setText((TextView) findViewById(R.id.p5jncs), String.valueOf(dec.format(junP5)));
                setText((TextView) findViewById(R.id.p5jlcs), String.valueOf(dec.format(julP5)));
                setText((TextView) findViewById(R.id.p5agcs), String.valueOf(dec.format(augP5)));
                setText((TextView) findViewById(R.id.p5spcs), String.valueOf(dec.format(sepP5)));
                setText((TextView) findViewById(R.id.p5occs), String.valueOf(dec.format(octP5)));
                setText((TextView) findViewById(R.id.p5nvcs), String.valueOf(dec.format(novP5)));
                setText((TextView) findViewById(R.id.p5dccs), String.valueOf(dec.format(decP5)));
            }
        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}
