package com.sugarbeach.controller;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.service.AuthenticateService;

import java.rmi.RemoteException;

public class AuthenticateController {
    private AuthenticateService authenticateService;

    public AuthenticateController() throws RemoteException {
        this.authenticateService = (AuthenticateService) ProxyHandler.getInstance().getService(ServiceType.AUTH);
    }

    /**
     * This method used to authenticate user
     *
     * @param role String
     * @param username String
     * @param password String
     * @return boolean
     * @throws RemoteException
     */
    public boolean login(String role, String username, String password) throws RemoteException {
        return authenticateService.login(role, username, password);
    }
}
