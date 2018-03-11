package org.grameen.fdp.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.google.maps.android.SphericalUtil;

import org.grameen.fdp.R;
import org.grameen.fdp.adapter.PointsListAdapter;
import org.grameen.fdp.object.Plot;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.PermissionsUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class MapActivity extends BaseActivity {

    public static Float DEFAULT_ZOOM = 17.0f;
    ProgressDialog progressDialog;
    String TAG = getClass().getSimpleName();
    Button addPoint;
    Button calculateArea;
    List<LatLng> latLngs = new ArrayList<>();
    Plot plot;
    RecyclerView recyclerView;
    boolean GpsStatus = false;
    LocationManager locationManager;
    boolean hasCalculated = false;
    PointsListAdapter mAdapter;
    Double AREA_OF_PLOT;
    android.location.LocationListener locationListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setIndeterminate(true);

        recyclerView = findViewById(R.id.recycler_view);


        plot = new Gson().fromJson(getIntent().getStringExtra("plot"), Plot.class);

        Toolbar toolbar;
        if (plot != null) {
            toolbar = setToolbar(plot.getName() +" " + getResources(R.string.title_area_calc));

        } else {
            toolbar = setToolbar("Plot Area Mapping");


        }


        mAdapter = new PointsListAdapter(this, latLngs);
        mAdapter.setHasStableIds(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new PointsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                mAdapter.removePoint(position);
                //latLngs.remove(position);

                if(latLngs.size() > 2)
                    calculateArea.setEnabled(true);
                    else
                        calculateArea.setEnabled(false);


                if(latLngs.size() > 0) {
                    if(findViewById(R.id.placeHolder).getVisibility() == View.VISIBLE)
                        findViewById(R.id.placeHolder).setVisibility(View.GONE);



                }else{

                    if(findViewById(R.id.placeHolder).getVisibility() == View.GONE)
                        findViewById(R.id.placeHolder).setVisibility(View.VISIBLE);

                }

            }
        });


        calculateArea = (Button) findViewById(R.id.calculate);
        calculateArea.setEnabled(false);

        calculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (latLngs != null && latLngs.size() > 2) {

                if (!hasCalculated) {
                    computeAreaInSquareMeters();

                }else{
                        showAlertDialog(false, "Area of plot", "The area of " + plot.getName() + " in square meters is " + AREA_OF_PLOT, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                                plot.setArea(AREA_OF_PLOT.toString());

                            }
                        }, getResources(R.string.ok),null, "", 0);

                        hasCalculated = true;

                }

                } else
                    CustomToast.makeToast(MapActivity.this, "Please add 3 or more points to calculate the area of " + plot.getName(), Toast.LENGTH_LONG);




            }
        });

        addPoint = (Button) findViewById(R.id.addPoint);
        addPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                addPoint.setEnabled(false);
                getCurrentLocation();

            }
        });







        onBackClicked();


        locationListener = new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Log.i(TAG, "^^^^^^^^^^ LOCATION CHANGED ^^^^^^^^^^^^");

                LatLng newLL = new LatLng(location.getLatitude(), location.getLongitude());
                mAdapter.addPoint(newLL);
                addPoint.setEnabled(true);
                progressDialog.dismiss();
                hasCalculated = false;

                if(latLngs.size() > 0) {
                    if(findViewById(R.id.placeHolder).getVisibility() == View.VISIBLE)
                    findViewById(R.id.placeHolder).setVisibility(View.GONE);

                }

                if(latLngs.size() > 2) {
                    calculateArea.setEnabled(true);

                }
                else {
                    calculateArea.setEnabled(false);

                }


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {
                Log.i(TAG, "^^^^^^^^^^ PROVIDER ENABLED ^^^^^^^^^^^^");

            }

            @Override
            public void onProviderDisabled(String s) {
                Log.i(TAG, "^^^^^^^^^^ PROVIDER DISABLED ^^^^^^^^^^^^");


            }
        };



    }



    void computeAreaInSquareMeters() {

            AREA_OF_PLOT = SphericalUtil.computeArea(latLngs);
            Log.d(TAG, "computeAreaInSquareMeters " + AREA_OF_PLOT);


            showAlertDialog(false, "Area of plot", "The area of " + plot.getName() + " in square meters is " + new DecimalFormat("0.00").format(AREA_OF_PLOT), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();

                    plot.setArea(AREA_OF_PLOT.toString());

                }
            }, getResources(R.string.ok),null, "", 0);


            hasCalculated = true;
 }


    double convertToHectres(Double valueInSquareMetres) {

        return valueInSquareMetres / 10000;

    }

    double convertToAcres(Double valueInSquareMetres) {

        return valueInSquareMetres / 4040.856;

    }



    private void getCurrentLocation() {

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (GpsStatus) {

            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            criteria.setPowerRequirement(Criteria.POWER_LOW);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setCostAllowed(true);
            criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
            criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);


            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            // This is the Best And IMPORTANT part
            final Looper looper = null;

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                if (locationManager != null) {
                    locationManager.requestSingleUpdate(criteria, locationListener, looper);
                }
            }
        } else {

            CustomToast.makeToast(this, "Please Enable GPS First", Toast.LENGTH_LONG).show();

        }


    }



}
