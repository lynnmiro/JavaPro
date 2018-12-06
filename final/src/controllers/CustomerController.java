package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class CustomerController extends UserController implements CustomerOperationsController {
	
	
	public CustomerController() {
		
	}
	
	private String phoneNum;

	public CustomerController(int id, String email, String password) {
		super(id, email, password);
	}

	@Override
	public void makeReservation() {
		// TODO Auto-generated method stub
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ReservationView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Reservation View");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
		
	}

	@Override
	public void viewReservation(int reservationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReservation(int reservationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReservation(int reservationId) {
		// TODO Auto-generated method stub
		
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
