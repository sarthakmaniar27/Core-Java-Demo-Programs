import java.net.*;
import java.io.*;
import java.util.*;
class FactorialClient
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Client Started");
			Socket soc = new Socket("localhost",9806);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number :");
			int n = sc.nextInt(); //Taking number as input from the user
			OutputStream oos = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true);
			pw.println(n); //Sending this number to the server

			//Receive the result from the server now
			InputStream ois = soc.getInputStream();
			//BufferedReader in = new BufferedReader(new InputStreamReader(ois));
			Scanner in = new Scanner(ois);
			int result = in.nextInt(); //Getting the result from the server
			System.out.println("The factorial is : "+result);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}