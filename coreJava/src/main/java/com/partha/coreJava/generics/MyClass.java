package com.partha.coreJava.generics;

public class MyClass<T> {
	
	T variable1 ;

	public MyClass(T obj){
		this.variable1=obj;
	}
	
	
	public void print(){
		System.out.println(this.variable1);
	}
	
}
