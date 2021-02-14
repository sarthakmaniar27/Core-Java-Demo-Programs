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

class PriorityQueueDemo1
{
	public static void main(String[] args) 
	{
		PriorityQueue q = new PriorityQueue(15,new MyComparator());
		q.offer("Parth");
		q.offer("Ayush");
		q.offer("Sarthak");
		q.offer("Aryan");
		System.out.println(q);  //[Sarthak, Ayush, Parth, Aryan]
	}
}

/*
import java.util.*; 
  
public class PriorityQueueDemo1 { 
    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in); 
        // Creating Priority queue constructor having  
        // initial capacity=5 and a StudentComparator instance  
        // as its parameters 
        PriorityQueue<Student> pq = new 
             PriorityQueue<Student>(5, new StudentComparator()); 
                  
                // Invoking a parameterized Student constructor with  
                // name and cgpa as the elements of queue 
                Student student1 = new Student("Nandini", 3.8); 
                  
                // Adding a student object containing fields  
                // name and cgpa to priority queue  
                pq.add(student1); 
                Student student2 = new Student("Anmol", 4.6); 
                        pq.add(student2);          
                Student student3 = new Student("Palak", 4.0); 
                        pq.add(student3); 
                  
                // Printing names of students in priority order,poll() 
                // method is used to access the head element of queue 
                System.out.println("Students served in their priority order"); 
                  
                while (!pq.isEmpty()) { 
                System.out.println(pq.poll().getName()); 
        }  
    } 
}  
  
class StudentComparator implements Comparator<Student>{ 
              
            // Overriding compare()method of Comparator  
                        // for descending order of cgpa 
            public int compare(Student s1, Student s2) { 
                if (s1.cgpa < s2.cgpa) 
                    return 1; 
                else if (s1.cgpa > s2.cgpa) 
                    return -1; 
                                return 0; 
                } 
        } 
  
class Student { 
    public String name; 
    public double cgpa; 
          
    // A parameterized student constructor 
    public Student(String name, double cgpa) { 
      
        this.name = name; 
        this.cgpa = cgpa; 
    } 
      
    public String getName() { 
        return name; 
    }  
} 
*/