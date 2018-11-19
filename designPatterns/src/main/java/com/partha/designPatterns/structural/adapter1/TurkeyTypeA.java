package com.partha.designPatterns.structural.adapter1;

public class TurkeyTypeA implements Turkey{

	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		System.out.println("turkeyA gobbles loud");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("turkeyA flies high");
	}

}

