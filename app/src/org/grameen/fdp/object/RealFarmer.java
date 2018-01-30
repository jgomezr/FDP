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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setEducationLevel(String education) {
        this.educationLevel = education;
    }

    public String getEducationLevel() {
        return educationLevel;
    }


    public void setFamilyMembersJson(String familyMembersJson) {
        this.familyMembersJson = familyMembersJson;
    }

    public String getFamilyMembersJson() {
        return familyMembersJson;
    }


    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public void setHasRegistered(String hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public String getHasRegistered() {
        return hasRegistered;
    }

    public void setId(String id) {
        this.id = id;
    }




    public void setAggregateEconomicResultsJson(String aggregateEconomicResultsJson) {
        this.aggregateEconomicResultsJson = aggregateEconomicResultsJson;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public void setFarmerProfileJson(String farmerProfile) {
        this.farmerProfileJson = farmerProfile;
    }

    public void setFarmingEconomicProfileJson(String farmingEconomicProfileJson) {
        this.farmingEconomicProfileJson = farmingEconomicProfileJson;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProductiveProfileJson(String productiveProfileJson) {
        this.productiveProfileJson = productiveProfileJson;
    }

    public void setSocioEconomicProfileJson(String socioEconomicProfileJson) {
        this.socioEconomicProfileJson = socioEconomicProfileJson;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setOtherJson(String otherJson) {
        this.otherJson = otherJson;
    }

    public String getOtherJson() {
        return otherJson;
    }

    public String getId() {
        return id;
    }



    public String getAggregateEconomicResultsJson() {
        return aggregateEconomicResultsJson;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCode() {
        return code;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getFarmerProfileJson() {
        return farmerProfileJson;
    }

    public String getFarmingEconomicProfileJson() {
        return farmingEconomicProfileJson;
    }

    public String getGender() {
        return gender;
    }

    public String getProductiveProfileJson() {
        return productiveProfileJson;
    }

    public String getSocioEconomicProfileJson() {
        return socioEconomicProfileJson;
    }

    public String getVillage() {
        return village;
    }

    public String getPlotsInfoJson() {
        return plotsInfoJson;
    }

    public void setPlotsInfoJson(String plotsInfoJson) {
        this.plotsInfoJson = plotsInfoJson;
    }
}
