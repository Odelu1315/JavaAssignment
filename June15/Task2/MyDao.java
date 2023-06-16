package com.mph.props;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDao {
	private static String dbname;
	private static String uname;
	private static String password;
	private static Connection  con;

	public MyDao() {
		
	}

	public MyDao(String dbname, String uname, String password) {
		super();
		this.dbname = dbname;
		this.uname = uname;
		this.password = password;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static synchronized Connection getMyConnection() {
		try {
			con=DriverManager.getConnection(dbname,uname,password);
			System.out.println(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	

	@Override
	public String toString() {
		return "MyDao [dbname=" + dbname + ", uname=" + uname + ", password=" + password + "]";
	}

}




//public class MyDbConnection {
//	private static Connection  con;
//	private MyDbConnection() {
//		
//	}
//	public static synchronized Connection getMyConnection() {
//		try {
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","131522");
//			System.out.println(con);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return con;
//	}
//	
//
