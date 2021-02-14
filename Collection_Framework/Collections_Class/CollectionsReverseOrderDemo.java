import java.util.*;
class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Integer i1 = (Integer)obj1;
		Integer i2 = (Integer)obj2;
		return i1.compareTo(i2); //Ascending Order 
		// OR
		//return (s2.compareTo(s1));
	}
}
class CollectionsReverseOrderDemo
{
	public static void main(String[] args) 
	{
		MyComparator c = new MyComparator();
		Comparator c1 = Collections.reverseOrder(c);
		ArrayList l = new ArrayList();
		l.add(15);
		l.add(0);
		l.add(20);
		l.add(10);
		l.add(5);
		System.out.println(l);  //[15, 0, 20, 10, 5]
		Collections.sort(l,c1); //Descending Order
		System.out.println(l); //[20, 15, 10, 5, 0]
		
	}
}