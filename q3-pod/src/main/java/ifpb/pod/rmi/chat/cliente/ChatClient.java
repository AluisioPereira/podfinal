/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.cliente;

import ifpb.pod.rmi.chat.shared.Message;
import ifpb.pod.rmi.chat.shared.Subscriber;
import java.rmi.RemoteException;

/**
 *
 * @author ajp
 */
public interface ChatClient extends Subscriber {

    public void sendMessage(Message message) throws RemoteException;
}
