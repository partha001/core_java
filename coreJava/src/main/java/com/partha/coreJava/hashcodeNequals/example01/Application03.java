package com.partha.coreJava.hashcodeNequals.example01;

/**
 * this is another example to demonstrate that the == operator doesnt 
 * depend on hashcode
 * @author partha
 *
 */
public class Application03 {

	public static void main(String[] args) {
		Emp emp1= new Emp(1,"partha");
		Emp emp2= new Emp(1,"partha");
				
		//System.out.println("s1-hashcode:"+s1.hashCode() + "   s2-hashcode:"+s2.hashCode());
		System.out.println("emp1-hashcode:"+emp1.hashCode() + "   emp2-hashcode:"+emp2.hashCode());
		
		System.out.println(emp1==emp2);
	}

}

class Emp {
	private int empid;
	private String empname;

	public Emp(int empid, String empname) {
		super();
		this.empid = empid;
		this.empname = empname;
	}
		
}
