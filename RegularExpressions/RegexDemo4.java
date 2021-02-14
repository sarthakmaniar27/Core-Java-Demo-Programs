
//Pattern Class split() method
import java.util.regex.*;

class RegexDemo4
{
	public static void main(String[] args) 
	{
		Pattern p = Pattern.compile("\\s");
		String[] s = p.split("Sardar Patel Institue of Technology");
		for(String s1:s)
		{
			System.out.println(s1);
		}
	}
}
