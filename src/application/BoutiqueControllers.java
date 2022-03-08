package application;
import application.boutique.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoutiqueControllers implements Initializable {
		
		private Stage stage;
		private Scene scene;
		private Parent root;
	    

	    @FXML
	    private TableView<Boutique> table_boutique;

	    @FXML
	    private TableColumn<Boutique, Integer> col_id;
	    
	    @FXML
	    private TableColumn<Boutique, String> col_Emplacement;

	    @FXML
	    private TableColumn<Boutique, Integer> col_vendeur;
	    @FXML
	    private TableColumn<Boutique, String> col_moughataa;

	   
	    
	     @FXML
	    private TextField txt_Emplacement;

	    @FXML
	    private TextField txt_vendeur;

	    @FXML
	    private TextField txt_id;
	    
	    @FXML
	    private TextField text_mgt;
	    @FXML
	    private TextField filterField;
	    
	    
	    
	    public void clearFields() {
	    	txt_Emplacement.setText(null);
	    	txt_vendeur.setText(null);
			txt_id.setText(null);
			text_mgt.setText(null);
		 }
	   
	    @FXML
	    private void generer(ActionEvent event) {
	    	
	    }
	    
	    @FXML
	    private Button back;
	    
	    @FXML
	    private void rBack(ActionEvent event) throws IOException {
	    	///BoutiqueTemwin/src/application/Dashboard.fxml
	    	
	    	URL uri = new File("src/application//Dashboard.fxml").toURI().toURL();
	    	root = FXMLLoader.load(uri);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    	
	    }
	       
	    ObservableList<Boutique> listM;
	    ObservableList<Boutique> dataList;
	    
	   
	    
	    int index = -1;
	    
	    Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	     
	    public void Add_boutique (){    
	        conn = mysqlconnect.ConnectDb();
	        String sql = "insert into boutique(emplacemnt,vendeur,moughataa) values(?,?,?)";
	        try {
	        	
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, txt_Emplacement.getText());
	            pst.setString(2, txt_vendeur.getText());
	            pst.setString(3, text_mgt.getText());
	            
	            pst.execute();

//	            JOptionPane.showMessageDialog(null, "Users Add succes");
	            UpdateTable();
	            search_boutique();
	            clearFields();
	            infoBox("Le Boutique est bien jhjh Ajouté","Success",null);
	            
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("Le Boutique n'est pas Ajouté par ce  que  "+e,"Failed",null);
	        }
	    }
	    

	    //////// methode select users ///////
	    @FXML
	    void getSelected (MouseEvent event){
	    index = table_boutique.getSelectionModel().getSelectedIndex();
	    if (index <= -1){
	    
	        return;
	    }
	    txt_id.setText(col_id.getCellData(index).toString());
	    txt_Emplacement.setText(col_Emplacement.getCellData(index).toString());
	    txt_vendeur.setText(col_vendeur.getCellData(index).toString());
	    text_mgt.setText(col_moughataa.getCellData(index).toString());
	   
	    }

	    public void Edit (){   //`username`, `password`, `email`, `type`
	        try {
	            conn = mysqlconnect.ConnectDb();
	            String value1 = txt_id.getText();
	            String value2 = txt_Emplacement.getText();
	            String value3 = txt_vendeur.getText();
	            String value4 = text_mgt.getText();
	            String sql = "update boutique set emplacemnt= '"+value2+"',vendeur= '"+
	                    value3+"',moughataa= '"+value4+"' ";
	            pst= conn.prepareStatement(sql);
	            pst.execute();
//	            JOptionPane.showMessageDialog(null, "Update");
	            UpdateTable();
	            search_boutique();
	            clearFields();
	            infoBox("Le Boutique est bien Modifié","Success",null);
	            
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("Le Boutique n'est pas Modifié par ce que  "+e,"Failed",null);
	        }
	        
	    }
	    
	    public void Delete(){
	    conn = mysqlconnect.ConnectDb();
	    String sql = "delete from boutique where id = ?";
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, txt_id.getText());
	            pst.execute();
//	            JOptionPane.showMessageDialog(null, "Delete");
	            infoBox("Le Boutique est bien Supprimé","Success",null);
	            UpdateTable();
	            search_boutique();
	            clearFields();
	        } catch (Exception e) {
//	            JOptionPane.showMessageDialog(null, e);
	        	infoBox("Le Boutique n'est pas Supprimé par ce que  "+e,"Failed",null);
	        }
	    
	    }

	    
	    public void UpdateTable(){
	        col_id.setCellValueFactory(new PropertyValueFactory<Boutique,Integer>("id"));
	        col_Emplacement.setCellValueFactory(new PropertyValueFactory<Boutique,String>("emplacement"));
	        col_vendeur.setCellValueFactory(new PropertyValueFactory<Boutique,Integer>("vendeur"));
	        col_moughataa.setCellValueFactory(new PropertyValueFactory<Boutique,String>("moughataa"));
	        
	        listM = mysqlconnect.getDataBoutique();
	        table_boutique.setItems(listM);
	    }
	    
	    

	    
	 @FXML
	    void search_boutique() {          
	        col_id.setCellValueFactory(new PropertyValueFactory<Boutique,Integer>("id"));
	        col_Emplacement.setCellValueFactory(new PropertyValueFactory<Boutique,String>("emplacement"));
	        col_vendeur.setCellValueFactory(new PropertyValueFactory<Boutique,Integer>("vendeur"));
	        col_moughataa.setCellValueFactory(new PropertyValueFactory<Boutique,String>("moughataa"));
	       
	        dataList = mysqlconnect.getDataBoutique();
	        table_boutique.setItems(dataList);
	        FilteredList<Boutique> filteredData = new FilteredList<>(dataList, b -> true);  
	 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	 filteredData.setPredicate(boutique -> {
	    if (newValue == null || newValue.isEmpty()) {
	     return true;
	    }    
	    String lowerCaseFilter = newValue.toLowerCase();
	    
	    if (boutique.getEmplacement().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
	     return true; // Filter matches username
	    } else if (boutique.getVendeur()!= -1) {
	     return true; // Filter matches lastname
	    }else if (boutique.getMoughataa().toLowerCase().indexOf(lowerCaseFilter) != -1) {
	     return true; // Filter matches nni
	    }
	    else
		return false;
	    
	   });
	  });  
	  SortedList<Boutique> sortedData = new SortedList<>(filteredData);  
	  sortedData.comparatorProperty().bind(table_boutique.comparatorProperty());  
	  table_boutique.setItems(sortedData);      
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
	    search_boutique();
	    // Code Source in description
	    } 

	}


