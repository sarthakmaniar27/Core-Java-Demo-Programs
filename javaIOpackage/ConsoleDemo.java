import java.io.*;
class ConsoleDemo
{
	public static void main(String[] args) throws Exception
	{
		Console c = System.console();
		String uname =  c.readLine("Enter Username :");
		char[] pwd = c.readPassword("Enter Password :");
		String upwd = new String(pwd);
		if(uname.equals("sarthak") && upwd.equals("123"))
		{
			System.out.println("Login Succesful!");
		}
		else
		{
			System.out.println("Login Failed!");
		}
	}
}