import java.io.*;
import java.util.*;

public class Tokenizer {
	
	@SuppressWarnings("unused")
	private BufferedReader reader;
	
	private HashMap<String,Integer> myTokens = new HashMap<String,Integer>();
	public HashMap<String, Integer> getMyTokens() {
		return myTokens;
	}	
	public void addToken(String token){		
		if(myTokens.containsKey(token))
			myTokens.replace(token, myTokens.get(token).intValue()+1);
		else
			myTokens.put(token, 1);		
	}
	public void addTokens(String[] tokens){		
		for(String myToken: tokens){
			addToken(myToken);			
		}		
	}	

	private HashMap<Integer,Tweet> myTweets = new HashMap<Integer,Tweet>();
	public HashMap<Integer,Tweet> getMyTweets() {
		return myTweets;
	}
	public void addMyTweets(Tweet myTweet) {
		myTweets.put(myTweets.size()+1, myTweet);
	}
	
	
	public int returnCountOfToken(String token){		
		int totalCount = 0;
		
		if(myTokens.containsKey(token))
			totalCount = myTokens.get(token).intValue();
		return totalCount;		
	}
	
	public BufferedReader readFile(String filename) throws FileNotFoundException{		
		//Reading file
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		return reader;		
	}

	public void tokenize(String delimiters, String fileName) throws IOException{

		@SuppressWarnings("unused")
		int tweetNumber = 0;
		
		String[] lineTokens = null;
		String line = null;

		BufferedReader reader = readFile(fileName);
		TweetsFile myFile = new TweetsFile(fileName);
		
		while((line = reader.readLine()) != null){
			tweetNumber++;
			
			//Each line stands for each Tweet
			Tweet myTweet = new Tweet (line, fileName);
			myFile.addToListOfTweets(myTweet);

			//split into tokens
			lineTokens = line.split(delimiters);
			//AddTokens to tweets
			myTweet.setTokens(lineTokens);
			//Add tokens to the token hashmap
			this.addTokens(lineTokens);
			this.addMyTweets(myTweet);
		}
	}
	
	public void writeFile(String fileName) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));		
	}

}
