package controllers;

import display.Display;

public class UI
{
	
	public int width,height;
	public String title;
	
	private Display display;
	private MainController mainController;
	
	
	public UI(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		mainController = new MainController(display);
	}
	
	
	
	public void start()
	{
		init();
		mainController.startMainLoop();
	}
	
}