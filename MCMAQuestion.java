import java.util.*;
import java.io.*;

//Konrad Kurzynowski
//kkurzy4

public class MCMAQuestion extends MCQuestion{

	protected ArrayList<Answer> rightAnswers, studentAnswers;
	public double baseCredit;
	
	public MCMAQuestion(String str, double max, double baseCredit) {
		super(str, max);
		this.baseCredit = baseCredit;
		this.rightAnswers = new ArrayList<Answer>();
		this.studentAnswers = new ArrayList<Answer>();
		return;
	}
	
	public MCMAQuestion(Scanner sc) {
		super(sc);
		this.baseCredit = sc.nextDouble();
		sc.nextLine();
		int numAnswers = sc.nextInt();
		sc.nextLine();
		this.rightAnswers = new ArrayList<Answer>();
		this.studentAnswers = new ArrayList<Answer>();
		int i = 0;
		MCMAAnswer mcmaa;
		for (i = 0; i < numAnswers; i++) {
			mcmaa = new MCMAAnswer(sc);
			if (mcmaa.creditIfSelected > 0.0) {
				this.rightAnswers.add(mcmaa);
			}
			this.answerList.add(mcmaa);
		}
		return;
	}
	
	public Answer getNewAnswer () {
		
		MCMAAnswer ans = new MCMAAnswer(null, 0.0);
		return ans;
		
	}
	
	public Answer getNewAnswer (String str) {
		
		MCMAAnswer ans = new MCMAAnswer(str, 0.0);
		return ans;
		
	}
	
	public Answer getNewAnswer (String str, double creditIfSelected) {
		
		MCMAAnswer ans = new MCMAAnswer(str, creditIfSelected);
		return ans;
		
	}
	
	public void getAnswerFromStudent () {
		
		print();
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.println("Please answer question by typing in each letter choice seperated by a single space.");
		String s = input.nextLine();
		String [] ans = s.split(" ");
		int i , size = ans.length;
		for (i = 0; i < size; i++) {
			char c = Character.toUpperCase(ans[i].charAt(0));
			int choice = c - 'A';
		
			if (choice < 0 || choice >= this.answerList.size() || choice == 18) {
				return;
			}
		
			this.studentAnswers.add(this.answerList.get(choice));
		
		}
		return;
	}
	
	public double getValue () {
		
		double sum = 0.0;
		int size = this.answerList.size();
		int i = 0;
		for (i = 0; i < size; i++) {
			sum += this.answerList.get(i).getCredit(null);
		}
		return Math.min(1.0,  sum)*this.maxValue;
	}
	
	public void save(PrintWriter pw) {
		pw.println("MCMAQuestion");
		pw.println(maxValue);
		pw.println(text);
		pw.println(baseCredit);
		super.save(pw);
	}
	
	public void saveStudentAnswer(PrintWriter pw) {
		int size = this.studentAnswers.size();
		pw.println(size);
		int i = 0;
		MCMAAnswer mcmaa;
		for (i = 0; i < size; i++) {
			mcmaa = (MCMAAnswer) this.studentAnswers.get(i);
			pw.println(mcmaa.answer);
		}
		pw.println("");
	}
	
	public void restoreStudentAnswers(Scanner sc) {
		String line;
		int x = sc.nextInt();
		sc.nextLine();
		//SQUARE RUNTIME - SHIT FUCK FU"CK FUCK SHIT FUCK WHAT THE GUCK
		//IM SO SORRY
		//ILL FIX THISD LATER
		for(int i = 0; i < x; i++)
		{
			line = sc.nextLine();
			for(Answer ans : studentAnswers)
			{
				if(((MCAnswer)ans).answer.equals(line))
				{
					((MCAnswer)ans).selected = true;
					studentAnswers.add(ans);
				}			
			}
		}
	}
}
