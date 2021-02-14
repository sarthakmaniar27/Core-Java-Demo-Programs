import java.util.*;
class Temp
{
	int i;
	Temp(int i)
	{
		this.i = i;
	}
	public int hashCode()
	{
		return i;
	}
	public String toString()
	{
		return i+"";
	}
}

class HashtableDemo
{
	public static void main(String[] args) 
	{
	Hashtable h = new Hashtable();
	h.put(new Temp(5),"A");
	h.put(new Temp(2),"B");
	h.put(new Temp(6),"C");
	h.put(new Temp(15),"D");
	h.put(new Temp(23),"E");
	h.put(new Temp(16),"F");
	//h.put("durga",null);
	System.out.println(h);	//{6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
	}
}