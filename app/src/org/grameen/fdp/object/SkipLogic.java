package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 02/01/2018.
 */

public class SkipLogic {

    @SerializedName("LastModifiedDate")
    String lastModifiedDate;

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


    public SkipLogic() {
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionToBeTaken() {
        return actionToBeTaken;
    }

    public void setActionToBeTaken(String actionToBeTaken) {
        this.actionToBeTaken = actionToBeTaken;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public String getQuestionShowHide() {
        return questionShowHide;
    }

    public void setQuestionShowHide(String questionShowHide) {
        this.questionShowHide = questionShowHide;
    }
}
