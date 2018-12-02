package org.grameen.fdp.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.salesforce.androidsdk.app.SalesforceSDKManager;

import org.grameen.fdp.R;
import org.grameen.fdp.activity.BaseActivity;
import org.grameen.fdp.activity.LandingPageActivity;
import org.grameen.fdp.activity.LoginActivity;
import org.grameen.fdp.application.FdpApplication;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;

/**
 * Created by aangjnr on 27/11/2017.
 */

public class LogoutDialogFragment extends DialogFragment {

    SharedPreferences prefs;
    private AlertDialog logoutConfirmationDialog;

    /**
     * Default constructor.
     */
    public LogoutDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        logoutConfirmationDialog = new AlertDialog.Builder(getActivity(), R.style.DialogTheme)
                .setTitle(getString(R.string.log_out))
                .setPositiveButton(getString(R.string.yes),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                String localPath = Environment.getDataDirectory().getPath() + "/data/" + getActivity().getPackageName() + "/databases/" + Constants.DB_NAME;
                                String backupPath = FdpApplication.databaseBackupsPath + "/" + Constants.DB_NAME;

                                if (DatabaseHelper.getInstance(getActivity()).exportDB(localPath, backupPath) != -1) {

                                    Log.i("LOGOUT FRAG", "********  Database backup complete!  **********");

                                    prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

                                    SalesforceSDKManager.getInstance().logout(getActivity());

                                    Intent intent = new Intent(getActivity(), LoginActivity.class);

                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    prefs.edit().clear().apply();


                                    try {
                                        DatabaseHelper.getInstance(getActivity()).deleteAllTables();
                                        Log.i("LOGOUT FRAG", "DATABASE DELETED");

                                        startActivity(intent);
                                        getActivity().finishAffinity();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                /*
                                String accountType = SalesforceSDKManager.getInstance().getClientManager().getAccountType();

                                // Gets a rest client.
                                new ClientManager(getActivity(), accountType, SalesforceSDKManager.getInstance().getLoginOptions(),
                                        SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {

                                    @Override
                                    public void authenticatedRestClient(RestClient client) {

                                        Log.i("LOGOUT FRAG", "Auth REST CLIENT = " + client);

                                        if (client == null) {
                                            Log.i("LOGOUT FRAG", "Auth REST CLIENT IS NULL");


                                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            prefs.edit().clear().apply();
                                            if(getActivity().deleteDatabase("fdp.db")){
                                                Log.i("LOGOUT FRAG", "DATABASE DELETED");

                                                startActivity(intent);
                                                getActivity().finish();

                                            }
                                        }
                                        // Shows everything.
                                    }
                                });*/
                                }

                            }
                        })
                .setNegativeButton(getString(R.string.no), null)
                .create();
        return logoutConfirmationDialog;
    }
}