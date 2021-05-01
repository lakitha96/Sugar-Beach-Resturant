package com.sugarbeach.service;

import com.sugarbeach.enums.ServiceType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    private static ServiceFactory serviceFactory;

    public ServiceFactoryImpl() throws RemoteException {
    }

    public static ServiceFactory getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws RemoteException{
        switch (serviceType) {
            case QUESTIONNAIRE:
                return new QuestionnaireServiceImpl();
            case FEEDBACK:
                return new FeedbackServiceImpl();
            case AUTH:
                return new AuthenticateServiceImpl();
            default:
                return null;
        }
    }
}
