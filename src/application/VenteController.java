package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.vente.mysqlconnect;
import application.vente.vente;
import application.loginSystem;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VenteController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	loginSystem user;
    

    @FXML
    private TableView<vente> table_users;

    @FXML
    private TableColumn<vente, Integer> col_id;

    @FXML
    private TableColumn<vente, Integer> col_idclient;

    @FXML
    private TableColumn<vente, String> col_datevente;

    @FXML
    private TableColumn<vente, Integer> col_idvendeur;

    @FXML
    private TableColumn<vente, Integer> col_quantite_vendues;
    
    @FXML
    private TableColumn<vente, String> col_produit;

    
     @FXML
    private TextField txt_idclient;

    @FXML
    private TextField txt_datevente;

    @FXML
    private TextField txt_quantite_vendues;

    @FXML
    private TextField txt_idvendeur;
        
    @FXML
    private TextField txt_id;
    
    @FXML
    private TextField txt_produit;

    
    @FXML
    private TextField filterField;
    
    public void clearFields() {
    	txt_idclient.setText(null);
    	txt_datevente.setText(null);
    	txt_quantite_vendues.setText(null);
    	txt_idvendeur.setText(null);
		txt_id.setText(null);
		txt_produit.setText(null);
	 }
    
    @FXML
    private Button back;
    
    @FXML
    private void rBack(ActionEvent event) throws IOException {///BoutiqueTemwin/src/application/Dashboard.fxml
    	if(user.role=="admin") {
	    	root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    	}else if (user.role=="magasinier") {
    		root = FXMLLoader.load(getClass().getResource("DashboardMagasinier.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
    	}else {
    		root = FXMLLoader.load(getClass().getResource("DashboardBoutique.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
    	}
    }
       
    ObservableList<vente> listM;
    ObservableList<vente> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     
    public void Add_users (){ 
    	int idc = Integer.parseInt(txt_idclient.getText().toString());
    	int idv = Integer.parseInt(txt_idvendeur.getText().toString());
        int qvendue = Integer.parseInt(txt_quantite_vendues.getText().toString());
        String pr = txt_produit.getText().toString();
        String dv = txt_datevente.getText().toString();
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into ventes (id,idclient,idvendeur,quantite_vendues,produit,datevente) VALUES (null,'"+idc+"','"+idv+"','"+qvendue+"','"+pr+"','"+dv+"');";
        try {
        	Statement st = conn.createStatement();
        	st.executeUpdate(sql);
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, txt_idclient.getText());
//            pst.setString(2, txt_idvendeur.getText());
//            pst.setString(3, txt_quantite_vendues.getText());
//            pst.setString(4, txt_produit.getText());
//            pst.setString(5, txt_datevente.getText());
//            pst.execute();
            
//            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search_user();
            clearFields();
            infoBox("Le vente est bien Ajouté","Success",null);
            
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le vente n'est pas Ajouté par ce que  "+e,"Failed",null);
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
    txt_idclient.setText(col_idclient.getCellData(index).toString());
    txt_idvendeur.setText(col_idvendeur.getCellData(index).toString());
    txt_quantite_vendues.setText(col_quantite_vendues.getCellData(index).toString());
    txt_produit.setText(col_produit.getCellData(index).toString());
    txt_datevente.setText(col_datevente.getCellData(index).toString());
    
    }

    public void Edit (){   //`username`, `password`, `email`, `type`
        try {
            conn = mysqlconnect.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_idclient.getText();
            String value3 = txt_idvendeur.getText();
            String value4 = txt_quantite_vendues.getText();
            String value5 = txt_produit.getText();
            String value6 = txt_datevente.getText();
            String sql = "update ventes set idclient= '"+value2+"',idvendeur = '"+
                    value3+"',quantite_vendues = '"+value4+"',produit = '"+value5+"',datevente = '"+value6+"' where id='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_user();
            clearFields();
            infoBox("Le vente est bien Modifié","Success",null);
            
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le vente n'est pas Modifié par ce que  "+e,"Failed",null);
        }
        
    }
    
    public void Delete(){
    conn = mysqlconnect.ConnectDb();
    String sql = "delete from ventes where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Delete");
            infoBox("Le vente est bien Supprimé","Success",null);
            UpdateTable();
            search_user();
            clearFields();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le vente n'est pas Supprimé par ce que  "+e,"Failed",null);
        }
    
    }

    public void UpdateTable(){
//        col_id.setCellValueFactory(new PropertyValueFactory<vente,Integer>("id"));
//        col_idclient.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idclient"));
//        col_quantite_vendues.setCellValueFactory(new PropertyValueFactory<vente,Integer>("quantite_vendues"));
//        col_idvendeur.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idvendeur"));
//        col_produit.setCellValueFactory(new PropertyValueFactory<vente,String>("produit"));
//        col_datevente.setCellValueFactory(new PropertyValueFactory<vente,String>("datevente"));
    	
    	col_id.setCellValueFactory(new PropertyValueFactory<vente,Integer>("id"));
        col_idclient.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idclient"));
        col_idvendeur.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idvendeur"));
        col_quantite_vendues.setCellValueFactory(new PropertyValueFactory<vente,Integer>("quantite_vendues"));
        col_produit.setCellValueFactory(new PropertyValueFactory<vente,String>("produit"));
        col_datevente.setCellValueFactory(new PropertyValueFactory<vente,String>("datevente"));
        
        //id,idclient,idvendeur,quantite_vendues,produit,datevente
        
        listM = mysqlconnect.getDatausers();
        table_users.setItems(listM);
    }
    
//    public void UpdateTable(){
//        col_id.setCellValueFactory(new PropertyValueFactory<vente,Integer>("id"));
//        col_idclient.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idclient"));
//        col_quantite_vendues.setCellValueFactory(new PropertyValueFactory<vente,Integer>("quantite_vendues"));
//        col_idvendeur.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idvendeur"));
//        col_produit.setCellValueFactory(new PropertyValueFactory<vente,String>("produit"));
//        col_datevente.setCellValueFactory(new PropertyValueFactory<vente,String>("datevente"));
//        
//        listM = mysqlconnect.getDatausers();
//        table_users.setItems(listM);
//    }
    
    

    
 @FXML
    void search_user() {          
        col_id.setCellValueFactory(new PropertyValueFactory<vente,Integer>("id"));
        col_idclient.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idclient"));
        col_quantite_vendues.setCellValueFactory(new PropertyValueFactory<vente,Integer>("quantite_vendues"));
        col_idvendeur.setCellValueFactory(new PropertyValueFactory<vente,Integer>("idvendeur"));
        col_produit.setCellValueFactory(new PropertyValueFactory<vente,String>("produit"));
        col_datevente.setCellValueFactory(new PropertyValueFactory<vente,String>("datevente"));
        
        dataList = mysqlconnect.getDatausers();
        table_users.setItems(dataList);
        FilteredList<vente> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getProduit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getIdvendeur() != -1) {
     return true; // Filter matches password
    }else if (person.getIdclient() != -1) {
     return true; // Filter matches password
    }
    else if (person.getId()!=-1)
         return true;// Filter matches email
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<vente> sortedData = new SortedList<>(filteredData);  
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
