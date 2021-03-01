package controllers;

import connections.Connection;
import display.Display;
import loops.MainLoop;
import loops.PlayRecordedFlyLoop;
import managers.keyManager.TextAreaKeyListener;
import otherFunctions.Database;


public class MainController implements Runnable
{
	
	private boolean loopIs = false;
	
	private Thread thread;
	
	private Display display;
	private TextAreaKeyListener textAreaKeyListener;
	
	private Database database;
	Connection connection;
	
	
	//loop classes
	static MainLoop mainLoop;
	static PlayRecordedFlyLoop playRecordedFlyLoop;
	//threads
	static Thread thread_MainLoop;
	static Thread thread_PlayRecordedFlyLoop;
	
	
	
	public MainController(Display display)
	{
		this.display = display;
	}
	
	@Override
	public void run()
	{
		init();
		startMainLoopThread();
		
	}
	
	private void init()
	{
		textAreaKeyListener = display.getTextAreaKeyListener();
		
		connection = new Connection();
		database = new Database();
		
		mainLoop = new MainLoop(connection,textAreaKeyListener);
		playRecordedFlyLoop = new PlayRecordedFlyLoop(connection);
		
		
		database.eraseRecordedFly();
		database.setRecordingButtonIs(false);
		
	}
	
	
	public static void startRecordedFly()
	{
		mainLoop.stopMainLoop();
		try {
			thread_PlayRecordedFlyLoop = new Thread(playRecordedFlyLoop);
			thread_PlayRecordedFlyLoop.start();
			thread_PlayRecordedFlyLoop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		startMainLoopThread();
	}
	
	
	private static void startMainLoopThread()
	{
		
			thread_MainLoop = new Thread(mainLoop);
			thread_MainLoop.start();
			mainLoop.startMainLoop();
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