package com.partha.designPatterns.creational.singleton1;

/**
 * this is not threadsafe
 * @author partha
 *
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton Singleton_obj1=Singleton.getInstanceOfSingleton();
		System.out.println(Singleton_obj1.hashCode());
		Singleton Singleton_obj2=Singleton.getInstanceOfSingleton();
		System.out.println(Singleton_obj2.hashCode());

	}

}
