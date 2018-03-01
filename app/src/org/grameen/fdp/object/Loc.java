package org.grameen.fdp.object;

/**
 * Created by aangjnr on 19/09/2017.
 */


import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;


public class Loc {


    String plotId;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("lonngitude")
    private String longitude;


    public Loc() {
    }


    public Loc(String plotId, String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
        this.plotId = plotId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    LatLng getLatLng() {
        return new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));


    }
}
