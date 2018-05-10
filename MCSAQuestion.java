import java.util.*;
import java.io.*;

//Konrad Kurzynowski
//kkurzy4

public class MCSAQuestion extends MCQuestion{

	public MCSAQuestion (String str, double max) {
		super(str, max);
		return;
	}
	
	public MCSAQuestion(Scanner sc) {
		super(sc);
		int numAnswers = sc.nextInt();
		sc.nextLine();
		int i = 0;
		MCSAAnswer mcsaa;
		for (i = 0; i < numAnswers; i++) {
			mcsaa = new MCSAAnswer(sc);
			if (mcsaa.creditIfSelected == 1.0) {
				this.rightAnswer = mcsaa;
			}
			this.answerList.add(mcsaa);
		}
		return;
	}
	
	public Answer getNewAnswer () {
		
		MCSAAnswer ans = new MCSAAnswer(null, 0.0);
		return ans;
		
	}
	
	public Answer getNewAnswer (String str) {
		
		MCSAAnswer ans = new MCSAAnswer(str, 0.0);
		return ans;
		
	}
	
	public Answer getNewAnswer (String str, double creditIfSelected) {
		
		MCSAAnswer ans = new MCSAAnswer(str, creditIfSelected);
		return ans;
		
	}
	
	public void getAnswerFromStudent (String s) {
		
		//Scanner input = ScannerFactory.getKeyboardScanner();
		//String s = input.nextLine();
		char c = Character.toUpperCase(s.charAt(0));
		int choice = c - 'A';
		
		if (choice < 0 || choice >= this.answerList.size() || choice == 18) {
			return;
		}
		
		this.studentAnswer = this.answerList.get(choice);
		
		int size = this.answerList.size();
		int i = 0;
		for (i = 0; i < size; i++) {
			this.answerList.get(i).setSelected(false);
		}
		this.answerList.get(choice).setSelected(true);
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
	
	public double getValue(MCSAAnswer ans) {
		return super.getValue(ans);
	}
	
	public void save(PrintWriter pw) {
		pw.println("MCSAQuestion");
		pw.println(maxValue);
		pw.println(text);
		super.save(pw);
	}
	
	public void saveStudentAnswer(PrintWriter pw) {
		MCSAAnswer mcsaa = (MCSAAnswer) this.studentAnswer;
		pw.println(mcsaa.answer);
		pw.println("");
		return;
	}
	
	public void restoreStudentAnswer(Scanner sc) {
		
	}
}
