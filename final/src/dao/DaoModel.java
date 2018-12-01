package dao;

import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;

public class DaoModel {

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public DaoModel() { // create db object instance
		conn = new DBConnect();
	}

	// CREATE TABLE METHOD
	public void createTable() {

		// Open a connection
		System.out.println("Connecting to database to create Table...");

		try {
			stmt = conn.connect().createStatement();
			System.out.println("Connected database successfully...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String usertableCreate = "CREATE TABLE LNT_User" + "(userID VARCHAR(20) PRIMARY KEY," + "userFN varchar (20),"
				+ "userLN varchar (20)," + "userRole varchar (20)," + "email varchar (20)," + "password varchar (20))";

		String restauranttableCreate = "CREATE TABLE LNT_restaurant" + "(restaurantID int PRIMARY KEY, "
				+ " restaurantName varchar (50)," + " discription varchar (200)," + "menu varchar (50),"
				+ " restaurantType varchar (50)," + " phoneNumber int," + " address varchar (100))";

		String tabletableCreate = "CREATE TABLE LNT_table" + "(tableID int PRIMARY KEY, " + " capacity int,"
				+ " restaurantID int," + "FOREIGN KEY (restaurantID) references LNT_restaurant(restaurantID))";

		String reservationtableCreate = "CREATE TABLE LNT_reservation (reservationID int PRIMARY KEY,"
				+ "restaurantID int, userID VARCHAR(20), tableID int, localDateTime varchar (50),"
				+ "restaurantType varchar (50), numberOfGuests int,"
				+ "FOREIGN KEY (restaurantID) references LNT_restaurant(restaurantID),"
				+ "FOREIGN KEY (userID) references LNT_User(userID), FOREIGN KEY (tableID) references LNT_table(tableID))";

		try {
			// Creating USER table
			System.out.println("Creating USER table in given database...");
			stmt.executeUpdate(usertableCreate);
			System.out.println("USER table created.");

			// Creating RESTAURANT table
			System.out.println("Creating RESTAURANT table in given database...");
			stmt.executeUpdate(restauranttableCreate);
			System.out.println("RESTAURANT table created.");

			// Creating table table
			System.out.println("Creating TABLE table in given database...");
			stmt.executeUpdate(tabletableCreate);
			System.out.println("Tables table created.");

			// Creating reservation table
			System.out.println("Creating Reservation table in given database...");
			stmt.executeUpdate(reservationtableCreate);
			System.out.println("Reservation table created.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("Four Tables are Created in the database");
		try {
			conn.connect().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
//close db connection 
