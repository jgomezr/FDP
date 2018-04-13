package org.grameen.fdp.syncObjects;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by aangjnr on 24/03/2018.
 */

public class Answer {


    String Answer__c;
    Date Date__c;
    String External_id__c;
    String Farmer_ID__c;
    String Question__c;
    String Submission__c;
    String Plot__c;


    public Answer() {
    }


    public void setSubmission__c(String submission__c) {
        Submission__c = submission__c;
    }

    public void setAnswer__c(String answer__c) {
        Answer__c = answer__c;
    }

    public void setDate__c(Date date__c) {
        Date__c = date__c;
    }


    public void setFarmer_ID__c(String farmer_ID__c) {
        Farmer_ID__c = farmer_ID__c;
    }

    public void setQuestion__c(String question__c) {
        Question__c = question__c;
    }

    public String getSubmission__c() {
        return Submission__c;
    }

    public Date getDate__c() {
        return Date__c;
    }

    public String getAnswer__c() {
        return Answer__c;
    }


    public void setExternal_id__c(String external_id__c) {
        External_id__c = external_id__c;
    }

    public String getExternal_id__c() {
        return External_id__c;
    }

    public String getFarmer_ID__c() {
        return Farmer_ID__c;
    }

    public String getQuestion__c() {
        return Question__c;
    }


    public void setPlot__c(String plot__c) {
        Plot__c = plot__c;
    }

    public String getPlot__c() {
        return Plot__c;
    }


}
