package view;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * Controller for the photo view
 */
public class Photo_View_controller 
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
     * Sets the {@link #currentPhoto currentPhoto} to the inputed photo
     * @param photo
     */
    public void setPhoto(Photo photo)
    {
        currentPhoto = photo;
    }
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
    public void setAlbum(Album albumName)
    {
        currentAlbum = albumName;
    }
    /**
     * Label to hold photo title
     */
    @FXML
    private Label photoName;
    /**
     * Label to hold photo date
     */
    @FXML
    private Label DateLabel;
    /**
     * DetailedImammgeView to hold photo
     */
    @FXML
    private ImageView DetailedImageView;
    /**
     * Return button to transition back to album view
     */
    @FXML
    private Button ReturnButton;
    /**
     * List of tagkey and tagvalues for the current photo
     */
    @FXML
    private ListView<String> ListOfTags;
    /**
     * Updates photo properties
     */
    public void updateUI() 
    {
        if (currentPhoto != null) 
        {
            photoName.setText(currentPhoto.getPhotoName());
            DetailedImageView.setImage(currentPhoto.getImage());
            DateLabel.setText(currentPhoto.getDateAsString());
            // I think that this method of setting the choice box to all tags works but not sure, need to test
            List<String> allTags = currentPhoto.getTagsAsString();
            ListOfTags.getItems().addAll(allTags);
        }
    }
    /**
     * sets up photo viewing
     */
    @FXML
    private void initialize() 
    {
        if (currentPhoto != null)
        {
            photoName.setText(currentPhoto.getPhotoName());
            DetailedImageView.setImage(currentPhoto.getImage());
            DateLabel.setText(currentPhoto.getDateAsString());
            // I think that this method of setting the choice box to all tags works but not sure, need to test
            List<String> allTags = currentPhoto.getTagsAsString();
            ListOfTags.getItems().addAll(allTags);
        }
          
    }
    /**
     * Returns the user to their album view
     * @param event Button clicked
     */
    @FXML
    void returnButtonClicked(ActionEvent event) 
    {
        // Redirect to user's album view
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
            Parent root = loader.load();
            Album_View_Controller albumViewController = loader.getController();
            albumViewController.setUser(currentUser);
            albumViewController.setAlbumName(currentAlbum.getAlbumName());
            albumViewController.setPhoto(currentPhoto);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ReturnButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }  
}
