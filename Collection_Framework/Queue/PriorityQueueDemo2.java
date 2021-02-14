import java.util.*;
class MyComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		return (s2.compareTo(s1));
	}
}
class PriorityQueueDemo2
{
	public static void main(String[] args) 
	{
		PriorityQueue<String> q = new PriorityQueue<String>(15,new MyComparator());
		q.offer("Apple");
		q.offer("Orange");
		q.offer("Banana");
		q.offer("Grapes");
		q.offer("Kiwi");
		//System.out.println(q);  
		while (!q.isEmpty()) { 
                System.out.println(q.poll()); 
            }
	}
}