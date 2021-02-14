class MyThread extends Thread
{
	public void run()
	{
		System.out.println(l.get());
	}
}
 //static  ThreadLocal l = new ThreadLocal();
class ThreadLocalDemo
{
	public static void main(String[] args) 
	{
		ThreadLocal l = new ThreadLocal();
		MyThread t = new MyThread();
		t.start();	
		System.out.println(l.get());		
	}
}