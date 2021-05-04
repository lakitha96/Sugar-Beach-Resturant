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

    /**
     * On this constructor objects will initiate
     */
    public AuthenticateServiceImpl() throws RemoteException {
        this.userRepository = (UserRepository) RepositoryFactory.getInstance().getRepository(RepositoryType.USER);
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * This method used to authenticate with users
     * passwords will be encrypted
     * passwords matcher will check password accuracy and return matched or not
     *
     ** third party library used - spring-security-crypto
     ** https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/crypto.html
     ** plain password and database saved encrypted password will check on matches method
     *
     * @return success (true) or failed (false) boolean
     */
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
