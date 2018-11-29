package controllers;

import models.DaoModel;

public class db {

	public static void main(String[] args) {
		db.callPersist();
		
		// TODO Auto-generated method stub

	}
	public static void callPersist() {
		DaoModel daoModel = new DaoModel();
		daoModel.createTable(); // creates the table


	}


}
