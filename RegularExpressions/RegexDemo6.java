
//Write a program to check whether the given number is a valid mobile number or not
import java.util.regex.*;

class RegexDemo6
{
	public static void main(String[] args) 
	{
		String regular_expression = "(0|91)?[7-9][0-9]{9}";
		String mobile = "919988776655"; 
		Pattern p = Pattern.compile(regular_expression); 
		Matcher m = p.matcher(mobile);

		if(m.find() && m.group().equals(mobile))
		{
			System.out.println("Valid Mobile Number!");
		}
		else
		{
			System.out.println("Invalid Mobile Number!");
		}
	}
}
