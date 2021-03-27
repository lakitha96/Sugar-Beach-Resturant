package com.sugarbeach.resource;

import java.io.Serializable;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class FeedbackResource implements Serializable {
    private String customerName;
    private String msisdn;
    private int answerId;

    public FeedbackResource() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "FeedbackResource{" +
                "customerName='" + customerName + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", answerId=" + answerId +
                '}';
    }
}
