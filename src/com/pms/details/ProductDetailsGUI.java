package com.pms.details;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pms.client.ProductClientGUI;
import com.pms.daoImpl.ProductDaoImpl;
import com.pms.pojo.Product;
import com.pms.pojo.TableDisplay;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductDetailsGUI{
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	ProductCrudGUI addUserGUI = new ProductCrudGUI();	

    public Stage primaryStage;
	
	public void productDetails(){
		// TODO Auto-generated method stub
		primaryStage = new Stage();

		// Create a VBox layout
        VBox vbox = new VBox();
        
        // Create a heading label
        Label heading = new Label("Manage Product");
        heading.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #007bff;");
        
        // Create two buttons
        Button button1 = new Button("Add Product");
        Button button2 = new Button("View All Products");
        Button button3 = new Button("View Product ");
        Button button4 = new Button("Update Product");
        Button button5 = new Button("Delete Product");
        Button button6 = new Button("Return to Main Menu");

        
        // Apply some CSS styling to the buttons
        button1.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button2.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button3.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button4.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button5.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button6.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 20;");
        
        // Add event handlers to the buttons
        button1.setOnAction(e -> addUserGUI.addProductGUI());
        button2.setOnAction(e -> addUserGUI.viewAllProductGUI());
        button3.setOnAction(e -> addUserGUI.viewProductByIDGUI());
        button6.setOnAction(e -> primaryStage.close());

        
        // Add heading and buttons to the VBox layout
        vbox.getChildren().addAll(heading, button1, button2, button3, button4, button5,button6);
        
        // Apply some CSS styling to the layout
        vbox.setStyle("-fx-background-color: white; -fx-padding: 20;");
        vbox.setSpacing(20);
        vbox.setPrefWidth(500);
        vbox.setPrefHeight(650);
        
        // Set a margin on the second button to create space
        VBox.setMargin(button6, new Insets(10, 0, 0, 0));
        
        // Create a Scene with the VBox layout
        Scene scene = new Scene(vbox);
        
        // Set the title of the window to "Product Management System"
        primaryStage.setTitle("Manage Product");
        
        // Set the Scene of the window
        primaryStage.setScene(scene);
        
        // Show the window
        primaryStage.show();
   	}
	
}
