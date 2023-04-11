package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


public class User_controller {

    @FXML
    private ChoiceBox<?> AlbumChoiceBox;

    @FXML
    private Button CreateAlbumButton;

    @FXML
    private Button DeleteAlbumButton;

    @FXML
    private Button LogoutButtonUser;

    @FXML
    private TextField NameField;

    @FXML
    private Button OpenAlbumButton;

    @FXML
    private Button RenameAlbumButton;

    @FXML
    void CreateAlbumButtonClicked(ActionEvent event) 
    {
        String albumName = NameField.getText();

        if (PhotoApp.User.albumExists(albumName))
        {
            // Show error message for album already existing
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Album Name");
            alert.setContentText("This album already exists");
            alert.showAndWait();
        }
        else
        {
            PhotoApp.User.addAlbum(albumName);
        }
    }

    @FXML
    void DeleteAlbumButtonClicked(ActionEvent event) 
    {
        String albumName = NameField.getText();

        if (PhotoApp.User.albumExists(albumName))
        {
            PhotoApp.User.removeAlbum(albumName);
        }
        else
        {
            // Show error message for album not existing
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Album Name");
            alert.setContentText("This album does not exist");
            alert.showAndWait();
        }
    }

    @FXML
    void LogoutButtonUserClicked(ActionEvent event) 
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
            Stage stage = (Stage) LogoutButtonUser.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    void OpenAlbumButtonClicked(ActionEvent event) 
    {
        // BUG: Current iteration of this method relies on currently unimplemented methods
        // Get the selected album name from the choice box
        String albumName = (String) AlbumChoiceBox.getValue();

        // Check if the selected album name is not null and exists in the user's album list
        if (albumName != null && PhotoApp.User.albumExists(albumName)) 
        {
            // Redirect to the album screen
            // BUG: Current iteration of this method relies on currently unimplemented methods
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
                Parent root = loader.load();
                Album_View_Controller albumViewController = loader.getController();
                albumViewController.setPhotoApp(PhotoApp);
                albumViewController.setUser(username);
                albumViewController.setAlbumName(albumName);
                Scene scene = new Scene(root);
                Stage stage = (Stage) OpenAlbumButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void RenameAlbumButtonClicked(ActionEvent event) 
    {
        // Get the selected album name from the choice box
        String oldAlbumName = (String) AlbumChoiceBox.getValue();

        // Check if the selected album name is not null and exists in the user's album list
        if (oldAlbumName != null && PhotoApp.User.albumExists(oldAlbumName)) 
        {
            // Get the new album name from the text field
            String newAlbumName = NameField.getText();

            // Check if the new album name is different from the current album name
            if (!oldAlbumName.equals(newAlbumName)) 
            {
                // Check if the new album name already exists
                if (PhotoApp.User.albumExists(newAlbumName))
                {
                    // Show error message for album already existing
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Album Name");
                    alert.setContentText("An album with this name already exists");
                    alert.showAndWait();
                }
                else
                {
                    // Rename the album
                    PhotoApp.User.renameAlbum(oldAlbumName, newAlbumName);
                }
            }
        }
    }
}
