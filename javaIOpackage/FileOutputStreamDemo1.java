import java.io.*;

class FileOutputStreamDemo1
{
	public static void main(String[] args) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("pqr.txt");
		String data = "Lorem ipsum Durga sit amet, consectetur adipiscing elit, Durga do eiusmod tempor incididunt ut labore et Durga magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Durga aute irure dolor in reprehenderit in Durga velit esse cillum dolore eu Durga nulla pariatur. Excepteur sint occaecat cupidatat non proident, Durga in culpa qui officia deserunt mollit anim id est laborum."; //Durga is coming 7 times
		byte[] b = data.getBytes();
		fos.write(b);
		fos.close();
	}
}