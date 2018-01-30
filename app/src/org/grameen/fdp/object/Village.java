package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 30/01/2018.
 */

public class Village {


    String Name;
    String Id;

    @SerializedName("district__c")
    String district;


    public void setName(String name) {
        Name = name;
    }


    public void setId(String id) {
        Id = id;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public String getDistrict() {
        return district;
    }
}
