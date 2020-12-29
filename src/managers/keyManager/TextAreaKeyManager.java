package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TextAreaKeyManager extends KeyManager
{
	
	public boolean up, down, left, right;
	
	private long startTime = 0;
	
	private boolean pressedOnesIs = false;
	
	private int lettersInTextArea = 1;
	private final int BACKSPACE_KEY = 8;
	
	public TextAreaKeyManager(JTextArea textArea)
	{
		super(textArea);
	}

	
	
	public void tick()
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
			pressedOnesIs = false;
			System.out.println("Time:"+((System.nanoTime()-startTime)/1000000)+" ms");
			
			// TODO: 12/29/2020 -error when pressed two keys at the same time-
			textArea.replaceRange("",lettersInTextArea,textArea.getText().length());
//			textArea.append("Time:"+((System.nanoTime()-startTime)/1000000)+" ms");  TODO: 12/29/2020 -need extra  thought-
			lettersInTextArea ++;
		}
		
		// if you press backspace more than the characters in the textArea restores the value of lettersInTextArea
		if (lettersInTextArea < 1)
			lettersInTextArea = 1;
		
		System.out.println("letters:"+lettersInTextArea);
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
