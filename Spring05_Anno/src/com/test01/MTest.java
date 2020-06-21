package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 어노테이션 없이
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		// 어노테이션 이용
		
		MyNickNamePrn myNick = factory.getBean("myNickName",MyNickNamePrn.class);
		System.out.println(myNick);
		
	}
}
