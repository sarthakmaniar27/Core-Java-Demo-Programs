
//Predefined Character Classes
import java.util.regex.*;

class RegexDemo2
{
	public static void main(String[] args) 
	{
		String x = "\\s";
		//String x = "\\S";
		//String x = "\\d";
		//String x = "\\D";
		//String x = "\\w";
		//String x = "\\W";
		//String x = ".";
		Pattern p = Pattern.compile(x);
		Matcher m = p.matcher("a7b k@9z");
		while(m.find())
		{
			System.out.println(m.start()+"--"+m.group());
		}
	}
}
