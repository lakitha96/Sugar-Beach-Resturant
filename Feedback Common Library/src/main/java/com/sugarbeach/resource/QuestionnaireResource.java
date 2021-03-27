package com.sugarbeach.resource;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class QuestionnaireResource implements Serializable {
    private String type;
    private String question;
    private List<String> answerList;
    private List<AnswerResource> answerResourceList;

    public QuestionnaireResource() {
    }

    public QuestionnaireResource(String type, String question, List<String> answerList, List<AnswerResource> answerResourceList) {
        this.type = type;
        this.question = question;
        this.answerList = answerList;
        this.answerResourceList = answerResourceList;
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

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public List<AnswerResource> getAnswerResourceList() {
        return answerResourceList;
    }

    public void setAnswerResourceList(List<AnswerResource> answerResourceList) {
        this.answerResourceList = answerResourceList;
    }

    @Override
    public String toString() {
        return "QuestionnaireResource{" +
                "type='" + type + '\'' +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                ", answerResourceList=" + answerResourceList +
                '}';
    }
}
