import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
class EchoServer
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Waiting for Clients...");	
			ServerSocket ss = new ServerSocket(9806);
			Socket soc = ss.accept();
			System.out.println("Connection Established!");
			//Read the data(string) which the client sent
			InputStream ois = soc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ois));
			String str = br.readLine(); //Data received from the client

			//Now again sending back this data to the client
			OutputStream oos = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true); //true means auto-flush
			pw.println("Server says: "+str); //Data sent
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}