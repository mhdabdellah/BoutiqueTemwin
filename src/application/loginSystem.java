package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginSystem implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/boutique_temwin";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	
	public static String role ;
	
	@FXML
	private TextField loginNameOrEmail;
	
	@FXML
	private PasswordField loginPassword;
	
	Stage dashboardStage = new Stage();
	
	@FXML
	private void register(ActionEvent event) throws IOException{
//    	infoBox("Affichage de la list des Produits","Success",null);
    	root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	
	@FXML
	private void login(ActionEvent event){// paresInteger(loginNameOrEmail.getText(
		String nameOrEmail = loginNameOrEmail.getText().toString();
		String password = loginPassword.getText().toString();
		
		
//		infoBox("L'utilisateur "+nameOrEmail+" qui a comme mot de passe"+password+"est bien Enregistrer","Success",null);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			String sql= "SELECT * FROM `utilisateur` WHERE (username= '"+nameOrEmail+"' and password = '"+password+"' and type='admin') or (email= '"+nameOrEmail+"' and password = '"+password+"' and type='admin') ;";
			ResultSet rs = st.executeQuery(sql);
			Statement st2 = con.createStatement();
			String sql2= "SELECT * FROM `utilisateur` WHERE (username= '"+nameOrEmail+"' and password = '"+password+"' and type='magasinier') or (email= '"+nameOrEmail+"' and password = '"+password+"' and type='magasinier') ;";
			ResultSet rs2 = st2.executeQuery(sql2);
			Statement st3 = con.createStatement();
			String sql3= "SELECT * FROM `utilisateur` WHERE (username= '"+nameOrEmail+"' and password = '"+password+"' and type='vendeure') or (email= '"+nameOrEmail+"' and password = '"+password+"' and type='vendeure') ;";
			ResultSet rs3 = st3.executeQuery(sql3);
			if(rs.next()) {
				infoBox("L'utilisateur "+nameOrEmail+" est bien Identifie","Success",null);
				this.role = "admin";
//				Node source = (Node) event.getSource();
//				dashboardStage = (Stage) source.getScene().getWindow();
//				dashboardStage.close();
//				scene = new Scene(FXMLLoader.load(getClass().getResource("Dashboard.fxml")));
//				dashboardStage.setScene(scene);
//				dashboardStage.show();
				root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				
			}else if(rs2.next()) {
				this.role = "magasinier";
				infoBox("L'utilisateur "+nameOrEmail+" est bien Identifie Comme Magasinier","Success",null);
				root = FXMLLoader.load(getClass().getResource("DashboardMagasinier.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else if(rs3.next()) {
				infoBox("L'utilisateur "+nameOrEmail+" est bien Identifie Comme Vendeur","Success",null);
				this.role = "vendeur";
				root = FXMLLoader.load(getClass().getResource("DashboardBoutique.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else{
				infoBox("l'email ou la mots de passe il est incorrecte","Failed",null);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
