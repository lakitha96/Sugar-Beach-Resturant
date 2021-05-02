package com.sugarbeach.service;

import com.sugarbeach.resource.QuestionnaireAdminResource;
import com.sugarbeach.resource.QuestionnaireResource;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Lakitha Prabudh on 3/27/21
 */
public interface QuestionnaireService extends SuperService{
    List<QuestionnaireResource> getAllQuestionWithAnswers() throws RemoteException;
    boolean save(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException;
    boolean update(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException;
    boolean delete(QuestionnaireAdminResource questionnaireAdminResource) throws RemoteException;
}
