import java.util.*;
class LinkedListDemo
{
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		l.add("Hello"); //[Hello]
		l.add(30); 		//[Hello,30]
		l.add(null);	//[Hello,30,null]
		l.add("Hello"); //[Hello,30,null,Hello]
		l.set(0,"World"); //[World,30,null,Hello]
		l.add(0,"Sarthak"); //[Sarthak,World,30,null,Hello]
		l.removeLast(); //[Sarthak,World,30,null]
		l.addFirst("CCC"); //[CCC,Sarthak,World,30,null]
		System.out.println(l); //[CCC,Sarthak,World,30,null]

	}
}