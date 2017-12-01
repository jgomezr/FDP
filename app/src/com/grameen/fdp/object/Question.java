package com.grameen.fdp.object;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aangjnr on 29/11/2017.
 */

public class Question {


    String Id;
    String Caption__c;
    String Error_text__c;
    String Help_Text__c;
    String Max_value__c;
    String Min_value__c;
    String Options__c;
    String Type__c;
    Form Form__r;
    Object answer;


    public Question(){}


    Question( String Id, String Caption__c, String Error_text__c, String Help_Text__c, String Max_value__c, String Min_value__c, String Options__c, String Type__c, Form Form__r){

        this.Id = Id;
        this.Caption__c = Caption__c;
        this.Error_text__c = Error_text__c;
        this.Help_Text__c = Help_Text__c;
        this.Max_value__c = Max_value__c;
        this.Min_value__c = Min_value__c;
        this.Options__c = Options__c;
        this.Type__c = Type__c;
        this.Form__r = Form__r;

    }


    public void setId(String id) {
        Id = id;
    }


    public void setCaption__c(String caption__c) {
        Caption__c = caption__c;
    }

    public void setError_text__c(String error_text__c) {
        Error_text__c = error_text__c;
    }

    public void setForm__r(Form form__r) {
        Form__r = form__r;
    }

    public void setHelp_Text__c(String help_Text__c) {
        Help_Text__c = help_Text__c;
    }

    public void setMax_value__c(String max_value__c) {
        Max_value__c = max_value__c;
    }

    public void setMin_value__c(String min_value__c) {
        Min_value__c = min_value__c;
    }

    public void setOptions__c(String options__c) {
        Options__c = options__c;
    }

    public void setType__c(String type__c) {
        Type__c = type__c;
    }

    public String getError_text__c() {
        return Error_text__c;
    }

    public String getId() {
        return Id;
    }

    public Form getForm__r() {
        return Form__r;
    }

    public String getCaption__c() {
        return Caption__c;

    }

    public String getHelp_Text__c() {
        return Help_Text__c;
    }

    public String getMax_value__c() {
        return Max_value__c;
    }

    public String getMin_value__c() {
        return Min_value__c;
    }


    public String getOptions__c() {
        return Options__c;
    }

    public String getType__c() {
        return Type__c;
    }



    public List<String> formatQuestionOptions(){

        try {

            return Arrays.asList(Options__c.split(","));

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }




    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }
}
