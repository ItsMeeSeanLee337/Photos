package view;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.image.Image;
/**
 * Album object class
 */
public class Album 
{
    /**
     * Long for serialization
     */
    private static final long serialVersionUID = 1L; // for serialization
    /**
     * Name of Album
     */
    private String name;
    /**
     * Photos stored in Album
     */
    private ArrayList<Photo> photos;
    /**
     * Constructor, initializes {@link #name name} and {@link #photos photos}
     * @param name
     */
    public Album(String name) 
    {
        this.name = name;
        photos = new ArrayList<Photo>();
    }
    /**
     * Adds a photo the the album
     * @param photoName Photo's name
     * @param date Photo's date
     * @param imageFilePath Photo's path
     * @param tagKey Photo's tagkey
     * @param tagValue Photo's tagvalue
     * @throws FileNotFoundException
     */
    public void addPhoto(String photoName, Calendar date, Image image) throws FileNotFoundException 
    {
        Photo photo = new Photo(photoName, date, image);
        photos.add(photo);
    }
    /**
     * Retrives photos
     * @return this albums array of {@link #photos photos}
     */
    public ArrayList<Photo> getPhotos() 
    {
        return photos;
    }
    /**
     * Removes photo with the name imputed
     * @param photoName name of photo to be deleted
     */
    public void removePhoto(Photo photoName) 
    {
        photos.remove(photoName);
    }
    /**
     * retrieves name of this Album
     * @return {@link #name name} of this Album
     */
    public String getAlbumName() 
    {
        return name;
    }
    /**
     * Renames this album
     * @param newAlbumName new name
     */
    public void renameAlbum(String newAlbumName) 
    {
        this.name = newAlbumName;
    }
    /**
     * Determines if this album contains a photo with the name inputted
     * @param photoName Name of photo to search for
     * @return Boolean
     */
    public boolean photoExists(Photo photoName) 
    {
        // Returns true if the "albums" hashmap contains the given album name, false otherwise
        return photos.contains(photoName);
    }
}