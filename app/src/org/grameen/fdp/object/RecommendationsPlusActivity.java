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


    @SerializedName("Activity_Name__c")
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


    public RecommendationsPlusActivity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public String getLaborDaysNeeded() {
        return laborDaysNeeded;
    }

    public void setLaborDaysNeeded(String laborDaysNeeded) {
        this.laborDaysNeeded = laborDaysNeeded;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getSuppliesCost() {
        return suppliesCost;
    }

    public void setSuppliesCost(String suppliesCost) {
        this.suppliesCost = suppliesCost;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }
}
