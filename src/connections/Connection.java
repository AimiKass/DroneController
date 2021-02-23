package connections;

import java.io.IOException;
import java.net.Socket;

public class Connection
{
	private static final String host = "192.168.1.8";
	private static final int port = 1234;
	private Socket socket ;
	
	public Connection()
	{
		try {
			socket = new Socket(host,port);
		} catch (IOException e)
		{
			System.out.println("socket can not open for some reason");
		}
	}
	
	
	public Socket getSocket()
	{
		return socket;
	}
}
