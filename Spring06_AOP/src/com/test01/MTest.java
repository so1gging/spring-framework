package com.test01;

public class MTest {

	public static void main(String[] args) {
		
		Woman w = new Woman();
		Man m = new Man();
		System.out.println("여학생 입장");
		w.ClassWork();
		System.out.println("----------");
		System.out.println("남학생 입장");
		m.ClassWork();
		
		// 공통적으로 들어가는 중복되는 코드가 존재한다.!
		// Primary Concern : 카트를 한다 & 흐드미 연결
		// Cross-Cutting Concern : 출석카드를 찍는다 & 쉬는날이네? & 집에간다
	}

}
