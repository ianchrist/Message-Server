/*
* Ian Christopherson
* CISC 230
* Dr.Jarvis
* 4/22/2015
*/
import java.net.*;
import java.io.*;
import java.util.*;

public class ActionMessage implements Serializable
{
/*
 * Ian Christopherson
 * April 22, 2015
 *
 * This class is used to send and print messages
 *
 * Variables:
 *     private static final long serialVersionUID = 1;
 *         Allows us to use Serializable
 *
 *     private InetSocketAddress from
 *         Holds who the message is from
 *
 *     private String message
 *         Contains the message to be sent
 *
 *     private InetSockedAddress to
 *         Holds who the message will be sent to
 *
 *     Constructor:
 *         public ActionMessage(InetSocketAddress to, InetSocketAddress from, String message)
 *             Initiates the instance variables for ActionMessage
 *
 * Methods:
 *     public InetSocketAddress getTo()
 *         Returns the variable to
 *
 *     public InetSocketAddress getFrom()
 *         Returns the variable from
 *
 *     public String getMessage()
 *         Returns the variable message
 *
 *     public void send() throws IOException
 *         Allows us to send messages
 *
 *     public void execute()
 *         Allows us to displays the name when printing the message
 *
 * Modification History:
 *     April 22, 2015
 *         Original Version
 *
 *     April 27, 2015
 *         Added error checking to the constructor
 */
    private static final long serialVersionUID = 1;

    private InetSocketAddress from;
    private String            message;
    private InetSocketAddress to;

    public ActionMessage(InetSocketAddress to, InetSocketAddress from, String message)
    {
        if(to == null){throw new IllegalArgumentException("ActionMessage.constructor: Parameter is null: to");}
        if(from == null){throw new IllegalArgumentException("ActionMessage.constructor: Parameter is null: from");}
        if(message == null){throw new IllegalArgumentException("ActionMessage.constructor: Parameter is null: message");}
        this.to = to;
        this.from = from;
        this.message = message;
    }//Constructor for the ActionMessage class

    public InetSocketAddress getTo()
    {
        return this.to;
    }//Returns the variable to

    public InetSocketAddress getFrom()
    {
        return this.from;
    }//Returns the variable from

    public String getMessage()
    {
        return this.message;
    }//Returns the variable message

    public void send() throws IOException
    {
        Socket             connection;
        ObjectOutputStream oos;

        connection = new Socket(getTo().getAddress(), getTo().getPort());
        oos = new ObjectOutputStream(connection.getOutputStream());

        oos.writeObject(this);

        oos.close();
        connection.close();
    }// Allows us to send messages

    public void execute()
    {
        String    name;
        Directory directory;
        directory = Directory.getInstance();
        if(directory.get(getFrom())!=null)
        {
            name = directory.get(getFrom());
        }
        else
        {
            name = getFrom().getAddress().toString();
        }
        System.out.println(name+": "+getMessage());
    }//Allows us to displays the name when printing the message
}