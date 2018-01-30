package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 17/01/2018.
 */

public class RecommendationsPlusActivity {


    @SerializedName("Id")
    String id;

    @SerializedName("Name")
    String name;

    @SerializedName("Activity__c")
    String activityId;

    @SerializedName("Activity__r.Name")
    String activityName;

    @SerializedName("Labor_cost__c")
    String laborCost;

    @SerializedName("Labor_days_need__c")
    String laborDaysNeeded;

    @SerializedName("Month__c")
    String month;

    @SerializedName("Recommendation__c")
    String recommendationId;

    @SerializedName("Supplies_cost__c")
    String suppliesCost;

    @SerializedName("Year__c")
    String year;





    public RecommendationsPlusActivity(){}


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public void setLaborDaysNeeded(String laborDaysNeeded) {
        this.laborDaysNeeded = laborDaysNeeded;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public void setSuppliesCost(String suppliesCost) {
        this.suppliesCost = suppliesCost;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public String getLaborDaysNeeded() {
        return laborDaysNeeded;
    }

    public String getMonth() {
        return month;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public String getSuppliesCost() {
        return suppliesCost;
    }

    public String getYear() {
        return year;
    }
}
