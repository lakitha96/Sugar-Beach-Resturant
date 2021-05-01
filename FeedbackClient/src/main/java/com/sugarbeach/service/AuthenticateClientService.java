package com.sugarbeach.service;

import com.sugarbeach.enums.ServiceType;
import com.sugarbeach.proxy.ProxyHandler;

import java.rmi.RemoteException;

public class AuthenticateClientService implements AuthenticateService{
    private AuthenticateService authenticateService;

    public AuthenticateClientService() throws RemoteException {
        this.authenticateService = (AuthenticateService) ProxyHandler.getInstance().getService(ServiceType.AUTH);
    }

    @Override
    public boolean login(String role, String username, String password) throws RemoteException {
        return authenticateService.login(role, username, password);
    }
}
