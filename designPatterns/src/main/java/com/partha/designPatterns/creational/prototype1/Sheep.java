package com.partha.designPatterns.creational.prototype1;

public class Sheep implements Animal{

	@Override
	public Animal makeCopy() {
		System.out.println("sheep is being made");
		Sheep sheepObject=null;
		try {
			sheepObject=(Sheep)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return sheepObject;
		
	}
	
	public Sheep(){
		System.out.println("sheep is made");
	}
	
	public String toString(){
		return "dolly is my hero , Baaa";
	}

}
