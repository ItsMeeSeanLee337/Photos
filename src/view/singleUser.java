package view;
import java.io.Serializable;
import java.util.ArrayList;

public class singleUser 
{
    private static final long serialVersionUID = 1L; // for serialization
    
    private String username;
    private ArrayList<Album> albums;
    
    public singleUser(String username) 
    {
        this.username = username;
        albums = new ArrayList<Album>();
    }

    public void addAlbum(String albumName) 
    {
        albums.add(new Album(albumName));
    }

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

    public ArrayList<Album> getAlbums() 
    {
        return albums;
    }

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
