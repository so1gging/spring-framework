package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// [1] emp 완성
		// [2] .xml완성 <!-- bean 2개 설정(1.생성자 이용, 2. setter 이용) -->
		// [3] main 완성 // getBean() 을 통한 생성된 bean 주입 후 // 각 bean의 필드값 출력.
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Emp emp1 = (Emp) factory.getBean("emp1");
		Emp emp2 = (Emp) factory.getBean("emp2");
		
		System.out.println(emp1);
		System.out.println(emp2);
		
	}

}
