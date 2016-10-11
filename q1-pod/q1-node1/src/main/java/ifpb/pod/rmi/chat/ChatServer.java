/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

/**
 *
 * @author ajp
 */
public class ChatServer implements ChatService, Subject {

    @Override
    public void sendMessage(Message m) {
        m = new Message("POD", "Chat!");

    }

    @Override
    public void addObserver() {
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void registry(String uuid, ifpb.pod.rmi.chat.ChatClient client) {
    }

}
