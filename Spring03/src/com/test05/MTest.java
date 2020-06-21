package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		Developer ju = factory.getBean("jush",Developer.class);
		Engineer jang = factory.getBean("jangjh",Engineer.class);
		
		System.out.println(ju);
		System.out.println(jang);

	}

}
