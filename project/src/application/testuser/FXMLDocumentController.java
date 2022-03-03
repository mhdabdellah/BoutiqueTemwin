package application.testuser;

	import java.io.IOException;
import java.net.URL;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ResourceBundle;
//	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.collections.transformation.FilteredList;
	import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
//	import javafx.scene.input.KeyEvent;
	import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//import javax.swing.JOptionPane;

	/**
	 *
	 * @author amir
	 */
	public class FXMLDocumentController implements Initializable {
		
		private Stage stage;
		private Scene scene;
		private Parent root;
	    

	    @FXML
	    private TableView<users> table_users;

	    @FXML
	    private TableColumn<users, Integer> col_id;

	    @FXML
	    private TableColumn<users, String> col_username;

	    @FXML
	    private TableColumn<users, String> col_password;

	    @FXML
	    private TableColumn<users, String> col_email;

	    @FXML
	    private TableColumn<users, String> col_type;
	    
	     @FXML
	    private TextField txt_username;

	    @FXML
	    private TextField txt_password;

	    @FXML
	    private TextField txt_email;

	    @FXML
	    private TextField txt_type;
	        
	    @FXML
	    private TextField txt_id;
	    
	    @FXML
	    private TextField filterField;
	    
	    public void clearFields() {
	    	txt_username.setText(null);
	    	txt_password.setText(null);
	    	txt_email.setText(null);
	    	txt_type.setText(null);
			txt_id.setText(null);
		 }
	    
	    @FXML
	    private Button back;
	    
	    @FXML
	    private void rBack(ActionEvent event) throws IOException {///BoutiqueTemwin/src/application/Dashboard.fxml
	    	root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    	
	    }
	       
	    ObservableList<users> listM;
	    ObservableList<users> dataList;
	    
	   
	    
	    int index = -1;
	    
	    Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	     
	    public void Add_users (){    
	        conn = mysqlconnect.ConnectDb();
	        String sql = "insert into utilisateur (username,password,email,type)values(?,?,?,? )";
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, txt_username.getText());
	            pst.setString(2, txt_password.getText());
	            pst.setString(3, txt_email.getText());
	            pst.setString(4, txt_type.getText());
	            pst.execute();
	            
//	            JOptionPane.showMessageDialog(null, "Users Add succes");
	            UpdateTable();
	            search_user();
	            clearFields();
	            infoBox("L'utilisateur est bien Ajouté","Success",null);
	            
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("L'utilisateur n'est pas Ajouté par ce que  "+e,"Failed",null);
	        }
	    }
	    

	    //////// methode select users ///////
	    @FXML
	    void getSelected (MouseEvent event){
	    index = table_users.getSelectionModel().getSelectedIndex();
	    if (index <= -1){
	    
	        return;
	    }
	    txt_id.setText(col_id.getCellData(index).toString());
	    txt_username.setText(col_username.getCellData(index).toString());
	    txt_password.setText(col_password.getCellData(index).toString());
	    txt_email.setText(col_email.getCellData(index).toString());
	    txt_type.setText(col_type.getCellData(index).toString());
	    
	    }

	    public void Edit (){   //`username`, `password`, `email`, `type`
	        try {
	            conn = mysqlconnect.ConnectDb();
	            String value1 = txt_id.getText();
	            String value2 = txt_username.getText();
	            String value3 = txt_password.getText();
	            String value4 = txt_email.getText();
	            String value5 = txt_type.getText();
	            String sql = "update utilisateur set username= '"+value2+"',password= '"+
	                    value3+"',email= '"+value4+"',type= '"+value5+"' where id='"+value1+"' ";
	            pst= conn.prepareStatement(sql);
	            pst.execute();
//	            JOptionPane.showMessageDialog(null, "Update");
	            UpdateTable();
	            search_user();
	            clearFields();
	            infoBox("L'utilisateur est bien Modifié","Success",null);
	            
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("L'utilisateur n'est pas Modifié par ce que  "+e,"Failed",null);
	        }
	        
	    }
	    
	    public void Delete(){
	    conn = mysqlconnect.ConnectDb();
	    String sql = "delete from utilisateur where id = ?";
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, txt_id.getText());
	            pst.execute();
//	            JOptionPane.showMessageDialog(null, "Delete");
	            infoBox("L'utilisateur est bien Supprimé","Success",null);
	            UpdateTable();
	            search_user();
	            clearFields();
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("L'utilisateur n'est pas Supprimé par ce que  "+e,"Failed",null);
	        }
	    
	    }

	    
	    public void UpdateTable(){
	        col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
	        col_username.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
	        col_password.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
	        col_email.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
	        col_type.setCellValueFactory(new PropertyValueFactory<users,String>("type"));
	        
	        listM = mysqlconnect.getDatausers();
	        table_users.setItems(listM);
	    }
	    
	    

	    
	 @FXML
	    void search_user() {          
	        col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
	        col_username.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
	        col_password.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
	        col_email.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
	        col_type.setCellValueFactory(new PropertyValueFactory<users,String>("type"));
	        
	        dataList = mysqlconnect.getDatausers();
	        table_users.setItems(dataList);
	        FilteredList<users> filteredData = new FilteredList<>(dataList, b -> true);  
	 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	 filteredData.setPredicate(person -> {
	    if (newValue == null || newValue.isEmpty()) {
	     return true;
	    }    
	    String lowerCaseFilter = newValue.toLowerCase();
	    
	    if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
	     return true; // Filter matches username
	    } else if (person.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
	     return true; // Filter matches password
	    }else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
	     return true; // Filter matches password
	    }
	    else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter)!=-1)
	         return true;// Filter matches email
	                                
	         else  
	          return false; // Does not match.
	   });
	  });  
	  SortedList<users> sortedData = new SortedList<>(filteredData);  
	  sortedData.comparatorProperty().bind(table_users.comparatorProperty());  
	  table_users.setItems(sortedData);      
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
	    public void initialize(URL url, ResourceBundle rb) {
	    UpdateTable();
	    search_user();
	    // Code Source in description
	    } 
	}
