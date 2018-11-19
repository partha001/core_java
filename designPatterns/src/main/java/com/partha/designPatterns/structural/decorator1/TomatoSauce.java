package com.partha.designPatterns.structural.decorator1;


public class TomatoSauce extends ToppingDecorator{

	public TomatoSauce(Pizza newPizza) {
		super(newPizza);
		// TODO Auto-generated constructor stub
		System.out.println("adding tomato souce");
	}

	public String getDescription(){
		return tempPizza.getDescription()+ ",tomato-sauce";
	}
	
	public double getCost(){
		return tempPizza.getCost() + .35;
	}
	
}
