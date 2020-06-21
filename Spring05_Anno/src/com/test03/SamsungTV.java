package com.test03;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("SAMSUNG TV ON");
	}

	@Override
	public void powerOff() {
		System.out.println("SAMSUNG TV OFF");
	}

	@Override
	public void volumnUp() {
		System.out.println("SAMSUNG TV VOL UP");
	}

	@Override
	public void volumnDown() {
		System.out.println("SAMSUNG TV VOL DOWN");
	}

}
