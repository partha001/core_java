package com.partha.designPatterns.structural.adapter1;

public class Application {


	public static void main(String[] args) {
		Duck duck1=new DuckTypeA();
		printDuckdetails(duck1);
		
		//see how a turkey object is converted to type Duck
		//with the help of the adapter so that it is 
		//acceptable to the method printDuckdetails()
		Turkey turkey1=new TurkeyTypeA();
		Duck duck2=new TurkeyAdapter(turkey1);
		printDuckdetails(duck2);
		
	}
	
	public static void printDuckdetails(Duck duck_obj){
		System.out.println("duck-hashcode="+duck_obj.hashCode());
		duck_obj.quack();
		duck_obj.fly();
		System.out.println("\n");
	}


}
