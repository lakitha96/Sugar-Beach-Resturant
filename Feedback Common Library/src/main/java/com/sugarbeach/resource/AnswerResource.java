package com.sugarbeach.resource;

import java.io.Serializable;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class AnswerResource implements Serializable {
    private int questionId;
    private int answerId;
    private String answer;

    public AnswerResource() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerResource{" +
                "questionId=" + questionId +
                ", answerId=" + answerId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
