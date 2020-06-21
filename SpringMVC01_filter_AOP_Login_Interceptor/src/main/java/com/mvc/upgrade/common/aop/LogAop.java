package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	public void before(JoinPoint join) {
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
