package com.partha.designPatterns.creational.singleton2;

public class Singleton {
	
	private static Singleton first_instance;

	private Singleton(){}

	public static Singleton getInstanceOfSingleton()
	{
		synchronized(Singleton.class){ 
			if(first_instance == null) {
				// If the instance isn't needed it isn't created
				// This is known as lazy instantiation
				first_instance = new Singleton();
			}
		}
		return first_instance;
	}



}
