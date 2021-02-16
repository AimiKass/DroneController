package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// TODO: 2/15/2021 i do not think you will need that anymore
public abstract class KeyManager implements KeyListener
{
	protected boolean[] keys;
	
	protected  JTextArea textArea;
	
	public KeyManager(JTextArea textArea)
	{
		this.textArea = textArea;
		keys = new boolean[256];
	}
	
	
	@Override
	public void keyPressed(KeyEvent e)
	{
	
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
	
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	
	}
	
}
