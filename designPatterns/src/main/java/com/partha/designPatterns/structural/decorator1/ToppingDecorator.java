package com.partha.designPatterns.structural.decorator1;


//this class has been made abstract only to make it more flexible 
//the program will run and produce the same output even if we remove the keyword abstract
public  abstract class ToppingDecorator implements Pizza {
	
	protected Pizza tempPizza;
	
	public ToppingDecorator(Pizza newPizza){
		tempPizza=newPizza;
	}
	
	public String getDescription(){
		return tempPizza.getDescription();
	}
	
	public double getCost(){
		return tempPizza.getCost();
	}
	
}
