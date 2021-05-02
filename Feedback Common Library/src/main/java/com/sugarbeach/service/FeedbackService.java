package com.sugarbeach.service;

import com.sugarbeach.resource.FeedbackReportResource;
import com.sugarbeach.resource.FeedbackResource;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public interface FeedbackService extends SuperService {
    boolean save(List<FeedbackResource> feedbackResourceList) throws RemoteException;

    FeedbackReportResource getFeedbackReportData(int questionId) throws RemoteException;
}
