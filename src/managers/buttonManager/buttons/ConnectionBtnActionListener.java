package managers.buttonManager.buttons;

import connections.Connection;
import controllers.MainController;
import managers.buttonManager.ButtonManager;
import otherFunctions.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConnectionBtnActionListener extends ButtonManager
{
	JTextArea ipTextArea,portTextArea;
	public ConnectionBtnActionListener(JButton button,JTextArea ipTextArea, JTextArea portTextArea)
	{
		super(button);
		this.ipTextArea = ipTextArea;
		this.portTextArea = portTextArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Database database = new Database();
		database.setIP(ipTextArea.getText());
//		System.out.println(ipTextArea.getText());
		database.setPort(portTextArea.getText());
//		System.out.println(portTextArea.getText());
		
		Connection connection = new Connection();
		MainController.setConnection(connection);
		MainController.startMainLoopThread();
	}
}
