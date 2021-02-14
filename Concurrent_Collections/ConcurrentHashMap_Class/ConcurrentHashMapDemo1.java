import java.util.concurrent.*;
import java.util.*;

class ConcurrentHashMapDemo1 extends Thread
{
	static ConcurrentHashMap m = new ConcurrentHashMap();
	public void run()
	{
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println("Child Thread Updating the Map");
		m.put(103,"C");
		m.putIfAbsent(101,"D");
		m.replace(102,"B","E");
		m.put(104,"F");
		m.replace(101,"A","G");
	}
	public static void main(String[] args) throws InterruptedException
	{
		m.put(101,"A");
		m.put(102,"B");
		ConcurrentHashMapDemo1 t = new ConcurrentHashMapDemo1();
		t.start();
		//t.join(); //Main thread will wait for the child thread to get completed!
		//Now there are two threads
		Set s1 = m.keySet();
		Iterator itr = s1.iterator(); //As we can apply Iterator only on Collection Objects
		while(itr.hasNext())
		{
			Integer i1 = (Integer)itr.next();
			System.out.println("Main Thread Iterating the Map and Current Entry is "+i1+"="+m.get(i1));
			Thread.sleep(3000);
		}
		System.out.println(m);
	}
}
