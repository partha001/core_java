package com.partha.problemSolving.linkedlists.singlylinked;



public class ReversingASinglyLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new ReversingASinglyLinkedList.Node(10);
		list.head.next = new  ReversingASinglyLinkedList.Node(20);
		list.head.next.next = new  ReversingASinglyLinkedList.Node(30);
		printList(list);
		printList(reversingLinkedList(list));
		
	}
	
	
	public static LinkedList reversingLinkedList(LinkedList  list){
		LinkedList reversedLinkedList = new LinkedList();
		Node current = list.head;
		while(current!=null){
			Node newNode = null;
			if(reversedLinkedList.head == null){
				newNode = new Node(current.data);
				reversedLinkedList.head = newNode;
			}else{
				newNode = new Node(current.data);
				newNode.next = reversedLinkedList.head;
				reversedLinkedList.head = newNode;
			}
			current = current.next;
		}
		return reversedLinkedList;
	}
	
	public static void printList(LinkedList list){
		System.out.println("");
		ReversingASinglyLinkedList.Node current = list.head;
		while(current!=null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}
	
	
	static class LinkedList{
		
		Node head;
		
		int size =0;
		
		public LinkedList() {
			this.head = null;
		}
		
		public LinkedList(int data) {
			Node node = new Node();
			node.data = data;
			node.next = null;
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
