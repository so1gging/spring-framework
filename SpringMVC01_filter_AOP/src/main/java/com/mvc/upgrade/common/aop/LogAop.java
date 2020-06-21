package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	public void before(JoinPoint join) {
		// AOP 관련해서 JoinPoint를 파라미터로 전달받을 경우 반드시 첫번째 파라미터로 지정해야 함(그 외는 예외 발생)
		// JoinPoint 인터페이스는 호출되는 대상의 객체, 메서드, 그리고 전달되는 파라미터 목록에 접근할 수 있는 메서드를 제공한다.
			/*
		 	Signature getSignature( ) - 호출되는 메서드에 대한 정보를 구함
  			Object getTarget( ) - 대상 객체를 구함
  			Object[ ] getArgs( ) - 파라미터 목록을 구함
  			*/
		
		// org.aspectj.lang.Signature 인터페이스는 호출되는 메서드와 관련된 정보를 제공하기 위해 다음과 같은 메서드를 정의

		/*
		 * String getName( ) - 메서드의 이름을 구함
			String toLongName( ) - 메서드를 완전하게 표현한 문장을 구함(메서드의 리턴 타입, 파라미터 타입 모두 표시)
			String toShortName( ) - 메서드를 축약해서 표현한 문장을 구함(메서드의 이름만 구함)

		 * 
		 * */

		Logger logger = LoggerFactory.getLogger(join.getTarget()+""); //대상 객체 지정
		logger.info("-------Aop Start-------");
		// appender라는 친구한테 던져준다.
		// appender가 해당 문자들을 관리.
		
		Object[] args = join.getArgs(); // 대상 객체의 파라미터를 가져온다. 
		if(args != null) {
			
			logger.info("method: "+join.getSignature().getName());
			for(int i=0;i<args.length;i++) {
				logger.info(i+"번째"+args[i]);
				
			}
		}
		
		System.out.println("before end");
	}
	
	public void after(JoinPoint join) {
		
		System.out.println("after start");
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-------Aop End-------");
		
	}
	
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("---------Error Log----------");
		logger.info("ERROR : "+join.getArgs());
		logger.info("ERROR: "+join.toString());
		
	}
	
}
