package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Admin_Controller 
{

    @FXML
    private Button CreateUserButton;

    @FXML
    private Button DeleteUserButton;

    @FXML
    private Button LogoutButtonAdmin;

    @FXML
    private TextField NewUserNameField;

    @FXML
    private ChoiceBox<?> UserListChoiceBox; // Need to figure out how to add all users to the choice box and have them selectable accordingly

    @FXML
    void CreateUserButtonClicked(ActionEvent event)
    {
        String username = NewUserNameField.getText();
        // Check if the user already exists
        if (PhotoApp.userExists(username)) 
        {
            System.out.println("User already exists."); // Should pop an alert saying "User already exists", can implement later
            return;
        }
        else
        {
            PhotoApp.addUser(username);
            return;
        }
    }

    @FXML
    void DeleteUserButtonClicked(ActionEvent event) 
    {
        String username = UserListChoiceBox.getId(); // I don't think this is the way to get the username from the choice box but current placeholder
        // Check if the user already exists
        if (PhotoApp.userExists(username)) 
        {
            PhotoApp.removeUser(username);
            return;
        }
        else
        {
            System.out.println("User does not exist"); // Should pop an alert saying "User does not exist", can implement later
            return;
        }
    }

    @FXML
    void LogoutButtonAdminClicked(ActionEvent event) 
    {
        // Redirect to login screen
        // BUG: Current iteration of this method relies on currently unimplemented methods
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            login_controller loginController = loader.getController();
            loginController.setPhotoApp(PhotoApp);
            loginController.setUser(username);
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
