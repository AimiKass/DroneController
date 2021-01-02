package controllers;

import display.Display;

public class UI
{
	
	public int width,height;
	public String title;
	
	private Display display;
	private MainLoop mainLoop;
	
	
	public UI(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		mainLoop = new MainLoop(display);
	}
	
	
	
	
	public void start()
	{
		init();
		mainLoop.startMainLoop();
		
	}
	
	


	
}