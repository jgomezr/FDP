package org.grameen.fdp.syncObjects;

import com.google.gson.annotations.Expose;

/**
 * Created by aangjnr on 24/03/2018.
 */

public class MonitoringAnswer {


    String Answer__c;
    String Question__c;
    String Competence__c;
    String Competence_Answer__c;
    String Reasons_For_Failure__c;
    String Reasons_for_failure_answer__c;
    String External_id__c;
    String Monitoring__c;
    String Submission__c;


    public MonitoringAnswer() {
    }

    public void setExternal_id__c(String external_id__c) {
        External_id__c = external_id__c;
    }

    public void setSubmission__c(String submission__c) {
        Submission__c = submission__c;
    }

    public void setQuestion__c(String question__c) {
        Question__c = question__c;
    }

    public void setAnswer__c(String answer__c) {
        Answer__c = answer__c;
    }

    public void setCompetence__c(String competence__c) {
        Competence__c = competence__c;
    }

    public void setCompetence_Answer__c(String competence_Answer__c) {
        Competence_Answer__c = competence_Answer__c;
    }

    public void setMonitoring__c(String monitoring__c) {
        Monitoring__c = monitoring__c;
    }

    public void setReasons_For_Failure__c(String reasons_For_Failure__c) {
        Reasons_For_Failure__c = reasons_For_Failure__c;
    }

    public void setReasons_for_failure_answer__c(String reasons_for_failure_answer__c) {
        Reasons_for_failure_answer__c = reasons_for_failure_answer__c;
    }

    public String getExternal_id__c() {
        return External_id__c;
    }

    public String getSubmission__c() {
        return Submission__c;
    }

    public String getQuestion__c() {
        return Question__c;
    }

    public String getAnswer__c() {
        return Answer__c;
    }

    public String getCompetence__c() {
        return Competence__c;
    }

    public String getCompetence_Answer__c() {
        return Competence_Answer__c;
    }

    public String getMonitoring__c() {
        return Monitoring__c;
    }

    public String getReasons_For_Failure__c() {
        return Reasons_For_Failure__c;
    }

    public String getReasons_for_failure_answer__c() {
        return Reasons_for_failure_answer__c;
    }
}
