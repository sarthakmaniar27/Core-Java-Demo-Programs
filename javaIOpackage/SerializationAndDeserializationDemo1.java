import java.io.*;


class User implements Serializable
{
	String uname;
	transient String upwd;
	User(String uname, String upwd)
	{
		this.uname = uname;
		this.upwd = upwd; 
	}

	public void displayUserDetails()
	{
		System.out.println("--------------------------");
		System.out.println("User Name :"+uname);
		System.out.println("Password :"+upwd);
	}
}

class SerializationAndDeserializationDemo1
{
	public static void main(String[] args) throws Exception
	{
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		User user1 = new User("Sarthak","xyz");
		System.out.println("User Details before Serialization:");
		user1.displayUserDetails();
		oos.writeObject(user1);
		System.out.println();
		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("user.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User user2 = (User)ois.readObject();
		System.out.println("User Details after Deserialization:");
		user2.displayUserDetails();

	}
}