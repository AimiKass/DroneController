package managers.buttonManager.buttons;

import connections.WifiConnection;
import managers.buttonManager.ButtonManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConnectBtnManager extends ButtonManager
{
	
	public ConnectBtnManager(JButton button)
	{
		super(button);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		WifiConnection wifiConnection= new WifiConnection();
		

		if (button.getText().equals("Connect"))
		{
			wifiConnection.start();
			
			button.setText("Stop Connection");
			System.out.println("Connection has began");
			
		}else if (button.getText().equals("Stop Connection"))
		{
			wifiConnection.stop();
			
			button.setText("Connect");
			System.out.println("Connection has stopped");
			
		}
	}
	
	
	
	
	
}
