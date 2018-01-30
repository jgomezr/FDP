package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 22/01/2018.
 */

public class ActivitiesPlusInputs {



    @SerializedName("Id")
    String id;

    @SerializedName("Name")
    String name;

    @SerializedName("Input_type__c")
    String inputType;

    @SerializedName("Quantity__c")
    String quantity;

    @SerializedName("Input__r.Cost__c")
    String inputUnitCost;

    @SerializedName("Cost__c")
    String totalCost;

    @SerializedName("Input__r.Unit__c")
    String inputSIUnit;


    @SerializedName("Recommendation__c")
    String recommendationId;

    @SerializedName("reco__c")
    String recommendationName;



    public ActivitiesPlusInputs(){}


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public void setInputSIUnit(String inputSIUnit) {
        this.inputSIUnit = inputSIUnit;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public void setInputUnitCost(String inputUnitCost) {
        this.inputUnitCost = inputUnitCost;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setRecommendationName(String recommendationName) {
        this.recommendationName = recommendationName;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public String getInputSIUnit() {
        return inputSIUnit;
    }

    public String getInputType() {
        return inputType;
    }

    public String getInputUnitCost() {
        return inputUnitCost;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getRecommendationName() {
        return recommendationName;
    }

    public String getTotalCost() {
        return totalCost;
    }


}
