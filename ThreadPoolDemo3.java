import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Task implements Runnable
{
	
	static int jobCounter = 1;
	public void run()
	{
		System.out.println(Thread.currentThread().getName() +" is executing the job : "+ jobCounter++);
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
	}
}

class ThreadPoolDemo3
{
	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newCachedThreadPool();

		for(int i=0;i<100;i++)
		{
			service.execute(new Task());
		}
		service.shutdown();
	}
}