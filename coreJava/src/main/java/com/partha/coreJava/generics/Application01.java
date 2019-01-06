package com.partha.coreJava.generics;

public class Application01 {

	public static void main(String[] args) {
		MyClass<String> test=new MyClass<String>("hello generics");
		test.print();
	}

}


