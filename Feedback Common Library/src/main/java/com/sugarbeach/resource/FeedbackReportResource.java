package com.sugarbeach.resource;

import java.io.Serializable;
import java.util.List;

public class FeedbackReportResource implements Serializable {
    private String question;
    private List<FeedbackAnswerReportResource> answerReportResources;

    public FeedbackReportResource() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<FeedbackAnswerReportResource> getAnswerReportResources() {
        return answerReportResources;
    }

    public void setAnswerReportResources(List<FeedbackAnswerReportResource> answerReportResources) {
        this.answerReportResources = answerReportResources;
    }

    @Override
    public String toString() {
        return "FeedbackReportResource{" +
                "question='" + question + '\'' +
                ", answerReportResources=" + answerReportResources +
                '}';
    }

    public static class FeedbackAnswerReportResource implements Serializable{
        private String answer;
        private int answerCount;

        public FeedbackAnswerReportResource() {
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public int getAnswerCount() {
            return answerCount;
        }

        public void setAnswerCount(int answerCount) {
            this.answerCount = answerCount;
        }

        @Override
        public String toString() {
            return "FeedbackAnswerResource{" +
                    "answer='" + answer + '\'' +
                    ", answerCount=" + answerCount +
                    '}';
        }
    }
}
