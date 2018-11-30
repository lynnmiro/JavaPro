package models;

import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;

public class DaoModel {
	
	//Declare DB objects 
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public DaoModel() { //create db object instance
	 conn = new DBConnect();
	}
	// CREATE TABLE METHOD
	// CREATE TABLE METHOD
	public void createTable() {
	 try {

	 // Open a connection
	 System.out.println("Connecting to database to create Table...");
	 System.out.println("Connected database successfully...");

	 // Execute create query
	 System.out.println("Creating table in given database...");

	 stmt = conn.connect().createStatement();

		 String sql = "CREATE TABLE fplnt " + 
		              "(pid INTEGER not NULL AUTO_INCREMENT, " + 
		  	        " id VARCHAR(10), " +
				  " income numeric(8,2), " + 
				  " pep VARCHAR(3), " + 
			  " PRIMARY KEY ( pid ))";
	 stmt.executeUpdate(sql);
	 System.out.println("Created table in given database...");
	 conn.connect().close(); //close db connection 
	}catch (SQLException se) { // Handle errors for JDBC
	 se.printStackTrace();
	}
	}
	
}
//close db connection 
