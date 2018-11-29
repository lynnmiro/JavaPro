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
	public void createTable() {
	

	 // Open a connection
	 System.out.println("Connecting to database to create Table...");
	 System.out.println("Connected database successfully...");

	 // Execute create query
	 System.out.println("Creating table in given database...");

	 try {
		stmt = conn.connect().createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		 String sql = "CREATE TABLE fp510LNT ";  
		        
	 try {
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 System.out.println("Created table in given database...");
	 try {
		conn.connect().close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	}
}
//close db connection 
