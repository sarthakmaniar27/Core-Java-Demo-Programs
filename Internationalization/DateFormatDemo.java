import java.text.*;
import java.util.*;

class DateFormatDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Full Form is : "+DateFormat.getDateInstance(0,Locale.US).format(new Date()));
		System.out.println("Long Form is : "+DateFormat.getDateInstance(1,Locale.US).format(new Date()));
		System.out.println("Medium Form is : "+DateFormat.getDateInstance(2,Locale.US).format(new Date()));
		System.out.println("Short Form is : "+DateFormat.getDateInstance(3,Locale.US).format(new Date()));
		System.out.println("Full Form with time is : "+DateFormat.getDateTimeInstance(0,0,Locale.US).format(new Date()));
		System.out.println("Long Form with time is : "+DateFormat.getDateTimeInstance(1,1,Locale.US).format(new Date()));
		System.out.println("Medium Form with time is : "+DateFormat.getDateTimeInstance(2,2,Locale.US).format(new Date()));
		System.out.println("Short Form with time is : "+DateFormat.getDateTimeInstance(3,3,Locale.US).format(new Date()));
	}
}