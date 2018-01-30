package org.grameen.fdp.object;

import java.util.List;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class Farmer {

    String id;
    String name;
    String code;
    String villageName;
    String educationLevel;
    String gender;
    String birthYear;
    String haveSpouse;
    String noOfSpouses;
    String spouseName;
    String spouseEducationLevel;
    String haveChildren;
    String noOfChildren;
    String farmArea;
    String lastVisitDate;
    String imageUrl;
    String landSize;

    int syncStatus;

    List<Plot> plotsList;





    /////////////////////////////////////////////////

    String age__c;
    String assignedTo__c;
    String birthday__c;
    String Count_Farmer__c;
    String country__c;
    String district__c;
    String educationalLevel__c;
    String Family_members__c;

    String farmerCode__c;
    String farmer_group__c;
    String FDP_Farm__c;
    String FDP_submission__c;
    String fullName__c;
    String gender__c;
    String gps__c;
    String Has_farmer_profile__c;
    String Has_fdp__c;
    String householdAddress__c;
    String Initial_baseline_date__c;
    String Last_baseline_date__c;
    String yearsRelationshipWithMars__c;
    String Number_of_baselines__c;
    String organization__c;
    String Phone_number__c;
    String Postal_address__c;
    String reasonRetreat__c;
    String registrationDate__c;
    String spouseAge__c;
    String spouseBirthday__c;
    String spouseEducationallevel__c;
    String spouseName__c;
    String status__c;
    String Status_indicator__c;
    String UTZ_starting_year__c;
    String village__c;
    String village_name__c;


    Farmer(){}

    public void setFDP_submission__c(String FDP_submission__c) {
        this.FDP_submission__c = FDP_submission__c;
    }

    public void setAge__c(String age__c) {
        this.age__c = age__c;
    }

    public void setAssignedTo__c(String assignedTo__c) {
        this.assignedTo__c = assignedTo__c;
    }

    public void setLandSize(String landSize) {
        this.landSize = landSize;
    }

    public void setBirthday__c(String birthday__c) {
        this.birthday__c = birthday__c;
    }

    public void setCount_Farmer__c(String count_Farmer__c) {
        Count_Farmer__c = count_Farmer__c;
    }

    public void setCountry__c(String country__c) {
        this.country__c = country__c;
    }

    public void setDistrict__c(String district__c) {
        this.district__c = district__c;
    }

    public void setEducationalLevel__c(String educationalLevel__c) {
        this.educationalLevel__c = educationalLevel__c;
    }

    public void setFamily_members__c(String family_members__c) {
        Family_members__c = family_members__c;
    }

    public void setFarmer_group__c(String farmer_group__c) {
        this.farmer_group__c = farmer_group__c;
    }

    public void setFarmerCode__c(String farmerCode__c) {
        this.farmerCode__c = farmerCode__c;
    }

    public void setFDP_Farm__c(String FDP_Farm__c) {
        this.FDP_Farm__c = FDP_Farm__c;
    }

    public void setFullName__c(String fullName__c) {
        this.fullName__c = fullName__c;
    }

    public void setGender__c(String gender__c) {
        this.gender__c = gender__c;
    }

    public void setGps__c(String gps__c) {
        this.gps__c = gps__c;
    }

    public void setHas_farmer_profile__c(String has_farmer_profile__c) {
        Has_farmer_profile__c = has_farmer_profile__c;
    }

    public void setHas_fdp__c(String has_fdp__c) {
        Has_fdp__c = has_fdp__c;
    }

    public void setHouseholdAddress__c(String householdAddress__c) {
        this.householdAddress__c = householdAddress__c;
    }

    public void setInitial_baseline_date__c(String initial_baseline_date__c) {
        Initial_baseline_date__c = initial_baseline_date__c;
    }

    public void setLast_baseline_date__c(String last_baseline_date__c) {
        Last_baseline_date__c = last_baseline_date__c;
    }

    public void setNumber_of_baselines__c(String number_of_baselines__c) {
        Number_of_baselines__c = number_of_baselines__c;
    }

    public void setOrganization__c(String organization__c) {
        this.organization__c = organization__c;
    }

    public void setPhone_number__c(String phone_number__c) {
        Phone_number__c = phone_number__c;
    }

    public void setPostal_address__c(String postal_address__c) {
        Postal_address__c = postal_address__c;
    }

    public void setReasonRetreat__c(String reasonRetreat__c) {
        this.reasonRetreat__c = reasonRetreat__c;
    }

    public void setRegistrationDate__c(String registrationDate__c) {
        this.registrationDate__c = registrationDate__c;
    }

    public void setSpouseAge__c(String spouseAge__c) {
        this.spouseAge__c = spouseAge__c;
    }

    public void setSpouseBirthday__c(String spouseBirthday__c) {
        this.spouseBirthday__c = spouseBirthday__c;
    }

    public void setSpouseEducationallevel__c(String spouseEducationallevel__c) {
        this.spouseEducationallevel__c = spouseEducationallevel__c;
    }

    public void setSpouseName__c(String spouseName__c) {
        this.spouseName__c = spouseName__c;
    }

    public void setStatus__c(String status__c) {
        this.status__c = status__c;
    }

    public void setStatus_indicator__c(String status_indicator__c) {
        Status_indicator__c = status_indicator__c;
    }

    public void setUTZ_starting_year__c(String UTZ_starting_year__c) {
        this.UTZ_starting_year__c = UTZ_starting_year__c;
    }

    public void setVillage__c(String village__c) {
        this.village__c = village__c;
    }

    public void setVillage_name__c(String village_name__c) {
        this.village_name__c = village_name__c;
    }

    public void setYearsRelationshipWithMars__c(String yearsRelationshipWithMars__c) {
        this.yearsRelationshipWithMars__c = yearsRelationshipWithMars__c;
    }

    public String getFDP_submission__c() {
        return FDP_submission__c;
    }

    public String getAge__c() {
        return age__c;
    }

    public String getAssignedTo__c() {
        return assignedTo__c;
    }

    public String getBirthday__c() {
        return birthday__c;
    }

    public String getCount_Farmer__c() {
        return Count_Farmer__c;
    }

    public String getCountry__c() {
        return country__c;
    }

    public String getDistrict__c() {
        return district__c;
    }

    public String getEducationalLevel__c() {
        return educationalLevel__c;
    }

    public String getFamily_members__c() {
        return Family_members__c;
    }

    public String getFarmer_group__c() {
        return farmer_group__c;
    }

    public String getFarmerCode__c() {
        return farmerCode__c;
    }

    public String getFDP_Farm__c() {
        return FDP_Farm__c;
    }

    public String getFullName__c() {
        return fullName__c;
    }

    public String getGender__c() {
        return gender__c;
    }

    public String getGps__c() {
        return gps__c;
    }

    public String getHas_farmer_profile__c() {
        return Has_farmer_profile__c;
    }

    public String getHas_fdp__c() {
        return Has_fdp__c;
    }

    public String getHouseholdAddress__c() {
        return householdAddress__c;
    }

    public String getInitial_baseline_date__c() {
        return Initial_baseline_date__c;
    }

    public String getLast_baseline_date__c() {
        return Last_baseline_date__c;
    }

    public String getNumber_of_baselines__c() {
        return Number_of_baselines__c;
    }

    public String getOrganization__c() {
        return organization__c;
    }

    public String getPhone_number__c() {
        return Phone_number__c;
    }

    public String getPostal_address__c() {
        return Postal_address__c;
    }

    public String getReasonRetreat__c() {
        return reasonRetreat__c;
    }

    public String getRegistrationDate__c() {
        return registrationDate__c;
    }

    public String getSpouseAge__c() {
        return spouseAge__c;
    }

    public String getSpouseBirthday__c() {
        return spouseBirthday__c;
    }

    public String getSpouseEducationallevel__c() {
        return spouseEducationallevel__c;
    }

    public String getSpouseName__c() {
        return spouseName__c;
    }

    public String getStatus__c() {
        return status__c;
    }

    public String getStatus_indicator__c() {
        return Status_indicator__c;
    }

    public String getUTZ_starting_year__c() {
        return UTZ_starting_year__c;
    }

    public String getVillage__c() {
        return village__c;
    }

    public String getVillage_name__c() {
        return village_name__c;
    }

    public String getYearsRelationshipWithMars__c() {
        return yearsRelationshipWithMars__c;
    }

    ////////////////////////////////////////////////


    public Farmer(String id, String name, String code, String villageName, String image, String educationLevel, String gender, String birthdayYear, String haveSpouse, String noOnSpouses, String spouseName, String spouseEducationLevel, String haveChildren, String noOfChildren){

        this.id = id;
        this.name =  name;
        this.imageUrl = image;
        this.code = code;
        this.villageName = villageName;
        this.educationLevel = educationLevel;
        this.gender = gender;
        this.birthYear = birthdayYear;
        this.haveSpouse = haveSpouse;
        this.noOfSpouses = noOnSpouses;
        this.spouseEducationLevel = spouseEducationLevel;
        this.spouseName = spouseName;
        this.haveChildren = haveChildren;
        this.noOfChildren = noOfChildren;
        this.landSize = landSize;

    }


    public String getLandSize() {
        return landSize;
    }

    public void setPlotsList(List<Plot> plotsList) {
        this.plotsList = plotsList;
    }

    public List<Plot> getPlotsList() {
        return plotsList;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public String getFarmArea() {
        return farmArea;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public void setFarmArea(String farmArea) {
        this.farmArea = farmArea;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }


    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public int getSyncStatus() {
        return syncStatus;
    }


    public void setBirthYear(String birthdayYear) {
        this.birthYear = birthdayYear;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHaveChildren(String haveChildren) {
        this.haveChildren = haveChildren;
    }

    public void setHaveSpouse(String haveSpouse) {
        this.haveSpouse = haveSpouse;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public void setNoOfSpouses(String noOfSpouses) {
        this.noOfSpouses = noOfSpouses;
    }

    public void setSpouseEducationLevel(String spouseEducationLevel) {
        this.spouseEducationLevel = spouseEducationLevel;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getGender() {
        return gender;
    }

    public String getHaveChildren() {
        return haveChildren;
    }

    public String getHaveSpouse() {
        return haveSpouse;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public String getNoOfSpouses() {
        return noOfSpouses;
    }

    public String getSpouseEducationLevel() {
        return spouseEducationLevel;
    }

    public String getSpouseName() {
        return spouseName;
    }


}
