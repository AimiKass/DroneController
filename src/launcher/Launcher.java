package launcher;

import controllers.UI;

public class Launcher
{
	public static void main(String[] args)
	{
		UI UI = new UI("DroneController", 700, 500);
		UI.start();
	}
}
