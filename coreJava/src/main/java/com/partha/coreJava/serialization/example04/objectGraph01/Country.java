package com.partha.coreJava.serialization.example04.objectGraph01;

import java.io.Serializable;

public class Country implements Serializable {
	
	private String name;
	

	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
