package com.partha.mm.example02;

/**
 * This program is to demonstrate how memory is consumed with creation of objects
 * and then if garbage collection runs at some point of time then the memory will be 
 * freed
 * @author partha
 *
 */
public class App02 {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		long availableMemoryBytes = runtime.freeMemory();
		System.out.println("available memory :"+ availableMemoryBytes/1024 +"k");
		
		for(int i=0;i<=10000000;i++){
			Customer customer = new Customer(i,"customer"+i+1);
		}
		
		availableMemoryBytes = runtime.freeMemory();
		System.out.println("available memory :"+ availableMemoryBytes/1024 +"k");
		
		System.gc();
		
		availableMemoryBytes = runtime.freeMemory();
		System.out.println("available memory :"+ availableMemoryBytes/1024 +"k");
		
		
	}
	
	public static class Customer {
		int customerid;
		String name;
		
		public Customer(int customerid, String name) {
			super();
			this.customerid = customerid;
			this.name = name;
		}
		
		
	}

}
