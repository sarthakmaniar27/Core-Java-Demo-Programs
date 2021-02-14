import java.util.*;
import java.io.*;
import java.lang.*;


class MyThread extends Thread
{
		MultiMergeSort mms = new MultiMergeSort();
	    int arr[];
        int start;
        int end;
        MyThread(int arr[], int start, int end)
        {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }
        public void run()
        {
            mms.sort(arr,start,end);
        }
}
class MultiMergeSort 
{ 
	void merge(int arr[], int l, int m, int r) 
	{ 
		int n1 = m - l + 1; 
		int n2 = r - m; 
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 

		int i = 0, j = 0; 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			int m = (l+r)/2; 
			sort(arr, l, m); 
			sort(arr , m+1, r); 
			merge(arr, l, m, r); 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	public static void main(String args[]) 
	{ 

		int arr[] = new int[1000000];
		int newarr[] = new int[1000000]; //10 lakh size
		Random rand = new Random(1000000);
		for (int i = 0; i < 1000000 ; i++) {
            arr[i] = Math.abs(rand.nextInt(1000000));
        }		
        //0 thread
		//time started
		long startTime = System.currentTimeMillis();
		MultiMergeSort ob = new MultiMergeSort(); 
		ob.sort(arr, 0, arr.length-1); 

		long endTime = System.currentTimeMillis();
		//time ended
        System.out.println("\nTime taken to sort when number of threads = 0 : " + (endTime - startTime) + " Milli Seconds"); 
		
        //2 threads
		MyThread t1 = new MyThread(newarr,0,499999);
		MyThread t2 = new MyThread(newarr,500000,999999);
		//time started
		startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){}
          endTime = System.currentTimeMillis();
          //time ended
         System.out.println("\nTime taken to sort when number of threads = 2 " + (endTime - startTime) + " Milli Seconds"); 
		// 4 threads
        t1 = new MyThread(newarr,0,249999);
        t2 = new MyThread(newarr,250000,499999);
        MyThread t3 = new MyThread(newarr,500000,749999);
        MyThread t4 = new MyThread(newarr,750000,999999);
          startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(Exception e){}
          endTime = System.currentTimeMillis();
         System.out.println("\nTime taken to sort when number of threads = 4 " + (endTime - startTime) + " Milli Seconds"); 
         
         // 10 threads
        t1 = new MyThread(newarr,0,99999);
        t2 = new MyThread(newarr,100000,199999);
        t3 = new MyThread(newarr,200000,299999);
        t4 = new MyThread(newarr,300000,399999);
        MyThread t5 = new MyThread(newarr,400000,499999);
        MyThread t6 = new MyThread(newarr,500000,599999);
        MyThread t7 = new MyThread(newarr,600000,699999);
        MyThread t8 = new MyThread(newarr,700000,799999);
        MyThread t9 = new MyThread(newarr,800000,899999);
        MyThread t10 = new MyThread(newarr,900000,999999);
          startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.start();
	        t6.start();
	        t7.start();
	        t8.start();
	        t9.start();
	        t10.start();
        }catch(Exception e){}
          endTime = System.currentTimeMillis();
         System.out.println("\nTime taken to sort when number of threads = 10 " + (endTime - startTime) + " Milli Seconds");  

	} 
} 
