package launcher;

import controllers.UI;

public class Launcher
{
	public static void main(String[] args)
	{
		UI UI = new UI("DroneController", 640, 360);
		UI.start();
	}
}
