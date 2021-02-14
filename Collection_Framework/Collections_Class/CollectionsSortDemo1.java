import java.util.*;

class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		String s1 = (String)obj1;
		String s2 = (String)obj2;
		return -(s1.compareTo(s2)); 
		// OR
		//return (s2.compareTo(s1));
	}
}
class CollectionsSortDemo1
{
	public static void main(String[] args) 
	{
		ArrayList l = new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("K");
		l.add("N");
		System.out.println("Before Sorting: "+l); //Before Sorting: [Z, A, K, N]
		Collections.sort(l,new MyComparator());
		System.out.println("After Sorting: "+l); //After Sorting: [Z, N, K, A]
	}
}