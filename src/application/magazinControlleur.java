package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.megazin.*;
import application.vente.mysqlconnect;
import application.vente.vente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;

public class magazinControlleur implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
    

    @FXML
    private TableView<magazin> fxtable;

    @FXML
    private TableColumn<magazin, Integer> colid;

    @FXML
    private TableColumn<magazin, Integer> colidmagazinieur;

    @FXML
    private TableColumn<magazin, String> collieu;
    @FXML
    private TableColumn<magazin, String> colmoughataa;
    @FXML
	private TextField fxid;
    @FXML
	private TextField fxidmagazinieur;
    @FXML
	private TextField fxlieu;
    @FXML
	private TextField fxmoughataa;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnmodifie;
    @FXML
    private Button btnsup;
    
    @FXML
    private void rBack(ActionEvent event) throws IOException {///BoutiqueTemwin/src/application/Dashboard.fxml
    	root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    	
    }
 

    private static void infoBox(String infoMessage, String titleBar, String headerMessage) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		}
		    public static Connection ConnectDb(){
		    	Connection conn;
		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		             conn =  DriverManager.getConnection("jdbc:mysql://localhost/boutique_temwin","root","");
		           // JOptionPane.showMessageDialog(null, "Connection Established");
		            return conn;
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e);
		            return null;
		        }
	   }
		  public ObservableList<magazin> getMagazinList(){
		    ObservableList<magazin> magazinList=FXCollections.observableArrayList();
		    Connection  conn = ConnectDb();
		    	String query="SELECT *FROM magazin";
		    	Statement st;
		    	ResultSet rs;
		    	
		    	try {
		    		st=conn.createStatement();
		    		rs=st.executeQuery(query);
		    		magazin magazins;
		    		while(rs.next()) {
		                magazins=new magazin(rs.getInt("id"),rs.getInt("idmagazinieur"),rs.getString("lieu"),rs.getString("moughataa"));
		    			magazinList.add(magazins);
		    		}
		    	}catch(Exception ex){
		    		ex.printStackTrace();
		    	}
		    	return magazinList;
		    } 
		  public void showMagazin() {
			  ObservableList<magazin> list=getMagazinList();
			  colid.setCellValueFactory(new PropertyValueFactory<magazin,Integer>("id"));
			  colidmagazinieur.setCellValueFactory(new PropertyValueFactory<magazin,Integer>("idmagazinieur"));
			  collieu.setCellValueFactory(new PropertyValueFactory<magazin,String>("lieu"));
			  colmoughataa.setCellValueFactory(new PropertyValueFactory<magazin,String>("moughataa"));
			  fxtable.setItems(list);  
		  }

}
