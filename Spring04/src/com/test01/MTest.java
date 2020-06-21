package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		// bean 을 생성
		
		MyClass myclass = (MyClass) factory.getBean("myClass");
		//생성된 bean들 중에 getBean("myClass")
		myclass.prn();

	}

}
