package com.partha.designPatterns.behavioral.command1;

public class TurnOff implements Command {
	
	ElectronicDevice theDevice;
	
	public TurnOff(ElectronicDevice newDevice){
		theDevice=newDevice;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theDevice.off();
	}


}
