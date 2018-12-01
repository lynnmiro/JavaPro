package controllers;

import java.time.LocalDateTime;

public class ReservationController {
	private int id;
	private int resturantid;
	private int customerid;
	private int tableid;
	private LocalDateTime dateTime;
	private int numOfGuests;
	
	public Reservation(int id, int resturantid, int customerid, int tableid, LocalDateTime dateTime, int numOfGuests) {
		super();
		this.id = id;
		this.resturantid = resturantid;
		this.customerid = customerid;
		this.tableid = tableid;
		this.dateTime = dateTime;
		this.numOfGuests = numOfGuests;
	}	
}
