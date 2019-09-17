package com.partha.mm.example01;

import java.util.ArrayList;

/**
 * 1.this program is to understand how object passing works in java
 * 2. it is because of this property that the calledMethod can change object state of the callingMethod to we need to be careful 
 * 	  about values we pass. in case if we dont want the object to be modified then we have to make it immutable.
 * @author partha
 *
 */
public class App01PassingObjectArguments {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		//when we call the below method the pointer to list object is copied to the method argument
		//so changes done by the method is visible to the main method()
		addToList(list);
		list.stream().forEach(System.out::println);
		
		
		
		//lets see another example of how object passing between methods work
		Employee emp = new Employee(1, "partha");
		changeEmployeeName("mimi", emp);
		System.out.println("employeename:"+emp.name);
	}
	
	
	public static void addToList(ArrayList<String> list){
		list.add("four");
	}
	
	
	public static Employee changeEmployeeName(String updatedName,Employee emp){
		emp.name = updatedName;
		return emp;
	}
	
	
	
	
	public static class Employee {
		int empId;
		String name;
		
		public Employee(int empId, String name) {
			super();
			this.empId = empId;
			this.name = name;
		}
		
		
	}

}
