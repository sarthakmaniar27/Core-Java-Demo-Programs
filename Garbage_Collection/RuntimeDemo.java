import java.util.Date;
class RuntimeDemo
{
	public static void main(String[] args) 
	{
		Runtime r = Runtime.getRuntime(); //Getting Runtime object
		System.out.println("Total Memory: "+r.totalMemory());
		System.out.println("Free Memory: "+r.freeMemory());
		for (int i=1; i<=10000 ;i++ ) 
		{
			Date d = new Date(); //Creating 10000 Date objects
			d=null;	 //Make 10000 Date objects for GC
		}	
		System.out.println("Free Memory before calling gc(): "+r.freeMemory());
		r.gc(); //Requesting JVM to run GC
		System.out.println("Free Memory after calling gc(): "+r.freeMemory());
	}
}