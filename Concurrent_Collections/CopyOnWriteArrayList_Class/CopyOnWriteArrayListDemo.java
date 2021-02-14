import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class CopyOnWriteArrayListDemo
{
	public static void main(String[] args) 
	{
		ArrayList l = new ArrayList();
		l.add("A");
		l.add("B");  // l -> [A, B] 
		CopyOnWriteArrayList l1 = new CopyOnWriteArrayList();
		l1.addIfAbsent("A");
		l1.addIfAbsent("C"); // l1 -> [A, C] 
		l1.addAll(l);		// l1 -> [A, C, A, B] 	
		ArrayList l2 = new ArrayList();
		l2.add("A");
		l2.add("E"); // l2 -> [A, E] 
		l1.addAllAbsent(l2); //l1 -> [A, C, A, B, E]
		System.out.println(l1); //[A, C, A, B, E]
	}
}