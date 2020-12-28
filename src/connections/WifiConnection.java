package connections;

import java.io.DataOutputStream;
import java.net.Socket;

public class WifiConnection implements Runnable
{
	
	
	private Thread thread;
	
	DataOutputStream dataOutputStream;
	Socket socket ;
	
	
	@Override
	public void run()
	{
		openSocket();
		sendMsg(1500);
		
	}
	
	public void sendMsg(int msg)
	{
		try {
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeInt(msg);
			System.out.println(msg);
		} catch (Exception e)
		{
			System.out.println("message can not be send for some reason");
		}
	}
	
	private void openSocket()
	{
		try {
			socket = new Socket("192.168.1.10", 1234);
		}catch (Exception e)
		{
			System.out.println("socket can not open for some reason");
		}
	}
	
	public Socket getSocket()
	{
		return socket;
	}
	
	
	// TODO: 12/28/2020 change name to open and close (wifiConnection)
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start(); //call run method
	}
	
	
	public synchronized void stop()
	{
		try { thread.join();}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
