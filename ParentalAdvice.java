/*
	Ian Christopherson
	CISC 230
	Dr. Jarvis
	3/24/15
*/

import java.util.*;
import java.io.*;
public class ParentalAdvice extends UnSolicitedAdvice
{
/*
	Ian Christopherson
	March 26, 2015

	The purpose of this class is to create an object which
	gives us advice from parents

	Constructor:
		public ParentalAdvice(String[] advice)
			Uses super to call on the hierarchy and allows us
			to add advice to ParentalAdvice using the driver

		public ParentalAdvice(File file) throws IOException
			Uses super to call on the hierarchy and allows us
			to add advice to ParentalAdvice using a file

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

    public ParentalAdvice(String[] advice)
    {
        super(advice);
    }//Constructor for FortuneCookie

    public ParentalAdvice(File file) throws IOException
    {
		super(file);
	}//Constructor for FortuneCookie importing files


    public String getAdviceGiverName()
    {
        return "Parental Advice";
    }//Returns what the advice giver's name is
}