package com.partha.designPatterns.behavioral.state1;

public class Silent implements MobileAlertState{
	
    @Override
    public void alert(AlertStateContext ctx)  
    { 
        System.out.println("silent..."); 
    } 
  
} 