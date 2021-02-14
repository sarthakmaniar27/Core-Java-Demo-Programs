import java.util.*;
class VectorDemo1
{
	public static void main(String[] args)
	{
		Vector v = new Vector(24);
		System.out.println(v.capacity());
		for(int i=1;i<=10;i++)
		{
			v.addElement(i);
		}
		System.out.println(v.capacity());
		v.addElement("A");
		System.out.println(v.capacity());
		System.out.println(v); //[1,2,3,....,9,10,A]
	}
}