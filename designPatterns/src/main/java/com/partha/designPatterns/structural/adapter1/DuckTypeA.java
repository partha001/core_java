package com.partha.designPatterns.structural.adapter1;

public class DuckTypeA implements Duck{

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("duckA quacks loud");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("duckA flies high");
	}

}
