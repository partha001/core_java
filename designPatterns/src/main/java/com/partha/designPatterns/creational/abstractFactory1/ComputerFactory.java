package com.partha.designPatterns.creational.abstractFactory1;

public class ComputerFactory {
	
	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}

}
