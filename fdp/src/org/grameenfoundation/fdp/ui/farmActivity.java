package org.grameenfoundation.fdp.ui;

import android.Manifest;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class farmActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: farmActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button button;
    private EditText textView,nPlots;
    private LinearLayout adtCrops,adtCropsArea,hireLaborDays;
    private Spinner hireLabor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farm);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(DetailActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(DetailActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(DetailActivity.OBJECT_NAME_KEY);
        }
        adtCropsArea = (LinearLayout) findViewById(R.id.otherCropsArea_Layout);
        adtCrops = (LinearLayout) findViewById(R.id.aditionalCrops_Layout);
        button = (Button) findViewById(R.id.farmGPSButton);
        textView = (EditText) findViewById(R.id.farmGPS_field);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                setText( textView,location.getLatitude() + "/" + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);
                return;
            }
        } else {
            configureButton();
        }

        hireLabor = (Spinner) findViewById(R.id.hireLabor_field);
        hireLaborDays = (LinearLayout) findViewById(R.id.hireLaborDays_Layout);
        hireLabor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (hireLabor.getSelectedItem().toString().equals("Yes")){
                    hireLaborDays.setVisibility(View.VISIBLE);
                }else{
                    hireLaborDays.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        nPlots = (EditText) findViewById(R.id.numberPlots_field);
        nPlots.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                   if (nPlots.getText().toString().equals("0")){
                       Toast.makeText(getApplicationContext(),"the number of plots must be greater than zero !", Toast.LENGTH_LONG).show();
                   }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void launchPlot (View view) {
        save();
        final Intent certIntent = new Intent(this, certificationActivity.class);
        certIntent.addCategory(Intent.CATEGORY_DEFAULT);
        certIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        certIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        certIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivity(certIntent);
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
            if (sObject.getHaveaditionalcrops().equals("Yes")){
                adtCropsArea.setVisibility(View.VISIBLE);
                adtCrops.setVisibility(View.VISIBLE);
            }else {
                adtCropsArea.setVisibility(View.GONE);
                adtCrops.setVisibility(View.GONE);
            }
            setText((EditText) findViewById(R.id.farmName_field),sObject.getFarmName());
            setText((EditText) findViewById(R.id.farmVillage_field),sObject.getFarmVillage());
            setText((EditText) findViewById(R.id.farmGPS_field),sObject.getFarmGPS());
            setText((EditText) findViewById(R.id.farmAge_field),sObject.getFarmAge());
            setText((EditText) findViewById(R.id.farmCertifications_field),sObject.getFarmCertifications());
            //set Total Farm Area field
            if (sObject.getTotalFarmArea().isEmpty()){
                setText((EditText) findViewById(R.id.farmArea_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.farmArea_field),
                        sObject.getTotalFarmArea());
            }

            //set Total Cocoa Area field
            if (sObject.getTotalCocoaArea().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaArea_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaArea_field),
                        sObject.getTotalCocoaArea());
            }

            //set Total Renovation Area field
            if (sObject.getTotalRenovationArea().isEmpty()){
                setText((EditText) findViewById(R.id.renovationArea_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.renovationArea_field),
                        sObject.getTotalRenovationArea());
            }

            //set Total Other Area field
            if (sObject.getTotalAreaOtherCrops().isEmpty()){
                setText((EditText) findViewById(R.id.areaOtherCrops_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.areaOtherCrops_field),
                        sObject.getTotalAreaOtherCrops());
            }

            setText((EditText) findViewById(R.id.additionalCrops_field),sObject.getAditionalCrops());
            setText((EditText) findViewById(R.id.fmWorkFarm_field),sObject.getFamilyMembersWorkFarm());

            //set hire labor field
            if (sObject.getHireLabor().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireLabor_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireLabor_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.hireLabor_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set days hire field
            if (sObject.getHowManyLaborDaysHire().isEmpty()){
                setText((EditText) findViewById(R.id.daysHire_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.daysHire_field),
                        sObject.getHowManyLaborDaysHire());
            }

            //set number of plots field
            if (sObject.getNumberOfPlots().isEmpty()){
                setText((EditText) findViewById(R.id.numberPlots_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.numberPlots_field),
                        sObject.getNumberOfPlots());
            }

        }
    }

    private void setText(EditText textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String farmName = ((EditText) findViewById(R.id.farmName_field)).getText().toString();
        final String farmVillage = ((EditText) findViewById(R.id.farmVillage_field)).getText().toString();
        final String farmGPS = ((EditText) findViewById(R.id.farmGPS_field)).getText().toString();
        final String farmAge = ((EditText) findViewById(R.id.farmAge_field)).getText().toString();
        final String farmCert = ((EditText) findViewById(R.id.farmCertifications_field)).getText().toString();
        final String farmArea = ((EditText) findViewById(R.id.farmArea_field)).getText().toString();
        final String farmCocoaArea = ((EditText) findViewById(R.id.cocoaArea_field)).getText().toString();
        final String farmRenArea = ((EditText) findViewById(R.id.renovationArea_field)).getText().toString();
        final String farmAreaOtherCrops = ((EditText) findViewById(R.id.areaOtherCrops_field)).getText().toString();
        final String farmAditionalCrops = ((EditText) findViewById(R.id.additionalCrops_field)).getText().toString();
        final String farmWorkOnFarm = ((EditText) findViewById(R.id.fmWorkFarm_field)).getText().toString();
        final String hireLabor = ((Spinner) findViewById(R.id.hireLabor_field)).getSelectedItem().toString();
        final String hireDays = ((EditText) findViewById(R.id.daysHire_field)).getText().toString();
        final String numberPlots = ((EditText) findViewById(R.id.numberPlots_field)).getText().toString();
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
            contact.put(ContactObject.FARMNAME, farmName);
            contact.put(ContactObject.FARMVILLAGE, farmVillage);
            contact.put(ContactObject.FARMGPS, farmGPS);
            contact.put(ContactObject.FARMAGE, farmAge);
            contact.put(ContactObject.FARMCERTIFICATIONS, farmCert);
            contact.put(ContactObject.TOTALFARMAREA, farmArea);
            contact.put(ContactObject.TOTALCOCOAAREA, farmCocoaArea);
            contact.put(ContactObject.TOTALRENOVATIONAREA, farmRenArea);
            contact.put(ContactObject.TOTALAREAOTHERCROPS, farmAreaOtherCrops);
            contact.put(ContactObject.ADITIONALCROPS, farmAditionalCrops);
            contact.put(ContactObject.FAMILYMEMBERSWORKONFARM, farmWorkOnFarm);
            contact.put(ContactObject.HIRELABOR, hireLabor);
            contact.put(ContactObject.HOWMANYLABORDAYSHIRE, hireDays);
            contact.put(ContactObject.NUMBEROFPLOTS, numberPlots);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Save successful!", LENGTH_LONG).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}
