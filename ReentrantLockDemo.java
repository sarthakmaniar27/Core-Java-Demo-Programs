import java.util.concurrent.locks.*;

class Dislplay
{
	ReentrantLock l = new ReentrantLock();
	public void wish(String name)
	{
		l.lock();
			for(int i=0;i<10;i++)
			{
				System.out.print("Good Morning : ");
				try
				{
					Thread.sleep(2000);
				}
				catch(InterruptedException e){}
				System.out.println(name);
			} 
			l.unlock();
	}
}

class MyThread extends Thread
{
	Dislplay d;
	String name;
	MyThread(Dislplay d, String name)
	{
		this.d = d;
		this.name = name;
	}
	public void run()
	{
		d.wish(name);
	}
}

class ReentrantLockDemo
{
	public static void main(String[] args) 
	{
		Dislplay d = new Dislplay();
		MyThread t1 = new MyThread(d,"Dhoni");
		MyThread t2 = new MyThread(d,"Kohli");
		t1.start();
		t2.start();
	}
}
