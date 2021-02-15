package controllers;

import connections.SendToDrone;
import display.Display;
import managers.keyManager.TextAreaKeyListener;
import java.awt.event.KeyEvent;

public class MainLoop implements Runnable
{
	private static final double ONE_SECOND = 1000000000;
	private static final int MOTOR_STEP = 10;
	
	private int L_R = 11500;
	private int F_B = 21500;
	
	
	private boolean loopIs = false;
	
	private Thread thread;
	
	private Display display;
	private TextAreaKeyListener textAreaKeyListener;
	private SendToDrone sendToDrone;
	
	
	public MainLoop(Display display)
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
		sendToDrone = new SendToDrone();
	}
	
	
	private void loop()
	{
//		textAreaKeyListener.updateKeys();
		
		
		// TODO: 2/5/2021  yaw , throttle , roll , pitch
		
		
		if (textAreaKeyListener.pressed.contains(KeyEvent.VK_W)) //FORWARD
		{
			if (F_B <22000)
				F_B += MOTOR_STEP;
		}
		if (textAreaKeyListener.pressed.contains(KeyEvent.VK_S)) //BACKWARD
		{
			if (F_B >21000)
				F_B -= MOTOR_STEP;
		}
		if (textAreaKeyListener.pressed.contains(KeyEvent.VK_A)) //LEFT
		{
			if (L_R >11000)
				L_R -= MOTOR_STEP;
		}
		if (textAreaKeyListener.pressed.contains(KeyEvent.VK_D)) //RIGHT
		{
			if (L_R <12000)
				L_R += MOTOR_STEP;
		}
		
		
		boolean stopLR = !textAreaKeyListener.pressed.contains(KeyEvent.VK_A) && !textAreaKeyListener.pressed.contains(KeyEvent.VK_D);
		
		boolean stopFB = !textAreaKeyListener.pressed.contains(KeyEvent.VK_W) && !textAreaKeyListener.pressed.contains(KeyEvent.VK_S);
		
		
		if (stopLR)
		{
			L_R = 11500;
		}
		if (stopFB)
		{
			F_B = 21500;
		}
		
		sendToDrone.directions(L_R);
		sendToDrone.directions(F_B);
		
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
