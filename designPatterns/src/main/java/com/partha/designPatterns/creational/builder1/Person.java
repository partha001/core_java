package com.partha.designPatterns.creational.builder1;

public class Person {
	
	    private String firstName;
	    private String lastName;
	    private int age;
	   
	    
	   
	    public Person(String firstName,  String lastName, int age) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.age = age;
	    }
	    
	    public static Builder builder(){
	    	return new Builder();
	    }
	    

	    public static class Builder {
	        private String firstName;
	        private String lastName;
	        private int age;
	   
	        

	        public Builder() {
				super();
			}

			public Builder setFirstName(String firstName) {
	            this.firstName = firstName;
	            return this;
	        }

	        public Builder setLastName(String lastName) {
	            this.lastName = lastName;
	            return this;
	        }

	        public Builder setAge(int age) {
	            this.age = age;
	            return this;
	        }

	        

	        public Person build() {
	            return new Person(firstName,lastName, age);
	        }
	    }
	    
}