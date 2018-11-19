package com.partha.designPatterns.structural.decorator1;

public class Mozzarella extends ToppingDecorator{

	public Mozzarella(Pizza newPizza) {
		super(newPizza);
		System.out.println("adding mozzarella");
	}

	public String getDescription(){
		return tempPizza.getDescription()+ ",mozarella";
	}
	
	public double getCost(){
		return tempPizza.getCost() + .50;
	}
	
}
