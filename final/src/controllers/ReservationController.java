package controllers;

import java.time.LocalDateTime;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ReservationController {
	private int id;
	private int restaurantID;
	private int reservationID;
	private int customerid;
	private int tableid;
	private LocalDateTime dateTime;
	private int numOfGuests;
	
	public ReservationController() {
		
	}
	
	public ReservationController(int id, int resturantid, int customerid, int tableid, LocalDateTime dateTime, int numOfGuests) {
		super();
		this.id = id;
		this.reservationID = reservationID;
		this.customerid = customerid;
		this.tableid = tableid;
		this.dateTime = dateTime;
		this.numOfGuests = numOfGuests;
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
