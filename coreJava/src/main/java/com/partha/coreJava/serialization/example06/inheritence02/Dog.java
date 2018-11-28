package com.partha.coreJava.serialization.example06.inheritence02;

import java.io.Serializable;

public class Dog extends Animal implements Serializable{
	
	int j;

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
		
}
