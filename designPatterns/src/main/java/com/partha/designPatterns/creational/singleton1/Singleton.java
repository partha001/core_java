package com.partha.designPatterns.creational.singleton1;

public class Singleton {
	
	private static Singleton Singleton_obj;
	
	/* to prevent object creation first we declare a private constructor */
	private Singleton(){
		
	}
	
	/*
	 * public static synchronized Singleton getInstanceOfSingleton(){
	 */
	public static Singleton getInstanceOfSingleton(){
		if(Singleton_obj==null){
			Singleton_obj=new Singleton();
		}
		return Singleton_obj;
	}


}
