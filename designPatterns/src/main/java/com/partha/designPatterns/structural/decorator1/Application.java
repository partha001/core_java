package com.partha.designPatterns.structural.decorator1;

public class Application {

	public static void main(String[] args) {
		Pizza pizzaObj1 =new TomatoSauce(new Mozzarella(new PlainPizza()));
		System.out.println(pizzaObj1.getDescription() +":"+ pizzaObj1.getCost());

		System.out.println("\n\n");
		Pizza pizzaObj2 =new Mozzarella(new TomatoSauce(new PlainPizza()));
		System.out.println(pizzaObj2.getDescription() +":"+ pizzaObj2.getCost());
	}

}
