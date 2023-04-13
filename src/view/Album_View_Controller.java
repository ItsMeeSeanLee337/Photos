package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * Controller for the album View
 */
public class Album_View_Controller 
{
    /**
     * Current user logged in
     */
    singleUser currentUser;
    /**
     * Currently selected album
     */
    Album currentAlbum;
    /**
     * Photo being viewed
     */
    Photo currentPhoto;
    /**
     * Sets the current user to the one sharing username
     * @param username input username
     */
    public void setUser(singleUser username)
    {
        currentUser = username;
    }
    /**
     * Retrieves the current users album with input albumname
     * @param albumName input albumname
     */
    public void setAlbumName(String albumName)
    {
        currentUser.getAlbum(albumName);
    }
    /**
     * Sets the {@link #currentPhoto currentPhoto} to the inputed photo
     * @param photo
     */
    public void setPhoto(Photo photo)
    {
        currentPhoto = photo;
    }
    /**
     * Button to add new photo
     */
    @FXML
    private Button AddNewPhotoButton;
    /**
     * Button to add new tag(s)
     */
    @FXML
    private Button AddTagsButton;
    /**
     * Imageview containing photos
     */
    @FXML
    private ImageView AlbumImageView;
    /**
     * Button to delete photos
     */
    @FXML
    private Button DeletePhotoButton;
    /**
     * Button to open photo into detail view
     */
    @FXML
    private Button DetailViewButton;
    /**
     * Button to go to next photo
     */
    @FXML
    private Button NextPhotoButton;
    /**
     * Button to go to previous photo
     */
    @FXML
    private Button PreviousPhotoButton;
    /**
     * Button to remove tag(s)
     */
    @FXML
    private Button RemoveTagsButton;
    /**
     * Button to rename photos
     */
    @FXML
    private Button RenamePhotoButton;
    /**
     * Textfield for tagkey input
     */
    @FXML
    private TextField tagKey;
    /**
     * Textfield for tagvalue input
     */
    @FXML
    private TextField tagValue;
    /**
     * Textfield for photo name */   
    @FXML
    private TextField photoName;
    /**
     * Adds a new photo to the current album
     * @param event Button clicked
     */   
    @FXML
    void AddNewPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Adds a new photo to the current album
    }
    /**
     * Adds tags to the current photo
     * @param event Button clicked
     */
    @FXML
    void AddTagsButtonClicked(ActionEvent event) 
    {
        String tagKeyString = tagKey.getText();
        String tagValueString = tagValue.getText();
        currentPhoto.addTags(tagKeyString, tagValueString);
    }
    /**
     * Deletes currently selected photo
     * @param event Button clicked
     */
    @FXML
    void DeletePhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Deletes the current photo from the album
    }
    /**
     * Transitions view of photo to detail view
     * @param event Button clicked
     */
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
            photoViewController.setUser(currentUser);
            photoViewController.setAlbumName(currentAlbum.getAlbumName());
            photoViewController.setPhoto(currentPhoto);
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
    /**
     * Transitions to the next photo in the album
     * @param event Button clicked
     */
    @FXML
    void NextPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Goes to the next photo
    }
    /**
     * Transitions to the previous photo in the album
     * @param event
     */
    @FXML
    void PreviousPhotoButtonClicked(ActionEvent event) 
    {
        // TODO: Goes to the previous photo
    }
    /**
     * Removes tags specified in the {@link #tagKey tagKey} and {@link #tagValue tagValue} TextFields
     * @param event Button clicked
     */
    @FXML
    void RemoveTagsButtonClicked(ActionEvent event) 
    {
        String tagKeyString = tagKey.getText();
        String tagValueString = tagValue.getText();
        currentPhoto.removeTags(tagKeyString, tagValueString);
    }
    /**
     * Renames photo to string specified in the {@link #photoName photoname} textfield
     * @param event
     */
    @FXML
    void RenamePhotoButtonClicked(ActionEvent event) 
    {
        String photoNameString = photoName.getText();
        currentPhoto.renamePhoto(photoNameString);
    }
}
