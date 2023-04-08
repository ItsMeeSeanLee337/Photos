package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Admin_Controller {

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
    private void createUser() 
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
    private void deleteUser()
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
}
