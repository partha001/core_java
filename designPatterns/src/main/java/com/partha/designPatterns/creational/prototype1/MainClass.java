package com.partha.designPatterns.creational.prototype1;

public class MainClass {

	public static void main(String[] args) {
		CloneFactory animalMaker=new CloneFactory();
		Sheep sally=new Sheep();
		Sheep clonedSheep=(Sheep)animalMaker.getClone(sally);
		System.out.println(sally);
		System.out.println(clonedSheep);
		System.out.println("sally hashcode:"+System.identityHashCode(System.identityHashCode(sally)));
		System.out.println("cloned hashcode:"+System.identityHashCode(System.identityHashCode(clonedSheep)));
	}

}
