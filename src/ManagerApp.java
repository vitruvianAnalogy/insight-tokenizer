import java.io.*;
import java.util.*;


public class ManagerApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = args[0];
		String outputFileName = args[1];
		String delimiters = " ";
		
		//First task is to create a Tokenizer that tokenizes the text and store it in a DS
		Tokenizer myTokenizer = new Tokenizer();
		try 
		{
			//Tokenizing tweets from the file
			myTokenizer.tokenize(delimiters, fileName);
			
			//Calling Feature 1
			myTokenizer.printTokenFrequencies();
			
			//Calling Feature 2
			float[] median = myTokenizer.medianUniqueTokens();
			myTokenizer.writeFile()

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Second task is to call feature one
	}

}
