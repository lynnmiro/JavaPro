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
	
	public UserController getCredentials(String username, String password){
			UserController user;
        	String query = "SELECT * FROM userlnt WHERE username = ? and password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
                if(rs.next()) { 
                	//if(password.equals(rs.getString("password")) && username.equals(rs.getString("username"))) {
                	if (rs.getBoolean("admin")) {
                		user = new AdminController(rs.getInt("id"), username, password, true);
                	}
                	else {
                		user = new CustomerController(rs.getInt("id"), username, password);
                	}
                	//setAdmin(rs.getBoolean("admin"));
                	return user;
                	
                	//}
                }
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
			return null;
    }

}//end class