package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/beans.xml");
		System.out.println("Spring Bean Container 생성완료");
		TV lg = factory.getBean("lg",TV.class);
		TV samsung = factory.getBean("samsung",TV.class);
		
		lg.powerOn();
		lg.volumeUp();
		lg.volumeDown();
		lg.powerOff();
		
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeDown();
		samsung.powerOff();

	}

}
