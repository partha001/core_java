package com.partha.mm.example02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class App03 {

	public static void main(String[] args) {

		CustomerManager cm = new CustomerManager();
		CustomerGenerator task = new CustomerGenerator(cm);
		for (int user = 0; user < 10; user++) {
			Thread t = new Thread(task);
			t.start();
		}
		
		//main thread is now acting as the monitoring thread
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cm.howManyCustomers();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
			
		}


	}


	public static class CustomerGenerator implements Runnable {

		private CustomerManager cm;
		private int totalCustomersGenerated = 0;
		
		public CustomerGenerator(CustomerManager cm) {
			this.cm = cm;
		}
		
		@Override
		public void run() {
			while (true) {		
			try {
				Thread.sleep((1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Simulate user adding a customer through a web page
			String name = new UUID(1l,10l).toString();
			Customer c = new Customer(name);
			cm.addCustomer(c);
			totalCustomersGenerated++;
			cm.getNextCustomer();
			//System.out.println(totalCustomersGenerated);
			}
		}

	}


	public static class CustomerManager {

		private List<Customer> customers = new ArrayList<Customer>();
		private int nextId = 0;

		public  void addCustomer(Customer customer) {
			synchronized (this) {
				customer.setId(nextId);
				nextId++;
			}
			customers.add(customer);
		}
		
		public Customer getNextCustomer() {
			//should do:
			//customers.remove(0);
			return customers.get(0);
		}

		public void howManyCustomers() {
			int size = 0;
			size = customers.size();
			System.out.println("" + new Date() + " : " + size);
		}

		public void displayCustomers() {
			synchronized(customers){
				for (Customer c : customers) {
					System.out.println(c.toString());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}



	}


	public static class Customer{

		private int id;
		private String name;
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String toString() {
			return id + " : " + name;
		}
		
		public Customer(String name) {
			super();
			this.name = name;
		}

	}
	 	
}
