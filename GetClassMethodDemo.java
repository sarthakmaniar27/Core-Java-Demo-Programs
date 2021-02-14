import java.lang.reflect.*;
class GetClassMethodDemo
{
	public static void main(String[] args) 
	{
		Object o = new String("sarthak");
		Class c = o.getClass();	
		System.out.println("The Fully Qualified Name of the class is "+c.getName());
		Method[] m = c.getDeclaredMethods();
		int count =0;
		for(Method m1 : m)
		{
			count++;
			System.out.println(m1.getName());
		}
		System.out.println("The total number of methods inside "+c.getName()+" class is "+count);
	}
}