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
public class NumQuestion extends Question
{
	private double tolerance;
//---------------------- Constructors
	public NumQuestion(String txt, double maxVal, double Tolerance) 
	{
		super(txt, maxVal); 
		this.tolerance = Tolerance;
	}
	public NumQuestion(Scanner s) 
	{
		super(s);
	//	s.nextLine();
		
		//s.nextLine();
		try
		{
			 this.rightAnswer = new NumAnswer(s);
			 this.tolerance = s.nextDouble();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
	}
//---------------------- Methods
	public NumAnswer getNewAnswer()
	{
		NumAnswer answer = new NumAnswer();
		return answer;
	}
//----------------------
	public NumAnswer getNewAnswer(String txt)
	{
		NumAnswer answer = new NumAnswer(txt);
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
		studentAnswer = new NumAnswer(input);
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
		pw.println("NumQuestion");
		pw.println(maxValue);
		pw.println(text);	
		rightAnswer.save(pw);
	// delete later 
		pw.println(tolerance);
		pw.println("");
	}
	
	/*public void saveStudentAnswer(PrintWriter pw) {
		NumAnswer numa = (NumAnswer) this.studentAnswer;
		pw.println(saa.answer);
		return;
	}*/
//----------------------
	
//----------------------

}
//------------------------------------------------------