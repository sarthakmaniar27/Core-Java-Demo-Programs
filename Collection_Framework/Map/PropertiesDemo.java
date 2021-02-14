import java.util.*;
import java.io.*;

class PropertiesDemo
{
	public static void main(String[] args) throws Exception
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("abc.properties");
		p.load(fis);
		System.out.println(p);
		String s = p.getProperty("username");
		System.out.println(s);
		//p.setProperty("pwd","xyzabc");
		p.setProperty("age","20");
		//p.setProperty("email","hello@gmail.com");
		FileOutputStream fos = new FileOutputStream("abc.properties");
		p.store(fos,"Updated by Sarthak");	
	}
}