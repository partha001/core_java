package com.partha.designPatterns.behavioral.observer1;

public class Observer1 implements Observers {

	private double googlePrice; 
	private double yahooPrice;
	private StockGrabber stockGrabber;
	
	//notice the using a constructor makes it mandatory to specify a Subject mandatory
	//against which the observer will be registered automatically upon its creation
	public Observer1(StockGrabber stockGrabber){
		this.stockGrabber=stockGrabber;
		stockGrabber.addObserver(this);
	}
	
	
	@Override
	public void updateStockPrice(double googlePrice, double yahooPrice) {
		// TODO Auto-generated method stub
		this.googlePrice=googlePrice;
		this.yahooPrice=yahooPrice;
		System.out.println("stock prices updated for obsever1");

	}
}
