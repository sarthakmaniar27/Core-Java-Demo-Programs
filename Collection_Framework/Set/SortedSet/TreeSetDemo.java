import java.util.*;
class TreeSetDemo
{
	public static void main(String[] args)
	{
		TreeSet t = new TreeSet();
		t.add("A");
		t.add("a");
		t.add("B");
		t.add("Z");
		t.add("L");
		//t.add(new Integer(10));
		//t.add(null);
		System.out.println(t);
	}
}