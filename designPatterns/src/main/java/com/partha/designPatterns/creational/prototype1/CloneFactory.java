package com.partha.designPatterns.creational.prototype1;

public class CloneFactory {
	

	public Animal getClone(Animal animalSample){
		return animalSample.makeCopy();
	}

}
