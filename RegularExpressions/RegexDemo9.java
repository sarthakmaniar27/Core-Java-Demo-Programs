
//Write a program to display all .txt files present in a particular folder.
import java.util.regex.*;
import java.io.*;

class RegexDemo9
{
	public static void main(String[] args) throws Exception
	{
		
		String regular_expression = "[a-zA-Z0-9_.$]+[.]txt";
		Pattern p = Pattern.compile(regular_expression);
		File f = new File("../javaIOpackage");
		//File f = new File("../../JAVA");
		//File f = new File("../RegularExpressions");
		String[] s = f.list();
		int count = 0;
		for(String s1:s)
		{
			Matcher m = p.matcher(s1);
			if(m.find() && m.group().equals(s1))
			{
				count++;
				System.out.println(s1);
			}
		}
		System.out.println("The total number of .txt files in "+f.getName()+" is "+count);	
	}
}
