package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		School p = factory.getBean("mySchool",School.class);
		System.out.println(p);
		// Qualifier 를 통해 이름을 정해주었다.
		// Autowired를 통해 먼저 Type을 검사한다.
		// 똑같은 타입의 bean이 두 개 이상이라면, name으로 검색을 하는 것이다.
	}
}
