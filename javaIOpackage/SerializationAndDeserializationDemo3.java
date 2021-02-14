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

class SerializationAndDeserializationDemo3
{
	public static void main(String[] args) throws Exception
	{
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Rat r1 = new Rat();
		//Performing Serialization:
		FileOutputStream fos = new FileOutputStream("dog_cat_rat.txt");
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
		FileInputStream fis = new FileInputStream("dog_cat_rat.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog)ois.readObject();
		Cat c2 = (Cat)ois.readObject();
		Rat r2 = (Rat)ois.readObject();
		System.out.println("Dog Object Details after Deserialization:");
		d2.displayDog();
		System.out.println("Cat Object Details after Deserialization:");
		c2.displayCat();
		System.out.println("Rat Object Details after Deserialization:");
		r2.displayRat();

	}
}