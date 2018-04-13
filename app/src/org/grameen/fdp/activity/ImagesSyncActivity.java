package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameen.fdp.R;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.syncObjects.Answer;
import org.grameen.fdp.syncObjects.Farmer;
import org.grameen.fdp.syncObjects.Monitoring;
import org.grameen.fdp.syncObjects.MonitoringAnswer;
import org.grameen.fdp.syncObjects.Plot;
import org.grameen.fdp.syncObjects.Submission;
import org.grameen.fdp.utility.Callbacks;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;
import org.grameen.fdp.utility.DateUtil;
import org.grameen.fdp.utility.Utils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import okhttp3.MultipartBody;

import static java.sql.DriverManager.println;

/**
 * Created by aangjnr on 11/12/2017.
 */

public class ImagesSyncActivity extends SalesforceActivity {


    AlertDialog.Builder builder;
    boolean BREAK_OUT_OF_LOOP = false;
    ObjectMapper oMapper;

    final int MAX_RETRY = 3;
    int RETRY_COUNT = 0;

    int COUNT = 0;
    int BEGIN_INDEX = 0;
    final int MAX = 200;
    int SYNC_STATUS = Constants.SYNC_STATUS_NO_SYNC;
    String message = "";
    String title = "";


    String SUBMISSION_ID;

    String USER_ID;
    RestClient restClient = null;
    ProgressDialog progressDialog;
    String TAG = "DataDownloadActivity";

    DatabaseHelper databaseHelper;
    long start = 0;

    String ISO_CODE = "";
    Context context;

    Boolean syncInitialData;
    String API_VERSION;

    Boolean exception = false;


    public static Callbacks.NetworkActivityCompleteListener networkActivityCompleteListener;

    public static void onNetworkActivityComplete(Callbacks.NetworkActivityCompleteListener listener) {
        networkActivityCompleteListener = listener;
    }

    public static void removeOnNetworkActivityComplete() {
        networkActivityCompleteListener = null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper = DatabaseHelper.getInstance(this);

        syncInitialData = getIntent().getBooleanExtra("initialData", false);

        context = this;

        ISO_CODE = PreferenceManager.getDefaultSharedPreferences(this).getString("ISO", "");


        oMapper = new ObjectMapper();

        API_VERSION = ApiVersionStrings.getVersionNumber(this);


    }

    @Override
    public void onResume(RestClient client) {

        restClient = client;


        try {
            RestClient.ClientInfo ci = restClient.getClientInfo();
            USER_ID = ci.userId;

            System.out.println("*****************************************************************");
            System.out.println();
            Log.i(TAG, "USER ID IS " + USER_ID);
            System.out.println();
            System.out.println("*****************************************************************");

            PreferenceManager.getDefaultSharedPreferences(this).edit().putString(Constants.USER_UID, USER_ID).apply();


        } catch (Exception e) {
            e.printStackTrace();
        }


        if (Utils.checkInternetConnection(context)) {


            sendDataForCreate();


        }

    }


    @Override
    public void onResume() {

        super.onResume();

    }


    public String getResources(int resource) {
        return getString(resource);

    }


    void sendDataForCreate() {

        RestRequest restRequest = null;
        restRequest = new RestRequest(RestRequest.RestMethod.PUT, API_VERSION, new JSONObject());
        Log.i(TAG, "REQUEST PATH = " + restRequest.getPath());


        RestResponse response = null;
        try {
            response = restClient.sendSync(restRequest);
            Log.i(TAG, "RESPONSE CODE = " + response.getStatusCode());
            try {
                Log.i(TAG, "RESPONSE CODE = " + response.asJSONObject());
            } catch (JSONException e) {
                e.printStackTrace();

            }

            if (response.isSuccess()) {
                BEGIN_INDEX += MAX;
                RETRY_COUNT = 0;

                COUNT -= MAX;


            } else {


            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "RESPONSE BODY is NULL");

            RETRY_COUNT++;
            if (RETRY_COUNT == MAX_RETRY) {

                BREAK_OUT_OF_LOOP = true;

            }


        }


    }


    public void createAttachment(String attachmentJson, File attachmentFile) throws Exception {


    }

}














































