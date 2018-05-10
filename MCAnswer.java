import java.util.*;
import java.io.*;

//Konrad Kurzynowski
//kkurzy4

public abstract class MCAnswer extends Answer{

	protected String answer;
	protected boolean selected;
	protected double creditIfSelected;
	
	protected MCAnswer (String str, double credit) {
		
		this.answer = str;
		this.creditIfSelected = credit;
		this.selected = false;
		return;
		
	}
	
	public MCAnswer(Scanner sc) {
		if (sc.hasNextDouble()) {
			this.creditIfSelected = sc.nextDouble();
		}
		this.answer = sc.nextLine();
		this.selected = false;
		return;
	}
	
	public void MCAnswer2(Scanner sc) {
		this.answer = sc.nextLine();
		this.selected = false;
		return;
	}
	
	public void print () {
		if (selected) {
			System.out.print("* ");
		}
		System.out.print(this.answer);
		System.out.println("\n");
		return;
	}
	
	public void setSelected (Boolean bool) {
		
		this.selected = bool;
		return;
		
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public double getCredit(Answer rightAnswer) {
		return selected ? creditIfSelected : 0;
	}
	
	public void save(PrintWriter pw) {
		pw.print(this.creditIfSelected + " ");
		pw.print(this.answer);
		pw.println("");
		return;
	}
}
