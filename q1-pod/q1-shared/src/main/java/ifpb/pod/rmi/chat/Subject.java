/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat;

import java.rmi.Remote;

/**
 *
 * @author ajp
 */
public interface Subject extends Remote {

    void addObserver();

    void removeObserver();

    public void registry(String uuid, ChatClient client);

}
