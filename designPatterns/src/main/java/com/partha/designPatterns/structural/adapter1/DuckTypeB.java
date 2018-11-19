package com.partha.designPatterns.structural.adapter1;

public class DuckTypeB implements Duck{

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("duckB quacks not-so-loud");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("duckB flies low");
	}

}

