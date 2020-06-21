package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// Aspect : Advice + PointCut
// Aspect : 공통기능 그 자체
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object target = null; // Advice를 삽입 할 대상 객체
		
		System.out.println("공통기능 : 출석카드를 찍는다.");
		
		try {
			target = invocation.proceed(); // 핵심기능 실행!!!!
		} catch (Exception e) {
			System.out.println("공통기능 : 쉬는날이네?");
		}finally {
			System.out.println("공통기능 : 집에 간다.");
		}
		
		return target;
	}

}
