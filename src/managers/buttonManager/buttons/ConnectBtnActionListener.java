package managers.buttonManager.buttons;

import managers.buttonManager.ButtonManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConnectBtnActionListener extends ButtonManager
{
	
	public ConnectBtnActionListener(JButton button)
	{
		super(button);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if (button.getText().equals("Connect"))
		{
			
			button.setText("Stop Connection");
			System.out.println("Connection has began");
			
		}else if (button.getText().equals("Stop Connection"))
		{
			button.setText("Connect");
			System.out.println("Connection has stopped");
			
		}
	}
	
}
