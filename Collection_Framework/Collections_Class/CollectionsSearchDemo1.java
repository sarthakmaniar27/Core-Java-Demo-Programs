import java.util.*;
class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Integer i1 = (Integer)obj1;
		Integer i2 = (Integer)obj2;
		return -(i1.compareTo(i2)); 
		// OR
		//return (s2.compareTo(s1));
	}
}
class CollectionsSearchDemo1
{
	public static void main(String[] args) 
	{
		MyComparator c = new MyComparator();
		ArrayList l = new ArrayList();
		l.add(15);
		l.add(0);
		l.add(20);
		l.add(10);
		l.add(5);
		Collections.sort(l,c);
		System.out.println(l); //[20, 15, 10, 5, 0]
		System.out.println(Collections.binarySearch(l,10,c)); //2
		System.out.println(Collections.binarySearch(l,13,c)); //-3
		System.out.println(Collections.binarySearch(l,17)); //unpredictable 
		
	}
}