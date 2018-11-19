package com.partha.designPatterns.structural.adapter1;

public class TurkeyAdapter implements Duck {

	Turkey turkey;
	
	public TurkeyAdapter(Turkey new_turkey){
		turkey=new_turkey;
	}
	
	
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		turkey.gobble();
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		turkey.fly();
		
	}

}

