import java.util.concurrent.locks.*;
import java.util.concurrent.*; //TimeUnit is in this package

class MyThread extends Thread
{
	static ReentrantLock l = new ReentrantLock();
	MyThread(String name)
	{
		super(name);
	}

	public void run()
	{

		do{
			try{
			
			if(l.tryLock(5000,TimeUnit.MILLISECONDS))
			{
				System.out.println(Thread.currentThread().getName()+" got lock.");
				Thread.sleep(30000); //sleeping for 30 seconds.
				l.unlock();
				System.out.println(Thread.currentThread().getName()+" releases the lock.");
				break;
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+" unable to get the lock and will try again.");
			}	
		}catch(InterruptedException e){}
		}while(true);
	}
}

class TryLockDemo2
{
	public static void main(String[] args) 
	{
		MyThread t1 = new MyThread("First Thread");
		MyThread t2 = new MyThread("Second Thread");
		//MyThread t3 = new MyThread("Third Thread");	
		t1.start();
		t2.start();
		//t3.start();
	}
}