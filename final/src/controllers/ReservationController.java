package controllers;

import java.time.LocalDateTime;

public class ReservationController {
	private int id;
	private int restaurantID;
	private int reservationID;
	private int customerid;
	private int tableid;
	private LocalDateTime dateTime;
	private int numOfGuests;
	
	public ReservationController(int id, int resturantid, int customerid, int tableid, LocalDateTime dateTime, int numOfGuests) {
		super();
		this.id = id;
		this.reservationID = reservationID;
		this.customerid = customerid;
		this.tableid = tableid;
		this.dateTime = dateTime;
		this.numOfGuests = numOfGuests;
	}	
}
