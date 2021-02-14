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
class TreeMapDemo1
{
	public static void main(String[] args) 
	{
	TreeMap m = new TreeMap(new MyComparator());
	m.put("Sarthak",105);
	m.put("Sarjak",102);
	m.put("Aryan",101);
	m.put("Ayush",107);
	m.put("Parth",104);
	m.put("Anuj",103);
	m.put("Shrey",106);
	m.put("Neha",108);
	System.out.println(m); //{Shrey=106, Sarthak=105, Sarjak=102, Parth=104, Neha=108, Ayush=107, Aryan=101, Anuj=103}	
	}
}