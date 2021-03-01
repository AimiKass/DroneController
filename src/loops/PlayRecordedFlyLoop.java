package loops;

import connections.Connection;
import connections.SendToDroneFrom;
import otherFunctions.Database;

public class PlayRecordedFlyLoop implements Runnable
{
	private static final double ONE_SECOND = 1000000000;
	private boolean exit = false;
	
	private  SendToDroneFrom sendToDrone;
	
	private Connection connection;
	
	
	private Database database;
	
	int i;
	
	
	// TODO: 2/27/2021 you can create  abstract class fot the loop classes
	public PlayRecordedFlyLoop(Connection connection)
	{
		this.connection = connection;
	}
	
	private void init()
	{
		sendToDrone = new SendToDroneFrom(connection.getSocket());
		database = new Database();
		
		exit = false;
		
		i=0;
		
	}
	
	@Override
	public void run()
	{
		init();
		System.out.println("PlayRecordedFlyLoop started");
		
		while (!exit)
		{
			//code here
			
			startLoop();
			
			exit = true;
		}
		System.out.println("PlayRecordedFlyLoop stopped....");
	}
	
	
	private void loop()
	{
		
		
		for (Integer directions : database.getRecordedFly().get(i))
			sendToDrone.directions(directions);
		
			
		if (i <database.getRecordedFly().size()-1)
			i++;
		else
			exit = true;
		
		
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
	
	public void startPlayRecordedFlyLoop()
	{
		exit = false;
	}
	public void stopPlayRecordedFlyLoop()
	{
		exit = true;
	}
}
