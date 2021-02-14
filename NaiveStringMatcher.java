import java.util.*;
import java.lang.*;

class Test
{
	public static void naive_string_matching(int[] T,int[] P)
	{
		int i,j,n,m;
		 n = T.length;
		 m = P.length;
		 for(i=0;i<=n-m;i++) //i is the shifting variable. Maximum no. of shifts will be n-m.
		 {
		 	for(j=0;j<m;j++) //
		 	{
		 		if(T[i+j]!= P[j]) //So shift by 1
		 			break;
		 	}
		 	if(j==m) //
		 		System.out.println("Pattern occurs with shift "+i);
	     }	
	}
}

class NaiveStringMatcher
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n,m,i;
		System.out.println("Enter Text size:");
		n = sc.nextInt();
		int[] T = new int[n];
		System.out.println("Enter Text:");
		for(i=0;i<n;i++)
		 {
			T[i] = sc.nextInt();
		 }
		System.out.println("Enter Pattern size:");
		m = sc.nextInt(); 
		int[] P = new int[m];
		System.out.println("Enter Pattern:");
		for(i=0;i<m;i++)
		 {
			P[i] = sc.nextInt();
		 }
		/*
		System.out.print("Text is: ");
		for(i=0;i<n;i++)
		{
			System.out.print(T[i]+" ");	
		}
		System.out.print("\n");
		System.out.print("Pattern is: ");
		for(i=0;i<m;i++)
		{
			System.out.print(P[i]+" ");	
		}
		*/
		Test t = new Test();
		t.naive_string_matching(T,P);
	}
}	
