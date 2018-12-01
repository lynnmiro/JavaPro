package controllers;

public class CustomerController extends UserController implements CustomerOperationsController {
	
	private String phoneNum;

	public CustomerController(int id, String firstName, String lastName, String email, String password, String phoneNum) {
		super(id, firstName, lastName, email, password);
		this.phoneNum = phoneNum;
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
