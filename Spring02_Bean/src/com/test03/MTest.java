package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee);
		
		Address hong = (Address)factory.getBean("hong");
		System.out.println(hong);
		
		// 스프링이 객체를 만들었다.
	}
}
