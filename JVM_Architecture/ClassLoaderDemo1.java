class ClassLoaderDemo1
{
 	public static void main(String[] args) 
 	{
 		System.out.println(String.class.getClassLoader());	//null --> bcoz Bootstrap class Loader is responsible to load this String class and Bootstrap class Loader in not implemented in java, so it gives null
 		System.out.println(ClassLoaderDemo1.class.getClassLoader()); //Application class Loader is responsible to load this ClassLoaderDemo1.class
 	}
}