import java.io.*;
import java.util.*;
import java.util.Map.*;


public class ManagerApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = args[0];
		String delimiters = "";
		
		//First task is to create a Tokenizer that tokenizes the text and store it in a DS
		Tokenizer myTokenizer = new Tokenizer();
		try 
		{
			//Tokenizing tweets from the file
			myTokenizer.tokenize(delimiters, fileName);
			
			//FEATURE ONE : PRINT TOKENS AND THEIR FREQUENCIES
			HashMap<String,Integer> myTokens = myTokenizer.getMyTokens();
			for (String token : myTokens.keySet()){
				System.out.println(token + " " +myTokens.get(token).intValue());
			}
			
			//FEATURE TWO : PRINT MEDIAN OF UNIQUE TOKENS
			HashMap<Integer,Tweet> myTweets = myTokenizer.getMyTweets();
			for(Entry<Integer, Tweet> myTweet : myTweets.entrySet()){
				
			}
			

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Second task is to call feature one
	}

}
