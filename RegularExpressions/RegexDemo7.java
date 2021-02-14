
//Write a program to check whether the mail id is valid or not
import java.util.regex.*;

class RegexDemo7
{
	public static void main(String[] args) 
	{
		String regular_expression = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
		String mail = "techno.codeuseme@gmail.com"; 
		Pattern p = Pattern.compile(regular_expression); 
		Matcher m = p.matcher(mail);

		if(m.find() && m.group().equals(mail))
		{
			System.out.println("Valid Mail Id!");
		}
		else
		{
			System.out.println("Invalid Mail Id!");
		}
	}
}
