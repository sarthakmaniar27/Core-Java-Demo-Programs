
//Pattern Class split() method
import java.util.regex.*;

class RegexDemo5
{
	public static void main(String[] args) 
	{
		Pattern p = Pattern.compile("\\."); // or Pattern p = Pattern.compile("[.]");
		String[] s = p.split("www.durgasoftware.com");
		for(String s1:s)
		{
			System.out.println(s1);
		}
	}
}
