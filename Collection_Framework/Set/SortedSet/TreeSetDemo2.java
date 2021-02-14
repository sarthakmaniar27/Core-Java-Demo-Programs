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
class TreeSetDemo2
{
	public static void main(String[] args)
	{
		TreeSet t = new TreeSet(new MyComparator());
		t.add("Sarthak");
		t.add("Sarjak");
		t.add("Aryan");
		t.add("Ayush");
		t.add("Parth");
		t.add("Anuj");
		t.add("Shrey");
		t.add("Neha");
		System.out.println(t); //[Shrey, Sarthak, Sarjak, Parth, Neha, Ayush, Aryan, Anuj]
	}
}