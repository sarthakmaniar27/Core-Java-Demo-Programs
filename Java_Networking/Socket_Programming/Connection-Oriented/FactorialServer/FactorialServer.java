import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
class FactorialServer
{
	public static int getFactorial(int number)
	{
		if(number == 0 || number == 1)
		{
			return number;
		}
		else
		{
			return (number*getFactorial(number-1));
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Waiting for Clients...");
			ServerSocket ss = new ServerSocket(9806);
			Socket soc = ss.accept();
			System.out.println("Connection Established!");

			//Receive the number from the client
			InputStream ois = soc.getInputStream();
			//BufferedReader br = new BufferedReader(new InputStreamReader(ois));
			Scanner sc = new Scanner(ois);
			int n = sc.nextInt(); //Getting the number from the client
			int fact = getFactorial(n);
			//Now send this result back to the client
			OutputStream oos =  soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true);
			pw.println(fact); //Result sent to the client

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}