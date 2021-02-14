import java.net.*;
import java.io.*;

class UDPClient
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(); //this datagram socket will not know about
		//the iP address and the port number, it is your Packet which knows about it.
		/*
		A datagram is basically an information 
		but there is no guarantee of its content, arrival or arrival time.
		*/
		//Now take input from the user
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string");
		String str = userInput.readLine();
		//Now we have to send this data to the server right,
		//for this we will use DatagramPacket class. It is a message that can be 
		//sent or received. If you send multiple packet, it may arrive in any order. 
		//Additionally, packet delivery is not guaranteed.

		byte[] b = str.getBytes(); //Converting data into Byte Array format

		//To get the IP Address, we'll use InetAddress class
		InetAddress ip = InetAddress.getLocalHost();

		DatagramPacket dp = new DatagramPacket(b,b.length,ip,9806);
		/*You need to mention 4 parameters:
		first parameter: data you want to send in Byte Array format only
		second parameter: data length 
		third parameter: IP Address
		fourth parameter: Port Number
		*/
		//Now simply send the data(packet) to the server
		ds.send(dp);


		//Receive the data(packet) from the server
		//This data will come in the form of Array of bytes remember
		byte[] b1 = new byte[1024];
		DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
		//Now simply receive the data(packet) from the server
		ds.receive(dp1);
		//Now just print it
		String str1 = new String(dp1.getData());
		//Using getData() method, you can fetch the data from the packet.
		System.out.println("Server says : "+str1); 

		

	}
}