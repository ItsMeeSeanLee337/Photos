package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    private Label TagLabel;
    // BUG: Currently it is only possible to display a single tag, the application should be able to dynamicaly display as many tags as the user attributes

    @FXML
    void returnButtonClicked(ActionEvent event) {
        // TODO: Exit from the photo view back to the album view
    }  
}
