package loops;

import connections.Connection;
import connections.SendToDroneFrom;
import managers.keyManager.TextAreaKeyListener;
import otherFunctions.Database;
import otherFunctions.ProcessKeyInput;

public class MainLoop implements Runnable
{
	private static final double ONE_SECOND = 1000000000;
	private boolean exit = false;
	
	private ProcessKeyInput processKeyInput;
	private  SendToDroneFrom sendToDrone;
	
	private  Connection connection;
	private TextAreaKeyListener textAreaKeyListener;
	
	Database database;
	
	public MainLoop(Connection connection, TextAreaKeyListener textAreaKeyListener)
	{
		this.connection = connection;
		this.textAreaKeyListener = textAreaKeyListener;
	}
	
	private void init()
	{
		sendToDrone = new SendToDroneFrom(connection.getSocket());
		processKeyInput = new ProcessKeyInput();
		database = new Database();
	}
	
	@Override
	public void run()
	{
		init();
		
		System.out.println("MainLoop started");
		while (!exit)
		{
			//code here
			startLoop();
			
			exit = true;
			
		}
		System.out.println("MainLoop stopped....");
	}
	
	
	private void loop()
	{
		for (Integer directions:processKeyInput.values(textAreaKeyListener.getPressed()))
		{
			sendToDrone.directions(directions);
			
			if (database.getRecordingButtonIs())
				database.setRecordedFly(directions.toString());
		}
		if (database.getRecordingButtonIs())
			database.setRecordedFly(".");
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
		
		while (!exit)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick ;
			timer += now - lastTime;
			lastTime = now;
			
			
			if (delta >= 1)
			{
				loop();
				delta--;
			}
			
			if (timer >= ONE_SECOND)
				timer = 0;
		}
	}
	
	
	public void startMainLoop()
	{
		exit = false;
	}
	public void stopMainLoop()
	{
		exit = true;
	}
}
