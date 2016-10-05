/*
    Ian Christopherson
    CISC 230
    Dr. Jarvis
    3/24/15
*/

import java.util.*;
import java.io.*;
public class MagicPirateBall extends MagicEightBall
{
/*
   Ian Christopherson
   March 25,2015

   The purpose of this class is to create an object
   which givues us advice in the form of a pirate
   magic eight ball
   
   Variables:
        Private static final String[] prefix
            Contains a list of prefixes for the pirate ball
   
        Private static final String[] suffix
            Contains a list of suffixes for the pirate ball
            
    Constructor:
        public MagicPirateBall()
            Allows us to get advice from the magic pirate ball
            
    Methods:
        public String getAdvice()
            Returns the advice from MagicPirateBall
            
        public String getAdviceGiverName()
            Returns the name of the advice giver
            
        private String getPirateTalk()
            Allows us to get advice in pirate speak
            
   Modification History:
        March 25, 2015
            Original Version
            
        March 26, 2015
            Put the list of pirate responses with the prefix
            and suffix variable
 */
    private static final String[] prefix = new String[] {"Arr, ",
                                                         "Grr, ",
                                                         "Blimey! ",
                                                         "Swab the poopdeck! ",
                                                         "Avast ye, ",
                                                         "Yo-ho-ho, ",
                                                         "Eyy matey, ",
                                                         ""
                                                        };
                                                        
    private static final String[] suffix = new String[] {" matey",
                                                         " sang Michael Bolton",
                                                         " ye",
                                                         " ye harty",
                                                         " or else walk the plank",
                                                         "... or not",
                                                         ""
                                                        };

    public MagicPirateBall()
    {
        super.getAdvice();
    }//Constructor for MagicPirateBall

    public String getAdvice()
    {
        return getPirateTalk();
    }//Returns the advice from MagicPirateBall

    public String getAdviceGiverName()
    {
        return "Magic Pirate Ball";
    }//Returns the name of the advice giver

    private String getPirateTalk()
    {
        return prefix[(int)(prefix.length*Math.random())] + super.getAdvice() + suffix[(int)(suffix.length*Math.random())];
    }//Allows us to get advice in pirate speak

}