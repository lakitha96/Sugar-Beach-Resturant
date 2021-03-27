package com.sugarbeach.model;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class QuestionModel {
    private int id;
    private String type;
    private String question;

    public QuestionModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
