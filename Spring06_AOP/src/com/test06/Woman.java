package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{

	@Override
	public void classWork() {
		System.out.println("카트를 한다.");
	}

}
