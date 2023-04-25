package view;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Controller for the search view
 */
public class Search_View_Controller 
{

    /**
     * Current user logged in
     */
    static singleUser currentUser;
    /**
     * Sets the current user to the one sharing username
     * @param username input username
     */
    public void setUser(singleUser username)
    {
        currentUser = username;
    }
    /**
     * List of photos containing results from search
     */
    List<Photo> results;
    /**
     * Button to create album from results
     */
    @FXML
    private Button CreateAlbumFromResultsButton;
    /**
     * Button to log user out
     */
    @FXML
    private Button LogoutButton;
    /**
     * Button to return to user view
     */
    @FXML
    private Button ReturnButton;
    /**
     * Button to serach by the date
     */
    @FXML
    private Button SearchByDateButton;
    /**
     * Button to search by the photos name
     */
    @FXML
    private Button SearchByNameSearchButton;
    /**
     * Button to search by tags
     */
    @FXML
    private Button SearchByTagButton;
    /**
     * TextField to hold the search parameters for the {@link #SearchByNameSearchButton SearchByNameSearchButton}, {@link #SearchByTagButton SearchByTagButton}, and {@link #SearchByDateButton SearchByDateButton}
     */
    @FXML
    private TextField SearchInputTextField;
    /**
     * ListView containing all the searched photos
     */
    @FXML
    private ListView<Photo> SearchedPhotosListView;
    /**
     * current user logged in
     */
    @FXML
    void CreateAlbumFromResultsButtonClicked(ActionEvent event) throws FileNotFoundException 
    {
        // Creates album from Results
        currentUser.addAlbum("Album from results");
        for (Photo photo : results)
        {
            currentUser.getAlbum("Album from results").addPhoto(photo);
        }
        // Then go to the album view for this newly created album
        // Redirect to the album screen
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Album View.fxml"));
            Parent root = loader.load();
            Album_View_Controller albumViewController = loader.getController();
            albumViewController.setUser(currentUser);
            albumViewController.setAlbumName("Album from results");
            albumViewController.updateUI();
            Scene scene = new Scene(root);
            Stage stage = (Stage) CreateAlbumFromResultsButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    /**
     * Transitions user back to the login view
     * @param event Button clicked
     */
    @FXML
    void LogoutButtonClicked(ActionEvent event) 
    {
        // Redirect to login screen
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) LogoutButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    /**
     * Transitions user back to the user view
     * @param event Button clicked
     */
    @FXML
    void ReturnButtonClicked(ActionEvent event) 
    {
        // Redirect to user's album view
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("User View.fxml"));
            Parent root = loader.load();
            User_View_Controller userViewController = loader.getController();
            userViewController.setUser(currentUser.getUsername());
            userViewController.updateUI();
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
    /**
     * Searches all photos of {@link #currentUser currentUser} by the date of {@link #SearchInputTextField SearchInputTextField}
     * @param event Button clicked
     */
    @FXML
    void SearchByDateButtonClicked(ActionEvent event) 
    {
        String parameters = SearchInputTextField.getText();
        results.clear();
        for (Album album : currentUser.getAlbums())
        {
            for (Photo photo : album.getPhotos())
            {
                if (photo.getDateAsString().contains(parameters))
                {
                    results.add(photo);
                }
            }
        }
        // Display the photos:
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(results);
    
        // Set the cell factory for the ListView to display both the photo and its name
        SearchedPhotosListView.setCellFactory(param ->
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
        SearchedPhotosListView.setItems(observablePhotos);
        SearchInputTextField.clear();
    }
    /**
     * Searches all photos of {@link #currentUser currentUser} by the name of {@link #SearchInputTextField SearchInputTextField}
     * @param event Button clicked
     */
    @FXML
    void SearchByNameButtonClicked(ActionEvent event) 
    {
        String parameters = SearchInputTextField.getText();
        results.clear();
        for (Album album : currentUser.getAlbums())
        {
            for (Photo photo : album.getPhotos())
            {
                if (photo.getPhotoName().contains(parameters))
                {
                    results.add(photo);
                }
            }
        }
        // Display the photos:
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(results);
    
        // Set the cell factory for the ListView to display both the photo and its name
        SearchedPhotosListView.setCellFactory(param ->
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
        SearchedPhotosListView.setItems(observablePhotos);
        SearchInputTextField.clear();
    }
    /**
     * Searches all photos of {@link #currentUser currentUser} by the tag of {@link #SearchInputTextField SearchInputTextField}
     * @param event Button clicked
     */
    @FXML
    void SearchByTagButtonClicked(ActionEvent event) 
    {
        String parameters = SearchInputTextField.getText();
        results.clear();
        for (Album album : currentUser.getAlbums())
        {
            for (Photo photo : album.getPhotos())
            {
                if (photo.getTagsAsString().contains(parameters))
                {
                    results.add(photo);
                }
            }
        }
        // Display the photos:
        // Create a new ObservableList to hold the photos for the ListView
        ObservableList<Photo> observablePhotos = FXCollections.observableArrayList(results);
    
        // Set the cell factory for the ListView to display both the photo and its name
        SearchedPhotosListView.setCellFactory(param ->
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
        SearchedPhotosListView.setItems(observablePhotos);
        SearchInputTextField.clear();
    }

}
