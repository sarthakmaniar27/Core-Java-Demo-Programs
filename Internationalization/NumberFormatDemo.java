import java.text.*;
import java.util.*;

class NumberFormatDemo
{
	public static void main(String[] args) 
	{
		double d = 123456.789;
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		NumberFormat nf1 = NumberFormat.getInstance(Locale.GERMANY);
		NumberFormat nf2 = NumberFormat.getInstance(Locale.JAPAN);
		NumberFormat nf3 = NumberFormat.getInstance(Locale.US);
		NumberFormat nf4 = NumberFormat.getInstance(Locale.KOREA);
		System.out.println("Italy form is : "+nf.format(d));
		System.out.println("Germany form is : "+nf1.format(d));
		System.out.println("Japan form is : "+nf2.format(d));
		System.out.println("US form is : "+nf3.format(d));
		System.out.println("Korea form is : "+nf4.format(d));
	}
}