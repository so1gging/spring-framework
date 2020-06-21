package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {
	private MyClass myClass;
	
	
	public BeanTest() {
		System.out.println("기본 생성자(no-args)");
	}
	
	
	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date: "+date+")");
	}
	
	/////////////////////
	public void setMyClass(MyClass myclass) {
		this.myClass = myclass;
		System.out.println("setMyClass() called : "+ myClass);
	}
	
	public void setDate(Date date) {
		System.out.println("setDate() called : "+date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber() called : "+num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("setStudent() called");
		for(String str:arr) {
			System.out.println(str);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList() called");
		for(String v:list) {
			System.out.println(v);
		}
	}
	
	public void setSet(Set<String> set) {
		System.out.println("setSet() called");
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			String element = (String) it.next();
			System.out.println(element);
			
		}
		
		
	}
	
	public void setMap(Map<String,String> map) {
		System.out.println("setMap() called");
		// map은 entry로 이루어져있다.
		Collection<String> values = map.values();
		for(String v:values) {
			System.out.println(v);
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore() 호출");
		for(Score sc:list) {
			System.out.println(sc);
		}
	}
	
	
}
