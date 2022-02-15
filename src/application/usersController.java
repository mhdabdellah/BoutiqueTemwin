package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class usersController implements Initializable{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/boutique_temwin";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	
	
	    @FXML
	    private TableView<Users> tableUsers;
	    @FXML
	    private TableColumn<Users, Integer> userid;
	    @FXML
	    private TableColumn<Users, String> userName;
	    @FXML
	    private TableColumn<Users, String> userPassword;
	    @FXML
	    private TableColumn<Users, String> userEmail;
	    @FXML
	    private TableColumn<Users, String> userType;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<Users> list = getProductList();
		userid.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
		userName.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));
		userPassword.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
		userEmail.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
		userType.setCellValueFactory(new PropertyValueFactory<Users, String>("type"));
		        
		 tableUsers.setItems(list);
		
	}
	
	public ObservableList<Users> getProductList(){
		 ObservableList<Users> productList = FXCollections.observableArrayList();
		 String query = "SELECT * FROM utilisateur";
		 try {  
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
            Users user;
            
            while(rs.next()){
                user = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("email"),rs.getString("type"));
                productList.add(user);
                
            }
		 }catch(SQLException e){
			 System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
	     } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return productList;
		
	}

}
