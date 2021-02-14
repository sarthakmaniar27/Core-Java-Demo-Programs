
//Quantifiers
import java.util.regex.*;

class RegexDemo3
{
	public static void main(String[] args) 
	{
		String x = "a";
		//String x = "a+";
		//String x = "a*";
		//String x = "a?";
		Pattern p = Pattern.compile(x);
		Matcher m = p.matcher("abaabaaab");
		while(m.find())
		{
			System.out.println(m.start()+"--"+m.group());
		}
	}
}
