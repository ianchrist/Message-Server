/*
    Ian Christopherson
    CISC 230
    Dr. Jarvis
    3/24/15
*/

import java.util.*;
import java.io.*;
abstract public class Advice implements Cloneable
{
/*
   Ian Christopherson
   March 24, 2015

   This class will be what allows all of the solicited and
   unsolicited advice to be used

   Variable:
        private String[] advice
            Contains the advice for other classes

   Constructor:
        public Advice(String[] advice)
            Initiates the advice variable

        public Advice(File file) throws IOException
            Initiates the advice variable containing a file

   Methods:
		public static Advice adviceFactory(String id)
			Returns a type of advice, depending on what is entered

		public static Advice adviceArray(int position)
			Contains an array of created advice

        public String getAdvice()
            Returns a piece of advice

        public String getAdviceAsSentance()
            Returns the advice along with who sent it

        private static String[] getAdviceFromFile(File dataFile) throws IOException
            Allows files to be imported

        abstract public String getAdviceType()
            Allows the advice type to be recieved

        abstract public String getAdviceGiverName()
            Tells the class wno sent the advice

    Modification History:
        March 24, 2015
            Original Version

        March 27, 2015
            Created the getAdviceFromFile method

        May 4, 2015
        	Added the factory method and adviceArray

 */
    private String[] advice;

    public Advice(String[] advice)
    {
        this.advice = advice.clone();
    }//Initiates the advice variable

    public Advice(File file) throws IOException
    {
        this.advice = getAdviceFromFile(file);
    }//Initiates the advice variable

    public static Advice adviceFactory(String id)
    {
        Advice adviceTypes;
        adviceTypes = null;
        id = id.toLowerCase();


        if (id.equals(">pirate") ||  id.equals(">pirate advice") || id.equals(">magic pirate ball"))
        {
            adviceTypes =  adviceArray(1);
        }

        else if (id.equals(">8 ball") || id.equals(">eight ball") || id.equals(">magic 8 ball") || id.equals(">magic eight ball"))
        {
            adviceTypes = adviceArray(0);
        }

        else if (id.equals(">fortune cookie"))
        {
            adviceTypes = adviceArray(2);
        }

        else if (id.equals(">parent") || id.equals(">parents") || id.equals(">parent advice") || id.equals (">parental advice"))
        {
            adviceTypes = adviceArray(3);
        }

        else
        {
			adviceTypes = adviceArray((int)(Math.random()*4));
		}


        return adviceTypes;
    }//Returns the type of advice depending on what is entered

    public static Advice adviceArray(int position)
    {
        String[] fortuneMessage;
        String[] parentsMessage;

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

        Advice[] adviceList = {new MagicEightBall(),
                               new MagicPirateBall(),
                               new FortuneCookie(fortuneMessage),
                               new ParentalAdvice(parentsMessage)
                              };

        return adviceList[position];
    }//Creates an array of the types of advice objects

    public String getAdvice()
    {
        return this.advice[(int)(advice.length*Math.random())];
    }//Returns the advice

    public String getAdviceAsSentance()
    {
        return getAdviceType() + " From " + getAdviceGiverName() + ": " + getAdvice();
    }//Returns the advice, advice giver, and what kind of advice

    private static String[] getAdviceFromFile(File dataFile) throws IOException
    {
        String[]       advice;
        Vector<String> adviceVector;
        int            i;
        BufferedReader input;
        String         record;


        adviceVector = new Vector<String>();
        i = 0;
        input = new BufferedReader(new FileReader(dataFile));
        record = input.readLine();

        while(record!=null)
        {
            adviceVector.add(record);
            i++;
        }
        advice = adviceVector.toArray(new String[0]);
        return advice;
    }//Allows files to be imported

    abstract public String getAdviceType();//Allows the class to recieve the advice type

    abstract public String getAdviceGiverName();//ALlows the class to recieve the advice giver name

}