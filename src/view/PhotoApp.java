package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;

public class PhotoApp implements Serializable 
{
    
    private static final long serialVersionUID = 1L; // for serialization
    
    private static HashMap<String, User> users; // map of usernames to User objects
    
    public PhotoApp() 
    {
        users = new HashMap<>();
    }
    
    public static void addUser(String username) 
    {
        User user = new User(username);
        users.put(username, user);
    }
    
    public static User getUser(String username) 
    {
        return users.get(username);
    }
    
    public static void removeUser(String username) 
    {
        users.remove(username);
    }

    public static boolean userExists(String username) 
    {
        // Returns true if the "users" hashmap contains the given username, false otherwise
        return users.containsKey(username);
    }

    public static class User implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private String username;
        private static HashMap<String, Album> albums;
        
        public User(String username) 
        {
            this.username = username;
            albums = new HashMap<>();
        }
        
        public static void addAlbum(String albumName) 
        {
            Album album = new Album(albumName);
            albums.put(albumName, album);
        }
        
        public static Album getAlbum(String albumName) 
        {
            return albums.get(albumName);
        }
        
        public static ArrayList<Album> getAlbums() 
        {
            return new ArrayList<>(albums.values());
        }
        
        public static void removeAlbum(String albumName) 
        {
            albums.remove(albumName);
        }

        public static void renameAlbum(String oldAlbumName, String newAlbumName) 
        {
            // TODO: Not sure if this way of renaming an album actually works, needs testing
            PhotoApp.Album obj = albums.remove("oldAlbumName");
            albums.put("newKey", obj);
        }

        public static boolean albumExists(String albumName) 
        {
            // Returns true if the "albums" hashmap contains the given album name, false otherwise
            return albums.containsKey(albumName);
        }
    }
    
    public static class Album implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private static String name;
        private static HashMap<String, Photo> photos;
        
        public Album(String name) 
        {
            this.name = name;
            photos = new HashMap<>();
        }
        
        public static void addPhoto(String photoName, Calendar date, String imageFilePath, String tagKey, String tagValue) 
        {
            Photo photo = new Photo(photoName, date, imageFilePath);
            photo.addTags(tagKey, tagValue);
            photos.put(photoName, photo);
        }
        
        public static ArrayList<Photo> getPhotos() 
        {
            return new ArrayList<>(photos.values());
        }
        
        public static void removePhoto(String photoName) 
        {
            photos.remove(photoName);
        }
        
        public static String getAlbumName() 
        {
            return name;
        }

        public static boolean photoExists(String photoName) 
        {
            // Returns true if the "albums" hashmap contains the given album name, false otherwise
            return photos.containsKey(photoName);
        }
    }
    
    public static class Photo implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private static String name;
        private static Calendar date;
        private static HashMap<String, String> tags;
        private static String imageFilePath;

        public Photo(String name, Calendar date, String imageFilePath)  
        {
            this.name = name;
            this.date = date;
            this.tags = new HashMap<>();
            this.imageFilePath = imageFilePath;
        }
        
        public static String getPhotoName() 
        {
            return name;
        }

        public static Calendar getDate()
        {
            return date;
        }

        public static HashMap<String, String> getTags() 
        {
            return tags;
        }

        public static String getImageFilePath()
        {
            return imageFilePath;
        }

        public static void addTags(String tagKey, String tagValue) 
        {
            tags.put(tagKey, tagValue);
        }

        public static void removeTags(String tagKey, String tagValue)
        {
            tags.remove(tagKey, tagValue);
        }

        public static void renamePhoto(String newPhotoName)
        {
            name = newPhotoName;
        }
    }
}
