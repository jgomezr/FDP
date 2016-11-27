package org.grameenfoundation.fdp.ui;

import android.Manifest;
import android.app.ActionBar;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class plotActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: plotActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private EditText geneticP1,geneticP2,geneticP3,geneticP4,geneticP5,gapP1,gapP2,gapP3,gapP4,gapP5,soilFertMng1,soilFertMng2,soilFertMng3,soilFertMng4,soilFertMng5,filliP1, filliP2, filliP3, filliP4, filliP5, fcondP1,  fcondP2, fcondP3, fcondP4, fcondP5, limeNP1, limeNP2, limeNP3, limeNP4, limeNP5, gpsP1, ageP1, areP1, estP1, steP1, gpsP2, ageP2, areP2, estP2, steP2, gpsP3, ageP3, areP3, estP3, steP3, gpsP4, ageP4, areP4, estP4, steP4, gpsP5, ageP5, areP5, estP5, steP5, ph1, ph2, ph3, ph4, ph5;
    private TextView Lp1, Lp2, Lp3, Lp4, Lp5;
    private Spinner cteP1, cteP2, cteP3, cteP4, cteP5, plantP1, tehelP1, debDiP1, pruniP1, pesDiP1, weediP1, harveP1, shadeP1, soilCP1, orgMaP1, fertFP1, fertAP1, drainP1, hireNP1, plantP2, tehelP2, debDiP2, pruniP2, pesDiP2, weediP2, harveP2, shadeP2, soilCP2, orgMaP2, fertFP2, fertAP2, drainP2, hireNP2, plantP3, tehelP3, debDiP3, pruniP3, pesDiP3, weediP3, harveP3, shadeP3, soilCP3, orgMaP3, fertFP3, fertAP3, drainP3, hireNP3, plantP4, tehelP4, debDiP4, pruniP4, pesDiP4, weediP4, harveP4, shadeP4, soilCP4, orgMaP4, fertFP4, fertAP4, drainP4, hireNP4, plantP5, tehelP5, debDiP5, pruniP5, pesDiP5, weediP5, harveP5, shadeP5, soilCP5, orgMaP5, fertFP5, fertAP5, drainP5, hireNP5;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button calc1,calc2,calc3,calc4,calc5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(R.string.plotActivityTitle);
        setContentView(R.layout.plot);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(DetailActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(DetailActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(DetailActivity.OBJECT_NAME_KEY);
        }
        Lp1 = (TextView) findViewById(R.id.plot_1_label);
        Lp2 = (TextView) findViewById(R.id.plot_2_label);
        Lp3 = (TextView) findViewById(R.id.plot_3_label);
        Lp4 = (TextView) findViewById(R.id.plot_4_label);
        Lp5 = (TextView) findViewById(R.id.plot_5_label);
        gpsP1 = (EditText) findViewById(R.id.gpsp1_field);
        ageP1 = (EditText) findViewById(R.id.plotAgep1_field);
        areP1 = (EditText) findViewById(R.id.plotArea1_field);
        cteP1 = (Spinner) findViewById(R.id.cocoaTreesP1_field);
        estP1 = (EditText) findViewById(R.id.estimatedP1_field);
        steP1 = (EditText) findViewById(R.id.shadeTreesP1_field);
        plantP1 = (Spinner) findViewById(R.id.plantingP1_field);
        fcondP1 = (EditText) findViewById(R.id.farmConditionP1_field);
        tehelP1 = (Spinner) findViewById(R.id.treeHealthP1_field);
        debDiP1 = (Spinner) findViewById(R.id.debilitationP1_field);
        pruniP1 = (Spinner) findViewById(R.id.pruningP1_field);
        pesDiP1 = (Spinner) findViewById(R.id.pestDiseaseP1_field);
        weediP1 = (Spinner) findViewById(R.id.weedingP1_field);
        harveP1 = (Spinner) findViewById(R.id.harvestingP1_field);
        shadeP1 = (Spinner) findViewById(R.id.shadeManagementP1_field);
        soilCP1 = (Spinner) findViewById(R.id.soilConditionP1_field);
        orgMaP1 = (Spinner) findViewById(R.id.organicMatterP1_field);
        fertFP1 = (Spinner) findViewById(R.id.fartFormP1_field);
        fertAP1 = (Spinner) findViewById(R.id.fartApplicationP1_field);
        limeNP1 = (EditText) findViewById(R.id.limeP1_field);
        drainP1 = (Spinner) findViewById(R.id.drainageP1_field);
        filliP1 = (EditText) findViewById(R.id.fillingP1_field);
        hireNP1 = (Spinner) findViewById(R.id.hireP1_field);
        gpsP2 = (EditText) findViewById(R.id.gpsp2_field);
        ageP2 = (EditText) findViewById(R.id.plotAgep2_field);
        areP2 = (EditText) findViewById(R.id.plotArea2_field);
        cteP2 = (Spinner) findViewById(R.id.cocoaTreesP2_field);
        estP2 = (EditText) findViewById(R.id.estimatedP2_field);
        steP2 = (EditText) findViewById(R.id.shadeTreesP2_field);
        plantP2 = (Spinner) findViewById(R.id.plantingP2_field);
        fcondP2 = (EditText) findViewById(R.id.farmConditionP2_field);
        tehelP2 = (Spinner) findViewById(R.id.treeHealthP2_field);
        debDiP2 = (Spinner) findViewById(R.id.debilitationP2_field);
        pruniP2 = (Spinner) findViewById(R.id.pruningP2_field);
        pesDiP2 = (Spinner) findViewById(R.id.pestDiseaseP2_field);
        weediP2 = (Spinner) findViewById(R.id.weedingP2_field);
        harveP2 = (Spinner) findViewById(R.id.harvestingP2_field);
        shadeP2 = (Spinner) findViewById(R.id.shadeManagementP2_field);
        soilCP2 = (Spinner) findViewById(R.id.soilConditionP2_field);
        orgMaP2 = (Spinner) findViewById(R.id.organicMatterP2_field);
        fertFP2 = (Spinner) findViewById(R.id.fartFormP2_field);
        fertAP2 = (Spinner) findViewById(R.id.fartApplicationP2_field);
        limeNP2 = (EditText) findViewById(R.id.limeP2_field);
        drainP2 = (Spinner) findViewById(R.id.drainageP2_field);
        filliP2 = (EditText) findViewById(R.id.fillingP2_field);
        hireNP2 = (Spinner) findViewById(R.id.hireP2_field);
        gpsP3 = (EditText) findViewById(R.id.gpsp3_field);
        ageP3 = (EditText) findViewById(R.id.plotAgep3_field);
        areP3 = (EditText) findViewById(R.id.plotArea3_field);
        cteP3 = (Spinner) findViewById(R.id.cocoaTreesP3_field);
        estP3 = (EditText) findViewById(R.id.estimatedP3_field);
        steP3 = (EditText) findViewById(R.id.shadeTreesP3_field);
        plantP3 = (Spinner) findViewById(R.id.plantingP3_field);
        fcondP3 = (EditText) findViewById(R.id.farmConditionP3_field);
        tehelP3 = (Spinner) findViewById(R.id.treeHealthP3_field);
        debDiP3 = (Spinner) findViewById(R.id.debilitationP3_field);
        pruniP3 = (Spinner) findViewById(R.id.pruningP3_field);
        pesDiP3 = (Spinner) findViewById(R.id.pestDiseaseP3_field);
        weediP3 = (Spinner) findViewById(R.id.weedingP3_field);
        harveP3 = (Spinner) findViewById(R.id.harvestingP3_field);
        shadeP3 = (Spinner) findViewById(R.id.shadeManagementP3_field);
        soilCP3 = (Spinner) findViewById(R.id.soilConditionP3_field);
        orgMaP3 = (Spinner) findViewById(R.id.organicMatterP3_field);
        fertFP3 = (Spinner) findViewById(R.id.fartFormP3_field);
        fertAP3 = (Spinner) findViewById(R.id.fartApplicationP3_field);
        limeNP3 = (EditText) findViewById(R.id.limeP3_field);
        drainP3 = (Spinner) findViewById(R.id.drainageP3_field);
        filliP3 = (EditText) findViewById(R.id.fillingP3_field);
        hireNP3 = (Spinner) findViewById(R.id.hireP3_field);
        gpsP4 = (EditText) findViewById(R.id.gpsp4_field);
        ageP4 = (EditText) findViewById(R.id.plotAgep4_field);
        areP4 = (EditText) findViewById(R.id.plotArea4_field);
        cteP4 = (Spinner) findViewById(R.id.cocoaTreesP4_field);
        estP4 = (EditText) findViewById(R.id.estimatedP4_field);
        steP4 = (EditText) findViewById(R.id.shadeTreesP4_field);
        plantP4 = (Spinner) findViewById(R.id.plantingP4_field);
        fcondP4 = (EditText) findViewById(R.id.farmConditionP4_field);
        tehelP4 = (Spinner) findViewById(R.id.treeHealthP4_field);
        debDiP4 = (Spinner) findViewById(R.id.debilitationP4_field);
        pruniP4 = (Spinner) findViewById(R.id.pruningP4_field);
        pesDiP4 = (Spinner) findViewById(R.id.pestDiseaseP4_field);
        weediP4 = (Spinner) findViewById(R.id.weedingP4_field);
        harveP4 = (Spinner) findViewById(R.id.harvestingP4_field);
        shadeP4 = (Spinner) findViewById(R.id.shadeManagementP4_field);
        soilCP4 = (Spinner) findViewById(R.id.soilConditionP4_field);
        orgMaP4 = (Spinner) findViewById(R.id.organicMatterP4_field);
        fertFP4 = (Spinner) findViewById(R.id.fartFormP4_field);
        fertAP4 = (Spinner) findViewById(R.id.fartApplicationP4_field);
        limeNP4 = (EditText) findViewById(R.id.limeP4_field);
        drainP4 = (Spinner) findViewById(R.id.drainageP4_field);
        filliP4 = (EditText) findViewById(R.id.fillingP4_field);
        hireNP4 = (Spinner) findViewById(R.id.hireP4_field);
        gpsP5 = (EditText) findViewById(R.id.gpsp5_field);
        ageP5 = (EditText) findViewById(R.id.plotAgep5_field);
        areP5 = (EditText) findViewById(R.id.plotArea5_field);
        cteP5 = (Spinner) findViewById(R.id.cocoaTreesP5_field);
        estP5 = (EditText) findViewById(R.id.estimatedP5_field);
        steP5 = (EditText) findViewById(R.id.shadeTreesP5_field);
        plantP5 = (Spinner) findViewById(R.id.plantingP5_field);
        fcondP5 = (EditText) findViewById(R.id.farmConditionP5_field);
        tehelP5 = (Spinner) findViewById(R.id.treeHealthP5_field);
        debDiP5 = (Spinner) findViewById(R.id.debilitationP5_field);
        pruniP5 = (Spinner) findViewById(R.id.pruningP5_field);
        pesDiP5 = (Spinner) findViewById(R.id.pestDiseaseP5_field);
        weediP5 = (Spinner) findViewById(R.id.weedingP5_field);
        harveP5 = (Spinner) findViewById(R.id.harvestingP5_field);
        shadeP5 = (Spinner) findViewById(R.id.shadeManagementP5_field);
        soilCP5 = (Spinner) findViewById(R.id.soilConditionP5_field);
        orgMaP5 = (Spinner) findViewById(R.id.organicMatterP5_field);
        fertFP5 = (Spinner) findViewById(R.id.fartFormP5_field);
        fertAP5 = (Spinner) findViewById(R.id.fartApplicationP5_field);
        limeNP5 = (EditText) findViewById(R.id.limeP5_field);
        drainP5 = (Spinner) findViewById(R.id.drainageP5_field);
        filliP5 = (EditText) findViewById(R.id.fillingP5_field);
        hireNP5 = (Spinner) findViewById(R.id.hireP5_field);
        ph1 = (EditText) findViewById(R.id.ph1_field);
        ph2 = (EditText) findViewById(R.id.ph2_field);
        ph3 = (EditText) findViewById(R.id.ph3_field);
        ph4 = (EditText) findViewById(R.id.ph4_field);
        ph5 = (EditText) findViewById(R.id.ph5_field);
        geneticP1= (EditText) findViewById(R.id.geneticP1_field);
        geneticP2= (EditText) findViewById(R.id.geneticP2_field);
        geneticP3= (EditText) findViewById(R.id.geneticP3_field);
        geneticP4= (EditText) findViewById(R.id.geneticP4_field);
        geneticP5= (EditText) findViewById(R.id.geneticP5_field);
        gapP1= (EditText) findViewById(R.id.gapP1_field);
        gapP2= (EditText) findViewById(R.id.gapP2_field);
        gapP3= (EditText) findViewById(R.id.gapP3_field);
        gapP4= (EditText) findViewById(R.id.gapP4_field);
        gapP5= (EditText) findViewById(R.id.gapP5_field);
        soilFertMng1= (EditText) findViewById(R.id.soilFertMng1_field);
        soilFertMng2= (EditText) findViewById(R.id.soilFertMng2_field);
        soilFertMng3= (EditText) findViewById(R.id.soilFertMng3_field);
        soilFertMng4= (EditText) findViewById(R.id.soilFertMng4_field);
        soilFertMng5= (EditText) findViewById(R.id.soilFertMng5_field);
        calc1= (Button) findViewById(R.id.calculateP1);
        calc2= (Button) findViewById(R.id.calculateP2);
        calc3= (Button) findViewById(R.id.calculateP3);
        calc4= (Button) findViewById(R.id.calculateP4);
        calc5= (Button) findViewById(R.id.calculateP5);

        gpsP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gpsP1, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
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
                        locationManager.removeUpdates(locationListener);
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
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gpsP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gpsP3, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
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
                        locationManager.removeUpdates(locationListener);
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
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gpsP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gpsP4, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
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
                        locationManager.removeUpdates(locationListener);
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
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gpsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gpsP2, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
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
                        locationManager.removeUpdates(locationListener);
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
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gpsP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gpsP5, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
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
                        locationManager.removeUpdates(locationListener);
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
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        ph1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph1.getText()).isEmpty()){
                    setText(limeNP1,"N/A");
                }else if (Double.parseDouble(ph1.getText().toString()) > 5.8){
                    setText(limeNP1,"No");
                }else{
                    setText(limeNP1,"Yes");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ph2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph2.getText()).isEmpty()){
                    setText(limeNP2,"N/A");
                }else if (Double.parseDouble(ph2.getText().toString()) > 5.8){
                    setText(limeNP2,"No");
                }else{
                    setText(limeNP2,"Yes");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ph3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph3.getText()).isEmpty()){
                    setText(limeNP3,"N/A");
                }else if (Double.parseDouble(ph3.getText().toString()) > 5.8){
                    setText(limeNP3,"No");
                }else{
                    setText(limeNP3,"Yes");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ph4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph4.getText()).isEmpty()){
                    setText(limeNP4,"N/A");
                }else if (Double.parseDouble(ph4.getText().toString()) > 5.8){
                    setText(limeNP4,"No");
                }else{
                    setText(limeNP4,"Yes");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ph5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph5.getText()).isEmpty()){
                    setText(limeNP5,"N/A");
                }else if (Double.parseDouble(ph5.getText().toString()) > 5.8){
                    setText(limeNP5,"No");
                }else{
                    setText(limeNP5,"Yes");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        areP1.addTextChangedListener(new TextWatcher() {


             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {}

             @Override
             public void afterTextChanged(Editable s) {
                 double p1;
                 if(areP1.getText().toString().isEmpty()){
                     p1=0;
                 }else{
                     p1=Double.parseDouble(areP1.getText().toString());
                 }

                 if ((p1+Double.parseDouble(areP2.getText().toString())+Double.parseDouble(areP3.getText().toString())+Double.parseDouble(areP4.getText().toString())+Double.parseDouble(areP5.getText().toString()))>Double.parseDouble(sObject.getTotalCocoaArea())){
                     areP1.setBackgroundColor(Color.parseColor("#cc0000"));
                     Toast.makeText(getApplicationContext(), "Your plots area can't be hig than Cocoa Area on farm", Toast.LENGTH_LONG).show();
                 }else{
                     areP1.setBackgroundColor(Color.TRANSPARENT);
                 }
             }
        });

        areP2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p2;
                if(areP2.getText().toString().isEmpty()){
                    p2=0;
                }else{
                    p2=Double.parseDouble(areP2.getText().toString());
                }
                if ((Double.parseDouble(areP1.getText().toString())+p2+Double.parseDouble(areP3.getText().toString())+Double.parseDouble(areP4.getText().toString())+Double.parseDouble(areP5.getText().toString()))>Double.parseDouble(sObject.getTotalCocoaArea())){
                    areP2.setBackgroundColor(Color.parseColor("#cc0000"));
                    Toast.makeText(getApplicationContext(), "Your plots area can't be hig than Cocoa Area on farm", Toast.LENGTH_LONG).show();
                }else{
                    areP2.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        areP3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double p3;
                if(areP3.getText().toString().isEmpty()){
                    p3=0;
                }else{
                    p3=Double.parseDouble(areP3.getText().toString());
                }
                if ((Double.parseDouble(areP1.getText().toString())+Double.parseDouble(areP2.getText().toString())+p3+Double.parseDouble(areP4.getText().toString())+Double.parseDouble(areP5.getText().toString()))>Double.parseDouble(sObject.getTotalCocoaArea())){
                    areP3.setBackgroundColor(Color.parseColor("#cc0000"));
                    Toast.makeText(getApplicationContext(), "Your plots area can't be hig than Cocoa Area on farm", Toast.LENGTH_LONG).show();
                }else{
                    areP3.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        areP4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double p4;
                if(areP4.getText().toString().isEmpty()){
                    p4=0;
                }else{
                    p4=Double.parseDouble(areP4.getText().toString());
                }
                if ((Double.parseDouble(areP1.getText().toString())+Double.parseDouble(areP2.getText().toString())+Double.parseDouble(areP3.getText().toString())+p4+Double.parseDouble(areP5.getText().toString()))>Double.parseDouble(sObject.getTotalCocoaArea())){
                    areP4.setBackgroundColor(Color.parseColor("#cc0000"));
                    Toast.makeText(getApplicationContext(), "Your plots area can't be hig than Cocoa Area on farm", Toast.LENGTH_LONG).show();
                }else{
                    areP4.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        areP5.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double p5;
                if(areP5.getText().toString().isEmpty()){
                    p5=0;
                }else{
                    p5=Double.parseDouble(areP5.getText().toString());
                }
                if ((Double.parseDouble(areP1.getText().toString())+Double.parseDouble(areP2.getText().toString())+Double.parseDouble(areP3.getText().toString())+Double.parseDouble(areP4.getText().toString())+p5)>Double.parseDouble(sObject.getTotalCocoaArea())){
                    areP5.setBackgroundColor(Color.parseColor("#cc0000"));
                    Toast.makeText(getApplicationContext(), "Your plots area can't be hig than Cocoa Area on farm", Toast.LENGTH_LONG).show();
                }else{
                    areP5.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        estP1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p1;
                double p2;
                double p3;
                double p4;
                double p5;
                if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()){
                    p1=0;
                    p2=0;
                    p3=0;
                    p4=0;
                    p5=0;
                }else{
                    p1=Double.parseDouble(estP1.getText().toString());
                    p2=Double.parseDouble(estP2.getText().toString());
                    p3=Double.parseDouble(estP3.getText().toString());
                    p4=Double.parseDouble(estP4.getText().toString());
                    p5=Double.parseDouble(estP5.getText().toString());
                }
                if ((p1+p2+p3+p4+p5)>Double.parseDouble(sObject.getProductioncocoaly())){
                    Toast.makeText(getApplicationContext(), "Your estimated production is greater than that of the previous year", Toast.LENGTH_LONG).show();
                }
            }
        });

        estP2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p1;
                double p2;
                double p3;
                double p4;
                double p5;
                if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()){
                    p1=0;
                    p2=0;
                    p3=0;
                    p4=0;
                    p5=0;
                }else{
                    p1=Double.parseDouble(estP1.getText().toString());
                    p2=Double.parseDouble(estP2.getText().toString());
                    p3=Double.parseDouble(estP3.getText().toString());
                    p4=Double.parseDouble(estP4.getText().toString());
                    p5=Double.parseDouble(estP5.getText().toString());
                }
                if ((p1+p2+p3+p4+p5)>Double.parseDouble(sObject.getProductioncocoaly())){
                    Toast.makeText(getApplicationContext(), "Your estimated production is greater than that of the previous year", Toast.LENGTH_LONG).show();
                }
            }
        });

        estP3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p1;
                double p2;
                double p3;
                double p4;
                double p5;
                if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()){
                    p1=0;
                    p2=0;
                    p3=0;
                    p4=0;
                    p5=0;
                }else{
                    p1=Double.parseDouble(estP1.getText().toString());
                    p2=Double.parseDouble(estP2.getText().toString());
                    p3=Double.parseDouble(estP3.getText().toString());
                    p4=Double.parseDouble(estP4.getText().toString());
                    p5=Double.parseDouble(estP5.getText().toString());
                }
                if ((p1+p2+p3+p4+p5)>Double.parseDouble(sObject.getProductioncocoaly())){
                    Toast.makeText(getApplicationContext(), "Your estimated production is greater than that of the previous year", Toast.LENGTH_LONG).show();
                }
            }
        });
        estP4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p1;
                double p2;
                double p3;
                double p4;
                double p5;
                if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()){
                    p1=0;
                    p2=0;
                    p3=0;
                    p4=0;
                    p5=0;
                }else{
                    p1=Double.parseDouble(estP1.getText().toString());
                    p2=Double.parseDouble(estP2.getText().toString());
                    p3=Double.parseDouble(estP3.getText().toString());
                    p4=Double.parseDouble(estP4.getText().toString());
                    p5=Double.parseDouble(estP5.getText().toString());
                }
                if ((p1+p2+p3+p4+p5)>Double.parseDouble(sObject.getProductioncocoaly())){
                    Toast.makeText(getApplicationContext(), "Your estimated production is greater than that of the previous year", Toast.LENGTH_LONG).show();
                }
            }
        });
        estP5.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                double p1;
                double p2;
                double p3;
                double p4;
                double p5;
                if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()){
                    p1=0;
                    p2=0;
                    p3=0;
                    p4=0;
                    p5=0;
                }else{
                    p1=Double.parseDouble(estP1.getText().toString());
                    p2=Double.parseDouble(estP2.getText().toString());
                    p3=Double.parseDouble(estP3.getText().toString());
                    p4=Double.parseDouble(estP4.getText().toString());
                    p5=Double.parseDouble(estP5.getText().toString());
                }
                if ((p1+p2+p3+p4+p5)>Double.parseDouble(sObject.getProductioncocoaly())){
                    Toast.makeText(getApplicationContext(), "Your estimated production is greater than that of the previous year", Toast.LENGTH_LONG).show();
                }
            }
        });

        cteP1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP1.getSelectedItem().toString().equals("3x2.5")||cteP1.getSelectedItem().toString().equals("3x3")||cteP1.getSelectedItem().toString().equals("3.5x3.5")||cteP1.getSelectedItem().toString().equals("3x3.5")){
                    setText(filliP1,"No");
                }else if(cteP1.getSelectedItem().toString().equals("4x4")||cteP1.getSelectedItem().toString().equals("3.5x4")){
                    setText(filliP1,"Yes");
                }else{
                    setText(filliP1,"No");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cteP2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP2.getSelectedItem().toString().equals("2.5x2.5")||cteP2.getSelectedItem().toString().equals("3x3")||cteP2.getSelectedItem().toString().equals("3.5x3.5")||cteP2.getSelectedItem().toString().equals("3x3.5")){
                   setText(filliP2,"No");
                }else if(cteP2.getSelectedItem().toString().equals("4x4")||cteP2.getSelectedItem().toString().equals("3.5x4")){
                    setText(filliP2,"Yes");
                }else{
                    setText(filliP2,"No");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cteP3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP3.getSelectedItem().toString().equals("2.5x2.5")||cteP3.getSelectedItem().toString().equals("3x3")||cteP3.getSelectedItem().toString().equals("3.5x3.5")||cteP3.getSelectedItem().toString().equals("3x3.5")){
                    setText(filliP3,"No");
                }else if(cteP3.getSelectedItem().toString().equals("4x4")||cteP3.getSelectedItem().toString().equals("3.5x4")){
                    setText(filliP3,"Yes");
                }else{
                    setText(filliP3,"No");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cteP4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP4.getSelectedItem().toString().equals("2.5x2.5")||cteP4.getSelectedItem().toString().equals("3x3")||cteP4.getSelectedItem().toString().equals("3.5x3.5")||cteP4.getSelectedItem().toString().equals("3x3.5")){
                    setText(filliP4,"No");
                }else if(cteP4.getSelectedItem().toString().equals("4x4")||cteP4.getSelectedItem().toString().equals("3.5x4")){
                    setText(filliP4,"Yes");
                }else{
                    setText(filliP4,"No");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cteP5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP5.getSelectedItem().toString().equals("2.5x2.5")||cteP5.getSelectedItem().toString().equals("3x3")||cteP5.getSelectedItem().toString().equals("3.5x3.5")||cteP5.getSelectedItem().toString().equals("3x3.5")){
                    setText(filliP5,"No");
                }else if(cteP5.getSelectedItem().toString().equals("4x4")||cteP5.getSelectedItem().toString().equals("3.5x4")){
                    setText(filliP5,"Yes");
                }else{
                    setText(filliP5,"No");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void calculate(View view) {
        switch(view.getId()) {
            case R.id.calculateP1:
                if (plantP1.getSelectedItem().toString().equals("B")) {
                    setText(geneticP1, "B");
                } else {
                    setText(geneticP1, "G");
                }
                if ((cteP1.getSelectedItem().toString().equals("2x2")||cteP1.getSelectedItem().toString().equals("2.5x2.5")||cteP1.getSelectedItem().toString().equals("3×4")||cteP1.getSelectedItem().toString().equals("3.5×4")||cteP1.getSelectedItem().toString().equals("4×4"))||(Double.parseDouble(ageP1.getText().toString()) > 25)||(tehelP1.getSelectedItem().toString().equals("B"))||(debDiP1.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP1, "B");
                    setText(filliP1,"No");
                }else{
                    setText(fcondP1, "G");
                }
                if (pruniP1.getSelectedItem().toString().equals("B")||pesDiP1.getSelectedItem().toString().equals("B")||weediP1.getSelectedItem().toString().equals("B")||harveP1.getSelectedItem().toString().equals("B")||shadeP1.getSelectedItem().toString().equals("B")){
                    setText(gapP1,"B");
                }else{
                    setText(gapP1, "G");
                }
                if (soilCP1.getSelectedItem().toString().equals("B")||orgMaP1.getSelectedItem().toString().equals("B")||fertFP1.getSelectedItem().toString().equals("B")||fertAP1.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng1,"B");
                }else{
                    setText(soilFertMng1,"G");
                }
                partialSave();
                break;

            case R.id.calculateP2:
                if (plantP2.getSelectedItem().toString().equals("B")) {
                    setText(geneticP2, "B");
                } else {
                    setText(geneticP2, "G");
                }
                if ((cteP2.getSelectedItem().toString().equals("2x2")||cteP2.getSelectedItem().toString().equals("2.5x2.5")||cteP2.getSelectedItem().toString().equals("3×4")||cteP2.getSelectedItem().toString().equals("3.5×4")||cteP2.getSelectedItem().toString().equals("4×4"))||(Double.parseDouble(ageP2.getText().toString()) > 25)||(tehelP2.getSelectedItem().toString().equals("B"))||(debDiP2.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP2, "B");
                    setText(filliP2,"No");
                }else{
                    setText(fcondP2, "G");
                }
                if (pruniP2.getSelectedItem().toString().equals("B")||pesDiP2.getSelectedItem().toString().equals("B")||weediP2.getSelectedItem().toString().equals("B")||harveP2.getSelectedItem().toString().equals("B")||shadeP2.getSelectedItem().toString().equals("B")){
                    setText(gapP2,"B");
                }else{
                    setText(gapP2, "G");
                }
                if (soilCP2.getSelectedItem().toString().equals("B")||orgMaP2.getSelectedItem().toString().equals("B")||fertFP2.getSelectedItem().toString().equals("B")||fertAP2.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng2,"B");
                }else{
                    setText(soilFertMng2,"G");
                }
                partialSave();
                break;

            case R.id.calculateP3:
                if (plantP3.getSelectedItem().toString().equals("B")) {
                    setText(geneticP3, "B");
                } else {
                    setText(geneticP3, "G");
                }
                if ((cteP3.getSelectedItem().toString().equals("2x2")||cteP3.getSelectedItem().toString().equals("2.5x2.5")||cteP3.getSelectedItem().toString().equals("3×4")||cteP3.getSelectedItem().toString().equals("3.5×4")||cteP3.getSelectedItem().toString().equals("4×4"))||(Double.parseDouble(ageP3.getText().toString()) > 25)||(tehelP3.getSelectedItem().toString().equals("B"))||(debDiP3.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP3, "B");
                    setText(filliP3,"No");
                }else{
                    setText(fcondP3, "G");
                }
                if (pruniP3.getSelectedItem().toString().equals("B")||pesDiP3.getSelectedItem().toString().equals("B")||weediP3.getSelectedItem().toString().equals("B")||harveP3.getSelectedItem().toString().equals("B")||shadeP3.getSelectedItem().toString().equals("B")){
                    setText(gapP3,"B");
                }else{
                    setText(gapP3, "G");
                }
                if (soilCP3.getSelectedItem().toString().equals("B")||orgMaP3.getSelectedItem().toString().equals("B")||fertFP3.getSelectedItem().toString().equals("B")||fertAP3.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng3,"B");
                }else{
                    setText(soilFertMng3,"G");
                }
                partialSave();
                break;

            case R.id.calculateP4:
                if (plantP4.getSelectedItem().toString().equals("B")) {
                    setText(geneticP4, "B");
                } else {
                    setText(geneticP4, "G");
                }
                if ((cteP4.getSelectedItem().toString().equals("2x2")||cteP4.getSelectedItem().toString().equals("2.5x2.5")||cteP4.getSelectedItem().toString().equals("3×4")||cteP4.getSelectedItem().toString().equals("3.5×4")||cteP4.getSelectedItem().toString().equals("4×4"))||(Double.parseDouble(ageP4.getText().toString()) > 25)||(tehelP4.getSelectedItem().toString().equals("B"))||(debDiP4.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP4, "B");
                    setText(filliP4,"No");
                }else{
                    setText(fcondP4, "G");
                }
                if (pruniP4.getSelectedItem().toString().equals("B")||pesDiP4.getSelectedItem().toString().equals("B")||weediP4.getSelectedItem().toString().equals("B")||harveP4.getSelectedItem().toString().equals("B")||shadeP4.getSelectedItem().toString().equals("B")){
                    setText(gapP4,"B");
                }else{
                    setText(gapP4, "G");
                }
                if (soilCP4.getSelectedItem().toString().equals("B")||orgMaP4.getSelectedItem().toString().equals("B")||fertFP4.getSelectedItem().toString().equals("B")||fertAP4.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng4,"B");
                }else{
                    setText(soilFertMng4,"G");
                }
                partialSave();
                break;

            case R.id.calculateP5:
                if (plantP5.getSelectedItem().toString().equals("B")) {
                    setText(geneticP5, "B");
                } else {
                    setText(geneticP5, "G");
                }
                if ((cteP5.getSelectedItem().toString().equals("2x2")||cteP5.getSelectedItem().toString().equals("2.5x2.5")||cteP5.getSelectedItem().toString().equals("3×4")||cteP5.getSelectedItem().toString().equals("3.5×4")||cteP5.getSelectedItem().toString().equals("4×4"))||(Double.parseDouble(ageP5.getText().toString()) > 25)||(tehelP5.getSelectedItem().toString().equals("B"))||(debDiP5.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP5, "B");
                    setText(filliP5,"No");
                }else{
                    setText(fcondP5, "G");
                }
                if (pruniP5.getSelectedItem().toString().equals("B")||pesDiP5.getSelectedItem().toString().equals("B")||weediP5.getSelectedItem().toString().equals("B")||harveP5.getSelectedItem().toString().equals("B")||shadeP5.getSelectedItem().toString().equals("B")){
                    setText(gapP5,"B");
                }else{
                    setText(gapP5, "G");
                }
                if (soilCP5.getSelectedItem().toString().equals("B")||orgMaP5.getSelectedItem().toString().equals("B")||fertFP5.getSelectedItem().toString().equals("B")||fertAP5.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng5,"B");
                }else{
                    setText(soilFertMng5,"G");
                }
                partialSave();
                break;
        }
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void launchFdp(View view) {
        save();
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

    public boolean onOptionsItemSelected(MenuItem item){
        save();
        Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);
        detailIntent.addCategory(Intent.CATEGORY_DEFAULT);
        detailIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        detailIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        detailIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivityForResult(detailIntent, 0);
        return true;

    }

    private void refreshScreen() {
        if (sObject != null) {
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                Lp1.setVisibility(View.VISIBLE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                ph1.setVisibility(View.VISIBLE);
                geneticP1.setVisibility(View.VISIBLE);
                gapP1.setVisibility(View.VISIBLE);
                soilFertMng1.setVisibility(View.VISIBLE);
                calc1.setVisibility(View.VISIBLE);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                Lp2.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                ph2.setVisibility(View.VISIBLE);
                geneticP2.setVisibility(View.VISIBLE);
                gapP2.setVisibility(View.VISIBLE);
                soilFertMng2.setVisibility(View.VISIBLE);
                calc2.setVisibility(View.VISIBLE);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                Lp3.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.VISIBLE);
                ageP3.setVisibility(View.VISIBLE);
                areP3.setVisibility(View.VISIBLE);
                cteP3.setVisibility(View.VISIBLE);
                estP3.setVisibility(View.VISIBLE);
                steP3.setVisibility(View.VISIBLE);
                plantP3.setVisibility(View.VISIBLE);
                fcondP3.setVisibility(View.VISIBLE);
                tehelP3.setVisibility(View.VISIBLE);
                debDiP3.setVisibility(View.VISIBLE);
                pruniP3.setVisibility(View.VISIBLE);
                pesDiP3.setVisibility(View.VISIBLE);
                weediP3.setVisibility(View.VISIBLE);
                harveP3.setVisibility(View.VISIBLE);
                shadeP3.setVisibility(View.VISIBLE);
                soilCP3.setVisibility(View.VISIBLE);
                orgMaP3.setVisibility(View.VISIBLE);
                fertFP3.setVisibility(View.VISIBLE);
                fertAP3.setVisibility(View.VISIBLE);
                limeNP3.setVisibility(View.VISIBLE);
                drainP3.setVisibility(View.VISIBLE);
                filliP3.setVisibility(View.VISIBLE);
                hireNP3.setVisibility(View.VISIBLE);
                ph3.setVisibility(View.VISIBLE);
                geneticP3.setVisibility(View.VISIBLE);
                gapP3.setVisibility(View.VISIBLE);
                soilFertMng3.setVisibility(View.VISIBLE);
                calc3.setVisibility(View.VISIBLE);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                Lp4.setVisibility(View.VISIBLE);
                gpsP4.setVisibility(View.VISIBLE);
                ageP4.setVisibility(View.VISIBLE);
                areP4.setVisibility(View.VISIBLE);
                cteP4.setVisibility(View.VISIBLE);
                estP4.setVisibility(View.VISIBLE);
                steP4.setVisibility(View.VISIBLE);
                plantP4.setVisibility(View.VISIBLE);
                fcondP4.setVisibility(View.VISIBLE);
                tehelP4.setVisibility(View.VISIBLE);
                debDiP4.setVisibility(View.VISIBLE);
                pruniP4.setVisibility(View.VISIBLE);
                pesDiP4.setVisibility(View.VISIBLE);
                weediP4.setVisibility(View.VISIBLE);
                harveP4.setVisibility(View.VISIBLE);
                shadeP4.setVisibility(View.VISIBLE);
                soilCP4.setVisibility(View.VISIBLE);
                orgMaP4.setVisibility(View.VISIBLE);
                fertFP4.setVisibility(View.VISIBLE);
                fertAP4.setVisibility(View.VISIBLE);
                limeNP4.setVisibility(View.VISIBLE);
                drainP4.setVisibility(View.VISIBLE);
                filliP4.setVisibility(View.VISIBLE);
                hireNP4.setVisibility(View.VISIBLE);
                ph4.setVisibility(View.VISIBLE);
                geneticP4.setVisibility(View.VISIBLE);
                gapP4.setVisibility(View.VISIBLE);
                soilFertMng4.setVisibility(View.VISIBLE);
                calc4.setVisibility(View.VISIBLE);
            }
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                Lp5.setVisibility(View.VISIBLE);
                gpsP5.setVisibility(View.VISIBLE);
                ageP5.setVisibility(View.VISIBLE);
                areP5.setVisibility(View.VISIBLE);
                cteP5.setVisibility(View.VISIBLE);
                estP5.setVisibility(View.VISIBLE);
                steP5.setVisibility(View.VISIBLE);
                plantP5.setVisibility(View.VISIBLE);
                fcondP5.setVisibility(View.VISIBLE);
                tehelP5.setVisibility(View.VISIBLE);
                debDiP5.setVisibility(View.VISIBLE);
                pruniP5.setVisibility(View.VISIBLE);
                pesDiP5.setVisibility(View.VISIBLE);
                weediP5.setVisibility(View.VISIBLE);
                harveP5.setVisibility(View.VISIBLE);
                shadeP5.setVisibility(View.VISIBLE);
                soilCP5.setVisibility(View.VISIBLE);
                orgMaP5.setVisibility(View.VISIBLE);
                fertFP5.setVisibility(View.VISIBLE);
                fertAP5.setVisibility(View.VISIBLE);
                limeNP5.setVisibility(View.VISIBLE);
                drainP5.setVisibility(View.VISIBLE);
                filliP5.setVisibility(View.VISIBLE);
                hireNP5.setVisibility(View.VISIBLE);
                ph5.setVisibility(View.VISIBLE);
                geneticP5.setVisibility(View.VISIBLE);
                gapP5.setVisibility(View.VISIBLE);
                soilFertMng5.setVisibility(View.VISIBLE);
                calc5.setVisibility(View.VISIBLE);
            }
            //set field
            if (sObject.getPlot1Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea1_field),
                        sObject.getPlot1Area());
            }

            //set field
            if (sObject.getPlot1Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep1_field),
                        sObject.getPlot1Age());
            }
            //set field
            if (sObject.getPlot1GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp1_field),
                        sObject.getPlot1GPS());
            }

            //set field
            if (sObject.getPlot1CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2.5x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3.5×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPlot1ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP1_field),
                        sObject.getPlot1ShadeTrees());
            }

            //set field
            if (sObject.getPlot1Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP1_field),
                        sObject.getPlot1Yield());
            }

            //set field
            if (sObject.getPlantingMaterial1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition1().isEmpty()){
                setText((EditText) findViewById(R.id.farmConditionP1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.farmConditionP1_field),
                        sObject.getFarmCondition1());
            }

            //set field
            if (sObject.getTreeHealth1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed1().isEmpty()){
                setText((EditText) findViewById(R.id.limeP1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.limeP1_field),
                        sObject.getLimeNeed1());
            }

            //set field
            if (sObject.getDrainageNeed1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption1().isEmpty()){
                setText((EditText) findViewById(R.id.fillingP1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.fillingP1_field),
                        sObject.getFillingOption1());
            }

            //set field
            if (sObject.getHireLabor1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot2Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea2_field),
                        sObject.getPlot2Area());
            }

            //set field
            if (sObject.getPlot2Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep2_field),
                        sObject.getPlot2Age());
            }
            //set field
            if (sObject.getPlot2GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp2_field),
                        sObject.getPlot2GPS());
            }

            //set field
            if (sObject.getPlot2CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2.5x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3.5×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPlot2ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP2_field),
                        sObject.getPlot2ShadeTrees());
            }

            //set field
            if (sObject.getPlot2Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP2_field),
                        sObject.getPlot2Yield());
            }

            //set field
            if (sObject.getPlantingMaterial2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition2().isEmpty()){
                setText((EditText) findViewById(R.id.farmConditionP2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.farmConditionP2_field),
                        sObject.getFarmCondition2());
            }

            //set field
            if (sObject.getTreeHealth2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFartilizerApplication2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFartilizerApplication2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFartilizerApplication2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed2().isEmpty()){
                setText((EditText) findViewById(R.id.limeP2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.limeP2_field),
                        sObject.getLimeNeed2());
            }

            //set field
            if (sObject.getDrainageNeed2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption2().isEmpty()){
                setText((EditText) findViewById(R.id.fillingP2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.fillingP2_field),
                        sObject.getFillingOption2());
            }


            //set field
            if (sObject.getHireLabor2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot3Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea3_field),
                        sObject.getPlot3Area());
            }

            //set field
            if (sObject.getPlot3Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep3_field),
                        sObject.getPlot3Age());
            }
            //set field
            if (sObject.getPlot3GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp3_field),
                        sObject.getPlot3GPS());
            }

            //set field
            if (sObject.getPlot3CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2.5x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3.5×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPlot3ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP3_field),
                        sObject.getPlot3ShadeTrees());
            }

            //set field
            if (sObject.getPlot3Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP3_field),
                        sObject.getPlot3Yield());
            }

            //set field
            if (sObject.getPlantingMaterial3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition3().isEmpty()){
                setText((EditText) findViewById(R.id.farmConditionP3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.farmConditionP3_field),
                        sObject.getFarmCondition3());
            }

            //set field
            if (sObject.getTreeHealth3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed3().isEmpty()){
                setText((EditText) findViewById(R.id.limeP3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.limeP3_field),
                        sObject.getLimeNeed3());
            }


            //set field
            if (sObject.getDrainageNeed3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption3().isEmpty()){
                setText((EditText) findViewById(R.id.fillingP3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.fillingP3_field),
                        sObject.getFillingOption3());
            }

            //set field
            if (sObject.getHireLabor3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot4Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea4_field),
                        sObject.getPlot4Area());
            }

            //set field
            if (sObject.getPlot4Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep4_field),
                        sObject.getPlot4Age());
            }
            //set field
            if (sObject.getPlot4GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp4_field),
                        sObject.getPlot4GPS());
            }

            //set field
            if (sObject.getPlot4CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2.5x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3.5×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPlot4ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP4_field),
                        sObject.getPlot4ShadeTrees());
            }

            //set field
            if (sObject.getPlot4Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP4_field),
                        sObject.getPlot4Yield());
            }

            //set field
            if (sObject.getPlantingMaterial4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition4().isEmpty()){
                setText((EditText) findViewById(R.id.farmConditionP4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.farmConditionP4_field),
                        sObject.getFarmCondition4());
            }

            //set field
            if (sObject.getTreeHealth4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.geLimeNeed4().isEmpty()){
                setText((EditText) findViewById(R.id.limeP4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.limeP4_field),
                        sObject.geLimeNeed4());
            }

            //set field
            if (sObject.getDrainageNeed4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption4().isEmpty()){
                setText((EditText) findViewById(R.id.fillingP4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.fillingP4_field),
                        sObject.getFillingOption4());
            }

            //set field
            if (sObject.getHireLabor4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot5Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea5_field),
                        sObject.getPlot5Area());
            }

            //set field
            if (sObject.getPlot5Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep5_field),
                        sObject.getPlot5Age());
            }
            //set field
            if (sObject.getPlot5GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp5_field),
                        sObject.getPlot5GPS());
            }

            //set field
            if (sObject.getPlot5CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2.5x3")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3.5×4")) {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.cocoaTreesP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPlot5ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP5_field),
                        sObject.getPlot5ShadeTrees());
            }

            //set field
            if (sObject.getPlot5Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP5_field),
                        sObject.getPlot5Yield());
            }

            //set field
            if (sObject.getPlantingMaterial5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition5().isEmpty()){
                setText((EditText) findViewById(R.id.farmConditionP5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.farmConditionP5_field),
                        sObject.getFarmCondition5());
            }

            //set field
            if (sObject.getTreeHealth5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed5().isEmpty()){
                setText((EditText) findViewById(R.id.limeP5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.limeP5_field),
                        sObject.getLimeNeed5());
            }

            //set field
            if (sObject.getDrainageNeed5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption5().isEmpty()){
                setText((EditText) findViewById(R.id.fillingP5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.fillingP5_field),
                        sObject.getFillingOption5());
            }

            //set field
            if (sObject.getHireLabor5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPH1().isEmpty()){
                setText((EditText) findViewById(R.id.ph1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.ph1_field),
                        sObject.getPH1());
            }

            //set field
            if (sObject.getPH2().isEmpty()){
                setText((EditText) findViewById(R.id.ph2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.ph2_field),
                        sObject.getPH2());
            }

            //set field
            if (sObject.getPH3().isEmpty()){
                setText((EditText) findViewById(R.id.ph3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.ph3_field),
                        sObject.getPH3());
            }

            //set field
            if (sObject.getPH4().isEmpty()){
                setText((EditText) findViewById(R.id.ph4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.ph4_field),
                        sObject.getPH4());
            }

            //set field
            if (sObject.getPH5().isEmpty()){
                setText((EditText) findViewById(R.id.ph5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.ph5_field),
                        sObject.getPH5());
            }

            //set field genetics
            if (sObject.getGENETIC1().isEmpty()){
                setText((EditText) findViewById(R.id.geneticP1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.geneticP1_field),
                        sObject.getGENETIC1());
            }

            if (sObject.getGENETIC2().isEmpty()){
                setText((EditText) findViewById(R.id.geneticP2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.geneticP2_field),
                        sObject.getGENETIC2());
            }

            if (sObject.getGENETIC3().isEmpty()){
                setText((EditText) findViewById(R.id.geneticP3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.geneticP3_field),
                        sObject.getGENETIC3());
            }

            if (sObject.getGENETIC4().isEmpty()){
                setText((EditText) findViewById(R.id.geneticP4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.geneticP4_field),
                        sObject.getGENETIC4());
            }

            if (sObject.getGENETIC5().isEmpty()){
                setText((EditText) findViewById(R.id.geneticP5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.geneticP5_field),
                        sObject.getGENETIC5());
            }

            //set field gaps
            if (sObject.getGAP1().isEmpty()){
                setText((EditText) findViewById(R.id.gapP1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.gapP1_field),
                        sObject.getGAP1());
            }

            if (sObject.getGAP2().isEmpty()){
                setText((EditText) findViewById(R.id.gapP2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.gapP2_field),
                        sObject.getGAP2());
            }

            if (sObject.getGAP3().isEmpty()){
                setText((EditText) findViewById(R.id.gapP3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.gapP3_field),
                        sObject.getGAP3());
            }

            if (sObject.getGAP4().isEmpty()){
                setText((EditText) findViewById(R.id.gapP4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.gapP4_field),
                        sObject.getGAP4());
            }

            if (sObject.getGAP5().isEmpty()){
                setText((EditText) findViewById(R.id.gapP5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.gapP5_field),
                        sObject.getGAP5());
            }

            //set field soil fertility mng
            if (sObject.getSOILMNG1().isEmpty()){
                setText((EditText) findViewById(R.id.soilFertMng1_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.soilFertMng1_field),
                        sObject.getSOILMNG1());
            }

            if (sObject.getSOILMNG2().isEmpty()){
                setText((EditText) findViewById(R.id.soilFertMng2_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.soilFertMng2_field),
                        sObject.getSOILMNG2());
            }

            if (sObject.getSOILMNG3().isEmpty()){
                setText((EditText) findViewById(R.id.soilFertMng3_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.soilFertMng3_field),
                        sObject.getSOILMNG3());
            }

            if (sObject.getSOILMNG4().isEmpty()){
                setText((EditText) findViewById(R.id.soilFertMng4_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.soilFertMng4_field),
                        sObject.getSOILMNG4());
            }

            if (sObject.getSOILMNG5().isEmpty()){
                setText((EditText) findViewById(R.id.soilFertMng5_field),"N/A");
            }else {
                setText((EditText) findViewById(R.id.soilFertMng5_field),
                        sObject.getSOILMNG5());
            }
        }
    }

    private void setText(EditText textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String gpsp1 = ((EditText) findViewById(R.id.gpsp1_field)).getText().toString();
        final String plotAgep1 = ((EditText) findViewById(R.id.plotAgep1_field)).getText().toString();
        final String plotArea1 = ((EditText) findViewById(R.id.plotArea1_field)).getText().toString();
        final String cocoaTreesP1 = ((Spinner) findViewById(R.id.cocoaTreesP1_field)).getSelectedItem().toString();
        final String estimatedP1 = ((EditText) findViewById(R.id.estimatedP1_field)).getText().toString();
        final String shadeTreesP1 = ((EditText) findViewById(R.id.shadeTreesP1_field)).getText().toString();
        final String plantingP1 = ((Spinner) findViewById(R.id.plantingP1_field)).getSelectedItem().toString();
        final String farmConditionP1 = ((EditText) findViewById(R.id.farmConditionP1_field)).getText().toString();
        final String treeHealthP1 = ((Spinner) findViewById(R.id.treeHealthP1_field)).getSelectedItem().toString();
        final String debilitationP1 = ((Spinner) findViewById(R.id.debilitationP1_field)).getSelectedItem().toString();
        final String pruningP1 = ((Spinner) findViewById(R.id.pruningP1_field)).getSelectedItem().toString();
        final String pestDiseaseP1 = ((Spinner) findViewById(R.id.pestDiseaseP1_field)).getSelectedItem().toString();
        final String weedingP1 = ((Spinner) findViewById(R.id.weedingP1_field)).getSelectedItem().toString();
        final String harvestingP1 = ((Spinner) findViewById(R.id.harvestingP1_field)).getSelectedItem().toString();
        final String shadeManagementP1 = ((Spinner) findViewById(R.id.shadeManagementP1_field)).getSelectedItem().toString();
        final String soilConditionP1 = ((Spinner) findViewById(R.id.soilConditionP1_field)).getSelectedItem().toString();
        final String organicMatterP1 = ((Spinner) findViewById(R.id.organicMatterP1_field)).getSelectedItem().toString();
        final String fertFormP1 = ((Spinner) findViewById(R.id.fartFormP1_field)).getSelectedItem().toString();
        final String fertApplicationP1 = ((Spinner) findViewById(R.id.fartApplicationP1_field)).getSelectedItem().toString();
        final String limeP1 = ((EditText) findViewById(R.id.limeP1_field)).getText().toString();
        final String drainageP1 = ((Spinner) findViewById(R.id.drainageP1_field)).getSelectedItem().toString();
        final String fillingP1 = ((EditText) findViewById(R.id.fillingP1_field)).getText().toString();
        final String hireP1 = ((Spinner) findViewById(R.id.hireP1_field)).getSelectedItem().toString();
        final String gpsp2 = ((EditText) findViewById(R.id.gpsp2_field)).getText().toString();
        final String plotAgep2 = ((EditText) findViewById(R.id.plotAgep2_field)).getText().toString();
        final String plotArea2 = ((EditText) findViewById(R.id.plotArea2_field)).getText().toString();
        final String cocoaTreesP2 = ((Spinner) findViewById(R.id.cocoaTreesP2_field)).getSelectedItem().toString();
        final String estimatedP2 = ((EditText) findViewById(R.id.estimatedP2_field)).getText().toString();
        final String shadeTreesP2 = ((EditText) findViewById(R.id.shadeTreesP2_field)).getText().toString();
        final String plantingP2 = ((Spinner) findViewById(R.id.plantingP2_field)).getSelectedItem().toString();
        final String farmConditionP2 = ((EditText) findViewById(R.id.farmConditionP2_field)).getText().toString();
        final String treeHealthP2 = ((Spinner) findViewById(R.id.treeHealthP2_field)).getSelectedItem().toString();
        final String debilitationP2 = ((Spinner) findViewById(R.id.debilitationP2_field)).getSelectedItem().toString();
        final String pruningP2 = ((Spinner) findViewById(R.id.pruningP2_field)).getSelectedItem().toString();
        final String pestDiseaseP2 = ((Spinner) findViewById(R.id.pestDiseaseP2_field)).getSelectedItem().toString();
        final String weedingP2 = ((Spinner) findViewById(R.id.weedingP2_field)).getSelectedItem().toString();
        final String harvestingP2 = ((Spinner) findViewById(R.id.harvestingP2_field)).getSelectedItem().toString();
        final String shadeManagementP2 = ((Spinner) findViewById(R.id.shadeManagementP2_field)).getSelectedItem().toString();
        final String soilConditionP2 = ((Spinner) findViewById(R.id.soilConditionP2_field)).getSelectedItem().toString();
        final String organicMatterP2 = ((Spinner) findViewById(R.id.organicMatterP2_field)).getSelectedItem().toString();
        final String fertFormP2 = ((Spinner) findViewById(R.id.fartFormP2_field)).getSelectedItem().toString();
        final String fertApplicationP2 = ((Spinner) findViewById(R.id.fartApplicationP2_field)).getSelectedItem().toString();
        final String limeP2 = ((EditText) findViewById(R.id.limeP2_field)).getText().toString();
        final String drainageP2 = ((Spinner) findViewById(R.id.drainageP2_field)).getSelectedItem().toString();
        final String fillingP2 = ((EditText) findViewById(R.id.fillingP2_field)).getText().toString();
        final String hireP2 = ((Spinner) findViewById(R.id.hireP2_field)).getSelectedItem().toString();
        final String gpsp3 = ((EditText) findViewById(R.id.gpsp3_field)).getText().toString();
        final String plotAgep3 = ((EditText) findViewById(R.id.plotAgep3_field)).getText().toString();
        final String plotArea3 = ((EditText) findViewById(R.id.plotArea3_field)).getText().toString();
        final String cocoaTreesP3 = ((Spinner) findViewById(R.id.cocoaTreesP3_field)).getSelectedItem().toString();
        final String estimatedP3 = ((EditText) findViewById(R.id.estimatedP3_field)).getText().toString();
        final String shadeTreesP3 = ((EditText) findViewById(R.id.shadeTreesP3_field)).getText().toString();
        final String plantingP3 = ((Spinner) findViewById(R.id.plantingP3_field)).getSelectedItem().toString();
        final String farmConditionP3 = ((EditText) findViewById(R.id.farmConditionP3_field)).getText().toString();
        final String treeHealthP3 = ((Spinner) findViewById(R.id.treeHealthP3_field)).getSelectedItem().toString();
        final String debilitationP3 = ((Spinner) findViewById(R.id.debilitationP3_field)).getSelectedItem().toString();
        final String pruningP3 = ((Spinner) findViewById(R.id.pruningP3_field)).getSelectedItem().toString();
        final String pestDiseaseP3 = ((Spinner) findViewById(R.id.pestDiseaseP3_field)).getSelectedItem().toString();
        final String weedingP3 = ((Spinner) findViewById(R.id.weedingP3_field)).getSelectedItem().toString();
        final String harvestingP3 = ((Spinner) findViewById(R.id.harvestingP3_field)).getSelectedItem().toString();
        final String shadeManagementP3 = ((Spinner) findViewById(R.id.shadeManagementP3_field)).getSelectedItem().toString();
        final String soilConditionP3 = ((Spinner) findViewById(R.id.soilConditionP3_field)).getSelectedItem().toString();
        final String organicMatterP3 = ((Spinner) findViewById(R.id.organicMatterP3_field)).getSelectedItem().toString();
        final String fertFormP3 = ((Spinner) findViewById(R.id.fartFormP3_field)).getSelectedItem().toString();
        final String fertApplicationP3 = ((Spinner) findViewById(R.id.fartApplicationP3_field)).getSelectedItem().toString();
        final String limeP3 = ((EditText) findViewById(R.id.limeP3_field)).getText().toString();
        final String drainageP3 = ((Spinner) findViewById(R.id.drainageP3_field)).getSelectedItem().toString();
        final String fillingP3 = ((EditText) findViewById(R.id.fillingP3_field)).getText().toString();
        final String hireP3 = ((Spinner) findViewById(R.id.hireP3_field)).getSelectedItem().toString();
        final String gpsp4 = ((EditText) findViewById(R.id.gpsp4_field)).getText().toString();
        final String plotAgep4 = ((EditText) findViewById(R.id.plotAgep4_field)).getText().toString();
        final String plotArea4 = ((EditText) findViewById(R.id.plotArea4_field)).getText().toString();
        final String cocoaTreesP4 = ((Spinner) findViewById(R.id.cocoaTreesP4_field)).getSelectedItem().toString();
        final String estimatedP4 = ((EditText) findViewById(R.id.estimatedP4_field)).getText().toString();
        final String shadeTreesP4 = ((EditText) findViewById(R.id.shadeTreesP4_field)).getText().toString();
        final String plantingP4 = ((Spinner) findViewById(R.id.plantingP4_field)).getSelectedItem().toString();
        final String farmConditionP4 = ((EditText) findViewById(R.id.farmConditionP4_field)).getText().toString();
        final String treeHealthP4 = ((Spinner) findViewById(R.id.treeHealthP4_field)).getSelectedItem().toString();
        final String debilitationP4 = ((Spinner) findViewById(R.id.debilitationP4_field)).getSelectedItem().toString();
        final String pruningP4 = ((Spinner) findViewById(R.id.pruningP4_field)).getSelectedItem().toString();
        final String pestDiseaseP4 = ((Spinner) findViewById(R.id.pestDiseaseP4_field)).getSelectedItem().toString();
        final String weedingP4 = ((Spinner) findViewById(R.id.weedingP4_field)).getSelectedItem().toString();
        final String harvestingP4 = ((Spinner) findViewById(R.id.harvestingP4_field)).getSelectedItem().toString();
        final String shadeManagementP4 = ((Spinner) findViewById(R.id.shadeManagementP4_field)).getSelectedItem().toString();
        final String soilConditionP4 = ((Spinner) findViewById(R.id.soilConditionP4_field)).getSelectedItem().toString();
        final String organicMatterP4 = ((Spinner) findViewById(R.id.organicMatterP4_field)).getSelectedItem().toString();
        final String fertFormP4 = ((Spinner) findViewById(R.id.fartFormP4_field)).getSelectedItem().toString();
        final String fertApplicationP4 = ((Spinner) findViewById(R.id.fartApplicationP4_field)).getSelectedItem().toString();
        final String limeP4 = ((EditText) findViewById(R.id.limeP4_field)).getText().toString();
        final String drainageP4 = ((Spinner) findViewById(R.id.drainageP4_field)).getSelectedItem().toString();
        final String fillingP4 = ((EditText) findViewById(R.id.fillingP4_field)).getText().toString();
        final String hireP4 = ((Spinner) findViewById(R.id.hireP4_field)).getSelectedItem().toString();
        final String gpsp5 = ((EditText) findViewById(R.id.gpsp5_field)).getText().toString();
        final String plotAgep5 = ((EditText) findViewById(R.id.plotAgep5_field)).getText().toString();
        final String plotArea5 = ((EditText) findViewById(R.id.plotArea5_field)).getText().toString();
        final String cocoaTreesP5 = ((Spinner) findViewById(R.id.cocoaTreesP5_field)).getSelectedItem().toString();
        final String estimatedP5 = ((EditText) findViewById(R.id.estimatedP5_field)).getText().toString();
        final String shadeTreesP5 = ((EditText) findViewById(R.id.shadeTreesP5_field)).getText().toString();
        final String plantingP5 = ((Spinner) findViewById(R.id.plantingP5_field)).getSelectedItem().toString();
        final String farmConditionP5 = ((EditText) findViewById(R.id.farmConditionP5_field)).getText().toString();
        final String treeHealthP5 = ((Spinner) findViewById(R.id.treeHealthP5_field)).getSelectedItem().toString();
        final String debilitationP5 = ((Spinner) findViewById(R.id.debilitationP5_field)).getSelectedItem().toString();
        final String pruningP5 = ((Spinner) findViewById(R.id.pruningP5_field)).getSelectedItem().toString();
        final String pestDiseaseP5 = ((Spinner) findViewById(R.id.pestDiseaseP5_field)).getSelectedItem().toString();
        final String weedingP5 = ((Spinner) findViewById(R.id.weedingP5_field)).getSelectedItem().toString();
        final String harvestingP5 = ((Spinner) findViewById(R.id.harvestingP5_field)).getSelectedItem().toString();
        final String shadeManagementP5 = ((Spinner) findViewById(R.id.shadeManagementP5_field)).getSelectedItem().toString();
        final String soilConditionP5 = ((Spinner) findViewById(R.id.soilConditionP5_field)).getSelectedItem().toString();
        final String organicMatterP5 = ((Spinner) findViewById(R.id.organicMatterP5_field)).getSelectedItem().toString();
        final String fertFormP5 = ((Spinner) findViewById(R.id.fartFormP5_field)).getSelectedItem().toString();
        final String fertApplicationP5 = ((Spinner) findViewById(R.id.fartApplicationP5_field)).getSelectedItem().toString();
        final String limeP5 = ((EditText) findViewById(R.id.limeP5_field)).getText().toString();
        final String drainageP5 = ((Spinner) findViewById(R.id.drainageP5_field)).getSelectedItem().toString();
        final String fillingP5 = ((EditText) findViewById(R.id.fillingP5_field)).getText().toString();
        final String hireP5 = ((Spinner) findViewById(R.id.hireP5_field)).getSelectedItem().toString();
        final String ph1 = ((EditText) findViewById(R.id.ph1_field)).getText().toString();
        final String ph2 = ((EditText) findViewById(R.id.ph2_field)).getText().toString();
        final String ph3 = ((EditText) findViewById(R.id.ph3_field)).getText().toString();
        final String ph4 = ((EditText) findViewById(R.id.ph4_field)).getText().toString();
        final String ph5 = ((EditText) findViewById(R.id.ph5_field)).getText().toString();
        final String genetic1 = ((EditText) findViewById(R.id.geneticP1_field)).getText().toString();
        final String genetic2 = ((EditText) findViewById(R.id.geneticP2_field)).getText().toString();
        final String genetic3 = ((EditText) findViewById(R.id.geneticP3_field)).getText().toString();
        final String genetic4 = ((EditText) findViewById(R.id.geneticP4_field)).getText().toString();
        final String genetic5 = ((EditText) findViewById(R.id.geneticP5_field)).getText().toString();
        final String gap1 = ((EditText) findViewById(R.id.gapP1_field)).getText().toString();
        final String gap2 = ((EditText) findViewById(R.id.gapP2_field)).getText().toString();
        final String gap3 = ((EditText) findViewById(R.id.gapP3_field)).getText().toString();
        final String gap4 = ((EditText) findViewById(R.id.gapP4_field)).getText().toString();
        final String gap5 = ((EditText) findViewById(R.id.gapP5_field)).getText().toString();
        final String soilft1 = ((EditText) findViewById(R.id.soilFertMng1_field)).getText().toString();
        final String soilft2 = ((EditText) findViewById(R.id.soilFertMng2_field)).getText().toString();
        final String soilft3 = ((EditText) findViewById(R.id.soilFertMng3_field)).getText().toString();
        final String soilft4 = ((EditText) findViewById(R.id.soilFertMng4_field)).getText().toString();
        final String soilft5 = ((EditText) findViewById(R.id.soilFertMng5_field)).getText().toString();
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
            contact.put(ContactObject.PLOT1GPS, gpsp1);
            contact.put(ContactObject.PLOT1AGE, plotAgep1);
            contact.put(ContactObject.PLOT1AREA, plotArea1);
            contact.put(ContactObject.PLOT1COCOATREES, cocoaTreesP1);
            contact.put(ContactObject.PLOT1YIELD, estimatedP1);
            contact.put(ContactObject.PLOT1SHADETREES, shadeTreesP1);
            contact.put(ContactObject.PLANTINGMATERIAL1, plantingP1);
            contact.put(ContactObject.FARMCONDITION1, farmConditionP1);
            contact.put(ContactObject.TREEHEALTH1, treeHealthP1);
            contact.put(ContactObject.DEBILITATINGDISEASE1, debilitationP1);
            contact.put(ContactObject.PRUNING1, pruningP1);
            contact.put(ContactObject.PESTDISEASESANITATION1, pestDiseaseP1);
            contact.put(ContactObject.WEEDING1, weedingP1);
            contact.put(ContactObject.HARVESTING1, harvestingP1);
            contact.put(ContactObject.SHADEMANAGEMENT1, shadeManagementP1);
            contact.put(ContactObject.SOILCONDITION1, soilConditionP1);
            contact.put(ContactObject.ORGANICMATTER1, organicMatterP1);
            contact.put(ContactObject.FERTILIZERFORMULATION1, fertFormP1);
            contact.put(ContactObject.FERTILIZERAPPLICATION1, fertApplicationP1);
            contact.put(ContactObject.LIMENEED1, limeP1);
            contact.put(ContactObject.DRAINAGENEED1, drainageP1);
            contact.put(ContactObject.FILLINGOPTION1, fillingP1);
            contact.put(ContactObject.HIRELABOR1, hireP1);
            contact.put(ContactObject.PLOT2GPS, gpsp2);
            contact.put(ContactObject.PLOT2AGE, plotAgep2);
            contact.put(ContactObject.PLOT2AREA, plotArea2);
            contact.put(ContactObject.PLOT2COCOATREES, cocoaTreesP2);
            contact.put(ContactObject.PLOT2YIELD, estimatedP2);
            contact.put(ContactObject.PLOT2SHADETREES, shadeTreesP2);
            contact.put(ContactObject.PLANTINGMATERIAL2, plantingP2);
            contact.put(ContactObject.FARMCONDITION2, farmConditionP2);
            contact.put(ContactObject.TREEHEALTH2, treeHealthP2);
            contact.put(ContactObject.DEBILITATINGDISEASE2, debilitationP2);
            contact.put(ContactObject.PRUNING2, pruningP2);
            contact.put(ContactObject.PESTDISEASESANITATION2, pestDiseaseP2);
            contact.put(ContactObject.WEEDING2, weedingP2);
            contact.put(ContactObject.HARVESTING2, harvestingP2);
            contact.put(ContactObject.SHADEMANAGEMENT2, shadeManagementP2);
            contact.put(ContactObject.SOILCONDITION2, soilConditionP2);
            contact.put(ContactObject.ORGANICMATTER2, organicMatterP2);
            contact.put(ContactObject.FERTILIZERFORMULATION2, fertFormP2);
            contact.put(ContactObject.FERTILIZERAPPLICATION2, fertApplicationP2);
            contact.put(ContactObject.LIMENEED2, limeP2);
            contact.put(ContactObject.DRAINAGENEED2, drainageP2);
            contact.put(ContactObject.FILLINGOPTION2, fillingP2);
            contact.put(ContactObject.HIRELABOR2, hireP2);
            contact.put(ContactObject.PLOT3GPS, gpsp3);
            contact.put(ContactObject.PLOT3AGE, plotAgep3);
            contact.put(ContactObject.PLOT3AREA, plotArea3);
            contact.put(ContactObject.PLOT3COCOATREES, cocoaTreesP3);
            contact.put(ContactObject.PLOT3YIELD, estimatedP3);
            contact.put(ContactObject.PLOT3SHADETREES, shadeTreesP3);
            contact.put(ContactObject.PLANTINGMATERIAL3, plantingP3);
            contact.put(ContactObject.FARMCONDITION3, farmConditionP3);
            contact.put(ContactObject.TREEHEALTH3, treeHealthP3);
            contact.put(ContactObject.DEBILITATINGDISEASE3, debilitationP3);
            contact.put(ContactObject.PRUNING3, pruningP3);
            contact.put(ContactObject.PESTDISEASESANITATION3, pestDiseaseP3);
            contact.put(ContactObject.WEEDING3, weedingP3);
            contact.put(ContactObject.HARVESTING3, harvestingP3);
            contact.put(ContactObject.SHADEMANAGEMENT3, shadeManagementP3);
            contact.put(ContactObject.SOILCONDITION3, soilConditionP3);
            contact.put(ContactObject.ORGANICMATTER3, organicMatterP3);
            contact.put(ContactObject.FERTILIZERFORMULATION3, fertFormP3);
            contact.put(ContactObject.FERTILIZERAPPLICATION3, fertApplicationP3);
            contact.put(ContactObject.LIMENEED3, limeP3);
            contact.put(ContactObject.DRAINAGENEED3, drainageP3);
            contact.put(ContactObject.FILLINGOPTION3, fillingP3);
            contact.put(ContactObject.HIRELABOR3, hireP3);
            contact.put(ContactObject.PLOT4GPS, gpsp4);
            contact.put(ContactObject.PLOT4AGE, plotAgep4);
            contact.put(ContactObject.PLOT4AREA, plotArea4);
            contact.put(ContactObject.PLOT4COCOATREES, cocoaTreesP4);
            contact.put(ContactObject.PLOT4YIELD, estimatedP4);
            contact.put(ContactObject.PLOT4SHADETREES, shadeTreesP4);
            contact.put(ContactObject.PLANTINGMATERIAL4, plantingP4);
            contact.put(ContactObject.FARMCONDITION4, farmConditionP4);
            contact.put(ContactObject.TREEHEALTH4, treeHealthP4);
            contact.put(ContactObject.DEBILITATINGDISEASE4, debilitationP4);
            contact.put(ContactObject.PRUNING4, pruningP4);
            contact.put(ContactObject.PESTDISEASESANITATION4, pestDiseaseP4);
            contact.put(ContactObject.WEEDING4, weedingP4);
            contact.put(ContactObject.HARVESTING4, harvestingP4);
            contact.put(ContactObject.SHADEMANAGEMENT4, shadeManagementP4);
            contact.put(ContactObject.SOILCONDITION4, soilConditionP4);
            contact.put(ContactObject.ORGANICMATTER4, organicMatterP4);
            contact.put(ContactObject.FERTILIZERFORMULATION4, fertFormP4);
            contact.put(ContactObject.FERTILIZERAPPLICATION4, fertApplicationP4);
            contact.put(ContactObject.LIMENEED4, limeP4);
            contact.put(ContactObject.DRAINAGENEED4, drainageP4);
            contact.put(ContactObject.FILLINGOPTION4, fillingP4);
            contact.put(ContactObject.HIRELABOR4, hireP4);
            contact.put(ContactObject.PLOT5GPS, gpsp5);
            contact.put(ContactObject.PLOT5AGE, plotAgep5);
            contact.put(ContactObject.PLOT5AREA, plotArea5);
            contact.put(ContactObject.PLOT5COCOATREES, cocoaTreesP5);
            contact.put(ContactObject.PLOT5YIELD, estimatedP5);
            contact.put(ContactObject.PLOT5SHADETREES, shadeTreesP5);
            contact.put(ContactObject.PLANTINGMATERIAL5, plantingP5);
            contact.put(ContactObject.FARMCONDITION5, farmConditionP5);
            contact.put(ContactObject.TREEHEALTH5, treeHealthP5);
            contact.put(ContactObject.DEBILITATINGDISEASE5, debilitationP5);
            contact.put(ContactObject.PRUNING5, pruningP5);
            contact.put(ContactObject.PESTDISEASESANITATION5, pestDiseaseP5);
            contact.put(ContactObject.WEEDING5, weedingP5);
            contact.put(ContactObject.HARVESTING5, harvestingP5);
            contact.put(ContactObject.SHADEMANAGEMENT5, shadeManagementP5);
            contact.put(ContactObject.SOILCONDITION5, soilConditionP5);
            contact.put(ContactObject.ORGANICMATTER5, organicMatterP5);
            contact.put(ContactObject.FERTILIZERFORMULATION5, fertFormP5);
            contact.put(ContactObject.FERTILIZERAPPLICATION5, fertApplicationP5);
            contact.put(ContactObject.LIMENEED5, limeP5);
            contact.put(ContactObject.DRAINAGENEED5, drainageP5);
            contact.put(ContactObject.FILLINGOPTION5, fillingP5);
            contact.put(ContactObject.HIRELABOR5, hireP5);
            contact.put(ContactObject.PH1, ph1);
            contact.put(ContactObject.PH2, ph2);
            contact.put(ContactObject.PH3, ph3);
            contact.put(ContactObject.PH4, ph4);
            contact.put(ContactObject.PH5, ph5);
            contact.put(ContactObject.GENETIC1,genetic1);
            contact.put(ContactObject.GENETIC2,genetic2);
            contact.put(ContactObject.GENETIC3,genetic3);
            contact.put(ContactObject.GENETIC4,genetic4);
            contact.put(ContactObject.GENETIC5,genetic5);
            contact.put(ContactObject.GAP1,gap1);
            contact.put(ContactObject.GAP2,gap2);
            contact.put(ContactObject.GAP3,gap3);
            contact.put(ContactObject.GAP4,gap4);
            contact.put(ContactObject.GAP5,gap5);
            contact.put(ContactObject.SOILMNG1,soilft1);
            contact.put(ContactObject.SOILMNG2,soilft2);
            contact.put(ContactObject.SOILMNG3,soilft3);
            contact.put(ContactObject.SOILMNG4,soilft4);
            contact.put(ContactObject.SOILMNG5,soilft5);
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

    private void partialSave() {
        final String gpsp1 = ((EditText) findViewById(R.id.gpsp1_field)).getText().toString();
        final String plotAgep1 = ((EditText) findViewById(R.id.plotAgep1_field)).getText().toString();
        final String plotArea1 = ((EditText) findViewById(R.id.plotArea1_field)).getText().toString();
        final String cocoaTreesP1 = ((Spinner) findViewById(R.id.cocoaTreesP1_field)).getSelectedItem().toString();
        final String estimatedP1 = ((EditText) findViewById(R.id.estimatedP1_field)).getText().toString();
        final String shadeTreesP1 = ((EditText) findViewById(R.id.shadeTreesP1_field)).getText().toString();
        final String plantingP1 = ((Spinner) findViewById(R.id.plantingP1_field)).getSelectedItem().toString();
        final String farmConditionP1 = ((EditText) findViewById(R.id.farmConditionP1_field)).getText().toString();
        final String treeHealthP1 = ((Spinner) findViewById(R.id.treeHealthP1_field)).getSelectedItem().toString();
        final String debilitationP1 = ((Spinner) findViewById(R.id.debilitationP1_field)).getSelectedItem().toString();
        final String pruningP1 = ((Spinner) findViewById(R.id.pruningP1_field)).getSelectedItem().toString();
        final String pestDiseaseP1 = ((Spinner) findViewById(R.id.pestDiseaseP1_field)).getSelectedItem().toString();
        final String weedingP1 = ((Spinner) findViewById(R.id.weedingP1_field)).getSelectedItem().toString();
        final String harvestingP1 = ((Spinner) findViewById(R.id.harvestingP1_field)).getSelectedItem().toString();
        final String shadeManagementP1 = ((Spinner) findViewById(R.id.shadeManagementP1_field)).getSelectedItem().toString();
        final String soilConditionP1 = ((Spinner) findViewById(R.id.soilConditionP1_field)).getSelectedItem().toString();
        final String organicMatterP1 = ((Spinner) findViewById(R.id.organicMatterP1_field)).getSelectedItem().toString();
        final String fertFormP1 = ((Spinner) findViewById(R.id.fartFormP1_field)).getSelectedItem().toString();
        final String fertApplicationP1 = ((Spinner) findViewById(R.id.fartApplicationP1_field)).getSelectedItem().toString();
        final String limeP1 = ((EditText) findViewById(R.id.limeP1_field)).getText().toString();
        final String drainageP1 = ((Spinner) findViewById(R.id.drainageP1_field)).getSelectedItem().toString();
        final String fillingP1 = ((EditText) findViewById(R.id.fillingP1_field)).getText().toString();
        final String hireP1 = ((Spinner) findViewById(R.id.hireP1_field)).getSelectedItem().toString();
        final String gpsp2 = ((EditText) findViewById(R.id.gpsp2_field)).getText().toString();
        final String plotAgep2 = ((EditText) findViewById(R.id.plotAgep2_field)).getText().toString();
        final String plotArea2 = ((EditText) findViewById(R.id.plotArea2_field)).getText().toString();
        final String cocoaTreesP2 = ((Spinner) findViewById(R.id.cocoaTreesP2_field)).getSelectedItem().toString();
        final String estimatedP2 = ((EditText) findViewById(R.id.estimatedP2_field)).getText().toString();
        final String shadeTreesP2 = ((EditText) findViewById(R.id.shadeTreesP2_field)).getText().toString();
        final String plantingP2 = ((Spinner) findViewById(R.id.plantingP2_field)).getSelectedItem().toString();
        final String farmConditionP2 = ((EditText) findViewById(R.id.farmConditionP2_field)).getText().toString();
        final String treeHealthP2 = ((Spinner) findViewById(R.id.treeHealthP2_field)).getSelectedItem().toString();
        final String debilitationP2 = ((Spinner) findViewById(R.id.debilitationP2_field)).getSelectedItem().toString();
        final String pruningP2 = ((Spinner) findViewById(R.id.pruningP2_field)).getSelectedItem().toString();
        final String pestDiseaseP2 = ((Spinner) findViewById(R.id.pestDiseaseP2_field)).getSelectedItem().toString();
        final String weedingP2 = ((Spinner) findViewById(R.id.weedingP2_field)).getSelectedItem().toString();
        final String harvestingP2 = ((Spinner) findViewById(R.id.harvestingP2_field)).getSelectedItem().toString();
        final String shadeManagementP2 = ((Spinner) findViewById(R.id.shadeManagementP2_field)).getSelectedItem().toString();
        final String soilConditionP2 = ((Spinner) findViewById(R.id.soilConditionP2_field)).getSelectedItem().toString();
        final String organicMatterP2 = ((Spinner) findViewById(R.id.organicMatterP2_field)).getSelectedItem().toString();
        final String fertFormP2 = ((Spinner) findViewById(R.id.fartFormP2_field)).getSelectedItem().toString();
        final String fertApplicationP2 = ((Spinner) findViewById(R.id.fartApplicationP2_field)).getSelectedItem().toString();
        final String limeP2 = ((EditText) findViewById(R.id.limeP2_field)).getText().toString();
        final String drainageP2 = ((Spinner) findViewById(R.id.drainageP2_field)).getSelectedItem().toString();
        final String fillingP2 = ((EditText) findViewById(R.id.fillingP2_field)).getText().toString();
        final String hireP2 = ((Spinner) findViewById(R.id.hireP2_field)).getSelectedItem().toString();
        final String gpsp3 = ((EditText) findViewById(R.id.gpsp3_field)).getText().toString();
        final String plotAgep3 = ((EditText) findViewById(R.id.plotAgep3_field)).getText().toString();
        final String plotArea3 = ((EditText) findViewById(R.id.plotArea3_field)).getText().toString();
        final String cocoaTreesP3 = ((Spinner) findViewById(R.id.cocoaTreesP3_field)).getSelectedItem().toString();
        final String estimatedP3 = ((EditText) findViewById(R.id.estimatedP3_field)).getText().toString();
        final String shadeTreesP3 = ((EditText) findViewById(R.id.shadeTreesP3_field)).getText().toString();
        final String plantingP3 = ((Spinner) findViewById(R.id.plantingP3_field)).getSelectedItem().toString();
        final String farmConditionP3 = ((EditText) findViewById(R.id.farmConditionP3_field)).getText().toString();
        final String treeHealthP3 = ((Spinner) findViewById(R.id.treeHealthP3_field)).getSelectedItem().toString();
        final String debilitationP3 = ((Spinner) findViewById(R.id.debilitationP3_field)).getSelectedItem().toString();
        final String pruningP3 = ((Spinner) findViewById(R.id.pruningP3_field)).getSelectedItem().toString();
        final String pestDiseaseP3 = ((Spinner) findViewById(R.id.pestDiseaseP3_field)).getSelectedItem().toString();
        final String weedingP3 = ((Spinner) findViewById(R.id.weedingP3_field)).getSelectedItem().toString();
        final String harvestingP3 = ((Spinner) findViewById(R.id.harvestingP3_field)).getSelectedItem().toString();
        final String shadeManagementP3 = ((Spinner) findViewById(R.id.shadeManagementP3_field)).getSelectedItem().toString();
        final String soilConditionP3 = ((Spinner) findViewById(R.id.soilConditionP3_field)).getSelectedItem().toString();
        final String organicMatterP3 = ((Spinner) findViewById(R.id.organicMatterP3_field)).getSelectedItem().toString();
        final String fertFormP3 = ((Spinner) findViewById(R.id.fartFormP3_field)).getSelectedItem().toString();
        final String fertApplicationP3 = ((Spinner) findViewById(R.id.fartApplicationP3_field)).getSelectedItem().toString();
        final String limeP3 = ((EditText) findViewById(R.id.limeP3_field)).getText().toString();
        final String drainageP3 = ((Spinner) findViewById(R.id.drainageP3_field)).getSelectedItem().toString();
        final String fillingP3 = ((EditText) findViewById(R.id.fillingP3_field)).getText().toString();
        final String hireP3 = ((Spinner) findViewById(R.id.hireP3_field)).getSelectedItem().toString();
        final String gpsp4 = ((EditText) findViewById(R.id.gpsp4_field)).getText().toString();
        final String plotAgep4 = ((EditText) findViewById(R.id.plotAgep4_field)).getText().toString();
        final String plotArea4 = ((EditText) findViewById(R.id.plotArea4_field)).getText().toString();
        final String cocoaTreesP4 = ((Spinner) findViewById(R.id.cocoaTreesP4_field)).getSelectedItem().toString();
        final String estimatedP4 = ((EditText) findViewById(R.id.estimatedP4_field)).getText().toString();
        final String shadeTreesP4 = ((EditText) findViewById(R.id.shadeTreesP4_field)).getText().toString();
        final String plantingP4 = ((Spinner) findViewById(R.id.plantingP4_field)).getSelectedItem().toString();
        final String farmConditionP4 = ((EditText) findViewById(R.id.farmConditionP4_field)).getText().toString();
        final String treeHealthP4 = ((Spinner) findViewById(R.id.treeHealthP4_field)).getSelectedItem().toString();
        final String debilitationP4 = ((Spinner) findViewById(R.id.debilitationP4_field)).getSelectedItem().toString();
        final String pruningP4 = ((Spinner) findViewById(R.id.pruningP4_field)).getSelectedItem().toString();
        final String pestDiseaseP4 = ((Spinner) findViewById(R.id.pestDiseaseP4_field)).getSelectedItem().toString();
        final String weedingP4 = ((Spinner) findViewById(R.id.weedingP4_field)).getSelectedItem().toString();
        final String harvestingP4 = ((Spinner) findViewById(R.id.harvestingP4_field)).getSelectedItem().toString();
        final String shadeManagementP4 = ((Spinner) findViewById(R.id.shadeManagementP4_field)).getSelectedItem().toString();
        final String soilConditionP4 = ((Spinner) findViewById(R.id.soilConditionP4_field)).getSelectedItem().toString();
        final String organicMatterP4 = ((Spinner) findViewById(R.id.organicMatterP4_field)).getSelectedItem().toString();
        final String fertFormP4 = ((Spinner) findViewById(R.id.fartFormP4_field)).getSelectedItem().toString();
        final String fertApplicationP4 = ((Spinner) findViewById(R.id.fartApplicationP4_field)).getSelectedItem().toString();
        final String limeP4 = ((EditText) findViewById(R.id.limeP4_field)).getText().toString();
        final String drainageP4 = ((Spinner) findViewById(R.id.drainageP4_field)).getSelectedItem().toString();
        final String fillingP4 = ((EditText) findViewById(R.id.fillingP4_field)).getText().toString();
        final String hireP4 = ((Spinner) findViewById(R.id.hireP4_field)).getSelectedItem().toString();
        final String gpsp5 = ((EditText) findViewById(R.id.gpsp5_field)).getText().toString();
        final String plotAgep5 = ((EditText) findViewById(R.id.plotAgep5_field)).getText().toString();
        final String plotArea5 = ((EditText) findViewById(R.id.plotArea5_field)).getText().toString();
        final String cocoaTreesP5 = ((Spinner) findViewById(R.id.cocoaTreesP5_field)).getSelectedItem().toString();
        final String estimatedP5 = ((EditText) findViewById(R.id.estimatedP5_field)).getText().toString();
        final String shadeTreesP5 = ((EditText) findViewById(R.id.shadeTreesP5_field)).getText().toString();
        final String plantingP5 = ((Spinner) findViewById(R.id.plantingP5_field)).getSelectedItem().toString();
        final String farmConditionP5 = ((EditText) findViewById(R.id.farmConditionP5_field)).getText().toString();
        final String treeHealthP5 = ((Spinner) findViewById(R.id.treeHealthP5_field)).getSelectedItem().toString();
        final String debilitationP5 = ((Spinner) findViewById(R.id.debilitationP5_field)).getSelectedItem().toString();
        final String pruningP5 = ((Spinner) findViewById(R.id.pruningP5_field)).getSelectedItem().toString();
        final String pestDiseaseP5 = ((Spinner) findViewById(R.id.pestDiseaseP5_field)).getSelectedItem().toString();
        final String weedingP5 = ((Spinner) findViewById(R.id.weedingP5_field)).getSelectedItem().toString();
        final String harvestingP5 = ((Spinner) findViewById(R.id.harvestingP5_field)).getSelectedItem().toString();
        final String shadeManagementP5 = ((Spinner) findViewById(R.id.shadeManagementP5_field)).getSelectedItem().toString();
        final String soilConditionP5 = ((Spinner) findViewById(R.id.soilConditionP5_field)).getSelectedItem().toString();
        final String organicMatterP5 = ((Spinner) findViewById(R.id.organicMatterP5_field)).getSelectedItem().toString();
        final String fertFormP5 = ((Spinner) findViewById(R.id.fartFormP5_field)).getSelectedItem().toString();
        final String fertApplicationP5 = ((Spinner) findViewById(R.id.fartApplicationP5_field)).getSelectedItem().toString();
        final String limeP5 = ((EditText) findViewById(R.id.limeP5_field)).getText().toString();
        final String drainageP5 = ((Spinner) findViewById(R.id.drainageP5_field)).getSelectedItem().toString();
        final String fillingP5 = ((EditText) findViewById(R.id.fillingP5_field)).getText().toString();
        final String hireP5 = ((Spinner) findViewById(R.id.hireP5_field)).getSelectedItem().toString();
        final String ph1 = ((EditText) findViewById(R.id.ph1_field)).getText().toString();
        final String ph2 = ((EditText) findViewById(R.id.ph2_field)).getText().toString();
        final String ph3 = ((EditText) findViewById(R.id.ph3_field)).getText().toString();
        final String ph4 = ((EditText) findViewById(R.id.ph4_field)).getText().toString();
        final String ph5 = ((EditText) findViewById(R.id.ph5_field)).getText().toString();
        final String genetic1 = ((EditText) findViewById(R.id.geneticP1_field)).getText().toString();
        final String genetic2 = ((EditText) findViewById(R.id.geneticP2_field)).getText().toString();
        final String genetic3 = ((EditText) findViewById(R.id.geneticP3_field)).getText().toString();
        final String genetic4 = ((EditText) findViewById(R.id.geneticP4_field)).getText().toString();
        final String genetic5 = ((EditText) findViewById(R.id.geneticP5_field)).getText().toString();
        final String gap1 = ((EditText) findViewById(R.id.gapP1_field)).getText().toString();
        final String gap2 = ((EditText) findViewById(R.id.gapP2_field)).getText().toString();
        final String gap3 = ((EditText) findViewById(R.id.gapP3_field)).getText().toString();
        final String gap4 = ((EditText) findViewById(R.id.gapP4_field)).getText().toString();
        final String gap5 = ((EditText) findViewById(R.id.gapP5_field)).getText().toString();
        final String soilft1 = ((EditText) findViewById(R.id.soilFertMng1_field)).getText().toString();
        final String soilft2 = ((EditText) findViewById(R.id.soilFertMng2_field)).getText().toString();
        final String soilft3 = ((EditText) findViewById(R.id.soilFertMng3_field)).getText().toString();
        final String soilft4 = ((EditText) findViewById(R.id.soilFertMng4_field)).getText().toString();
        final String soilft5 = ((EditText) findViewById(R.id.soilFertMng5_field)).getText().toString();
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
            contact.put(ContactObject.PLOT1GPS, gpsp1);
            contact.put(ContactObject.PLOT1AGE, plotAgep1);
            contact.put(ContactObject.PLOT1AREA, plotArea1);
            contact.put(ContactObject.PLOT1COCOATREES, cocoaTreesP1);
            contact.put(ContactObject.PLOT1YIELD, estimatedP1);
            contact.put(ContactObject.PLOT1SHADETREES, shadeTreesP1);
            contact.put(ContactObject.PLANTINGMATERIAL1, plantingP1);
            contact.put(ContactObject.FARMCONDITION1, farmConditionP1);
            contact.put(ContactObject.TREEHEALTH1, treeHealthP1);
            contact.put(ContactObject.DEBILITATINGDISEASE1, debilitationP1);
            contact.put(ContactObject.PRUNING1, pruningP1);
            contact.put(ContactObject.PESTDISEASESANITATION1, pestDiseaseP1);
            contact.put(ContactObject.WEEDING1, weedingP1);
            contact.put(ContactObject.HARVESTING1, harvestingP1);
            contact.put(ContactObject.SHADEMANAGEMENT1, shadeManagementP1);
            contact.put(ContactObject.SOILCONDITION1, soilConditionP1);
            contact.put(ContactObject.ORGANICMATTER1, organicMatterP1);
            contact.put(ContactObject.FERTILIZERFORMULATION1, fertFormP1);
            contact.put(ContactObject.FERTILIZERAPPLICATION1, fertApplicationP1);
            contact.put(ContactObject.LIMENEED1, limeP1);
            contact.put(ContactObject.DRAINAGENEED1, drainageP1);
            contact.put(ContactObject.FILLINGOPTION1, fillingP1);
            contact.put(ContactObject.HIRELABOR1, hireP1);
            contact.put(ContactObject.PLOT2GPS, gpsp2);
            contact.put(ContactObject.PLOT2AGE, plotAgep2);
            contact.put(ContactObject.PLOT2AREA, plotArea2);
            contact.put(ContactObject.PLOT2COCOATREES, cocoaTreesP2);
            contact.put(ContactObject.PLOT2YIELD, estimatedP2);
            contact.put(ContactObject.PLOT2SHADETREES, shadeTreesP2);
            contact.put(ContactObject.PLANTINGMATERIAL2, plantingP2);
            contact.put(ContactObject.FARMCONDITION2, farmConditionP2);
            contact.put(ContactObject.TREEHEALTH2, treeHealthP2);
            contact.put(ContactObject.DEBILITATINGDISEASE2, debilitationP2);
            contact.put(ContactObject.PRUNING2, pruningP2);
            contact.put(ContactObject.PESTDISEASESANITATION2, pestDiseaseP2);
            contact.put(ContactObject.WEEDING2, weedingP2);
            contact.put(ContactObject.HARVESTING2, harvestingP2);
            contact.put(ContactObject.SHADEMANAGEMENT2, shadeManagementP2);
            contact.put(ContactObject.SOILCONDITION2, soilConditionP2);
            contact.put(ContactObject.ORGANICMATTER2, organicMatterP2);
            contact.put(ContactObject.FERTILIZERFORMULATION2, fertFormP2);
            contact.put(ContactObject.FERTILIZERAPPLICATION2, fertApplicationP2);
            contact.put(ContactObject.LIMENEED2, limeP2);
            contact.put(ContactObject.DRAINAGENEED2, drainageP2);
            contact.put(ContactObject.FILLINGOPTION2, fillingP2);
            contact.put(ContactObject.HIRELABOR2, hireP2);
            contact.put(ContactObject.PLOT3GPS, gpsp3);
            contact.put(ContactObject.PLOT3AGE, plotAgep3);
            contact.put(ContactObject.PLOT3AREA, plotArea3);
            contact.put(ContactObject.PLOT3COCOATREES, cocoaTreesP3);
            contact.put(ContactObject.PLOT3YIELD, estimatedP3);
            contact.put(ContactObject.PLOT3SHADETREES, shadeTreesP3);
            contact.put(ContactObject.PLANTINGMATERIAL3, plantingP3);
            contact.put(ContactObject.FARMCONDITION3, farmConditionP3);
            contact.put(ContactObject.TREEHEALTH3, treeHealthP3);
            contact.put(ContactObject.DEBILITATINGDISEASE3, debilitationP3);
            contact.put(ContactObject.PRUNING3, pruningP3);
            contact.put(ContactObject.PESTDISEASESANITATION3, pestDiseaseP3);
            contact.put(ContactObject.WEEDING3, weedingP3);
            contact.put(ContactObject.HARVESTING3, harvestingP3);
            contact.put(ContactObject.SHADEMANAGEMENT3, shadeManagementP3);
            contact.put(ContactObject.SOILCONDITION3, soilConditionP3);
            contact.put(ContactObject.ORGANICMATTER3, organicMatterP3);
            contact.put(ContactObject.FERTILIZERFORMULATION3, fertFormP3);
            contact.put(ContactObject.FERTILIZERAPPLICATION3, fertApplicationP3);
            contact.put(ContactObject.LIMENEED3, limeP3);
            contact.put(ContactObject.DRAINAGENEED3, drainageP3);
            contact.put(ContactObject.FILLINGOPTION3, fillingP3);
            contact.put(ContactObject.HIRELABOR3, hireP3);
            contact.put(ContactObject.PLOT4GPS, gpsp4);
            contact.put(ContactObject.PLOT4AGE, plotAgep4);
            contact.put(ContactObject.PLOT4AREA, plotArea4);
            contact.put(ContactObject.PLOT4COCOATREES, cocoaTreesP4);
            contact.put(ContactObject.PLOT4YIELD, estimatedP4);
            contact.put(ContactObject.PLOT4SHADETREES, shadeTreesP4);
            contact.put(ContactObject.PLANTINGMATERIAL4, plantingP4);
            contact.put(ContactObject.FARMCONDITION4, farmConditionP4);
            contact.put(ContactObject.TREEHEALTH4, treeHealthP4);
            contact.put(ContactObject.DEBILITATINGDISEASE4, debilitationP4);
            contact.put(ContactObject.PRUNING4, pruningP4);
            contact.put(ContactObject.PESTDISEASESANITATION4, pestDiseaseP4);
            contact.put(ContactObject.WEEDING4, weedingP4);
            contact.put(ContactObject.HARVESTING4, harvestingP4);
            contact.put(ContactObject.SHADEMANAGEMENT4, shadeManagementP4);
            contact.put(ContactObject.SOILCONDITION4, soilConditionP4);
            contact.put(ContactObject.ORGANICMATTER4, organicMatterP4);
            contact.put(ContactObject.FERTILIZERFORMULATION4, fertFormP4);
            contact.put(ContactObject.FERTILIZERAPPLICATION4, fertApplicationP4);
            contact.put(ContactObject.LIMENEED4, limeP4);
            contact.put(ContactObject.DRAINAGENEED4, drainageP4);
            contact.put(ContactObject.FILLINGOPTION4, fillingP4);
            contact.put(ContactObject.HIRELABOR4, hireP4);
            contact.put(ContactObject.PLOT5GPS, gpsp5);
            contact.put(ContactObject.PLOT5AGE, plotAgep5);
            contact.put(ContactObject.PLOT5AREA, plotArea5);
            contact.put(ContactObject.PLOT5COCOATREES, cocoaTreesP5);
            contact.put(ContactObject.PLOT5YIELD, estimatedP5);
            contact.put(ContactObject.PLOT5SHADETREES, shadeTreesP5);
            contact.put(ContactObject.PLANTINGMATERIAL5, plantingP5);
            contact.put(ContactObject.FARMCONDITION5, farmConditionP5);
            contact.put(ContactObject.TREEHEALTH5, treeHealthP5);
            contact.put(ContactObject.DEBILITATINGDISEASE5, debilitationP5);
            contact.put(ContactObject.PRUNING5, pruningP5);
            contact.put(ContactObject.PESTDISEASESANITATION5, pestDiseaseP5);
            contact.put(ContactObject.WEEDING5, weedingP5);
            contact.put(ContactObject.HARVESTING5, harvestingP5);
            contact.put(ContactObject.SHADEMANAGEMENT5, shadeManagementP5);
            contact.put(ContactObject.SOILCONDITION5, soilConditionP5);
            contact.put(ContactObject.ORGANICMATTER5, organicMatterP5);
            contact.put(ContactObject.FERTILIZERFORMULATION5, fertFormP5);
            contact.put(ContactObject.FERTILIZERAPPLICATION5, fertApplicationP5);
            contact.put(ContactObject.LIMENEED5, limeP5);
            contact.put(ContactObject.DRAINAGENEED5, drainageP5);
            contact.put(ContactObject.FILLINGOPTION5, fillingP5);
            contact.put(ContactObject.HIRELABOR5, hireP5);
            contact.put(ContactObject.PH1, ph1);
            contact.put(ContactObject.PH2, ph2);
            contact.put(ContactObject.PH3, ph3);
            contact.put(ContactObject.PH4, ph4);
            contact.put(ContactObject.PH5, ph5);
            contact.put(ContactObject.GENETIC1,genetic1);
            contact.put(ContactObject.GENETIC2,genetic2);
            contact.put(ContactObject.GENETIC3,genetic3);
            contact.put(ContactObject.GENETIC4,genetic4);
            contact.put(ContactObject.GENETIC5,genetic5);
            contact.put(ContactObject.GAP1,gap1);
            contact.put(ContactObject.GAP2,gap2);
            contact.put(ContactObject.GAP3,gap3);
            contact.put(ContactObject.GAP4,gap4);
            contact.put(ContactObject.GAP5,gap5);
            contact.put(ContactObject.SOILMNG1,soilft1);
            contact.put(ContactObject.SOILMNG2,soilft2);
            contact.put(ContactObject.SOILMNG3,soilft3);
            contact.put(ContactObject.SOILMNG4,soilft4);
            contact.put(ContactObject.SOILMNG5,soilft5);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Partially Saved!", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}