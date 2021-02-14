
import java.util.*;
import java.lang.*;
import java.io.*;

class knapsack01
{
    static int t[][] = new int[10001][10001];
    public static int knapsack(int[] wt,int[] val,int w,int n)
    {
        if(n==0 || w==0)
            return 0;
            
        if(t[n][w]!= -1)
            return t[n][w]; 
        if(wt[n-1]<=w)
        {
            return t[n][w] = (int)Math.max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1),knapsack(wt,val,w,n-1) );
        }
        else
        {
            return t[n][w] = knapsack(wt,val,w,n-1);
        }
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<t.length;i++)
            {
                Arrays.fill(t[i],-1);
            }
		int testcases = sc.nextInt();
		while(testcases!=0)
		{
		   int n = sc.nextInt();  
		   int w = sc.nextInt();
		   int wt[] = new int[n];
		   int val[] = new int[n];
		   for(int i=0;i<n;i++)
		       val[i] = sc.nextInt();
		   for(int i=0;i<n;i++)
		       wt[i] = sc.nextInt(); 
		   int result = knapsack(wt,val,w,n);     
		   System.out.println(result);
		   testcases--;
		}
	}
}