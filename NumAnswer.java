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
public class NumAnswer extends Answer
{ 
//---------------------- Attributes
	protected String text;
//---------------------- Constructors
	public NumAnswer(){this("** Invalid value entered **");}
	public NumAnswer(String txt) { this.text = txt;}
	public NumAnswer(Scanner s) 
	{ 
		try
		{
     		text = s.nextLine();
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
		if (rightAnswer instanceof NumAnswer)
		{
		//	NumAnswer na = (NumAnswer)rightAnswer;
			//if (this.text.equalsIgnoreCase(na.text))
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