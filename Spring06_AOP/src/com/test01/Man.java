package com.test01;

public class Man {
	public void ClassWork() {
		System.out.println("출석카드를 찍는다.");
	
		try {
			System.out.println("HDMI 연결");	
		} catch (Exception e) {
			System.out.println("쉬는날이네?");
		}finally {
			System.out.println("집에 간다.");
		}
		
	}
}
