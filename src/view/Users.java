package view;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;

public class Users 
{
    private final long serialVersionUID = 1L; // for serialization
    
    private static HashMap<String, singleUser> users; // map of usernames to User objects
    
    public Users() 
    {
        users = new HashMap<>();
    }
    
    public static void addUser(String username) 
    {
        singleUser user = new singleUser(username);
        users.put(username, user);
    }
    
    public static singleUser getUser(String username) 
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
}
