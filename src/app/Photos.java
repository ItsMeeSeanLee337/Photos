// Sean Lee & Carlos Aguilar
package app;
import view.*;

import java.io.*;
import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.login_controller;
/**
 * Photos class, extends Application, loads and setups the stage
 */
public class Photos extends Application 
{
	/**
	 * Stage
	 */
	Stage mainStage;
	/**
	 * Initializes fxml files, the stage, and initializes the Users class
	 */
	public void start(Stage stage) throws IOException 
	{
		mainStage = stage;
	
		// Load the FXML file into a VBox
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
		VBox root = loader.load();
	
		// Set the main stage for the controller
		login_controller controller = loader.getController();
		controller.setMainStage(mainStage);
	
		//Initialize the Users class, the following can prbably be some sort of method inside the users class
		// BUG: Don't know how to have the stock user and album set implemented, current iteration relies on manually inputting images
		Users data = new Users();
		Users.addUser("stock");
		singleUser stock = Users.getUser("stock");
		stock.addAlbum("stock");
		Album stockAlbum = stock.getAlbum("stock");
		//* This all doesn't work because "The system can't find the path specified"
		Calendar date = Calendar.getInstance();
		Image first = new Image("file:data/1.jpg");
		Image second = new Image("file:data/2.jpg");
		Image third = new Image("file:data/3.jpg");
		Image fourth = new Image("file:data/4.jpg");
		Image fifth = new Image("file:data/5.jpg");

		stockAlbum.addPhoto("1.jpg", date, first);
		stockAlbum.addPhoto("1.jpg", date, second);
		stockAlbum.addPhoto("1.jpg", date, third);
		stockAlbum.addPhoto("1.jpg", date, fourth);
		stockAlbum.addPhoto("1.jpg", date, fifth);
		// Show the scene
		Scene scene = new Scene(root, 700, 400);
		mainStage.setScene(scene);
		mainStage.show();
	}
	/**
	 * Main class used as launcher
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}

}





/*
try {
*/	
/*	
} catch (IOException e) {
	e.printStackTrace();
}
*/