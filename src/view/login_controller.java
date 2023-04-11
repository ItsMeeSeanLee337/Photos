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

public class login_controller 
{

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UsernameField;

    @FXML
    void LoginButtonClicked(ActionEvent event) 
    {
        // BUG: Current iteration of this method relies on currently unimplemented methods
        String username = UsernameField.getText();
        
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
        else if (PhotoApp.userExists(username)) 
        {
            // Redirect to user's album view
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
                Parent root = loader.load();
                Album_View_Controller albumViewController = loader.getController();
                albumViewController.setPhotoApp(PhotoApp);
                albumViewController.setUser(username);
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
}
