import java.util.regex.*;

class RegexDemo
{
	public static void main(String[] args) 
	{
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abbabbba");
		int count = 0;
		while(m.find())
		{
			count++;
			System.out.println(m.start()+"--"+m.end()+"--"+m.group());
		}
		System.out.println("The total number of occurrences : "+count);	
	}
}
