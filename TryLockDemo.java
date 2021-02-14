import java.util.concurrent.locks.*;


class MyThread extends Thread
{
	static ReentrantLock l = new ReentrantLock();
	MyThread(String name)
	{
		super(name);
	}

	public void run()
	{
		if(l.tryLock())
		{
			System.out.println(Thread.currentThread().getName()+" got lock and performing safe operations...");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){}
			l.unlock();
		}
		else
		{
			System.out.println(Thread.currentThread().getName()+" unable to get the lock and hence performing alternative operations...");
		}
	}
}

class TryLockDemo
{
	public static void main(String[] args) 
	{
		MyThread t1 = new MyThread("First Thread");
		MyThread t2 = new MyThread("Second Thread");
		MyThread t3 = new MyThread("Third Thread");	
		t1.start();
		t2.start();
		t3.start();
	}
}