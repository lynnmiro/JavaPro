package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DBConnect;
import javafx.application.Application;

import javafx.stage.Stage;
import models.DaoModel;
import models.User;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import models.DaoModel;


public class Main extends Application {
public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();

			stage = primaryStage;
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
			System.out.println("Error occured while inflating view: " + e);

		} 
	}



	
	public static void main(String[] args) {

//		launch(args);
		
//		DaoModel dao = new DaoModel();
//		dao.createTable();
		User user = new User();
//		user.addUser("ABC1234", "Jack", "Smith", "Customer", "a@b.com", "ab5678");
//		user.getUser("ABC1234");
//		user.updateUserPassword("ABC1234","12345");
//		user.deleteUser("");

		
		launch(args);
		
		//DaoModel dao = new DaoModel();
		//dao.createTable();
	}
}
