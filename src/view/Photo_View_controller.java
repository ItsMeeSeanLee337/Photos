package view;

import java.io.IOException;

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
    public void setAlbumName(String albumName)
    {
        currentUser.getAlbum(albumName);
    }
    /**
     * Label to hold photo title
     */
    @FXML
    private Label CaptionLabel;
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
    private ListView<?> ListOfTags;
    /**
     * Returns the user to their album view
     * @param event Button clicked
     */
    @FXML
    void returnButtonClicked(ActionEvent event) {
        // Redirect to user's album view
        // BUG: Current iteration of this method relies on currently unimplemented methods
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
            Parent root = loader.load();
            Album_View_Controller albumViewController = loader.getController();
            albumViewController.setPhotoApp(PhotoApp);
            albumViewController.setUser(username);
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
