package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class TextAreaKeyListener extends KeyManager
{
	
//	public boolean forward, backward, left, right ;
	
	private long startTime = 0;
	
	private int lettersInTextArea = 0;
	private final int BACKSPACE_KEY = 8;
	
	
	public Set<Integer> pressed = new HashSet<>();
	
	
	public TextAreaKeyListener(JTextArea textArea)
	{
		super(textArea);
	}
	
	
	public void updateKeys()
	{
//		forward = keys[KeyEvent.VK_W];
//		backward = keys[KeyEvent.VK_S];
//		left = keys[KeyEvent.VK_A];
//		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == BACKSPACE_KEY)
			lettersInTextArea--;
		else {
			startTime = System.nanoTime();
			pressed.add(e.getKeyCode());
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{

		pressed.remove(e.getKeyCode());
		
		if (e.getKeyCode() != BACKSPACE_KEY)
		{
			System.out.println("Time:"+((System.nanoTime()-startTime)/1000000)+" ms");
			
			// TODO: 12/29/2020 -error with time-
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