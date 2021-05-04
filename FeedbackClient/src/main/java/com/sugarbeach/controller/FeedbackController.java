package com.sugarbeach.controller;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.resource.FeedbackReportResource;
import com.sugarbeach.resource.FeedbackResource;
import com.sugarbeach.service.FeedbackService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class FeedbackController {
    private FeedbackService feedbackService;

    public FeedbackController() throws RemoteException {
        feedbackService = (FeedbackService) ProxyHandler.getInstance().getService(ServiceType.FEEDBACK);
    }

    public boolean save(List<FeedbackResource> feedbackResourceList) throws RemoteException{
        return feedbackService.save(feedbackResourceList);
    }

    public FeedbackReportResource getFeedbackReportData(int questionId) throws RemoteException {
        return feedbackService.getFeedbackReportData(questionId);
    }
}
