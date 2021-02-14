import java.lang.*;
import java.util.*;
import java.io.*;
/*
class ExceptionHandler
{
	public static void main(String[] args) {
		try
		{
			//System.out.println("Statement 1");
			//System.out.println("Statement 2");
			System.out.println(10/0);
		}
		catch(Exception e)
		{
			//System.out.println("Statement 4");
			System.out.println(10/0); //Statement 4
		}
		finally
		{
			System.out.println("Statement 5");
		}
		System.out.println("Statement 6");
	}
}


class ExceptionHandler
{
	public static void main(String[] args) {
		//System.out.println(10/0);

		1.) ArithmeticException e = new ArithmeticException("/ by zero");
		throw e;

		// OR

		2.) throw new ArithmeticException("/ by zero");
	}
}
*/
/*
class ExceptionHandler
{
	static ArithmeticException e;
	public static void main(String[] args) {
		throw e;
	}
}
*/
/*
class A
{
	static int[] a = {1,5,-9,0,4,7,3,8,2,6};
	public void m1(int loopingIndex)
	{
		if(loopingIndex > a.length) 
		{
			throw new ArrayIndexOutOfBoundsException("Your looping index is greater than "+a.length);
		}

	}
	public void m2(int l) 
	{
		m1(l);
		try
		{
			for(int i=0;i<l;i++)
			{
				int x = a[i+1]%a[i];
			}
		}catch(ArithmeticException e)
		{
			System.out.println(e);
		}	


	}

}

class ExceptionHandler
{
	public static void main(String[] args) {
		int l;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the looping index:");
		l = sc.nextInt();
		A obj = new A();
		obj.m2(l);
	}
}
*/
/*
 class AmountExceedLimitException extends RuntimeException
{
	AmountExceedLimitException(String s)
	{
	  super(s);
	} 
}
 class NoSufficientBalanceException extends RuntimeException
{
	NoSufficientBalanceException(String s)
	{
	   super(s);
	}
}

class Account 
{
	static int bal_amt;
	public int deposit(int deposit_amt)
	{	
		bal_amt = bal_amt + deposit_amt;
		System.out.println("Your balance amount is "+bal_amt);
		return bal_amt;
	}
	public void withdraw(int deposit_amt,int withdraw_amt)
	{
		bal_amt = bal_amt - withdraw_amt;
		System.out.println(bal_amt);
		if(bal_amt < 1000)
		{
			throw new NoSufficientBalanceException("Minimum balance should me 1000!!");
		}
		else if(withdraw_amt > 20000)
		{
			throw new AmountExceedLimitException("You cannot withdraw more than 20,000 at a time!!");
		}
		else
		{
			System.out.println("You have successfully withdrew the amount!!");
		}	
	}
}
class ExceptionHandler
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account a = new Account();
		int  wAmt, dAmt;
		System.out.println("Enter the amount you want to deposit:"); 
		dAmt = sc.nextInt();
		a.deposit(dAmt);
		System.out.println("Enter the amount you want to withdraw:"); 
		wAmt = sc.nextInt();
		a.withdraw(dAmt,wAmt);
	}
}
*/

class ExceptionHandler 
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Hello");	
		}
		catch(Error e)
		{

		}
	}
}
