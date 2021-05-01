/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.proxy;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.service.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lakitha
 */
public class ProxyHandler implements ServiceFactory{
    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private QuestionnaireService questionnaireService;
    private FeedbackService feedbackService;
    private AuthenticateService authenticateService;

    private ProxyHandler(){
        try{
            serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:8081/feedback-server");
            questionnaireService = (QuestionnaireService) serviceFactory.getService(ServiceType.QUESTIONNAIRE);
            feedbackService = (FeedbackService) serviceFactory.getService(ServiceType.FEEDBACK);
            authenticateService = (AuthenticateService) serviceFactory.getService(ServiceType.AUTH);
        }catch(MalformedURLException | NotBoundException | RemoteException e) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }
    

    @Override
    public SuperService getService(ServiceType serviceType) throws RemoteException {
        switch(serviceType) {
            case QUESTIONNAIRE:
                return questionnaireService;
            case FEEDBACK:
                return feedbackService;
            case AUTH:
                return authenticateService;
            default:
                return null;
        }
    }
    
}
