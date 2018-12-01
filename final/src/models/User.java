package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import dao.DBConnect;

public class User extends DBConnect {

	String userID;
	String userFN;
	String userLN;
	String userRole;
	String email;
	String password;

	// Default Constructor
	public User() {

	}

	public User(String userId) {
		this.userID = userId;
		// TODO
	}

	public User getUser(String userId) {
		User user = new User();
		String query = "SELECT * FROM lnt_user WHERE userID = ?;";
		Connection c = null;
		PreparedStatement statement = null;
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// grab record data by table field name into CustomerModel account object
				user.setUserFN(resultSet.getString("userFN"));
				user.setUserLN(resultSet.getString("userLN"));
				user.setUserRole(resultSet.getString("userLN"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
			System.out.println("Mi");
			statement.close();
			c.close();
		} catch (

		SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
		return user;
	}

	public void addUser(String userId, String userFN, String userLN, String userRole, String email, String password) {
		String query = "INSERT INTO lnt_user (userID, userFN, userLN, userRole, email, password)"
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		
		Connection c = null;
		PreparedStatement statement = null;
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, userFN);
			statement.setString(3, userLN);
			statement.setString(4, userRole);
			statement.setString(5, email);
			statement.setString(6, password);

			int r = statement.executeUpdate();

			statement.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
	}

	public void updateUserPassword(String userId, String password) {
		String query = "UPDATE lnt_user SET password = ? WHERE userID = ?;";
		Connection c = null;
		PreparedStatement statement = null;
	
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setString(1, password);
			statement.setString(2, userId);

			int r = statement.executeUpdate();

			statement.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}

	}

	public void deleteUser(String userId) {
		String query = "DELETE FROM lnt_user WHERE userID = ?;";

		Connection c = null;
		PreparedStatement statement = null;
	
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setString(1, userId);
			
			int r = statement.executeUpdate();

			statement.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}

	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the userFN
	 */
	public String getUserFN() {
		return userFN;
	}

	/**
	 * @param userFN the userFN to set
	 */
	public void setUserFN(String userFN) {
		this.userFN = userFN;
	}

	/**
	 * @return the userLN
	 */
	public String getUserLN() {
		return userLN;
	}

	/**
	 * @param userLN the userLN to set
	 */
	public void setUserLN(String userLN) {
		this.userLN = userLN;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
