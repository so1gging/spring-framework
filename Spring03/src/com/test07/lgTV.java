package com.test07;

public class lgTV implements TV{
	public lgTV() {
		System.out.println("lg tv생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("lg tv On");
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("lg tv Off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("lg tv Volume Up");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("lg tv Volume Down");
	}

}
