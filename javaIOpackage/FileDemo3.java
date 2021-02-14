import java.io.*;

class FileDemo3{
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("abc.text");
		char[] ch = {'s','a','r','t','h','a','k'};
		String s = "Java";
		fw.write(ch);
		fw.write("\n");
		fw.write(s);
		fw.write("\n");
		fw.write('x');
		fw.flush();
		fw.close();
		FileReader fr = new FileReader("abc.text");
		int i = fr.read();
		while(i!=-1)
		{
			System.out.print((char)i);
			i = fr.read();
		}
		File f = new File("sarthak123");
		File f1 = new File(f,"hello.txt");
		FileReader fr2 = new FileReader(f1);
		int j = fr2.read();
		System.out.println("\n"+j); //-1
		
	}
}