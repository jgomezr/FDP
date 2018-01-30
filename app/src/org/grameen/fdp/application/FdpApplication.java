package org.grameen.fdp.application;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;

import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

import org.grameen.fdp.activity.MainActivity;
 import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aangjnr on 27/11/2017.
 */

public class FdpApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        SmartSyncSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(),  MainActivity.class);

		/*
		 * Un-comment the line below to enable push notifications in this app.
		 * Replace 'pnInterface' with your implementation of 'PushNotificationInterface'.
		 * Add your Google package ID in 'bootonfig.xml', as the value
		 * for the key 'androidPushNotificationClientId'.
		 */
        // SalesforceSDKManager.getInstance().setPushNotificationReceiver(pnInterface);


        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("ISO", "GHA").apply();


    }
}

class NativeKeyImpl implements SalesforceSDKManager.KeyInterface {

    @Override
    public String getKey(String name) {
        return Encryptor.hash(name + "12s9adpahk;n12-97sdainkasd=012", name + "12kl0dsakj4-cxh1qewkjasdol8");
    }
}
