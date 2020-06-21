package com.test07;

public class samsungTV implements TV{

	public samsungTV() {
		System.out.println("samsung tv생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv On");	
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv Off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv Volume Up");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("samsung tv Volume Down");
	}

}
