import java.util.*;

class ConcurrentModificationExceptionDemo extends Thread
{
	static ArrayList l = new ArrayList();
	public void run()
	{
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println("Child Thread Updating the List");
		l.add("D");
	}
	public static void main(String[] args) throws InterruptedException
	{
		l.add("A");
		l.add("B");
		l.add("C");
		ConcurrentModificationExceptionDemo t = new ConcurrentModificationExceptionDemo();
		t.start();
		//Now there are two threads
		Iterator itr = l.iterator();
		while(itr.hasNext())
		{
			String s1 = (String)itr.next();
			System.out.println("Main Thread Iterating the List and Current Object is "+s1);
			Thread.sleep(3000);
		}
		System.out.println(l);
	}
}
