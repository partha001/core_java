package com.partha.designPatterns.behavioral.strategy1;

public interface Flys {

	public String fly();

}

class CanFly implements Flys{
	public String fly() {
		// TODO Auto-generated method stub
		return "i am flying";
	}

}
 
class CantFly implements Flys {
		public String fly() {
			// TODO Auto-generated method stub
			return "sorry i cant fly";
		}

	}

