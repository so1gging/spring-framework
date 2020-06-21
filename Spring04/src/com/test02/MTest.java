package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		MyFood myName = factory.getBean("myFoodByName",MyFood.class);
		System.out.println("<< byName >> \n"+myName);
		
		//MyFood myType = factory.getBean("myFoodByType",MyFood.class);
		//System.out.println("<< byType >> \n"+myType);
		
		MyFood myConstructor = factory.getBean("myFoodConstructor",MyFood.class);
		System.out.println("<< byConstructor >> \n"+myConstructor);
		
		MyFood myDefault = factory.getBean("myFoodDefault",MyFood.class);
		System.out.println("<< byDefault >> \n"+myDefault);
	}

}
