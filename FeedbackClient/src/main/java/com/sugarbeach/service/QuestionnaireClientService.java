/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.service;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.resource.FeedbackResource;
import com.sugarbeach.resource.QuestionnaireResource;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lakitha
 */
public class QuestionnaireClientService implements QuestionnaireService{
    
    private QuestionnaireService questionnaireService;

    public QuestionnaireClientService() throws RemoteException {
        questionnaireService = (QuestionnaireService) ProxyHandler.getInstance().getService(ServiceType.QUESTIONNAIRE);
    }

    @Override
    public List<QuestionnaireResource> getAllQuestionWithAnswers() throws RemoteException{
        return questionnaireService.getAllQuestionWithAnswers();
    }
    
}
