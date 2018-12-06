package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;
import controllers.UserController;

public class LoginController {

	
	@FXML
	private TextField txtUsername;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Label lblError;

	private LoginModel model;
	
	public LoginController() {
		model = new LoginModel();

	}
	
	public void login() {
		String username = this.txtUsername.getText();
		String password = this.txtPassword.getText();

		// Validations
		
		if (username == null || username.trim().equals("") && 
				   (password == null || password.trim().equals(""))) {
					lblError.setText("User name / password Cannot be empty or spaces");
					return;
				}
		
		if (username == null || username.trim().equals("")) {
			lblError.setText("Username cannot be empty or spaces");
			return;

		}
		if (password == null || password.trim().equals("")) {
			lblError.setText("Password cannot be empty or spaces");
			return;
		}
		
		// authentication check
		checkCredentials(username, password);
	}

	public void checkCredentials(String username, String password) {
		
		UserController user = model.getCredentials(username, password);
		if (user == null) {
			lblError.setText("User does not exist!");
			return;
		}
		try {
			AnchorPane root;
			//check if instance of user is admin controller or else (customer class) and assigned 
			
			
			if (user.getClass() == AdminController.class) {
				
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
				Main.stage.setTitle("Admin View");
				System.out.println("we are here");
			}
			else {
				// If user is customer, inflate customer view
	
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/CustomerView.fxml"));
	
				Main.stage.setTitle("Customer View");

			}

			Scene scene = new Scene(root);
			Main.stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
			throw new RuntimeException(e);
		}

	}
}
	