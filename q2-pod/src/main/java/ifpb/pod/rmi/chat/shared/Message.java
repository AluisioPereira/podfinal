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
import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {

    private String from;
    private String text;

    public String from() {
        return from;
    }

    public void setFrom(String uuid) {
        from = uuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
