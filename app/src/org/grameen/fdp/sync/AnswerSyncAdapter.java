package org.grameen.fdp.sync; // change the package if is needed

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

/**
 * A simple sync adapter to perform background sync of answers.
 *
 * @author bhariharan
 */
public class AnswerSyncAdapter extends AbstractThreadedSyncAdapter {

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param autoInitialize True - if it should be initialized automatically, False - otherwise.
     */
    public AnswerSyncAdapter(Context context, boolean autoInitialize,
                              boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {
        if (account != null) {
            final UserAccount user = SalesforceSDKManager.getInstance().getUserAccountManager().buildUserAccount(account);
            final AnswerListLoader answerLoader = new AnswerListLoader(getContext(), user);
            answerLoader.syncDown();
        }
    }
}