package com.partha.coreJava.hashcodeNequals.example01;

/**
 * this is another example to demonstrate that the == operator doesnt 
 * depend on hashcode
 * @author partha
 *
 */
public class Application02 {

	public static void main(String[] args) {
		Employee emp1= new Employee(1,"partha");
		Employee emp2= new Employee(1,"partha");
		
		String s1 =new String("test1");
		String s2 =new String("test1");
		
		System.out.println("emp1-hashcode:"+emp1.hashCode() + "   emp2-hashcode:"+emp2.hashCode());
		
		System.out.println(emp1==emp2);
	}

}

class Employee {
	private int empid;
	private String empname;
	
	@Override
	public int hashCode() {
		return this.empid;
	}

	public Employee(int empid, String empname) {
		super();
		this.empid = empid;
		this.empname = empname;
	}
		
}
