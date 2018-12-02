package controllers;

public abstract class UserController {
	
	private int id;
	private String email;
	private String password;
	
	protected UserController(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
