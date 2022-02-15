package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;



public class DashboardController implements Initializable{
	
	    @FXML
	    private Button ajouter;
	    @FXML
	    private Button listerp;
	    @FXML
	    private Button ajouteru;
	    @FXML
	    private Button listeru;
	    @FXML
	    private Button ajouterv;
	    @FXML
	    private Button listerv;
	    
	    @FXML
		private void ajouterProduit(ActionEvent event){
	    	infoBox("L'ajoute de la Produit dans la list des Produits","Success",null);
	    	
	    }
	    
	    @FXML
		private void listerProduits(ActionEvent event){
	    	infoBox("Affichage de la list des Produits","Success",null);
	    }
	    
	    @FXML
		private void ajouterUser(ActionEvent event){
	    	infoBox("L'ajoute d'un Utilisateur dans la list des Utilisateurs","Success",null);
	    }
	    
	    @FXML
		private void listerUsers(ActionEvent event){
	    	infoBox("Affichage de la list des Utilisateurs","Success",null);
	    }
	    
	    @FXML
		private void ajouterVent(ActionEvent event){
	    	infoBox("L'ajoute de la Vent dans la list des Vents","Success",null);
	    }
	    
	    @FXML
		private void listerVents(ActionEvent event){
	    	infoBox(" Affichage de la list des Vents","Success",null);
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
