
// Character Classes
import java.util.regex.*;

class RegexDemo1
{
	public static void main(String[] args) 
	{
		String x = "[abc]";
		//String x = "[^abc]";
		//String x = "[a-z]";
		//String x = "[0-9]";
		//String x = "[a-zA-Z0-9]";
		//String x = "[^a-zA-Z0-9]";
		Pattern p = Pattern.compile(x);
		Matcher m = p.matcher("a3b#k@9z");
		while(m.find())
		{
			System.out.println(m.start()+"--"+m.group());
		}
	}
}
