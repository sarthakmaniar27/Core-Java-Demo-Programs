import java.io.*;

class FileDemo4{
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("abc.text");
		char[] c = {'s','a','r','t','h','a','k'};
		fw.write(c);
		File f = new File("abc.txt");
		System.out.println((int)f.length());
		char[] ch = new char[(int)f.length()];
		FileReader fr = new FileReader("abc.text");
		fr.read(ch);
		for(char ch1:ch)
			System.out.println("ch1");
		fr.close();
	
	}
}