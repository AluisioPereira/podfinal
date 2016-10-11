/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.server;

import ifpb.pod.rmi.chat.shared.TopicManager;
import ifpb.pod.rmi.chat.shared.TopicManagerImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ajp
 */
public class App {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        final TopicManager manager = new TopicManagerImpl();
        Registry registry = LocateRegistry.createRegistry(10999);
        registry.bind("__ChatServer__", manager);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                manager.notifySubscribers();
            }
        }, 1000, 10000);
    }
}
