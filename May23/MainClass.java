
package mypack;
class Employee {

	int empno;
	String ename;

	Salary sal;
	
	public Employee() {
	  System.out.println("From Employee Constructor");
	  sal = new Salary();
	}
	
	public Employee(int x, String ename) {
		  this.empno=x;
		  this.ename=ename;
		  System.out.println("From Employee Constructor");
		  sal = new Salary();
	}

	public void getDetails() {
		System.out.println(empno + " -- " + ename + " --- " + sal);
	}
	
	 public void CalSalary(double basic) {
	        sal.setBasic(basic);
	        sal.setDa(0.5 * basic); 
	        sal.setPf(0.3 * basic); 
	        sal.setGross(basic + sal.getDa() - sal.getPf());
	        sal.setNet(sal.getGross());
	    }

}

class Manager extends Employee {
	String dept;
	String name;
	int id;
	
	public Manager() {}
	

	public Manager(int id,String name,String dept) {
		super(); 
		this.dept=dept;
		this.name=name;
		this.id=id;
		 // used to invoke base clas constructor
		System.out.println("From Mgr Constr");
	}



	public void getDetails() {
		System.out.println(id + " -- " + name + "--  " + dept);
	}
	
	

}

public class MainClass {
	

	public static void main(String[] args) {
		Employee emp = new Employee(444,"Odelu");
		
	     emp.CalSalary(40000); 
		 emp.getDetails();

		Manager mgr = new Manager(555,"Jhansi","Backend");
		
		mgr.getDetails();

	
	}

}