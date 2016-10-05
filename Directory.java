/*
 * Ian Christopherson
 * CISC 230
 * Dr. Jarvis
 * 4/22/2015
*/
import java.util.*;
import java.net.*;

public class Directory
{
/*
 * Ian Christopherson
 * March 22, 2015
 * 
 * This class will contain a list of users along with the
 * IPs associated with them, allowing us to access and modify
 * them
 * 
 * Variables:
 *     private static Directory instance = new Directory();
 *         Contains the directory for other classes to use
 *         
 *     private HashMap<InetSocketAddress, String> map;
 *         Contains IPs and their users
 *         
 * Constructor:
 *     private Directory()
 *         Initiates the map variable
 *         
 * Methods
 *     public static Directory getInstance() 
 *         Returns the instance variable
 *         
 *     public synchronized void update(InetSocketAddress key, String value, boolean overwrite)
 *         Helps update the directory
 *     
 *     public synchronized String get(InetSocketAddress key)
 *         Returns the user if an ip is entered
 */
    private static Directory instance = new Directory();
    private HashMap<InetSocketAddress, String> map;

    private Directory()
    {
        map = new HashMap<InetSocketAddress, String>();
    }//The constructor for the Directory class

    public static Directory getInstance() 
    { 
        return instance; 
    } //Returns the instance variable

    public synchronized void update(InetSocketAddress key, String value, boolean overwrite)
    {
        if(overwrite) 
        {
            this.map.remove(key);
        }
        this.map.put(key, value);
    }//Helps update the directory

    public synchronized String get(InetSocketAddress key)
    {
        return this.map.get(key);
    }//Returns the user if an ip is entered
}