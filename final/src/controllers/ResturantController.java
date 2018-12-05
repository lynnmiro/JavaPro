package controllers;

import java.util.List;

import com.mysql.cj.xdevapi.Table;

public class ResturantController {

	private int id;
	private String name;
	private String type;
	private String phoneNum;
	private List<Table> tables;
	
	public ResturantController(int id, String name, String description, String menu, String type, String phoneNum,
			String address, List<Table> tables) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.phoneNum = phoneNum;
		this.tables = tables;
	}
}
