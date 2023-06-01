package com.dedalus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dal.dao.EmployeeDao;
import com.dedalus.model.Employee;

public class EmployeeController implements EmployeeInterface,Serializable {
	
	Scanner sc = new Scanner(System.in);
	Employee emp;
	EmployeeDao empdao = new EmployeeDao();
	List<Employee> emplist = new ArrayList<Employee>(); 
	
	public void addEmployee()
	{		
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno =sc.nextInt();
		emp.setEmpno(eno);
		
		System.out.println("Enter Ename");
		String ename =sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		empdao.insertEmployee(emp);
		System.out.println("Employee Added Successfully");
		
	}
	public void updEmployee()
	{		
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno =sc.nextInt();
		emp.setEmpno(eno);
		
		System.out.println("Enter Ename");
		String ename =sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		empdao.updateEmployee(emp);
		System.out.println("Employee updated Successfully");
		
	}
	
	public void delEmployee()
	{		
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno =sc.nextInt();
		emp.setEmpno(eno);
		
		//System.out.println("Enter Ename");
		//String ename =sc.next();
		//emp.setEname(ename);
		emplist.add(emp);
		empdao.deleteEmployee(emp);
		System.out.println("Employee deleted Successfully");
		
	}

	public List<Employee> getEmplist(){
		return emplist;
	}
	
	public void viewEmployee() {
		//System.out.println(emp.getEmpno());
		//System.out.println(emp.getEname());
		
		//System.out.println(emplist);
		
		Iterator<Employee> i = emplist.iterator();
		
		//METHOD -1
		/*
		while(i.hasNext()) {
			System.out.println(i.next());
		}*/
		
		//Method -2
		
		emplist.forEach(e->System.out.println(e));
		System.out.println("Dataas from DB:");
		empdao.showEmployee();
		
		
	}
	
	public void serialize(List<Employee> emp) throws IOException {
		try{
			//emp = new Employee();
		
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emp);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
		catch(Exception e) {
			System.out.println("exception");
		}
	}
	public void deserialize(String filename) throws IOException {
		try{	
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<Employee> emp =(List<Employee>)ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			for(int i=0;i<emp.size();i++) {
				System.out.println("Employee No."+emp.get(i).getEmpno());
				System.out.println("Employee Name"+emp.get(i).getEname());
			}
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
		catch(Exception e) {
			System.out.println("Exception");
		}

	}

}