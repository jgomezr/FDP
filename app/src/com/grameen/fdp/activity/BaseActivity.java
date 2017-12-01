package com.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.grameen.fdp.fragment.LogoutDialogFragment;
import com.grameen.fdp.utility.Constants;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;

import com.grameen.fdp.R;

import java.io.UnsupportedEncodingException;

import static java.sql.DriverManager.println;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class BaseActivity extends AppCompatActivity{

    private static final String DOUBLE_LINE = "==============================================================================";
    private static final String SINGLE_LINE = "------------------------------------------------------------------------------";


     SharedPreferences prefs;
    private String apiVersion;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        apiVersion = ApiVersionStrings.getVersionNumber(this);

    }

   Toolbar setToolbar(String title) {

        Toolbar toolbar = null;
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return toolbar;

    }






    public void showAlertDialog(Boolean cancelable, @Nullable String title, @Nullable String message,
                                @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                @NonNull String positiveText,
                                @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                @NonNull String negativeText, @Nullable int icon_drawable) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppDialog);
        builder.setTitle(title);
        builder.setCancelable(cancelable);


        if (icon_drawable != 0) builder.setIcon(icon_drawable);
        builder.setMessage(message);

        if (onPositiveButtonClickListener != null)
            builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        if (onNegativeButtonClickListener != null)
            builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        builder.show();
    }



    public static class SpacesGridItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public SpacesGridItemDecoration(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {



            outRect.bottom = mSpace;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 1 || parent.getChildAdapterPosition(view) == 2) {
                outRect.top = mSpace * 2;
            }else{

                outRect.top = mSpace;

            }

            if(parent.getChildAdapterPosition(view) % 3 == 0){
                outRect.right = mSpace * 2;
                outRect.left = mSpace;

            }else if(parent.getChildAdapterPosition(view) % 3 == 2){
                outRect.left = mSpace * 2;
                outRect.right = mSpace;

            }

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // I do not want this...
                // Home as up button is to navigate to Home-Activity not previous acitivity
                super.onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);


    }





    public static void showError(Context context, Exception e) {
        Toast toast = Toast.makeText(context,
                context.getString(
                        SalesforceSDKManager.getInstance().
                                getSalesforceR().stringGenericError(),
                        e.toString()),
                Toast.LENGTH_LONG);
        toast.show();
    }


    void showSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    void hideSoftKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }




    public static ProgressDialog showProgress(Context context, String title, String message, Boolean cancelable){

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelable);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        return progressDialog;


    }


    public void logOut(final AppCompatActivity context){
/*
        String accountType = SalesforceSDKManager.getInstance().getAccountType();

        // Gets a rest client.
        new ClientManager(this, accountType, SalesforceSDKManager.getInstance().getLoginOptions(),
                SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {

            @Override
            public void authenticatedRestClient(RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(context);

                    prefs.edit().putBoolean(Constants.IS_USER_SIGNED_IN, false).apply();

                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    context.finish();



                }

                // Shows everything.
             }
        });*/


        LogoutDialogFragment logoutDialogFragment = new LogoutDialogFragment();
        logoutDialogFragment.show(getSupportFragmentManager(), "logoutDialog");
     }









    public static void printRequestInfo(long nanoDuration, int characterLength, int statusCode) {
        System.out.println(SINGLE_LINE);
        System.out.println("Time (ms): " + nanoDuration / 1000000);
        System.out.println("Size (chars): " + characterLength);
        System.out.println("Status code: " + statusCode);
    }

    public static void printException(Exception e) {
        System.out.println("Error: " + e.getClass().getSimpleName());
        System.out.println(e.getMessage());
        e.printStackTrace();

    }

    public static void printHeader(Object obj) {
        System.out.println(DOUBLE_LINE);
        System.out.println(obj.toString());
        System.out.println(SINGLE_LINE);
    }





}
