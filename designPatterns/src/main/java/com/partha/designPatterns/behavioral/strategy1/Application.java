package com.partha.designPatterns.behavioral.strategy1;

public class Application {

	public static void main(String[] args) {

		Animal animal1=new Dog();
		animal1.setName("sparky");
		System.out.println("type="+animal1.getClass()+"      name="+animal1.getName()+"       try_to_fly="+animal1.tryToFly());

		Animal animal2=new Bird();
		animal2.setName("sweety");
		System.out.println("type="+animal2.getClass()+"     name="+animal2.getName()+"       try_to_fly="+animal2.tryToFly());

	}

}
