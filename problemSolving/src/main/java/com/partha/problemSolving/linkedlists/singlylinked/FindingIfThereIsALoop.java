package com.partha.problemSolving.linkedlists.singlylinked;

public class FindingIfThereIsALoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		
		
		System.out.println(hasLoop(list.head));
	}
	
	public static boolean hasLoop(Node node){
		if(node==null){
			return false;
		}else{
			//i.e. if the pointers traverse the list at different speed then they will meet
			//meet sometime if there is a loop
			boolean flag = false;
			Node slowPointer = node;
			Node fastPointer = node.next; 
			while(fastPointer!=null && 
					slowPointer!=null && 
					fastPointer.next!=null 
					// this condition avoid null pointer exception
					){
				fastPointer = fastPointer.next.next;
				slowPointer = slowPointer.next;	
				if(slowPointer==fastPointer){
					flag = true;
					break;
				}
			}
			return flag;
		}
	}
	
	public static class LinkedList {
		Node head;
		
	}
	
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
		}
		
		
	}

}
