package org.grameen.fdp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.grameen.fdp.R;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.Utils;

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
        if(launchMultiplePermissions(PERMISSIONS))
            showAlertDialog();





        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                prefs.edit().putBoolean("isFirstSignIn", false).apply();
                prefs.edit().putString("flag", Constants.REGISTER ).apply();
                startActivity(new Intent(LandingPageActivity.this, MainActivity.class));

            }
        });



        findViewById(R.id.monitoring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prefs.edit().putBoolean("isFirstSignIn", false).apply();
                prefs.edit().putString("flag", Constants.MONITORING ).apply();
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


        for(Integer results : grantResults)
            permissionGranted = results == PackageManager.PERMISSION_GRANTED;

        Log.i("LANDING PAGE ACTIVITY ", permissionGranted + "");






        if (permissionGranted) {
            // Toast.makeText(this, permission[0], Toast.LENGTH_SHORT).show();

            if(launchMultiplePermissions(PERMISSIONS))
            showAlertDialog();

        } else {


            showAlertDialog(false, "Provide Permissions", "All permissions are needed for FDP to work properly", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                    launchMultiplePermissions(PERMISSIONS);


                }
            }, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                    finish();

                }
            }, "Quit", 0);


        }

    }





    void showAlertDialog(){
        if(prefs.getBoolean("isFirstSignIn", true))
            if(Utils.checkInternetConnection(LandingPageActivity.this))

                showAlertDialog(false, "Hey there!", "Looks like this is your first sign in.\n" +
                        "Since you have internet connection it's recommended you sync data from the server.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        startActivity(new Intent(LandingPageActivity.this, SyncActivity.class));

                        prefs.edit().putBoolean("isFirstSignIn", false).apply();


                    }
                }, "Sync anyway", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        startActivity(new Intent(LandingPageActivity.this, SyncActivity.class));


                    }
                }, "Sync", 0);
    }









}
