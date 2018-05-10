
//Christian Haro - charo3
import java.util.*;
import java.io.*;
//import java.time.LocalDateTime;

public class Exam {
	
	
	private ArrayList<Question> questions = new ArrayList<Question>();
	private String text;
	
	//---------------------- Constructors
	/* A constructor for creating the Exam object. New Exams do not have Questions
	until they are added. The input parameter is the title / header of the exam, to be printed before
	the questions. ( Note that the title / header may consist of multiple lines. )*/
	public Exam( String param )
	{
		this.text = param;
	}
	
	
	
	public Exam (Scanner sc) {
		this.text = sc.nextLine();
		this.questions = new ArrayList<Question>();
		String line;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if (line.startsWith("NumQuestion")) {
				NumQuestion numq = new NumQuestion(sc);
				this.questions.add(numq);
			}
			if (line.startsWith("SAQuestion")) {
				SAQuestion saq = new SAQuestion(sc);
				this.questions.add(saq);
			}
			if (line.startsWith("MCSAQuestion")) {
				MCSAQuestion mcsaq = new MCSAQuestion(sc);
				this.questions.add(mcsaq);
			}
			if (line.startsWith("MCMAQuestion")) {
				MCMAQuestion mcmaq = new MCMAQuestion(sc);
				this.questions.add(mcmaq);
			}
		}
	}
	
	
	/* Add a Question to an Exam. By default new questions are added
	to the end of the existing list.*/
	public void AddQuestion(Question param) 
	{
		questions.add(param);
	}
	
	
	
	public void reorderMCAnswers(int position)
	{
		if(position >= 0 && position < questions.size()-1)
			if(questions.get(position) instanceof MCQuestion)
				((MCQuestion) questions.get(position)).reorderAnswers();
		else if(position < 0)
		{
			for (Question var : questions) 
			{ 
				if(var instanceof MCQuestion)
					((MCQuestion) var).reorderAnswers();
			}
		}
		else 
		{
			System.out.println("ERROR OUT OF BOUNDS");
		}
			
	}
	
	public void printQ(int position) {
		this.questions.get(position).print();
	}
	
	/* Prints the exam to the screen, along with all of its questions.*/
	public void print()
	{
		System.out.println(text);

		
		String Qoutput;
		int i = 1;
		for (Question var : questions) 
		{ 
			Qoutput = String.format("%d: ",i++ );
			System.out.print(Qoutput);
		   var.print();
		}
	}
	

	
	public void getAnswerFromStudent(int position) {
		
		int i = 0;
		int size = this.questions.size();
		
		if (position >= 0 && position < size) {
			
			this.questions.get(position).getAnswerFromStudent();
			
		}
		
		else if (position < 0) {
			
			for (i = 0; i < size; i++) {
				
				this.questions.get(i).getAnswerFromStudent();
				
			}
		}
		
	}
	
	/* Randomly reorders the Questions within the Exam.*/
	public void reorderQuestions()
	{
		System.out.println("Shuffling...");
		Collections.shuffle(questions);
		for(Question var: questions)
		{
			if(var instanceof MCQuestion)
				 ((MCQuestion) var).reorderAnswers();
		}
	}
	
	/* Get the overall value ( score ) of the exam. This method should work
	regardless of how many ( if any ) of the Questions have been answered*/
	public double getValue()
	{
		double value = 0;
		for (Question var : questions) 
		{ 
		   value += var.getValue();
		}
		return value;
	}
	// i added this method below vvvvv because it's 3am and i cant 
	// think of an easier way to get the # of questions from ExamGrader right now.
	// edit if need be! :-)
	public int getNumQuestions()
	{
		return questions.size();
	}
	
	public void reportQuestionValues()
	{
		System.out.println("Now reporting Values...");
		double max = 0;
		for (Question var : questions) 
		{ 
		   max += var.maxValue;
		   System.out.println(var.text);
		   System.out.print("Value: ");
		   System.out.println(var.maxValue);
		   
		}
		System.out.println("Max Exam total...");
		System.out.println(max);
	}
	
	public void save(PrintWriter pw)
	{
		pw.println(text);		
		//pw.println(LocalDateTime.now());
		pw.println();
		for(Question q : questions)
		{
			q.save(pw);
			pw.println();
		}
	}

	public void deleteQuestion(int val)
	{
		try {
			Question q1 = questions.remove(val);
			System.out.println("Removed");
			System.out.println(q1.text);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Out of bounds, try again");
			e.printStackTrace();
		}
		
	}
	
	/*public void saveStudentAnswers(PrintWriter pw)
	{
		Scanner in = ScannerFactory.getKeyboardScanner();
		System.out.println("Enter Student Name");
		String name = in.nextLine();
		pw.println(name);
		pw.println(this.text);
		//pw.println(LocalDateTime.now());
		pw.println();
		for(Question q : questions)
		{
			q.saveStudentAnswer(pw);
			pw.println();
		}
	}*/
	
	public void saveStudentAnswers (PrintWriter pw) {
		Scanner in = ScannerFactory.getKeyboardScanner();
		System.out.println("Enter Student Name");
		String name = in.nextLine();
		pw.println(name);
		pw.println(this.text);
		pw.println("");
		int size = this.questions.size();
		int i = 0;
		for (i = 0; i < size; i++) {
			if (this.questions.get(i) instanceof NumQuestion) {
				pw.println("NumAnswer");
				this.questions.get(i).saveStudentAnswer(pw);
			}
			if (this.questions.get(i) instanceof SAQuestion) {
				pw.println("SAAnswer");
				this.questions.get(i).saveStudentAnswer(pw);
			}
			if (this.questions.get(i) instanceof MCSAQuestion) {
				pw.println("MCSAAnswer");
				this.questions.get(i).saveStudentAnswer(pw);
			}
			if (this.questions.get(i) instanceof MCMAQuestion) {
				pw.println("MCMAAnswer");
				this.questions.get(i).saveStudentAnswer(pw);
			}
		}
		return;
	}
	
	/*public void restoreStudentAnswers(Scanner sn)
	{
		try{
		//sn.nextLine();
			sn.nextLine();
			String line = sn.nextLine();
			int count = 0;
			while (sn.hasNextLine()) 
			{				
			
				if(line.equals("MCSAAnswer"))
				{
					line = sn.nextLine();
					for(MCAnswer ans : ((MCSAQuestion)questions.get(count)).answerList)
					{
						if(ans.answer.equals(line))
						{
							ans.selected = true;
							questions.get(count).studentAnswer = ans;
							break;
						}
					}
				}
				if(line.equals("SAAnswer"))
				{
					line = sn.nextLine();
					questions.get(count).studentAnswer = ((SAQuestion)questions.get(count)).getNewAnswer(line);
				}
				if(line.equals("NumAnswer"))
				{
					line = sn.nextLine();
					questions.get(count).studentAnswer = ((NumQuestion)questions.get(count)).getNewAnswer(line);
				}
				if(line.equals("MCMAAnswer"))
				{
					((MCMAQuestion)questions.get(count)).restoreStudentAnswers(sn);
			
				
				}
				if(line.equals("NumAnswer"))
				{
					
					line = sn.nextLine();
					questions.get(count).studentAnswer = ((NumQuestion)questions.get(count)).getNewAnswer(line);	
				}
				sn.nextLine();
				if(sn.hasNextLine())
				line = sn.nextLine();
				count++;
			}
		}	

		catch (Exception ex)
		{
			ex.printStackTrace(); //delete later
		}
	}*/
	
	public void restoreStudentAnswers (Scanner sc) {
		this.text = sc.nextLine();
		String line;
		int size = this.questions.size();
		int i = 0, j = 0, k = 0, m = 0, n = 0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if (line.startsWith("SAAnswer")) {
				SAAnswer saa = new SAAnswer(sc);
				for (i = 0; i < size; i++) {
					if (this.questions.get(i) instanceof SAQuestion && this.questions.get(i).studentAnswer == null) {
						this.questions.get(i).studentAnswer = saa;
					}
				}
			}
			if (line.startsWith("MCSAAnswer")) {
				MCSAAnswer mcsaa = new MCSAAnswer(sc);
				MCSAQuestion mcsaq;
				MCSAAnswer mcsaa2;
				for (j = 0; j < size; j++) {
					if (this.questions.get(j) instanceof MCSAQuestion) {
						mcsaq = (MCSAQuestion) this.questions.get(j);
						int size2 = mcsaq.answerList.size();
						for (k = 0; k < size2; k++) {
							mcsaa2 = (MCSAAnswer) mcsaq.answerList.get(k);
							if (mcsaa2.answer.contains(mcsaa.answer)) {
								this.questions.get(j).studentAnswer = mcsaa;
							}
						}
					}
				}
			}
			if (line.startsWith("MCMAAnswer")) {
				int length = sc.nextInt();
				sc.nextLine();
				int a = 0;
				for (a = 0; a < length; a++) {
					MCMAAnswer mcmaa = new MCMAAnswer(sc);
					MCMAQuestion mcmaq;
					MCMAAnswer mcmaa2;
					for (m = 0; m < size; m++) {
						if (this.questions.get(m) instanceof MCMAQuestion) {
							mcmaq = (MCMAQuestion) this.questions.get(m);
							int size2 = mcmaq.answerList.size();
							for (n = 0; n < size2; n++) {
								mcmaa2 = (MCMAAnswer) mcmaq.answerList.get(n);
								if (mcmaa2.answer.contains(mcmaa.answer)) {
									mcmaq.studentAnswers.add(mcmaa);
								}
							}
						}
					}
				}
			}
		}
	}
}
	


