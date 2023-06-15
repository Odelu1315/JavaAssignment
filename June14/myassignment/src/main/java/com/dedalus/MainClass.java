package com.dedalus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dedalus.assignment;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("assign.xml");
		assignment assig =(assignment)context.getBean("assig");
		System.out.println(assig.sayHi());

	}

}
