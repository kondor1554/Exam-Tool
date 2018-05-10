import java.util.*;
//import java.io.*;

//Konrad Kurzynowski
//kkurzy4

public class MCSAAnswer extends MCAnswer{

	public MCSAAnswer (String str, double creditIfSelected) {
		super(str, creditIfSelected);
		return;
	}
	
	public MCSAAnswer(Scanner sc) {
		super(sc);
		return;
	}
	
	protected double getCredit (MCSAAnswer rightAnswer) {
		return super.getCredit(rightAnswer);
	}

}
