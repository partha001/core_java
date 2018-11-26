package com.partha.designPatterns.behavioral.state1;

public class Vibration implements MobileAlertState {
	
    @Override
    public void alert(AlertStateContext ctx)  
    { 
         System.out.println("vibration..."); 
    } 
  
} 