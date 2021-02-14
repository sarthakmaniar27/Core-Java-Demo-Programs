import java.io.*;

class FileInputStreamDemo2
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("pqr.txt");
		int size = fis.available();
		byte[] b = new byte[size];
		fis.read(b);
		String data = new String(b);
		System.out.println(data);
		System.out.println();
		String[] words = data.split(" ");
		int number_Of_Words = words.length;
		int count = 0;
		for(String word : words)
		{
			if(word.equals("Durga"))
			{ 
				count++;
			}
		}
		System.out.println("The number of words in the file is "+number_Of_Words);
		System.out.println("\"Durga\" word is repeated "+count+" times");
		
		fis.close();
	}
}