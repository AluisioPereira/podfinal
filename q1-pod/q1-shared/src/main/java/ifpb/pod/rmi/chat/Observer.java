/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ajp
 */
public class Observer extends UnicastRemoteObject implements Remote {

    public Observer() throws RemoteException {
        super();
    }

    public void notifyObserver(Message msg) throws RemoteException {

    }

}
