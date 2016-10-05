/*
	Ian Christopherson
	CISC 230
	Dr. Jarvis
	3/24/15
*/

import java.util.*;
import java.io.*;
public class MagicEightBall extends SolicitedAdvice
{
/*
	Ian Christopherson
	March 24, 2015
	
	The purpose of this class is to create an object
	which gives us advice from a magic eight ball
	
	Constructor:
		public MagicEightBall()
			Allows us to get advice from the
			magic eight ball

	Methods:
		public String getAdviceGiverName()
			Returns who is giving the advice

	Modification History:
		March 24, 2015
			Original Version

		March 25, 2015
			Added the list of possible messages 
			for the magic eight ball
*/

    public MagicEightBall()
    {

		super(new String[] {"It is certain",
							"It is decidedly so",
							"Without a doubt",
							"Yes definitely",
							"You may rely on it",
							"As I see it, yes",
							"Most likely",
							"Outlook good",
							"Yes",
							"Signs point to yes",
							"Reply hazy, try again",
							"Ask again later",
							"Better not tell you now",
							"Cannot predict now",
							"Concentrate and ask again",
							"Don't count on it",
							"My reply is no",
							"My sources say no",
							"Outlook not so good",
							"Very doubtful"
							});
    }//Constructor for MagicEightBall

    public String getAdviceGiverName()
    {
        return "Magic Eight Ball";
    }//Returns the name of the advice giver
}