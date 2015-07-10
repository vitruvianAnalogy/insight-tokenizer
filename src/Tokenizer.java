import java.io.*;
import java.util.*;

public class Tokenizer {
	
	@SuppressWarnings("unused")
	private BufferedReader reader;
	
	/**
	 * The set of tokens and their frequencies and their getter and setter methods.
	 * Provides solution to Feature 1
	 */
	private TreeMap<String,Integer> myTokens = new TreeMap<String,Integer>();
	public TreeMap<String, Integer> getMyTokens() {
		return myTokens;
	}	
	public void addToken(String token){		
		if(myTokens.containsKey(token))
			myTokens.put(token, myTokens.get(token).intValue()+1);
		else
			myTokens.put(token, 1);		
	}
	public void addTokens(String[] tokens){		
		for(String myToken: tokens){
			addToken(myToken);			
		}		
	}	
			

	/**
	 *Feature 2 :  The feature the prints the median of unique tokens
	 */
	public float[] medianUniqueTokens(){
		//FEATURE TWO : PRINT MEDIAN OF UNIQUE TOKENS
		int tweetNumber = 0;
		float[] median = new float[myTweets.size()];
		for(Tweet myTweet : myTweets){
			tweetNumber++;
			if(tweetNumber%2 == 1)
			{
				int medianLocation = tweetNumber/2;
				median[tweetNumber-1]= (myTweets.get(medianLocation).getUniqueTokens().size());
				
			}
			else if(tweetNumber%2 == 0){
				int medianLocation1 = tweetNumber/2;
				int medianLocation2 = (tweetNumber/2) - 1;
				median[tweetNumber-1]=((float)myTweets.get(medianLocation2).getUniqueTokens().size() + (float)myTweets.get(medianLocation1).getUniqueTokens().size())/2;
			}
			
		}
		return median;
	}

	/**
	 * The set of tweets and their frequencies and their getter and setter methods.
	 */
	private ArrayList<Tweet> myTweets = new ArrayList<Tweet>();
	public ArrayList<Tweet> getMyTweets() {
		return myTweets;
	}
	public void addMyTweets(Tweet myTweet) {
		this.myTweets.add(myTweet);
	}
	
	//Returns count of a single token
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
			myTweet.setUniqueTokens(lineTokens);
			
			//Add tokens to the token hashmap
			this.addTokens(lineTokens);
			this.addMyTweets(myTweet);
		}
	}
	
	
	/**
	 *Feature 2 : The function that prints the frequencies of the tokens 
	 */
	public void writeFile(String fileName, float[] median) throws IOException{
		PrintWriter printer = new PrintWriter(new FileWriter(fileName));
		int counter = 0;
		while(counter!=median.length){
			printer.println(median[counter]);
			counter++;
		}
		printer.close();
	}
	
	/**
	 *Feature 1 : The function that prints the frequencies of the tokens 
	 */
	public void writeFile(String fileName, TreeMap<String, Integer> myTokens2) throws IOException {
		PrintWriter printer = new PrintWriter(new FileWriter(fileName));
		for (String token : myTokens.keySet()){
			printer.println(token + " " +myTokens.get(token).intValue());
		}
		printer.close();
		
	}


}
