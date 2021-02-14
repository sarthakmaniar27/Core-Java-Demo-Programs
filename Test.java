import java.lang.*;

// Understanding newInstance() method
/*
class A { 

} 
class B {

 } 
  
 class Test 
{   
  
    public static void main(String[] args) throws InstantiationException, 
    IllegalAccessException, ClassNotFoundException 
    { 
         // Create an object of type 'c'  
        //Object obj = Class.forName(args[0]).newInstance(); 
        // This is to print type of object created 
        //System.out.println("Object created for class:"
          //              + obj.getClass().getName()); 
        Class c=Class.forName(args[0]);
        A a = (A)c.newInstance();
        System.out.println("Object created for class:" + a.getClass().getName());
    
    }    


class Test
{
	String s = new String("Hello");
	String s1;
	String s2 = null;
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.s == null ); //false
		System.out.println(t.s1 == null ); //true
		System.out.println(t.s2== null ); //
	}
}
}
*/
/*
class Test
{	
	public static void main(String[] args) {
		//Integer i = new Integer(null);
		//StringBuffer s = new StringBuffer(null);
		Test t = new  Test();
		System.out.println(t);
	}
}

*/
class Test
{
	public static void main(String[] args) {
		byte a = 40, b = 50;
		byte sum = (byte)a + b;
		System.out.println(sum);
		
	}
}