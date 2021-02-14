import java.io.*;


class Employee implements Externalizable
{
	int eno;
	String ename;
	float esal;
	public Employee()
	{
		System.out.println("public no-arg constructor");
	}
	Employee(int eno, String ename, float esal)
	{
		this.eno = eno;
		this.ename = ename;
		this.esal = esal; 
	}

	public void writeExternal(ObjectOutput oop) throws IOException
	{
		oop.writeObject(ename);
	}
	public void readExternal(ObjectInput oip) throws IOException, ClassNotFoundException
	{
		ename = (String)oip.readObject();
	}

	public void getEmployeeDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Employee Number :"+this.eno);
		System.out.println("Employee Name :"+this.ename);
		System.out.println("Employee Salary :"+this.esal);
	}
}

class ExternalizationDemo1
{
	public static void main(String[] args) throws Exception
	{
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("externalizable_file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Employee emp1 = new Employee(101,"Sarthak",5000);
		System.out.println("Employee Details before Serialization:");
		emp1.getEmployeeDetails();
		oos.writeObject(emp1);// At this line JVM will check whether the objects's corresponding
		// class is implementing Serializable or Externalizable interface.
		/*If objects's corresponding class is implementing Serializable interface
		then whole object data will be sent to the file.
		If objects's corresponding class is implementing Externalizable interface
		then JVM will understand that the programmer does not want to copy the 
		whole object data to the file,so JVM will execute writeExternal() method.
		Within this method we have to write the code to save our choice variables to the file.
 		*/

		System.out.println();
		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("externalizable_file.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee emp2 = (Employee)ois.readObject();//At this line also JVM will check whether the objects's corresponding
		// class is implementing Serializable or Externalizable interface.
		/*If objects's corresponding class is implementing Serializable interface
		then already whole object data is available in the file read it.
		If objects's corresponding class is implementing Externalizable interface
		then JVM will understand that the file does not contain 
		whole object data,so JVM will create a new object by executing
		public no-arg constructor because object(data) is not there in the file.
		Now on this newly created object, JVM will call readExternal() method.
		Withnin this method, we have to read those variables/properties which we sent to the file

		In short, in Serialization, object is created by ObjectInputStream 
		and in Externalization object is created by no-arg contructor. 
		*/
		System.out.println("Employee Details after Deserialization:");
		emp2.getEmployeeDetails();

	}
}