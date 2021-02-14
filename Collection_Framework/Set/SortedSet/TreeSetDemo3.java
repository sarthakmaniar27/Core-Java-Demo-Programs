import java.util.*;

class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		//here first convert StringBuffer objects into String objects
		String s1 = obj1.toString();
		String s2 = obj2.toString();
		return (s1.compareTo(s2)); 
	}
}
class TreeSetDemo3
{
	public static void main(String[] args)
	{
		TreeSet t = new TreeSet(new MyComparator());
		t.add(new StringBuffer("Sarthak"));
		t.add(new StringBuffer("Sarjak"));
		t.add(new StringBuffer("Aryan"));
		t.add(new StringBuffer("Ayush"));
		t.add(new StringBuffer("Parth"));
		t.add(new StringBuffer("Anuj"));
		t.add(new StringBuffer("Shrey"));
		t.add(new StringBuffer("Neha"));
		System.out.println(t); //[Anuj, Aryan, Ayush, Neha, Parth, Sarjak, Sarthak, Shrey]
	}
}