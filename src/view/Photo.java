package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;

import javafx.scene.image.Image;

import java.util.Calendar;
/**
 * Photos object class
 */
public class Photo
{
    /**
     * Long for serialization
     */
    private static final long serialVersionUID = 1L; // for serialization
    /**
     * Name of photo
     */
    private String name;
    /**
     * Date of photo
     */
    private Calendar date;
    /**
     * Tags of the photo containing two strings, a tagkey and tagvalue
     */
    private HashMap<String, String> tags;
    /**
     * Path of photo
     */
    private String imageFilePath;
    /**
     * Photo itself
     */
    private Image image; // I think this is how you get an actual image in the photo but not sure, need to test it out
    /**
     * Constructor, Initializes name, date, and path and creates a hashmap for {@link #tags tags}
     * @param name {@link #name name}
     * @param date {@link #date date}
     * @param imageFilePath {@link #imageFilePath filepath}
     * @throws FileNotFoundException
     */
    public Photo(String name, Calendar date, String imageFilePath) throws FileNotFoundException  
    {
        this.name = name;
        this.date = date;
        this.tags = new HashMap<>();
        this.imageFilePath = imageFilePath;
        image = new Image(new FileInputStream(imageFilePath));
    }
    /**
     * Retrieves name of this photo
     * @return {@link #name name} of this photo
     */
    public String getPhotoName() 
    {
        return name;
    }
    /**
     * Retrieves date of this photo
     * @return {@link #date of this photo}
     */
    public Calendar getDate()
    {
        return date;
    }
    /**
     * Retrieves tags of this photo
     * @return {@link #tags tags} of this photo
     */
    public HashMap<String, String> getTags() 
    {
        return tags;
    }
    /**
     * Retrieves filepath of this photo
     * @return imageFilePath
     */
    public String getImageFilePath()
    {
        return imageFilePath;
    }
    /**
     * Adds new tag
     * @param tagKey Key for {@link #tags tag} hashmap
     * @param tagValue Value for {@link #tags tag} hashmap
     */
    public void addTags(String tagKey, String tagValue) 
    {
        tags.put(tagKey, tagValue);
    }
    /**
     * Removes inputted tag
     * @param tagKey Key for {@link #tags tag} hashmap
     * @param tagValue Value for {@link #tags tag} hashmap
     */
    public void removeTags(String tagKey, String tagValue)
    {
        tags.remove(tagKey, tagValue);
    }
    /**
     * Renames this photo
     * @param newPhotoName new name
     */
    public void renamePhoto(String newPhotoName)
    {
        name = newPhotoName;
    }
}
