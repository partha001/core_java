package com.partha.ds01.linkedlist.singlylinked01;

public class Application {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node node= new Node(10);
		ll.addFirst(node);
		node = new Node(20);
		ll.addFirst(node);
		System.out.println(ll.toString()); 		// 20 , 10 
		node = new Node(30);
		ll.addLast(node);
		System.out.println(ll.toString());		//20 , 10, 30
		//printing length
		System.out.println(ll.length());		//03
		//deleting element from head
		ll.deleteFromHead();
		System.out.println(ll.toString());		// 10, 30
		//testing the find() with an item that is present
		System.out.println(ll.find(25));		//this will print null since the data is not present
		//testing the find() with an item that is present
		System.out.println(ll.find(10));		//this will print hashcode of the node
	}

}
