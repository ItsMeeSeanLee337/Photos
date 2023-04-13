package view;
import java.io.Serializable;
import java.util.HashMap;
/**
 * Users object class
 */
public class Users 
{
    /**
     * Long for serialization
     */
    private final long serialVersionUID = 1L; // for serialization
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

    public static HashMap<String, singleUser> getAllUsers()
    {
        return users;
    }
}