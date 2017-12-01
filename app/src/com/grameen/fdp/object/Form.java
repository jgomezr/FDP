package com.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Form {


    String Name;
    @SerializedName("Country__c")
    String CountryId;

    public Form(){}
    Form(String name, String countryId){this.Name = name; this.CountryId = countryId;}


    public String getName() {
        return Name;
    }

    public String getCountryId() {
        return CountryId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountryId(String countryId) {
        CountryId = countryId;
    }
}
