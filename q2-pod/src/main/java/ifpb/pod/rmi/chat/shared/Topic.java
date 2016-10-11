/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ajp
 */
public interface Topic extends Remote {

    void register(String uuid, Subscriber sub) throws RemoteException;
}
