package com.sugarbeach.service;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.resource.FeedbackResource;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public class FeedbackClientService implements FeedbackService{
    private FeedbackService feedbackService;

    public FeedbackClientService() throws RemoteException {
        feedbackService = (FeedbackService) ProxyHandler.getInstance().getService(ServiceType.FEEDBACK);
    }

    @Override
    public boolean save(List<FeedbackResource> feedbackResourceList) throws RemoteException{
        return feedbackService.save(feedbackResourceList);
    }
}
