package org.grameenfoundation.fdpwaf.loaders;/**
 * Created by julian_Gf on 7/8/2016.
 */
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
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.smartsync.util.SOQLBuilder;
import com.salesforce.androidsdk.smartsync.util.SoqlSyncDownTarget;
import com.salesforce.androidsdk.smartsync.util.SyncDownTarget;
import com.salesforce.androidsdk.smartsync.util.SyncOptions;
import com.salesforce.androidsdk.smartsync.util.SyncState;
import com.salesforce.androidsdk.smartsync.util.SyncState.MergeMode;
import com.salesforce.androidsdk.smartsync.util.SyncState.Status;
import com.salesforce.androidsdk.smartsync.util.SyncUpTarget;

import org.grameenfoundation.fdpwaf.objects.ContactObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple AsyncTaskLoader to load a list of Salesforce contacts.
 *
 * @author bhariharan
 */
public class ContactListLoader extends AsyncTaskLoader<List<ContactObject>> {

    public static final String CONTACT_SOUP = "contacts";
    public static final Integer LIMIT = 10000;
    public static final String LOAD_COMPLETE_INTENT_ACTION = "org.grameenfoundation.fdp.loaders.LIST_LOAD_COMPLETE";
    private static final String TAG = "SmartSyncExplorer: ContactListLoader";
    private static IndexSpec[] CONTACTS_INDEX_SPEC = {
            new IndexSpec("Id", Type.string),
            new IndexSpec("fullName__c", Type.string),
            new IndexSpec("nationalID__c", Type.string),
            new IndexSpec(SyncManager.LOCALLY_CREATED, Type.string),
            new IndexSpec(SyncManager.LOCALLY_UPDATED, Type.string),
            new IndexSpec(SyncManager.LOCALLY_DELETED, Type.string),
            new IndexSpec(SyncManager.LOCAL, Type.string)
    };

    private SmartStore smartStore;
    private SyncManager syncMgr;
    private long syncId = -1;
    private UserAccount curAccount;
    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param account User account.
     */
    public ContactListLoader(Context context, UserAccount account) {
        super(context);
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
        syncMgr = SyncManager.getInstance(account);
    }

    @Override
    public List<ContactObject> loadInBackground() {
        if (!smartStore.hasSoup(CONTACT_SOUP)) {
            return null;
        }
        final QuerySpec querySpec = QuerySpec.buildAllQuerySpec(CONTACT_SOUP,
                ContactObject.LAST_NAME, QuerySpec.Order.ascending, LIMIT);
        JSONArray results = null;
        List<ContactObject> contacts = new ArrayList<ContactObject>();
        try {
            results = smartStore.query(querySpec, 0);
            for (int i = 0; i < results.length(); i++) {
                contacts.add(new ContactObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSqlException e) {
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return contacts;
    }

    /**
     * Pushes local changes up to the server.
     */
    public synchronized void syncUp() {
        final SyncUpTarget target = new SyncUpTarget();
        final SyncOptions options = SyncOptions.optionsForSyncUp(Arrays.asList(ContactObject.CONTACT_FIELDS_SYNC_UP),
                MergeMode.LEAVE_IF_CHANGED);

        try {
            syncMgr.syncUp(target, options, ContactListLoader.CONTACT_SOUP, new SyncUpdateCallback() {

                @Override
                public void onUpdate(SyncState sync) {
                    if (Status.DONE.equals(sync.getStatus())) {
                        syncDown();
                    }
                }
            });
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSyncException e) {
            Log.e(TAG, "SmartSyncException occurred while attempting to sync up", e);
        }
    }

    /**
     * Pulls the latest records from the server.
     */
    public synchronized void syncDown() {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        smartStore.registerSoup(ContactListLoader.CONTACT_SOUP, CONTACTS_INDEX_SPEC);
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
                final SyncOptions options = SyncOptions.optionsForSyncDown(SyncState.MergeMode.LEAVE_IF_CHANGED);
                final String soqlQuery = SOQLBuilder.getInstanceWithFields(ContactObject.CONTACT_FIELDS_SYNC_DOWN)
                        .from(Constants.SUBMISSION).limit(ContactListLoader.LIMIT).build();
                final SyncDownTarget target = new SoqlSyncDownTarget(soqlQuery);
                final SyncState sync = syncMgr.syncDown(target, options,
                        ContactListLoader.CONTACT_SOUP, callback);
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

