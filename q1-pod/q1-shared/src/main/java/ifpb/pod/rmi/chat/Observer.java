/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ajp
 */
@SuppressWarnings("serial")
public class Observer extends UnicastRemoteObject implements Remote {

    private static final long serialVersionUID = 1L;
    List observes = new ArrayList();

    public Observer() throws RemoteException {
        super();
    }

    public void notifyObserver(Message msg) throws RemoteException {
        Iterator it = observes.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.notifyObserver(msg);
            System.out.println(msg);
        }

    }

}
