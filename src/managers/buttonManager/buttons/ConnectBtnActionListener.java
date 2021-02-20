package managers.buttonManager.buttons;

import connections.Connection;
import connections.SendToDroneFrom;
import controllers.MainController;
import managers.buttonManager.ButtonManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConnectBtnActionListener extends ButtonManager
{
	
	
	
	public ConnectBtnActionListener(JButton button)
	{
		super(button);
//		connection = new Connection();
//		sendToDrone = new SendToDroneFrom(MainController.getConnection().getSocket());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if (button.getText().equals("Connect"))
		{
//			MainController.sendToDrone.directions(52000); //Arms the drone
//			button.setText("Stop Connection");
		
		}else if (button.getText().equals("Stop Connection"))
		{
//			button.setText("Connect");
		}
	}
	
	
	
	
}
