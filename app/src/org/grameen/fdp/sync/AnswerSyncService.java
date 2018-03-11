package org.grameen.fdp.sync; // change the package if is needed

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * A simple service that binds with the correct sync adapter.
 *
 * @author bhariharan
 */
public class AnswerSyncService extends Service {

    private static final Object SYNC_ADAPTER_LOCK = new Object();
    private static AnswerSyncAdapter ANSWER_SYNC_ADAPTER = null;

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (SYNC_ADAPTER_LOCK) {
            if (ANSWER_SYNC_ADAPTER == null) {
                ANSWER_SYNC_ADAPTER = new AnswerSyncAdapter(getApplicationContext(),
                        true, false);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return ANSWER_SYNC_ADAPTER.getSyncAdapterBinder();
    }
}