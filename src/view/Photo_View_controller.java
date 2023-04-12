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

public class Photo_View_controller {

    @FXML
    private Label CaptionLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private ImageView DetailedImageView;

    @FXML
    private Button ReturnButton;

    @FXML
    private ListView<?> ListOfTags;

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
