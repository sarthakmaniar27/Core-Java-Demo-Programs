
//Write a program to read all mobile numbers present in the given input file where 
//mobile numbers are mixed with normal text data
import java.util.regex.*;
import java.io.*;

class RegexDemo8
{
	public static void main(String[] args) throws Exception
	{
		
		String regular_expression = "(0|91)?[7-9][0-9]{9}";
		Pattern p = Pattern.compile(regular_expression);
		try(
				PrintWriter pw = new PrintWriter("output.txt");
				BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			)
		{
			
			String line = br.readLine();
			while(line != null) 
			{
				Matcher m = p.matcher(line); //Each line will be our target string
				while(m.find()) //This loop will get repeated for every match present in the line
				{
					pw.println(m.group());
				}

				line = br.readLine();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!!!");
		}
	}
}
