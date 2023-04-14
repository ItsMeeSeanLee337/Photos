package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 * Controller for the admin view
 */
public class Admin_Controller 
{
    /**
     * Button to create user
     */    
    @FXML
    private Button CreateUserButton;
    /**
     * Button to delete user
     */
    @FXML
    private Button DeleteUserButton;
    /**
     * Button to logout
     */
    @FXML
    private Button LogoutButtonAdmin;
    /**
     * Field to create a new user
     */
    @FXML
    private TextField NewUserNameField;
    /**
     * Choicebox containing a list of users
     */
    @FXML
    private ChoiceBox<String> UserListChoiceBox;

    @FXML
    private void initialize() 
    {
        // I think that this method of setting the choice box to all usernames works but not sure, need to test
        List<String> allUsernames = new ArrayList<String>(Users.getAllUsers().keySet());
        UserListChoiceBox.getItems().addAll(allUsernames);
    }
    // Need to figure out how to add all users to the choice box and have them selectable accordingly
    /**
     * Creates user with the parameters input into the {@link #UserListChoiceBox UserListChoiceBox} 
     * @param event Button clicked
     */
    @FXML
    void CreateUserButtonClicked(ActionEvent event)
    {
        String username = NewUserNameField.getText();
        // Check if the user already exists
        if (Users.userExists(username)) 
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username");
            alert.setContentText("This username already exists");
            alert.showAndWait();
            return;
        }
        else
        {
            Users.addUser(username);
            UserListChoiceBox.getItems().add(username);
            NewUserNameField.clear();
            return;
        }
    }
    /**
     * Deletes the user with the parameters input into the {@link #UserListChoiceBox UserListChoiceBox} 
     * @param event Button clicked
     */
    @FXML
    void DeleteUserButtonClicked(ActionEvent event) 
    {
        String username = (String)UserListChoiceBox.getId(); // I don't think this is the way to get the username from the choice box but current placeholder
        // Check if the user already exists
        if (Users.userExists(username) && !username.equals("Stock")) 
        {
            UserListChoiceBox.getItems().remove(username);
            Users.removeUser(username);
            // This method doesn't fully work because it seems that the deleted user isn't removed from the choice box
            return;
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username");
            alert.setContentText("This user does not exist");
            alert.showAndWait();
            return;
        }
    }
    /**
     * Logsout user and redirects to the login view
     * @param event Button clicked
     */
    @FXML
    void LogoutButtonAdminClicked(ActionEvent event) 
    {
        // Redirect to login screen
        // BUG: Current iteration of this method relies on currently unimplemented methods
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) LogoutButtonAdmin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}
