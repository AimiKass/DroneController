package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TextAreaKeyListener extends KeyManager
{
	
	public boolean up, down, left, right ,stop = false;
	
	private long startTime = 0;
	
	private boolean pressedOnesIs = false;
	
	private int lettersInTextArea = 0;
	private final int BACKSPACE_KEY = 8;
	
	public TextAreaKeyListener(JTextArea textArea)
	{
		super(textArea);
	}

	
	
	public void updateKeys()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == BACKSPACE_KEY)
			lettersInTextArea--;
		else {
			if (!pressedOnesIs)
			{
				stop = false;
				keys[e.getKeyCode()] = true;
				startTime = System.nanoTime();
				
				pressedOnesIs = true;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
		
		if (e.getKeyCode() != BACKSPACE_KEY)
		{
			stop = true;
			
			pressedOnesIs = false;
			System.out.println("Time:"+((System.nanoTime()-startTime)/1000000)+" ms");
			
			// TODO: 12/29/2020 -error when pressed two keys at the same time-
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
}