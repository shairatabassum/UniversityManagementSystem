/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuUMS;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MeRiDa
 */
public class DBconnection {
    
     Connection cnn;
    public static Connection Connecrdb() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection cnn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MeRiDa\\Documents\\NetBeansProjects\\UMS\\UMS.sqlite");
            return cnn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
