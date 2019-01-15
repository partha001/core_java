package com.partha.ds01.linkedlist.doublylinked01;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList dll= new DoublyLinkedList();
		//inserting the first node
		Node node = new Node(10);
		dll.addFirst(node);
		System.out.println(dll.toString());  //10
		//adding another node at first 
		node = new Node(5);
		dll.addFirst(node);
		System.out.println(dll.toString()); // 5,10
		//checking if the length() is working properly or not
		System.out.println(dll.length());   //2
		
	}

}
