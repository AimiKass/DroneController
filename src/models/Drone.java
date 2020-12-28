package models;

import controllers.MainController;

public class Drone
{
	private MainController controller;
	
	public Drone(MainController controller)
	{
		this.controller = controller;
	}
	
	
	public void tick()
	{
		getInput();
	}
	
	private void getInput()
	{
		if (controller.getKeyManager().up) //W
			System.out.println("up");
		if (controller.getKeyManager().down) //S
			System.out.println("down");
		if (controller.getKeyManager().left) //A
			System.out.println("left");
		if (controller.getKeyManager().right) //D
			System.out.println("right");
	}
	
	
}
