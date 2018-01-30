package org.grameen.fdp.utility;

import android.provider.BaseColumns;

/**
 * Created by aangjnr on 30/11/2017.
 */

public class DatabaseDataClass {


    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " integer";
    private static final String COMMA = ",";

     static final String FARMER_TABLE = "farmer_table";

     static final String QUESTIONS_TABLE = "questions_table";
     static final String QUESTION_ID = "id";
     static final String QUESTION_NAME = "name";
    static final String QUESTION_TRANSLATION = "translation";

    static final String QUESTION_CAPTION = "caption";
     static final String QUESTION_ERROR_TEXT = "error_text";
     static final String QUESTION_HELPER_TEXT = "helper_text";
     static final String QUESTION_MAXI_VALUE = "max_value";
     static final String QUESTION_MINI_VALUE = "min_value";
     static final String QUESTION_OPTIONS = "options";
     static final String QUESTION_TYPE = "type";
     static final String QUESTION_FORM_NAME = "form_name";
     static final String QUESTION_FORM_ID = "form_id";








    static final String FARMER_NAME = "Farmer_Name";
    static final String FARMER_CODE = "Farmer_Code";
    static final String FARMER_ID = "Farmer_Id";
    static final String FARMER_VILLAGE = "Farmer_Village";
    static final String FARMER_GENDER = "Farmer_Gender";
    static final String FARMER_BIRTHYEAR = "Farmer_Birthyear";
    static final String FARMER_IMAGE_URL = "Farmer_Image";


 static final String FARMER_EDUCATION = "Farmer_Education";
    static final String FARMER_LAST_VISIT_DATE = "Farmer_LastVisit_Date";
    static final String FARMER_LAND_AREA = "Farmer_LandArea";


    static final String FARMER_PROFILE_JSON = "Farmer_Profile";
   static final String ADOPTION_OBSERVATION_RESULTS_JSON = "Adoption_Observation_Results";
   static final String AGGREGATE_ECONOMIC_RESULTS_JSON = "Agregate_Economic_Results";
   static final String OTHER_JSON = "Other";
   static final String ADDITIONAL_INTERVENTION_JSON = "Additional_Intervention";
   static final String ADOPTION_OBSERVATIONS_JSON = "Adoption_Observations";
   static final String PRODUCTIVE_PROFILE_JSON = "Productive_Profile";
   static final String FARMING_ECONOMIC_PROFILE_JSON = "Farming_Economic_Profile";
   static final String SOCIO_ECONOMIC_PROFILE_JSON = "Socioeconomic_Profile";
   static final String FAMILY_MEMBERS_JSON = "Family_Members";
   static final String PLOT_INFO = "Plot_Info";
   static final String HAS_REGISTERED = "Registration_Status";
   static final String FARMER_SYNC_STATUS = "Sync_status";




    static final String FORMS_TABLE = "form_table";
    static final String FORM_ID = "id";
    static final String FORM_NAME = "name";


    static final String VILLAGES_TABLE = "village_table";
    static final String VILLAGE_ID = "id";
    static final String VILLAGE_NAME = "name";
    static final String VILLAGE_DISTRICT = "district";







    static final String PLOTS_TABLE = "Plot_Table";
    static final String PLOT_ID = "Id";
    static final String PLOT_NAME = "Name";
    static final String PLOT_INFORMATION_JSON = "Plot_Info";
    static final String START_YEAR = "start_year";
    static final String RECOMMENDATION_ID = "recommendationId";


    static final String SKIP_LOGIC_TABLE = "skip_logic";
    static final String ID = "id";
    static final String SKIP_LOGIC_NAME = "name";
    static final String SKIP_LOGIC_QUESTION_ID = "question_id";
    static final String SKIP_LOGIC_ANSWER_VALUE = "answer";
    static final String SKIP_LOGIC_QUESTION_AFFECTED_ID = "question_affected_id";
    static final String SKIP_LOGIC_OPERATOR = "logical_operand";
    static final String SKIP_LOGIC_ACTION_TAKEN = "action";








    static final String CALCULATIONS_TABLE = "calculations_table";
    static final String CALCULATIONS_NAME = "name";
    static final String CALCULATIONS_Q1 = "q1";
    static final String CALCULATIONS_Q2 = "q2";
    static final String CALCULATIONS_Q3 = "q3";
    static final String CALCULATIONS_Q4 = "q4";
    static final String CALCULATIONS_OP1 = "op1";
    static final String CALCULATIONS_OP2 = "op2";
    static final String CALCULATIONS_OP3 = "op3";
    static final String CALCULATIONS_RESULT_QUESTION = "result_question";





    static final String RECOMMENDATIONS_TABLE = "recommendations_table";
    static final String RECOMMENDATIONS_NAME = "name";
    static final String RECOMMENDATIONS_CONDITION = "condition";
    static final String RECOMMENDATIONS_DESCRIPTION = "description";
    static final String RECOMMENDATIONS_HIERARCHY = "hierarchy";

 static final String RECOMMENDATIONS_INCOME0 = "income0";
 static final String RECOMMENDATIONS_INCOME1 = "income1";
 static final String RECOMMENDATIONS_INCOME2 = "income2";
 static final String RECOMMENDATIONS_INCOME3 = "income3";
 static final String RECOMMENDATIONS_INCOME4 = "income4";
 static final String RECOMMENDATIONS_INCOME5 = "income5";
 static final String RECOMMENDATIONS_INCOME6 = "income6";
 static final String RECOMMENDATIONS_INCOME7 = "income7";

    static final String RECOMMENDATIONS_LOGIC = "logic";
    static final String RECOMMENDATIONS_RELATED_1 = "related1";
    static final String RECOMMENDATIONS_RELATED_2 = "related2";
    static final String RECOMMENDATIONS_YEAR_BACK_TO_GAPS = "year_to_gaps";
    static final String RECOMMENDATIONS_QUESTIONS_INVOLVED = "questions_involved";






    static final String RECOMMENDATIONS_PLUS_ACTIVITIES_TABLE = "recommendations_activities_table";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_NAME = "name";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_ACTIVITY_ID = "activity_id";
    static final String RECOMMENDATIONS_PLUS_ACTIVITIES_ACTIVITY_NAME = "activity_name";
    static final String RECOMMENDATIONS_PLUS_ACTIVITIES_LABOR_COST = "labor_cost";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_LABOR_DAYS_NEEDED = "labor_days_needed";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_MONTH = "month";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_YEAR = "year";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_SUPPLIES_COST = "supplies_cost";
 static final String RECOMMENDATIONS_PLUS_ACTIVITIES_RECOMMENDATION_ID = "recommendation_id";





 static final String LOGIC_TABLE = "logic_table";
    static final String LOGIC_NAME = "logic_name";

    static final String LOGIC_PARENT_LOGIC = "parent_logic";
    static final String LOGIC_PARENT_LOGICAL_OPERATOR = "parent_logical_operator";
    static final String LOGIC_RESULT = "logic_results";
    static final String LOGIC_RESULT_QUESTIONS = "logic_results_question";

    static final String LOGIC_LO1 = "lo1";
    static final String LOGIC_LO2 = "lo2";
    static final String LOGIC_LO3 = "lo3";
    static final String LOGIC_LO4 = "lo4";
    static final String LOGIC_LO5 = "lo5";
    static final String LOGIC_LO6 = "lo6";
    static final String LOGIC_LO7 = "lo7";
    static final String LOGIC_LO8 = "lo8";
    static final String LOGIC_LO9 = "lo9";
    static final String LOGIC_LO10 = "lo10";


    static final String LOGIC_Q1 = "q1";
    static final String LOGIC_Q2 = "q2";
    static final String LOGIC_Q3 = "q3";
    static final String LOGIC_Q4 = "q4";
    static final String LOGIC_Q5 = "q5";
    static final String LOGIC_Q6 = "q6";
    static final String LOGIC_Q7 = "q7";
    static final String LOGIC_Q8 = "q8";
    static final String LOGIC_Q9 = "q9";
    static final String LOGIC_Q10 = "q10";



    static final String LOGIC_QLO1 = "qlo1";
    static final String LOGIC_QLO2 = "qlo2";
    static final String LOGIC_QLO3 = "ql03";
    static final String LOGIC_QLO4 = "qlo4";
    static final String LOGIC_QLO5 = "qlo5";
    static final String LOGIC_QLO6 = "qlo6";
    static final String LOGIC_QLO7 = "qlo7";
    static final String LOGIC_QLO8 = "qlo8";
    static final String LOGIC_QLO9 = "qlo9";
    static final String LOGIC_QLO10 = "qlo10";




    static final String LOGIC_V1 = "v1";
    static final String LOGIC_V2 = "v2";
    static final String LOGIC_V3 = "v3";
    static final String LOGIC_V4 = "v4";
    static final String LOGIC_V5 = "v5";
    static final String LOGIC_V6 = "v6";
    static final String LOGIC_V7 = "v7";
    static final String LOGIC_V8 = "v8";
    static final String LOGIC_V9 = "v9";
    static final String LOGIC_V10 = "v10";


    static final String LOGIC_EVALUATED_VALUE = "evaluated_value";








    static final String ACTIVITIY_PLUS_INPUTS_TABLE = "activities_and_inputs";
    static final String ACTIVITIY_PLUS_INPUTS_NAME = "name";
    static final String ACTIVITIY_PLUS_INPUTS_INPUT_TYPE = "Input_type__c";
    static final String ACTIVITIY_PLUS_INPUTS_QUANTITY = "quantity";
    static final String ACTIVITIY_PLUS_INPUTS_UNIT_COST = "unit_cost";
    static final String ACTIVITIY_PLUS_INPUTS_TOTAL_COST = "total_cost";
    static final String ACTIVITIY_PLUS_INPUTS_SI_UNIT = "si_unit";
    static final String ACTIVITIY_PLUS_INPUTS_RECOMMENDATION_ID = "recommendation_id";
    static final String ACTIVITIY_PLUS_INPUTS_RECOMMENDATION_NAME = "recommendation_name";




    static final String CREATE_PLOTS_TABLE = "CREATE TABLE IF NOT EXISTS " + PLOTS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + FARMER_CODE + TEXT_TYPE + COMMA
            + PLOT_ID + TEXT_TYPE + COMMA
            + PLOT_NAME + TEXT_TYPE + COMMA
            + PLOT_INFORMATION_JSON + TEXT_TYPE + COMMA
            + ADDITIONAL_INTERVENTION_JSON + TEXT_TYPE + COMMA
            + ADOPTION_OBSERVATIONS_JSON + TEXT_TYPE + COMMA
            + ADOPTION_OBSERVATION_RESULTS_JSON + TEXT_TYPE + COMMA
            + RECOMMENDATION_ID + TEXT_TYPE + COMMA
            + START_YEAR + " integer" + ")";


    static final String DROP_PLOTS_TABLE = "drop table if exists " + PLOTS_TABLE;






    static final String CREATE_FARMER_TABLE = "CREATE TABLE IF NOT EXISTS " + FARMER_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + FARMER_NAME + TEXT_TYPE + COMMA
            + FARMER_CODE + TEXT_TYPE + COMMA
            + FARMER_ID + TEXT_TYPE + COMMA
            + FARMER_VILLAGE + TEXT_TYPE + COMMA
            + FARMER_GENDER + TEXT_TYPE + COMMA
            + FARMER_BIRTHYEAR + TEXT_TYPE + COMMA
            + FARMER_IMAGE_URL + TEXT_TYPE + COMMA

            + FARMER_EDUCATION + TEXT_TYPE + COMMA
            + FARMER_LAST_VISIT_DATE + TEXT_TYPE + COMMA
            + FARMER_LAND_AREA + TEXT_TYPE + COMMA

            + FARMER_PROFILE_JSON + TEXT_TYPE + COMMA
            + ADOPTION_OBSERVATION_RESULTS_JSON + TEXT_TYPE + COMMA
            + AGGREGATE_ECONOMIC_RESULTS_JSON + TEXT_TYPE + COMMA
            + OTHER_JSON + TEXT_TYPE + COMMA
            + ADDITIONAL_INTERVENTION_JSON + TEXT_TYPE + COMMA
            + ADOPTION_OBSERVATIONS_JSON + TEXT_TYPE + COMMA
            + PRODUCTIVE_PROFILE_JSON + TEXT_TYPE + COMMA
            + FARMING_ECONOMIC_PROFILE_JSON + TEXT_TYPE + COMMA
            + SOCIO_ECONOMIC_PROFILE_JSON + TEXT_TYPE + COMMA
            + FAMILY_MEMBERS_JSON + TEXT_TYPE + COMMA
            + PLOT_INFO + TEXT_TYPE + COMMA
            + HAS_REGISTERED + TEXT_TYPE + COMMA
            + FARMER_SYNC_STATUS + " integer" + ")";


    static final String DROP_FARMER_TABLE = "drop table if exists " + FARMER_TABLE;



    static final String CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + QUESTIONS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + QUESTION_ID + TEXT_TYPE + COMMA
            + QUESTION_NAME + TEXT_TYPE + COMMA

            + QUESTION_CAPTION + TEXT_TYPE + COMMA
            + QUESTION_ERROR_TEXT + TEXT_TYPE + COMMA
            + QUESTION_HELPER_TEXT + TEXT_TYPE + COMMA
            + QUESTION_MAXI_VALUE + TEXT_TYPE + COMMA
            + QUESTION_MINI_VALUE + TEXT_TYPE + COMMA
            + QUESTION_OPTIONS + TEXT_TYPE + COMMA
            + QUESTION_TYPE + TEXT_TYPE + COMMA
            + QUESTION_TRANSLATION + TEXT_TYPE + COMMA

            + QUESTION_FORM_NAME + TEXT_TYPE + COMMA
              + QUESTION_FORM_ID+ " TEXT " + ")";



    static final String DROP_QUESTIONS_TABLE = "drop table if exists " + QUESTIONS_TABLE;



    static final String CREATE_FORMS_TABLE = "CREATE TABLE IF NOT EXISTS " + FORMS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + FORM_ID + TEXT_TYPE + COMMA
            + FORM_NAME + " TEXT " + ")";

    static final String DROP_FORMS_TABLE = "drop table if exists " + FORMS_TABLE;


    static final String CREATE_VILLAGES_TABLE = "CREATE TABLE IF NOT EXISTS " + VILLAGES_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + VILLAGE_NAME + TEXT_TYPE + COMMA
            + VILLAGE_DISTRICT + " TEXT " + ")";

    static final String DROP_VILLAGES_TABLE = "drop table if exists " + VILLAGES_TABLE;






    static final String CREATE_SKIP_LOGIC_TABLE = "CREATE TABLE IF NOT EXISTS " + SKIP_LOGIC_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + ID + TEXT_TYPE + COMMA
            + SKIP_LOGIC_NAME + TEXT_TYPE + COMMA
            + SKIP_LOGIC_QUESTION_ID + TEXT_TYPE + COMMA
            + SKIP_LOGIC_ANSWER_VALUE + TEXT_TYPE + COMMA
            + SKIP_LOGIC_QUESTION_AFFECTED_ID + TEXT_TYPE + COMMA
            + SKIP_LOGIC_OPERATOR + TEXT_TYPE + COMMA
            + SKIP_LOGIC_ACTION_TAKEN + " TEXT " + ")";



    static final String DROP_SKIP_LOGIC_TABLE = "drop table if exists " + SKIP_LOGIC_TABLE;





    static final String CREATE_CALCULATIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + CALCULATIONS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + ID + TEXT_TYPE + COMMA
            + CALCULATIONS_NAME + TEXT_TYPE + COMMA
            + CALCULATIONS_Q1 + TEXT_TYPE + COMMA
            + CALCULATIONS_Q2 + TEXT_TYPE + COMMA
            + CALCULATIONS_Q3 + TEXT_TYPE + COMMA
            + CALCULATIONS_Q4 + TEXT_TYPE + COMMA
            + CALCULATIONS_OP1 + TEXT_TYPE + COMMA
            + CALCULATIONS_OP2 + TEXT_TYPE + COMMA
            + CALCULATIONS_OP3 + TEXT_TYPE + COMMA
            + CALCULATIONS_RESULT_QUESTION + " TEXT " + ")";

    static final String DROP_CALCULATIONS_TABLE = "drop table if exists " + CALCULATIONS_TABLE;






    static final String CREATE_RECOMMENDATIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + RECOMMENDATIONS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + ID + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_NAME + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_CONDITION + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_DESCRIPTION + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_HIERARCHY + TEXT_TYPE + COMMA

            + RECOMMENDATIONS_INCOME0 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME1 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME2 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME3 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME4 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME5 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME6 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_INCOME7 + TEXT_TYPE + COMMA

            + RECOMMENDATIONS_LOGIC + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_RELATED_1 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_RELATED_2 + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_QUESTIONS_INVOLVED + TEXT_TYPE + COMMA
            + RECOMMENDATIONS_YEAR_BACK_TO_GAPS + " TEXT " + ")";


    static final String DROP_RECOMMENDATIONS_TABLE = "drop table if exists " + RECOMMENDATIONS_TABLE;




    static final String CREATE_LOGIC_TABLE = "CREATE TABLE IF NOT EXISTS " + LOGIC_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + ID + TEXT_TYPE + COMMA
            + LOGIC_NAME + TEXT_TYPE + COMMA
            + LOGIC_PARENT_LOGIC + TEXT_TYPE + COMMA
            + LOGIC_PARENT_LOGICAL_OPERATOR + TEXT_TYPE + COMMA
            + LOGIC_RESULT + TEXT_TYPE + COMMA
            + LOGIC_RESULT_QUESTIONS + TEXT_TYPE + COMMA


            + LOGIC_LO1 + TEXT_TYPE + COMMA
            + LOGIC_LO2 + TEXT_TYPE + COMMA
            + LOGIC_LO3 + TEXT_TYPE + COMMA
            + LOGIC_LO4 + TEXT_TYPE + COMMA
            + LOGIC_LO5 + TEXT_TYPE + COMMA
            + LOGIC_LO6 + TEXT_TYPE + COMMA
            + LOGIC_LO7 + TEXT_TYPE + COMMA
            + LOGIC_LO8 + TEXT_TYPE + COMMA
            + LOGIC_LO9 + TEXT_TYPE + COMMA
            + LOGIC_LO10 + TEXT_TYPE + COMMA


            + LOGIC_Q1 + TEXT_TYPE + COMMA
            + LOGIC_Q2 + TEXT_TYPE + COMMA
            + LOGIC_Q3 + TEXT_TYPE + COMMA
            + LOGIC_Q4 + TEXT_TYPE + COMMA
            + LOGIC_Q5 + TEXT_TYPE + COMMA
            + LOGIC_Q6 + TEXT_TYPE + COMMA
            + LOGIC_Q7 + TEXT_TYPE + COMMA
            + LOGIC_Q8 + TEXT_TYPE + COMMA
            + LOGIC_Q9 + TEXT_TYPE + COMMA
            + LOGIC_Q10 + TEXT_TYPE + COMMA


            + LOGIC_QLO1 + TEXT_TYPE + COMMA
            + LOGIC_QLO2 + TEXT_TYPE + COMMA
            + LOGIC_QLO3 + TEXT_TYPE + COMMA
            + LOGIC_QLO4 + TEXT_TYPE + COMMA
            + LOGIC_QLO5 + TEXT_TYPE + COMMA
            + LOGIC_QLO6 + TEXT_TYPE + COMMA
            + LOGIC_QLO7 + TEXT_TYPE + COMMA
            + LOGIC_QLO8 + TEXT_TYPE + COMMA
            + LOGIC_QLO9 + TEXT_TYPE + COMMA
            + LOGIC_QLO10 + TEXT_TYPE + COMMA


            + LOGIC_V1 + TEXT_TYPE + COMMA
            + LOGIC_V2 + TEXT_TYPE + COMMA
            + LOGIC_V3 + TEXT_TYPE + COMMA
            + LOGIC_V4 + TEXT_TYPE + COMMA
            + LOGIC_V5 + TEXT_TYPE + COMMA
            + LOGIC_V6 + TEXT_TYPE + COMMA
            + LOGIC_V7 + TEXT_TYPE + COMMA
            + LOGIC_V8 + TEXT_TYPE + COMMA
            + LOGIC_V9 + TEXT_TYPE + COMMA
            + LOGIC_V10 + TEXT_TYPE + COMMA
            + LOGIC_EVALUATED_VALUE + " TEXT " + ")";

    static final String DROP_LOGIC_TABLE = "drop table if exists " + LOGIC_TABLE;





 static final String CREATE_RECOMMENDATION_PLUS_ACTIVITIES_TABLE = "CREATE TABLE IF NOT EXISTS " + RECOMMENDATIONS_PLUS_ACTIVITIES_TABLE +  "("
         + BaseColumns._ID + " integer primary key autoincrement, "
         + ID + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_NAME + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_ACTIVITY_ID + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_ACTIVITY_NAME + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_LABOR_COST+ TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_LABOR_DAYS_NEEDED + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_MONTH + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_YEAR + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_SUPPLIES_COST + TEXT_TYPE + COMMA
         + RECOMMENDATIONS_PLUS_ACTIVITIES_RECOMMENDATION_ID + " TEXT " + ")";

 static final String DROP_RECOMMENDATION_PLUS_ACTIVITIES_TABLE = "drop table if exists " + RECOMMENDATIONS_PLUS_ACTIVITIES_TABLE;











    static final String CREATE_ACTIVITIES_PLUS_INPUTS_TABLE = "CREATE TABLE IF NOT EXISTS " + ACTIVITIY_PLUS_INPUTS_TABLE +  "("
            + BaseColumns._ID + " integer primary key autoincrement, "
            + ID + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_NAME + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_INPUT_TYPE + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_QUANTITY + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_UNIT_COST+ TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_TOTAL_COST + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_SI_UNIT + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_RECOMMENDATION_ID + TEXT_TYPE + COMMA
            + ACTIVITIY_PLUS_INPUTS_RECOMMENDATION_NAME + " TEXT " + ")";

    static final String DROP_ACTIVITIES_PLUS_INPUTS_TABLE = "drop table if exists " + ACTIVITIY_PLUS_INPUTS_TABLE;




}
