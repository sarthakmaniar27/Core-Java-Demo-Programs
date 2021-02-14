import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
class Server
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
			Scanner sc = new Scanner(ois);
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int n = sc.nextInt();
			int result = 0;
			if(n == 1)
			{
				result = num1 + num2;
			}
			else if(n == 2)
			{
				result = num1 - num2;	
			}
			else if(n == 3)
			{
				result = num1 * num2;	
			}
			else if(n == 4)
			{
				try{
					result = num1 / num2;	
				}catch(ArithmeticException e)
				{
					System.out.println(e);
				}
				
			}
			else
			{
				System.out.println("Invalid Input. Please try again!");
			}

			//Now again sending back this data to the client
			OutputStream oos = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true); //true means auto-flush
			pw.println(result); //Data sent
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}