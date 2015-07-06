
public class Token{

	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	private int frequency;
	public int getFrequency() {
		return frequency;
	}
	
	public Token getTokenByValue(String value){
		if(this.value.equals(value)){
			return this;
		}
		else
			return null;
	}
	public Token(String value){
		this.value = value;
		this.frequency = this.frequency + 1;
	}

}