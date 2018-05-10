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
public class ExamGrader
{
	public static void main(String[] args)
	{
		try
		{
			String afile = null;
			String efile = null;
			Scanner escan = null;
			Scanner ascan = null;
			System.out.println("ExamGrader");
			if (args.length == 0)
			{
				System.out.println("Enter name of answer file ending in '.txt'");
				Scanner s = ScannerFactory.getKeyboardScanner();
				afile = s.nextLine();
				File a = new File(afile);
				ascan = new Scanner(a);
				efile = ascan.nextLine();
				File e = new File(efile);
				escan = new Scanner(e);

			}
			else
			{
				for (String s: args) 
				{
					System.out.println(s);
					File a = new File(s);
					ascan = new Scanner(a);
					efile = ascan.nextLine();
					File e = new File(efile);
					escan = new Scanner(e);

				}

			}
			Exam exam = new Exam(escan);
			PrintWriter pw = new PrintWriter("studentCSV.csv");
			//ascan.skip("[\r\n]+");
			StringBuffer header = new StringBuffer("");
			StringBuffer data = new StringBuffer("");
			header.append("Name,TotalScore,QuestionScores\n");
			pw.write(header.toString());
			
			data.append(ascan.nextLine());
			data.append(",");
			data.append(10);
			data.append(",");
			data.append("11");
			data.append("\n");
			data.append("Test Name");
			data.append(",");
			data.append("10");
			data.append(",");
			data.append("14");
			data.append("\n");
			pw.write(data.toString());
			exam.print();
			exam.restoreStudentAnswers(ascan);
			exam.reportQuestionValues();
			//double d = exam.getValue();
			exam.print();
			ascan.close();
			escan.close();
			pw.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}



	}
}