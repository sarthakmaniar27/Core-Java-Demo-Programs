import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Task implements Runnable
{
	
	static int jobCounter = 0;
	public void run()
	{
		jobCounter++;
		System.out.println(Thread.currentThread().getName() +" is executing the job : "+jobCounter);
	}
}

class ThreadPoolDemo2
{
	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newFixedThreadPool(10);

		for(int i=0;i<50;i++)
		{
			service.execute(new Task());
		}
		service.shutdown();
	}
}