package application.boutique;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author muhamedoufi
 */
public class mysqlconnect {
    
    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/boutique_temwin","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    public static ObservableList<Boutique> getDataBoutique(){
        Connection conn = ConnectDb();
        ObservableList<Boutique> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from boutique");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Boutique(Integer.parseInt(rs.getString("id")), rs.getString("emplacement"), Integer.parseInt(rs.getString("vendeur")),rs.getString("moughataa")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}


