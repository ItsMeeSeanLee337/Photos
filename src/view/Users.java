package view;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
/**
 * Users object class
 */
public class Users implements Serializable
{
    /**
     * Long for serialization
     */
    private final long serialVersionUID = 1L; // for serialization, I think this variable is important and necessary
    /**
     * Hashmap of users corresponding to their username
     */
    private static HashMap<String, singleUser> users; // map of usernames to User objects
    /**
     * Constructor, initializes {@link #users}
     */
    public Users() 
    {
        users = new HashMap<>();
    }
    /**
     * Adds new user to the {@link #users users} hashmap
     * @param username username for new user
     */
    public static void addUser(String username) 
    {
        singleUser user = new singleUser(username);
        users.put(username, user);
    }
    /**
     * Retrieves username of user
     * @param username inputted username
     * @return username of user
     */
    public static singleUser getUser(String username) 
    {
        return users.get(username);
    }
    /**
     * Removes user from the {@link #users users} hashmap
     * @param username Username of user to be removed
     */
    public static void removeUser(String username) 
    {
        users.remove(username);
    }
    /**
     * Checks if user exists in the {@link #users users} hashmap
     * @param username username of user to be searched
     * @return boolean
     */
    public static boolean userExists(String username) 
    {
        // Returns true if the "users" hashmap contains the given username, false otherwise
        return users.containsKey(username);
    }

    /**
     * Returns all users in the {@link #users users} hashmap
     * @return HasMap<String, singleUser>
     */
    public static HashMap<String, singleUser> getAllUsers()
    {
        return users;
    }

    // I am not sure if the following methods for serializing and deserializing, also I don't know how to use them, must test 
    /**
     * Writes the Users object to a file using ObjectOutputStream
     * @param fileName name of the file to write to
     */
    public void writeToFile(String filename) throws IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(this);
        }
    }
    /**
     * Reads the Users object from a file using ObjectInputStream
     * @param fileName name of the file to read from
     */
    public static Users readFromFile(String filename) throws IOException, ClassNotFoundException 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            return (Users) ois.readObject();
        }
    }
}