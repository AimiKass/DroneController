package connections;

import otherFunctions.Database;

import java.io.IOException;
import java.net.Socket;

public class Connection
{
	
	private Socket socket ;
	
	public Connection()
	{
		Database database = new Database();
		
		try {
			socket = new Socket(database.getIP(),Integer.parseInt(database.getPort()));
		} catch (IOException e)
		{
			// TODO: 2/27/2021 create popup windows
			System.out.println("socket can not open for some reason");
		}
	}
	
	
	public Socket getSocket()
	{
		return socket;
	}
}
