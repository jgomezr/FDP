package org.grameen.fdp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameen.fdp.utility.Constants;


/**
 * Created by aangjnr on 27/11/2017.
 */

public class LoginActivity extends SalesforceActivity {

    String TAG = "LoginActivity";
    RestClient restClient;
    SharedPreferences prefs;
    private PasscodeManager passcodeManager;
    private RestClient client;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        passcodeManager = SalesforceSDKManager.getInstance().getPasscodeManager();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);


    }

    @Override
    public void onResume(RestClient client) {

        restClient = client;



      /*  Log.i("", "***************************************");
        Log.i("", "***************************************");
        Log.i("TOKEN IS ", restClient.getAuthToken());

        Log.i("", "***************************************");
        Log.i("", "***************************************");

*/


        // Hides everything until we are logged in.
        //findViewById(R.id.root).setVisibility(View.INVISIBLE);

        // Brings up the passcode screen if needed.
        if (passcodeManager.onResume(this)) {
            String accountType = SalesforceSDKManager.getInstance().getAccountType();

            // Gets a rest client.
            new ClientManager(this, accountType, SalesforceSDKManager.getInstance().getLoginOptions(),
                    SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {

                @Override
                public void authenticatedRestClient(RestClient client) {
                    if (client == null) {

                        Log.d(TAG, "CLIENT IS NULL");

                        SalesforceSDKManager.getInstance().logout(LoginActivity.this);
                        return;
                    }
                    LoginActivity.this.restClient = client;

                    Log.d(TAG, "CLIENT IS OK");

                    // Shows everything.
                    // findViewById(R.id.root).setVisibility(View.VISIBLE);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("client_name", client.getClientInfo().displayName);
                    editor.putString("client_email", client.getClientInfo().username);
                    editor.putString(Constants.USER_UID, client.getClientInfo().userId);

                    editor.putBoolean(Constants.IS_USER_SIGNED_IN, true);
                    editor.apply();

                    startActivity(new Intent(LoginActivity.this, LandingPageActivity.class));
                    finish();
                }
            });
        } else {

            Log.d(TAG, "NO LOGIN NEEEDED. CLIENT IS OK");


            prefs.edit().putBoolean(Constants.IS_USER_SIGNED_IN, true).apply();
            startActivity(new Intent(LoginActivity.this, LandingPageActivity.class));
            finish();


        }


    }


    @Override
    public void onPause() {
        passcodeManager.onPause(this);
        super.onPause();
    }


}
