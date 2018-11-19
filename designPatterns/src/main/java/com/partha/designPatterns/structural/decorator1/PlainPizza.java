package com.partha.designPatterns.structural.decorator1;

public class PlainPizza implements Pizza {
	
public PlainPizza(){
	System.out.println("making the plain pizza");
}

@Override
public String getDescription() {
	return "plain pizza";
}

@Override
public double getCost() {
	return 4.00;
}
}

