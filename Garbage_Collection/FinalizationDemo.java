
class FinalizationDemo
{
	public static void main(String[] args) 
	{
		//String s = new String("Sarthak");
		FinalizationDemo s = new FinalizationDemo();
		s=null;
		System.gc();
		//Now there are two threads: main and demon(gc)
		System.out.println("End of Main");
	}
	public void finalize()
	{
		//System.out.println("finalize() method called");
		System.out.println("Garbage collector called finalize() method");
	}
}