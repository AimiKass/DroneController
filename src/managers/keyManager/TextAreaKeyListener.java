package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class TextAreaKeyListener implements KeyListener
{
	protected  JTextArea textArea;
	
	private boolean pressedOnesIs = false;
	private long startTime = 0;
	
	private int lettersInTextArea = 0;
	private final int BACKSPACE_KEY = 8;
	
	
	private Set<Integer> pressed = new HashSet<>();
	
	
	public TextAreaKeyListener(JTextArea textArea)
	{
		this.textArea = textArea;
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
}