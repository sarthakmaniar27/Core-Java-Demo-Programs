import java.lang.*;
// Exampe 1
/*
class Mythread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
			System.out.println("Child Thread");
				Thread.yield();
	}
}
class ThreadDemo
{
	public static void main(String[] args) 
	{
		Mythread t = new Mythread();
		//t.setPriority(10);
		t.start();
		for(int i=0;i<10;i++)
			System.out.println("Main Thread");

	}
}
*/

// Exampe 2
/*
class Mythread extends Thread
{
	public void run()
	{
		//System.out.println(Thread.currentThread().getName());
		System.out.println("Child Thread is working");
	}
}
class ThreadDemo
{
	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().getName()); //main
		Mythread t = new Mythread(); // main thread creates child thread object, so child thread is created
		//System.out.println(t.getName());
		Thread.currentThread().setName("child");
		System.out.println(Thread.currentThread().getName());
		t.start(); // child thread starts
		//System.out.println(Thread.currentThread().getName());
		System.out.println("Main Thread is working");
	}
}
*/
// Exampe 3
/*
class Mythread extends Thread
{
	public void run()
	{
		Thread.currentThread().setName("child");
		System.out.println("This line is executed by "+Thread.currentThread().getName());
	}
}
class ThreadDemo
{
	public static void main(String[] args) 
	{
		Mythread t = new Mythread(); 
		t.start();
		System.out.println("This line is executed by "+Thread.currentThread().getName());
	}
}
*/

// Exampe 4
/*
class Mythread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Child Thread");
				try{
					Thread.sleep(2000);   //child thread will take total 20 sec to complete execution
					//We are putting the child thread in the sleep state for 2000 ms i.e 2 s, so there may be a chance that some other threads may interrupt while our child thread is sleeping so IE Exception may occur,so better handle this exception.
				}catch(InterruptedException e)
				{
					System.out.println(e);
				}
		}
	}
}
class ThreadDemo
{
	public static void main(String[] args) throws InterruptedException  
	{
		Mythread t = new Mythread();
		t.start();
		t.join(10000); //wait only for 10 sec
		for(int i=0;i<10;i++)
			System.out.println("Main Thread");

	}
}
*/
// Exampe 5
/*
class Mythread extends Thread 
{
	static Thread mt;
	public void run()
	{
		
		try
		{
			mt.join();
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}
		for(int i=0;i<10;i++)
		{
			System.out.println("Child Thread");
		}
	}
}
class ThreadDemo
{
	public static void main(String[] args) throws InterruptedException  
	{
		Mythread.mt = Thread.currentThread(); //so mt will point to the main thread
		Mythread t = new Mythread();
		t.start();
		t.join();
		for(int i=0;i<10;i++)
		{
			System.out.println("Main Thread");
			Thread.sleep(2000);
		}

	}
}
*/

// Exampe 6

class Mythread extends Thread 
{
	public void run()
	{
		
		try
		{
				for(int i=0;i<10;i++)
			{
				System.out.println("I am Lazy Child Thread");
				if(i == 5)
					Thread.sleep(2000);
				else
					continue;
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Oh damn, I got interrupted!!");
		}
		
	}
}
class ThreadDemo
{
	public static void main(String[] args) throws InterruptedException  
	{
		Mythread t = new Mythread();
		t.start();
		t.interrupt();
	    System.out.println("End of Main Thread");
	}
}