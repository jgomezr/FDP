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

    @SerializedName("Input__c")
    String inputId;

    @SerializedName("Cost__c")
    String totalCost;

    @SerializedName("Recommendation__c")
    String recommendationId;

    @SerializedName("reco__c")
    String recommendationName;


    public ActivitiesPlusInputs() {
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

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputUnitCost) {
        this.inputId = inputUnitCost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRecommendationName() {
        return recommendationName;
    }

    public void setRecommendationName(String recommendationName) {
        this.recommendationName = recommendationName;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }


}
