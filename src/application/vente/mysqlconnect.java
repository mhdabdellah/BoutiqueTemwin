package application.vente;

	
	
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

	/**
	 *
	 * @author 
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
	    
	    public static ObservableList<vente> getDatausers(){
	        Connection conn = ConnectDb();
	        ObservableList<vente> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from ventes");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new vente(Integer.parseInt(rs.getString("id").toString()), Integer.parseInt(rs.getString("idclient").toString()), Integer.parseInt(rs.getString("quantite_vendues").toString()),Integer.parseInt( rs.getString("idvendeur").toString()), rs.getString("datevente").toString(),rs.getString("produit").toString()));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	    
}


