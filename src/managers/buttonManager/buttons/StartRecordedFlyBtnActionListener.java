package managers.buttonManager.buttons;

import controllers.MainController;
import managers.buttonManager.ButtonManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartRecordedFlyBtnActionListener extends ButtonManager
{
	
	public StartRecordedFlyBtnActionListener(JButton button)
	{
		super(button);
	}
	
	
	// TODO: 3/1/2021 check that shit
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainController.startRecordedFly();
	}
	
	
}
