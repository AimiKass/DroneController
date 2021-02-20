package connections;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendToDroneFrom
{
	private DataOutputStream dataOutputStream;
	private Socket socket;
	
	public SendToDroneFrom(Socket socket)
	{
		this.socket = socket;
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
