package managers.keyManager;

import models.RecordedKey;
import otherFunctions.Database;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

// TODO: 2/25/2021 you can make a TextArea Controller and
//  break up the code to smaller sections
public class TextAreaKeyListener implements KeyListener
{
	protected  JTextArea textArea;
	
	private boolean pressedOnesIs = false;
	
	private HashSet<RecordedKey> recordedKeys = new HashSet<>();
	private Set<Integer> pressed = new HashSet<>();
	
	private long startTime = 0;
	
	private int lettersInTextArea = 0;
	
	private final int BACKSPACE_KEY = 8;
	
	private Database database;
	
	
	
	public TextAreaKeyListener(JTextArea textArea)
	{
		this.textArea = textArea;
		database = new Database();
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == BACKSPACE_KEY)
			lettersInTextArea--;
		else {
			pressed.add(e.getKeyCode());
			
			if (!pressedOnesIs)
			{
				startTime = System.nanoTime();
				pressedOnesIs = true;
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		
		pressed.remove(e.getKeyCode());
		if (e.getKeyCode() != BACKSPACE_KEY)
		{
			pressedOnesIs = false;
			
			textArea.replaceRange("",lettersInTextArea,textArea.getText().length());
			
			long totalTime = (System.nanoTime() - startTime);
			textArea.append("Time the key \""+e.getKeyChar()+"\" pressed :"+((System.nanoTime()-startTime)/1000000)+" ms");
			textArea.append("\n");
			
			lettersInTextArea += (21 + String.valueOf(totalTime).length() + 3) ;
			
			
			// TODO: 2/25/2021 reset dataBase
			if (database.getRecordingButtonIs())
				database.setRecordedFly(Character.toString(e.getKeyChar())+"."+Long.toString(totalTime));
		}
		
		if (lettersInTextArea < 1)
			lettersInTextArea = 1;
		
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	
	}
	
	
	public Set<Integer> getPressed()
	{
		return pressed;
	}
	
	public HashSet<RecordedKey> getRecordedKeys()
	{
		return recordedKeys;
	}
}