package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
	
	public TableModel getTable() {
		int tableId = Integer.parseInt(txtTableId.getText());
		tableModel = new TableModel();
		return tableModel.getTable(tableId);
	}
	
	
}
