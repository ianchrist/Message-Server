/*
 * Ian Christopherson
 * CISC 230
 * Dr. Jarvis
 * 4/22/2015
*/
import java.util.*;
import java.net.*;

public class ActionUpdateMessage extends ActionMessage
{
/*
 * Ian Christopherson
 * March 22, 2015
 * 
 * This class helps update the Directory class
 * 
 * Variable:
 *     private static final long serialVersionUID = 1;
 *         Helps with the Serializable class
 * 
 * Constructors:
 *     public ActionUpdateMessage(InetSocketAddress to, InetSocketAddress from, String message)
 *         Initiates the instance variables for ActionUpdateMessage
 *         
 * Methods:
 *     public void execute()
 *         Helps update the directory
 *         
 * Method History:
 *     March 22, 2015
 *         Original Version
 * 
 */
    private static final long serialVersionUID = 1;

    public ActionUpdateMessage(InetSocketAddress to, InetSocketAddress from, String message)
    {
        super(to, from, message);
    }//The constructor for ActionUpdateMessage

    public void execute()
    {
        InetSocketAddress address;
        String[]          parsedMessage;
        
        parsedMessage = getMessage().split(" ", 2);
        address = new InetSocketAddress(parsedMessage[1], 10217);
        Directory.getInstance().update(address, parsedMessage[0], true);
    }//Helps update the directory
}