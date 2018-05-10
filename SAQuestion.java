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
public class SAQuestion extends Question
{
//---------------------- Constructors
	public SAQuestion(){this("** Invalid value entered **");}
	public SAQuestion(String txt) {super(txt, 0.0);}
	public SAQuestion(Scanner s) 
	{
		super(s);
		try
		{
     		rightAnswer = new SAAnswer(s);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
	}
	public SAQuestion(String txt, double maxVal) { super(txt,maxVal); }
//---------------------- Methods
	public SAAnswer getNewAnswer()
	{
		SAAnswer answer = new SAAnswer();
		return answer;
	}
//----------------------
	public SAAnswer getNewAnswer(String txt)
	{
		SAAnswer answer = new SAAnswer(txt);
		return answer;
	}
//----------------------
	public void getAnswerFromStudent()
	{
		print();
		Scanner scan = ScannerFactory.getKeyboardScanner();
		String input = null;
		input = scan.nextLine();
		if (input.contentEquals("s")) {
			return;
		}
		studentAnswer = new SAAnswer(input);
	}
//----------------------
	public double getValue()
	{
		double val = studentAnswer.getCredit(rightAnswer);
		return val;
	}
//----------------------
	public void save(PrintWriter pw)
	{
		pw.println("SAQuestion");
		pw.println(maxValue);
		pw.println(text);
		rightAnswer.save(pw);
		pw.println("");
	}
//----------------------
}
//------------------------------------------------------