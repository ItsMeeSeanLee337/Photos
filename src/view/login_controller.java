package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 * Controller for the login view
 */
public class login_controller 
{
    /**
     * username of user using the application
     */
    static String username;
    /**
     * Loginview is the initial stage
     */
    Stage mainStage;
    /**
     * Button to initiate login to user inputed into the {@link #UsernameField UsernameField} TextField
     */
    @FXML
    private Button LoginButton;
    /**
     * Textfield for username input
     */
    @FXML
    private TextField UsernameField;
    /**
     * Will either transition to admin or user view dependant on the input in the {@link #UsernameField UsernameField} TextField
     * @param event Button Clicked
     */
    @FXML
    void LoginButtonClicked(ActionEvent event) 
    {
        username = UsernameField.getText();
        
        if (username.equals("admin")) 
        {
            // Switch to the admin view
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        else if (Users.userExists(username)) 
        {
            // Redirect to user's album view
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User View.fxml"));
                Parent root = loader.load();
                User_View_Controller userViewController = loader.getController();
                userViewController.setUser(username);
                Scene scene = new Scene(root);
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        else 
        {
            // Show error message for invalid username
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username");
            alert.setContentText("The username you entered does not exist.");
            alert.showAndWait();
        }
    }
    /**
     * Sets the mainstage to loginview
     * @param stage this stage
     */
    public void setMainStage(Stage stage) 
    {
		mainStage = stage;
	}
}
