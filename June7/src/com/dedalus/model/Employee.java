package com.dedalus.model;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Comparable<Employee>, Serializable {
	private int empno;
	private String ename;
	public Employee() {
		super();
		
	}

	public Employee(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno=empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empno-o.empno;
	}
	
	public static Comparator<Employee> namecomparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (o1.getEname().compareTo(o2.getEname()));
		}
		
	};
}
