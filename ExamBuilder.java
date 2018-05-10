
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExamBuilder{

	public static void main(String[] args) {
		
		/**
		* Exam Builder  
		*
		* @author Christian Haro
		* @version 3.0
		* @since 2018-01-30
		*/


		
		
		try {
			System.out.println("Exam Builder");
			File file = new File("input.txt");
			Scanner fileReader = new Scanner(file);
			
			

			Exam ex = new Exam(fileReader);
			

			fileReader.close();
            
			ex.print();
			
			Scanner in = ScannerFactory.getKeyboardScanner();
			
			String cmnd = null;
			do
			{
				cmnd = null;
				System.out.println("INPUT COMMAND (SINGLE CHAR ONLY)");
                System.out.println("a - load exam");
				System.out.println("b - Saves the exam");
				System.out.println("c - Add Question");
				System.out.println("d - delete Question");
                System.out.println("r - Reorder the exam");
                //HAVE AN OPTION TO PRINT HARD COPY
				System.out.println("p - Print out the exam");
				System.out.println("q - Quits the application");
				
				cmnd = in.nextLine().toLowerCase();

                if(cmnd.equals("a")){ 
                        //maybe have these in methods?
                        file = new File("output.txt");
					    fileReader = new Scanner(file);					
					    ex = new Exam(fileReader);
					    fileReader.close();
				}else if(cmnd.equals("b"))
				{
                        PrintWriter pw = new PrintWriter("output.txt");	
					    ex.save(pw);
                        pw.close();
				}
				else if(cmnd.equals("c"))
				{
					addInteractiveQuestion(ex);
				}
				else if(cmnd.equals("d"))
				{
					System.out.println("Question # to delete");
					int val = in.nextInt() - 1;
					in.nextLine();
					ex.deleteQuestion(val);
				}
				else if(cmnd.equals("r"))
				{
					ex.reorderQuestions();
                    ex.print();
				}
				else if(cmnd.equals("p"))
				{
					ex.print();
				}

                
				//the tricky shit...
				//there may be a better tool of this (Switch Statments?) but as it stands I needed something dirty
				//inputs aren't thouroughly checked
				
			}while(!cmnd.equalsIgnoreCase("q"));
			
			in.close();
			//????
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}


	//STILL NEEDS WORK
    public static void addInteractiveQuestion(Exam ex)
    {
		double value;
		Scanner in = ScannerFactory.getKeyboardScanner();
		System.out.println("Question Type? (i.e numquestion , mcsaquestion, mcmaquestion, saquestion");
		System.out.println("Print Exact");
		String line = in.nextLine().toLowerCase();
		if(line.equals("numquestion"))
		{
			System.out.println("Point Value?");
			value = in.nextDouble();
			in.nextLine();

			System.out.println("Question?");
			line = in.nextLine();
			//pucking puck puck
			System.out.println("Answer?");
			double a = in.nextDouble();
			in.nextLine();
			String Answer = Double.toString(a);

			
			System.out.println("tolerance?");
			double tolvalue = in.nextDouble();
			in.nextLine();	
			NumQuestion q2 = new NumQuestion(line, value, tolvalue);		
			q2.setRightAnswer(q2.getNewAnswer(Answer));
			ex.AddQuestion(q2);
		}
		if(line.equals("mcsaquestion"))
		{
			System.out.println("Point Value?");
			value = in.nextDouble();
			in.nextLine();
			System.out.println("Question?");
			line = in.nextLine();

			MCSAQuestion q1 = new MCSAQuestion(line,value);
			System.out.println("Number of Answers?");
			in.nextLine();
			int size = in.nextInt();
			for(int i = 0; i<size;i++)
			{
				System.out.println("Answer Value?");
				value = in.nextDouble();
				in.nextLine();
				System.out.println("Answer Text?");
				line = in.nextLine();
				
				q1.AddAnswer((MCAnswer) q1.getNewAnswer(line, value));
			}		
			ex.AddQuestion(q1);					
		}
		if(line.equals("saquestion"))
		{
			System.out.println("Point Value?");
			value = in.nextDouble();
			in.nextLine();
			System.out.println("Question?");
			line = in.nextLine();
			SAQuestion q2 = new SAQuestion(line, value);
			
			System.out.println("Answer?");
			line = in.nextLine();
			q2.setRightAnswer(q2.getNewAnswer(line));
			ex.AddQuestion(q2);
		}
		if(line.equals("mcmaquestion"))
		{

			System.out.println("Point Value?");
			value = in.nextDouble();
			in.nextLine();
			System.out.println("Question?");
			line = in.nextLine();
			System.out.println("Base Value?");
			double baseValue = in.nextDouble();
			in.nextLine();
			
			MCMAQuestion q3 = new MCMAQuestion(line,value,baseValue);
			System.out.println("Num of Answers?");
			int size = in.nextInt();
			
			for(int i = 0; i<size;i++)
			{
				System.out.println("Answer Value?");
				value = in.nextDouble();
				in.nextLine();
				System.out.println("Answer Text?");
				line = in.nextLine();
				q3.AddAnswer((MCMAAnswer) q3.getNewAnswer(line, value));
			}		
			ex.AddQuestion(q3);	
		}
    }
}