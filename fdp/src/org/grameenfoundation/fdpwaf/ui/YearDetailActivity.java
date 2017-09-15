package org.grameenfoundation.fdpwaf.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
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

import org.grameenfoundation.fdpwaf.R;
import org.grameenfoundation.fdpwaf.loaders.ContactDetailLoader;
import org.grameenfoundation.fdpwaf.objects.ContactObject;


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
    public yearDelayFragment fragment1,fragment2,fragment3,fragment4,fragment5,fragment6,fragment7,fragment8,fragment9,fragment10;
    public replantDetailFragment replant1,replant2,replant3,replant4,replant5,replant6,replant7,replant8,replant9,replant10;
    public graftingDetailFragment graft1,graft2,graft3,graft4,graft5,graft6,graft7,graft8,graft9,graft10;
    public extraDetailFragment extra1,extra2,extra3,extra4,extra5,extra6,extra7,extra8,extra9,extra10;
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
        fragment1 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot1);
        replant1 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot1);
        graft1 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot1);
        extra1 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot1);
        fragment2 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot2);
        replant2 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot2);
        graft2 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot2);
        extra2 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot2);
        fragment3 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot3);
        replant3 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot3);
        graft3 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot3);
        extra3 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot3);
        fragment4 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot4);
        replant4 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot4);
        graft4 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot4);
        extra4 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot4);
        fragment5 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot5);
        replant5 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot5);
        graft5 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot5);
        extra5 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot5);
        fragment6 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot6);
        replant6 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot6);
        graft6 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot6);
        extra6 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot6);
        fragment7 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot7);
        replant7 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot7);
        graft7 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot7);
        extra7 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot7);
        fragment8 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot8);
        replant8 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot8);
        graft8 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot8);
        extra8 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot8);
        fragment9 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot9);
        replant9 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot9);
        graft9 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot9);
        extra9 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot9);
        fragment10 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot10);
        replant10 = (replantDetailFragment) getFragmentManager().findFragmentById(R.id.fgrPlot10);
        graft10 = (graftingDetailFragment) getFragmentManager().findFragmentById(R.id.fggPlot10);
        extra10 = (extraDetailFragment) getFragmentManager().findFragmentById(R.id.fgePlot10);
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
        finish();
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
            double plot1Area = 0;
            double plot2Area = 0;
            double plot3Area = 0;
            double plot4Area = 0;
            double plot5Area = 0;
            double plot6Area = 0;
            double plot7Area = 0;
            double plot8Area = 0;
            double plot9Area = 0;
            double plot10Area = 0;
            if (sObject.getAREAUNITS().contentEquals("Ac")){
                plot1Area = Double.valueOf(sObject.getPlot1Area())*0.4046856;
                plot2Area = Double.valueOf(sObject.getPlot2Area())*0.4046856;
                plot3Area = Double.valueOf(sObject.getPlot3Area())*0.4046856;
                plot4Area = Double.valueOf(sObject.getPlot4Area())*0.4046856;
                plot5Area = Double.valueOf(sObject.getPlot5Area())*0.4046856;
                plot6Area = Double.valueOf(sObject.getPlot6Area())*0.4046856;
                plot7Area = Double.valueOf(sObject.getPlot7Area())*0.4046856;
                plot8Area = Double.valueOf(sObject.getPlot8Area())*0.4046856;
                plot9Area = Double.valueOf(sObject.getPlot9Area())*0.4046856;
                plot10Area = Double.valueOf(sObject.getPlot10Area())*0.4046856;
            }else{
                plot1Area = Double.valueOf(sObject.getPlot1Area());
                plot2Area = Double.valueOf(sObject.getPlot2Area());
                plot3Area = Double.valueOf(sObject.getPlot3Area());
                plot4Area = Double.valueOf(sObject.getPlot4Area());
                plot5Area = Double.valueOf(sObject.getPlot5Area());
                plot6Area = Double.valueOf(sObject.getPlot6Area());
                plot7Area = Double.valueOf(sObject.getPlot7Area());
                plot8Area = Double.valueOf(sObject.getPlot8Area());
                plot9Area = Double.valueOf(sObject.getPlot9Area());
                plot10Area = Double.valueOf(sObject.getPlot10Area());
            }

            String startY1 = sObject.getStartYearP1();
            String startY2 = sObject.getStartYearP2();
            String startY3 = sObject.getStartYearP3();
            String startY4 = sObject.getStartYearP4();
            String startY5 = sObject.getStartYearP5();
            String startY6 = sObject.getStartYearP6();
            String startY7 = sObject.getStartYearP7();
            String startY8 = sObject.getStartYearP8();
            String startY9 = sObject.getStartYearP9();
            String startY10 = sObject.getStartYearP10();
            setText((TextView) findViewById(R.id.yearDetail),(getString(R.string.year)+yearLaunch));

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //visibility of plots
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                if(sObject.getPLOT1RENOVATION().equals("Yes")||sObject.getPLOT1RENOVATION().equals("Oui")){
                    if(sObject.getPLOT1RENOVATIONREASON().equals("Replanting")||sObject.getPLOT1RENOVATIONREASON().equals("Replantation")){
                        ft.show(replant1);
                        ft.hide(fragment1);
                        ft.hide(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            replant1.calc(getString(R.string.pt1),"", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            replant1.calc(getString(R.string.pt1),"", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            replant1.calc(getString(R.string.pt1),"", "", plot1Area, startY1, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment1);
                        ft.hide(replant1);
                        ft.show(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            graft1.calc(getString(R.string.pt1), "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            graft1.calc(getString(R.string.pt1), "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            graft1.calc(getString(R.string.pt1), "", "", plot1Area, startY1, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO1().equals("replanting")) {
                        //Replant
                        ft.show(replant1);
                        ft.hide(fragment1);
                        ft.hide(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Oui")) {
                            replant1.calc(getString(R.string.pt1), "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Saisonnier")) {
                            replant1.calc(getString(R.string.pt1), "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            replant1.calc(getString(R.string.pt1), "", "", plot1Area, startY1, yearLaunch);
                        }
                    }else if (sObject.getRECO1().equals("replanting+extra")){
                        ft.show(replant1);
                        ft.hide(fragment1);
                        ft.hide(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            replant1.calc(getString(R.string.pt1), "extra", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            replant1.calc(getString(R.string.pt1), "extra", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            replant1.calc(getString(R.string.pt1), "extra", "", plot1Area, startY1, yearLaunch);
                        }

                    } else if (sObject.getRECO1().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment1);
                        ft.hide(replant1);
                        ft.show(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            graft1.calc(getString(R.string.pt1), "extra", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            graft1.calc(getString(R.string.pt1), "extra", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            graft1.calc(getString(R.string.pt1), "extra", "", plot1Area, startY1, yearLaunch);
                        }
                    } else if (sObject.getRECO1().equals("grafting")) {
                        ft.hide(fragment1);
                        ft.hide(replant1);
                        ft.show(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            graft1.calc(getString(R.string.pt1), "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            graft1.calc(getString(R.string.pt1), "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            graft1.calc(getString(R.string.pt1), "", "", plot1Area, startY1, yearLaunch);
                        }

                    } else if (sObject.getRECO1().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment1);
                        ft.hide(replant1);
                        ft.hide(graft1);
                        ft.show(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            extra1.calc(getString(R.string.pt1), "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            extra1.calc(getString(R.string.pt1), "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            extra1.calc(getString(R.string.pt1), "", "", plot1Area, startY1, yearLaunch);
                        }

                    } else {
                        //GAP
                        ft.show(fragment1);
                        ft.hide(replant1);
                        ft.hide(graft1);
                        ft.hide(extra1);
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui")) {
                            fragment1.calc(getString(R.string.pt1), "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.calc(getString(R.string.pt1), "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            fragment1.calc(getString(R.string.pt1), "", "", plot1Area, startY1, yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment1);
                ft.hide(replant1);
                ft.hide(graft1);
                ft.hide(extra1);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                if(sObject.getPLOT2RENOVATION().equals("Yes")||sObject.getPLOT2RENOVATION().equals("Oui")){
                    if(sObject.getPLOT2RENOVATIONREASON().equals("Replanting")||sObject.getPLOT2RENOVATIONREASON().equals("Replantation")){
                        ft.show(replant2);
                        ft.hide(fragment2);
                        ft.hide(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            replant2.calc(getString(R.string.pt2), "", "labor", plot2Area, startY2, yearLaunch);
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")) {
                            replant2.calc(getString(R.string.pt2), "", "season", plot2Area, startY2, yearLaunch);
                        } else {
                            replant2.calc(getString(R.string.pt2), "", "", plot2Area, startY2, yearLaunch);
                        }

                    }else{
                        ft.hide(replant2);
                        ft.hide(fragment2);
                        ft.show(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            graft2.calc(getString(R.string.pt2), "", "labor", plot2Area, startY2, yearLaunch);
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")) {
                            graft2.calc(getString(R.string.pt2), "", "season", plot2Area, startY2, yearLaunch);
                        } else {
                            graft2.calc(getString(R.string.pt2), "", "", plot2Area, startY2, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO2().equals("replanting")) {
                        //Replant
                        ft.show(replant2);
                        ft.hide(fragment2);
                        ft.hide(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Oui") || sObject.getHireLabor2().equals("Oui")) {
                            replant2.calc(getString(R.string.pt2), "", "labor", plot2Area, startY2, yearLaunch);
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Saisonnier")) {
                            replant2.calc(getString(R.string.pt2), "", "season", plot2Area, startY2, yearLaunch);
                        } else {
                            replant2.calc(getString(R.string.pt2), "", "", plot2Area, startY2, yearLaunch);
                        }
                    }else if (sObject.getRECO2().equals("replanting+extra")){
                        ft.show(replant2);
                        ft.hide(fragment2);
                        ft.hide(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            replant2.calc(getString(R.string.pt2),"extra","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")){
                            replant2.calc(getString(R.string.pt2),"extra","season",plot2Area,startY2,yearLaunch);
                        }else{
                            replant2.calc(getString(R.string.pt2),"extra","",plot2Area,startY2,yearLaunch);
                        }

                    } else if(sObject.getRECO2().equals("grafting+extra")) {
                        //Graft
                        ft.hide(replant2);
                        ft.hide(fragment2);
                        ft.show(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            graft2.calc(getString(R.string.pt2),"extra","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")){
                            graft2.calc(getString(R.string.pt2),"extra","season",plot2Area,startY2,yearLaunch);
                        }else{
                            graft2.calc(getString(R.string.pt2),"extra","",plot2Area,startY2,yearLaunch);
                        }
                    }else if (sObject.getRECO2().equals("grafting")) {
                        ft.hide(replant2);
                        ft.hide(fragment2);
                        ft.show(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            graft2.calc(getString(R.string.pt2),"","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")){
                            graft2.calc(getString(R.string.pt2),"","season",plot2Area,startY2,yearLaunch);
                        }else{
                            graft2.calc(getString(R.string.pt2),"","",plot2Area,startY2,yearLaunch);
                        }

                    }else if (sObject.getRECO2().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(replant2);
                        ft.hide(fragment2);
                        ft.hide(graft2);
                        ft.show(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            extra2.calc(getString(R.string.pt2),"","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")){
                            extra2.calc(getString(R.string.pt2),"","season",plot2Area,startY2,yearLaunch);
                        }else{
                            extra2.calc(getString(R.string.pt2),"","",plot2Area,startY2,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.hide(replant2);
                        ft.show(fragment2);
                        ft.hide(graft2);
                        ft.hide(extra2);
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui")) {
                            fragment2.calc(getString(R.string.pt2),"","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier")){
                            fragment2.calc(getString(R.string.pt2),"","season",plot2Area,startY2,yearLaunch);
                        }else{
                            fragment2.calc(getString(R.string.pt2),"","",plot2Area,startY2,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment2);
                ft.hide(replant2);
                ft.hide(graft2);
                ft.hide(extra2);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                if(sObject.getPLOT3RENOVATION().equals("Yes")||sObject.getPLOT3RENOVATION().equals("Oui")){
                    if(sObject.getPLOT3RENOVATIONREASON().equals("Replanting")||sObject.getPLOT3RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment3);
                        ft.show(replant3);
                        ft.hide(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            replant3.calc(getString(R.string.pt3), "", "labor", plot3Area, startY3, yearLaunch);
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            replant3.calc(getString(R.string.pt3), "", "season", plot3Area, startY3, yearLaunch);
                        } else {
                            replant3.calc(getString(R.string.pt3), "", "", plot3Area, startY3, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment3);
                        ft.hide(replant3);
                        ft.show(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            graft3.calc(getString(R.string.pt3), "", "labor", plot3Area, startY3, yearLaunch);
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            graft3.calc(getString(R.string.pt3), "", "season", plot3Area, startY3, yearLaunch);
                        } else {
                            graft3.calc(getString(R.string.pt3), "", "", plot3Area, startY3, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO3().equals("replanting")) {
                        //Replant
                        ft.hide(fragment3);
                        ft.show(replant3);
                        ft.hide(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Oui")) {
                            replant3.calc(getString(R.string.pt3), "", "labor", plot3Area, startY3, yearLaunch);
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Saisonnier")) {
                            replant3.calc(getString(R.string.pt3), "", "season", plot3Area, startY3, yearLaunch);
                        } else {
                            replant3.calc(getString(R.string.pt3), "", "", plot3Area, startY3, yearLaunch);
                        }
                    }else if (sObject.getRECO3().equals("replanting+extra")){
                        ft.hide(fragment3);
                        ft.show(replant3);
                        ft.hide(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui")) {
                            replant3.calc(getString(R.string.pt3),"extra","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier")){
                            replant3.calc(getString(R.string.pt3),"extra","season",plot3Area,startY3,yearLaunch);
                        }else{
                            replant3.calc(getString(R.string.pt3),"extra","",plot3Area,startY3,yearLaunch);
                        }

                    } else if(sObject.getRECO3().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment3);
                        ft.hide(replant3);
                        ft.show(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui")) {
                            graft3.calc(getString(R.string.pt3),"extra","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier")){
                            graft3.calc(getString(R.string.pt3),"extra","season",plot3Area,startY3,yearLaunch);
                        }else{
                            graft3.calc(getString(R.string.pt3),"extra","",plot3Area,startY3,yearLaunch);
                        }
                    }else if (sObject.getRECO3().equals("grafting")) {
                        ft.hide(fragment3);
                        ft.hide(replant3);
                        ft.show(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui")) {
                            graft3.calc(getString(R.string.pt3),"","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier")){
                            graft3.calc(getString(R.string.pt3),"","season",plot3Area,startY3,yearLaunch);
                        }else{
                            graft3.calc(getString(R.string.pt3),"","",plot3Area,startY3,yearLaunch);
                        }

                    }else if (sObject.getRECO3().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment3);
                        ft.hide(replant3);
                        ft.hide(graft3);
                        ft.show(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui")) {
                            extra3.calc(getString(R.string.pt3),"","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier")){
                            extra3.calc(getString(R.string.pt3),"","season",plot3Area,startY3,yearLaunch);
                        }else{
                            extra3.calc(getString(R.string.pt3),"","",plot3Area,startY3,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment3);
                        ft.hide(replant3);
                        ft.hide(graft3);
                        ft.hide(extra3);
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui")) {
                            fragment3.calc(getString(R.string.pt3),"","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier")){
                            fragment3.calc(getString(R.string.pt3),"","season",plot3Area,startY3,yearLaunch);
                        }else{
                            fragment3.calc(getString(R.string.pt3),"","",plot3Area,startY3,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment3);
                ft.hide(replant3);
                ft.hide(graft3);
                ft.hide(extra3);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                if(sObject.getPLOT4RENOVATION().equals("Yes")||sObject.getPLOT4RENOVATION().equals("Oui")){
                    if(sObject.getPLOT4RENOVATIONREASON().equals("Replanting")||sObject.getPLOT4RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment4);
                        ft.show(replant4);
                        ft.hide(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            replant4.calc(getString(R.string.pt4), "", "labor", plot4Area, startY4, yearLaunch);
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            replant4.calc(getString(R.string.pt4), "", "season", plot4Area, startY4, yearLaunch);
                        } else {
                            replant4.calc(getString(R.string.pt4), "", "", plot4Area, startY4, yearLaunch);
                        }
                    }else{
                        ft.hide(fragment4);
                        ft.hide(replant4);
                        ft.show(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            graft4.calc(getString(R.string.pt4), "", "labor", plot4Area, startY4, yearLaunch);
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            graft4.calc(getString(R.string.pt4), "", "season", plot4Area, startY4, yearLaunch);
                        } else {
                            graft4.calc(getString(R.string.pt4), "", "", plot4Area, startY4, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getRECO4().equals("replanting")) {
                        //Replant
                        ft.hide(fragment4);
                        ft.show(replant4);
                        ft.hide(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Oui")) {
                            replant4.calc(getString(R.string.pt4), "", "labor", plot4Area, startY4, yearLaunch);
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Saisonnier")) {
                            replant4.calc(getString(R.string.pt4), "", "season", plot4Area, startY4, yearLaunch);
                        } else {
                            replant4.calc(getString(R.string.pt4), "", "", plot4Area, startY4, yearLaunch);
                        }
                    }else if (sObject.getRECO4().equals("replanting+extra")){
                        ft.hide(fragment4);
                        ft.show(replant4);
                        ft.hide(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui")) {
                            replant4.calc(getString(R.string.pt4),"extra","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier")){
                            replant4.calc(getString(R.string.pt4),"extra","season",plot4Area,startY4,yearLaunch);
                        }else{
                            replant4.calc(getString(R.string.pt4),"extra","",plot4Area,startY4,yearLaunch);
                        }

                    } else if(sObject.getRECO4().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment4);
                        ft.hide(replant4);
                        ft.show(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui")) {
                            graft4.calc(getString(R.string.pt4),"extra","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier")){
                            graft4.calc(getString(R.string.pt4),"extra","season",plot4Area,startY4,yearLaunch);
                        }else{
                            graft4.calc(getString(R.string.pt4),"extra","",plot4Area,startY4,yearLaunch);
                        }
                    }else if (sObject.getRECO4().equals("grafting")) {
                        ft.hide(fragment4);
                        ft.hide(replant4);
                        ft.show(graft4);
                        ft.hide(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui")) {
                            graft4.calc(getString(R.string.pt4),"","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier")){
                            graft4.calc(getString(R.string.pt4),"","season",plot4Area,startY4,yearLaunch);
                        }else{
                            graft4.calc(getString(R.string.pt4),"","",plot4Area,startY4,yearLaunch);
                        }

                    }else if (sObject.getRECO4().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment4);
                        ft.hide(replant4);
                        ft.hide(graft4);
                        ft.show(extra4);
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui")) {
                            extra4.calc(getString(R.string.pt4),"","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier")){
                            extra4.calc(getString(R.string.pt4),"","season",plot4Area,startY4,yearLaunch);
                        }else{
                            extra4.calc(getString(R.string.pt4),"","",plot4Area,startY4,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment4);
                        ft.hide(replant4);
                        ft.hide(graft4);
                        ft.hide(extra4);

                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui")) {
                            fragment4.calc(getString(R.string.pt4),"","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier")){
                            fragment4.calc(getString(R.string.pt4),"","season",plot4Area,startY4,yearLaunch);
                        }else{
                            fragment4.calc(getString(R.string.pt4),"","",plot4Area,startY4,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment4);
                ft.hide(replant4);
                ft.hide(graft4);
                ft.hide(extra4);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                if(sObject.getPLOT5RENOVATION().equals("Yes")||sObject.getPLOT5RENOVATION().equals("Oui")){
                    if(sObject.getPLOT5RENOVATIONREASON().equals("Replanting")||sObject.getPLOT5RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment5);
                        ft.show(replant5);
                        ft.hide(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            replant5.calc(getString(R.string.pt5), "", "labor", plot5Area, startY5, yearLaunch);
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            replant5.calc(getString(R.string.pt5), "", "season", plot5Area, startY5, yearLaunch);
                        } else {
                            replant5.calc(getString(R.string.pt5), "", "", plot5Area, startY5, yearLaunch);
                        }
                    }else{
                        ft.hide(fragment5);
                        ft.hide(replant5);
                        ft.show(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            graft5.calc(getString(R.string.pt5), "", "labor", plot5Area, startY5, yearLaunch);
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            graft5.calc(getString(R.string.pt5), "", "season", plot5Area, startY5, yearLaunch);
                        } else {
                            graft5.calc(getString(R.string.pt5), "", "", plot5Area, startY5, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getRECO5().equals("replanting")) {
                        //Replant
                        ft.hide(fragment5);
                        ft.show(replant5);
                        ft.hide(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Oui")) {
                            replant5.calc(getString(R.string.pt5), "", "labor", plot5Area, startY5, yearLaunch);
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Saisonnier")) {
                            replant5.calc(getString(R.string.pt5), "", "season", plot5Area, startY5, yearLaunch);
                        } else {
                            replant5.calc(getString(R.string.pt5), "", "", plot5Area, startY5, yearLaunch);
                        }
                    }else if (sObject.getRECO5().equals("replanting+extra")){
                        ft.hide(fragment5);
                        ft.show(replant5);
                        ft.hide(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui")) {
                            replant5.calc(getString(R.string.pt5),"extra","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier")){
                            replant5.calc(getString(R.string.pt5),"extra","season",plot5Area,startY5,yearLaunch);
                        }else{
                            replant5.calc(getString(R.string.pt5),"extra","",plot5Area,startY5,yearLaunch);
                        }

                    } else if(sObject.getRECO5().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment5);
                        ft.hide(replant5);
                        ft.show(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui")) {
                            graft5.calc(getString(R.string.pt5),"extra","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier")){
                            graft5.calc(getString(R.string.pt5),"extra","season",plot5Area,startY5,yearLaunch);
                        }else{
                            graft5.calc(getString(R.string.pt5),"extra","",plot5Area,startY5,yearLaunch);
                        }
                    }else if (sObject.getRECO5().equals("grafting")) {
                        ft.hide(fragment5);
                        ft.hide(replant5);
                        ft.show(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui")) {
                            graft5.calc(getString(R.string.pt5),"","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier")){
                            graft5.calc(getString(R.string.pt5),"","season",plot5Area,startY5,yearLaunch);
                        }else{
                            graft5.calc(getString(R.string.pt5),"","",plot5Area,startY5,yearLaunch);
                        }

                    }else if (sObject.getRECO5().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment5);
                        ft.hide(replant5);
                        ft.hide(graft5);
                        ft.show(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui")) {
                            extra5.calc(getString(R.string.pt5),"","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier")){
                            extra5.calc(getString(R.string.pt5),"","season",plot5Area,startY5,yearLaunch);
                        }else{
                            extra5.calc(getString(R.string.pt5),"","",plot5Area,startY5,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment5);
                        ft.hide(replant5);
                        ft.hide(graft5);
                        ft.hide(extra5);
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui")) {
                            fragment5.calc(getString(R.string.pt5),"","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier")){
                            fragment5.calc(getString(R.string.pt5),"","season",plot5Area,startY5,yearLaunch);
                        }else{
                            fragment5.calc(getString(R.string.pt5),"","",plot5Area,startY5,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment5);
                ft.hide(replant5);
                ft.hide(graft5);
                ft.hide(extra5);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                if(sObject.getPLOT6RENOVATION().equals("Yes")||sObject.getPLOT6RENOVATION().equals("Oui")){
                    if(sObject.getPLOT6RENOVATIONREASON().equals("Replanting")||sObject.getPLOT6RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment6);
                        ft.show(replant6);
                        ft.hide(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            replant6.calc(getString(R.string.pt6), "", "labor", plot6Area, startY6, yearLaunch);
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            replant6.calc(getString(R.string.pt6), "", "season", plot6Area, startY6, yearLaunch);
                        } else {
                            replant6.calc(getString(R.string.pt6), "", "", plot6Area, startY6, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment6);
                        ft.hide(replant6);
                        ft.show(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            graft6.calc(getString(R.string.pt6), "", "labor", plot6Area, startY6, yearLaunch);
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            graft6.calc(getString(R.string.pt6), "", "season", plot6Area, startY6, yearLaunch);
                        } else {
                            graft6.calc(getString(R.string.pt6), "", "", plot6Area, startY6, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO6().equals("replanting")) {
                        //Replant
                        ft.hide(fragment6);
                        ft.show(replant6);
                        ft.hide(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Oui")) {
                            replant6.calc(getString(R.string.pt6), "", "labor", plot6Area, startY6, yearLaunch);
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Saisonnier")) {
                            replant6.calc(getString(R.string.pt6), "", "season", plot6Area, startY6, yearLaunch);
                        } else {
                            replant6.calc(getString(R.string.pt6), "", "", plot6Area, startY6, yearLaunch);
                        }
                    }else if (sObject.getRECO6().equals("replanting+extra")){
                        ft.hide(fragment6);
                        ft.show(replant6);
                        ft.hide(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui")) {
                            replant6.calc(getString(R.string.pt6),"extra","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier")){
                            replant6.calc(getString(R.string.pt6),"extra","season",plot6Area,startY6,yearLaunch);
                        }else{
                            replant6.calc(getString(R.string.pt6),"extra","",plot6Area,startY6,yearLaunch);
                        }

                    } else if(sObject.getRECO6().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment6);
                        ft.hide(replant6);
                        ft.show(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui")) {
                            graft6.calc(getString(R.string.pt6),"extra","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier")){
                            graft6.calc(getString(R.string.pt6),"extra","season",plot6Area,startY6,yearLaunch);
                        }else{
                            graft6.calc(getString(R.string.pt6),"extra","",plot6Area,startY6,yearLaunch);
                        }
                    }else if (sObject.getRECO6().equals("grafting")) {
                        ft.hide(fragment6);
                        ft.hide(replant6);
                        ft.show(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui")) {
                            graft6.calc(getString(R.string.pt6),"","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier")){
                            graft6.calc(getString(R.string.pt6),"","season",plot6Area,startY6,yearLaunch);
                        }else{
                            graft6.calc(getString(R.string.pt6),"","",plot6Area,startY6,yearLaunch);
                        }
                    }else if (sObject.getRECO6().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment6);
                        ft.hide(replant6);
                        ft.hide(graft6);
                        ft.show(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui")) {
                            extra6.calc(getString(R.string.pt6),"","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier")){
                            extra6.calc(getString(R.string.pt6),"","season",plot6Area,startY6,yearLaunch);
                        }else{
                            extra6.calc(getString(R.string.pt6),"","",plot6Area,startY6,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment6);
                        ft.hide(replant6);
                        ft.hide(graft6);
                        ft.hide(extra6);
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui")) {
                            fragment6.calc(getString(R.string.pt6),"","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier")){
                            fragment6.calc(getString(R.string.pt6),"","season",plot6Area,startY6,yearLaunch);
                        }else{
                            fragment6.calc(getString(R.string.pt6),"","",plot6Area,startY6,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment6);
                ft.hide(replant6);
                ft.hide(graft6);
                ft.hide(extra6);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                if(sObject.getPLOT7RENOVATION().equals("Yes")||sObject.getPLOT7RENOVATION().equals("Oui")){
                    if(sObject.getPLOT7RENOVATIONREASON().equals("Replanting")||sObject.getPLOT7RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment7);
                        ft.show(replant7);
                        ft.hide(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            replant7.calc(getString(R.string.pt7), "", "labor", plot7Area, startY7, yearLaunch);
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            replant7.calc(getString(R.string.pt7), "", "season", plot7Area, startY7, yearLaunch);
                        } else {
                            replant7.calc(getString(R.string.pt7), "", "", plot7Area, startY7, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment7);
                        ft.hide(replant7);
                        ft.show(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            graft7.calc(getString(R.string.pt7), "", "labor", plot7Area, startY7, yearLaunch);
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            graft7.calc(getString(R.string.pt7), "", "season", plot7Area, startY7, yearLaunch);
                        } else {
                            graft7.calc(getString(R.string.pt7), "", "", plot7Area, startY7, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO7().equals("replanting")) {
                        //Replant
                        ft.hide(fragment7);
                        ft.show(replant7);
                        ft.hide(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Oui")) {
                            replant7.calc(getString(R.string.pt7), "", "labor", plot7Area, startY7, yearLaunch);
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Saisonnier")) {
                            replant7.calc(getString(R.string.pt7), "", "season", plot7Area, startY7, yearLaunch);
                        } else {
                            replant7.calc(getString(R.string.pt7), "", "", plot7Area, startY7, yearLaunch);
                        }
                    }else if (sObject.getRECO7().equals("replanting+extra")){
                        ft.hide(fragment7);
                        ft.show(replant7);
                        ft.hide(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui")) {
                            replant7.calc(getString(R.string.pt7),"extra","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier")){
                            replant7.calc(getString(R.string.pt7),"extra","season",plot7Area,startY7,yearLaunch);
                        }else{
                            replant7.calc(getString(R.string.pt7),"extra","",plot7Area,startY7,yearLaunch);
                        }

                    } else if(sObject.getRECO7().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment7);
                        ft.hide(replant7);
                        ft.show(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui")) {
                            graft7.calc(getString(R.string.pt7),"extra","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier")){
                            graft7.calc(getString(R.string.pt7),"extra","season",plot7Area,startY7,yearLaunch);
                        }else{
                            graft7.calc(getString(R.string.pt7),"extra","",plot7Area,startY7,yearLaunch);
                        }
                    }else if (sObject.getRECO7().equals("grafting")) {
                        ft.hide(fragment7);
                        ft.hide(replant7);
                        ft.show(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui")) {
                            graft7.calc(getString(R.string.pt7),"","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier")){
                            graft7.calc(getString(R.string.pt7),"","season",plot7Area,startY7,yearLaunch);
                        }else{
                            graft7.calc(getString(R.string.pt7),"","",plot7Area,startY7,yearLaunch);
                        }

                    }else if (sObject.getRECO7().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment7);
                        ft.hide(replant7);
                        ft.hide(graft7);
                        ft.show(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui")) {
                            extra7.calc(getString(R.string.pt7),"","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier")){
                            extra7.calc(getString(R.string.pt7),"","season",plot7Area,startY7,yearLaunch);
                        }else{
                            extra7.calc(getString(R.string.pt7),"","",plot7Area,startY7,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment7);
                        ft.hide(replant7);
                        ft.hide(graft7);
                        ft.hide(extra7);
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui")) {
                            fragment7.calc(getString(R.string.pt7),"","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier")){
                            fragment7.calc(getString(R.string.pt7),"","season",plot7Area,startY7,yearLaunch);
                        }else{
                            fragment7.calc(getString(R.string.pt7),"","",plot7Area,startY7,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment7);
                ft.hide(replant7);
                ft.hide(graft7);
                ft.hide(extra7);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                if(sObject.getPLOT8RENOVATION().equals("Yes")||sObject.getPLOT8RENOVATION().equals("Oui")){
                    if(sObject.getPLOT8RENOVATIONREASON().equals("Replanting")||sObject.getPLOT8RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment8);
                        ft.show(replant8);
                        ft.hide(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            replant8.calc(getString(R.string.pt8), "", "labor", plot8Area, startY8, yearLaunch);
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            replant8.calc(getString(R.string.pt8), "", "season", plot8Area, startY8, yearLaunch);
                        } else {
                            replant8.calc(getString(R.string.pt8), "", "", plot8Area, startY8, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment8);
                        ft.hide(replant8);
                        ft.show(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            graft8.calc(getString(R.string.pt8), "", "labor", plot8Area, startY8, yearLaunch);
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            graft8.calc(getString(R.string.pt8), "", "season", plot8Area, startY8, yearLaunch);
                        } else {
                            graft8.calc(getString(R.string.pt8), "", "", plot8Area, startY8, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO8().equals("replanting")) {
                        //Replant
                        ft.hide(fragment8);
                        ft.show(replant8);
                        ft.hide(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Oui")) {
                            replant8.calc(getString(R.string.pt8), "", "labor", plot8Area, startY8, yearLaunch);
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Saisonnier")) {
                            replant8.calc(getString(R.string.pt8), "", "season", plot8Area, startY8, yearLaunch);
                        } else {
                            replant8.calc(getString(R.string.pt8), "", "", plot8Area, startY8, yearLaunch);
                        }
                    }else if (sObject.getRECO8().equals("replanting+extra")){
                        ft.hide(fragment8);
                        ft.show(replant8);
                        ft.hide(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui")) {
                            replant8.calc(getString(R.string.pt8),"extra","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier")){
                            replant8.calc(getString(R.string.pt8),"extra","season",plot8Area,startY8,yearLaunch);
                        }else{
                            replant8.calc(getString(R.string.pt8),"extra","",plot8Area,startY8,yearLaunch);
                        }

                    } else if(sObject.getRECO8().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment8);
                        ft.hide(replant8);
                        ft.show(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui")) {
                            graft8.calc(getString(R.string.pt8),"extra","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier")){
                            graft8.calc(getString(R.string.pt8),"extra","season",plot8Area,startY8,yearLaunch);
                        }else{
                            graft8.calc(getString(R.string.pt8),"extra","",plot8Area,startY8,yearLaunch);
                        }
                    }else if (sObject.getRECO8().equals("grafting")) {
                        ft.hide(fragment8);
                        ft.hide(replant8);
                        ft.show(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui")) {
                            graft8.calc(getString(R.string.pt8),"","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier")){
                            graft8.calc(getString(R.string.pt8),"","season",plot8Area,startY8,yearLaunch);
                        }else{
                            graft8.calc(getString(R.string.pt8),"","",plot8Area,startY8,yearLaunch);
                        }

                    }else if (sObject.getRECO8().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment8);
                        ft.hide(replant8);
                        ft.hide(graft8);
                        ft.show(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui")) {
                            extra8.calc(getString(R.string.pt8),"","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier")){
                            extra8.calc(getString(R.string.pt8),"","season",plot8Area,startY8,yearLaunch);
                        }else{
                            extra8.calc(getString(R.string.pt8),"","",plot8Area,startY8,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment8);
                        ft.hide(replant8);
                        ft.hide(graft8);
                        ft.hide(extra8);
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui")) {
                            fragment8.calc(getString(R.string.pt8),"","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier")){
                            fragment8.calc(getString(R.string.pt8),"","season",plot8Area,startY8,yearLaunch);
                        }else{
                            fragment8.calc(getString(R.string.pt8),"","",plot8Area,startY8,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment8);
                ft.hide(replant8);
                ft.hide(graft8);
                ft.hide(extra8);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                if(sObject.getPLOT9RENOVATION().equals("Yes")||sObject.getPLOT9RENOVATION().equals("Oui")){
                    if(sObject.getPLOT9RENOVATIONREASON().equals("Replanting")||sObject.getPLOT9RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment9);
                        ft.show(replant9);
                        ft.hide(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            replant9.calc(getString(R.string.pt9), "", "labor", plot9Area, startY9, yearLaunch);
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            replant9.calc(getString(R.string.pt9), "", "season", plot9Area, startY9, yearLaunch);
                        } else {
                            replant9.calc(getString(R.string.pt9), "", "", plot9Area, startY9, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment9);
                        ft.hide(replant9);
                        ft.show(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            graft9.calc(getString(R.string.pt9), "", "labor", plot9Area, startY9, yearLaunch);
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            graft9.calc(getString(R.string.pt9), "", "season", plot9Area, startY9, yearLaunch);
                        } else {
                            graft9.calc(getString(R.string.pt9), "", "", plot9Area, startY9, yearLaunch);
                        }

                    }
                }else{
                    if (sObject.getRECO9().equals("replanting")) {
                        //Replant
                        ft.hide(fragment9);
                        ft.show(replant9);
                        ft.hide(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Oui")) {
                            replant9.calc(getString(R.string.pt9), "", "labor", plot9Area, startY9, yearLaunch);
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Saisonnier")) {
                            replant9.calc(getString(R.string.pt9), "", "season", plot9Area, startY9, yearLaunch);
                        } else {
                            replant9.calc(getString(R.string.pt9), "", "", plot9Area, startY9, yearLaunch);
                        }
                    }else if (sObject.getRECO9().equals("replanting+extra")){
                        ft.hide(fragment9);
                        ft.show(replant9);
                        ft.hide(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui")) {
                            replant9.calc(getString(R.string.pt9),"extra","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier")){
                            replant9.calc(getString(R.string.pt9),"extra","season",plot9Area,startY9,yearLaunch);
                        }else{
                            replant9.calc(getString(R.string.pt9),"extra","",plot9Area,startY9,yearLaunch);
                        }

                    } else if(sObject.getRECO9().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment9);
                        ft.hide(replant9);
                        ft.show(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui")) {
                            graft9.calc(getString(R.string.pt9),"extra","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier")){
                            graft9.calc(getString(R.string.pt9),"extra","season",plot9Area,startY9,yearLaunch);
                        }else{
                            graft9.calc(getString(R.string.pt9),"extra","",plot9Area,startY9,yearLaunch);
                        }
                    }else if (sObject.getRECO9().equals("grafting")) {
                        ft.hide(fragment9);
                        ft.hide(replant9);
                        ft.show(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui")) {
                            graft9.calc(getString(R.string.pt9),"","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier")){
                            graft9.calc(getString(R.string.pt9),"","season",plot9Area,startY9,yearLaunch);
                        }else{
                            graft9.calc(getString(R.string.pt9),"","",plot9Area,startY9,yearLaunch);
                        }

                    }else if (sObject.getRECO9().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment9);
                        ft.hide(replant9);
                        ft.hide(graft9);
                        ft.show(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui")) {
                            extra9.calc(getString(R.string.pt9),"","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier")){
                            extra9.calc(getString(R.string.pt9),"","season",plot9Area,startY9,yearLaunch);
                        }else{
                            extra9.calc(getString(R.string.pt9),"","",plot9Area,startY9,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment9);
                        ft.hide(replant9);
                        ft.hide(graft9);
                        ft.hide(extra9);
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui")) {
                            fragment9.calc(getString(R.string.pt9),"","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier")){
                            fragment9.calc(getString(R.string.pt9),"","season",plot9Area,startY9,yearLaunch);
                        }else{
                            fragment9.calc(getString(R.string.pt9),"","",plot9Area,startY9,yearLaunch);
                        }

                    }
                }
            }else{
                ft.hide(fragment9);
                ft.hide(replant9);
                ft.hide(graft9);
                ft.hide(extra9);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                if(sObject.getPLOT10RENOVATION().equals("Yes")||sObject.getPLOT10RENOVATION().equals("Oui")){
                    if(sObject.getPLOT10RENOVATIONREASON().equals("Replanting")||sObject.getPLOT10RENOVATIONREASON().equals("Replantation")){
                        ft.hide(fragment10);
                        ft.show(replant10);
                        ft.hide(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            replant10.calc(getString(R.string.pt10), "", "labor", plot10Area, startY10, yearLaunch);
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            replant10.calc(getString(R.string.pt10), "", "season", plot10Area, startY10, yearLaunch);
                        } else {
                            replant10.calc(getString(R.string.pt10), "", "", plot10Area, startY10, yearLaunch);
                        }

                    }else{
                        ft.hide(fragment10);
                        ft.hide(replant10);
                        ft.show(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            graft10.calc(getString(R.string.pt10), "", "labor", plot10Area, startY10, yearLaunch);
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            graft10.calc(getString(R.string.pt10), "", "season", plot10Area, startY10, yearLaunch);
                        } else {
                            graft10.calc(getString(R.string.pt10), "", "", plot10Area, startY10, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getRECO10().equals("replanting")) {
                        //Replant
                        ft.hide(fragment10);
                        ft.show(replant10);
                        ft.hide(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Oui")) {
                            replant10.calc(getString(R.string.pt10), "", "labor", plot10Area, startY10, yearLaunch);
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Saisonnier")) {
                            replant10.calc(getString(R.string.pt10), "", "season", plot10Area, startY10, yearLaunch);
                        } else {
                            replant10.calc(getString(R.string.pt10), "", "", plot10Area, startY10, yearLaunch);
                        }
                    }else if (sObject.getRECO10().equals("replanting+extra")){
                        ft.hide(fragment10);
                        ft.show(replant10);
                        ft.hide(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui")) {
                            replant10.calc(getString(R.string.pt10),"extra","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier")){
                            replant10.calc(getString(R.string.pt10),"extra","season",plot10Area,startY10,yearLaunch);
                        }else{
                            replant10.calc(getString(R.string.pt10),"extra","",plot10Area,startY10,yearLaunch);
                        }

                    } else if(sObject.getRECO10().equals("grafting+extra")) {
                        //Graft
                        ft.hide(fragment10);
                        ft.hide(replant10);
                        ft.show(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui")) {
                            graft10.calc(getString(R.string.pt10),"extra","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier")){
                            graft10.calc(getString(R.string.pt10),"extra","season",plot10Area,startY10,yearLaunch);
                        }else{
                            graft10.calc(getString(R.string.pt10),"extra","",plot10Area,startY10,yearLaunch);
                        }
                    }else if (sObject.getRECO10().equals("grafting")) {
                        ft.hide(fragment10);
                        ft.hide(replant10);
                        ft.show(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui")) {
                            graft10.calc(getString(R.string.pt10),"","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier")){
                            graft10.calc(getString(R.string.pt10),"","season",plot10Area,startY10,yearLaunch);
                        }else{
                            graft10.calc(getString(R.string.pt10),"","",plot10Area,startY10,yearLaunch);
                        }

                    }else if (sObject.getRECO10().equals("extra")) {
                        //Extra Soil Management
                        ft.hide(fragment10);
                        ft.hide(replant10);
                        ft.hide(graft10);
                        ft.show(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui")) {
                            extra10.calc(getString(R.string.pt10),"","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier")){
                            extra10.calc(getString(R.string.pt10),"","season",plot10Area,startY10,yearLaunch);
                        }else{
                            extra10.calc(getString(R.string.pt10),"","",plot10Area,startY10,yearLaunch);
                        }

                    }else{
                        //GAP
                        ft.show(fragment10);
                        ft.hide(replant10);
                        ft.hide(graft10);
                        ft.hide(extra10);
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui")) {
                            fragment10.calc(getString(R.string.pt10),"","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier")){
                            fragment10.calc(getString(R.string.pt10),"","season",plot10Area,startY10,yearLaunch);
                        }else{
                            fragment10.calc(getString(R.string.pt10),"","",plot10Area,startY10,yearLaunch);
                        }
                    }
                }
            }else{
                ft.hide(fragment10);
                ft.hide(replant10);
                ft.hide(graft10);
                ft.hide(extra10);
            }

            ft.commitAllowingStateLoss();
        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}
