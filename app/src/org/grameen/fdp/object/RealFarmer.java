package org.grameen.fdp.object;

/**
 * Created by aangjnr on 13/12/2017.
 */

public class RealFarmer {

    String farmerName;
    String code;
    String id;
    String village;
    String gender;
    String birthYear;

    String educationLevel;
    String imageUrl;
    String lastVisitDate;
    String landArea;


    String farmerProfileJson;
    String familyMembersJson;

    String aggregateEconomicResultsJson;
    String productiveProfileJson;
    String farmingEconomicProfileJson;
    String socioEconomicProfileJson;
    String otherJson;

    String plotsInfoJson;

    int syncStatus;
    String hasRegistered;


    public String getLandArea() {

        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String education) {
        this.educationLevel = education;
    }

    public String getFamilyMembersJson() {
        return familyMembersJson;
    }

    public void setFamilyMembersJson(String familyMembersJson) {
        this.familyMembersJson = familyMembersJson;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getHasRegistered() {
        return hasRegistered;
    }

    public void setHasRegistered(String hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public String getOtherJson() {
        return otherJson;
    }

    public void setOtherJson(String otherJson) {
        this.otherJson = otherJson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAggregateEconomicResultsJson() {
        return aggregateEconomicResultsJson;
    }

    public void setAggregateEconomicResultsJson(String aggregateEconomicResultsJson) {
        this.aggregateEconomicResultsJson = aggregateEconomicResultsJson;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerProfileJson() {
        return farmerProfileJson;
    }

    public void setFarmerProfileJson(String farmerProfile) {
        this.farmerProfileJson = farmerProfile;
    }

    public String getFarmingEconomicProfileJson() {
        return farmingEconomicProfileJson;
    }

    public void setFarmingEconomicProfileJson(String farmingEconomicProfileJson) {
        this.farmingEconomicProfileJson = farmingEconomicProfileJson;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProductiveProfileJson() {
        return productiveProfileJson;
    }

    public void setProductiveProfileJson(String productiveProfileJson) {
        this.productiveProfileJson = productiveProfileJson;
    }

    public String getSocioEconomicProfileJson() {
        return socioEconomicProfileJson;
    }

    public void setSocioEconomicProfileJson(String socioEconomicProfileJson) {
        this.socioEconomicProfileJson = socioEconomicProfileJson;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPlotsInfoJson() {
        return plotsInfoJson;
    }

    public void setPlotsInfoJson(String plotsInfoJson) {
        this.plotsInfoJson = plotsInfoJson;
    }
}
