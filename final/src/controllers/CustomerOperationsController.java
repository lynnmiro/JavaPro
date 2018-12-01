package controllers;
public interface CustomerOperationsController {
	
	void makeReservation();
	void viewReservation(int reservationId);
	void updateReservation(int reservationId);
	void deleteReservation(int reservationId);

}
