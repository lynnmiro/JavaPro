package controllers;

public class CustomerController extends UserController implements CustomerOperationsController {
	
	private String phoneNum;

	public CustomerController(int id, String email, String password) {
		super(id, email, password);
	}

	@Override
	public void makeReservation() {
		// TODO Auto-generated method stub
		
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

}
