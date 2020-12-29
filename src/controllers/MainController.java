package controllers;

import display.Display;
import managers.buttonManager.ButtonManager;
import managers.buttonManager.buttons.ConnectBtnManager;
import managers.keyManager.TextAreaKeyManager;
import models.Drone;

import javax.swing.*;

public class MainController implements Runnable
{
	private static final double ONE_SECOND = 1000000000;
	
	
	public int width,height;
	public String title;
	
	private Display display;
	private JFrame frame;
	
	private JTextArea textArea;
	private JButton connectBtn;
	
	
	private Thread thread;
	private boolean loopIs = false;
	
	private Drone drone;
	
	//Input
	private TextAreaKeyManager textAreaKeyManager;
	private ButtonManager connectBtnManager;
	
	
	
	public MainController(String title,int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		drone = new Drone(this);
		
		
		//initialize components
		connectBtn = display.getConnectBtn();
		textArea = display.getTextArea();
		//initialize managers
		textAreaKeyManager = new TextAreaKeyManager(textArea);
		connectBtnManager = new ConnectBtnManager(connectBtn);
		//add listeners
		connectBtn.addActionListener(connectBtnManager);
		display.getTextArea().addKeyListener(textAreaKeyManager);
		
	}
	
	
	
	
	@Override
	public void run()
	{
		init();
		
		
		
		startLoop();
		
		stopMainController();
	}
	
	
	/**
	 * The loop function repeats itself according with the startLoop()
	 */
	private void loop()
	{
		drone.tick();
		textAreaKeyManager.tick();
	}
	
	
	/**
	 * 	Function that repeats a loop method in specific ticks per second (tpc)
	 */
	private void startLoop()
	{
		int tpc = 20;
		double timePerTick = ONE_SECOND / tpc;
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
	
	
	
	public synchronized void startMainController()
	{
		if (loopIs)
			return;
		loopIs =true;
		
		thread = new Thread(this);
		thread.start(); //call run method
	}
	
	
	public synchronized void stopMainController()
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
	
	
	
	public TextAreaKeyManager getTextAreaKeyManager()
	{
		return  textAreaKeyManager;
	}
	
	
}