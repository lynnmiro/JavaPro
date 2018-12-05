package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class AdminController extends UserController {
	

	public AdminController(int id, String email, String password, boolean c) {
		super(id, email, password);
		// TODO Auto-generated constructor stub
	}
	static int user_id;




//	public void gototables () {
	
	public static void setUser(int user_id){
	    AdminController.user_id = user_id;
	}
	
//

	public void gototables() {

		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/TableView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Table View");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}
	public void logout() {
		System.exit(0);
		try {
		    AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
}
