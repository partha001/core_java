package com.partha.designPatterns.behavioral.chainOfResponsibility1;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);

}
