package com.partha.mm.example01;

public class App03ExploringFinal {

	public static void main(String[] args) {

		
		final Employee emp ;
		emp = new Employee(10,"partha");
		emp.name = "mimi";
		System.out.println(emp.name);
		
		
		
//		final Employee emp2 = null;
//		emp2 = new Employee(20,"saikat");
	}
	
	
	
	public static class Employee{
		
		int empid;
		String name;
		
		public Employee(int empid, String name) {
			super();
			this.empid = empid;
			this.name = name;
		}
		
		
	}

}
