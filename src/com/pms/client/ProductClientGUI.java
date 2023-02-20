
package com.pms.client;

import com.pms.details.ProductDetails;
import com.pms.details.ProductDetailsGUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProductClientGUI extends Application {
	ProductDetailsGUI productDetailsGui = new ProductDetailsGUI();
private static final int INACTIVITY_TIMEOUT = 5 * 60 * 1000; // 5 minutes in milliseconds
    
    private long lastInteractionTime;

    @Override
    public void start(Stage stage) {
        // Create a VBox layout
        VBox vbox = new VBox();
        
        // Create a heading label
        Label heading = new Label("Welcome to Product Management System");
        heading.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #007bff;");
        
        // Create two buttons
        Button button1 = new Button("Manage Product");
        Button button2 = new Button("Exit");
        
        // Apply some CSS styling to the buttons
        button1.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 20;");
        button2.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 20;");
        
        // Add event handlers to the buttons
        button1.setOnAction(e -> productDetailsGui.productDetails());
        button2.setOnAction(e -> System.exit(0));
        
        // Add heading and buttons to the VBox layout
        vbox.getChildren().addAll(heading, button1, button2);
        
        // Apply some CSS styling to the layout
        vbox.setStyle("-fx-background-color: white; -fx-padding: 20;");
        vbox.setSpacing(20);
        vbox.setPrefWidth(500);
        vbox.setPrefHeight(650);
        
        // Set a margin on the second button to create space
        VBox.setMargin(button2, new Insets(10, 0, 0, 0));
        
        // Create a Scene with the VBox layout
        Scene scene = new Scene(vbox);
        
        // Set the title of the window to "Product Management System"
        stage.setTitle("Product Management System");
        
        
        scene.setOnMouseMoved(e -> {
            // Update last interaction time on mouse movement
            lastInteractionTime = System.currentTimeMillis();
        });
        
        scene.setOnKeyTyped(e -> {
            // Update last interaction time on key press
            lastInteractionTime = System.currentTimeMillis();
        });
        
        // Create a timeline that checks for inactivity every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
            if (System.currentTimeMillis() - lastInteractionTime > INACTIVITY_TIMEOUT) {
                // Inactivity timeout exceeded, shut down the app
                Platform.exit();
            }
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        // Set the Scene of the window
        stage.setScene(scene);
        
        // Show the window
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

