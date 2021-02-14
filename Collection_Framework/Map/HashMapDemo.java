import java.util.*;
class HashMapDemo
{
	public static void main(String[] args) 
	{
		HashMap h = new HashMap();
		h.put("Sarthak",100);
		h.put("Sarjak",250);
		h.put("Parth",400);
		h.put("Ayush",750);
		h.put("Shrey",990);
		System.out.println(h);	
		System.out.println(h.put("Sarjak",500));
		Set s = h.keySet();
		System.out.println(s);
		Collection c = h.values();
		System.out.println(c);
		Set s1 = h.entrySet();
		System.out.println(s1);
		Iterator itr = s1.iterator();
		while(itr.hasNext())
		{
			Map.Entry m = (Map.Entry)itr.next();
			if(m.getKey().equals("Shrey"))
			{
				m.setValue(900);
			}
			System.out.println(m.getKey()+"--"+m.getValue());
		}
		System.out.println(h);
	}
}