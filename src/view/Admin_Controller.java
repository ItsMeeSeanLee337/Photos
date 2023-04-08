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
    private ChoiceBox<?> UserListChoiceBox;

    @FXML
    private void createUser(String username) 
    {
        // Check if the user already exists
        if (PhotoApp.userExists(username)) 
        {
            System.out.println("User already exists.");
            return;
        }
        else
        {
            PhotoApp.addUser(username);
            return;
        }
    }
}
