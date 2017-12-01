package com.grameen.fdp.object;

/**
 * Created by aangjnr on 19/09/2017.
 */


import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;


public class Loc {


    @SerializedName("latitude")
    private String latitude;


    @SerializedName("lonngitude")
    private String longitude;



    String plotId;


    public Loc(){}


    public Loc(String plotId, String lat, String lon){
        this.latitude = lat;
        this.longitude = lon;
        this.plotId = plotId;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }




    LatLng getLatLng(){
        return new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));


    }
}
