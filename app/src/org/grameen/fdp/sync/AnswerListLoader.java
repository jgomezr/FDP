package org.grameen.fdp.sync; // change the package if is needed

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartSqlHelper.SmartSqlException;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.store.SmartStore.Type;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager.SmartSyncException;
import com.salesforce.androidsdk.smartsync.manager.SyncManager.SyncUpdateCallback;
import com.salesforce.androidsdk.smartsync.target.SoqlSyncDownTarget;
import com.salesforce.androidsdk.smartsync.target.SyncDownTarget;
 import com.salesforce.androidsdk.smartsync.util.SOQLBuilder;
 import com.salesforce.androidsdk.smartsync.util.SyncOptions;
import com.salesforce.androidsdk.smartsync.util.SyncState;
import com.salesforce.androidsdk.smartsync.util.SyncState.MergeMode;
import com.salesforce.androidsdk.smartsync.util.SyncState.Status;


import org.grameen.fdp.utility.Constants;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCAL;
import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_CREATED;
import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_DELETED;
import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_UPDATED;

/**
 * A simple AsyncTaskLoader to load a list of Salesforce answers.
 *
 */
public class AnswerListLoader extends AsyncTaskLoader<List<AnswerObject>> {

    public static final String ANSWER_SOUP = "answers";
    public static final Integer LIMIT = 10000;
    public static final String LOAD_COMPLETE_INTENT_ACTION = "org.grameen.fdp.sync.LIST_LOAD_COMPLETE";//change package
    private static final String TAG = "AnswerListLoader";
    private static IndexSpec[] ANSWER_INDEX_SPEC = {
            new IndexSpec("Id", Type.string),
            new IndexSpec("Farmer__c", Type.string),
            new IndexSpec("Question__c", Type.string),
            new IndexSpec(LOCALLY_CREATED, Type.string),
            new IndexSpec(LOCALLY_UPDATED, Type.string),
            new IndexSpec(LOCALLY_DELETED, Type.string),
            new IndexSpec(LOCAL, Type.string)
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
    public AnswerListLoader(Context context, UserAccount account) {
        super(context);
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
        syncMgr = SyncManager.getInstance(account);
    }

    @Override
    public List<AnswerObject> loadInBackground() {
        if (!smartStore.hasSoup(ANSWER_SOUP)) {
            return null;
        }
        final QuerySpec querySpec = QuerySpec.buildAllQuerySpec(ANSWER_SOUP,
                AnswerObject.NAME, QuerySpec.Order.ascending, LIMIT);
        JSONArray results = null;
        List<AnswerObject> answers = new ArrayList<AnswerObject>();
        try {
            results = smartStore.query(querySpec, 0);
            for (int i = 0; i < results.length(); i++) {
                answers.add(new AnswerObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSqlException e) {
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return answers;
    }

    /**
     * Pulls the latest records from the server.
     */
    public synchronized void syncDown() {
        smartStore.registerSoup(AnswerListLoader.ANSWER_SOUP, ANSWER_INDEX_SPEC);
        final SyncUpdateCallback callback = new SyncUpdateCallback() {

            @Override
            public void onUpdate(SyncState sync) {
                if (Status.DONE.equals(sync.getStatus())) {
                    fireLoadCompleteIntent();
                }
            }
        };
        try {
            if (syncId == -1) {
                final SyncOptions options = SyncOptions.optionsForSyncDown(MergeMode.LEAVE_IF_CHANGED);
                final String soqlQuery = SOQLBuilder.getInstanceWithFields(AnswerObject.ANSWER_FIELDS_SYNC_DOWN)
                        .from(Constants.ANSWERS).limit(AnswerListLoader.LIMIT).build();//create the constant public static final String ANSWERS = "fpd_Answer__c";
                final SyncDownTarget target = new SoqlSyncDownTarget(soqlQuery);
                final SyncState sync = syncMgr.syncDown(target, options,
                        AnswerListLoader.ANSWER_SOUP, callback);
                syncId = sync.getId();

            } else {
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

