/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.RemoteException;

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
        msg = new Message("Chat: ", "Aluísio");
    }

    //    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }
//        try {
//            ChatService remoteService = (ChatService) Naming.lookup("//localhost:9999/RmiService");
//            ChatClient client = new ChatClient();
//            Message msg = new Message("POD", "Chat com RMI");
//            remoteService.sendMessage(msg);
//        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
//        }
//    }
}
