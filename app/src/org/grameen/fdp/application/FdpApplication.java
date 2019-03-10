package org.grameen.fdp.application;

 import android.os.Environment;
  import android.support.multidex.MultiDexApplication;
 import android.support.v7.preference.PreferenceManager;
 import android.util.Log;

import com.balsikandar.crashreporter.CrashReporter;
 import com.crashlytics.android.Crashlytics;
 import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;

  import org.grameen.fdp.activity.MainActivity;

import java.io.File;

 import io.fabric.sdk.android.Fabric;


/**
 * Created by aangjnr on 27/11/2017.
 */

public class FdpApplication extends MultiDexApplication {


    public static final String END_POINT = "https://fdp-developer-edition.na73.force.com/syncData?";

    public static final String REQUEST_TYPE_FARMER = "requesttype=farmer&data=";
    public static final String REQUEST_TYPE_PLOT = "requesttype=plot&data=";

    public static String ROOT_DIR = Environment.getExternalStorageDirectory() + File.separator + ".FDP/v2";

    public static String crashReportsPath = ROOT_DIR + File.separator + "crashReports";

    public static String databaseBackupsPath = ROOT_DIR + File.separator + "databaseBackups";





    @Override
    public void onCreate() {
        super.onCreate();
        SmartSyncSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(), MainActivity.class);
        Fabric.with(this, new Crashlytics());



        try {
            Log.i("FDP APPLICATION", "************  CRASHYTICS ENABLED! **********");
            File databaseFile = new File(crashReportsPath);
            if (!databaseFile.exists())
                databaseFile.mkdirs();
        } catch (Exception ignore) {
        }


        Crashlytics.setUserIdentifier(PreferenceManager.getDefaultSharedPreferences(
                this).getString("client_email",
                PreferenceManager.getDefaultSharedPreferences(
                        this).getString("client_name", "FDP USER")));
        CrashReporter.initialize(this, crashReportsPath);

            try {
                Log.i("FDP APPLICATION", "************  CRASHYTICS ENABLED! **********");
                File databaseFile = new File(databaseBackupsPath);
                if (!databaseFile.exists())
                    databaseFile.mkdirs();

            } catch (Exception ignore) {
            }



    }
}

class NativeKeyImpl implements SalesforceSDKManager.KeyInterface {

    @Override
    public String getKey(String name) {
        return Encryptor.hash(name + "12s9adpahk;n12-97sdainkasd=012", name + "12kl0dsakj4-cxh1qewkjasdol8");
    }
}
