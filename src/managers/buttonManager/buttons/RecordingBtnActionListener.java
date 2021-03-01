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
		
		if (e.getSource() == button)
		{
			if (pressedOneIs)
			{
				pressedOneIs = false;
				// code for second press
				database.setRecordingButtonIs(false);
				button.setText("Start Recording");
			}else
			{
				pressedOneIs = true;
				//code for first press
				database.eraseRecordedFly();
				database.setRecordingButtonIs(true);
				button.setText("Stop Recording");
			}
			
		}
		
	}
	
}