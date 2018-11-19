package com.partha.designPatterns.behavioral.command1;

public class TurnOn implements Command{

	ElectronicDevice theDevice;
	
	public TurnOn(ElectronicDevice newDevice){
		theDevice=newDevice;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theDevice.on();
	}

}
