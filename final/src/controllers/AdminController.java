package controllers;

public class AdminController extends UserController implements AdminOperationsControllers{
	Boolean admin;
	
	public AdminController(int id, String email, String password, boolean isAdmin) {
		super(id, email, password);
		this.admin = isAdmin;
		
	}
	public void isAdminController() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void addRestaurant() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}

}
