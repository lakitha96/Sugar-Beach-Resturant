/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.controller;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.resource.QuestionnaireAdminResource;
import com.sugarbeach.resource.QuestionnaireResource;
import com.sugarbeach.service.QuestionnaireService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author lakitha
 */
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;

    public QuestionnaireController() throws RemoteException {
        questionnaireService = (QuestionnaireService) ProxyHandler.getInstance().getService(ServiceType.QUESTIONNAIRE);
    }

    /**
     * This method used to get all question with answers
     *
     * @return {@link List<QuestionnaireResource>}
     * @throws RemoteException
     */
    public List<QuestionnaireResource> getAllQuestionWithAnswers() throws RemoteException {
        return questionnaireService.getAllQuestionWithAnswers();
    }

    /**
     * This method used save questionnaire
     *
     * @param questionnaireAdminResource {@link QuestionnaireAdminResource}
     * @return boolean
     * @throws RemoteException
     */
    public boolean save(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException {
        return questionnaireService.save(questionnaireAdminResource);
    }

    /**
     * This method used to update questionnaire
     *
     * @param questionnaireAdminResource {@link QuestionnaireAdminResource}
     * @return boolean
     * @throws RemoteException
     */
    public boolean update(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException {
        return questionnaireService.update(questionnaireAdminResource);
    }

    /**
     * This method used to delete questionnaire
     *
     * @param questionnaireAdminResource {@link QuestionnaireAdminResource}
     * @return boolean
     * @throws RemoteException
     */
    public boolean delete(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException {
        return questionnaireService.delete(questionnaireAdminResource);
    }
}
