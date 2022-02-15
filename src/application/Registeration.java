package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class Registeration implements Initializable{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/boutique_temwin";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	
	
	@FXML
	private TextField registerName;
	
	@FXML
	private TextField registerEmail;
	
	@FXML
	private TextField registerEtat;
	
	@FXML
	private PasswordField registerPassword;
	
	@FXML
	private PasswordField registerConfirmPassword;
	
	@FXML
	private void userRegisteration(ActionEvent event){
		
		String nom = registerName.getText().toString();
//		infoBox("L'utilisateur "+nom+" est bien Enregistrer","Success",null);
		String email = registerEmail.getText().toString();
		String password = registerPassword.getText().toString();
		String confirmPassword = registerConfirmPassword.getText().toString();
		String  etat= registerEtat.getText().toString();
		int constant = 9;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			if (password.contentEquals(confirmPassword)) {
				String sql= "INSERT INTO `utilisateur`(`id`, `username`, `password`, `email`, `type`) VALUES (null,'"+nom+"','"+password+"','"+email+"','"+etat+"');";
//				st.executeUpdate(sql);
				
				if(st.executeUpdate(sql)!=0) {
					infoBox("L'utilisateur "+nom+" est bien Enregistrer","Success",null);
				}else {
					infoBox("Problem d'insertion Repeter l'insertion s'il vous plait","Failed",null);
				}
			}else {
				infoBox("repeter la mots de passe correcte","Failed",null);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
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
