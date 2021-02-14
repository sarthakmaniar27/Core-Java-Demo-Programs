import java.io.*;

class CopyImageFile
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("src.jpg");
		int size = fis.available();
		byte[] b = new byte[size];
		fis.read(b);
		FileOutputStream fos = new FileOutputStream("dest.jpg");
		fos.write(b);
		System.out.println("Image copied from \"src.jpg\" file to \"dest.jpg\" file");
		fis.close();
		fos.close();
	}
}