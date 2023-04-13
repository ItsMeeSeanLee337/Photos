// Sean Lee & Carlos Aguilar
package app;
import view.*;

import java.io.*;
import java.io.IOException;

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
	
		//Initialize the Users class
		Users data = new Users();
		// Show the scene
		Scene scene = new Scene(root, 700, 400);
		mainStage.setScene(scene);
		mainStage.show();
	}
	/**
	 * Main class used as launcher
	 * @param args
	 */
	public static void main(String[] args) {
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