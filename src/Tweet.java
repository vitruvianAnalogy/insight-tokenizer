import java.util.*;


public class Tweet {
	
	private String value;	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Tweet getByValue(String value){
		if(this.value.equals(value)){
			return this;
		}else
			return null;
	}
	
	//Since a Tweet can occur in multiple files
	private ArrayList<String> fileName;
	public ArrayList<String> getFileName() {
		return fileName;
	}
	public void setFileName(ArrayList<String> fileNames) {
		this.fileName = fileNames;
	}
	public void addToListOfFileNames(String fileName) {
		this.fileName.add(fileName);
	}
	
	
	HashSet<String> uniqueTokens = new HashSet<String>();
	public void setUniqueTokens(String[] tokens) {
		for(String token : tokens)
			this.uniqueTokens.add(token);
	}
	public HashSet<String> getUniqueTokens() {
		return uniqueTokens;
	}
	
	
	private ArrayList<String> tokens;
	public ArrayList<String> getTokens() {
		return tokens;
	}
	public void setTokens(String[] tokens) {
		for(String token : tokens)
			this.tokens.add(token);
	}
	
	//Constructor
	public Tweet(String value, String fileName){
		this.setValue(value);
		this.addToListOfFileNames(fileName);
	}
	

	
}
