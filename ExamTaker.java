import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//import java.time.LocalDateTime;

// Konrad Kurzynowski
// kkurzy4

public class ExamTaker {

	public ExamTaker() {
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Name : Konrad Kurzynowski");
		System.out.println("Netid : kkurzy4");
		System.out.println("\n");
		System.out.println("Welcome to ExamTaker. If at any point you wish to skip a question, type 's' as an answer.");
		System.out.println("Student Information will be taken at the end of the examination.");
		System.out.println("\n");
		
		Scanner sc, in;
		PrintWriter pw;

		try {
			sc = new Scanner(new File("sample exam file2.txt"));
			pw = new PrintWriter(new File("sample answer file2.txt"));
			Exam examA = new Exam(sc);
			examA.print();
			examA.getAnswerFromStudent(-1);
			in = ScannerFactory.getKeyboardScanner();
			System.out.println("Do you need to go back to a question? (enter 'yes' if you skipped questions)");
			String line = in.nextLine();
			while (line.contentEquals("yes")) {
				System.out.println("Enter question number to go back to.");
				int num = in.nextInt();
				examA.getAnswerFromStudent(num);
				System.out.println("Do you need to go back to a question? (enter 'yes' if you skipped questions)");
				line = in.nextLine();	
			}
			examA.saveStudentAnswers(pw);
			sc.close();
			pw.close();
			return;
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
