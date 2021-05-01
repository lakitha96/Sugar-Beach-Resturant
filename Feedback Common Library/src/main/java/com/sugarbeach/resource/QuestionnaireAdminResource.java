package com.sugarbeach.resource;

import java.io.Serializable;
import java.util.List;

public class QuestionnaireAdminResource implements Serializable {
    private int questionId;
    private String question;
    private List<String> answerList;

    public QuestionnaireAdminResource() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "QuestionnaireAdminResource{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
