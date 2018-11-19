package com.partha.designPatterns.behavioral.strategy1;

public class Animal {
	
	private String name;
	private int height;
	private int weight;

	//this is the new property that is added
	public Flys flyingType;

	//this is the method that we have added to suffice the new requirement
	public String tryToFly(){
		return flyingType.fly();
	}

	//generating getters and setter methods for the old attributes
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	//getters and setters for the new class attribute
	public Flys getFlyingType() {
		return flyingType;
	}

	public void setFlyingType(Flys flyingType) {
		this.flyingType = flyingType;
	}


}


class Dog extends Animal {	
	//note that in the constructor of the dog class we are deciding its flytype
	public Dog(){
		super();
		flyingType=new CantFly();
	}
}


class Bird extends Animal {
	//similarly note that in the constructor of the bird class we are deciding its flytype
		public Bird(){
			super();
			flyingType=new CanFly();
		}
	}

