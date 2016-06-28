package org.grameenfoundation.fdp.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * A simple service that binds with the correct sync adapter.
 * Created by julian_Gf on 6/26/2016.
 */
public class FarmerSyncService extends Service {
    private static final Object SYNC_ADAPTER_LOCK = new Object();
    private static FarmerSyncAdapter FARMER_SYNC_ADAPTER = null;

    @Override
    public void onCreate(){
        super.onCreate();
        synchronized (SYNC_ADAPTER_LOCK){
            FARMER_SYNC_ADAPTER = new FarmerSyncAdapter(getApplicationContext(), true,false);
        }
    }

    @Override
    public IBinder onBind(Intent intent){
        return FARMER_SYNC_ADAPTER.getSyncAdapterBinder();
    }
}
