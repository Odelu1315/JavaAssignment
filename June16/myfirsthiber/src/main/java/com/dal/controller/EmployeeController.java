package com.dal.controller;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.dal.model.Employee;


public class EmployeeController {
	 SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txn;
	    Employee emp;
	    Scanner sc = new Scanner(System.in);
	    public void addEmployee() {
	        txn = session.beginTransaction();

	        emp = new Employee();
	        System.out.println("Enter your First Name:");
	        String fname = sc.next();        
	        emp.setEname(fname);            
	        session.save(emp);
	        txn.commit();
	        System.out.println("Employee Successfully Created... :)");
		
		
	}

}
