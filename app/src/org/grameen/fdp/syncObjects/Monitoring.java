package org.grameen.fdp.syncObjects;

import com.google.gson.annotations.Expose;

/**
 * Created by aangjnr on 24/03/2018.
 */

public class Monitoring {


    String External_id__c;
    String MonitoringName__c;
    String Plot__c;
    String Result__c;
    String Submission__c;
    String Year__c;

    String Plot_External_id__c;


    public Monitoring() {
    }


    public void setExternal_id__c(String external_id__c) {
        External_id__c = external_id__c;
    }

    public void setPlot__c(String plot__c) {
        Plot__c = plot__c;
    }

    public void setMonitoringName__c(String monitoringName__c) {
        MonitoringName__c = monitoringName__c;
    }

    public void setResult__c(String result__c) {
        Result__c = result__c;
    }


    public void setSubmission__c(String submission__c) {
        Submission__c = submission__c;
    }

    public String getSubmission__c() {
        return Submission__c;
    }

    public void setYear__c(String year__c) {
        Year__c = year__c;
    }

    public String getExternal_id__c() {
        return External_id__c;
    }

    public String getPlot__c() {
        return Plot__c;
    }

    public String getMonitoringName__c() {
        return MonitoringName__c;
    }

    public String getResult__c() {
        return Result__c;
    }


    public String getYear__c() {
        return Year__c;
    }


    public void setPlot_External_id__c(String plot_External_id__c) {
        Plot_External_id__c = plot_External_id__c;
    }

    public String getPlot_External_id__c() {
        return Plot_External_id__c;
    }
}
