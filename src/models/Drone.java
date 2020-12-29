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
		if (controller.getTextAreaKeyManager().up) //W
		{
//			System.out.println("up");
		}
		if (controller.getTextAreaKeyManager().down) //S
		{
//			System.out.println("down");
		}
		if (controller.getTextAreaKeyManager().left) //A
		{
//			System.out.println("left");
		}
		if (controller.getTextAreaKeyManager().right) //D
		{
//			System.out.println("right");
		}
	}
	
	
}
