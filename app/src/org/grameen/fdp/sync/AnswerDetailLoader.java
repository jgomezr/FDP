package org.grameen.fdp.sync; // change the package if is needed

import org.json.JSONArray;
import org.json.JSONException;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartSqlHelper.SmartSqlException;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.util.Constants;//change the constants location if is needed

/**
 * A simple AsyncTaskLoader to load object detail for a Answer object.
 *
 * @author bhariharan
 */
public class AnswerDetailLoader extends AsyncTaskLoader<AnswerObject> {

    private static final String TAG = "SmartSyncExplorer:";

    private String objectId;
    private SmartStore smartStore;

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param account User account.
     * @param objId Object ID.
     */
    public AnswerDetailLoader(Context context, UserAccount account,
                               String objId) {
        super(context);
        objectId = objId;
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
    }

    @Override
    public AnswerObject loadInBackground() {
        if (TextUtils.isEmpty(objectId)) {
            return null;
        }
        AnswerObject sObject = null;
        if (!smartStore.hasSoup(AnswerListLoader.ANSWER_SOUP)) {
            return null;
        }
        final QuerySpec querySpec = QuerySpec.buildExactQuerySpec(
                AnswerListLoader.ANSWER_SOUP, Constants.ID, objectId, null, null, 1);
        JSONArray results = null;
        try {
            results = smartStore.query(querySpec, 0);
            if (results != null) {
                sObject = new AnswerObject(results.getJSONObject(0));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSqlException e) {
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return sObject;
    }
}
