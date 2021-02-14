import java.io.*;

class FileDemo1{
	public static void main(String[] args) throws IOException{
		File f = new File("abc.text");
		System.out.println(f.exists());
		f.createNewFile();
		System.out.println(f.exists());
	}
}