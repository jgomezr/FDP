package org.grameen.fdp.object;

/**
 * Created by aangjnr on 16/12/2017.
 */

public class Answer {


    String questionId;
    Object value;

    public Answer(){}


    public Answer(String id, Object ans){ this.questionId = id;
    this.value = ans;}



    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuestionId() {
        return questionId;
    }

    public Object getValue() {
        return value;
    }
}
