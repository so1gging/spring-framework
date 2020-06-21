package com.test04;

public class Woman implements Person{

	@Override
	public String classWork() {
		System.out.println("카트를 한다.");
		return "프로게이머";
	}

}
