package com.partha.designPatterns.behavioral.chainOfResponsibility1;

public class Currency {
	
	private int amount;

	public Currency(int amt){
		this.amount=amt;
	}

	public int getAmount(){
		return this.amount;
	}
}
