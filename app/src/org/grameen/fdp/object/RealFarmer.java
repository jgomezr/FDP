package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 13/12/2017.
 */

public class RealFarmer {

    @SerializedName("LastModifiedDate")
    String lastModifiedDate;


    int _ID;
    String farmerName;
    String code;
    String id;
    String village;
    String gender;
    String birthYear = "1970";
    String educationLevel;
    String imageUrl;
    String firstVisitDate;

    String lastVisitDate;
    String landArea;

    String answersJson;


    Integer syncStatus;
    String hasSubmitted;


    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int get_ID() {
        return _ID;
    }

    public void setFirstVisitDate(String firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public String getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setAnswersJson(String answersJson) {
        this.answersJson = answersJson;
    }

    public String getAnswersJson() {
        return answersJson;
    }

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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getHasSubmitted() {
        return hasSubmitted;
    }

    public void setHasSubmitted(String hasSubmitted) {
        this.hasSubmitted = hasSubmitted;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }


 }
