package org.grameenfoundation.fdp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartSqlHelper;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.util.Constants;

import org.grameenfoundation.fdp.objects.FarmerObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * A simple AsyncTaskLoader to load object detail for a Farmer object.
 * Created by julian_Gf on 6/26/2016.
 */
public class FarmerDetailLoader extends AsyncTaskLoader<FarmerObject> {
    private static final String TAG = "SmartSyncExplorer: FarmerDetailLoader";
    private String objetcId;
    private SmartStore smartStore;

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param account User account.
     * @param objId Object ID.
     */
    public FarmerDetailLoader(Context context, UserAccount account, String objId){
        super(context);
        objetcId = objId;
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
    }

    @Override
    public FarmerObject loadInBackground() {
        if (TextUtils.isEmpty(objetcId)){
            return null;
        }
        FarmerObject sObject = null;
        if (!smartStore.hasSoup(FarmerLoader.FARMER_SOUP)){
            return null;
        }
        final QuerySpec querySpec = QuerySpec.buildExactQuerySpec(
                FarmerLoader.FARMER_SOUP, Constants.ID, objetcId, null, null, 1);
        JSONArray results = null;
        try {
            results = smartStore.query(querySpec, 0);
            if (results != null){
                sObject = new FarmerObject(results.getJSONObject(0));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSqlHelper.SmartSqlException e) {
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return sObject;
    }
}