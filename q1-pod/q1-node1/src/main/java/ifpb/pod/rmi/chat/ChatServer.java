/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajp
 */
public class ChatServer implements ChatService, Subject {

    List observes = new ArrayList();

    @Override
    public void sendMessage(Message m) {
        Iterator it = observes.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            try {
                o.notifyObserver(m);
            } catch (RemoteException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void addObserver(Observer o) {
        observes.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observes.remove(o);
    }

    @Override
    public void registry(String uuid, ifpb.pod.rmi.chat.ChatClient client) {

    }

}
