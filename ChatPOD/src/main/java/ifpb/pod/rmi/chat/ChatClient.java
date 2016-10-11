/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ajp
 */
public class ChatClient extends UnicastRemoteObject implements Observerr {

    protected ChatClient() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            ChatService remoteService = (ChatService) Naming
                    .lookup("//localhost:9999/ChatService");

            ChatClient client = new ChatClient();
            remoteService.addObserver(client);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object observable, Object updateMsg)
            throws RemoteException {
        System.out.println("Mensagem:" + updateMsg);
    }
}
