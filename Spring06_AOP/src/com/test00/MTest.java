package com.test00;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test00/applicationContent.xml");
		factory.getBean("myDog",Dog.class).bark();

	}

}
