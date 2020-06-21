package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Emp lee = (Emp)factory.getBean("lee");
		Emp kim = (Emp)factory.getBean("kim");
		
		System.out.println(lee);
		System.out.println(kim);
	}

}
