package com.partha.designPatterns.creational.builder1;

import com.partha.designPatterns.creational.builder1.Person.Builder;

public class BuilderPattern {

	public static void main(String[] args) {
		 Person person = Person.builder()
		 		.setFirstName("partha")
		 		.setLastName("biswas")
		 		.setAge(30)
		 		.build();
	}

}
