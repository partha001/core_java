package com.partha.designPatterns.structural.adapter1;

public class TurkeyTypeB implements Turkey{

	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		System.out.println("turkeyB gobbles not so loud");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("turkeyB flies high");
	}

}
