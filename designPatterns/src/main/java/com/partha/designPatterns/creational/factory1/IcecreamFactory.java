package com.partha.designPatterns.creational.factory1;

public class IcecreamFactory {
	
	public IceCream makeIcecream(String type)
	{
		if(type.equals("chocolate")){
			return new ChocolateIcecream();
		}
		else if(type.equals("vanilla")){
			return new VanillaIcecream();	
		}
		else 
			return null;
	}


}
