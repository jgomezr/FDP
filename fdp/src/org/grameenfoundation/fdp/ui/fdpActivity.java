package org.grameenfoundation.fdp.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
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
    private Spinner st1,st2,st3,st4,st5,st6,st7,st8,st9,st10;
    private TextView found1,found2,found3,found4,found5,found6,found7,pyl1,pyl2,pyl3,pyl4,pyl5,pyl6,pyl7,plot1,plot2,plot3,plot4,plot5,plot6,plot7,plot8,plot9,plot10;
    public fdpFragment fragment1,fragment2,fragment3,fragment4,fragment5,fragment6,fragment7,fragment8,fragment9,fragment10;

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

        fragment1 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot1);
        fragment2 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot2);
        fragment3 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot3);
        fragment4 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot4);
        fragment5 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot5);
        fragment6 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot6);
        fragment7 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot7);
        fragment8 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot8);
        fragment9 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot9);
        fragment10 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot10);
        plot1 = (TextView) fragment1.getView().findViewById(R.id.plot);
        plot2 = (TextView) fragment2.getView().findViewById(R.id.plot);
        plot3 = (TextView) fragment3.getView().findViewById(R.id.plot);
        plot4 = (TextView) fragment4.getView().findViewById(R.id.plot);
        plot5 = (TextView) fragment5.getView().findViewById(R.id.plot);
        plot6 = (TextView) fragment6.getView().findViewById(R.id.plot);
        plot7 = (TextView) fragment7.getView().findViewById(R.id.plot);
        plot8 = (TextView) fragment8.getView().findViewById(R.id.plot);
        plot9 = (TextView) fragment9.getView().findViewById(R.id.plot);
        plot10 = (TextView) fragment10.getView().findViewById(R.id.plot);
        st1 = (Spinner)fragment1.getView().findViewById(R.id.startP_field);
        st2 = (Spinner)fragment2.getView().findViewById(R.id.startP_field);
        st3 = (Spinner)fragment3.getView().findViewById(R.id.startP_field);
        st4 = (Spinner)fragment4.getView().findViewById(R.id.startP_field);
        st5 = (Spinner)fragment5.getView().findViewById(R.id.startP_field);
        st6 = (Spinner)fragment6.getView().findViewById(R.id.startP_field);
        st7 = (Spinner)fragment7.getView().findViewById(R.id.startP_field);
        st8 = (Spinner)fragment8.getView().findViewById(R.id.startP_field);
        st9 = (Spinner)fragment9.getView().findViewById(R.id.startP_field);
        st10 = (Spinner)fragment10.getView().findViewById(R.id.startP_field);

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

            //Set start year 1
            if (sObject.getStartYearP1().contentEquals("Year 1")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 2")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 3")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 4")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 5")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 6")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 7")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 2
            if (sObject.getStartYearP2().contentEquals("Year 1")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 2")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 3")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 4")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 5")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 6")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 7")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 3
            if (sObject.getStartYearP3().contentEquals("Year 1")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 2")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 3")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 4")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 5")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 6")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 7")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 4
            if (sObject.getStartYearP4().contentEquals("Year 1")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 2")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 3")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 4")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 5")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 6")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 7")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 5
            if (sObject.getStartYearP5().contentEquals("Year 1")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 2")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 3")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 4")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 5")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 6")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 7")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 6
            if (sObject.getStartYearP6().contentEquals("Year 1")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 2")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 3")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 4")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 5")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 6")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 7")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 7
            if (sObject.getStartYearP7().contentEquals("Year 1")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 2")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 3")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 4")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 5")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 6")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 7")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 8
            if (sObject.getStartYearP8().contentEquals("Year 1")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 2")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 3")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 4")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 5")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 6")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 7")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 9
            if (sObject.getStartYearP9().contentEquals("Year 1")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 2")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 3")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 4")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 5")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 6")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 7")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 100
            if (sObject.getStartYearP10().contentEquals("Year 1")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 2")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 3")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 4")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 5")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 6")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 7")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

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
            double avgCost = Double.parseDouble(sObject.getAveragecocoaprice());
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

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //plot1
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                setText(plot1,"PLOT 1");
                fragment1.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                //main intervention
                if (sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age())>25)){
                    //Replant
                    if (sObject.getSOILMNG1().equals("B")){
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("replant","extra","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("replant","extra","",plot1Area,avgCost);
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("replant","","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("replant","","",plot1Area,avgCost);
                        }
                    }

                } else if((sObject.getFarmCondition1().equals("G")&&sObject.getGENETIC1().equals("B"))||(sObject.getFarmCondition1().equals("B")&&(Integer.parseInt(sObject.getPlot1Age())<25))){
                    //Graft
                    if (sObject.getSOILMNG1().equals("B")){
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("graft","extra","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("graft","extra","",plot1Area,avgCost);
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("graft","","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("graft","","",plot1Area,avgCost);
                        }
                    }

                }else if (sObject.getSOILMNG1().equals("B")){
                    //Extra Soil Management
                    if (sObject.getHireLabor1().equals("Yes")) {
                        fragment1.mainint("extra","","labor",plot1Area,avgCost);
                    }else{
                        fragment1.mainint("graft","","",plot1Area,avgCost);
                    }

                }else{
                    //GAP
                    if (sObject.getSOILMNG1().equals("B")){
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("gap","extra","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("gap","extra","",plot1Area,avgCost);
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")) {
                            fragment1.mainint("gap","","labor",plot1Area,avgCost);
                        }else{
                            fragment1.mainint("gap","","",plot1Area,avgCost);
                        }
                    }
                }

                //other interventions
                if (sObject.getHireLabor1().equals("Yes")) {
                    fragment1.other("labor");
                }

                if (sObject.getLimeNeed1().equals("Yes")) {
                    fragment1.other("lime");
                }

                if (sObject.getFillingOption1().equals("Yes")) {
                    fragment1.other("filling");
                }

                if (sObject.getDrainageNeed1().equals("Yes")) {
                    fragment1.other("drainage");
                }

                ft.show(fragment1);
            }else{ft.hide(fragment1);}
            //plot2

            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                setText(plot2,"PLOT 2");
                ft.show(fragment2);
            }else{ft.hide(fragment2);}

            //plot3
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                setText(plot3,"PLOT 3");
                fragment3.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                ft.show(fragment3);
            }else{ft.hide(fragment3);}

            //plot4
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                setText(plot4,"PLOT 4");
                ft.show(fragment4);
            }else{ft.hide(fragment4);}

            //plot5
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                setText(plot5,"PLOT 5");
                fragment5.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                ft.show(fragment5);
            }else{ft.hide(fragment5);}

            //plot6
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                setText(plot6,"PLOT 6");
                ft.show(fragment6);
            }else{ft.hide(fragment6);}

            //plot7
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                setText(plot7,"PLOT 7");
                fragment7.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                ft.show(fragment7);
            }else{ft.hide(fragment7);}

            //plot8
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                setText(plot8,"PLOT 8");
                ft.show(fragment8);
            }else{ft.hide(fragment8);}

            //plot9
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                setText(plot9,"PLOT 9");
                fragment9.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                ft.show(fragment9);
            }else{ft.hide(fragment9);}

            //plot10
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                setText(plot10,"PLOT 10");
                ft.show(fragment10);
            }else{ft.hide(fragment10);}
            ft.commitAllowingStateLoss();

            //net income cocoa
            int totalIncomeY1 = income11+income21+income31+income41+income51;
            int totalIncomeY2 = income12+income22+income32+income42+income52;
            int totalIncomeY3 = income13+income23+income33+income43+income53;
            int totalIncomeY4 = income14+income24+income34+income44+income54;
            int totalIncomeY5 = income15+income25+income35+income45+income55;
            int totalIncomeY6 = income16+income26+income36+income46+income56;
            int totalIncomeY7 = income17+income27+income37+income47+income57;
            setText((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(dec.format(totalIncomeY1)));
            setText((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(dec.format(totalIncomeY2)));
            setText((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(dec.format(totalIncomeY3)));
            setText((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(dec.format(totalIncomeY4)));
            setText((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(dec.format(totalIncomeY5)));
            setText((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(dec.format(totalIncomeY6)));
            setText((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(dec.format(totalIncomeY7)));

            //net income other crops
            double otherCrops = Double.parseDouble(sObject.getIncomeothercrops().toString());
            setText((TextView) findViewById(R.id.otherCropY1_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY2_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY3_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY4_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY5_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY6_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY7_field), String.valueOf(dec.format(otherCrops)));

            //net income farming
            int farmingy1 = (int) (totalIncomeY1+otherCrops);
            int farmingy2 = (int) (totalIncomeY2+otherCrops);
            int farmingy3 = (int) (totalIncomeY3+otherCrops);
            int farmingy4 = (int) (totalIncomeY4+otherCrops);
            int farmingy5 = (int) (totalIncomeY5+otherCrops);
            int farmingy6 = (int) (totalIncomeY6+otherCrops);
            int farmingy7 = (int) (totalIncomeY7+otherCrops);
            setText((TextView) findViewById(R.id.netFarmingY1_field), String.valueOf(dec.format(farmingy1)));
            setText((TextView) findViewById(R.id.netFarmingY2_field), String.valueOf(dec.format(farmingy2)));
            setText((TextView) findViewById(R.id.netFarmingY3_field), String.valueOf(dec.format(farmingy3)));
            setText((TextView) findViewById(R.id.netFarmingY4_field), String.valueOf(dec.format(farmingy4)));
            setText((TextView) findViewById(R.id.netFarmingY5_field), String.valueOf(dec.format(farmingy5)));
            setText((TextView) findViewById(R.id.netFarmingY6_field), String.valueOf(dec.format(farmingy6)));
            setText((TextView) findViewById(R.id.netFarmingY7_field), String.valueOf(dec.format(farmingy7)));

            //net other income sources
            double moneyBack = Double.parseDouble(sObject.getLoanmoneygetback().toString());
            double hhSavings = Double.parseDouble(sObject.getHouseholdsavings().toString());
            double farmWork = Double.parseDouble(sObject.getIncomefarmlabor().toString());
            double spouseWork = Double.parseDouble(sObject.getSpouseincome().toString());
            double familyWork = Double.parseDouble(sObject.getFamilymembersincome().toString());
            int totalOtherIncome = (int) (moneyBack + hhSavings+farmWork+spouseWork+familyWork);
            setText((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(dec.format(totalOtherIncome)));

            //total income
            int totalIncomeAllY1 = farmingy1 + totalOtherIncome;
            int totalIncomeAllY2 = farmingy2 + totalOtherIncome;
            int totalIncomeAllY3 = farmingy3 + totalOtherIncome;
            int totalIncomeAllY4 = farmingy4 + totalOtherIncome;
            int totalIncomeAllY5 = farmingy5 + totalOtherIncome;
            int totalIncomeAllY6 = farmingy6 + totalOtherIncome;
            int totalIncomeAllY7 = farmingy7 + totalOtherIncome;
            setText((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(dec.format(totalIncomeAllY1)));
            setText((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(dec.format(totalIncomeAllY2)));
            setText((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(dec.format(totalIncomeAllY3)));
            setText((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(dec.format(totalIncomeAllY4)));
            setText((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(dec.format(totalIncomeAllY5)));
            setText((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(dec.format(totalIncomeAllY6)));
            setText((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(dec.format(totalIncomeAllY7)));

            //total family costs
            double anLivExpen = Double.parseDouble(sObject.getAnnuallivingexpenses().toString());
            double anOtherExp = Double.parseDouble(sObject.getAnnualotherexpenses().toString());
            double expEducExp = Double.parseDouble(sObject.getExpectededucationexpenses().toString());
            double credPay = Double.parseDouble(sObject.getHowmuchpayforcredit().toString());
            int totalExpenses = (int) (anLivExpen+anOtherExp+expEducExp+credPay);
            setText((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(dec.format(totalExpenses)));

            // net family income
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
            setText((TextView) findViewById(R.id.netFamilyY1_field), String.valueOf(dec.format(availableY1)));
            if(availableY1 > 0){
                found1.setTextColor(Color.parseColor("#29a329"));
            }else{
                found1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY2_field), String.valueOf(dec.format(availableY2)));
            if(availableY2 > 0){
                found2.setTextColor(Color.parseColor("#29a329"));
            }else{
                found2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY3_field), String.valueOf(dec.format(availableY3)));
            if(availableY3 > 0){
                found3.setTextColor(Color.parseColor("#29a329"));
            }else{
                found3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY4_field), String.valueOf(dec.format(availableY4)));
            if(availableY4 > 0){
                found4.setTextColor(Color.parseColor("#29a329"));
            }else{
                found4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY5_field), String.valueOf(dec.format(availableY5)));
            if(availableY5 > 0){
                found5.setTextColor(Color.parseColor("#29a329"));
            }else{
                found5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY6_field), String.valueOf(dec.format(availableY6)));
            if(availableY6 > 0){
                found6.setTextColor(Color.parseColor("#29a329"));
            }else{
                found6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY7_field), String.valueOf(dec.format(availableY7)));
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
            setText((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(dec.format(totalY1)));
            setText((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(dec.format(totalY2)));
            setText((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(dec.format(totalY3)));
            setText((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(dec.format(totalY4)));
            setText((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(dec.format(totalY5)));
            setText((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(dec.format(totalY6)));
            setText((TextView) findViewById(R.id.foundsNeededY7_field), String.valueOf(dec.format(totalY7)));

            //profit or lost
            int pl1 = availableY1-totalY1;
            int pl2 = availableY2-totalY2;
            int pl3 = availableY3-totalY3;
            int pl4 = availableY4-totalY4;
            int pl5 = availableY5-totalY5;
            int pl6 = availableY6-totalY6;
            int pl7 = availableY7-totalY7;
            setText((TextView) findViewById(R.id.profitOrLostY1_field), String.valueOf(dec.format(pl1)));
            if(pl1 > 0){
                pyl1.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY2_field), String.valueOf(dec.format(pl2)));
            if(pl2 > 0){
                pyl2.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY3_field), String.valueOf(dec.format(pl3)));
            if(pl3 > 0){
                pyl3.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY4_field), String.valueOf(dec.format(pl4)));
            if(pl4 > 0){
                pyl4.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY5_field), String.valueOf(dec.format(pl5)));
            if(pl5 > 0){
                pyl5.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY6_field), String.valueOf(dec.format(pl6)));
            if(pl6 > 0){
                pyl6.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY7_field), String.valueOf(dec.format(pl7)));
            if(pl7 > 0){
                pyl7.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl7.setTextColor(Color.parseColor("#cc0000"));
            }
        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
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
