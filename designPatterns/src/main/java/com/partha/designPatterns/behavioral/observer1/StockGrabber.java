package com.partha.designPatterns.behavioral.observer1;

import java.util.ArrayList;

public class StockGrabber implements Subject {

	double googlePrice;
	double yahooPrice;

	//this is used to maintain the list of observers
	ArrayList<Observers> obs_list;

	//usning the constructor to initialize the list_of_observers
	public StockGrabber(){
		obs_list=new ArrayList<Observers>();
	}


	@Override
	public void addObserver(Observers obs) {
		this.obs_list.add(obs);
		System.out.println("observer has been added successfully");

	}

	@Override
	public void deleteObserver(Observers obs) {
		// TODO Auto-generated method stub
		int index=obs_list.indexOf(obs);
		obs_list.remove(index);
		System.out.println("observer has been removed successfully");

	}

	//this basically iterates over the list of observers to notify them
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observers obs: obs_list){
			obs.updateStockPrice(googlePrice, yahooPrice);
		}
	}
	



   public void setStockPrices(double googlePrice,double yahooPrice){
		this.googlePrice=googlePrice;
		this.yahooPrice=yahooPrice;
		notifyObservers(); 
   }

}

