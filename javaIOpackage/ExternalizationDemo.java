import java.io.*;

class Student implements Externalizable
{
	String sid;
	String sname;
	String semail;
	String smobile;
	public Student() //to perform deserialization
	{

	}
	Student(String sid, String sname, String semail, String smobile)
	{
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.smobile = smobile;
	}
	public void getStudentDetails()
	{
		System.out.println("------------------------------");
		System.out.println("Student ID "+sid);
		System.out.println("Student Name "+sname);
		System.out.println("Student Email "+semail);
		System.out.println("Student Mobile "+smobile);
	}
	public void writeExternal(ObjectOutput oop) throws IOException
	{
		try
		{
			//perform data manipulations


			//Manipulating student id
			String[] str1 = sid.split("-"); // DSS-111 --> ["DSS","111"]
			int student_id = Integer.parseInt(str1[1]);  // "111" --> 111
			//Manipulating student email id
			String[] str2 = semail.split("@"); // aaa@dss.com --> ["aaa","dss.com"] 
			String student_email_id = str2[0]; 
			//Manipulating student mobile
			String[] str3 = smobile.split("-"); // "91-9988776655" --> ["91","9988776655"]
			long student_mobile = Long.parseLong(str3[1]); // "9988776655" --> 9988776655

			//data manipulations completed!!
			//Now the manipulated data must be sent to Serialization..
			oop.writeInt(student_id);
			oop.writeUTF(sname);
			oop.writeUTF(student_email_id);
			oop.writeLong(student_mobile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void readExternal(ObjectInput oip) throws IOException, ClassNotFoundException
	{
		try
		{
			//Get Deserialized data from the ObjectInput and manipulate the data..
			sid = "DSS-"+oip.readInt();
			sname = oip.readUTF();
			semail = oip.readUTF()+"@dss.com"; 
			smobile = "91-"+oip.readLong();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
//Externalizable class "Student" completed
class ExternalizationDemo
{
	public static void main(String[] args) throws Exception
	{
		//Perform Serialization and Deserialization over Externalizable class "Student"
		FileOutputStream fos = new FileOutputStream("student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);	
		Student s1 = new Student("DSS-111","AAA","aaa@dss.com","91-9988776655");
		System.out.println("Student Details before Serialization:");
		s1.getStudentDetails();
		oos.writeObject(s1); // At this line JVM will check whether the objects's corresponding
		// class is implementing Serializable or Externalizable interface.
		/*If objects's corresponding class is implementing Serializable interface
		then whole object data will be sent to the file.
		If objects's corresponding class is implementing Externalizable interface
		then JVM will understand that the programmer does not want to copy the 
		whole object data to the file,so JVM will execute writeExternal() method.
		Within this method we have to write the code to save our choice variables to the file.
 		*/
		System.out.println();
		FileInputStream fis = new FileInputStream("student.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student s2 = (Student)ois.readObject(); //At this line also JVM will check whether the objects's corresponding
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
		System.out.println("Student Details after Deserialization:");
		s2.getStudentDetails();

	}
}