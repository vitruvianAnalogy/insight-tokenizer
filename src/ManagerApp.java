import java.io.*;
import java.util.*;


public class ManagerApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = System.getProperty("user.dir")+File.separator+"tweet_input"+File.separator+"tweets.txt";
		String outPutFileName1 = System.getProperty("user.dir")+File.separator+"tweet_output"+File.separator+"ft1.txt";
		String outPutFileName2 = System.getProperty("user.dir")+File.separator+"tweet_output"+File.separator+"ft2.txt";
		String delimiters = " ";
		
		//First task is to create a Tokenizer that tokenizes the text and store it in a DS
		Tokenizer myTokenizer = new Tokenizer();
		try 
		{
			//Tokenizing tweets from the file
			myTokenizer.tokenize(delimiters, fileName);
			
			//Calling Feature 1
			TreeMap<String,Integer> myTokens = myTokenizer.getMyTokens();
			myTokenizer.writeFile(outPutFileName1, myTokens);
			
			//Calling Feature 2
			float[] median = myTokenizer.medianUniqueTokens();
			myTokenizer.writeFile(outPutFileName2,median);

		} 
		catch (IOException ex) 
		{
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
		
	}

}
