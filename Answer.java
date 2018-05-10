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
public abstract class Answer // abstract class
{
	Answer(){  }
	Answer(Scanner s){  }
	public abstract void print();
	public abstract double getCredit(Answer rightAnswer);
	public abstract void save(PrintWriter pw);
}
//------------------------------------------------------

