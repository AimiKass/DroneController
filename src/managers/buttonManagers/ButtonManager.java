package managers.buttonManagers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ButtonManager implements ActionListener
{
	
	protected JButton button;
	
	public ButtonManager(JButton button)
	{
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	
	}
	
}
