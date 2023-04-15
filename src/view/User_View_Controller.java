package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Controller for user view
 */
public class User_View_Controller
{
    /**
     * current user logged in
     */
    static singleUser currentUser;
    /**
     * Album being viewed/attemping to view
     */
    static String albumName;
    /**
     * Sets user to the currently logged in user
     * @param username username of current user
     */
    public void setUser(String username)
    {
        currentUser = Users.getUser(username);
    }
    /**
     * Choicebox that holds albums
     */
    @FXML
    private ChoiceBox<String> AlbumChoiceBox;
    /**
     * Button to create new album
     */
    @FXML
    private Button CreateAlbumButton;
    /**
     * Button to Deletes album
     */
    @FXML
    private Button DeleteAlbumButton;
    /**
     * Button to log user out
     */
    @FXML
    private Button LogoutButtonUser;
    /**
     * TextField to hold name for the {@link #CreateAlbumButton CreateAlbumButton}, {@link #DeleteAlbumButton DeleteAlbumButton}, and {@link #OpenAlbumButton OpenAlbumButton}
     */
    @FXML
    private TextField NameField;
    /**
     * Button to open selected album
     */
    @FXML
    private Button OpenAlbumButton;
    /**
     * Button to Renames selected album
     */
    @FXML
    private Button RenameAlbumButton;

    @FXML
    private Button SearchPhotosButton;

    @FXML
    private void initialize() 
    {
        // I think that this method of setting the choice box to all album names works but not sure, need to test
        currentUser=Users.getUser(login_controller.username);
        List<String> allAlbumNames = currentUser.getAllAlbumsNames();
        AlbumChoiceBox.getItems().addAll(allAlbumNames);
    }

    /**
     * Creates new album with the name specified in the {@link #NameField NameField} Textfield
     * @param event Button clicked
     */
    @FXML
    void CreateAlbumButtonClicked(ActionEvent event) 
    {
        albumName = NameField.getText();
        if (currentUser.albumExists(albumName))
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
            currentUser.addAlbum(albumName);
            NameField.clear();
        }
        AlbumChoiceBox.getItems().add(albumName);
    }
    /**
     * Deletes album specified in the {@link #AlbumChoiceBox AlbumChoiceBox} choice box
     * @param event Button Clicked
     */
    @FXML
    void DeleteAlbumButtonClicked(ActionEvent event) 
    {
        String albumName = AlbumChoiceBox.getValue();

        if (currentUser.albumExists(albumName))
        {
            currentUser.removeAlbum(albumName);
            // Removes the selected album from the choice box
            AlbumChoiceBox.getItems().remove(albumName);
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
    /**
     * Transitions user back to the login view
     * @param event Button clicked
     */
    @FXML
    void LogoutButtonUserClicked(ActionEvent event) 
    {
        // Redirect to login screen
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
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
    /**
     * Opens album specified in the {@link #NameField NameField} Textfield
     * @param event Button clicked
     */
    @FXML
    void OpenAlbumButtonClicked(ActionEvent event) 
    {
        String albumName = AlbumChoiceBox.getValue();

        // Check if the selected album name is not null and exists in the user's album list
        if (albumName != null && currentUser.albumExists(albumName)) 
        {
            // Redirect to the album screen
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
                Parent root = loader.load();
                Album_View_Controller albumViewController = loader.getController();
                albumViewController.setUser(currentUser);
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
    /**
     * Renames album with the name specified in the {@link #NameField NameField} Textfield
     * @param event Button clicked
     */
    @FXML
    void RenameAlbumButtonClicked(ActionEvent event) 
    {
        String oldAlbumName = AlbumChoiceBox.getValue();

        // Check if the selected album name is not null and exists in the user's album list
        if (oldAlbumName != null && currentUser.albumExists(oldAlbumName)) 
        {
            // Get the new album name from the text field
            String newAlbumName = NameField.getText();

            // Check if the new album name is different from the current album name
            if (!oldAlbumName.equals(newAlbumName)) 
            {
                // Check if the new album name already exists
                if (currentUser.albumExists(newAlbumName))
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
                    currentUser.renameAlbum(oldAlbumName, newAlbumName);
                    // Remove the old name and add the new name
                    AlbumChoiceBox.getItems().remove(oldAlbumName);
                    AlbumChoiceBox.getItems().add(newAlbumName);
                    NameField.clear();
                }
            }
        }
    }
    @FXML
    void SearchPhotosButtonClicked(ActionEvent event) 
    {
        // Redirect to the search screen
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Search View.fxml"));
            Parent root = loader.load();
            Search_View_Controller search_View_Controller = loader.getController();
            search_View_Controller.setUser(currentUser);
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
