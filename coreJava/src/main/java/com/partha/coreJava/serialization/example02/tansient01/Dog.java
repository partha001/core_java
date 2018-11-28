package com.partha.coreJava.serialization.example02.tansient01;

import java.io.Serializable;

public class Dog implements Serializable{
	
	private transient int id;
	private transient String name;
	
	
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
	
	

}
