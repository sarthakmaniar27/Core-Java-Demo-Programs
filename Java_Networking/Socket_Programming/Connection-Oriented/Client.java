import java.net.Socket;
import java.io.*;
import java.util.*;
class Client
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Client Started");
			Socket soc = new Socket("localhost",9806);
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the 1st number: ");
			int num1 = sc.nextInt();
			System.out.println("Please enter the 2nd number: ");
			int num2 = sc.nextInt();
			System.out.println("What do you want to perform?");
			System.out.println("Press 1 for Additon(+)");
			System.out.println("Press 2 for Subtraction(-)");
			System.out.println("Press 3 for Multiplication(*)");
			System.out.println("Press 4 for Divison(/)");
			int n = sc.nextInt();
			

			//Now wrtie this data(string) to the server
			OutputStream oos = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(oos,true); //true means auto-flush
			pw.println(num1);
			pw.println(num2);
			pw.println(n);

			//Receive the data from the server
			InputStream ois = soc.getInputStream();
			Scanner in = new Scanner(ois);
			int result = in.nextInt(); //Getting the result from the server
			System.out.println("The result is : "+result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}