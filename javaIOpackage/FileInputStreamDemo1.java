import java.io.*;

class FileInputStreamDemo1
{
	public static void main(String[] args) throws Exception
	{
		String file_Name = args[0];
		FileInputStream fis = new FileInputStream(file_Name);
		int size = fis.available();
		byte[] b = new byte[size];
		fis.read(b);
		String data = new String(b);
		System.out.println(data);
		fis.close();
	}
}