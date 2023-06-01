package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.dal.util.MyDbConnection;
import com.dedalus.model.Employee;

public class EmployeeDao {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into DEDAEMP values(?,?)");
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dedaemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateEmployee(Employee emp) {
	    con = MyDbConnection.getMyConnection();
	    try {
	        ps = con.prepareStatement("update dedaemp set ename=? where empno=?");
	        ps.setString(1, emp.getEname());  // Set the name as the first parameter
	        ps.setInt(2, emp.getEmpno());     // Set the employee number as the second parameter
	        int noOfRows = ps.executeUpdate();
	        System.out.println(noOfRows + " row(s) updated successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

public void deleteEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("delete from dedaemp where empno=?");
			ps.setInt(1, emp.getEmpno());
			//ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got deleted from DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
}