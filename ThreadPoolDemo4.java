import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

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

class ThreadPoolDemo4
{
	public static void main(String[] args) 
	{
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		//method to run task only once that to after a delay of 10 seconds
		service.schedule(new Task(),10,TimeUnit.SECONDS);
		//method a run a task for every 10 seconds repeatedly
		service.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS); //15 is the initial delay, 10 is the period.
		//method a run repeatedly 10 seconds after the previous tasks completes 
		service.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);
		service.shutdown();
	}
}