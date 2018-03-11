package org.grameen.fdp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import org.grameen.fdp.R;
import org.grameen.fdp.object.Country;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aangjnr on 11/12/2017.
 */


public class LandingPageActivity extends BaseActivity {

    Boolean permissionGranted = false;

    String[] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);


        //Check for permission
        if (launchMultiplePermissions(PERMISSIONS)) {
            // showAlertDialog();
            //syncInitialData();


        }


        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                prefs.edit().putBoolean("isFirstSignIn", false).apply();
                prefs.edit().putString("flag", Constants.DIAGNOSTIC).apply();
                startActivity(new Intent(LandingPageActivity.this, MainActivity.class));

            }
        });


        findViewById(R.id.monitoring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefs.edit().putBoolean("isFirstSignIn", false).apply();
                prefs.edit().putString("flag", Constants.MONITORING).apply();
                startActivity(new Intent(LandingPageActivity.this, MainActivity.class));


            }
        });


    }


    boolean hasPermission(Context context, String permission) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {

            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {


                }
                return false;
            }

        }
        return true;
    }


    public boolean launchMultiplePermissions(String[] PERMISSIONS) {

        for (String permission : PERMISSIONS) {
            if (!hasPermission(this, permission)) {


                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    ActivityCompat.requestPermissions(this, PERMISSIONS, 30);

                } else {
                    ActivityCompat.requestPermissions(this, PERMISSIONS, 30);
                }


                return false;

            }


        }
        return true;

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);


        for (Integer results : grantResults)
            permissionGranted = results == PackageManager.PERMISSION_GRANTED;

        Log.i("LANDING PAGE ACTIVITY ", permissionGranted + "");


        if (permissionGranted) {
            // Toast.makeText(this, permission[0], Toast.LENGTH_SHORT).show();

            if (launchMultiplePermissions(PERMISSIONS))
                //showAlertDialog();
                if (prefs.getBoolean("initialData", true)) {
                    syncInitialData();
                } else {
                    showAlertDialog();
                }

        } else {


            showAlertDialog(false, getResources(R.string.provide_all_permissions), getResources(R.string.provide_all_permissions_rationale), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                    launchMultiplePermissions(PERMISSIONS);


                }
            }, getResources(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                    finish();

                }
            }, getResources(R.string.quit), 0);


        }

    }


    void showAlertDialog() {
        if (prefs.getBoolean("isFirstSignIn", true))
            if (Utils.checkInternetConnection(LandingPageActivity.this)) {


                final List<Country> countriesList = databaseHelper.getAllCountries();


                final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);

                final ArrayList<String> displayValues = new ArrayList<>();
                for (Country c : countriesList) {
                    displayValues.add(c.getName());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayValues);
                builder.setTitle(getResources(R.string.select_country_region));
                builder.setCancelable(false);
                builder.setNegativeButton(getResources(R.string.quit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        LandingPageActivity.this.supportFinishAfterTransition();

                    }
                });
                builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String ISO = countriesList.get(which).getIsoCode();
                        String CURRENCY = countriesList.get(which).getCurrency();

                        dialog.dismiss();

                        // CustomToast.makeToast(LandingPageActivity.this, "ISO CODE & CURRENCY SELECTED ARE " + ISO + " " + CURRENCY, Toast.LENGTH_SHORT).show();

                        Log.i(TAG, "ISO CODE & CURRENCY SELECTED ARE " + ISO + " " + CURRENCY);

                        final SharedPreferences.Editor editor = prefs.edit();

                        editor.putString("ISO", ISO);
                        editor.putString("currency", CURRENCY);
                        editor.apply();


                        showAlertDialog(false, getResources(R.string.hey_there), getResources(R.string.first_sign_in_rationale), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                startActivity(new Intent(LandingPageActivity.this, SyncActivity.class));

                                editor.putBoolean("isFirstSignIn", false).apply();


                            }
                        }, getResources(R.string.sync_anyway), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                startActivity(new Intent(LandingPageActivity.this, SyncActivity.class));

                                editor.putBoolean("isFirstSignIn", false).apply();


                            }
                        }, getResources(R.string.sync), 0);


                    }
                });

                builder.show();


            }


    }


    void syncInitialData() {


        Intent intent = new Intent(this, SyncActivity.class);
        intent.putExtra("initialData", true);
        startActivity(intent);

    }


    @Override
    protected void onResume() {
        super.onResume();


        Log.i(TAG, "ON RESUME");

        if (prefs.getBoolean("initialData", true)) {


            syncInitialData();


        } else {

            showAlertDialog();

        }
    }
}
