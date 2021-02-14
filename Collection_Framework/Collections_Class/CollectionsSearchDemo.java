import java.util.*;
class CollectionsSearchDemo
{
	public static void main(String[] args) 
	{
		ArrayList l = new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("M");
		l.add("K");
		l.add("a");
		Collections.sort(l);
		System.out.println(l); //[A, K, M, Z, a]
		System.out.println(Collections.binarySearch(l,"Z")); //3
		System.out.println(Collections.binarySearch(l,"J")); //-2
		
	}
}