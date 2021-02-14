import java.util.*;


class Employee implements Comparable
{
	int eid;
	String ename;
	Employee(int eid, String ename)
	{
		this.eid = eid;
		this.ename = ename;
	}
	public String toString()
	{
		return eid+"-"+ename;
	}
	public int compareTo(Object obj)
	{
		int eid1 = this.eid; //getting current employee's id who is already inserted
		Employee e = (Employee)obj;
		int eid2 = e.eid; //getting the employee's who is going to inserted 
		if(eid1 < eid2)
			return -1;
		else if(eid1 > eid2)
			return +1;
		else
			return 0;
	}
}

class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Employee e1 = (Employee)obj1;
		Employee e2 = (Employee)obj2;
		String s1 = e1.ename;
		String s2 = e2.ename;
		return s1.compareTo(s2);
	}
}
class TreeSetDemo5
{
	public static void main(String[] args)
	{
		Employee e1 = new Employee(105,"Sarthak");
		Employee e2 = new Employee(101,"Sarjak");
		Employee e3 = new Employee(102,"Parth");
		Employee e4 = new Employee(103,"Ayush");
		Employee e5 = new Employee(104,"Aryan");
		Employee e6 = new Employee(105,"Sarthak");
		TreeSet t = new TreeSet(); //Default Natural Sorting Order --> increasing id
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);
		t.add(e6);
		System.out.println(t); //[101-Sarjak, 102-Parth, 103-Ayush, 104-Aryan, 105-Sarthak]
		TreeSet t1 = new TreeSet(new MyComparator()); //Customized Sorting Order --> alphabetical order of names
		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		t1.add(e4);
		t1.add(e5);
		t1.add(e6);
		System.out.println(t1); //[104-Aryan, 103-Ayush, 102-Parth, 101-Sarjak, 105-Sarthak]
	}
}