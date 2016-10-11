/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajp
 */
public class ChatClient extends Observer implements ChatService {

    private static final long serialVersionUID = 1L;

    ChatClient(ChatService service) throws RemoteException {
        super();
    }

    public ChatClient() throws RemoteException {
    }

    @Override
    public void sendMessage(Message msg) {
        Iterator it = observes.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            try {
                o.notifyObserver(msg);
            } catch (RemoteException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
