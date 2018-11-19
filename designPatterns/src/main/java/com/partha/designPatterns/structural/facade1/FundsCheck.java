package com.partha.designPatterns.structural.facade1;

public class FundsCheck {

public double cashInAccount=1000.00;
	
	public double getCashInAccount(){
		return cashInAccount;
	}
	
	public void decreaseCashInAccount(double cashWithdrawn){
		cashInAccount-=cashWithdrawn;
	}
	
	public void increaseCashInAccount(double cashDeposited){
		cashInAccount+=cashDeposited;
	}
	
	public boolean haveEnoughMoney(double cashToWithdraw){
		if(cashToWithdraw>getCashInAccount()){
			System.out.println("error: you dont have enough money");
			System.out.println("current balance is : "+getCashInAccount());
			return false;
		}
		else{
			decreaseCashInAccount(cashToWithdraw);
			System.out.println("withdrawal complete: current balance is "+getCashInAccount());
			return true;
		}
	}
	
	public void makeDeposit(double cashToDeposit){
		increaseCashInAccount(cashToDeposit);
		System.out.println("deposit complete: current balance is :"+getCashInAccount());
	}
	

}
