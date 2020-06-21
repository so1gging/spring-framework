package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public String *(..))")
	public void before(JoinPoint join) { //Jointpoint 앞에서 실행되는 Advice
		System.out.println("출석카드를 찍는다.");
	}
	

	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날 이네?"); //예외가 던져 질때 실행되는 Advice
	}
	
	
	/*After Returning 어드바이스
	  타겟의 메서드가 정상적으로 실행된 이후(after) 시점에 처리해야 할 필요가 있는 부가기능을 정의한다.
		-> Jointpoint 메서드 호출이 정상적으로 종료된 뒤에 실행되는 Advice
	 */
	@AfterReturning(pointcut="execution(public * *(..))",returning="returnVal")
	public void returning(JoinPoint join,Object returnVal) {
		System.out.println(returnVal+" 성공");
	}
	
	
	@After("execution(public * com.test04.*.*(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
