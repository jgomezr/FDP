package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameen.fdp.R;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.syncObjects.Answer;
import org.grameen.fdp.syncObjects.Assignation;
import org.grameen.fdp.syncObjects.Farmer;
import org.grameen.fdp.syncObjects.Monitoring;
import org.grameen.fdp.syncObjects.MonitoringAnswer;
import org.grameen.fdp.syncObjects.Plot;
import org.grameen.fdp.object.Submission;
import org.grameen.fdp.utility.Callbacks;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.DatabaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

/**
 * Created by aangjnr on 11/12/2017.
 */

public class SyncDownActivity extends SalesforceActivity {


    public static Callbacks.NetworkActivityCompleteListener networkActivityCompleteListener;
    private String message = "";

    public static void onNetworkActivityComplete(Callbacks.NetworkActivityCompleteListener listener) {
        networkActivityCompleteListener = listener;
    }

    public static void removeOnNetworkActivityComplete() {
        networkActivityCompleteListener = null;
    }


    int _COUNT = 0;
    int _TOTAL_SIZE = 0;

    String nextRecordsUrl = "";
    RestRequest queryMore;
    Boolean DONE = true;
    RestRequest restRequest;
    String USER_ID;
    String SUBMISSION_ID;

    boolean BREAK_OUT_OF_LOOP = false;
    RestClient restClient = null;
    ProgressDialog progressDialog;
    String TAG = "DataDownloadActivity";

    DatabaseHelper databaseHelper;
    long start = 0;

    String ISO_CODE = "";
    Context context;

    Boolean syncInitialData;

    Boolean exception = false;
    int TOTAL_SIZE = 0;
    final int BATCH_SIZE = 2000;
    int COUNT = 0;

    Gson GSON = new Gson();

    List<Object> ALL_FARMER_LIST = new ArrayList<>();
    List<Object> ALL_FARMERS_PLOT_LIST = new ArrayList<>();
    List<Object> ALL_FARMER_ANSWERS = new ArrayList<>();
    List<Object> ALL_ASSIGNATIONS_LIST = new ArrayList<>();

    List<Object> ALL_MONITORING_LIST = new ArrayList<>();
    List<Object> ALL_MONITORING_ANSWERS_LIST = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        databaseHelper = DatabaseHelper.getInstance(this);

        syncInitialData = getIntent().getBooleanExtra("initialData", false);

        context = this;

        ISO_CODE = PreferenceManager.getDefaultSharedPreferences(this).getString("ISO", "");

        progressDialog = BaseActivity.showProgress(context, getResources(R.string.getting_data), getResources(R.string.please_wait), false);


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


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                getAllAssignations();

            }
        });

        thread.start();


    }


    @Override
    public void onResume() {

        super.onResume();

    }


    private RestResponse sendRequest(RestRequest request) {
        RestResponse restResponse = null;
        System.out.println("####  SEND REQUEST  ####");
        BaseActivity.printHeader(request);
        try {
            restResponse = sendSync(request);

            System.out.println("####  STATUS CODE = " + restResponse.getStatusCode());
        } catch (Exception e) {
            BaseActivity.printException(e);
            showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

        }

        return restResponse;
    }

    private RestResponse sendSync(RestRequest restRequest) throws IOException {
        System.out.println("\n\n");
        BaseActivity.printHeader(restRequest);

        start = System.nanoTime();

        return restClient.sendSync(restRequest);

    }


    void getAllAssignations() {

        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting all farmer assigned data");
            }
        });


        String soql = "select id, User__c, External_id__c, Farmer__c from assignation__c where User__c  = '" + USER_ID + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<Assignation>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> objects = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = objects.size();
                    Log.d(TAG, "ASSIGNATIONS ARRAY SIZE IS " + COUNT);


                    if (objects.size() > 0) {


                        ALL_ASSIGNATIONS_LIST.addAll(objects);


                        while (!DONE && !BREAK_OUT_OF_LOOP) {
                            nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                            getNextRecords(nextRecordsUrl, ALL_ASSIGNATIONS_LIST, listType);
                        }


                        _TOTAL_SIZE = ALL_ASSIGNATIONS_LIST.size();

                        if (!BREAK_OUT_OF_LOOP) {

                            for (int i = 0; i < ALL_ASSIGNATIONS_LIST.size(); i++) {


                                if (BREAK_OUT_OF_LOOP)
                                    break;

                                _COUNT++;


                                message = "Downloading " + _COUNT + " out of " + _TOTAL_SIZE;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        progressDialog.setTitle(message);
                                    }
                                });


                                Assignation assignation = (Assignation) ALL_ASSIGNATIONS_LIST.get(i);
                                //getAllFarmers();

                                getSubmission(assignation);


                            }


                            if (BREAK_OUT_OF_LOOP)
                                showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                            else
                                showSyncCompleteDialog();

                        } else
                            showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                    } else {
                        showNoData();
                    }


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                }

            } else
                showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);


    }

    void getSubmission(Assignation assignation) {

        RestResponse restResponse = null;


        String soql = "select id, name, Start__c, End__c from fpd_Submission__c where Respondent__c = '" + assignation.getFarmer__c() + "' and Country_iso__c = '" + ISO_CODE + "' ORDER BY createdDate DESC";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {

                try {

                    int size = 0;
                    size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);

                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<Submission>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Submission> submissions = (List<Submission>) gson.fromJson(String.valueOf(jsonArray), listType);

                    Log.d(TAG, "SUBMISSIONS ARRAY SIZE IS " + submissions.size());
                    if (submissions.size() > 0) {

                        SUBMISSION_ID = submissions.get(0).getId();
                        System.out.println();
                        System.out.println("********************");
                        Log.d(TAG, "SUBMISSION ID IS " + SUBMISSION_ID);
                        System.out.println("********************");
                        System.out.println();

                        if (SUBMISSION_ID != null)


                            getFarmerData(SUBMISSION_ID);


                        else
                            BREAK_OUT_OF_LOOP = true;

                        //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                    }


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                    BREAK_OUT_OF_LOOP = true;

                }


            } else
                BREAK_OUT_OF_LOOP = true;

//        showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

    }

    void getFarmerData(String submissionId) {

        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting farmer data");
            }
        });


        String soql = "select id, SubmitAgreement__c, firstVisitDate__c, lastModifiedDate__c, lastVisitDate__c, photoUrl__c, External_id__c, fullName__c, Name, gender__c, village__c, birthday__c, educationalLevel__c from fdp_farmer_answer__c where Submission__c  = '" + submissionId + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<Farmer>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> farmers = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = farmers.size();
                    Log.d(TAG, "FARMERS ARRAY SIZE IS " + COUNT);

                    ALL_FARMER_LIST.addAll(farmers);


                    while (!DONE && !BREAK_OUT_OF_LOOP) {
                        nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                        getNextRecords(nextRecordsUrl, ALL_FARMER_LIST, listType);
                    }


                    if (!BREAK_OUT_OF_LOOP)
                        getAllPlots(submissionId);


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                    BREAK_OUT_OF_LOOP = true;

                }


            } else
                BREAK_OUT_OF_LOOP = true;

        //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

    }


    void getAllPlots(String submissionId) {


        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting all plots data");
            }
        });


        String soql = "select id, External_id__c, Farmer_code__c, Plot_area_coordinates__c, Plot_name__c, Recommendation_id__c, Start_year__c from fpd_Plot_answer__c where Submission__c  = '" + submissionId + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<Plot>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> plots = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = plots.size();
                    Log.d(TAG, "PLOTS ARRAY SIZE IS " + COUNT);

                    ALL_FARMERS_PLOT_LIST.addAll(plots);


                    while (!DONE && !BREAK_OUT_OF_LOOP) {
                        nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                        getNextRecords(nextRecordsUrl, ALL_FARMERS_PLOT_LIST, listType);
                    }


                    if (!BREAK_OUT_OF_LOOP)
                        getAllAnswers(submissionId);


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                    BREAK_OUT_OF_LOOP = true;

                }

            } else
                BREAK_OUT_OF_LOOP = true;

//        showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);


    }


    void getAllAnswers(String submissionId) {


        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting all answers data");
            }
        });


        String soql = "select id, External_id__c, Answer__c, Date__c, Farmer_ID__c, Question__c from fpd_Answer__c where Submission__c  = '" + submissionId + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {


                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<Answer>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> objects = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = objects.size();
                    Log.d(TAG, "ANSWERS ARRAY SIZE IS " + COUNT);

                    ALL_FARMER_ANSWERS.addAll(objects);


                    while (!DONE && !BREAK_OUT_OF_LOOP) {
                        nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                        getNextRecords(nextRecordsUrl, ALL_FARMER_ANSWERS, listType);
                    }


                    if (!BREAK_OUT_OF_LOOP)
                        getAllMonitoring(submissionId);


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                    BREAK_OUT_OF_LOOP = true;

                }

            } else
                BREAK_OUT_OF_LOOP = true;

//        showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);


    }


    void getAllMonitoring(String submissionId) {


        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting all monitoring data");
            }
        });


        String soql = "select id, External_id__c, MonitoringName__c, Plot_External_id__c, Result__c, Year__c from fdp_Monitoring__c where Submission__c  = '" + submissionId + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<Monitoring>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> objects = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = objects.size();
                    Log.d(TAG, "MONITORING ARRAY SIZE IS " + COUNT);

                    ALL_MONITORING_LIST.addAll(objects);


                    while (!DONE && !BREAK_OUT_OF_LOOP) {
                        nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                        getNextRecords(nextRecordsUrl, ALL_MONITORING_LIST, listType);
                    }


                    if (!BREAK_OUT_OF_LOOP)
                        getAllMonitoringAnswers(submissionId);


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                    BREAK_OUT_OF_LOOP = true;

                }

            } else
                // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                BREAK_OUT_OF_LOOP = true;


    }


    void getAllMonitoringAnswers(String submissionId) {

        RestResponse restResponse = null;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Getting all monitoring answers data");
            }
        });


        String soql = "select id, External_id__c, Monitoring__c, Question__c, Answer__c, Competence__c, Competence_Answer__c, Reasons_For_Failure__c, Reasons_for_failure_answer__c from fdp_Monitoring_Answer__c where Submission__c  = '" + submissionId + "'";


        try {

            RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);
            restResponse = sendRequest(restRequest);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

            BREAK_OUT_OF_LOOP = true;

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));
                    TOTAL_SIZE = Integer.parseInt(restResponse.asJSONObject().getString("totalSize"));


                    int size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);


                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());


                    Type listType = new TypeToken<List<MonitoringAnswer>>() {
                    }.getType();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> objects = (List<Object>) GSON.fromJson(String.valueOf(jsonArray), listType);

                    COUNT = objects.size();
                    Log.d(TAG, "MONITORING ARRAY SIZE IS " + COUNT);

                    ALL_MONITORING_ANSWERS_LIST.addAll(objects);


                    while (!DONE && !BREAK_OUT_OF_LOOP) {
                        nextRecordsUrl = restResponse.asJSONObject().getString("nextRecordsUrl");
                        getNextRecords(nextRecordsUrl, ALL_MONITORING_ANSWERS_LIST, listType);
                    }


                    if (!BREAK_OUT_OF_LOOP)
                        parseAndSaveData();


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    BREAK_OUT_OF_LOOP = true;

                    // showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                }

            } else
                //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);
                BREAK_OUT_OF_LOOP = true;


    }


    void getNextRecords(String url, List<Object> objects, Type type) {

        RestResponse restResponse = null;

        try {

            //RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), url);
            RestRequest restRequest = new RestRequest(RestRequest.RestMethod.GET, url);
            restResponse = sendRequest(restRequest);


        } catch (Exception e) {
            e.printStackTrace();
            showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

        }


        if (restResponse != null)

            if (restResponse.isSuccess()) {
                try {

                    int size = 0;
                    size = restResponse.asString().length();
                    long duration = System.nanoTime() - start;
                    int statusCode = restResponse.getStatusCode();
                    BaseActivity.printRequestInfo(duration, size, statusCode);

                    Log.d(TAG, "THE RESULT IS ");
                    System.out.println(restResponse.asJSONObject());

                    Gson gson = new Gson();

                    JSONArray jsonArray = restResponse.asJSONObject().getJSONArray("records");

                    List<Object> objectList = (List<Object>) gson.fromJson(String.valueOf(jsonArray), type);

                    COUNT = objectList.size();
                    Log.d(TAG, "NEXT RECORDS OBJECTS ARRAY SIZE IS " + COUNT);

                    objects.addAll(objectList);

                    DONE = Boolean.valueOf(restResponse.asJSONObject().getString("done"));


                } catch (IOException | JSONException e) {
                    BaseActivity.printException(e);

                    //showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

                    BREAK_OUT_OF_LOOP = true;
                }


            } else
                BREAK_OUT_OF_LOOP = true;

//        showDialog(getResources(R.string.generic_error), getResources(R.string.connection_error), true);

    }


    public String getResources(int resource) {
        return getString(resource);
    }


    void showDialog(final String title, final String message, final boolean showRetry) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                BREAK_OUT_OF_LOOP = false;


                TOTAL_SIZE = 0;
                COUNT = 0;


                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                AlertDialog.Builder builder = new AlertDialog.Builder(SyncDownActivity.this, R.style.AppDialog);
                builder.setTitle(title);
                builder.setCancelable(false);
                builder.setMessage(message);


                if (showRetry)
                    builder.setPositiveButton(getResources(R.string.retry), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            startActivity(new Intent(SyncDownActivity.this, SyncDownActivity.class));
                            finish();
                        }
                    });

                builder.setNeutralButton(getResources(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });

                builder.show();

            }
        });

    }


    void showSyncCompleteDialog() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                BREAK_OUT_OF_LOOP = false;


                TOTAL_SIZE = 0;
                COUNT = 0;


                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                AlertDialog.Builder builder = new AlertDialog.Builder(SyncDownActivity.this, R.style.AppDialog);
                builder.setTitle(getResources(R.string.download_complete));
                builder.setCancelable(false);
                builder.setMessage(getResources(R.string.all_data_downloaded));


                builder.setPositiveButton(getResources(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        if (networkActivityCompleteListener != null)
                            networkActivityCompleteListener.taskComplete(Constants.SYNC_STATUS_COMPLETE);

                        finish();
                    }
                });


                builder.show();

            }
        });

    }


    void showNoData() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                AlertDialog.Builder builder = new AlertDialog.Builder(SyncDownActivity.this, R.style.AppDialog);
                builder.setTitle(getResources(R.string.no_data));
                builder.setCancelable(false);
                builder.setMessage(getResources(R.string.no_old_data));


                builder.setPositiveButton(getResources(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });


                builder.show();
            }
        });

    }


    void parseAndSaveData() {

        System.out.println("************* FARMER COUNT " + _COUNT + " *****************");
        System.out.println();
        System.out.println();

        //Log.i(TAG, "ALL ASSIGNATIONS LIST SIZE IS " + ALL_ASSIGNATIONS_LIST.size());

        Log.i(TAG, "ALL FARMERS LIST SIZE IS " + ALL_FARMER_LIST.size());
        Log.i(TAG, "ALL ANSWERS LIST SIZE IS " + ALL_FARMER_ANSWERS.size());

        Log.i(TAG, "ALL PLOTS LIST SIZE IS " + ALL_FARMERS_PLOT_LIST.size());

        Log.i(TAG, "ALL MONITORING LIST SIZE IS " + ALL_MONITORING_LIST.size());
        Log.i(TAG, "ALL MONITORING ANSWER LIST SIZE IS " + ALL_MONITORING_ANSWERS_LIST.size());


        System.out.println();
        System.out.println();
        System.out.println("******************************");


        for (int i = 0; i < ALL_FARMER_LIST.size(); i++) {

            Farmer farmer = (Farmer) ALL_FARMER_LIST.get(i);


            // if(ALL_ASSIGNATIONS_LIST.contains(farmer.getExternal_id__c())){
            //  System.out.println("FARMER " + farmer.getExternal_id__c() + " IS ASSIGNED TO USER");

            RealFarmer realFarmer = new RealFarmer();
            realFarmer.setId(farmer.getExternal_id__c());
            realFarmer.setCode(farmer.getName());
            realFarmer.setFirstVisitDate(farmer.getFirstVisitDate__c());
            realFarmer.setLastVisitDate(farmer.getLastVisitDate__c());
            realFarmer.setLastModifiedDate(farmer.getLastModifiedDate__c());
            realFarmer.setSyncStatus(1);
            realFarmer.setImageUrl(farmer.getPhotoUrl__c());
            realFarmer.setBirthYear(farmer.getBirthday__c());
            realFarmer.setEducationLevel(farmer.getEducationalLevel__c());
            realFarmer.setGender(farmer.getGender__c());
            realFarmer.setFarmerName(farmer.getFullName__c());
            realFarmer.setVillage(databaseHelper.getVillageName(farmer.getVillage__c()));
            realFarmer.setHasSubmitted(farmer.getSubmitAgreement__c());
            JSONObject jsonObject = new JSONObject();

            for (int j = 0; j < ALL_FARMER_ANSWERS.size(); j++) {

                Answer answer = (Answer) ALL_FARMER_ANSWERS.get(j);

                if (answer.getExternal_id__c().equals(farmer.getExternal_id__c()))
                    try {
                        jsonObject.put(answer.getQuestion__c(), answer.getAnswer__c());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }


            Log.i(TAG, "FARMER ANSWERS JSON OBJECT IS " + jsonObject);

            realFarmer.setAnswersJson(jsonObject.toString());


            if (databaseHelper.getFarmerBasicInfo(farmer.getExternal_id__c()) == null) {


                databaseHelper.addNewFarmer(realFarmer);


                for (int k = 0; k < ALL_FARMERS_PLOT_LIST.size(); k++) {
                    Plot plot = (Plot) ALL_FARMERS_PLOT_LIST.get(k);


                    if (plot.getFarmer_code__c().equals(farmer.getExternal_id__c())) {
                        RealPlot realPlot = new RealPlot();
                        realPlot.setId(plot.getExternal_id__c());
                        realPlot.setFarmerCode(plot.getFarmer_code__c());
                        realPlot.setName(plot.getPlot_name__c());
                        realPlot.setGpsPoints(plot.getPlot_area_coordinates__c());
                        realPlot.setRecommendationId(plot.getRecommendation_id__c());
                        realPlot.setStartYear(plot.getStart_year__c());

                        JSONObject plotAnswersJson = new JSONObject();


                        for (int j = 0; j < ALL_FARMER_ANSWERS.size(); j++) {

                            Answer answer = (Answer) ALL_FARMER_ANSWERS.get(j);

                            if (answer.getExternal_id__c().equals(plot.getExternal_id__c()))
                                try {
                                    plotAnswersJson.put(answer.getQuestion__c(), answer.getAnswer__c());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        }


                        realPlot.setPlotInformationJson(plotAnswersJson.toString());


                        databaseHelper.addNewPlot(realPlot);


                        for (int l = 0; l < ALL_MONITORING_LIST.size(); l++) {
                            Monitoring monitoring = (Monitoring) ALL_MONITORING_LIST.get(l);

                            if (monitoring.getPlot_External_id__c().equals(plot.getExternal_id__c())) {

                                org.grameen.fdp.object.Monitoring realMonitoring = new org.grameen.fdp.object.Monitoring();
                                realMonitoring.setId(monitoring.getExternal_id__c());
                                realMonitoring.setPlotId(monitoring.getPlot_External_id__c());
                                realMonitoring.setName(monitoring.getMonitoringName__c());

                                JSONObject monitoringJson = new JSONObject();

                                for (int m = 0; m < ALL_MONITORING_ANSWERS_LIST.size(); m++) {

                                    MonitoringAnswer monitoringAnswer = (MonitoringAnswer) ALL_MONITORING_ANSWERS_LIST.get(m);
                                    if (monitoringAnswer.getExternal_id__c().equals(monitoring.getExternal_id__c())) {

                                        try {
                                            monitoringJson.put(monitoringAnswer.getQuestion__c(), monitoringAnswer.getAnswer__c());
                                            monitoringJson.put(monitoringAnswer.getCompetence__c(), monitoringAnswer.getCompetence_Answer__c());
                                            monitoringJson.put(monitoringAnswer.getReasons_For_Failure__c(), monitoringAnswer.getReasons_for_failure_answer__c());


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                realMonitoring.setJson(monitoringJson.toString());

                                databaseHelper.addPlotMonitoring(realMonitoring, monitoring.getYear__c());


                            }
                        }


                    }

                }

            } else {


                Log.i(TAG, "FARMER ALREADY EXISTS!");

            }

        }


        ALL_FARMER_LIST.clear();
        ALL_FARMER_ANSWERS.clear();
        ALL_FARMERS_PLOT_LIST.clear();
        ALL_MONITORING_LIST.clear();
        ALL_MONITORING_ANSWERS_LIST.clear();

    }

}













































