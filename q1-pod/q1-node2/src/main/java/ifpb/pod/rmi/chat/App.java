/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author ajp
 */
public class App {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String uuid = UUID.randomUUID().toString();
        Registry registry = LocateRegistry.getRegistry(10999);
        Subject subject = (Subject) registry.lookup("__ChatServer__");
        ChatService service = (ChatService) registry.lookup("__ChatServer__");
        ChatClient client = new ChatClient(service);
        subject.registry(uuid, client);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            Message message = new Message();
            message.setFrom(uuid);
            message.setText(text);
            client.sendMessage(message);
        }
    }

}
