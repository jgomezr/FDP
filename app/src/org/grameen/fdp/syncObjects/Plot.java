package org.grameen.fdp.syncObjects;

import com.google.gson.annotations.Expose;

/**
 * Created by aangjnr on 24/03/2018.
 */

public class Plot {


    String Farmer_code__c;
    String External_id__c;
    String Plot_area_coordinates__c;
    String Plot_name__c;
    String Recommendation_id__c;
    int Start_year__c;
    String Submission__c;


    public Plot() {
    }


    public void setSubmission__c(String submission__c) {
        Submission__c = submission__c;
    }

    public void setExternal_id__c(String external_id__c) {
        External_id__c = external_id__c;
    }

    public void setFarmer_code__c(String farmer_code__c) {
        Farmer_code__c = farmer_code__c;
    }

    public void setPlot_area_coordinates__c(String plot_area_coordinates__c) {
        Plot_area_coordinates__c = plot_area_coordinates__c;
    }

    public void setPlot_name__c(String plot_name__c) {
        Plot_name__c = plot_name__c;
    }

    public void setRecommendation_id__c(String recommendation_id__c) {
        Recommendation_id__c = recommendation_id__c;
    }

    public String getRecommendation_id__c() {
        return Recommendation_id__c;
    }


    public void setStart_year__c(int start_year__c) {
        Start_year__c = start_year__c;
    }

    public int getStart_year__c() {
        return Start_year__c;
    }

    public String getSubmission__c() {
        return Submission__c;
    }

    public String getExternal_id__c() {
        return External_id__c;
    }

    public String getFarmer_code__c() {
        return Farmer_code__c;
    }

    public String getPlot_area_coordinates__c() {
        return Plot_area_coordinates__c;
    }

    public String getPlot_name__c() {
        return Plot_name__c;
    }


}
