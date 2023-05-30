package com.dedalus.view;
import com.dedalus.controller.EmployeeController;
import com.dedalus.model.Employee;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import  java.util.Scanner;
import java.util.function.BiPredicate;

class ThreadA implements Runnable {

	public void run() {
		try {
		

				Thread.sleep(3000);

				System.out.println("Please wait , loading.......");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class MainClass {

	public static void main(String[] args) {
		ThreadA ta = new ThreadA();
		Thread t = new Thread(ta);
		
		try {
			String user;
			String pass;
			InputStreamReader i= new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(i);
			
			System.out.println("enter username");
			user =b.readLine();
			
			System.out.println("enter password");
			pass=b.readLine();
			
			BiPredicate<String,String> login =(un,pw)->un.equals("Odelu")&&pw.equals("123");
			if (login.test(user,pass)) {
				
				System.out.println("Welcome " + user);
				System.out.println("Welcome to EMS");
				EmployeeController ec = new EmployeeController();
				Scanner sc =new Scanner(System.in);
				String ch=null;
				t.start();
				
				do {
					System.out.println("Enter your choice");
					System.out.println("1.Add Employee");
					System.out.println("2.View Employee");
					System.out.println("3.Serialization");
					System.out.println("4.Deserialization");
					int choice= sc.nextInt();
					switch(choice) {
					case 1:{
						
						ec.addEmployee();
						break;
					}
					case 2:{
						
						ec.viewEmployee();
						break;
					}
					case 3:{
						ec.serialize(ec.getEmplist());
						break;
						
					}
					case 4:{
						ec.deserialize("dedalus.txt");
						break;
						
					}
					default:{
						System.out.println("enter a valid number");
						break;
					}
					}
					
					System.out.println("Do u want to continue Y | y");
					ch=sc.next();
					
					}while(ch.equals("Y") || ch.equals("y"));
					System.out.println("Thanks for using our system.");
					System.exit(0);
			} else {
				throw new UserNotFoundException();
			}
			
			
			}
		catch (UserNotFoundException user) {
			
			user.printStackTrace();
		}

		catch (Exception ae) {
			System.out.println("IO");
		}
		finally {
			System.out.println("final block executed");
		}
		System.out.println("main block ends");
		}
		}
		