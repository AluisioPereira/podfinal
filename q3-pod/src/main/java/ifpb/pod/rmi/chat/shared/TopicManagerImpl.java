/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ajp
 */
@SuppressWarnings("serial")
public class TopicManagerImpl extends UnicastRemoteObject implements TopicManager {

    private List<String> subscribers = new ArrayList<String>();
    private Map<String, List<Message>> messages = new HashMap<String, List<Message>>();

    public TopicManagerImpl() throws RemoteException {
    }

    //@Override
    public void register(String uuid, Subscriber subscriber) throws RemoteException {
        subscribers.add(uuid);
        messages.put(uuid, new ArrayList<Message>());
    }

    //@Override
    public void publish(Message message) throws RemoteException {
        List<String> uuids = subscribers;
        for (String uuid : uuids) {
            if (!uuid.equals(message.from())) {
                List<Message> list = messages.get(uuid);
                list.add(message);
            }
        }
    }

    public List<Message> poll(String uuid) throws RemoteException {

        //
        List<Message> result = new ArrayList<Message>();
        //
        List<Message> notifications = messages.get(uuid);
        if (!notifications.isEmpty()) {
            result.addAll(notifications);
            notifications.clear();
        }
        //
        return result;
    }

    @Override
    public void notifySubscribers() {
    }

}
