import java.io.*;

class FileInputStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("xyz.txt");
		int size = fis.available();
		byte[] b = new byte[size];
		fis.read(b);
		String data = new String(b);
		System.out.println(data);
		fis.close();
	}
}