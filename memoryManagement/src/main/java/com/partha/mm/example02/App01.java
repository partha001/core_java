package com.partha.mm.example02;

public class App01 {

	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		
		
		// == checks for referrence equality 
		// whereas .equals() checks for referrence equality	
		System.out.println(a==b);
		
		//here "hello" is a internalized immutable object which is reused by the compiler.
		System.out.println("***************************************");
		
		
		//in this case the String value of three is not internalized
		String three = new Integer(76).toString();
		String four = "76";
		System.out.println(three==four);
		System.out.println("***************************************");
		
		
		//however if we want to explicitly internalize it 
		String five = new Integer(76).toString().intern();
		String six = "76";
		System.out.println(five==six);
		
	}

}
