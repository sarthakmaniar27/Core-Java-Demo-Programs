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
class ArraysSearchDemo
{
	public static void main(String[] args) 
	{
		//Primitive Array
		int[] a = {10,5,20,11,6};
		Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a,6)); //1
		System.out.println(Arrays.binarySearch(a,14)); //-5

		//Object Array		
		String[] s = {"A","Z","B"};
		System.out.println("Object Array Before Sorting:");
		Arrays.sort(s);
		System.out.println(Arrays.binarySearch(s,"Z")); //2
		System.out.println(Arrays.binarySearch(s,"S")); //-3
		MyComparator c = new MyComparator();
		Arrays.sort(s,c);
		System.out.println(Arrays.binarySearch(s,"Z",c)); //0
		System.out.println(Arrays.binarySearch(s,"S",c)); //-2
		System.out.println(Arrays.binarySearch(s,"N")); //unpredictable result
		
	}
}