package managers.buttonManager.buttons;

import managers.buttonManager.ButtonManager;
import otherFunctions.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RecordingBtnActionListener extends ButtonManager
{
	
	Database database;
	boolean pressedOneIs = false;
	
	public RecordingBtnActionListener(JButton button)
	{
		super(button);
		database = new Database();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (button.getText().equals("Start Recording"))
		{
			
			if (pressedOneIs)
			{
				pressedOneIs = false;
				database.eraseRecordedFly();
			}
			pressedOneIs = true;
			
			database.setRecordingButtonIs(true);
			
			button.setText("Stop Recording");
			
			
		}else if (button.getText().equals("Stop Recording"))
		{
			button.setText("Start Recording");
			
			database.setRecordingButtonIs(false);
		}
		
	}
	
}