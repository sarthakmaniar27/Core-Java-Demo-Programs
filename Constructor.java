/*
class P
{
	
	P()
	{
		int x = 20;
		System.out.println(x); //20
	}
}

class C extends P
{
	C(int x)
	{
		super();
		System.out.println(x); //10

	}
}
class Constructor 
{
	
	public static void main(String[] args)
	{
		C c = new C(10);
	}
}


class A
{
	int l =10;
	A(int i)
	{
		System.out.println(i);
	}
}
class B extends A
{
	int l =20;
	B(int i,int j)
	{
		super(i);
		System.out.println(j);
	}
}
class C extends B
{
	int l =30;
	C(int i,int j,int k)
	{
		super(i,j);
		System.out.println(k);
	}
}
class Constructor 
{
	
	public static void main(String[] args)
	{
		C c = new C(111,222,333);
	}
}



class Constructor{
      int  value1;
      int  value2;
      Constructor(){
         value1 = 10;
         value2 = 20;
         System.out.println("Inside Constructor");
     }
 
     public void display(){
        System.out.println("Value1 === "+value1);
        System.out.println("Value2 === "+value2);
    }
 
   public static void main(String args[]){
       Constructor d1 = new Constructor();
      d1.display();
  }
}


class Constructor{
      int  value1;
      int  value2;
       Constructor(){
       value1 = 10;
       value2 = 20;
       System.out.println("Inside 1st Constructor");
     }
     Constructor(int a){
      value1 = a;
      System.out.println("Inside 2nd Constructor");
    }
    Constructor(int a,int b){
    value1 = a;
    value2 = b;
    System.out.println("Inside 3rd Constructor");
   }
   public void display(){
      System.out.println("Value1 === "+value1);
      System.out.println("Value2 === "+value2);
  }
  public static void main(String args[]){
    Constructor d1 = new Constructor();
    Constructor d2 = new Constructor(30);
    Constructor d3 = new Constructor(30,40);
    d1.display();
    d2.display();
    d3.display();
 }
}

*/

/*
class Constructor{
   int  value1;
   int  value2;
   int value5; 
    Constructor(){
      value1 = 1;
      value2 = 2;
      System.out.println("Inside 1st Parent Constructor");
      System.out.println(value5);
   }
   Constructor(int a){
      value1 = a;
      System.out.println("Inside 2nd Parent Constructor");
   }
  public void display(){
     System.out.println("Value1 === "+value1);
     System.out.println("Value2 === "+value2);
  }
  public static void main(String args[]){
     ConstructorChild d1 = new ConstructorChild();
     d1.display();
  }
}
class ConstructorChild extends Constructor{
    int value3;
    int value4;
    ConstructorChild(){
     //super(5);
     value3 = 3;
     value4 = 4;
    System.out.println("Inside the Constructor of Child");
    }
    public void display(){
      System.out.println("Value1 === "+value1);
      System.out.println("Value2 === "+value2);
      System.out.println("Value1 === "+value3);
      System.out.println("Value2 === "+value4);
   }
}
*/
class P
{
	P(int i)
	{

	}
	P()
	{

	}

}
class C extends P
{

}
class 	Constructor
{
	public static void main(String[] args)
	{
		Constructor c = new Constructor();

	}
}