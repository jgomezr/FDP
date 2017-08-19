package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.MainActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian_Gf on 8/18/2017.
 */

public class newFarmer  extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: DetailActivity";
    private Button button;
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_farmer);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setIcon(R.drawable.ic_action_back);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(MainActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(MainActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(MainActivity.OBJECT_NAME_KEY);
            getActionBar().setTitle(launchIntent.getStringExtra(MainActivity.OBJECT_NAME_KEY));
            getActionBar().setSubtitle(objectTitle);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save variables on screen orientation change. Save the user's current game state
        savedInstanceState.putString(OBJECT_ID_KEY, objectId);
        savedInstanceState.putString(OBJECT_TITLE_KEY, objectTitle);
        savedInstanceState.putString(OBJECT_NAME_KEY, objNameKey);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore variables on screen orientation change. Restore state members from saved instance
        objectId = savedInstanceState.getString(OBJECT_ID_KEY);
        objectTitle = savedInstanceState.getString(OBJECT_TITLE_KEY);
        objNameKey = savedInstanceState.getString(OBJECT_NAME_KEY);
    }

    @Override
    public Loader<ContactObject> onCreateLoader(int id, Bundle args) {
        return new ContactDetailLoader(this, curAccount, objectId);
    }

    @Override
    public void onLoadFinished(Loader<ContactObject> loader, ContactObject data) {
        sObject = data;
        refreshScreen();
    }

    @Override
    public void onLoaderReset(Loader<ContactObject> loader) {
        sObject = null;
        refreshScreen();
    }

    private void refreshScreen() {
        if (sObject != null) {

        }

    }
    public void saveFarmer(View view) {
        save();
    }

    private void save() {
        final String firstName = ((EditText) findViewById(R.id.full_name_field)).getText().toString();
        final String title = ((EditText) findViewById(R.id.farmer_code_field)).getText().toString();
        final String country = "Indonesia";
        final SmartStore smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
        JSONObject contact;
        try {
            boolean isCreate = TextUtils.isEmpty(objectId);
            if (!isCreate) {
                contact = smartStore.retrieve(ContactListLoader.CONTACT_SOUP,
                        smartStore.lookupSoupEntryId(ContactListLoader.CONTACT_SOUP,
                                Constants.ID, objectId)).getJSONObject(0);
            } else {
                contact = new JSONObject();
                contact.put(Constants.ID, "local_" + System.currentTimeMillis()
                        + Constants.EMPTY_STRING);
                final JSONObject attributes = new JSONObject();
                attributes.put(Constants.TYPE.toLowerCase(), Constants.SUBMISSION);
                contact.put(Constants.ATTRIBUTES, attributes);
            }
            contact.put(ContactObject.FIRST_NAME, firstName);
            contact.put(ContactObject.TITLE, title);
            contact.put(ContactObject.COUNTRY,country);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, this.getString(R.string.saved), Toast.LENGTH_SHORT).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    @Override
    public void onDestroy() {
        getLoaderManager().destroyLoader(CONTACT_DETAIL_LOADER_ID);
        super.onDestroy();
    }
}
