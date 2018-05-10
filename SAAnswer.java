/*
 * Author name: Diana Vera
 * netID: dvera6
 * CS 342
 *
*/
//******************************************************
import java.util.*;
import java.io.*;
//------------------------------------------------------
public class SAAnswer extends Answer
{ 
//---------------------- Attributes
	protected String text;
//---------------------- Constructors
	public SAAnswer(){this("** Invalid value entered **");}
	public SAAnswer(String txt) { text = txt;}
	public SAAnswer(Scanner s) 
	{ 
		try
		{
     		text = s.nextLine();
     		text = text.trim();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
	}
//---------------------- Methods
	public void print()
	{
		System.out.println(text);
	}
//----------------------
	public double getCredit(Answer rightAnswer)
	{
		if (rightAnswer instanceof SAAnswer)
		{
			SAAnswer sa = (SAAnswer)rightAnswer;
			if (this.text.equalsIgnoreCase(sa.text))
				return 1.0;
		}
		return 0.0;
	}
//----------------------
	public void save(PrintWriter pw)
	{
		pw.println(text);
	}
//----------------------
}
//------------------------------------------------------