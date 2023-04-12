package view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Calendar;

public class Photo
{
    private static final long serialVersionUID = 1L; // for serialization
        
    private String name;
    private Calendar date;
    private HashMap<String, String> tags;
    private String imageFilePath;

    public Photo(String name, Calendar date, String imageFilePath)  
    {
        this.name = name;
        this.date = date;
        this.tags = new HashMap<>();
        this.imageFilePath = imageFilePath;
    }
    
    public String getPhotoName() 
    {
        return name;
    }

    public Calendar getDate()
    {
        return date;
    }

    public HashMap<String, String> getTags() 
    {
        return tags;
    }

    public String getImageFilePath()
    {
        return imageFilePath;
    }

    public void addTags(String tagKey, String tagValue) 
    {
        tags.put(tagKey, tagValue);
    }

    public void removeTags(String tagKey, String tagValue)
    {
        tags.remove(tagKey, tagValue);
    }

    public void renamePhoto(String newPhotoName)
    {
        name = newPhotoName;
    }
}
