package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect  {

	protected Connection connection;
	private static String url = "jdbc:mysql://www.papademas.net:3307/fp510";
	private static String username = "fpuser";
	private static String password = "510";

	public Connection connect() throws SQLException {


		 return DriverManager.getConnection(url, username, password);


		}
		

		public PreparedStatement prepareStatement(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return connect().prepareStatement(sql);
		}
}





