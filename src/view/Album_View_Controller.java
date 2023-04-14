package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
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
     * ListView to display all photos in the album
     */
    @FXML
    private ListView<Photo> photoListView;
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
    public void initialize() 
    {
        // I have no idea if this way of displaying photos and names in the list view actually works
        // Get the list of photos in the current album
        List<Photo> photos = currentAlbum.getPhotos();
    
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(photos);
    
        // Set the cell factory for the ListView to display both the photo and its name
        photoListView.setCellFactory(param -> 
        {
            ImageView imageView = new ImageView();
            Label nameLabel = new Label();
            HBox hbox = new HBox(imageView, nameLabel);
            hbox.setSpacing(10);
            ListCell<Photo> cell = new ListCell<Photo>() 
            {
                @Override
                protected void updateItem(Photo photo, boolean empty) 
                {
                    super.updateItem(photo, empty);
                    if (empty || photo == null) 
                    {
                        setText(null);
                        imageView.setImage(null);
                        nameLabel.setText(null);
                    } 
                    else 
                    {
                        setText(photo.getPhotoName());
                        imageView.setImage(photo.getImage());
                        nameLabel.setText(photo.getPhotoName());
                    }
                }
            };
            cell.setGraphic(hbox);
            return cell;
        });
        
    
        // Set the items of the ListView to the observable list of photos
        photoListView.setItems(observablePhotos);
    }
    /*
     * Adds a new photo to the current album
     * @param event Button clicked
     */   
    @FXML
    void AddNewPhotoButtonClicked(ActionEvent event) throws FileNotFoundException 
    {
        // This method needs testing
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) 
        {
            String name = selectedFile.getName();
            Image image = new Image(selectedFile.toURI().toString());
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(selectedFile.lastModified());
            //Photo photo = new Photo(name, date, image);
            currentAlbum.addPhoto(name, date, image);
        }
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
        // TODO: Deletes the current photo from the album, this is really placeholder because the controller never updates which photo is the current one
        // No way of knowing which photo is currently selected
        currentAlbum.removePhoto(currentPhoto);

    }
    /**
     * Transitions view of photo to detail view
     * @param event Button clicked
     */
    @FXML
    void DetailViewButtonClicked(ActionEvent event) 
    {
        // Go to Photo's detailed view
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
