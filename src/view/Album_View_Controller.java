package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Album_View_Controller {

    @FXML
    private Button AddNewPhotoButton;

    @FXML
    private Button AddTagsButton;

    @FXML
    private ImageView AlbumImageView;

    @FXML
    private Button DeletePhotoButton;

    @FXML
    private Button DetailViewButton;

    @FXML
    private Button NextPhotoButton;

    @FXML
    private Button PreviousPhotoButton;

    @FXML
    private Button RemoveTagsButton;

    @FXML
    private Button RenamePhotoButton;

    @FXML
    void AddNewPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Adds a new photo to the current album
    }

    @FXML
    void AddTagsButtonClicked(ActionEvent event) 
    {
        // TODO: Adds tag(s) to the current photo in the image view
        // BUG: Currently there is no way to input a tag to add or remove, need to fix ASAP
    }

    @FXML
    void DeletePhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Deletes the current photo from the album
    }

    @FXML
    void DetailViewButtonClicked(ActionEvent event) 
    {
        // Go to Photo's detailed view
        // BUG: Current iteration of this method relies on currently unimplemented methods
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Photo View.fxml"));
            Parent root = loader.load();
            Photo_View_controller photoViewController = loader.getController();
            photoViewController.setPhotoApp(PhotoApp);
            photoViewController.setPhoto("Current photo");
            Scene scene = new Scene(root);
            Stage stage = (Stage) DetailViewButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    void NextPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Goes to the next photo
    }

    @FXML
    void PreviousPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Goes to the previous photo
    }

    @FXML
    void RemoveTagsButtonClicked(ActionEvent event) 
    {
        // TODO: Removes tag(s) from current photo
        // BUG: Currently there is no way to input a tag to add or remove, need to fix ASAP
    }

    @FXML
    void RenamePhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Rename current photo
        // BUG: Currently there is no field or way to rename a photo, need to fix ASAP
    }
}
