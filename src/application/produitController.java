package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.produit.mysqlconnect;
import application.produit.produits;
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

public class produitController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TableView<produits> table_produits;

    @FXML
    private TableColumn<produits, Integer> col_id;

    @FXML
    private TableColumn<produits, String> col_code_produit;

    @FXML
    private TableColumn<produits, String> col_deseignation;

    @FXML
    private TableColumn<produits, Integer> col_quantite_pour_client;

    @FXML
    private TableColumn<produits, String> col_fournisseur;
    
    @FXML
    private TableColumn<produits, Integer> col_remise;
    
    @FXML
    private TableColumn<produits, Integer> col_prix;
    
    @FXML
    private TableColumn<produits, Integer> col_quantite;
    
     @FXML
    private TextField txt_code_produit;

    @FXML
    private TextField txt_deseignation;

    @FXML
    private TextField txt_quantite_pour_client;

    @FXML
    private TextField txt_fournisseur;
        
    @FXML
    private TextField txt_id;
    
    @FXML
    private TextField txt_remise;
    
    @FXML
    private TextField txt_prix;
    
    @FXML
    private TextField txt_quantite;
    
    @FXML
    private TextField filterField;
    
    public void clearFields() {
		 txt_code_produit.setText(null);
		 txt_deseignation.setText(null);
		 txt_quantite_pour_client.setText(null);
		 txt_fournisseur.setText(null);
		 txt_id.setText(null);
		 txt_remise.setText(null);
		 txt_prix.setText(null);
		 txt_quantite.setText(null);
	 }
    
    @FXML
    private Button back;
    
    @FXML
    private void rBack(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    	
    }
       
    ObservableList<produits> listM;
    ObservableList<produits> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     
    public void Add_users (){
    	String code =txt_code_produit.getText().toString();
        String nom = txt_deseignation.getText().toString();
        int qclient = Integer.parseInt(txt_quantite_pour_client.getText().toString());
        String fr = txt_fournisseur.getText().toString();
        int rm = Integer.parseInt(txt_remise.getText().toString());
        int pr = Integer.parseInt(txt_prix.getText().toString());
        int qn = Integer.parseInt(txt_quantite.getText().toString());
        conn = mysqlconnect.ConnectDb();
        String sql = "INSERT INTO produit VALUES (null,'"+code+"','"+nom+"','"+qclient+"','"+fr+"','"+rm+"','"+pr+"','"+qn+"');";
        try {
        	/*
        	 * Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			if (password.contentEquals(confirmPassword)) {
				String sql= "INSERT INTO `utilisateur`(`id`, `username`, `password`, `email`, `type`) VALUES (null,'"+nom+"','"+password+"','"+email+"','"+etat+"');";
//				st.executeUpdate(sql);
				
        	 * */
        	Statement st = conn.createStatement();
        	st.executeUpdate(sql);
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, txt_code_produit.getText());
//            pst.setString(2, txt_deseignation.getText());
//            pst.setString(3, txt_quantite_pour_client.getText());
//            pst.setString(4, txt_fournisseur.getText());
//            pst.setString(5, txt_remise.getText());
//            pst.setString(6, txt_prix.getText());
//            pst.setString(7, txt_quantite.getText());
//            pst.execute();
            
//            JOptionPane.showMessageDialog(null, "Produits  Add succes");
            infoBox("La produit est bien Ajouté","Success",null);
            UpdateTable();
            search_user();
            clearFields();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("La produit n'est pas Ajouté par ce que  "+e,"Failed",null);
        }
    }
    

    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
    index = table_produits.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    txt_id.setText(col_id.getCellData(index).toString());
    txt_code_produit.setText(col_code_produit.getCellData(index).toString());
    txt_deseignation.setText(col_deseignation.getCellData(index).toString());
    txt_quantite_pour_client.setText(col_quantite_pour_client.getCellData(index).toString());
    txt_fournisseur.setText(col_fournisseur.getCellData(index).toString());
    txt_remise.setText(col_remise.getCellData(index).toString());
    txt_prix.setText(col_prix.getCellData(index).toString());
    txt_quantite.setText(col_quantite.getCellData(index).toString());
//    
    }
//
    public void Edit (){   //`username`, `password`, `email`, `type`
        try {
        	/*
        	 * pst.setString(1, txt_code_produit.getText());
            pst.setString(2, txt_deseignation.getText());
            pst.setString(3, txt_quantite_pour_client.getText());
            pst.setString(4, txt_fournisseur.getText());
            pst.setString(5, txt_remise.getText());
            pst.setString(6, txt_prix.getText());
            pst.setString(7, txt_quantite.getText());
        	 * */
            conn = mysqlconnect.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_code_produit.getText();
            String value3 = txt_deseignation.getText();
            int value4 = Integer.parseInt(txt_quantite_pour_client.getText());
            String value5 = txt_fournisseur.getText();
            int value6 = Integer.parseInt(txt_remise.getText());
            int value7 = Integer.parseInt(txt_prix.getText());
            int value8 = Integer.parseInt(txt_quantite.getText());
            
            //code_produit,deseignation,quantite_pour_client,fournisseur,remise,prix,quantite
            
            String sql = "update produit set code_produit= '"+value2+"',deseignation= '"+
                    value3+"',quantite_pour_client= '"+value4+"',fournisseur= '"+value5+"',remise= '"+value6+"',prix= '"+value7+"',quantite= '"+value8+"' where id='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Update");
            infoBox("La produit est bien Modifié","Success",null);
            UpdateTable();
            search_user();
            clearFields();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("La produit n'est pas Modifié par ce que  "+e,"Failed",null);
        }
//        
    }
//    
    public void Delete(){
    conn = mysqlconnect.ConnectDb();
    String sql = "delete from produit where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Delete");
            infoBox("La produit est bien Supprimé","Success",null);
            UpdateTable();
            search_user();
            clearFields();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            infoBox("La produit n'est pas Supprimé par ce que  "+e,"Failed",null);
        }	    
    }

    
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<produits,Integer>("id"));
        col_code_produit.setCellValueFactory(new PropertyValueFactory<produits,String>("code_produit"));
        col_deseignation.setCellValueFactory(new PropertyValueFactory<produits,String>("deseignation"));
        col_quantite_pour_client.setCellValueFactory(new PropertyValueFactory<produits,Integer>("quantite_pour_client"));
        col_fournisseur.setCellValueFactory(new PropertyValueFactory<produits,String>("fournisseur"));
        col_remise.setCellValueFactory(new PropertyValueFactory<produits,Integer>("remise"));
        col_prix.setCellValueFactory(new PropertyValueFactory<produits,Integer>("prix"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<produits,Integer>("quantite"));
        
        listM = mysqlconnect.getDatausers();
        table_produits.setItems(listM);
    }
    
    

//    
 @FXML
    void search_user() {          
        col_id.setCellValueFactory(new PropertyValueFactory<produits,Integer>("id"));
        col_code_produit.setCellValueFactory(new PropertyValueFactory<produits,String>("code_produit"));
        col_quantite_pour_client.setCellValueFactory(new PropertyValueFactory<produits,Integer>("quantite_pour_client"));
        col_fournisseur.setCellValueFactory(new PropertyValueFactory<produits,String>("fournisseur"));
        col_remise.setCellValueFactory(new PropertyValueFactory<produits,Integer>("remise"));
        col_prix.setCellValueFactory(new PropertyValueFactory<produits,Integer>("prix"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<produits,Integer>("quantite"));
        
        dataList = mysqlconnect.getDatausers();
        table_produits.setItems(dataList);
        FilteredList<produits> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getDeseignation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches nom ou designation
    } else if (person.getCode_produit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches code
    }else if (person.getFournisseur().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches fournisseur
    }
    else if (String.valueOf(person.getId()).indexOf(lowerCaseFilter)!=-1)
         return true;// Filter matches id
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<produits> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_produits.comparatorProperty());  
  table_produits.setItems(sortedData);      
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
		 UpdateTable();
		 search_user();
		
	}

}
