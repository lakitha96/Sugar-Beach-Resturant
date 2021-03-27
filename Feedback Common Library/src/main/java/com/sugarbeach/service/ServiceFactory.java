package com.sugarbeach.service;

import com.sugarbeach.enums.ServiceType;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public interface ServiceFactory extends Remote {

    SuperService getService(ServiceType serviceType) throws RemoteException;

}
