package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
        // TODO: Logout from the current user
    }

    @FXML
    void OpenAlbumButtonClicked(ActionEvent event) 
    {
        // TODO: Open album, album to be opened is the one selected by the user in the choice box
    }

    @FXML
    void RenameAlbumButtonClicked(ActionEvent event) 
    {
        // TODO: Rename the album, the album selected in the choice box will be renamed into whatever is currently in NameField
    }
}
