package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import dao.DBConnect;

public class ReservationModel extends DBConnect {
	private int iD;
	private int resID;
	private int cusID;
	private int tabID;
	private LocalDateTime dTime;
	private int guestCt;
	
	public ReservationModel () {
		
	}
	public ReservationModel(int iD, int resID, int cusID, int tabID, LocalDateTime dTime, int guestCt)
	{
		this.setiD(iD);
		this.resID = resID;
		this.cusID = cusID;
		this.tabID = tabID;
		this.dTime = dTime;
		this.guestCt = guestCt;
	}
	public ReservationModel getReserve(int iD) {
		ReservationModel reserve = new ReservationModel();
		String query = "SELECT * FROM lnt_reservation WHERE iD = ?;";
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = connect();
			stmt = c.prepareStatement(query);
			stmt.setInt(1, iD);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				reserve.setResID(resultSet.getInt("reservationID"));
				reserve.setCusID(resultSet.getInt("userID"));
				reserve.setTabID(resultSet.getInt("tableID"));
				//reserve.setDTime(resultSet.geLocalDateTime("dTime"));
				reserve.setGuestCt(resultSet.getInt("numberOfGuests"));

			}
			stmt.close();
			c.close();
	}
		catch (SQLException e) {
			System.out.println("Error fetching accounts" + e);
		}
		return reserve;
		
}
	
	public void updateReserve(int iD, int resID, int cusID, int tabID, short dTime, int guestCt) {
		String query = "INSERT INTO lnt_reservation (iD, reservationID, userID, tableID, dTime, numberOfGuests)"
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = connect();
			stmt = c.prepareStatement(query);
			stmt.setInt(1, iD);
			stmt.setInt(2, resID);
			stmt.setInt(3, cusID);
			stmt.setInt(4, tabID);
			stmt.setShort(5, dTime);
			stmt.setInt(6, guestCt);

			int r = stmt.executeUpdate();

			stmt.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
	}
	public void deleteReserve(int iD) {
		String query = "DELETE FROM lnt_reservation WHERE iD = ?;";

		Connection c = null;
		PreparedStatement statement = null;
	
		try {
			c = connect();
			statement = c.prepareStatement(query);
			statement.setInt(1, iD);
			
			int r = statement.executeUpdate();

			statement.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}

	}
	public int getGuestCt() {
		return guestCt;
	}
    public void setGuestCt(int guestCt) {

    	this.guestCt = guestCt;
}
	public LocalDateTime getDTime() {
		return dTime;
	}
	public void setDTime(LocalDateTime dTime) {
		this.dTime = dTime;
	}
		
	public int getTabID() {
		return tabID;
	}
	public void setTabID(int tabID) {
		this.tabID = tabID;
	}
	public int getResID() {
		return resID;
	}
	public void setResID(int resID) {
		this.resID = resID;
		
	}
	public int getCusID() {
		return cusID;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
}
		
	

