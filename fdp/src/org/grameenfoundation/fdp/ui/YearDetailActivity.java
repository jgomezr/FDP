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
public class YearDetailActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: YearDetailActivity";
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

            if (yearLaunch.equals("1")){

                setText((TextView) findViewById(R.id.yearDetail),"YEAR 1");
                //plot 1
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY1Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
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
            if (yearLaunch.equals("2")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 2");
                //plot 1
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(plot1Area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(plot1Area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(plot1Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)));
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
                        janP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                        febP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                        marP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                        aprP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                        mayP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                        junP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                        julP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                        augP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                        sepP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                        octP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                        novP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                        decP1 = (int) ((plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(plot1Area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                    }else {
                        janP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)));
                        febP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)));
                        marP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)));
                        aprP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)));
                        mayP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2May)));
                        junP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)));
                        julP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)));
                        augP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)));
                        sepP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)));
                        octP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)));
                        novP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)));
                        decP1 = (int) (plot1Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(plot2Area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(plot2Area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(plot2Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)));
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
                        janP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                        febP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                        marP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                        aprP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                        mayP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                        junP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                        julP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                        augP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                        sepP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                        octP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                        novP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                        decP2 = (int) ((plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(plot2Area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                    }else {
                        janP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)));
                        febP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)));
                        marP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)));
                        aprP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)));
                        mayP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2May)));
                        junP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)));
                        julP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)));
                        augP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)));
                        sepP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)));
                        octP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)));
                        novP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)));
                        decP2 = (int) (plot2Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(plot3Area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(plot3Area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(plot3Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)));
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
                        janP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                        febP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                        marP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                        aprP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                        mayP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                        junP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                        julP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                        augP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                        sepP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                        octP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                        novP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                        decP3 = (int) ((plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(plot3Area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                    }else {
                        janP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)));
                        febP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)));
                        marP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)));
                        aprP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)));
                        mayP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2May)));
                        junP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)));
                        julP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)));
                        augP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)));
                        sepP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)));
                        octP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)));
                        novP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)));
                        decP3 = (int) (plot3Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(plot4Area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(plot4Area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(plot4Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)));
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
                        janP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                        febP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                        marP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                        aprP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                        mayP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                        junP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                        julP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                        augP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                        sepP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                        octP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                        novP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                        decP4 = (int) ((plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(plot4Area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                    }else {
                        janP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)));
                        febP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)));
                        marP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)));
                        aprP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)));
                        mayP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2May)));
                        junP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)));
                        julP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)));
                        augP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)));
                        sepP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)));
                        octP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)));
                        novP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)));
                        decP4 = (int) (plot4Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(plot5Area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(plot5Area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GraftingInputY2Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(plot5Area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)));
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
                        janP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                        febP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                        marP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                        aprP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                        mayP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                        junP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                        julP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                        augP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                        sepP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                        octP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                        novP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                        decP5 = (int) ((plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(plot5Area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                    }else {
                        janP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jan)));
                        febP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Feb)));
                        marP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Mar)));
                        aprP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Apr)));
                        mayP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2May)));
                        junP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jun)));
                        julP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Jul)));
                        augP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Aug)));
                        sepP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Sep)));
                        octP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Oct)));
                        novP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Nov)));
                        decP5 = (int) (plot5Area * (getResources().getInteger(R.integer.GAPSInputY2Dec)));
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
