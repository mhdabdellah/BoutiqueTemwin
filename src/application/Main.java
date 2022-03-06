package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();/BoutiqueTemwin/src/application/magazinDocument.fxml
			Parent root = FXMLLoader.load(getClass().getResource("magazinDocument.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Enregistrer Nouvelle Utilisateur");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
