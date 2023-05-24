package mypack;
import java.util.Scanner;
class Employee {

	int empno;
	String ename = "Odelu";
	Salary sal;
	
	public Employee() {
	  System.out.println("From Employee Constructor");
	  sal = new Salary();
	}
	
	public Employee(int x) {
		  this("Mani");
		  this.empno=x;
		  System.out.println("From Employee Constructor" + x);
		  sal = new Salary();
	}
	
	public Employee(String str) {
		  
		  System.out.println("From Employee Constructor" + str);
	}
	public String getDetails() {
		return (empno + " -- " + ename + " --- " + sal);
	}

}

class Manager extends Employee {
	String dept = "IT";
	

	public Manager() {
		super(888);  // used to invoke base clas constructor
		System.out.println("From Mgr Constr");
		
	}
	public String getDetails() {
		 return super.getDetails()+ "--  " + dept;
	}
	public void CalSalary(double basic) {
		sal.setBasic(basic);
		sal.setDa(0.5 * sal.getBasic());
		sal.setPf(0.3 * sal.getBasic());
		sal.setGross(sal.getBasic() + sal.getDa() - sal.getPf());
		sal.setNet(sal.getGross());
	}

}

public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter basic salary of manager");
		int basicSalary=sc.nextInt();
		Employee emp = new Employee();
		System.out.println(emp.getDetails());
		Manager mgr = new Manager();
		mgr.CalSalary(basicSalary);
		System.out.println(mgr.getDetails());

	}

}