package view;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * SingleUser object class
 */
public class singleUser implements Serializable
{
    /**
     * long for serialization
     */
    private static final long serialVersionUID = 1L; // for serialization, I think this variable is important and necessary
    /**
     * Username of this user
     */
    private String username;
    /**
     * Albums owned by this user
     */
    private ArrayList<Album> albums;
    /**
     * Constructor, intializes {@link #username username} and {@link #albums albums}
     * @param username
     */
    public singleUser(String username) 
    {
        this.username = username;
        albums = new ArrayList<Album>();
    }
    /**
     * Adds album to this users {@link #albums albums}
     * @param albumName New Album name
     */
    public void addAlbum(String albumName) 
    {
        albums.add(new Album(albumName));
    }
    public String getUsername()
    {
        return username;
    }
    /**
     * Retrieves album from this users {@link #albums albums}
     * @param albumName Name of album to be searched
     * @return specified album or null
     */
    public Album getAlbum(String albumName) 
    {
        for (Album album : albums) 
        {
            if (album.getAlbumName().equals(albumName)) 
            {
                return album;
            }
        }
        return null;
    }
    /**
     * Retrieves this users {@link #albums albums}
     * @return this users {@link #albums albums}
     */
    public ArrayList<Album> getAlbums() 
    {
        return albums;
    }
    public ArrayList<String> getAllAlbumsNames() 
    {
        ArrayList<String> allAlbumNames = new ArrayList<String>();
        for (Album album : albums)
        {
            allAlbumNames.add(album.getAlbumName());
        }
        return allAlbumNames;
    }
    
    /**
     * Removes specified album
     * @param albumName album to be removed
     */
    public void removeAlbum(String albumName) 
    {
        for (Album album : albums) {
            if (album.getAlbumName().equals(albumName)) 
            {
                albums.remove(album);
                return;
            }
        }
    }
    /**
     * Renames album
     * @param oldAlbumName Current name of album
     * @param newAlbumName New name of album
     */
    public void renameAlbum(String oldAlbumName, String newAlbumName) 
    {
        for (Album album : albums) 
        {
            if (album.getAlbumName().equals(oldAlbumName)) 
            {
                album.renameAlbum(newAlbumName);
                return;
            }
        }
    }
    /**
     * Checks that album exists in this users {@link #albums albums}
     * @param albumName name of album to be searched
     * @return Boolean
     */
    public boolean albumExists(String albumName) 
    {
        for (Album album : albums) {
            if (album.getAlbumName().equals(albumName))
            {
                return true;
            }
        }
        return false;
    }

    // I am not sure if the following methods for serializing and deserializing, also I don't know how to use them, must test 
    /**
     * For serialization
     * @param filename File for serialization
     * @throws IOException Exception from writing files
     */
    public void writeToFile(String filename) throws IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(this);
        }
    }
    /**
     * For deserialization
     * @param filename File for deserialization
     * @return Object info
     * @throws IOException Exception from reading files
     * @throws ClassNotFoundException Unknown reading
     */
    public static singleUser readFromFile(String filename) throws IOException, ClassNotFoundException 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            return (singleUser) ois.readObject();
        }
    }
}
