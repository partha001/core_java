package com.partha.coreJava.hashcodeNequals.example01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * this program is to demonstrate the inconsistency that will arise
 * if the hashcode() and equals() contract is broken
 * @author partha
 *
 */
public class Application05 {

	public static void main(String[] args) {
		Car car1 = new Car(1,20,"aaa");
		System.out.println("input car details : "+car1.toString());
		
		Map<Car, Car> map = new HashMap<Car, Car>();
		map.put(car1, car1);
		System.out.println("map size after inserting first car:"+ map.size());
		

		
		//now lets say am updating the name of car1
		car1.milage=50;
		car1.modelname="bbb";
		System.out.println("updated car details : "+car1.toString());
		
		map.put(car1, car1);
		System.out.println("map size after updating first car:"+ map.size());
		
	}
}

class Car {
	
	int uniqueid;
	int milage;
	String modelname;
	
	public Car(int uniqueid, int milage, String modelname) {
		super();
		this.uniqueid = uniqueid;
		this.milage = milage;
		this.modelname = modelname;
	}

	@Override
	public int hashCode() {
		return this.milage;
	}

	@Override
	public boolean equals(Object obj) {
		Car car= (Car)obj;
		return this.uniqueid==car.uniqueid;
	}

	@Override
	public String toString() {
		return "Car [uniqueid=" + uniqueid + ", milage=" + milage + ", modelname=" + modelname + "]";
	}

	
}
