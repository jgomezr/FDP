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
public class YearDetailActivity1 extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: YearDetailActivity1";
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

            if (yearLaunch.equals("3")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 3");
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY3Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY3Dec)));
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

            if (yearLaunch.equals("4")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 4");
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY4Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY4Dec)));
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
