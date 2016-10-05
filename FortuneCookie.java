/*
	Ian Christopherson
	CISC 230
	Dr. Jarvis
	3/24/15
*/

import java.util.*;
import java.io.*;
public class FortuneCookie extends UnSolicitedAdvice
{
/*
	Ian Christopherson
	March 26, 2015

	The purpose of this class is to create an object which
	gives us advice from a fortune cookie

	Constructor:
		public FortuneCookie(String[] advice)
			Uses super to call on the hierarchy and allows us
			to add advice to FortuneCookie using the driver

		public FortuneCookie(File file) throws IOException
			Uses super to call on the hierarchy and allows us
			to add advice to FortuneCookie using a file

	Methods:
		public String getAdviceGiverName()
			Returns what the advice giver's name is

	Modification History:
		March 26, 2015
			Original Version

		April 4, 2015
			Changes the constructor to allow for
			a string array to be entered

*/
    public FortuneCookie(String[] advice)
    {
    	super(advice);
    }//Constructor for FortuneCookie

    public FortuneCookie(File file) throws IOException
    {
		super(file);
	}//Constructor for FortuneCookie importing files

    public String getAdviceGiverName()
    {
        return "Fortune Cookie";
    }//Returns the name of the advice giver
}