package com.partha.designPatterns.structural.bridge1;

public class Triangle extends Shape {
	

	public Triangle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	} 

}
