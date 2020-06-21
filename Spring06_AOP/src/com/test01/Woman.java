package com.test01;

public class Woman {
	public void ClassWork() {
		System.out.println("출석카드를 찍는다.");
		
		try {
			System.out.println("카트라이더를 한다.");	
		} catch (Exception e) {
			System.out.println("쉬는날이네?");
		}finally {
			System.out.println("집에 간다.");
		}
	}
}
