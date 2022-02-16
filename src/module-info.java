module BoutiqueTemwin {
	requires javafx.controls;
	requires java.sql.rowset;
	requires java.base;
	requires java.management;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.testuser to javafx.graphics, javafx.fxml,javafx.base;
	opens application.produit to javafx.graphics, javafx.fxml,javafx.base;
}
