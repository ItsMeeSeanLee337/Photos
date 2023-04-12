package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Album 
{
    private static final long serialVersionUID = 1L; // for serialization
        
    private String name;
    private ArrayList<Photo> photos;
    
    public Album(String name) 
    {
        this.name = name;
        photos = new ArrayList<Photo>();
    }
    
    public void addPhoto(String photoName, Calendar date, String imageFilePath, String tagKey, String tagValue) 
    {
        Photo photo = new Photo(photoName, date, imageFilePath);
        photo.addTags(tagKey, tagValue);
        photos.add(photo);
    }
    
    public ArrayList<Photo> getPhotos() 
    {
        return photos;
    }
    
    public void removePhoto(String photoName) 
    {
        photos.remove(photoName);
    }
    
    public String getAlbumName() 
    {
        return name;
    }

    public void renameAlbum(String newAlbumName) 
    {
        this.name = newAlbumName;
    }

    public boolean photoExists(String photoName) 
    {
        // Returns true if the "albums" hashmap contains the given album name, false otherwise
        return photos.contains(photoName);
    }
}