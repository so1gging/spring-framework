package com.test03;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("LG TV ON");
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV OFF");
	}

	@Override
	public void volumnUp() {
		System.out.println("LG TV VOL UP");
	}

	@Override
	public void volumnDown() {
		System.out.println("LG TV VOL DOWN");
		
	}

}
