package com.partha.coreJava.hashcodeNequals.example01;

import java.util.HashSet;
import java.util.Set;

/**
 * this program is to demonstrate the inconsistency that will arise
 * if the hashcode() and equals() contract is broken
 * @author partha
 *
 */
public class Application04 {

	public static void main(String[] args) {
		Student student1= new Student(1,100,"partha");
		Student student2= new Student(1,200,"partha");	
		System.out.println("checking logical equivalance check using equals() returns : "+student1.equals(student2));
		
		Set<Student> set = new HashSet<Student>();
		set.add(student1);
		set.add(student2);
		
		//since the two objects are logical equivalents of each other hence there should be one object in the set.
		//however the below statement print2 this is because the hashcode and equals contract is broken
		System.out.println(set.size());
		
	}
}

class Student{
	
	int roll;
	int a;
	String name;
	
	
	
	public Student(int roll, int a ,String name) {
		super();
		this.roll = roll;
		this.a =a;
		this.name = name;
	}
	
	@Override
	public int hashCode() {	
		return this.a;
	}
	@Override
	public boolean equals(Object obj) {
		Student s=(Student)obj;
		return this.name.equals(s.name) && (this.roll==s.roll) ? true : false ;
	}
	
	
}
