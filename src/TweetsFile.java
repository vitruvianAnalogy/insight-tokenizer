import java.util.*;

public class TweetsFile {
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private ArrayList<Tweet> listOfTweets = new ArrayList<Tweet>();
	public ArrayList<Tweet> getListOfTweets() {
		return listOfTweets;
	}
	public void setListOfTweets(ArrayList<Tweet> listOfTweets) {
		this.listOfTweets = listOfTweets;
	}
	public void addToListOfTweets(Tweet myTweet){
		this.listOfTweets.add(myTweet);
	}
	
	public TweetsFile(String fileName)
	{
		this.setFileName(fileName);
	}
	
}
