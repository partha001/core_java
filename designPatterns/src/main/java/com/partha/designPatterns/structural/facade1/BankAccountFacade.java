	package com.partha.designPatterns.structural.facade1;

public class BankAccountFacade {
	

	private int accountNumber;
	private int securityCode;
	
	WelcomeToBank bankWelcome;
	AccountNumberCheck acctChecker;
	SecurityCodeCheck codeChecker;
	FundsCheck fundChecker;
	
	
	public BankAccountFacade(int newAcctNum,int newSecCode){
		
		accountNumber=newAcctNum;
		securityCode=newSecCode;
		
		bankWelcome=new WelcomeToBank();
		acctChecker=new AccountNumberCheck();
		codeChecker=new SecurityCodeCheck();
		fundChecker=new FundsCheck();
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	public int getSecurityCode(){
		return securityCode;
	}
	
	public void withdrawCash(double cashToGet){
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode()) &&
				fundChecker.haveEnoughMoney(cashToGet))
		{
			System.out.println("transaction complete\n");
		}
		else
		{
			System.out.println("transaction failed");
		}
	}
	
	public void depositCash(double cashToDeposit){
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode()))
		{
			fundChecker.makeDeposit(cashToDeposit);
			System.out.println("transaction deposited successfully\n");
		}
		else
		{
			System.out.println("transaction failed");
		}
	}


}
