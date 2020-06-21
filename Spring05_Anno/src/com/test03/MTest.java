package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {	
		// 1. factory 생성
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		// 2. getBean 통해 lgTV
		TV lgTV = factory.getBean("lgTV",TV.class);

		// 3. 메소드 4개 실행(on,off,up,down)
		lgTV.powerOn();
		lgTV.volumnUp();
		lgTV.volumnDown();
		lgTV.powerOff();
		
		// 4. getBean 통해 samsungTV
		TV samsungTV = factory.getBean("samsung",TV.class);

		// 5. 메소드 4개 실행(on,off,up,down)
		samsungTV.powerOn();
		samsungTV.volumnUp();
		samsungTV.volumnDown();
		samsungTV.powerOff();	
	}

}
