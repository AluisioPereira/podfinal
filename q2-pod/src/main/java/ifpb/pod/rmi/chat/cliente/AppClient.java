/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.cliente;

import ifpb.pod.rmi.chat.shared.Message;
import ifpb.pod.rmi.chat.shared.Polling;
import ifpb.pod.rmi.chat.shared.Publisher;
import ifpb.pod.rmi.chat.shared.Topic;
import ifpb.pod.rmi.chat.shared.TopicManager;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 *
 * @author ajp
 */
public class AppClient {

    @SuppressWarnings("restriction")
    private static Registry getRegistry() throws IOException {
        String url = "ag-rmi-pubsub-chatinheroku.herokuapp.com";
        RMISocketFactory.setSocketFactory(new sun.rmi.transport.proxy.RMIHttpToCGISocketFactory());
        return LocateRegistry.getRegistry(
                url, 1099, RMISocketFactory.getSocketFactory());
    }

    public static void main(String[] args) throws NotBoundException, IOException {
        String uuid = UUID.randomUUID().toString();
        //
        if (args.length > 0) {
            uuid = args[0];
        }
        //
        Registry registry = getRegistry();
        TopicManager manager = (TopicManager) registry.lookup("__ChatServer__");
        Topic topic = (Topic) manager;
        Publisher publisher = (Publisher) manager;
        Polling polling = (Polling) manager;
        //
        final ChatClientImpl client = new ChatClientImpl(uuid, publisher, polling);
        topic.register(uuid, client);
        //
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    client.update();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 1000);//1s, 10s
        //
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //
            String text = scanner.nextLine();
            //
            Message message = new Message();
            message.setFrom(uuid);
            message.setText(text);
            //
            client.sendMessage(message);
        }
        //
    }
}
