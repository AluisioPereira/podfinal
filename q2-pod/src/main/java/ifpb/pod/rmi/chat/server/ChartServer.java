/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.server;

import ifpb.pod.rmi.chat.shared.Message;
import ifpb.pod.rmi.chat.shared.Subscriber;
import ifpb.pod.rmi.chat.shared.TopicManager;
import ifpb.pod.rmi.chat.shared.TopicManagerImpl;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajp
 */
public class ChartServer implements TopicManager {

    @Override
    public void notifySubscribers() {
        System.out.println("Notificação!");

    }

    @Override
    public void publish(Message message) throws RemoteException {
        System.out.println("Messagem: " + message);
    }

    @Override
    public void register(String uuid, Subscriber sub) throws RemoteException, AccessException {
        final TopicManager manager = new TopicManagerImpl();
        Registry registry = LocateRegistry.createRegistry(10999);
        try {
            registry.bind("__ChatServer__", manager);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ChartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Message> poll(String uuid) throws RemoteException {
        throw new UnsupportedOperationException("lista de menssagem!");
    }

}
