// Sean Lee & Carlos Aguilar
package view;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PhotosController {

    @FXML
    private ChoiceBox<?> AlbumChoiceBox;

    @FXML
    private Button CreateAlbumButton;

    @FXML
    private Button DeleteAlbumButton;

    @FXML
    private Button LogoutButtonAdmin;

    @FXML
    private TextField NameField;

    @FXML
    private Button OpenAlbumButton;

    @FXML
    private Button RenameAlbumButton;
    
    @FXML
    private Button CreateUserButton;

    @FXML
    private Button DeleteUserButton;

    @FXML
    private Button LogoutButtonUser;

    @FXML
    private TextField NewUserNameField;

    @FXML
    private ChoiceBox<?> UserListChoiceBox;

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
    private Button LoginButton;

    @FXML
    private TextField UsernameField;

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
}
