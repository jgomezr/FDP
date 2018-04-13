package org.grameen.fdp.syncObjects;

/**
 * Created by aangjnr on 28/03/2018.
 */

public class Assignation {


    String External_id__c;
    String Farmer__c;
    String User__c;


    public Assignation() {
    }


    public void setExternal_id__c(String external_id__c) {
        External_id__c = external_id__c;
    }

    public void setFarmer__c(String farmer__c) {
        Farmer__c = farmer__c;
    }

    public void setUser__c(String user__c) {
        User__c = user__c;
    }

    public String getExternal_id__c() {
        return External_id__c;
    }

    public String getFarmer__c() {
        return Farmer__c;
    }

    public String getUser__c() {
        return User__c;
    }
}
