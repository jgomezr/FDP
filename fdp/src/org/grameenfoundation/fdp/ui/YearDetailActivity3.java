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
public class YearDetailActivity3 extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: YearDetailActivity3";
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

            if (yearLaunch.equals("7")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 7");
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY7Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY7Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY7Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY7Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY7Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY7Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY7Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY7Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY7Dec)));
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
