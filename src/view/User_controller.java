package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class User_controller {

    @FXML
    private ChoiceBox<?> AlbumChoiceBox;

    @FXML
    private Button CreateAlbumButton;

    @FXML
    private Button DeleteAlbumButton;

    @FXML
    private Button LogoutButtonUser;

    @FXML
    private TextField NameField;

    @FXML
    private Button OpenAlbumButton;

    @FXML
    private Button RenameAlbumButton;

    @FXML
    private void createAlbum()
    {
        // TODO: Create album, name of album will be whatever is in NameField
    }

    @FXML
    private void DeleteAlbum()
    {
        // TODO: Delete album, album to be deleted is the one selected by the user in the choice box
    }

    @FXML
    private void Logout()
    {
        // TODO: Logout from the current user
    }

    @FXML
    private void OpenAlbum()
    {
        // TODO: Open album, album to be opened is the one selected by the user in the choice box
    }

    @FXML
    private void RenameAlbum()
    {
        // TODO: Rename the album, the album selected in the choice box will be renamed into whatever is currently in NameField
    }

}
