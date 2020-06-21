package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		Developer bean1 = (Developer) factory.getBean("less");
		System.out.println(bean1);
		
		Engineer bean2 =  factory.getBean("honggd",Engineer.class);
		System.out.println(bean2);
		

	}

}
