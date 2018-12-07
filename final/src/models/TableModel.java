package models;

import dao.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableModel extends DBConnect {

	int tableID;
	int capacity;
	int restaurantID;

	// Default Constructor
	public TableModel() {

	}

	public TableModel(int tableID, int capacity, int restaurantID) {
		this.tableID = tableID;
		this.capacity = capacity;
		this.restaurantID = restaurantID;
	}

	// Fetching Table Information
	public TableModel getTable(int tableID) {
		TableModel table = new TableModel();
		String query = "SELECT * FROM lnt_table WHERE tableID = ?;";
		Connection c = null;
		PreparedStatement statement = null;
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setInt(1, tableID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				table.setCapacity(resultSet.getInt("capacity"));
				table.setRestaurantID(resultSet.getInt("restaurantID"));

			}

			statement.close();
			c.close();
		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
		return table;
	}

	
	//adding new records to lnt_table 
	public Boolean addTable(int tableID, int capacity, int restaurantID) {

		String query = "INSERT INTO lnt_table(tableID, capacity, restaurantID) VALUES (?,?,?);";

		Connection c = null;
		PreparedStatement statement = null;
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setInt(1, tableID);
			statement.setInt(2, capacity);
			statement.setInt(3, restaurantID);
			
			int r = statement.executeUpdate();


			statement.close();
			c.close();

			statement.close();
			c.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
			return false;
		}
	}
	
//	Update
	public Boolean updateTableCapacity(int tableID, int capacity) {
		String query = "UPDATE lnt_table SET capacity = ? WHERE tableID = ?;";
		Connection c = null;
		PreparedStatement statement = null;
	
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setInt(1, capacity);
			statement.setInt(2, tableID);

			int r = statement.executeUpdate();

			statement.close();
			c.close();
			return true;

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
			return false;
		}

	}

	public boolean deleteTable(int tableID) {
		String query = "DELETE FROM lnt_table WHERE tableID = ?;";

		Connection c = null;
		PreparedStatement statement = null;
	
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setInt(1, tableID);
			
			int r = statement.executeUpdate();

			statement.close();
			c.close();
			return true;

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
			return false;
		}

	}
	/**
	 * @return the tableID
	 */
	public int getTableID() {
		return tableID;
	}

	/**
	 * @param tableID the tableID to set
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the restaurantID
	 */
	public int getRestaurantID() {
		return restaurantID;
	}

	/**
	 * @param restaurantID the restaurantID to set
	 */
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
}
