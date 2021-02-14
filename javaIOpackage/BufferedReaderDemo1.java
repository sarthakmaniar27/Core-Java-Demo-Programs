import java.io.*;

class BufferedReaderDemo1
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the first number : ");
		String val1 = br.readLine(); 
		System.out.print("Enter the second number : ");
		String val2 = br.readLine(); 
		int num1 = Integer.parseInt(val1);
		int num2 = Integer.parseInt(val2);
		System.out.println("Addition : "+(num1 + num2));
	}
}