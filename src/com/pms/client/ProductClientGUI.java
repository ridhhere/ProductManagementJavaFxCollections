
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProductClientGUI extends Application {
	ProductDetailsGUI productDetailsGui = new ProductDetailsGUI();
	private static final int INACTIVITY_TIMEOUT = 5 * 60 * 1000; // 5 minutes in milliseconds

	private long lastInteractionTime;

	@Override
	public void start(Stage stage) {
		// Set the title of the window to "Product Management System"
		stage.setTitle("Product Management System");
		// Create a heading label
		Label heading = new Label("Login");
		heading.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #007bff;");

		VBox vbox1 = new VBox();

		Label usernameLabel = new Label("Username:");

		TextField usernameField = new TextField();

		Label passwordLabel = new Label("Password:");

		PasswordField passwordField = new PasswordField();

		Button loginButton = new Button("Login");

		Text errorText = new Text();
		errorText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
		errorText.setFill(Color.RED);

		loginButton.setOnAction(event -> {
			String username = usernameField.getText();
			String password = passwordField.getText();

			if (isValidUser(username, password)) {
				// user is authenticated, open the main application window
				// ...
				// Clear the form fields
				usernameField.clear();
				passwordField.clear();
				productDetailsGui.productDetails();
			} else {
				// show an error message
				errorText.setText("Invalid username or password.");
			}
		});
		// Add heading and buttons to the VBox layout
		vbox1.getChildren().addAll(heading, usernameLabel, usernameField, passwordLabel, passwordField, loginButton,
				errorText);

		// Apply some CSS styling to the layout
		vbox1.setStyle("-fx-background-color: white; -fx-padding: 20;");
		vbox1.setSpacing(20);
		vbox1.setPrefWidth(500);
		vbox1.setPrefHeight(650);
		Scene scene = new Scene(vbox1);

		// Set the Scene of the window
		stage.setScene(scene);

		// Show the window
		stage.show();
	}

	private boolean isValidUser(String username, String password) {
		// replace this with your authentication logic
		return username.equals("admin") && password.equals("admin123");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
