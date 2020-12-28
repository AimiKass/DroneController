package launcher;

import controllers.MainController;

public class Launcher
{
	public static void main(String[] args)
	{
		MainController mainController = new MainController("DroneController", 640, 360);
		mainController.startMainController();
	}
}
