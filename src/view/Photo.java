package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Photos object class
 */
public class Photo implements Serializable
{
    /**
     * Long for serialization
     */
    private static final long serialVersionUID = 1L; // for serialization, I think this variable is important and necessary
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
    /**
     * Photo itself
     */
    private Image image; // I think this is how you get an actual image in the photo but not sure, need to test it out
    /**
     * Constructor, Initializes name, date, and path and creates a hashmap for {@link #tags tags}
     * @param name {@link #name name}
     * @param date {@link #date date}
     * @throws FileNotFoundException
     */
    public Photo(String name, Calendar date, Image image) throws FileNotFoundException  
    {
        this.name = name;
        this.date = date;
        this.tags = new HashMap<>();
        this.image = image;
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
     * Retrieves date of this photo as a string
     * @return {@link #date} of this photo formatted as a string in the format "yyyy-MM-dd"
     */
    public String getDateAsString() 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return dateFormat.format(date.getTime());
    }
    /**
     * Retrieves Image of this photo
     * @return {@link #image of this photo}
     */
    public Image getImage()
    {
        return image;
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
     * Retrieves tags of this photo, as an arraylist of strings in "key: value" format
     * @return {@link #tags tags} of this photo
     */
    public ArrayList<String> getTagsAsString() 
    {
        ArrayList<String> keyValuePairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : tags.entrySet()) 
        {
            String keyValuePair = entry.getKey() + ": " + entry.getValue();
            keyValuePairs.add(keyValuePair);
        }
        return keyValuePairs;
    }
    /**
     * Returns whether or not a tag exists in this photo
     * @return {true or false
     */
    public boolean doesTagExist(String tagKey, String tagValue) 
    {
        ArrayList<String> keyValuePairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : tags.entrySet()) 
        {
            if (entry.getKey().equals(tagKey) && entry.getValue().equals(tagValue))
            {
                return true;
            }
        }
        return false;
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

    // I am not sure if the following methods for serializing and deserializing, also I don't know how to use them, must test 
    public void writeToFile(String filename) throws IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(this);
        }
    }

    public static Photo readFromFile(String filename) throws IOException, ClassNotFoundException 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            return (Photo) ois.readObject();
        }
    }
}
