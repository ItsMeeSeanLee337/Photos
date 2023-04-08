package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

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
    private void AddNewPhoto()
    {
        // TODO: Adds a new photo to the current album
    }

    @FXML
    private void AddTags()
    {
        // TODO: Adds tag(s) to the current photo in the image view
        // BUG: Currently there is no way to input a tag to add or remove, need to fix ASAP
    }

    @FXML
    private void DeletePhoto()
    {
        // TODO: Deletes the current photo from the album
    }

    @FXML
    private void GoToDetailView()
    {
        // TODO: Goes to a detailed photo view of the current photo
    }

    @FXML
    private void nextPhoto()
    {
        // TODO: Goes to the next photo
    }

    @FXML
    private void previousPhoto()
    {
        // TODO: Goes to the previous photo
    }

    @FXML
    private void RemoveTags()
    {
        // TODO: Removes tag(s) from current photo
        // BUG: Currently there is no way to input a tag to add or remove, need to fix ASAP
    }

    @FXML
    private void RenamePhoto()
    {
        // TODO: Rename current phot
        // BUG: Currently there is no field or way to rename a photo, need to fix ASAP
    }
}
