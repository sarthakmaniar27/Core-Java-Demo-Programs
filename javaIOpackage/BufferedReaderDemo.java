import java.io.*;

class BufferedReaderDemo
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Input Data : ");
		String data = br.readLine(); 
		System.out.print("Enter the same Data again : ");
		int val = br.read();
		System.out.println("First Entered Input : "+data);
		System.out.println("Second Entered Input : "+(char)val); 
	}
}