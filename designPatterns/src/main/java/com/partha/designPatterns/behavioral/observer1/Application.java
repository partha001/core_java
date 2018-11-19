package com.partha.designPatterns.behavioral.observer1;

public class Application {
	
	public static void main(String[] args) {
		
		StockGrabber stockGrabber=new StockGrabber();
		/* now lets create an observer object oject. upon successful creation it 
		 * would show a message */
		Observers obs_obj=new Observer1(stockGrabber);
		
		/* now lets update the stock prices for StockGrabber object and 
		 * and see whether the same gets reflected in the observer as well or not */	
		stockGrabber.setStockPrices(5000.00, 4000.00);
		}


}
