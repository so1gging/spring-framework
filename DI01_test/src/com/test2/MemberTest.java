package com.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test2/member.xml");
		MemberService ms = (MemberService) factory.getBean("memberService");
		ms.listMembers();

	}

}
