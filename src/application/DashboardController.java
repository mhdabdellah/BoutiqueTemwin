package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class DashboardController implements Initializable{
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	    @FXML
	    private Button manageUsers;
	    @FXML
	    private Button manageProduits;
	    @FXML
	    private Button logout;
	    
	    @FXML
		private void manageusers(ActionEvent event) throws IOException{
	    	infoBox("Affichage de la list des Utilisateurs","Success",null);
	    	root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    	
	    }
	    
	    @FXML
		private void manageproduits(ActionEvent event) throws IOException{
	    	infoBox("Affichage de la list des Produits","Success",null);
	    	root = FXMLLoader.load(getClass().getResource("produit/FXMLDocument.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	    
	    @FXML
		private void Logout(ActionEvent event) throws IOException{
	    	infoBox("Logout de Notre System","Success",null);
	    	root = FXMLLoader.load(getClass().getResource("login.fxml"));
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

}
