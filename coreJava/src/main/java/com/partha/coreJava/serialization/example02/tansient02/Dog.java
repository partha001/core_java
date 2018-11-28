package com.partha.coreJava.serialization.example02.tansient02;

import java.io.Serializable;

public class Dog implements Serializable{
	
	private transient int id;
	private transient String name;
	public static transient int noOflegs=4;
	private final transient int noOfEyes=2;
	public static final transient int noOfEars=2	;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void setNoOflegs(int noOflegs) {
		Dog.noOflegs = noOflegs;
	}
	public int getNoOfEyes() {
		return noOfEyes;
	}
	
	
	

}
