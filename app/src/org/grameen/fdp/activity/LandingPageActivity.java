package org.grameen.fdp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.balsikandar.crashreporter.CrashReporter;
import com.balsikandar.crashreporter.utils.CrashUtil;
import com.balsikandar.crashreporter.utils.FileUtils;
import com.crashlytics.android.Crashlytics;

import org.grameen.fdp.BuildConfig;
import org.grameen.fdp.R;
import org.grameen.fdp.application.FdpApplication;
import org.grameen.fdp.object.Country;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;
import org.grameen.fdp.utility.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import static org.grameen.fdp.application.FdpApplication.databaseBackupsPath;

/**
 * Created by aangjnr on 11/12/2017.
 */


public class LandingPageActivity extends BaseActivity {

    Boolean permissionGranted = false;


    String localPath;
    String backupPath;


    String[] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_landing_page);


        localPath = Environment.getDataDirectory().getPath() + "/data/" + getPackageName() + "/databases/" + Constants.DB_NAME;
        backupPath = databaseBackupsPath + "/" + Constants.DB_NAME;



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


                    try {

                        File databaseFile = new File(databaseBackupsPath);
                        if (!databaseFile.exists())
                            databaseFile.mkdirs();
                    } catch (Exception ignored) {
                    }

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
                builder.setTitle(getResources(R.string.hello) + "\n" + getResources(R.string.select_country_region));
                //builder.setMessage(getResources(R.string.select_country_region));
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

                                startActivity(new Intent(LandingPageActivity.this, DataDownloadActivity.class));

                                editor.putBoolean("isFirstSignIn", false).apply();


                            }
                        }, getResources(R.string.sync), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                //startActivity(new Intent(LandingPageActivity.this, DataDownloadActivity.class));

                                editor.putBoolean("isFirstSignIn", false).apply();


                            }
                        }, getResources(R.string.no), 0);


                    }
                });

                builder.show();


            }


    }


    void syncInitialData() {


        Intent intent = new Intent(this, DataDownloadActivity.class);
        intent.putExtra("initialData", true);
        startActivity(intent);

    }


    @Override
    public void onResume() {
        super.onResume();


        Log.i(TAG, "ON RESUME");

        if (prefs.getBoolean("initialData", true)) {


            syncInitialData();


        } else {

            showAlertDialog();

        }
    }


    public void showPopUp(@Nullable final View v) {

        final PopupMenu menu = new PopupMenu(this, v);

        menu.getMenuInflater()
                .inflate(R.menu.activity_landing_page_menu, menu.getMenu());

        //if(!BuildConfig.DEBUG)
        //menu.getMenu().findItem(R.id.crash_reports).setVisible(false);




        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.upload_logs:

                        //Todo upload logs to server

                        if (Utils.checkInternetConnection(LandingPageActivity.this))
                            sendLatestLogToServer();
                        else
                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.no_internet_connection_available), Toast.LENGTH_LONG).show();

                        return true;

                    case R.id.crash_reports:

                        // Intent intent = new Intent(LandingPageActivity.this, CrashReporterActivity.class);
                        Intent intent = new Intent(LandingPageActivity.this, CrashTestingActivity.class);
                        startActivity(intent);

                        return true;


                    case R.id.export_database:

                        Log.i(TAG, "********* LOCAL PATH IS " + localPath);
                        Log.i(TAG, "********* BACKUP PATH IS " + backupPath);


                        int value;

                        value = databaseHelper.exportDB(localPath, backupPath);

                        if (value == 1)
                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.database_exported), Toast.LENGTH_LONG).show();
                        else if (value == 0)
                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.no_database_data_found), Toast.LENGTH_LONG).show();
                        else
                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.database_export_error), Toast.LENGTH_LONG).show();


                        return true;


                    case R.id.import_database:

                        Log.i(TAG, "********* LOCAL PATH IS " + localPath);
                        Log.i(TAG, "********* BACKUP PATH IS " + backupPath);


                        showAlertDialog(true, getString(R.string.import_data_question), getString(R.string.import_data_rationale),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Log.i(TAG, "********* LOCAL PATH IS " + localPath);
                                        Log.i(TAG, "********* BACKUP PATH IS " + backupPath);


                                        int value;

                                        value = databaseHelper.exportDB(backupPath, localPath);

                                        if (value == 1)
                                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.database_imported), Toast.LENGTH_LONG).show();
                                        else if (value == 0)
                                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.no_database_data_found), Toast.LENGTH_LONG).show();
                                        else
                                            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.database_import_error), Toast.LENGTH_LONG).show();


                                    }
                                }, getString(R.string.yes), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        dialog.dismiss();


                                    }
                                }, getString(R.string.no), 0);


                        return true;



                    default:
                        return false;








                }
            }

        });

        menu.show();

    }

    private void sendLatestLogToServer() {
        CustomToast.makeToast(LandingPageActivity.this, "Sending logs...", Toast.LENGTH_LONG).show();

        List<File> logFiles = getAllCrashes();
        if (logFiles.size() > 0) {

            Crashlytics.log(FileUtils.readFromFile(new File(logFiles.get(0).getAbsolutePath())));

            CustomToast.makeToast(LandingPageActivity.this, getString(R.string.logs_sent), Toast.LENGTH_LONG).show();

            try {
                File[] logs = new File(CrashReporter.getCrashReportPath()).listFiles();
                for (File file : logs) {
                    FileUtils.delete(file);
                }
            } catch (Exception ignored) {
            }
        }else
            CustomToast.makeToast(LandingPageActivity.this, "No logs to send!", Toast.LENGTH_LONG).show();


    }


    private ArrayList<File> getAllCrashes() {
        String directoryPath;
        String crashReportPath = CrashReporter.getCrashReportPath();

        if (TextUtils.isEmpty(crashReportPath)) {
            directoryPath = CrashUtil.getDefaultPath();
        } else {
            directoryPath = crashReportPath;
        }
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("The path provided doesn't exists : " + directoryPath);
        }
        ArrayList<File> listOfFiles = new ArrayList<>(Arrays.asList(directory.listFiles()));
        for (Iterator<File> iterator = listOfFiles.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getName().contains(com.balsikandar.crashreporter.utils.Constants.EXCEPTION_SUFFIX)) {
                iterator.remove();
            }
        }
        Collections.sort(listOfFiles, Collections.reverseOrder());
        return listOfFiles;
    }
}
