package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.AdminController;
import controllers.CustomerController;
import controllers.UserController;
import dao.DBConnect;

public class LoginModel extends DBConnect {
 
	private Boolean admin;
 
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public UserController getCredentials(String email, String password){
			UserController user;
        	String query = "SELECT * FROM userlnt WHERE username = ? and password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, email);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
                if(rs.next()) { 
                	if (rs.getBoolean("admin")) {
                		user = new AdminController(rs.getInt("id"), email, password);
                	}
                	else {
                		user = new CustomerController(rs.getInt("id"), email, password);
                	}
                	return user;
                }
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
			return null;
    }

}//end class