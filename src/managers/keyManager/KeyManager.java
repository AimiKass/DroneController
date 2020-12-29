package managers.keyManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyManager implements KeyListener
{
	protected boolean[] keys;
	
	protected  JTextArea textArea;
	
	public KeyManager(JTextArea textArea)
	{
		this.textArea = textArea;
		keys = new boolean[256];
	}
	
	public abstract void tick();
	
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
