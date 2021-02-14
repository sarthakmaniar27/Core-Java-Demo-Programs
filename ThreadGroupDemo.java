class MyThread extends Thread
{
	MyThread(ThreadGroup g,String name)
	{
		super(g,name);
	}
	public void run()
	{
		System.out.println("Child thread");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){}
	}
}
class ThreadGroupDemo
{
	public static void main(String[] args)
	{

		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		ThreadGroup pg = new ThreadGroup("Parent Group");
		ThreadGroup cg = new ThreadGroup(pg,"Child Group");
		MyThread t1 = new MyThread(pg,"ChildThread1");
		MyThread t2 = new MyThread(pg,"ChildThread2");
		t1.start();
		t2.start();
		Thread[] t = new Thread[system.activeCount()];
		system.enumerate(t);
		for(Thread tn:t)
		{
			System.out.println(tn.getName()+" ---- "+tn.isDaemon());
		}


	}
}