package controllers;

import connections.Connection;
import connections.SendToDroneFrom;
import display.Display;
import managers.buttonManager.buttons.ConnectBtnActionListener;
import managers.keyManager.TextAreaKeyListener;
import otherFunctions.ProcessKeyInput;


public class MainController implements Runnable
{
	private static final double ONE_SECOND = 1000000000;
	
	
	private boolean loopIs = false;
	
	private Thread thread;
	
	private Display display;
	private TextAreaKeyListener textAreaKeyListener;
	public static SendToDroneFrom sendToDrone;
	private static Connection connection;
	ProcessKeyInput processKeyInput;
	
	
	
	public MainController(Display display)
	{
		this.display = display;
	}
	
	@Override
	public void run()
	{
		init();
		startLoop();
	}
	
	private void init()
	{
		textAreaKeyListener = display.getTextAreaKeyListener();
		connection = new Connection();
		sendToDrone = new SendToDroneFrom(connection.getSocket());
		processKeyInput = new ProcessKeyInput();
	}
	
	
	private void loop()
	{
		
		for (Integer directions:processKeyInput.values(textAreaKeyListener.getPressed()))
		{
			sendToDrone.directions(directions);
//			System.out.println(directions);
		}
		
	}
	
	
	/**
	 * 	Function that repeats a loop method in specific ticks per second (tpc)
	 */
	private void startLoop()
	{
		int tps = 20;  //ticks per second
		double timePerTick = ONE_SECOND / tps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (loopIs)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick ;
			timer += now - lastTime;
			lastTime = now;
			
			
			if (delta >= 1)
			{
				loop();
				ticks++;
				delta--;
			}
			
			if (timer >= ONE_SECOND)
			{
//				System.out.println("Ticks amd Frames:" + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
	}
	
	
	public void startMainLoop()
	{
		if (loopIs)
			return;
		loopIs =true;
		
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void stopMainLoop()
	{
		if (!loopIs)
			return;
		loopIs = false;
		
		try { thread.join();}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
