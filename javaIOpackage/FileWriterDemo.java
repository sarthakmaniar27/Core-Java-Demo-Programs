import java.io.*;

class FileWriterDemo
{
	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter("lmn.txt");
		String data = "Hellooo Sarthak";
		char[] ch = data.toCharArray();
		fw.write(ch);
		fw.close();
	}
}