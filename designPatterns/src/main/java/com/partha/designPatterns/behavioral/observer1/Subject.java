package com.partha.designPatterns.behavioral.observer1;

public interface Subject {

	public void addObserver(Observers obs);

	public void deleteObserver(Observers obs);

	public void notifyObservers();


}
