/*class Student 
{
	String name;
	int roll;
	static int count=0;
	{
		count++;
	}
	Student(String name, int roll)
	{
		this.name = name;
		this.roll = roll;
	}
	public static void main(String[] args)
	{	
		Student s1 = new Student("Sarthak",101);
		Student s2 = new Student("Sarjak",102);
		Student s3 = new Student("Aryan",103);
		Student s4 = new Student("Parth",104);
		Student s5 = new Student("Ayush",105);
		System.out.println("Number of objects created for Student class is "+count);
	}
}
*/

class Student 
{
	String name;
	int roll;
	Student(String name, int roll)
	{
		this.name = name;
		this.roll = roll;
	}
	public static void main(String[] args)
	{	
		Student s1 = new Student("Sarthak",101);
		Student s2 = new Student("Aryan",103);
		Student s3 = new Student("Sarthak",101);
		Student s4 = s1;
		//System.out.println(s1.equals(s2)); //false
		//System.out.println(s1.equals(s3)); //false
		//System.out.println(s1.equals(s4)); //true

		String p1 = new String("HELLO"); 
        String p2 = new String("HELLO"); 
        System.out.println(p1 == p2); //false
        System.out.println(p1.equals(p2)); //true
		
	}
}