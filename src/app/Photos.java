// Sean Lee & Carlos Aguilar
package app;
import view.*;

import java.io.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
		/* This all doesn't work because "The system can't find the path specified"
		stockAlbum.addPhoto("1.jpg", null, "/data/1.jpg", "tagkey1", "tagvalue1");
		stockAlbum.addPhoto("2.jpg", null, "/data/2.jpg", "tagkey2", "tagvalue2");
		stockAlbum.addPhoto("3.jpg", null, "/data/3.jpg", "tagkey3", "tagvalue3");
		stockAlbum.addPhoto("4.jpg", null, "/data/4.jpg", "tagkey4", "tagvalue4");
		stockAlbum.addPhoto("5.jpg", null, "/data/6.jpg", "tagkey5", "tagvalue5");*/
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