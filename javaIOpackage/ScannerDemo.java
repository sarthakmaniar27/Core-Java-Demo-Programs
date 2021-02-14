import java.util.*;

class ScannerDemo
{
	public static void main(String[] args) throws Exception
	{
			Scanner sc = new Scanner(System.in);
			System.out.print("Employee Number : ");
			int eno = sc.nextInt();
			System.out.print("Employee Name : ");
			String ename = sc.next();
			System.out.print("Employee Salary : ");
			float esal = sc.nextFloat();
			sc.nextLine(); //to read the leftover line
			System.out.print("Employee Address : ");
			String eaddr = sc.nextLine();
			System.out.println("Employee Details");
			System.out.println("-------------------");
			System.out.println("Employee Number : "+eno);
			System.out.println("Employee Name : "+ename);
			System.out.println("Employee Salary : "+esal);
			System.out.println("Employee Address : "+eaddr);
	}
}