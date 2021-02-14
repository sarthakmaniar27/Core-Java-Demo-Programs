import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class MessageProcessor implements Runnable
{
	private int message;

	MessageProcessor(int message)
	{
		this.message = message;
	}

	public void run()
	{
		System.out.println(Thread.currentThread().getName()+ " [RECEIVED] Message = " + message);
		respondToMessage(); //Make thread sleep to simulate doing some work
		System.out.println(Thread.currentThread().getName()+ " [DONE] Processing Message = " + message);
	}
	private void respondToMessage()
	{
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			System.out.println("Unable to process message "+ message);
		}
	}
}

class ThreadPoolDemo1
{
	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newFixedThreadPool(2); //Creates a threadpool od 2 threads This pool comes from the Executors class. There are other kinds of pools also.
		//Now I have to submit jobs to this executor framework.
		MessageProcessor p1 = new MessageProcessor(2);
		service.submit(p1);
		MessageProcessor p2 = new MessageProcessor(3);
		service.submit(p2);
		MessageProcessor p3 = new MessageProcessor(4);
		service.submit(p3);
		MessageProcessor p4 = new MessageProcessor(5);
		service.submit(p4);

		//The ExecutorService is waiting to receive more jobs, but we have completed our jobs
		// so we need to shutdown it.
		service.shutdown(); //Rejects any new jobs from being submitted, the ExecutorService will gracefully shutdown.
		//shutdown() shuts down after completing all the jobs.
		//service.shutdownNow(); //Terminate the executor service immediately.

		try{
			service.awaitTermination(20,TimeUnit.SECONDS); //wait for 10 seconds before movinf on. So we can use this instead of while loop
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
		/*while(!service.isTerminated())
		{

		}
	   */
		System.out.println("Submitted all jobs...");
		//The above line is going to run immediately at the begining of the console, if while() loop is removed.
	}
}

/*So basically we have 2 threads in the threadpool and 3 jobs to do. So 2 threads will do 3 jobs.
i.e. suppose my 2 threads are t1 and t2, and my 3 jobs are p1,p2,p3. Then t1 will pick up say p1, 
t2 will pick say p2 and remaining p3 job can be performed by either t1 or t2.


*/

