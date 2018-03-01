package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Form {


    String Name;
    @SerializedName("Type__c")
    String type;

    String Id;

    public Form() {
    }

    Form(String name, String type) {
        this.Name = name;
        this.type = type;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
