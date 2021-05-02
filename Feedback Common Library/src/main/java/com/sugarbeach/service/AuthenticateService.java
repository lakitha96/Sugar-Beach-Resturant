package com.sugarbeach.service;

import java.rmi.RemoteException;

public interface AuthenticateService extends SuperService {
    boolean login(String role, String username, String password) throws RemoteException;
}
