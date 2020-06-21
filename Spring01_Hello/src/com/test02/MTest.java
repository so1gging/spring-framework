package com.test02;

public class MTest {

	public static void main(String[] args) {
		MessageBean bean = new MessageBeanEn(); // 다형성
		bean.sayHello("Spring");
		
		bean = new MessageBeanKo();
		bean.sayHello("스프링");
		// 서로간의 간섭을 조금씩 줄인다. => 결합도를 낮춤
		// 어느 자식이 들어가든지 bean에 다 들어갈 수 있다.(MessageBean을 구현한 자식객체.)
		
		// DI : 객체를 스프링이 만들어서 우리가 사용을 할 것이다.
		

	}

}
