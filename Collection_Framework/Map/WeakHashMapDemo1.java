import java.util.*;

class Temp
{
	public String toString()
	{
		return "temp";
	}
	public void finalize()
	{
		System.out.println("finalize() method called!");
	}
}
class WeakHashMapDemo1 
{
	public static void main(String[] args) throws Exception
	{
		WeakHashMap	m = new WeakHashMap();
		Temp t = new Temp();
		m.put("sarthak",t);
		System.out.println(m);
		t=null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(m);
	}
}