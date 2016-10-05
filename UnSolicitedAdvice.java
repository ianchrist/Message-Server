/*
	Ian Christopherson
	CISC 230
	Dr. Jarvis
	3/24/15
*/

import java.util.*;
import java.io.*;
abstract public class UnSolicitedAdvice extends Advice
{
/*
	Ian Christopherson
	March 26, 2015

	This class will allow us to use our unsolicited advice,
	including both parental advice and fortune cookie

	Constructor:
		public UnSolicitedAdvice(String[] advice)
			Allows us to create UnSolicitedAdvice

		public UnSolicitedAdvice(File file) throws IOException
			Allows us to create UnSolicitedAdvice using a file

	Methods:
		public String getAdviceType()
			Returns what type of advice is being given

	Modification History:
		March 26, 2015
			Original Version

		April 4, 2015
			Changes the constructor to allow for
			a string array to be entered
*/
    public UnSolicitedAdvice(String[] advice)
    {
        super(advice);
    }//Constructor for UnSolicitedAdvice

    public UnSolicitedAdvice(File file) throws IOException
    {
		super(file);
	}//Constructor for UnSolicitedAdvice importing files

    public String getAdviceType()
    {
        return "UnSolicited Advice";
    }//Returns what type of advice is being given

}