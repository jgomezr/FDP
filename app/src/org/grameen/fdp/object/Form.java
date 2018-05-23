package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Form {


    @SerializedName("LastModifiedDate")
    String lastModifiedDate;

    String Name;
    @SerializedName("Type__c")
    String type;

    @SerializedName("Display_Name__c")
    String diaplayName;


    @SerializedName("Display_Order__c")
    Double diaplayOrder;

    @SerializedName("Translation__c")
    String translation;

    String Id;

    public Form() {
    }

    Form(String name, String type) {
        this.Name = name;
        this.type = type;
    }


    public void setDiaplayOrder(Double diaplayOrder) {
        this.diaplayOrder = diaplayOrder;
    }

    public Double getDiaplayOrder() {
        return diaplayOrder;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
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

    public void setId(String id) {
        Id = id;
    }

    public void setDiaplayName(String diaplayName) {
        this.diaplayName = diaplayName;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getId() {
        return Id;
    }

    public String getDiaplayName() {
        return diaplayName;
    }

    public String getTranslation() {
        return translation;
    }
}
