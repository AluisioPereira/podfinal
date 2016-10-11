/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.cliente;

import ifpb.pod.rmi.chat.shared.Message;
import ifpb.pod.rmi.chat.shared.Polling;
import ifpb.pod.rmi.chat.shared.Publisher;
import ifpb.pod.rmi.chat.shared.Subscriber;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author ajp
 */
@SuppressWarnings("serial")
public class ChatClientImpl extends UnicastRemoteObject implements ChatClient, Subscriber {

    private String subscriberUUID;
    private Publisher publisherStub;
    private Polling pollingStub;

    public ChatClientImpl(String uuid, Publisher publisher, Polling polling) throws RemoteException {
        subscriberUUID = uuid;
        publisherStub = publisher;
        pollingStub = polling;
    }

    ChatClientImpl(Publisher publisher) throws RemoteException {
        publisherStub = publisher;
    }

    //@Override
    public void sendMessage(Message message) throws RemoteException {
        publisherStub.publish(message);
    }

    //@Override
    public void update() throws RemoteException {
        List<Message> message = pollingStub.poll(subscriberUUID);
        for (Message msg : message) {
            System.out.println(msg.from() + ": " + msg.getText());
        }
    }

}
