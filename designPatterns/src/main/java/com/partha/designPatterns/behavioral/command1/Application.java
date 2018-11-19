package com.partha.designPatterns.behavioral.command1;

public class Application {

	public static void main(String[] args) {
		
		Television tv=new Television();	
		TurnOn command1=new TurnOn(tv);
		command1.execute();
		TurnOff command2=new TurnOff(tv);
		command2.execute();

	}

}
