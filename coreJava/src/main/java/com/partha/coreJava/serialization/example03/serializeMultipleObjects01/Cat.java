package com.partha.coreJava.serialization.example03.serializeMultipleObjects01;

import java.io.Serializable;

public class Cat implements Serializable{
	
	private  int id;
	private  String name;
	
	
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
