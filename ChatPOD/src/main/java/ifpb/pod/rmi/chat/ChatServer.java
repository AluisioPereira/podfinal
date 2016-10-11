/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.io.Serializable;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ajp
 */
public class ChatServer extends Observable implements ChatService {

    private class Observado implements Observer, Serializable {

        private static final long serialVersionUID = 1L;

        private Observerr observer = null;

        public Observado(Observerr remote) {
            this.observer = remote;
        }

        @Override
        public void update(Observable o, Object arg) {
            try {
                observer.update(o.toString(), arg);
            } catch (RemoteException e) {
                System.out
                        .println("Observer:" + this);
                o.deleteObserver(this);
            }
        }

    }

    @Override
    public void addObserver(Observerr Observer) throws RemoteException {
        Observado observado = new Observado(Observer);
        addObserver(observado);
        System.out.println("Observado:" + observado);
    }

    Thread thread = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                }
                setChanged();
                notifyObservers(new Date());
            }
        }
    ;

    };

    public ChatServer() {
        thread.start();
    }

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            Registry rmiRegistry = LocateRegistry.createRegistry(9999);
            ChatService ChatService = (ChatService) UnicastRemoteObject
                    .exportObject(new ChatServer(), 9999);
            rmiRegistry.bind("ChatService", ChatService);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
