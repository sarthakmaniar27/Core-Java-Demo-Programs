import java.util.*;
class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		String s1 = (String)obj1;
		String s2 = (String)obj2;
		return s2.compareTo(s1); 
	}
}
class ArraysSortDemo
{
	public static void main(String[] args) 
	{
		//Primitive Array
		int[] a = {10,5,20,11,6};
		System.out.println("Primitive Array Before Sorting:");
		for(int a1:a)
		{
			System.out.print(a1+" "); //10 5 20 11 6
		}
		
		/*System.out.println("Array: "   
                         + Arrays.toString(a));*/
                          
		System.out.println();
		Arrays.sort(a);
		System.out.println("Primitive Array After Sorting:");
		for(int a1:a)
		{
			System.out.print(a1+" "); //5 6 10 11 20 
		}
		System.out.println();

		//Object Array
		String[] s = {"A","Z","B"};
		System.out.println("Object Array Before Sorting:");
		for(String s1:s)
		{
			System.out.print(s1+" ");  //A Z B 
		}
		System.out.println();
		Arrays.sort(s);
		System.out.println("Object Array After Sorting(D.N.S.O):");
		for(String s1:s)
		{
			System.out.print(s1+" "); //A B Z
		}
		System.out.println();
		Arrays.sort(s,new MyComparator());
		System.out.println("Object Array After Sorting(C.S.O):");
		for(String s1:s)
		{
			System.out.print(s1+" "); //Z B A 
		}


	}
}