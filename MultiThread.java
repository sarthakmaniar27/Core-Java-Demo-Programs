import java.lang.*;

class MyThread1 extends Thread
{
	public void run()
	{
		int[] a = {10,-34,17,45,-5,18,57,91,86};
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<0)
				System.out.println(a[i]+" is a negative element");
		}

	}
}
class MyThread2 extends Thread
{
	public void run()
	{
		int[] a = {10,-34,17,45,-5,18,57,91,86};
		for(int i=0;i<a.length;i++)
		{
			if(a[i] > 0 && a[i]%2 == 0)
				System.out.println(a[i]+" is a positive + even element");
		}

	}
}
class MyThread3 extends Thread
{
	public void run()
	{
		int[] a = {10,-34,17,45,-5,18,57,91,86};
		for(int i=0;i<a.length;i++)
		{
			if(a[i] > 0 && a[i]%2== 1)
				System.out.println(a[i]+" is a positive + odd element");
		}

	}
}

class MultiThread
{
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		t1.start();
		t2.start();
		t3.start();
	}
}