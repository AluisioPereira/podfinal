/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.shared;

/**
 *
 * @author ajp
 */
public interface TopicManager extends Publisher, Topic, Polling {

    public void notifySubscribers();
}
