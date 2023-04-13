package view;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * SingleUser object class
 */
public class singleUser 
{
    /**
     * long for serialization
     */
    private static final long serialVersionUID = 1L; // for serialization
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
}
