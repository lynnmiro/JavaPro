package controllers;

public abstract class UserController {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	protected UserController(int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
}
