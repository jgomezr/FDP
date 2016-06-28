package org.grameenfoundation.fdp.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import org.grameenfoundation.fdp.loaders.FarmerLoader;

/**
 * A simple sync adapter to perform background sync of farmers.
 * Created by julian_Gf on 6/26/2016.
 */
public class FarmerSyncAdapter extends AbstractThreadedSyncAdapter {

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param autoInitialize True - if it should be initialized automatically, False - otherwise.
     */
    public FarmerSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs){
        super(context, autoInitialize, allowParallelSyncs);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult){
        if (account != null){
            final UserAccount user = SalesforceSDKManager.getInstance().getUserAccountManager().buildUserAccount(account);
            final FarmerLoader farmerLoader = new FarmerLoader(getContext(), user);
            farmerLoader.syncUp();
        }
    }
}