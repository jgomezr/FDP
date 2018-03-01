package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 15/02/2018.
 */

public class ComplexCalculation {



    String Id;

    String Name;

    @SerializedName("Question__c")
    String questionId;


    @SerializedName("Condition__c")
    String condition;




    public ComplexCalculation(){}


    public void setId(String id) {
        Id = id;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getId() {
        return Id;
    }

    public String getCondition() {
        return condition;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
