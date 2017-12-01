package com.grameen.fdp.utility;

import android.provider.BaseColumns;

/**
 * Created by aangjnr on 30/11/2017.
 */

public class DatabaseDataClass {


    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " integer";
    private static final String COMMA = ",";

     static final String FARMER_TABLE = "farmer_table";
    static final String FARMER_CODE = "farmerCode__c";
    static final String FARMER_AGE = "age__c";
    static final String FARMER_ASSIGNEE = "assignedTo__c";
    static final String FARMER_BIRTHDAY  = "birthday__c";
    static final String FARMER_COUNTRY = "country__c";
    static final String FARMER_DISTRICT = "district__c";
    static final String FARMER_EDUCATION_LEVEL = "educationalLevel__c";
    static final String FARMER_FAMILY_MEMBERS = "Family_members__c";
    static final String FARMER_GROUP = "farmer_group__c";
    static final String FARMER_FDP_FARM = "FDP_Farm__c";
    static final String FARMER_FDP_SUBMISSION = "FDP_submission__c";
    static final String FARMER_FULL_NAME = "fullName__c";
    static final String FARMER_GENDER = "gender__c";
    static final String FARMER_GPS_LOCATION = "gps__c";
    static final String FARMER_HAS_FARMER_PROFILE = "Has_farmer_profile__c";
    static final String FARMER_HAS_FDP = "Has_fdp__c";
    static final String FARMER_HOUSEHOLD_ADDRESS = "householdAddress__c";
    static final String FARMER_INITIAL_BASELINE_DATE = "Initial_baseline_date__c";
    static final String FARMER_LAST_BASELINE_DATE = "Last_baseline_date__c";
    static final String FARMER_YEARS_RELATIONSHIP_WITH_MARS = "yearsRelationshipWithMars__c";
    static final String FARMER_NUMBER_OF_BASELINES = "Number_of_baselines__c";
    static final String FARMER_ORGANIZATION = "organization__c";
    static final String FARMER_PHONENUMBER = "Phone_number__c";
    static final String FARMER_POSTAL_ADDRESS = "Postal_address__c";
    static final String FARMER_REASON_RETREAT = "reasonRetreat__c";
    static final String FARMER_REGISTRATION_DATE = "registrationDate__c";
    static final String FARMER_SPOUSE_AGE = "spouseAge__c";
    static final String FARMER_SPOUSE_BIRTHDATE = "spouseBirthday__c";
    static final String FARMER_SPOUSE_EDUCATION_LEVEL = "spouseEducationallevel__c";
    static final String FARMER_SPOUSE_NAME = "spouseName__c";
    static final String FARMER_SYNC_STATUS = "status__c";
    static final String FARMER_STATUS_INDICATOR = "Status_indicator__c";
    static final String FARMER_UTZ_SATRTING_YEAR = "UTZ_starting_year__c";
    static final String FARMER_VILLAGE = "village__c";
    static final String FARMER_VILLAGE_NAME = "village_name__c";




     static final String QUESTIONS_TABLE = "questions_table";
     static final String QUESTION_ID = "id";
     static final String QUESTION_CAPTION = "caption";
     static final String QUESTION_ERROR_TEXT = "error_text";
     static final String QUESTION_HELPER_TEXT = "helper_text";
     static final String QUESTION_MAXI_VALUE = "max_value";
     static final String QUESTION_MINI_VALUE = "min_value";
     static final String QUESTION_OPTIONS = "options";
     static final String QUESTION_TYPE = "type";
    static final String QUESTION_FORM_NAME = "form_name";
     static final String QUESTION_FORM_ID = "form_id";






      static final String CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + QUESTIONS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + QUESTION_ID + TEXT_TYPE + COMMA
            + QUESTION_CAPTION + TEXT_TYPE + COMMA
            + QUESTION_ERROR_TEXT + TEXT_TYPE + COMMA
            + QUESTION_HELPER_TEXT + TEXT_TYPE + COMMA
            + QUESTION_MAXI_VALUE + TEXT_TYPE + COMMA
            + QUESTION_MINI_VALUE + TEXT_TYPE + COMMA
            + QUESTION_OPTIONS + TEXT_TYPE + COMMA
            + QUESTION_TYPE + TEXT_TYPE + COMMA
              + QUESTION_FORM_NAME + TEXT_TYPE + COMMA
              + QUESTION_FORM_ID+ " TEXT " + ")";



      static final String DROP_QUESTIONS_TABLE = "drop table if exist " + QUESTIONS_TABLE;








}
