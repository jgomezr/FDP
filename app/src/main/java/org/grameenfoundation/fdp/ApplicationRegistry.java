package org.grameenfoundation.fdp;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by julian_Gf on 5/20/2016.
 * class that shares data across the entire application
 */

public class ApplicationRegistry {
    private ApplicationRegistry() {
    }

    private static Context applicationContext;
    private static Activity mainActivity;
    private static Map<String, Object> registry = new HashMap<String, Object>();

    //gets the application context
    public static Context getApplicationContext() {
        return applicationContext;
    }

    //sets the application context
    public static void setApplicationContext(Context applicationContext) {
        ApplicationRegistry.applicationContext = applicationContext;
    }

    //registers a record in the application registry with the given key and value.
    public static void register(String key, Object value) {
        registry.put(key, value);
    }

    //un registers/ removes a record with the given key from the registry
    public static void unRegister(String key) {
        registry.remove(key);
    }

    //gets the record associated with the given key from the registry
    public static Object retrieve(String key) {
        return registry.get(key);
    }

    public static Activity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(Activity mainActivity) {
        ApplicationRegistry.mainActivity = mainActivity;
    }
}
