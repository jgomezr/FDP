package org.grameen.fdp.application;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;

import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;

import org.grameen.fdp.activity.MainActivity;

import java.io.File;

/**
 * Created by aangjnr on 27/11/2017.
 */

public class FdpApplication extends MultiDexApplication {


    public static final String END_POINT = "https://fdp-developer-edition.na73.force.com/syncData?";

    public static final String REQUEST_TYPE_FARMER = "requesttype=farmer&data=";
    public static final String REQUEST_TYPE_PLOT = "requesttype=plot&data=";

    public static String ROOT_DIR = Environment
            .getExternalStorageDirectory() + File.separator + ".FDP";




    @Override
    public void onCreate() {
        super.onCreate();
        SmartSyncSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(), MainActivity.class);

		/*
         * Un-comment the line below to enable push notifications in this app.
		 * Replace 'pnInterface' with your implementation of 'PushNotificationInterface'.
		 * Add your Google package ID in 'bootonfig.xml', as the value
		 * for the key 'androidPushNotificationClientId'.
		 */
        // SalesforceSDKManager.getInstance().setPushNotificationReceiver(pnInterface);



       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }*/

    }
}

class NativeKeyImpl implements SalesforceSDKManager.KeyInterface {

    @Override
    public String getKey(String name) {
        return Encryptor.hash(name + "12s9adpahk;n12-97sdainkasd=012", name + "12kl0dsakj4-cxh1qewkjasdol8");
    }
}
