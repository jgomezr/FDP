package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Form {


    String Name;
    @SerializedName("Country__c")
    String Id;

    public Form(){}
    Form(String name, String countryId){this.Name = name; this.Id = countryId;}


    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId(String countryId) {
        Id = countryId;
    }
}
