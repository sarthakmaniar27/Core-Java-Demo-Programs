import java.io.*;


class Employee implements Serializable
{
	int eno;
	String ename;
	float esal;
	Employee(int eno, String ename, float esal)
	{
		this.eno = eno;
		this.ename = ename;
		this.esal = esal; 
	}

	public void getEmployeeDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Employee Number :"+eno);
		System.out.println("Employee Name :"+ename);
		System.out.println("Employee Salary :"+esal);
	}
}

class SerializationAndDeserializationDemo
{
	public static void main(String[] args) throws Exception
	{
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("serializable_file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Employee emp1 = new Employee(101,"Sarthak",5000);
		System.out.println("Employee Details before Serialization:");
		emp1.getEmployeeDetails();
		oos.writeObject(emp1);
		System.out.println();
		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("serializable_file.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee emp2 = (Employee)ois.readObject();
		System.out.println("Employee Details after Deserialization:");
		emp2.getEmployeeDetails();

	}
}