package com.sugarbeach.service;


import com.sugarbeach.enums.RepositoryType;
import com.sugarbeach.model.UserModel;
import com.sugarbeach.repository.RepositoryFactory;
import com.sugarbeach.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthenticateServiceImpl extends UnicastRemoteObject implements AuthenticateService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthenticateServiceImpl() throws RemoteException {
        this.userRepository = (UserRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.USER);
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean login(String role, String username, String password) {
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel != null) {
            boolean matches = bCryptPasswordEncoder.matches(password, userModel.getPassword());
            return matches && userModel.getRole().equalsIgnoreCase(role);
        }
        return false;
    }
}
