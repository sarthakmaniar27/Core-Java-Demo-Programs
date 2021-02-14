import java.io.*;

class FileReaderDemo
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("lmn.txt");
		String data = "";
		int i = fr.read();
		while(i != -1)
		{
			data = data + (char)i;
			i = fr.read();
		}
		System.out.println(data);
		fr.close();
	}
}