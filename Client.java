/*
 * Ian Christopherson
 * CISC 230
 * Dr. Jarvis
 * 4/21/2015
*/
import java.util.*;
import java.net.*;
import java.io.*;

public class Client
{
/*
 * Ian Christopherson
 * March 21, 2015
 *
 * This class is what we will use to send message to others
 *
 * Variables:
 *     private static HashMap<String, InetSocketAddress>
 *         Contains a list of IPs and their users
 *
 * Constructor:
 *     public Client(){}
 *         Constructor for the Client class
 *
 * Methods:
 *     private static String getInput(String prompt) throws IOException
 *         Allows user messages to be inputed in the client
 *
 *     private static String[] parseInput(String input)
 *         Splits the message into two parts in order to either send a
 *         message to a user, send a message to an ip, or add an ip
 *         to the directory
 *
 * Modification History:
 *     March 21, 2015
 *         Original Version
 *
 *     March 23, 2015
 *         Added different scenarios to mmain
 *
 *     May 5, 2015
 *         Added the nested class Handler
 *
 */
	private static HashMap<String, InetSocketAddress>

	map = new HashMap<>();

	public Client(){}//Constructor for the client class

	public static void main(String[] args) throws IOException
	{
		String            input;
		InetSocketAddress localAddress;
		String[]          parsedInput;

		localAddress = new InetSocketAddress(InetAddress.getLocalHost(), 10217);
		System.out.println("Client "+localAddress.getAddress());
		new ActionUpdateMessage(localAddress, localAddress, "Me "+localAddress.getAddress().toString().split("/")[1]).send();


		while(true)
		{
			input = getInput("Input: ");

			if(input.charAt(0) == '>')
			{
				GetAdviceAction getAdviceAction;
				getAdviceAction = new GetAdviceAction(input);
				getAdviceAction.send();

			}
			else
				{

				parsedInput = parseInput(input);
				if(parsedInput.length<2) {
					System.out.println("Invalid input");
					continue;
				}

				if(parsedInput[1].matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"))
				{
					InetSocketAddress address;
					address = new InetSocketAddress(parsedInput[1], 10217);
					map.put(parsedInput[0], address);
					new ActionUpdateMessage(localAddress, localAddress, input).send();
					System.out.println(parsedInput[0]+" was added at "+parsedInput[1]);
				}
				else if(parsedInput[0].matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$"))
				{
					InetSocketAddress address;
					address = new InetSocketAddress(parsedInput[0], 10217);
					new ActionMessage(localAddress, localAddress, parsedInput[1]).send();
					new ActionMessage(address, localAddress, parsedInput[1]).send();
				}
				else
				{
					new ActionMessage(localAddress, localAddress, parsedInput[1]).send();
					new ActionMessage(map.get(parsedInput[0]), localAddress, parsedInput[1]).send();
				}
		    }
		}
	}//The main to allow us to execute

	private static String getInput(String prompt) throws IOException
	{
		BufferedReader keyboard;
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(prompt);

		return keyboard.readLine();
	}//Allows user messages to be inputed in the client

	private static String[] parseInput(String input)
	{
		String[] parsedInput;
		parsedInput = input.split(" ", 2);

		return parsedInput;
	}//Splits the user message on the first space
}