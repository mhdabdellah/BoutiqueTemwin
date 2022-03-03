package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register extends Application{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Enregistrer Nouvelle Utilisateur");
		stage.show();
	}

}
