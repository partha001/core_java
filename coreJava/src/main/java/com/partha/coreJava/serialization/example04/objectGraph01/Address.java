package com.partha.coreJava.serialization.example04.objectGraph01;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String nameOfHouse;
	private Country country;
	
	public String getNameOfHouse() {
		return nameOfHouse;
	}
	public void setNameOfHouse(String nameOfHouse) {
		this.nameOfHouse = nameOfHouse;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Address(String nameOfHouse, Country country) {
		super();
		this.nameOfHouse = nameOfHouse;
		this.country = country;
	}
	
	

}
