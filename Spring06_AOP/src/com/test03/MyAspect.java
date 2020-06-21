package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect{
	// JoinPoint : 어드바이스가 적용될 수 있는 위치
	// => Advice(타켓(핵심기능을 담고있는 모듈)에 제공할 부가기능을 담고있는 모듈)를 적용해야 되는 부분
	// (ex : 필드, 메소드 / 스프링에서는 메소드만 해당) 

	public void before(JoinPoint join) {
		System.out.println("jointPoint method"+join.getSignature().toShortString());
		//공통기능(Advice)이 적용되는 메소드가 어떤 메소드 인지.
		System.out.println("jointPoint class : "+join.getTarget().getClass());
		// 공통기능(Advice)이 적용되는 메소드가 어떤 클래스 인지
		System.out.println("출석카드를 찍는다");
	}
	
	public void after(JoinPoint join) {
		System.out.println("jointPoint method"+join.getSignature().toShortString());
		System.out.println("jointPoint class : "+join.getTarget().getClass());
		System.out.println("집에 간다.");
	}

}
