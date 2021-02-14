import java.net.*;
import java.io.*;

class UDPServer
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(9806);
		//While accepting the data from the client, 
		//it is compulsary to need to mention the port number
		//Bcoz the client will send data to this port number


		//Now accept the data from the client
		byte[] b1 = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b1,b1.length);

		//Now simply receive the data(packet) from the client
		ds.receive(dp);
		String str = new String(dp.getData());


		//Now send this data back to the client
		byte[] b2 = str.getBytes();
		InetAddress ip = InetAddress.getLocalHost();
		DatagramPacket dp1 = new DatagramPacket(b2,b2.length,ip,dp.getPort());

		//Now simply send the data(packet) to the client
		ds.send(dp1);

	}
}