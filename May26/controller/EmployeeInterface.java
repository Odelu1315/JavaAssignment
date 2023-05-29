package com.dedalus.controller;

import java.io.IOException;
import java.util.List;

import com.dedalus.model.Employee;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee();
	public List<Employee> getEmplist();
	public void serialize(List<Employee> emp) throws IOException;
	public void deserialize(String filename) throws IOException;
}
