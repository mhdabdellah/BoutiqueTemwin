package application.produit;

	
	
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

	/**
	 *
	 * @author amir
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
	    
	    public static ObservableList<produits> getDatausers(){
	        Connection conn = ConnectDb();
	        ObservableList<produits> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from produit");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new produits(Integer.parseInt(rs.getString("id")), rs.getString("code_produit"), rs.getString("deseignation"), Integer.parseInt(rs.getString("quantite_pour_client")), rs.getString("fournisseur"),Integer.parseInt(rs.getString("remise")), Integer.parseInt(rs.getString("prix")), Integer.parseInt(rs.getString("quantite"))));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	    
}


