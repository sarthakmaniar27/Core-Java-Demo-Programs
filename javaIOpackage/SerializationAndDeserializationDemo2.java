import java.io.*;


class Bank implements Serializable //contained class should implement Serializable interface
{
	String bid = "B-111";
	String bname = "ICIC Bank";
}
class Account implements Serializable //contained class should implement Serializable interface
{
	String accNo = "abc123";
	Bank bank = new Bank();
}
class Employee implements Serializable
{
	String eid = "E-111";
	Account acc = new Account();

	public void getEmployeeDetails()
	{
		System.out.println("------------------------------------------");
		System.out.println("Employee id is "+eid);
		System.out.println("Employee account number is "+acc.accNo);
		System.out.println("Employee bank id is "+acc.bank.bid);
		System.out.println("Employee bank name is "+acc.bank.bname);
	}
}

class SerializationAndDeserializationDemo2
{
	public static void main(String[] args) throws Exception
	{
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("emp.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Employee emp1 = new Employee();
		System.out.println("Employee Details before Serialization:");
		emp1.getEmployeeDetails();
		oos.writeObject(emp1);
		System.out.println();
		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("emp.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee emp2 = (Employee)ois.readObject();
		System.out.println("Employee Details after Deserialization:");
		emp2.getEmployeeDetails();

	}
}