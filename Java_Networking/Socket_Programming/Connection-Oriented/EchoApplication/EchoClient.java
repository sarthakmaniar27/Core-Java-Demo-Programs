import java.net.Socket;
import java.io.*;
class EchoClient
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Client Started");
			Socket soc = new Socket("localhost",9806);
			//Take a string as an input from the user
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string");
			String str = userInput.readLine();

			//Now wrtie this data(string) to the server
			OutputStream oos = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true); //true means auto-flush
			pw.println(str);

			//Receive the data from the server
			InputStream ois = soc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ois));
			System.out.println(br.readLine());//Data received
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}