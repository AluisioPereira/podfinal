/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pod.rmi.chat.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author ajp
 */
public class NotificationRepository {

    String driver = "org.postgresql.Driver";
    String user = "postgres";
    String senha = "12345";
    String url = "jdbc:postgresql://localhost:5432/pod";
    Connection con = null;
    private static final Logger LOG = Logger.getLogger(NotificationRepository.class.getName());

    public NotificationRepository() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url, user, senha);
    }

    public void store(Notification n) {

    }

    public Notification[] listNotifications(String uuid) {
        return null;
    }

    public void removeNotifications(String uuid) {

    }
}
