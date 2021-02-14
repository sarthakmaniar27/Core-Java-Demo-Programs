import java.util.*;
class MyComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		return (s2.compareTo(s1));
	}
}
class PriorityQueueDemo3
{
	public static void main(String[] args) 
	{
		TreeSet<String> t = new TreeSet<String>(new MyComparator());
		t.add("Apple");
		t.add("Orange");
		t.add("Banana");
		t.add("Grapes");
		t.add("Kiwi");
		System.out.println(t);
		PriorityQueue<String> q = new PriorityQueue<String>(t);
		System.out.println(q);
	}
}