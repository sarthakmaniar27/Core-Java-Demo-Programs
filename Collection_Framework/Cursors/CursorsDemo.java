import java.util.*;
class CursorsDemo
{
	public static void main(String[] args)
	{
		Vector v = new Vector();
		Enumeration e = v.elements();
		Iterator itr = v.iterator();
		ListIterator ltr = v.listIterator();
		System.out.println(e.getClass().getName());
		System.out.println(itr.getClass().getName());
		System.out.println(ltr.getClass().getName());
	}
}