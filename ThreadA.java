
class ThreadB extends Thread
{
	int total = 0;
	public void run()
	{
		System.out.println("Child thread execution starts!");
		synchronized(this)
		{
			System.out.println("Child thread starts calculation..");
			for(int i=1; i<=100; i++)
			{
				total = total + i;
			}
			System.out.println("Child thread giving notification by calling notify() method");
			this.notify();
		}
	}
}	
class ThreadA
{
	public static void main(String[] args) throws InterruptedException
	{
		ThreadB b = new ThreadB();
		b.start();	
	// -> Now there are two threads: main thread and child thread.
		//below code will get executed by the main thread.
		Thread.sleep(10000);
		System.out.println("Main thread execution starts!");
		synchronized(b)
		{
			System.out.println("Main thread calling wait() method");
			System.out.println("Main thread immediately entered into the waiting state");
			b.wait(10000);
			System.out.println("Main thread got notification");
			System.out.println(b.total);

		}
		
	}
}