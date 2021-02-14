import java.io.*;

class Dog implements Serializable
{
	int i = 10;
	public void displayDog()
	{
		System.out.println(i);
	}
}
class Cat implements Serializable
{
	int j = 20;
	public void displayCat()
	{
		System.out.println(j);
	}
}
class Rat implements Serializable
{
	int k = 30;
	public void displayRat()
	{
		System.out.println(k);
	}
}

class SerializationAndDeserializationDemo4
{
	public static void main(String[] args) throws Exception
	{
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Rat r1 = new Rat();
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("dog_cat_rat_2.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		System.out.println("Dog Object Details before Serialization:");
		d1.displayDog();
		System.out.println("Cat Object Details before Serialization:");
		c1.displayCat();
		System.out.println("Rat Object Details before Serialization:");
		r1.displayRat();
		System.out.println();
		oos.writeObject(d1);
		oos.writeObject(c1);
		oos.writeObject(r1);
		System.out.println();
		//Performing Deserialization:
		FileInputStream fis = new FileInputStream("dog_cat_rat_2.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		//If we don't know the order of objects in Serialization 
		Object o = ois.readObject();
		while(o != null)
		{
			try
			{
					if(o instanceof Dog)
				{
					Dog d2  = (Dog)o;
					System.out.println("Dog Object Details after Deserialization:");
					d2.displayDog();
				}
				else if(o instanceof Cat)
				{
					Cat c2  = (Cat)o;
					System.out.println("Cat Object Details after Deserialization:");
					c2.displayCat();
				}
				else
				{
					Rat r2 = (Rat)o;
					System.out.println("Rat Object Details after Deserialization:");
					r2.displayRat();
				}
				o = ois.readObject();
			}
			catch(EOFException e)
			{
				break;
			}
		}

		

	}
}