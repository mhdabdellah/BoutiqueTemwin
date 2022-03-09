package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//import javax.imageio.ImageIO;

//-------------------------------------
//import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


import java.io.ByteArrayOutputStream;
//-------------------------------------
//import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
//import javafx.stage.Stage;
import application.client.*;


public class ClientController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
    

    @FXML
    private TableView<client> table_users;

    @FXML
    private TableColumn<client, Integer> col_id;
    
    @FXML
    private TableColumn<client, String> col_username;

    @FXML
    private TableColumn<client, String> col_lastname;

    @FXML
    private TableColumn<client, String> col_nni;

    @FXML
    private TableColumn<client, String> col_qrcode;
    
     @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_lastname;

    @FXML
    private TextField txt_nni;

    @FXML
    private TextField txt_qrcode;
        
    @FXML
    private TextField txt_id;
     
    @FXML
    private TextField filterField;
    
    public void clearFields() {
    	txt_username.setText(null);
    	txt_lastname.setText(null);
    	txt_nni.setText(null);
    	txt_qrcode.setText(null);
		txt_id.setText(null);
	 }
    @FXML
    private AnchorPane carte;
    
    @FXML
    private Text cartnom;
    
    @FXML
    private Text cartprenom;
    
    @FXML
    private Text cartnni;
    
    
    @FXML
    private Text cartid;
    
    @FXML
    private ImageView cartimage;
    
   
    public String generateQr(String nni) throws Exception {
		
		ByteArrayOutputStream out = QRCode.from(nni).to(ImageType.PNG).withSize(200, 200).stream();
    	File f = new File("C:\\javafx-sdk\\mysqlConnector\\"+nni+".png");
    	fos = new FileOutputStream(f);
    	fos.write(out.toByteArray());
    	fos.flush();
    	URL uri =f.toURI().toURL();
    	return uri.toString();
    	
    	
		
	}
    
    @FXML
    private void imprimer(ActionEvent event) {
    	Printer printer = Printer.getDefaultPrinter();
    	PageLayout pageLayout = printer.createPageLayout(Paper.A6,PageOrientation.PORTRAIT,Printer.MarginType.DEFAULT);
    	PrinterJob job= PrinterJob.createPrinterJob();
    	
    	if(job!= null) {
    		boolean success = job.printPage(carte);
    		if(success) {
    			job.endJob();
    		}
    	}
    }
    
    @FXML
    private void generer(ActionEvent event) {
    	
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
       
    ObservableList<client> listM;
    ObservableList<client> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	private FileOutputStream fos;
	
	
	
    
     
    public void Add_users (){    
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into client(username,lastname,nni,qrcode,qrimage) values (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_lastname.getText());
            pst.setString(3, txt_nni.getText());
            pst.setString(4, txt_nni.getText());
            pst.setString(5,generateQr(txt_nni.getText()));
            pst.execute();

//            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search_user();
            clearFields();
            infoBox("Le client est bien Ajouté".toString(),"Success",null);
            
        } 
        catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le client n'est pas Ajouté par ce  que  "+e,"Failed",null);
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
    cartid.setText("N°: "+col_id.getCellData(index).toString());
    txt_username.setText(col_username.getCellData(index).toString());
    txt_lastname.setText(col_lastname.getCellData(index).toString());
    txt_nni.setText(col_nni.getCellData(index).toString());
    txt_qrcode.setText(col_qrcode.getCellData(index).toString());
    cartnom.setText(col_username.getCellData(index).toString());
    cartprenom.setText(col_lastname.getCellData(index).toString());
    cartnni.setText(col_nni.getCellData(index).toString());
//    cartqrcode.setText(col_qrcode.getCellData(index).toString());
    conn = mysqlconnect.ConnectDb();
    String sql = "select qrimage from client where id ="+txt_id.getText();
    PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
	    Image im = new Image(rs.getString("qrimage"));
	    cartimage.setImage(im);
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		infoBox(""+txt_id.getText()+e,"Failed",null);	}

    
    }

    public void Edit (){   //`username`, `password`, `email`, `type`
        try {
            conn = mysqlconnect.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_username.getText();
            String value3 = txt_lastname.getText();
            String value4 = txt_nni.getText();
            String value5 = txt_qrcode.getText();
            String value6 = generateQr(txt_nni.getText());
            
            String sql = "update client set username= '"+value2+"',lastname= '"+
                    value3+"',nni= '"+value4+"',qrcode= '"+value5+"',qrimage= '"+value6+"'where id='"+value1+"'";
            pst= conn.prepareStatement(sql);
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_user();
            clearFields();
            infoBox("Le client est bien Modifié","Success",null);
            
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le client n'est pas Modifié par ce que  "+e,"Failed",null);
        }
        
    }
    
    public void Delete(){
    conn = mysqlconnect.ConnectDb();
    String sql = "delete from client where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Delete");
            infoBox("Le client est bien Supprimé","Success",null);
            UpdateTable();
            search_user();
            clearFields();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        	infoBox("Le client n'est pas Supprimé par ce que  "+e,"Failed",null);
        }
    
    }

    
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<client,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<client,String>("username"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<client,String>("lastname"));
        col_nni.setCellValueFactory(new PropertyValueFactory<client,String>("nni"));
        col_qrcode.setCellValueFactory(new PropertyValueFactory<client,String>("qrcode"));
       
        
        listM = mysqlconnect.getDatausers();
        table_users.setItems(listM);
    }
    
    

    
 @FXML
    void search_user() {          
        col_id.setCellValueFactory(new PropertyValueFactory<client,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<client,String>("username"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<client,String>("lastname"));
        col_nni.setCellValueFactory(new PropertyValueFactory<client,String>("nni"));
        col_qrcode.setCellValueFactory(new PropertyValueFactory<client,String>("qrcode"));
        
        
        dataList = mysqlconnect.getDatausers();
        table_users.setItems(dataList);
        FilteredList<client> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches lastname
    }else if (person.getNni().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches nni
    }
    else if (String.valueOf(person.getQrcode()).indexOf(lowerCaseFilter)!=-1)
         return true;// Filter matches qrcode
                                
         else  
                  return false; // Does not match.
   });
  });  
  SortedList<client> sortedData = new SortedList<>(filteredData);  
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
