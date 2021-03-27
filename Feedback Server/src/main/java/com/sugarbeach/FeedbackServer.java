package com.sugarbeach;

import com.sugarbeach.service.ServiceFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public class FeedbackServer {
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.createRegistry(8081);
            registry.rebind("feedback-server", ServiceFactoryImpl.getInstance());
            System.out.println("Feedback Server successfully started...");
        } catch (RemoteException ex) {
            Logger.getLogger(FeedbackServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
