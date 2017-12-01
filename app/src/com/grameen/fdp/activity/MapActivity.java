package com.grameen.fdp.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

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
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import com.grameen.fdp.R;
import com.grameen.fdp.object.Plot;
import com.grameen.fdp.utility.Constants;
import com.grameen.fdp.utility.PermissionsUtils;

import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class MapActivity extends BaseActivity implements
        OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, LocationListener {

    ProgressDialog progressDialog;
    String TAG = getClass().getSimpleName();
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    public static Float DEFAULT_ZOOM = 17.0f;
    private CameraPosition mCameraPosition;
    private boolean mPermissionDenied = false;

    Button addPoint;

    Plot plot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        plot = new Gson().fromJson(getIntent().getStringExtra("plot"), Plot.class);

        Toolbar toolbar;
        if(plot != null) {
              toolbar = setToolbar(plot.getName() + " Mappings");

        }else{
            toolbar = setToolbar("Plot Mappings");


        }



        addPoint = (Button) findViewById(R.id.addPoint);
        addPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addMarker();


            }
        });


        addPoint.setEnabled(false);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setIndeterminate(true);

        // Toolbar toolbar = setToolbar("Add a new plot");




        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        Log.d(TAG, "Map is ready");

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        findViewById(R.id.mainLayout).post(new Runnable() {
            @Override
            public void run() {
                startRevealAnimation(findViewById(R.id.mainLayout));

            }
        });


        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.getUiSettings().setMapToolbarEnabled(false);


        requestLocation();
        progressDialog.show();



    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        Log.d(TAG, "OnConnected");

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            // Retrieve the user’s last known location//
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                    mLocationRequest, this);



            addPoint.setEnabled(false);


        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "On connection suspended");


    }

    @Override
    public void onLocationChanged(Location location) {


        Log.d(TAG, "On location changed");


        if(progressDialog.isShowing())
            progressDialog.hide();

        if(!addPoint.isEnabled())
            addPoint.setEnabled(true);


        //Get new details from server, populate location of tow truck and tow location

        mLastLocation = location;

        addOverlay(mMap, new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));

        mCameraPosition = moveCameraToPosition(mMap, new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), DEFAULT_ZOOM);


        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }


        if (mMap.isMyLocationEnabled()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);

        }


    }








    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @Nullable String permissions[], @Nullable int[] grantResults) {


        switch (requestCode) {
            case Constants.PERMISSION_FINE_LOCATION: {
                Log.d(TAG, "Permission Loc");


                // If the request is cancelled, the result array will be empty (0)//
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Permission granted");


                    // If the user has granted your permission request, then your app can now perform all its
                    // location-related tasks, including displaying the user’s location on the map//
                    if (PermissionsUtils.isPermissionGranted(permissions, grantResults,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                        if (mGoogleApiClient == null) {
                            Log.d(TAG, "Google client is null, Building client");

                            mGoogleApiClient = buildGoogleApiClient(this);

                            if (mMap != null) {

                                if ( ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                                        != PackageManager.PERMISSION_GRANTED &&  ActivityCompat.checkSelfPermission(this,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                                    return;
                                }
                                mMap.setMyLocationEnabled(true);

                            }
                        }

                    } else {
                        // Display the missing permission error dialog when the fragments resume.
                        mPermissionDenied = true;
                    }
                }
            }
        }
    }


    @Override
    public void onStop() {
        super.onStop();

        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }


    @Override
    public void onResume() {
        super.onResume();

        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showAlertDialog(true, "Location permission", "Please grant location permission for the map to work properly", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }, "CANCEL", 0);
                    mPermissionDenied = false;
        } else {

            if (mGoogleApiClient != null)
                mGoogleApiClient.connect();


        }
    }






    void startRevealAnimation(View myView) {


        // get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int dx = Math.max(cx, myView.getWidth() - cx);
        int dy = Math.max(cy, myView.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        // Android native animator
        Animator animator =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(1500);
        animator.start();
     }

    void requestLocation() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "Permission not granted");


            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION}, Constants.PERMISSION_FINE_LOCATION);
        } else {

            Log.d(TAG, "Permission Granted, no need for checking");


            mGoogleApiClient = buildGoogleApiClient(this);

            mMap.setMyLocationEnabled(true);


        }
    }

    protected synchronized GoogleApiClient buildGoogleApiClient(GoogleApiClient.ConnectionCallbacks callbacks) {

        GoogleApiClient mGoogleApiClient;
        // Use the GoogleApiClient.Builder class to create an instance of the
        // Google Play Services API client//
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(callbacks)
                .addApi(LocationServices.API)
                .build();

        // Connect to Google Play Services, by calling the connect() method//
        mGoogleApiClient.connect();

        return mGoogleApiClient;
    }

    GroundOverlay addOverlay(GoogleMap mMap, LatLng place) {

        GroundOverlay groundOverlay = mMap.addGroundOverlay(new
                GroundOverlayOptions()
                .position(place, 100)
                .transparency(0.5f)
                .zIndex(3)
                .image(BitmapDescriptorFactory.fromBitmap(drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.map_overlay)))));

        startOverlayAnimation(groundOverlay);

        return groundOverlay;
    }


    Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


    void startOverlayAnimation(final GroundOverlay groundOverlay) {

        AnimatorSet animatorSet = new AnimatorSet();

        ValueAnimator vAnimator = ValueAnimator.ofInt(0, 100);
        vAnimator.setRepeatCount(ValueAnimator.INFINITE);
        vAnimator.setRepeatMode(ValueAnimator.RESTART);
        vAnimator.setInterpolator(new LinearInterpolator());
        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                final Integer val = (Integer) valueAnimator.getAnimatedValue();
                groundOverlay.setDimensions(val);


            }
        });

        ValueAnimator tAnimator = ValueAnimator.ofFloat(0, 1);
        tAnimator.setRepeatCount(ValueAnimator.INFINITE);
        tAnimator.setRepeatMode(ValueAnimator.RESTART);
        tAnimator.setInterpolator(new LinearInterpolator());
        tAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float val = (Float) valueAnimator.getAnimatedValue();
                groundOverlay.setTransparency(val);

            }
        });

        animatorSet.setDuration(3000);
        animatorSet.playTogether(vAnimator, tAnimator);
        animatorSet.start();
    }

    CameraPosition moveCameraToPosition(GoogleMap mMap, LatLng latLng, Float ZOOM) {

        CameraPosition mCameraPosition = new CameraPosition.Builder()
                .target(latLng)
                .zoom(ZOOM)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(mCameraPosition));

      /*
        if (mLastLocation != null) {

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(mLastLocation.getLatitude(),
                            mLastLocation.getLongitude()), DEFAULT_ZOOM));
        }*/


        return mCameraPosition;
    }



    void addMarker(){


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .draggable(false).visible(true));


    }



    void clearMap(View v){

        mMap.clear();

    }

}
