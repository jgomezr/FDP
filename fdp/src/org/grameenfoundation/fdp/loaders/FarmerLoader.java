package org.grameenfoundation.fdp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager.SmartSyncException;
import com.salesforce.androidsdk.smartsync.manager.SyncManager.SyncUpdateCallback;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.smartsync.util.SOQLBuilder;
import com.salesforce.androidsdk.smartsync.util.SoqlSyncDownTarget;
import com.salesforce.androidsdk.smartsync.util.SyncDownTarget;
import com.salesforce.androidsdk.smartsync.util.SyncOptions;
import com.salesforce.androidsdk.smartsync.util.SyncState;
import com.salesforce.androidsdk.smartsync.util.SyncState.MergeMode;
import com.salesforce.androidsdk.smartsync.util.SyncState.Status;
import com.salesforce.androidsdk.smartsync.util.SyncUpTarget;

import org.grameenfoundation.fdp.objects.FarmerObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple AsyncTaskLoader to load a list of Salesforce farmers.
 * Created by julian_Gf on 6/26/2016.
 */
public class FarmerLoader extends AsyncTaskLoader<List<FarmerObject>> {
    public static final String FARMER_SOUP = "farmers";
    public static final Integer LIMIT = 10000;
    public static final String LOAD_COMPLETE_INTENT_ACTION = "org.grameenfoundation.fdp.loaders.LIST_LOAD_COMPLETE";
    private static final String TAG = "SmartSyncExplorer: FarmerLoader";
    private static IndexSpec[] FARMERS_INDEX_SPEC ={
            new IndexSpec("Id", SmartStore.Type.string),
            new IndexSpec("Name", SmartStore.Type.string),
            new IndexSpec("fullName__c", SmartStore.Type.string),
            new IndexSpec(SyncManager.LOCALLY_CREATED, SmartStore.Type.string),
            new IndexSpec(SyncManager.LOCALLY_UPDATED, SmartStore.Type.string),
            new IndexSpec(SyncManager.LOCALLY_DELETED, SmartStore.Type.string),
            new IndexSpec(SyncManager.LOCAL, SmartStore.Type.string)
    };
    private SmartStore smartStore;
    private SyncManager syncMgr;
    private long syncId = -1;

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param account User account.
     */
    public FarmerLoader(Context context, UserAccount account) {
        super(context);
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
        syncMgr = SyncManager.getInstance(account);
    }

    @Override
    public List<FarmerObject> loadInBackground(){
        if (!smartStore.hasSoup(FARMER_SOUP)){
          return null;
        }
        final QuerySpec querySpec = QuerySpec.buildAllQuerySpec(FARMER_SOUP,FarmerObject.NAME,QuerySpec.Order.ascending ,LIMIT);
        JSONArray results = null;
        List<FarmerObject> farmers = new ArrayList<FarmerObject>();
        try{
            results = smartStore.query(querySpec,0);
            for (int i=0; i< results.length(); i++){
                farmers.add(new FarmerObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SyncManager.SmartSyncException e){
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return farmers;
    }
    /**
     * Pushes local changes up to the server.
     * */
    public synchronized void syncUp(){
        final SyncUpTarget target = new SyncUpTarget();
        final SyncOptions options = SyncOptions.optionsForSyncUp(Arrays.asList(FarmerObject.FARMER_FIELDS_SYNC_UP),MergeMode.LEAVE_IF_CHANGED);
        try {
            syncMgr.syncUp(target, options, FarmerLoader.FARMER_SOUP, new SyncUpdateCallback() {
                @Override
                public void onUpdate(SyncState sync) {
                    if (SyncState.Status.DONE.equals(sync.getStatus())){
                        syncDown();
                    }
                }
            });
        }catch (JSONException e){
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SyncManager.SmartSyncException e){
            Log.e(TAG, "SmartSyncException occurred while attempting to sync up", e);
        }
    }
    /**
     * Pulls the latest records from the server.
     */
    public synchronized void syncDown(){
        smartStore.registerSoup(FarmerLoader.FARMER_SOUP, FARMERS_INDEX_SPEC);
        final SyncUpdateCallback callback = new SyncUpdateCallback() {
            @Override
            public void onUpdate(SyncState sync) {
                if (Status.DONE.equals(sync.getStatus())){
                    fireLoadCompleteIntent();
                }
            }
        };
        try {
            if (syncId == -1){
                final SyncOptions options = SyncOptions.optionsForSyncDown(SyncState.MergeMode.LEAVE_IF_CHANGED);
                final String soqlQuery = SOQLBuilder.getInstanceWithFields(FarmerObject.FARMER_FIELDS_SYNC_DOWN).from(Constants.FARMER).limit(FarmerLoader.LIMIT).build();
                final SyncDownTarget target = new SoqlSyncDownTarget(soqlQuery);
                final SyncState sync = syncMgr.syncDown(target, options,FarmerLoader.FARMER_SOUP, callback);
                syncId = sync.getId();
            }else {
                syncMgr.reSync(syncId, callback);
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSyncException e) {
            Log.e(TAG, "SmartSyncException occurred while attempting to sync down", e);
        }
    }

    /**
     * Fires an intent notifying a registered receiver that fresh data is
     * available. This is for the special case where the data change has
     * been triggered by a background sync, even though the consuming
     * activity is in the foreground. Loaders don't trigger callbacks in
     * the activity unless the load has been triggered using a LoaderManager.
     */
    private void fireLoadCompleteIntent() {
        final Intent intent = new Intent(LOAD_COMPLETE_INTENT_ACTION);
        SalesforceSDKManager.getInstance().getAppContext().sendBroadcast(intent);
    }

}
