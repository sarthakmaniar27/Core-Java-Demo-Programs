import java.util.*;
class ListIteratorDemo
{
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		l.add("apple"); 
		l.add("mango"); 		
		l.add("orange");	
		l.add("banana"); 
		l.add("kiwi"); 
		l.add("grapes"); 
		System.out.println(l); //[apple, mango, orange, banana, kiwi, grapes]
		ListIterator ltr = l.listIterator();
		while(ltr.hasNext())
		{
			String s = (String)ltr.next();
			if(s.equals("orange"))
			{
				ltr.remove(); //[apple, mango, banana, kiwi, grapes]
			}
			else if(s.equals("kiwi"))
			{
				ltr.add("jackfruit"); //[apple, mango, banana, kiwi, jackfruit , grapes]
			}
			else if(s.equals("banana"))
			{
				ltr.set("orange"); //[apple, mango, orange , kiwi, jackfruit , grapes]
			}
		}
		System.out.println(l); //[apple, mango, orange , kiwi, jackfruit , grapes]
	}
}