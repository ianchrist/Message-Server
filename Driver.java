/*
	Ian Christopherson
	CISC 230
	Dr. Jarvis
	3/24/15
*/

import java.util.*;
import java.io.*;
public class Driver
{
/*
	Ian Christopherson
	March 25, 2015

	The purpose of this class is to create
	objects that will display various pieces
	of advice.  This includes the solicited
	advice from a magic 8 ball and a magic
	pirate ball and unsolicited advice from
	a fortune cookie and parents.
*/

	public static void main(String[]Args)
	{
		FortuneCookie   fortuneCookie;
		String[]        fortuneMessage;
		MagicEightBall  magicEightBall;
		MagicPirateBall magicPirateBall;
		ParentalAdvice  parentalAdvice;
		String[]        parentsMessage;
		Advice          test[];


		parentsMessage = new String[] {"Ask your mom",
		        					   "Ask your dad",
		        					   "Always use your back",
		        					   "Don't go outside",
		        					   "Your adopted",
		        					   "Ogres are like onions",
		        					   "Helmets are useless",
		        					   "Brush your teeth with bacon and soda"
								      };

		fortuneMessage = new String[] {"House without toilet is uncanny",
    								   "Man with one chopstick go hunry",
    								   "Man who throw a cat out car window makes kitty litter",
    								   "Man who pushes piano down mineshaft get tone A flat miner",
    								   "He who has a sharp tongue cuts own throat",
    								   "He who stick head in open window get pane in neck",
    								   "Man who jumps off cliff, jumps to conclusion",
    								   "Man who drop watch in whisky is wasting time"
								   	   };

		fortuneCookie =   new FortuneCookie(fortuneMessage);
		magicEightBall =  new MagicEightBall();
		magicPirateBall = new MagicPirateBall();
		parentalAdvice =  new ParentalAdvice(parentsMessage);
		test =            new Advice[4];

		test[0] = fortuneCookie;
		test[1] = magicEightBall;
		test[2] = magicPirateBall;
		test[3] = parentalAdvice;

		for(int i = 0; i < test.length; i++)
		{
			System.out.println(test[i].getAdviceAsSentance());
		}
	}
}