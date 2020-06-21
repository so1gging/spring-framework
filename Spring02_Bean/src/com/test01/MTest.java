package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean banana = (MessageBean) factory.getBean("banana");
		
		banana.sayHello(); // 아무런 설정 없이 bean만 생성하면 기본생성자를 통해 생성된다.
		
		MessageBean apple = (MessageBean) factory.getBean("apple");
		apple.sayHello();
		
		MessageBean mango = (MessageBean) factory.getBean("mango");
		mango.sayHello(); 
		
		// 매개변수를 순서대로 해주어야 한다.
		
	}

}
