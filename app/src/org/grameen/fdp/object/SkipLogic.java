package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 02/01/2018.
 */

public class SkipLogic {


    @SerializedName("Id")
    String id;

    @SerializedName("Name")
    String name;

    @SerializedName("Question__c")
    String questionId;

    @SerializedName("Question_value__c")
    String answerValue;

    @SerializedName("Question_1__c")
    String questionShowHide;

    @SerializedName("Logical_Operator__c")
    String logicalOperator;

    @SerializedName("Hide__c")
    String actionToBeTaken;




    public SkipLogic(){}


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public void setQuestionShowHide(String questionShowHide) {
        this.questionShowHide = questionShowHide;
    }

    public void setActionToBeTaken(String actionToBeTaken) {
        this.actionToBeTaken = actionToBeTaken;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getActionToBeTaken() {
        return actionToBeTaken;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public String getQuestionShowHide() {
        return questionShowHide;
    }
}
