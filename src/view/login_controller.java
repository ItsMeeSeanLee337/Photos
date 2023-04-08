package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login_controller 
{

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UsernameField;

    @FXML
    private void login() 
    {
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
        else if (username.equals("stock")) 
        {
            // Switch to the stock album view
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show(); // TODO: Current implementation of this method just goes into the album view if it is stock or a user, need to find a way to decide which album to go into
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        else 
        { // Go to the user's album
        }
    }
}
