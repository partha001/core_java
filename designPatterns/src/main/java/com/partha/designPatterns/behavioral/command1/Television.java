package com.partha.designPatterns.behavioral.command1;

public class Television implements ElectronicDevice{

	private int volume=0;
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("tv is turned on");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("tv is turned off");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
		System.out.println("volume is turned up to ="+volume);
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volume--;
		System.out.println("volume is turned down to ="+volume);
		
	}

}
