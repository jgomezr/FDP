package com.grameen.fdp.activity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.grameen.fdp.object.Question;
import com.grameen.fdp.utility.CustomToast;
import com.grameen.fdp.utility.DatabaseHelper;
import com.mancj.materialsearchbar.MaterialSearchBar;

import com.grameen.fdp.R;
import com.grameen.fdp.adapter.FarmerListAdapter;
import com.grameen.fdp.object.Farmer;
import com.grameen.fdp.object.Plot;
import com.grameen.fdp.utility.Utils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.SalesforceActivity;

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
 * Created by aangjnr on 08/11/2017.
 */



public class MainActivity extends SalesforceActivity implements NavigationView.OnNavigationItemSelectedListener, MaterialSearchBar.OnSearchActionListener{

    String TAG = "MainActivity";
    MaterialSearchBar searchBar;
    private DrawerLayout drawer;
    FloatingActionButton floatingActionButton;
    RecyclerView mRecycler;
    FarmerListAdapter mAdapter;
    List<Farmer> farmers;
    GridLayoutManager productsGridLayoutManager;
    private boolean IS_FAB_VISIBLE = false;

    ProgressDialog progressDialog;

    RestClient restClient = null;

    DatabaseHelper databaseHelper;


    @Override
    public void onResume(RestClient client) {

        restClient = client;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = DatabaseHelper.getInstance(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBar.enableSearch();
            }
        });
        searchBar.setOnSearchActionListener(this);
        //searchBar.inflateMenu(R.menu.main);
        Log.d("LOG_TAG", getClass().getSimpleName() + ": text " + searchBar.getText());
        searchBar.setCardViewElevation(10);
        searchBar.setRoundedSearchBarEnabled(false);



        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditFarmerDetailsActivity.class));
            }
        });



        mRecycler = (RecyclerView) findViewById(R.id.recycler_view);


        farmers = new ArrayList<>();
        farmers.add(new Farmer("0", "Farmer 1", "#001", "Village 1", null, "Secondary", "Male", "1967", "No", "0", "", "", "No", "0" ));
        farmers.add(new Farmer("1", "Farmer 2", "#002", "Village 2", null, "Secondary", "Female", "1967", "No", "0", "", "", "No", "0" ));
        farmers.add(new Farmer("2", "Farmer 3", "#003", "Village 3", null, "Secondary", "Male", "1977", "Yes", "1", "Spouse 3", "Primary", "No", "0" ));
        farmers.add(new Farmer("3", "Farmer 4", "#004", "Village 4", null, "Secondary", "Male", "1987", "No", "0", "", "", "No", "0" ));
        farmers.add(new Farmer("4", "Farmer 5", "#005", "Village 5", null, "Secondary", "Male", "1977", "Yes", "1", "Spouse 5", "Primary", "No", "0" ));
        farmers.add(new Farmer("5", "Farmer 6", "#006", "Village 6", null, "Secondary", "Male", "1965", "No", "0", "", "", "No", "0" ));
        farmers.add(new Farmer("6", "Farmer 7", "#007", "Village 7", null, "Secondary", "Male", "1977", "Yes", "1", "Spouse 7", "Primary", "No", "0" ));
        farmers.add(new Farmer("7", "Farmer 8", "#008", "Village 8", null, "Secondary", "Male", "1954", "No", "0", "", "", "No", "0" ));
        farmers.add(new Farmer("8", "Farmer 9", "#009", "Village 9", null, "Secondary", "Male", "1977", "Yes", "1", "Spouse 9", "Primary", "No", "0" ));
        farmers.add(new Farmer("9", "Farmer 10","#010", "Village 10", null, "Secondary", "Male", "1965", "No", "0", "", "", "No", "0" ));



        if(Utils.isTablet(this))
            productsGridLayoutManager = new GridLayoutManager(this, 6);
            else
            productsGridLayoutManager = new GridLayoutManager(this, 4);



        mRecycler.setLayoutManager(productsGridLayoutManager);
        BaseActivity.SpacesGridItemDecoration decoration = new BaseActivity.SpacesGridItemDecoration(8);
      //  mRecycler.addItemDecoration(decoration);


        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    // Scrolling up

                    floatingActionButton.hide();

                    IS_FAB_VISIBLE = false;


                } else {
                    // Scrolling down

                    floatingActionButton.show();

                    IS_FAB_VISIBLE = true;
                }
            }
        });



        mAdapter = new FarmerListAdapter(this, farmers);
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new FarmerListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                Farmer farmer = farmers.get(position);

                Plot plot1 = new Plot("0", "Plot 1", "5 Ha", "1.5", "1000kg", "22nd September, 2017");
                Plot plot2 = new Plot("1", "Plot 2", "1.4 Ha", "6", "900kg", "3rd September, 2017");
                Plot plot3 = new Plot("2", "Plot 3", "9 Acres", "7.5", "100kg", "14th September, 2017");

                List<Plot> plots = new ArrayList<Plot>();
                plots.add(plot1);
                plots.add(plot2);
                plots.add(plot3);

                farmer.setPlotsList(plots);

                farmer.setFarmArea("2 Ha");

                Intent intent = new Intent(MainActivity.this, FarmerDetailsActivity.class);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);
            }
        });











    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        drawer.closeDrawer(GravityCompat.START);

        switch(item.getItemId()){


            case R.id.sync:
                try {


                    progressDialog = BaseActivity.showProgress(this, "Getting data", "Please wait a moment", false);


                    String soql = "select id, Caption__c, Error_text__c, Help_Text__c, Max_value__c, Min_value__c, " +
                            "Options__c, Type__c, Form__r.Name, Form__r.Country__c from Question__c where Form__r.Country__r.ISO_code__c ='GHA'";

                    RestRequest restRequest = RestRequest.getRequestForQuery(ApiVersionStrings.getVersionNumber(this), soql);

                    sendRequest(restRequest);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                break;
        }


        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

        String s = enabled ? "enabled" : "disabled";
        Toast.makeText(MainActivity.this, "Search " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

        Toast.makeText(MainActivity.this, "Search confirmed " + text.toString(), Toast.LENGTH_SHORT).show();


        searchBar.clearSuggestions();
        searchBar.disableSearch();

    }


    @Override
    public void onButtonClicked(int buttonCode) {
        switch (buttonCode){
            case MaterialSearchBar.BUTTON_NAVIGATION:
                drawer.openDrawer(Gravity.LEFT);
                break;
            case MaterialSearchBar.BUTTON_BACK:
                searchBar.clearSuggestions();
                searchBar.disableSearch();

                break;


        }
    }



    @Override
    public void onBackPressed() {
        if(!IS_FAB_VISIBLE) {
            floatingActionButton.show();
            IS_FAB_VISIBLE = true;
        }else         if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (searchBar.isSearchEnabled()) {
            searchBar.clearSuggestions();
            searchBar.disableSearch();
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public void onResume() {

        super.onResume();






    }



    private void sendRequest(RestRequest request) {
         println("");
        BaseActivity.printHeader(request);
        try {
            sendFromUIThread(request);
        } catch (Exception e) {
            BaseActivity.printException(e);
        }
    }


    private void sendFromUIThread(RestRequest restRequest) throws UnsupportedEncodingException {
        System.out.println("\n\n");
        BaseActivity.printHeader(restRequest);

         final long start = System.nanoTime();


        restClient.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
            @Override
            public void onSuccess(RestRequest request, final RestResponse result) {
                result.consumeQuietly(); // consume before going back to main thread

                // consume before going back to main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();


                        if (result.isSuccess()) {
                            Log.d(TAG, "THE RESULT IS " + "A SUCCESS");


                            try {
                                int size = 0;
                                size = result.asString().length();
                                long duration = System.nanoTime() - start;
                                int statusCode = result.getStatusCode();
                                BaseActivity.printRequestInfo(duration, size, statusCode);

                                Log.d(TAG, "THE RESULT IS ");
                                System.out.println(result.asJSONObject());


                                Gson gson = new Gson();
                                Type listType = new TypeToken<List<Question>>() {}.getType();

                                JSONArray jsonArray = result.asJSONObject().getJSONArray("records");

                                List<Question> questions = (List<Question>) gson.fromJson(String.valueOf(jsonArray), listType);

                                Log.d(TAG, "SIZE OF QUESTIONS ARRAY IS " + questions.size());

                                if(
                                databaseHelper.deleteQuestionsTable()) {

                                    for (Question q : questions) {

                                        databaseHelper.addAQuestion(q);

                                    }

                                    Log.d(TAG, "QUESTIONS HAVE BEEN UPDATED! TOTAL SIZE IS " + databaseHelper.getAllQuestions().size());

                                }else {

                                   //CustomToast.makeToast(MainActivity.this, "Couldn't de", Toast.LENGTH_LONG).show();


                                    Log.d(TAG, "QUESTIONS TABLE WASN'T DELETED ");

                                 }




                            } catch (IOException | JSONException e) {
                                BaseActivity.printException(e);
                            }
                        }
                        else Log.d(TAG, "THE RESULT IS " + "A FAILURE");
                    }
                });


            }

            @Override
            public void onError(final Exception exception) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        progressDialog.dismiss();

                        BaseActivity.printHeader("Could not build query request");
                        BaseActivity.printException(exception);

                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        return super.onOptionsItemSelected(item);

    }






}
