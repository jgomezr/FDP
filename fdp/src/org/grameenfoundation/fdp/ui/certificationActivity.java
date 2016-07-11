package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian_Gf on 7/8/2016.
 */
public class certificationActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: certificationActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certification);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(farmActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(farmActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(farmActivity.OBJECT_NAME_KEY);
        }
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void launchPlot (View view) {
        save();
        final Intent plotIntent = new Intent(this, plotActivity.class);
        plotIntent.addCategory(Intent.CATEGORY_DEFAULT);
        plotIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        plotIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        plotIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivity(plotIntent);
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
        //Set field
        if (sObject.getRA1().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA1_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA1().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA1_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA1_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
        //Set field
        if (sObject.getRA2().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA2_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA2().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA2_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA2_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA3().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA3().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA4().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA4().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA5().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA5().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA6().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA6_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA6().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA6_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA6_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA7().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA7_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA7().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA7_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA7_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA8().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA8_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA8().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA8_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA8_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA9().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA9_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA9().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA9_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA9_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA10().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA10_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA10().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA10_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA10_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA11().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA11_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA11().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA11_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA11_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getRA12().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA12_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getRA12().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.RA12_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.RA12_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGA15().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GA15_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGA15().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GA15_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GA15_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB48().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB48_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB48().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB48_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB48_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB49().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB49_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB49().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB49_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB49_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB51().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB51_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB51().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB51_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB51_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB52().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB52_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB52().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB52_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB52_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB54().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB54_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB54().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB54_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB54_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB55().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB55_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB55().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB55_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB55_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB56().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB56_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB56().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB56_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB56_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB58().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB58_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB58().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB58_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB58_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB59().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB59_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB59().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB59_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB59_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB60().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB60_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB60().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB60_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB60_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB61().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB61_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB61().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB61_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB61_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB64().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB64_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB64().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB64_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB64_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB65().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB65_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB65().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB65_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB65_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB66().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB66_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB66().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB66_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB66_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getG68().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB68_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getG68().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB68_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB68_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGB72().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB72_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGB72().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GB72_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GB72_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getGC95().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.GC95_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getGC95().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.GC95_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.GC95_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getCOB3().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getCOB3().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.COB3_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getCOB4().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getCOB4().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.COB4_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

        //Set field
        if (sObject.getCOB5().contentEquals("Yes")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else if (sObject.getCOB5().contentEquals("No")) {
            Spinner spinner = (Spinner) findViewById(R.id.COB5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.No, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Spinner spinner = (Spinner) findViewById(R.id.COB5_field);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.yesNo, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

    }

    private void setText(EditText textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String ra1 = ((Spinner) findViewById(R.id.RA1_field)).getSelectedItem().toString();
        final String ra2 = ((Spinner) findViewById(R.id.RA2_field)).getSelectedItem().toString();
        final String ra3 = ((Spinner) findViewById(R.id.RA3_field)).getSelectedItem().toString();
        final String ra4 = ((Spinner) findViewById(R.id.RA4_field)).getSelectedItem().toString();
        final String ra5 = ((Spinner) findViewById(R.id.RA5_field)).getSelectedItem().toString();
        final String ra6 = ((Spinner) findViewById(R.id.RA6_field)).getSelectedItem().toString();
        final String ra7 = ((Spinner) findViewById(R.id.RA7_field)).getSelectedItem().toString();
        final String ra8 = ((Spinner) findViewById(R.id.RA8_field)).getSelectedItem().toString();
        final String ra9 = ((Spinner) findViewById(R.id.RA9_field)).getSelectedItem().toString();
        final String ra10 = ((Spinner) findViewById(R.id.RA10_field)).getSelectedItem().toString();
        final String ra11 = ((Spinner) findViewById(R.id.RA11_field)).getSelectedItem().toString();
        final String ra12 = ((Spinner) findViewById(R.id.RA12_field)).getSelectedItem().toString();
        final String ga15 = ((Spinner) findViewById(R.id.GA15_field)).getSelectedItem().toString();
        final String gb48 = ((Spinner) findViewById(R.id.GB48_field)).getSelectedItem().toString();
        final String gb49 = ((Spinner) findViewById(R.id.GB49_field)).getSelectedItem().toString();
        final String gb51 = ((Spinner) findViewById(R.id.GB51_field)).getSelectedItem().toString();
        final String gb52 = ((Spinner) findViewById(R.id.GB52_field)).getSelectedItem().toString();
        final String gb54 = ((Spinner) findViewById(R.id.GB54_field)).getSelectedItem().toString();
        final String gb55 = ((Spinner) findViewById(R.id.GB55_field)).getSelectedItem().toString();
        final String gb56 = ((Spinner) findViewById(R.id.GB56_field)).getSelectedItem().toString();
        final String gb58 = ((Spinner) findViewById(R.id.GB58_field)).getSelectedItem().toString();
        final String gb59 = ((Spinner) findViewById(R.id.GB59_field)).getSelectedItem().toString();
        final String gb60 = ((Spinner) findViewById(R.id.GB60_field)).getSelectedItem().toString();
        final String gb61 = ((Spinner) findViewById(R.id.GB61_field)).getSelectedItem().toString();
        final String gb64 = ((Spinner) findViewById(R.id.GB64_field)).getSelectedItem().toString();
        final String gb65 = ((Spinner) findViewById(R.id.GB65_field)).getSelectedItem().toString();
        final String gb66 = ((Spinner) findViewById(R.id.GB66_field)).getSelectedItem().toString();
        final String gb68 = ((Spinner) findViewById(R.id.GB68_field)).getSelectedItem().toString();
        final String gb72 = ((Spinner) findViewById(R.id.GB72_field)).getSelectedItem().toString();
        final String gc95 = ((Spinner) findViewById(R.id.GC95_field)).getSelectedItem().toString();
        final String cob3 = ((Spinner) findViewById(R.id.COB3_field)).getSelectedItem().toString();
        final String cob4 = ((Spinner) findViewById(R.id.COB4_field)).getSelectedItem().toString();
        final String cob5 = ((Spinner) findViewById(R.id.COB5_field)).getSelectedItem().toString();
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
            contact.put(ContactObject.RA1, ra1);
            contact.put(ContactObject.RA2, ra2);
            contact.put(ContactObject.RA3, ra3);
            contact.put(ContactObject.RA4, ra4);
            contact.put(ContactObject.RA5, ra5);
            contact.put(ContactObject.RA6, ra6);
            contact.put(ContactObject.RA7, ra7);
            contact.put(ContactObject.RA8, ra8);
            contact.put(ContactObject.RA9, ra9);
            contact.put(ContactObject.RA10, ra10);
            contact.put(ContactObject.RA11, ra11);
            contact.put(ContactObject.RA12, ra12);
            contact.put(ContactObject.GA15, ga15);
            contact.put(ContactObject.GB48, gb48);
            contact.put(ContactObject.GB49, gb49);
            contact.put(ContactObject.GB51, gb51);
            contact.put(ContactObject.GB52, gb52);
            contact.put(ContactObject.GB54, gb54);
            contact.put(ContactObject.GB55, gb55);
            contact.put(ContactObject.GB56, gb56);
            contact.put(ContactObject.GB58, gb58);
            contact.put(ContactObject.GB59, gb59);
            contact.put(ContactObject.GB60, gb60);
            contact.put(ContactObject.GB61, gb61);
            contact.put(ContactObject.GB64, gb64);
            contact.put(ContactObject.GB65, gb65);
            contact.put(ContactObject.GB66, gb66);
            contact.put(ContactObject.GB68, gb68);
            contact.put(ContactObject.GB72, gb72);
            contact.put(ContactObject.GC95, gc95);
            contact.put(ContactObject.COB3, cob3);
            contact.put(ContactObject.COB4, cob4);
            contact.put(ContactObject.COB5, cob5);
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
