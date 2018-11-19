package com.partha.designPatterns.creational.factory1;

public abstract class IceCream {
	
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public   void showPrice(){
		System.out.println("icecream price = "+price);
	}
	public  void showName(){
		System.out.println("icecream name = "+name);
	}


}
