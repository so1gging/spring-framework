package com.test06;

public class samsungTV implements TV{

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
