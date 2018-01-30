package org.grameen.fdp.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.salesforce.androidsdk.app.SalesforceSDKManager;

import org.grameen.fdp.R;

/**
 * Created by aangjnr on 27/11/2017.
 */

public class LogoutDialogFragment extends DialogFragment {

    private AlertDialog logoutConfirmationDialog;

    /**
     * Default constructor.
     */
    public LogoutDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        logoutConfirmationDialog = new AlertDialog.Builder(getActivity(), R.style.DialogTheme)
                .setTitle("Log out?")
                .setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                SalesforceSDKManager.getInstance().logout(getActivity());
                            }
                        })
                .setNegativeButton("NO", null)
                .create();
        return logoutConfirmationDialog;
    }
}