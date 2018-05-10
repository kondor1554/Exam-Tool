import java.io.PrintWriter;
import java.util.Scanner;

//Christian Haro - charo3

public abstract class Question {

	
	protected String text;

	protected Answer studentAnswer;
	protected Answer rightAnswer;
	
	
	//this is going to be updated internally by the select answer method
	protected double maxValue;
	
	protected Question(String text, Double MaxValue)
	{
		this.text = text;
		this.maxValue = MaxValue;
	}
	
	public Question(Scanner sn)
	{
		this.maxValue = sn.nextDouble();
		sn.nextLine();
		this.text = sn.nextLine();

	}
	
	

	
	
	
	/* Prints the question to the screen, along with all of its answers. The
	*input parameter indicates the position of this question in the list of questions, 1 for the first
	*question, 2 for the second, and so on.
	*
	*
	*/
	public void print()
	{
		
		System.out.println(text);

	}
	
	
	public void setRightAnswer(Answer ans)
	{
		rightAnswer = ans;
	}
	
	public abstract Answer getNewAnswer();

	public abstract void getAnswerFromStudent();
	
	public abstract double getValue();
	
	public abstract void save(PrintWriter pw);
	
	public void saveStudentAnswer(PrintWriter pw)
	{
		if(studentAnswer instanceof MCSAAnswer )
		{

			pw.println("MCSAAnswer");
			pw.println(((MCSAAnswer) studentAnswer).answer);
		}
		else if(studentAnswer instanceof SAAnswer)
		{
			pw.println(((SAAnswer) studentAnswer).text);
			pw.println("");
		}	
		
	}
	
	/** i'm not going to use this
	 * @deprecated
	 */
	public void restoreStudentAnswers(Scanner sn)
	{
	}
	
	/** selects the Answer in the given position. This may or may
	*not require unselecting other previously selected Answers.
	* @deprecated
	*/
//	public void selectAnswer( int position )
//	{
//		//deslect others?
//		for (Answer var : answers) {
//			var.setSelected(false);
//		}
//
//		answers.get(position).setSelected(true);
//		this.valueAnswer = answers.get(position).getValue();
//		
//	}	
	/* unselects the Answer in the given position.*/
//	public void unselectAnswer( int position )
//	{
//		answers.get(position).setSelected(false);
//	}
	
	
	
	
	
}
