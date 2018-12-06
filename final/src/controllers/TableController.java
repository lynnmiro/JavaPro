package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.*;

public class TableController {

	@FXML
	private TextField txtTableId;

	@FXML
	private TextField txtResId;

	@FXML
	private TextField txtCapacity;

	@FXML
	private Label lblError;

	@FXML
	private Label lblCapacity;

	@FXML
	private Label lblResId;

	private boolean reservedSW;

	private TableModel tableModel;

//	public TableController(int id, int resturantid, int capacity, boolean reservedSW) {
//		this.txtTableId = id;
//		this.txtResId = resturantid;
//		this.txtCapacity = capacity;
//		this.reservedSW = reservedSW;
//	}

	public void addTable() {
		int tableId = Integer.parseInt(txtTableId.getText());
		int capacity = Integer.parseInt(txtCapacity.getText());
		int restId = Integer.parseInt(txtResId.getText());
		tableModel = new TableModel();
		tableModel.addTable(tableId, capacity, restId);
	}

	public void deleteTable() {
		int tableId = Integer.parseInt(txtTableId.getText());
		tableModel = new TableModel();
		tableModel.deleteTable(tableId);
	}

	public void updateTable() {
		int tableId = Integer.parseInt(txtTableId.getText());
		int capacity = Integer.parseInt(txtCapacity.getText());
		tableModel = new TableModel();
		tableModel.updateTableCapacity(tableId, capacity);
	}

	public void getTable() {
		int tableId = Integer.parseInt(txtTableId.getText());
		tableModel = new TableModel();
		tableModel = tableModel.getTable(tableId);

		this.lblCapacity.setText("Table Capacity Is: " + Integer.toString(tableModel.getCapacity()));
		this.lblResId.setText("Restaurant ID Is: " + Integer.toString(tableModel.getRestaurantID()));

	}

	public void goToAddTable() {

		// System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/AddTableView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	public void goToDeleteTable() {

//		System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/DeleteTableView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}

	public void goToUpdateTable() {

//		System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/UpdateTableView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	public void goToGetTable() {

//		System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/GetTableView.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}
}
