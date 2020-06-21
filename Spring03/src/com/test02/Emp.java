package com.test02;

public class Emp {
	private String name;
	private int salary;

	//1. 생성자(기본, 매개변수)
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	//2. getter/setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	//3. toString

	@Override
	public String toString() {
		return "Emp [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
