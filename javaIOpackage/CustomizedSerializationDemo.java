import java.io.*;

class Account implements Serializable
{

	String username = "sarthak";
	transient String password = "xyz" ;
	
	// Implement below two methods for Customized Serialization
	private void writeObject(ObjectOutputStream os) throws Exception
	{
		os.defaultWriteObject(); //To perform Default Serialization
		//Now do the extra work with your data...
		String encripted_password = "123" + password + "@abc";
		os.writeObject(encripted_password);
	}
	private void readObject(ObjectInputStream is) throws Exception
	{
		is.defaultReadObject(); //To perform Default Deserialization
		//Now do the extra work with your data...
		String encripted_password = (String)is.readObject();
		password = encripted_password.substring(3,6); // "123xyz@abc" --> "xyz"
	}

	public void displayAccountDetails()
	{
		System.out.println("---------------------------");
		System.out.println("Username = "+this.username);
		System.out.println("Password = "+this.password);
	}

}
class CustomizedSerializationDemo
{
	public static void main(String[] args) throws Exception
	{
		Account a1 = new Account();
		a1.displayAccountDetails();

		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("customized_serializable_file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		System.out.println();

		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("customized_serializable_file.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account a2 = (Account)ois.readObject();
		a2.displayAccountDetails();
	}
}