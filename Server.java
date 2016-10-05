/* Ian Christopherson
 * CISC 230
 * Dr. Jarvis
 * 4/23/2015
 */
import java.util.*;
import java.net.*;
import java.io.*;
public class Server implements Runnable
{
/*
 * This class is what will bring up the server which we will use
 * to send and recieve messages to others.
 *
 * Constructor:
 *     Server()
 *         Allows us to use the Server Class
 *
 * Methods:
 *     public void run()
 *         Allows the server to run
 *
 * Modification History:
 *     April 23, 2015
 *         Original version
 *
 *     April 26, 2015
 *         Created the run() method
 */

 	private int portNumber;
 	private boolean done;
 	private boolean isRunning;

    public Server(int portNumber)
    {
		this.done = false;
		this.isRunning = false;
		this.portNumber = this.portNumber;
    };//Constructor for the Server class

    public static void main(String[] args) throws UnknownHostException
    {
		try
		{
        	System.out.println("Server "+InetAddress.getLocalHost());
        	Server server;
        	server = new Server(10217);
        	Thread thread;
        	thread = new Thread(server);
        	thread.start();
        	System.out.println("Press enter to quit");
        	System.in.read();
        	server.stopServer();

        	//new Thread(new Server(10217)).start();
		}
		catch(IOException ioe) {};
    }//Allows the server to be used

    public void run()
    {
		this.done = false;
		this.isRunning = true;
        try {
            Socket       connection;
            ServerSocket listener;

            listener = new ServerSocket(10217);

            while(!done)
            {
                connection = listener.accept();
                new Thread(new Handler(connection)).start();
            }
        }
        catch(IOException ioe){}
    }//Allows the server to run

    public boolean isRunning()
    {
		return this.isRunning;
	}

    public void stopServer()
    {
		if(!this.done)
		{
			try
			{
				this.done = true;
				new Socket(InetAddress.getLocalHost(), 10217);
			}
			catch (UnknownHostException uho){}
			catch (IOException ioe){}
		}
	}

    private class Handler implements Runnable
    {
	 /* This class connects the Server and ActionMessage
	 *
	 * Variable:
	 *     private socket connection
	 *         Allows the server to use ActionMessage
	 *
	 * Constructor:
	 *     public Handler(Socket connection)
	 *         Initiates the connection variable
	 *
	 * Methods:
	 *     public void run()
	 *         Allows the server use ActionMessage
	 *
	 * Modification History:
	 *     April 22, 2015
	 *         Original Version
	 *
	 *     April 23, 2015
 	 *         Added the run() method
 	 *
 	 *     May 4, 2015
 	 *         Nested the handler class
 	 */

		private Socket connection;

		public Handler(Socket connection)
		{
		    this.connection = connection;
		}//constructor

		public void run()
		{
		    ActionMessage message;
		    ObjectInputStream ois;
		    ois = null;
		    try {
		        ois = new ObjectInputStream(this.connection.getInputStream());
		        message = (ActionMessage)ois.readObject();
		        message.execute();
		        try
		        {
		            ois.close();
		        }
		        catch (Exception e){}

		    }//try
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }
		    finally
		    {
	            try
		        {
		            this.connection.close();
	            } catch (Exception e){}
	        }

        } //Allows the server use ActionMessage
	}
}