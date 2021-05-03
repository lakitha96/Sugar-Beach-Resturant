package com.sugarbeach.controller;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;
import com.sugarbeach.service.AuthenticateService;

import java.rmi.RemoteException;

public class AuthenticateController implements AuthenticateService {
    private AuthenticateService authenticateService;

    public AuthenticateController() throws RemoteException {
        this.authenticateService = (AuthenticateService) ProxyHandler.getInstance().getService(ServiceType.AUTH);
    }

    @Override
    public boolean login(String role, String username, String password) throws RemoteException {
        return authenticateService.login(role, username, password);
    }
}
