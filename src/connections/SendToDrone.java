package connections;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendToDrone
{
	private DataOutputStream dataOutputStream;
	private Socket socket ;
	
	public SendToDrone()
	{
		try {
			socket = new Socket("192.168.1.5", 1234);
		}catch (Exception e)
		{
			System.out.println("socket can not open for some reason");
		}
	}
	
	
	
	public void directions(int com)
	{
		try {
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeInt(com);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
