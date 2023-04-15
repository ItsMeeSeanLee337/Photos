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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    static singleUser currentUser;
    /**
     * Currently selected album
     */
    static Album currentAlbum;
    /**
     * Photo being viewed
     */
    static Photo currentPhoto;
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
    /**
     * Button to remove tags
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
     * Class to handle imageviewing on initialization
     */
    public void initialize() 
    {
        // Only jpg files work, something to keep in mind
        currentAlbum=Users.getUser(login_controller.username).getAlbum((User_View_Controller.albumName));
        // Get the list of photos in the current album
        List<Photo> photos = currentAlbum.getPhotos();
    
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(photos);
    
        // Set the cell factory for the ListView to display both the photo and its name
        photoListView.setCellFactory(param ->
        {
            ImageView imageView = new ImageView();
            HBox hbox = new HBox(imageView);
            hbox.setSpacing(10);
            Label nameLabel = new Label();
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
                        setText(null);
                        imageView.setImage(photo.getImage());
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(50); // Change the value to the desired width
                        imageView.setFitHeight(50); // Change the value to the desired height
                        nameLabel.setText(photo.getPhotoName());
                    }
                }
            };
            hbox.getChildren().add(nameLabel);
            cell.setGraphic(hbox);
            return cell;
        });
        // Set the items of the ListView to the observable list of photos
        photoListView.setItems(observablePhotos);

        // The following code is to handle if a user clicks on a photo in the listView, accordingly updates the currentPhoto with the selectedPhoto
        photoListView.setOnMouseClicked(event -> 
        {
            if (event.getClickCount() == 1) 
            {
                Photo selectedPhoto = photoListView.getSelectionModel().getSelectedItem();
                if (selectedPhoto != null) 
                {
                    currentPhoto = selectedPhoto;
                }
            }
        });
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
        // wpg files don't work, only jpg and png files
        currentAlbum=Users.getUser(login_controller.username).getAlbum((User_View_Controller.albumName));
        // Get the list of photos in the current album
        List<Photo> photos = currentAlbum.getPhotos();
    
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(photos);
    
        // Set the cell factory for the ListView to display both the photo and its name
        photoListView.setCellFactory(param ->
        {
            ImageView imageView = new ImageView();
            HBox hbox = new HBox(imageView);
            hbox.setSpacing(10);
            Label nameLabel = new Label();
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
                        setText(null);
                        imageView.setImage(photo.getImage());
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(50); // Change the value to the desired width
                        imageView.setFitHeight(50); // Change the value to the desired height
                        nameLabel.setText(photo.getPhotoName());
                    }
                }
            };
            hbox.getChildren().add(nameLabel);
            cell.setGraphic(hbox);
            return cell;
        });
        // Set the items of the ListView to the observable list of photos
        photoListView.setItems(observablePhotos);
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
        if (currentPhoto.doesTagExist(tagKeyString, tagValueString))
        {
            // Show error message for tag already existing
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Tag Addition");
            alert.setContentText("A tag with this key value pair already exists");
            alert.showAndWait();
        }
        else
        {
            tagKey.clear();
            tagValue.clear();
            currentPhoto.addTags(tagKeyString, tagValueString);
        }
    }
    /**
     * Deletes currently selected photo
     * @param event Button clicked
     */
    @FXML
    void DeletePhotoButtonClicked(ActionEvent event) 
    {
        currentAlbum.removePhoto(currentPhoto);

        currentAlbum=Users.getUser(login_controller.username).getAlbum((User_View_Controller.albumName));
        // Get the list of photos in the current album
        List<Photo> photos = currentAlbum.getPhotos();
    
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(photos);
    
        // Set the cell factory for the ListView to display both the photo and its name
        photoListView.setCellFactory(param ->
        {
            ImageView imageView = new ImageView();
            HBox hbox = new HBox(imageView);
            hbox.setSpacing(10);
            Label nameLabel = new Label();
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
                        setText(null);
                        imageView.setImage(photo.getImage());
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(50); // Change the value to the desired width
                        imageView.setFitHeight(50); // Change the value to the desired height
                        nameLabel.setText(photo.getPhotoName());
                    }
                }
            };
            hbox.getChildren().add(nameLabel);
            cell.setGraphic(hbox);
            return cell;
        });
        // Set the items of the ListView to the observable list of photos
        photoListView.setItems(observablePhotos);
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
            photoViewController.setAlbum(currentAlbum);
            photoViewController.setPhoto(currentPhoto);
            photoViewController.updateUI();
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
        if (currentPhoto.doesTagExist(tagKeyString, tagValueString))
        {
            tagKey.clear();
            tagValue.clear();
            currentPhoto.removeTags(tagKeyString, tagValueString);
        }
        else
        {
            // Show error message for tag not existing
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Tag Deletion");
            alert.setContentText("A tag with this key value pair does not exist");
            alert.showAndWait();
        }
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
        currentAlbum=Users.getUser(login_controller.username).getAlbum((User_View_Controller.albumName));
        // Get the list of photos in the current album
        List<Photo> photos = currentAlbum.getPhotos();
    
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(photos);
    
        // Set the cell factory for the ListView to display both the photo and its name
        photoListView.setCellFactory(param ->
        {
            ImageView imageView = new ImageView();
            HBox hbox = new HBox(imageView);
            hbox.setSpacing(10);
            Label nameLabel = new Label();
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
                        setText(null);
                        imageView.setImage(photo.getImage());
                        imageView.setPreserveRatio(true);
                        imageView.setFitWidth(50); // Change the value to the desired width
                        imageView.setFitHeight(50); // Change the value to the desired height
                        nameLabel.setText(photo.getPhotoName());
                    }
                }
            };
            hbox.getChildren().add(nameLabel);
            cell.setGraphic(hbox);
            return cell;
        });
        // Set the items of the ListView to the observable list of photos
        photoListView.setItems(observablePhotos);
    }
}
