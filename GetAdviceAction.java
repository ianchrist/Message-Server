import java.util.*;
import java.net.*;
import java.io.*;
public class GetAdviceAction extends ActionMessage
{
	public GetAdviceAction(String message) throws UnknownHostException
	{
		super(new InetSocketAddress(InetAddress.getLocalHost(), 10217), new InetSocketAddress(InetAddress.getLocalHost(), 10217), message);
		if(message == null){throw new IllegalArgumentException("GetAdviceAction.constructor: Parameter is null: message");}
	}//Constructor for ActionMessage

	public void execute()
	{
		Advice adviceType;
		adviceType = null;

	    try
	    {
			adviceType = Advice.adviceFactory(super.getMessage());
		}
		catch(Exception e){}

		System.out.println(adviceType.getAdviceAsSentance());
	}//Allows the Action hierarchy to use the advice factory method
}