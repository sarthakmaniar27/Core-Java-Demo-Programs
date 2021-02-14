import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

class CopyOnWriteArrayListDemo1 extends Thread
{
	static CopyOnWriteArrayList l = new CopyOnWriteArrayList();
	public void run()
	{
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println("Child Thread Updating the List");
		l.add("D");
		//l.remove("A");
	}
	public static void main(String[] args) throws InterruptedException
	{
		l.add("A");
		l.add("B");
		l.add("C");
		CopyOnWriteArrayListDemo1 t = new CopyOnWriteArrayListDemo1();
		t.start();
		//Now there are two threads
		Iterator itr = l.iterator();
		while(itr.hasNext())
		{
			String s1 = (String)itr.next();
			System.out.println("Main Thread Iterating the List and Current Object is "+s1);
			/*if(s1.equals("A"))
			{
				itr.remove(); //java.lang.UnsupportedOperationException
			}*/
			Thread.sleep(3000);
		}
		System.out.println(l);
	}
}
