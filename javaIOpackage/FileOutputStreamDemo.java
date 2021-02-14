import java.io.*;

class FileOutputStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("xyz.txt",true);
		String data = "Hello World!";
		byte[] b = data.getBytes();
		fos.write(b);
		fos.close();
	}
}