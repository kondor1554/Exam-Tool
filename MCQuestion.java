
//Christian Haro - charo3
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class MCQuestion extends Question {

	protected MCQuestion(String text, Double MaxValue) {
		super(text, MaxValue);
	}
	
	protected MCQuestion(Scanner sn)
	{
		super(sn);
	}
	
	

	//ArrayLists so that we can have as many Answers as we want. Built in functions
	protected ArrayList<MCAnswer> answerList = new ArrayList<MCAnswer>();

	@Override
	public void print() {
		
		super.print();
		String Qoutput;
		int i = 1;
		for (Answer var : answerList) 
		{
			
			char Letter = (char) (i++ + 64);
			Qoutput = String.format("\t%c:",Letter );
			System.out.print(Qoutput);
			var.print();
			
		}
	}

	/* Add an Answer to a Question. By default new answers are added to
	the end of the existing list.*/
	public void AddAnswer(MCAnswer ans)
	{
		answerList.add(ans);
	}
	
	/* Randomly reorders the Answers within the Question.*/
	public void reorderAnswers()
	{
		//thank god for built in java library
		Collections.shuffle(answerList);
	}
	
	public double getValue(MCAnswer ans)
	{
		double val = 0;
		for (Answer var : answerList) 
		{
			val += ((MCAnswer) var).getCredit(ans);	
		}
		return val * maxValue;
	}

	
	public void save(PrintWriter pr)
	{
		
		pr.println(answerList.size());
		for (Answer var: answerList)
		{
			var.save(pr);
		}
	}
}
