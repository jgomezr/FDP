package org.grameen.fdp.object;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Question {

    @SerializedName("LastModifiedDate")
    String lastModifiedDate;

    String Id;
    String Name;
    String Caption__c;
    String Default_value__c;
    Double Display_Order__c = 1.00;

    String Error_text__c;
    String Help_Text__c;
    String Hide__c;
    String Max_value__c;
    String Min_value__c;
    String Options__c;
    String Type__c;
    String Related_questions__c;
    Form Form__r;
    Object answer;

    String Translation__c;



    String answerValue;

    public Question() {
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTranslation__c() {
        return Translation__c;
    }

    public void setTranslation__c(String translation__c) {
        Translation__c = translation__c;
    }

    public String getError_text__c() {
        return Error_text__c;
    }

    public void setError_text__c(String error_text__c) {
        Error_text__c = error_text__c;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Form getForm__r() {
        return Form__r;
    }

    public void setForm__r(Form form__r) {
        Form__r = form__r;
    }

    public String getCaption__c() {
        return Caption__c;

    }

    public void setCaption__c(String caption__c) {
        Caption__c = caption__c;
    }

    public String getHelp_Text__c() {
        return Help_Text__c;
    }

    public void setHelp_Text__c(String help_Text__c) {
        Help_Text__c = help_Text__c;
    }

    public String getMax_value__c() {
        return Max_value__c;
    }

    public void setMax_value__c(String max_value__c) {
        Max_value__c = max_value__c;
    }

    public String getMin_value__c() {
        return Min_value__c;
    }

    public void setMin_value__c(String min_value__c) {
        Min_value__c = min_value__c;
    }

    public String getOptions__c() {
        return Options__c;
    }

    public void setOptions__c(String options__c) {
        Options__c = options__c;
    }

    public String getType__c() {
        return Type__c;
    }

    public void setType__c(String type__c) {
        Type__c = type__c;
    }

    public void setRelated_Questions__c(String related_Questions__c) {
        Related_questions__c = related_Questions__c;
    }

    public String getRelated_Questions__c() {
        return Related_questions__c;
    }

    public List<String> formatQuestionOptions() {

        String s = "";
/*
        if(getDefault_value__c() != null && !getDefault_value__c().equalsIgnoreCase("null"))

         s = getDefault_value__c()  + "," + getOptions__c();

        else  */   s = getOptions__c();


        Log.i("QUESTION MODEL", "OPTIONS = " + s);

        if (!s.equalsIgnoreCase("null"))

            try {

                return Arrays.asList(s.trim().split(","));

            } catch (Exception e) {
                e.printStackTrace();
                return Arrays.asList(s);
            }

        else return new ArrayList<>();

    }


    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }


    public void setDefault_value__c(String default_value__c) {
        Default_value__c = default_value__c;
    }

    public void setDisplay_Order__c(Double display_Order__c) {

        if(display_Order__c != null )
        Display_Order__c = display_Order__c;

        else Display_Order__c = 1.00;


    }

    public void setHide__c(String hide__c) {
        Hide__c = hide__c;
    }

    public void setRelated_questions__c(String related_questions__c) {
        Related_questions__c = related_questions__c;
    }

    public String getDefault_value__c() {
        return Default_value__c;
    }

    public Double getDisplay_Order__c() {


        if(Display_Order__c != null )

            return Display_Order__c;

        else return 1.00;

     }

    public String getHide__c() {
        return Hide__c;
    }

    public String getRelated_questions__c() {
        return Related_questions__c;
    }


    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getAnswerValue() {
        return answerValue;
    }
}
