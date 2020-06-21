package com.test00;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Aspect 역할을 할 클래스라고 명시해줌
public class MyAspect{
	
	@Before("execution(public void bark(..))")
	public void before(JoinPoint join) {
		System.out.println("Proxy Object : "+join.getThis().getClass());
		System.out.println("jointPoint method"+join.getSignature().toShortString());
		//공통기능(Advice)이 적용되는 메소드가 어떤 메소드 인지.
		System.out.println("jointPoint class : "+join.getTarget().getClass());
		// 공통기능(Advice)이 적용되는 메소드가 어떤 클래스 인지
		System.out.println("강아지가 짖습니다.");
	}
	
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("jointPoint method"+join.getSignature().toShortString());
		System.out.println("jointPoint class : "+join.getTarget().getClass());
		System.out.println("강아지가 짖지 않습니다.");
	}

}
