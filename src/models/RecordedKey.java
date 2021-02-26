package models;

public class RecordedKey
{
	private char key;
	private long timeKeyIsPressed;
	
	public RecordedKey(char key, long timeKeyIsPressed)
	{
		this.key = key;
		this.timeKeyIsPressed = timeKeyIsPressed;
	}
	
	
	public char getKey()
	{
		return key;
	}
	
	public long getTimeKeyIsPressed()
	{
		return timeKeyIsPressed;
	}
}
