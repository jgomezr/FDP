package org.grameenfoundation.fdp.ui;

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

import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.objects.ContactObject;


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
    private TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
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
        fragment2 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot2);
        fragment3 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot3);
        fragment4 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot4);
        fragment5 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot5);
        fragment6 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot6);
        fragment7 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot7);
        fragment8 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot8);
        fragment9 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot9);
        fragment10 = (yearDelayFragment) getFragmentManager().findFragmentById(R.id.fgPlot10);
        p1 = (TextView) fragment1.getView().findViewById(R.id.pt);
        p2 = (TextView) fragment2.getView().findViewById(R.id.pt);
        p3 = (TextView) fragment3.getView().findViewById(R.id.pt);
        p4 = (TextView) fragment4.getView().findViewById(R.id.pt);
        p5 = (TextView) fragment5.getView().findViewById(R.id.pt);
        p6 = (TextView) fragment6.getView().findViewById(R.id.pt);
        p7 = (TextView) fragment7.getView().findViewById(R.id.pt);
        p8 = (TextView) fragment8.getView().findViewById(R.id.pt);
        p9 = (TextView) fragment9.getView().findViewById(R.id.pt);
        p10 = (TextView) fragment10.getView().findViewById(R.id.pt);
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

            double plot1Area = Double.valueOf(sObject.getPlot1Area());
            double plot2Area = Double.valueOf(sObject.getPlot2Area());
            double plot3Area = Double.valueOf(sObject.getPlot3Area());
            double plot4Area = Double.valueOf(sObject.getPlot4Area());
            double plot5Area = Double.valueOf(sObject.getPlot5Area());
            double plot6Area = Double.valueOf(sObject.getPlot6Area());
            double plot7Area = Double.valueOf(sObject.getPlot7Area());
            double plot8Area = Double.valueOf(sObject.getPlot8Area());
            double plot9Area = Double.valueOf(sObject.getPlot9Area());
            double plot10Area = Double.valueOf(sObject.getPlot10Area());
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

            setText((TextView) findViewById(R.id.yearDetail),("YEAR "+yearLaunch));

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //visibility of plots
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                setText(p1,"PLOT 1");
                if(sObject.getPLOT1RENOVATION().equals("Yes")||sObject.getPLOT1RENOVATION().equals("Ya")){
                    if(sObject.getPLOT1RENOVATIONREASON().equals("Replanting")||sObject.getPLOT1RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.calc("replant", "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.calc("replant", "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            fragment1.calc("replant", "", "", plot1Area, startY1, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.calc("graft", "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.calc("graft", "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            fragment1.calc("graft", "", "", plot1Area, startY1, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition1().equals("B") || (Integer.parseInt(sObject.getPlot1Age()) > 25)) {
                        //Replant
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("replant", "extra", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("replant", "extra", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("replant", "extra", "", plot1Area, startY1, yearLaunch);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("replant", "", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("replant", "", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("replant", "", "", plot1Area, startY1, yearLaunch);
                            }
                        }

                    } else if ((sObject.getFarmCondition1().equals("G") && (sObject.getGENETIC1().equals("B")||sObject.getGENETIC1().equals("M"))) || ((Integer.parseInt(sObject.getPlot1Age()) > 20) && (Integer.parseInt(sObject.getPlot1Age()) < 26))) {
                        //Graft
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("graft", "extra", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("graft", "extra", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("graft", "extra", "", plot1Area, startY1, yearLaunch);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("graft", "", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("graft", "", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("graft", "", "", plot1Area, startY1, yearLaunch);
                            }
                        }

                    } else if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.calc("extra", "", "labor", plot1Area, startY1, yearLaunch);
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.calc("extra", "", "season", plot1Area, startY1, yearLaunch);
                        } else {
                            fragment1.calc("extra", "", "", plot1Area, startY1, yearLaunch);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("gap", "extra", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("gap", "extra", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("gap", "extra", "", plot1Area, startY1, yearLaunch);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.calc("gap", "", "labor", plot1Area, startY1, yearLaunch);
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.calc("gap", "", "season", plot1Area, startY1, yearLaunch);
                            } else {
                                fragment1.calc("gap", "", "", plot1Area, startY1, yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment1);
            }else{ft.hide(fragment1);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                setText(p2,"PLOT 2");

                if(sObject.getPLOT2RENOVATION().equals("Yes")||sObject.getPLOT2RENOVATION().equals("Ya")){
                    if(sObject.getPLOT2RENOVATIONREASON().equals("Replanting")||sObject.getPLOT2RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                            fragment2.calc("replant", "", "labor", plot2Area, startY2, yearLaunch);
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                            fragment2.calc("replant", "", "season", plot2Area, startY2, yearLaunch);
                        } else {
                            fragment2.calc("replant", "", "", plot2Area, startY2, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                            fragment2.calc("graft", "", "labor", plot2Area, startY2, yearLaunch);
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                            fragment2.calc("graft", "", "season", plot2Area, startY2, yearLaunch);
                        } else {
                            fragment2.calc("graft", "", "", plot2Area, startY2, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition2().equals("B")||(Integer.parseInt(sObject.getPlot2Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")){
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("replant","extra","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("replant","extra","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("replant","extra","",plot2Area,startY2,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("replant","","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("replant","","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("replant","","",plot2Area,startY2,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition2().equals("G") && (sObject.getGENETIC2().equals("B")||sObject.getGENETIC2().equals("M"))) || ((Integer.parseInt(sObject.getPlot2Age()) > 20) && (Integer.parseInt(sObject.getPlot2Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")){
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("graft","extra","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("graft","extra","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("graft","extra","",plot2Area,startY2,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("graft","","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("graft","","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("graft","","",plot2Area,startY2,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                            fragment2.calc("extra","","labor",plot2Area,startY2,yearLaunch);
                        }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                            fragment2.calc("extra","","season",plot2Area,startY2,yearLaunch);
                        }else{
                            fragment2.calc("extra","","",plot2Area,startY2,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")){
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("gap","extra","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("gap","extra","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("gap","extra","",plot2Area,startY2,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Ya")) {
                                fragment2.calc("gap","","labor",plot2Area,startY2,yearLaunch);
                            }else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Musiman")){
                                fragment2.calc("gap","","season",plot2Area,startY2,yearLaunch);
                            }else{
                                fragment2.calc("gap","","",plot2Area,startY2,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment2);
            }else{ft.hide(fragment2);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                setText(p3,"PLOT 3");
                if(sObject.getPLOT3RENOVATION().equals("Yes")||sObject.getPLOT3RENOVATION().equals("Ya")){
                    if(sObject.getPLOT3RENOVATIONREASON().equals("Replanting")||sObject.getPLOT3RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                            fragment3.calc("replant", "", "labor", plot3Area, startY3, yearLaunch);
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                            fragment3.calc("replant", "", "season", plot3Area, startY3, yearLaunch);
                        } else {
                            fragment3.calc("replant", "", "", plot3Area, startY3, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                            fragment3.calc("graft", "", "labor", plot3Area, startY3, yearLaunch);
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                            fragment3.calc("graft", "", "season", plot3Area, startY3, yearLaunch);
                        } else {
                            fragment3.calc("graft", "", "", plot3Area, startY3, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition3().equals("B")||(Integer.parseInt(sObject.getPlot3Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")){
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("replant","extra","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("replant","extra","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("replant","extra","",plot3Area,startY3,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("replant","","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("replant","","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("replant","","",plot3Area,startY3,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition3().equals("G") && (sObject.getGENETIC3().equals("B")||sObject.getGENETIC3().equals("M"))) || ((Integer.parseInt(sObject.getPlot3Age()) > 20) && (Integer.parseInt(sObject.getPlot3Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")){
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("graft","extra","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("graft","extra","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("graft","extra","",plot3Area,startY3,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("graft","","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("graft","","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("graft","","",plot3Area,startY3,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                            fragment3.calc("extra","","labor",plot3Area,startY3,yearLaunch);
                        }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                            fragment3.calc("extra","","season",plot3Area,startY3,yearLaunch);
                        }else{
                            fragment3.calc("extra","","",plot3Area,startY3,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")){
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("gap","extra","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("gap","extra","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("gap","extra","",plot3Area,startY3,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Ya")) {
                                fragment3.calc("gap","","labor",plot3Area,startY3,yearLaunch);
                            }else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Musiman")){
                                fragment3.calc("gap","","season",plot3Area,startY3,yearLaunch);
                            }else{
                                fragment3.calc("gap","","",plot3Area,startY3,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment3);
            }else{ft.hide(fragment3);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                setText(p4,"PLOT 4");
                if(sObject.getPLOT4RENOVATION().equals("Yes")||sObject.getPLOT4RENOVATION().equals("Ya")){
                    if(sObject.getPLOT4RENOVATIONREASON().equals("Replanting")||sObject.getPLOT4RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                            fragment4.calc("replant", "", "labor", plot4Area, startY4, yearLaunch);
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                            fragment4.calc("replant", "", "season", plot4Area, startY4, yearLaunch);
                        } else {
                            fragment4.calc("replant", "", "", plot4Area, startY4, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                            fragment4.calc("graft", "", "labor", plot4Area, startY4, yearLaunch);
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                            fragment4.calc("graft", "", "season", plot4Area, startY4, yearLaunch);
                        } else {
                            fragment4.calc("graft", "", "", plot4Area, startY4, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition4().equals("B")||(Integer.parseInt(sObject.getPlot4Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")){
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("replant","extra","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("replant","extra","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("replant","extra","",plot4Area,startY4,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("replant","","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("replant","","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("replant","","",plot4Area,startY4,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition4().equals("G") && (sObject.getGENETIC4().equals("B")||sObject.getGENETIC4().equals("M"))) || ((Integer.parseInt(sObject.getPlot4Age()) > 20) && (Integer.parseInt(sObject.getPlot4Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")){
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("graft","extra","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("graft","extra","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("graft","extra","",plot4Area,startY4,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("graft","","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("graft","","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("graft","","",plot4Area,startY4,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                            fragment4.calc("extra","","labor",plot4Area,startY4,yearLaunch);
                        }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                            fragment4.calc("extra","","season",plot4Area,startY4,yearLaunch);
                        }else{
                            fragment4.calc("extra","","",plot4Area,startY4,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")){
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("gap","extra","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("gap","extra","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("gap","extra","",plot4Area,startY4,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Ya")) {
                                fragment4.calc("gap","","labor",plot4Area,startY4,yearLaunch);
                            }else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Musiman")){
                                fragment4.calc("gap","","season",plot4Area,startY4,yearLaunch);
                            }else{
                                fragment4.calc("gap","","",plot4Area,startY4,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment4);
            }else{ft.hide(fragment4);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                setText(p5,"PLOT 5");
                if(sObject.getPLOT5RENOVATION().equals("Yes")||sObject.getPLOT5RENOVATION().equals("Ya")){
                    if(sObject.getPLOT5RENOVATIONREASON().equals("Replanting")||sObject.getPLOT5RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                            fragment5.calc("replant", "", "labor", plot5Area, startY5, yearLaunch);
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                            fragment5.calc("replant", "", "season", plot5Area, startY5, yearLaunch);
                        } else {
                            fragment5.calc("replant", "", "", plot5Area, startY5, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                            fragment5.calc("graft", "", "labor", plot5Area, startY5, yearLaunch);
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                            fragment5.calc("graft", "", "season", plot5Area, startY5, yearLaunch);
                        } else {
                            fragment5.calc("graft", "", "", plot5Area, startY5, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition5().equals("B")||(Integer.parseInt(sObject.getPlot5Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")){
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("replant","extra","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("replant","extra","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("replant","extra","",plot5Area,startY5,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("replant","","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("replant","","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("replant","","",plot5Area,startY5,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition5().equals("G") && (sObject.getGENETIC5().equals("B")||sObject.getGENETIC5().equals("M"))) || ((Integer.parseInt(sObject.getPlot5Age()) > 20) && (Integer.parseInt(sObject.getPlot5Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")){
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("graft","extra","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("graft","extra","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("graft","extra","",plot5Area,startY5,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("graft","","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("graft","","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("graft","","",plot5Area,startY5,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                            fragment5.calc("extra","","labor",plot5Area,startY5,yearLaunch);
                        }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                            fragment5.calc("extra","","season",plot5Area,startY5,yearLaunch);
                        }else{
                            fragment5.calc("extra","","",plot5Area,startY5,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")){
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("gap","extra","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("gap","extra","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("gap","extra","",plot5Area,startY5,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Ya")) {
                                fragment5.calc("gap","","labor",plot5Area,startY5,yearLaunch);
                            }else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Musiman")){
                                fragment5.calc("gap","","season",plot5Area,startY5,yearLaunch);
                            }else{
                                fragment5.calc("gap","","",plot5Area,startY5,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment5);
            }else{ft.hide(fragment5);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                setText(p6,"PLOT 6");
                if(sObject.getPLOT6RENOVATION().equals("Yes")||sObject.getPLOT6RENOVATION().equals("Ya")){
                    if(sObject.getPLOT6RENOVATIONREASON().equals("Replanting")||sObject.getPLOT6RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                            fragment6.calc("replant", "", "labor", plot6Area, startY6, yearLaunch);
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                            fragment6.calc("replant", "", "season", plot6Area, startY6, yearLaunch);
                        } else {
                            fragment6.calc("replant", "", "", plot6Area, startY6, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                            fragment6.calc("graft", "", "labor", plot6Area, startY6, yearLaunch);
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                            fragment6.calc("graft", "", "season", plot6Area, startY6, yearLaunch);
                        } else {
                            fragment6.calc("graft", "", "", plot6Area, startY6, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition6().equals("B")||(Integer.parseInt(sObject.getPlot6Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")){
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("replant","extra","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("replant","extra","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("replant","extra","",plot6Area,startY6,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("replant","","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("replant","","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("replant","","",plot6Area,startY6,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition6().equals("G") && (sObject.getGENETIC6().equals("B")||sObject.getGENETIC6().equals("M"))) || ((Integer.parseInt(sObject.getPlot6Age()) > 20) && (Integer.parseInt(sObject.getPlot6Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")){
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("graft","extra","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("graft","extra","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("graft","extra","",plot6Area,startY6,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("graft","","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("graft","","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("graft","","",plot6Area,startY6,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                            fragment6.calc("extra","","labor",plot6Area,startY6,yearLaunch);
                        }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                            fragment6.calc("extra","","season",plot6Area,startY6,yearLaunch);
                        }else{
                            fragment6.calc("extra","","",plot6Area,startY6,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")){
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("gap","extra","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("gap","extra","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("gap","extra","",plot6Area,startY6,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Ya")) {
                                fragment6.calc("gap","","labor",plot6Area,startY6,yearLaunch);
                            }else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Musiman")){
                                fragment6.calc("gap","","season",plot6Area,startY6,yearLaunch);
                            }else{
                                fragment6.calc("gap","","",plot6Area,startY6,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment6);
            }else{ft.hide(fragment6);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                setText(p7,"PLOT 7");
                if(sObject.getPLOT7RENOVATION().equals("Yes")||sObject.getPLOT7RENOVATION().equals("Ya")){
                    if(sObject.getPLOT7RENOVATIONREASON().equals("Replanting")||sObject.getPLOT7RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                            fragment7.calc("replant", "", "labor", plot7Area, startY7, yearLaunch);
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                            fragment7.calc("replant", "", "season", plot7Area, startY7, yearLaunch);
                        } else {
                            fragment7.calc("replant", "", "", plot7Area, startY7, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                            fragment7.calc("graft", "", "labor", plot7Area, startY7, yearLaunch);
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                            fragment7.calc("graft", "", "season", plot7Area, startY7, yearLaunch);
                        } else {
                            fragment7.calc("graft", "", "", plot7Area, startY7, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition7().equals("B")||(Integer.parseInt(sObject.getPlot7Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")){
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("replant","extra","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("replant","extra","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("replant","extra","",plot7Area,startY7,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("replant","","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("replant","","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("replant","","",plot7Area,startY7,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition7().equals("G") && (sObject.getGENETIC7().equals("B")||sObject.getGENETIC7().equals("M"))) || ((Integer.parseInt(sObject.getPlot7Age()) > 20) && (Integer.parseInt(sObject.getPlot7Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")){
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("graft","extra","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("graft","extra","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("graft","extra","",plot7Area,startY7,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("graft","","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("graft","","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("graft","","",plot7Area,startY7,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                            fragment7.calc("extra","","labor",plot7Area,startY7,yearLaunch);
                        }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                            fragment7.calc("extra","","season",plot7Area,startY7,yearLaunch);
                        }else{
                            fragment7.calc("extra","","",plot7Area,startY7,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")){
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("gap","extra","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("gap","extra","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("gap","extra","",plot7Area,startY7,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Ya")) {
                                fragment7.calc("gap","","labor",plot7Area,startY7,yearLaunch);
                            }else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Musiman")){
                                fragment7.calc("gap","","season",plot7Area,startY7,yearLaunch);
                            }else{
                                fragment7.calc("gap","","",plot7Area,startY7,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment7);
            }else{ft.hide(fragment7);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                setText(p8,"PLOT 8");
                if(sObject.getPLOT8RENOVATION().equals("Yes")||sObject.getPLOT8RENOVATION().equals("Ya")){
                    if(sObject.getPLOT8RENOVATIONREASON().equals("Replanting")||sObject.getPLOT8RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                            fragment8.calc("replant", "", "labor", plot8Area, startY8, yearLaunch);
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                            fragment8.calc("replant", "", "season", plot8Area, startY8, yearLaunch);
                        } else {
                            fragment8.calc("replant", "", "", plot8Area, startY8, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                            fragment8.calc("graft", "", "labor", plot8Area, startY8, yearLaunch);
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                            fragment8.calc("graft", "", "season", plot8Area, startY8, yearLaunch);
                        } else {
                            fragment8.calc("graft", "", "", plot8Area, startY8, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition8().equals("B")||(Integer.parseInt(sObject.getPlot8Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")){
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("replant","extra","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("replant","extra","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("replant","extra","",plot8Area,startY8,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("replant","","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("replant","","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("replant","","",plot8Area,startY8,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition8().equals("G") && (sObject.getGENETIC8().equals("B")||sObject.getGENETIC8().equals("M"))) || ((Integer.parseInt(sObject.getPlot8Age()) > 20) && (Integer.parseInt(sObject.getPlot8Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")){
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("graft","extra","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("graft","extra","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("graft","extra","",plot8Area,startY8,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("graft","","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("graft","","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("graft","","",plot8Area,startY8,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                            fragment8.calc("extra","","labor",plot8Area,startY8,yearLaunch);
                        }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                            fragment8.calc("extra","","season",plot8Area,startY8,yearLaunch);
                        }else{
                            fragment8.calc("extra","","",plot8Area,startY8,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")){
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("gap","extra","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("gap","extra","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("gap","extra","",plot8Area,startY8,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Ya")) {
                                fragment8.calc("gap","","labor",plot8Area,startY8,yearLaunch);
                            }else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Musiman")){
                                fragment8.calc("gap","","season",plot8Area,startY8,yearLaunch);
                            }else{
                                fragment8.calc("gap","","",plot8Area,startY8,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment8);
            }else{ft.hide(fragment8);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                setText(p9,"PLOT 9");
                if(sObject.getPLOT9RENOVATION().equals("Yes")||sObject.getPLOT9RENOVATION().equals("Ya")){
                    if(sObject.getPLOT9RENOVATIONREASON().equals("Replanting")||sObject.getPLOT9RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                            fragment9.calc("replant", "", "labor", plot9Area, startY9, yearLaunch);
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                            fragment9.calc("replant", "", "season", plot9Area, startY9, yearLaunch);
                        } else {
                            fragment9.calc("replant", "", "", plot9Area, startY9, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                            fragment9.calc("graft", "", "labor", plot9Area, startY9, yearLaunch);
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                            fragment9.calc("graft", "", "season", plot9Area, startY9, yearLaunch);
                        } else {
                            fragment9.calc("graft", "", "", plot9Area, startY9, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition9().equals("B")||(Integer.parseInt(sObject.getPlot9Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")){
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("replant","extra","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("replant","extra","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("replant","extra","",plot9Area,startY9,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("replant","","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("replant","","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("replant","","",plot9Area,startY9,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition9().equals("G") && (sObject.getGENETIC9().equals("B")||sObject.getGENETIC9().equals("M"))) || ((Integer.parseInt(sObject.getPlot9Age()) > 20) && (Integer.parseInt(sObject.getPlot9Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")){
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("graft","extra","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("graft","extra","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("graft","extra","",plot9Area,startY9,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("graft","","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("graft","","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("graft","","",plot9Area,startY9,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                            fragment9.calc("extra","","labor",plot9Area,startY9,yearLaunch);
                        }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                            fragment9.calc("extra","","season",plot9Area,startY9,yearLaunch);
                        }else{
                            fragment9.calc("extra","","",plot9Area,startY9,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")){
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("gap","extra","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("gap","extra","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("gap","extra","",plot9Area,startY9,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Ya")) {
                                fragment9.calc("gap","","labor",plot9Area,startY9,yearLaunch);
                            }else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Musiman")){
                                fragment9.calc("gap","","season",plot9Area,startY9,yearLaunch);
                            }else{
                                fragment9.calc("gap","","",plot9Area,startY9,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment9);
            }else{ft.hide(fragment9);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                setText(p10,"PLOT 10");
                if(sObject.getPLOT10RENOVATION().equals("Yes")||sObject.getPLOT10RENOVATION().equals("Ya")){
                    if(sObject.getPLOT10RENOVATIONREASON().equals("Replanting")||sObject.getPLOT10RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                            fragment10.calc("replant", "", "labor", plot10Area, startY10, yearLaunch);
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                            fragment10.calc("replant", "", "season", plot10Area, startY10, yearLaunch);
                        } else {
                            fragment10.calc("replant", "", "", plot10Area, startY10, yearLaunch);
                        }
                    }else{
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                            fragment10.calc("graft", "", "labor", plot10Area, startY10, yearLaunch);
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                            fragment10.calc("graft", "", "season", plot10Area, startY10, yearLaunch);
                        } else {
                            fragment10.calc("graft", "", "", plot10Area, startY10, yearLaunch);
                        }
                    }
                }else{
                    if (sObject.getFarmCondition10().equals("B")||(Integer.parseInt(sObject.getPlot10Age())>25)){
                        //Replant
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")){
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("replant","extra","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("replant","extra","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("replant","extra","",plot10Area,startY10,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("replant","","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("replant","","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("replant","","",plot10Area,startY10,yearLaunch);
                            }
                        }

                    } else if((sObject.getFarmCondition10().equals("G") && (sObject.getGENETIC10().equals("B")||sObject.getGENETIC10().equals("M"))) || ((Integer.parseInt(sObject.getPlot10Age()) > 20) && (Integer.parseInt(sObject.getPlot10Age()) < 26))){
                        //Graft
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")){
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("graft","extra","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("graft","extra","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("graft","extra","",plot10Area,startY10,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("graft","","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("graft","","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("graft","","",plot10Area,startY10,yearLaunch);
                            }
                        }

                    }else if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")){
                        //Extra Soil Management
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                            fragment10.calc("extra","","labor",plot10Area,startY10,yearLaunch);
                        }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                            fragment10.calc("extra","","season",plot10Area,startY10,yearLaunch);
                        }else{
                            fragment10.calc("extra","","",plot10Area,startY10,yearLaunch);
                        }

                    }else{
                        //GAP
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")){
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("gap","extra","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("gap","extra","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("gap","extra","",plot10Area,startY10,yearLaunch);
                            }
                        }else{
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Ya")) {
                                fragment10.calc("gap","","labor",plot10Area,startY10,yearLaunch);
                            }else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Musiman")){
                                fragment10.calc("gap","","season",plot10Area,startY10,yearLaunch);
                            }else{
                                fragment10.calc("gap","","",plot10Area,startY10,yearLaunch);
                            }
                        }
                    }
                }
                ft.show(fragment10);
            }else{ft.hide(fragment10);}

            ft.commitAllowingStateLoss();

        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}
