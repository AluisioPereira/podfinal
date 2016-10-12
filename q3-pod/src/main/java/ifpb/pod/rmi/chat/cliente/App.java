/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.cliente;

import ifpb.pod.rmi.chat.shared.TopicManager;
import ifpb.pod.rmi.chat.shared.TopicManagerImpl;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ajp
 */
public class App {

    private static void startServer() throws Exception {
        String _port = System.getenv("PORT") != null
                ? System.getenv("PORT") : "8080";
        Integer port = Integer.parseInt(_port);
        //

    }

    private static void startRMIServer() throws AccessException, RemoteException, AlreadyBoundException {
        //
        final TopicManager manager = new TopicManagerImpl();
        //
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("__ChatServer__", manager);
    }

    public static void main(String[] args) throws Exception {
        startRMIServer();
        startServer();
    }

}
