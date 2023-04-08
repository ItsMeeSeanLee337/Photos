package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoApp implements Serializable 
{
    
    private static final long serialVersionUID = 1L; // for serialization
    
    private static HashMap<String, User> users; // map of usernames to User objects
    
    public PhotoApp() 
    {
        users = new HashMap<>();
    }
    
    public void addUser(String username) 
    {
        User user = new User(username);
        users.put(username, user);
    }
    
    public User getUser(String username) 
    {
        return users.get(username);
    }
    
    public static boolean userExists(String username) 
    {
        // Returns true if the "users" hashmap contains the given username, false otherwise
        return users.containsKey(username);
    }

    public class User implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private String username;
        private static HashMap<String, Album> albums;
        
        public User(String username) 
        {
            this.username = username;
            albums = new HashMap<>();
        }
        
        public void addAlbum(String albumName) 
        {
            Album album = new Album(albumName);
            albums.put(albumName, album);
        }
        
        public Album getAlbum(String albumName) 
        {
            return albums.get(albumName);
        }
        
        public ArrayList<Album> getAlbums() 
        {
            return new ArrayList<>(albums.values());
        }
        
        public void removeAlbum(String albumName) 
        {
            albums.remove(albumName);
        }
    }
    
    public class Album implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private String name;
        private HashMap<String, Photo> photos;
        
        public Album(String name) 
        {
            this.name = name;
            photos = new HashMap<>();
        }
        
        public void addPhoto(String photoName) 
        {
            Photo photo = new Photo(photoName);
            photos.put(photoName, photo);
        }
        
        public ArrayList<Photo> getPhotos() 
        {
            return new ArrayList<>(photos.values());
        }
        
        public void removePhoto(String photoName) 
        {
            photos.remove(photoName);
        }
        
        public String getName() 
        {
            return name;
        }
    }
    
    public class Photo implements Serializable 
    {
        
        private static final long serialVersionUID = 1L; // for serialization
        
        private String name;
        
        public Photo(String name) 
        {
            this.name = name;
        }
        
        public String getName() 
        {
            return name;
        }
    }
}
