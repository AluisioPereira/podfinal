/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.cliente;

import ifpb.pod.rmi.chat.shared.Message;
import ifpb.pod.rmi.chat.shared.Publisher;
import ifpb.pod.rmi.chat.shared.Topic;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author ajp
 */
public class App {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        String uuid = "aluisio1102@gmail.com";
        Registry registry = LocateRegistry.getRegistry(10999);
        Topic topic = (Topic) registry.lookup("__ChatServer__");
        Publisher publisher = (Publisher) registry.lookup("__ChatServer__");
        ChatClientImpl client = new ChatClientImpl(publisher);
        topic.register(uuid, client);
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
