package com.partha.problemSolving.linkedlists;



public class ReversingASinglyLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new ReversingASinglyLinkedList.Node(10);
		list.head.next = new  ReversingASinglyLinkedList.Node(20);
		list.head.next.next = new  ReversingASinglyLinkedList.Node(30);
		list.printList();
		
		
		
		
	}
	

	
	
	static class LinkedList{
		
		Node head;
		
		public LinkedList() {
			this.head = null;
		}
		
		public LinkedList(int data) {
			Node node = new Node();
			node.data = data;
			node.next = null;
		}
		
		public LinkedList reversingLinkedList(){
			LinkedList reversedLinkedList = new 
			
		}
		
		
		public void printList(){
			System.out.println("");
			ReversingASinglyLinkedList.Node current = this.head;
			while(current!=null){
				System.out.print(current.data + " -> ");
				current = current.next;
			}
		}
		
		
	}
	
	
	static class Node{
		
		private int data;
		private Node next;
			
		public Node() {
			super();
		}

		Node(int data){
			super();
			this.data = data;			
		}
		
	}

}
