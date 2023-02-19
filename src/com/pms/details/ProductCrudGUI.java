package com.pms.details;

import com.pms.daoImpl.ProductDaoImpl;
import com.pms.pojo.Product;
import com.pms.pojo.TableDisplay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductCrudGUI{
	ProductDaoImpl productDaoImpl1 = new ProductDaoImpl();
	public Stage secondStage;
	public Stage thirdStage;
	public Stage fourthStage;


	public void addProductGUI() {
		secondStage = new Stage();
		// Create a VBox layout
        VBox vbox1 = new VBox();
        
        
        // Create a heading label
        Label heading = new Label("Add Products");
        heading.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #007bff;");

        
        Label productID = new Label("Enter Product ID:");
        TextField titleField1 = new TextField();
        
        Label productName = new Label("Enter Product Name:");
        TextField titleField2 = new TextField();
        
        Label productQuantity = new Label("Enter Product Quantity:");
        TextField titleField3 = new TextField();
        
        Label productPrice = new Label("Enter Product Price:");
        TextField titleField4 = new TextField();
        
        
        // Create a button for submitting the product details
        Button submitButton = new Button("Submit");          
        submitButton.setOnAction(event -> {
            try {
                // Code that might throw an exception
            	  // Get the values entered in the form fields
                int productID1 = Integer.parseInt(titleField1.getText());
                String productName1 = titleField2.getText();
                int productQuantity1 = Integer.parseInt(titleField3.getText());
                int productPrice1 = Integer.parseInt(titleField4.getText());
                
                //saving value to object
                productDaoImpl1.addProduct(productID1,productName1,productQuantity1,productPrice1);
                                  
                // Clear the form fields
                titleField1.clear();
                titleField2.clear();
                titleField3.clear();
                titleField4.clear();
            } catch (Exception e) {
                // Create an Alert dialog to display the error message
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Add Product Failed Please Try Again !!");
                alert.setContentText(e.getMessage());

                // Show the Alert dialog
                alert.showAndWait();
            }
        });
        
        Button backButton = new Button("Go back");
        backButton.setOnAction(e2 -> secondStage.close());
        
        // Add the form elements to the layout
        vbox1.getChildren().addAll(heading,productID, titleField1, productName, titleField2, productQuantity, titleField3,productPrice, titleField4,submitButton,backButton);
        vbox1.setPadding(new Insets(20));
        vbox1.setStyle("-fx-background-color: white; -fx-padding: 20;");
        vbox1.setSpacing(20);
        vbox1.setPrefWidth(500);
        vbox1.setPrefHeight(650);
        
        
        // Create a Scene with the VBox layout
        Scene scene1 = new Scene(vbox1);
        
        // Set the title of the window to "Product Management System"
        secondStage.setTitle("Add Product Page");
        
        // Set the Scene of the window
        secondStage.setScene(scene1);
        
        // Show the window
        secondStage.show();     
	}
	
	public void viewAllProductGUI() {
		thirdStage = new Stage();
		// Create a VBox layout
        VBox vbox1 = new VBox();
        
        
        // Create a heading label
        Label heading = new Label("View All Products");
        heading.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #007bff;");

        // Create some sample data
        ObservableList<TableDisplay> rows = FXCollections.observableArrayList();

        for(Product p:productDaoImpl1.viewAllProduct()) {
     		String value1=String.valueOf(p.getPid());
        	String value2=p.getPname();
			String value3=String.valueOf(p.getPrice());
			String value4=String.valueOf(p.getQty());
            rows.add(new TableDisplay(value1, value2, value3, value4));
		}	
   
        // Create table columns
        TableColumn<TableDisplay, String> column1 = new TableColumn<>("Product Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("column1"));
        TableColumn<TableDisplay, String> column2 = new TableColumn<>("Product Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("column2"));
        TableColumn<TableDisplay, String> column3 = new TableColumn<>("Quantity");
        column3.setCellValueFactory(new PropertyValueFactory<>("column3"));
        TableColumn<TableDisplay, String> column4 = new TableColumn<>("Price");
        column4.setCellValueFactory(new PropertyValueFactory<>("column4"));

        // Create a table view and set the data
        TableView<TableDisplay> tableView = new TableView<>();
        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.setItems(rows);


        Button backButton = new Button("Go back");
        backButton.setOnAction(e2 -> thirdStage.close());
        
        
        // Add the form elements to the layout
        vbox1.getChildren().addAll(heading,backButton,tableView);
        vbox1.setPadding(new Insets(20));
        vbox1.setStyle("-fx-background-color: white; -fx-padding: 20;");
        vbox1.setSpacing(20);
        vbox1.setPrefWidth(500);
        vbox1.setPrefHeight(650);
        
        
        // Create a Scene with the VBox layout
        Scene scene1 = new Scene(vbox1);
        
        // Set the title of the window to "Product Management System"
        thirdStage.setTitle("View All Product");
        
        // Set the Scene of the window
        thirdStage.setScene(scene1);
        
        // Show the window
        thirdStage.show();     
	}
	
	public void viewProductByIDGUI() {
		fourthStage = new Stage();
		// Create a VBox layout
        VBox vbox1 = new VBox();
        
        
        // Create a heading label
        Label heading = new Label("View Product By ID");
        heading.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #007bff;");
        
        Label productID1 = new Label("Enter Product Price:");
        TextField titleField1 = new TextField();
        
        
        // Create a button for submitting the product details
        Button submitButton = new Button("Submit");          
        submitButton.setOnAction(event -> {
            try {
                // Code that might throw an exception
            	  // Get the values entered in the form fields
                int productID = Integer.parseInt(titleField1.getText());
                
                //saving value to object
                                  
                // Clear the form fields
                titleField1.clear();
            } catch (Exception e) {
                // Create an Alert dialog to display the error message
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Add Product Failed Please Try Again !!");
                alert.setContentText(e.getMessage());

                // Show the Alert dialog
                alert.showAndWait();
            }
        });
        
        Button backButton = new Button("Go back");
        backButton.setOnAction(e2 -> fourthStage.close());

        // Create some sample data
        ObservableList<TableDisplay> rows = FXCollections.observableArrayList();

        for(Product p:productDaoImpl1.viewAllProduct()) {
     		String value1=String.valueOf(p.getPid());
        	String value2=p.getPname();
			String value3=String.valueOf(p.getPrice());
			String value4=String.valueOf(p.getQty());
            rows.add(new TableDisplay(value1, value2, value3, value4));
		}	
   
        // Create table columns
        TableColumn<TableDisplay, String> column1 = new TableColumn<>("Product Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("column1"));
        TableColumn<TableDisplay, String> column2 = new TableColumn<>("Product Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("column2"));
        TableColumn<TableDisplay, String> column3 = new TableColumn<>("Quantity");
        column3.setCellValueFactory(new PropertyValueFactory<>("column3"));
        TableColumn<TableDisplay, String> column4 = new TableColumn<>("Price");
        column4.setCellValueFactory(new PropertyValueFactory<>("column4"));

        // Create a table view and set the data
        TableView<TableDisplay> tableView = new TableView<>();
        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.setItems(rows);

        
        // Add the form elements to the layout
        vbox1.getChildren().addAll(heading,productID1,titleField1,submitButton,backButton,tableView);
        vbox1.setPadding(new Insets(20));
        vbox1.setStyle("-fx-background-color: white; -fx-padding: 20;");
        vbox1.setSpacing(20);
        vbox1.setPrefWidth(500);
        vbox1.setPrefHeight(650);
        
        
        // Create a Scene with the VBox layout
        Scene scene1 = new Scene(vbox1);
        
        // Set the title of the window to "Product Management System"
        fourthStage.setTitle("View Product By ID");
        
        // Set the Scene of the window
        fourthStage.setScene(scene1);
        
        // Show the window
        fourthStage.show();     
	}

}