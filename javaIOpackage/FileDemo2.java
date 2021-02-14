import java.io.*;

class FileDemo2{
	public static void main(String[] args) throws IOException{
		File f = new File("sarthak123");
		System.out.println(f.exists());
		f.mkdir();
		System.out.println(f.exists());
		File f1 = new File(f,"hello.txt");
		f1.createNewFile();
		System.out.println(f1.getName());
		System.out.println(f1.getParent());
		System.out.println(f1.getAbsolutePath());
		File f2 = new File(f,"bye.txt");
		f2.createNewFile();
		File f3 = new File(f,"tp.txt");
		f3.createNewFile();
		f3.delete(); //tp.txt file got deleted!
		System.out.println(f.isFile()); //false
		System.out.println(f1.isFile()); //true
		System.out.println(f.isDirectory()); //true
		System.out.println(f1.isDirectory()); //false
		String[] files = f.list();
		System.out.println(f.getName()+ " directory contains below files:");
		for(String file:files)
			System.out.println(file);

	}
}