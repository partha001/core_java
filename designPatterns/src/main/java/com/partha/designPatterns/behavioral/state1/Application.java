package com.partha.designPatterns.behavioral.state1;

public class Application {

	 public static void main(String[] args)  
	    { 
	        AlertStateContext stateContext = new AlertStateContext(); 
	        stateContext.alert(); 
	        stateContext.alert(); 
	        stateContext.setState(new Silent()); 
	        stateContext.alert(); 
	        stateContext.alert(); 
	        stateContext.alert();         
	    } 

}
