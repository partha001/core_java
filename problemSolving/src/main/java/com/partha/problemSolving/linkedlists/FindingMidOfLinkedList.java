package com.partha.problemSolving.linkedlists;

public class FindingMidOfLinkedList {

	private class LinkedList{
		Node head;

		public void addFirst(int data){
			Node newNode= new Node(data);
			if(this.head==null)
				this.head=newNode;
			else{
				newNode.next = this.head;
				this.head=newNode;		
			}
		}
		
		public void addLast(int data){
			Node newNode = new Node(data);
			if(this.head==null){
				this.head=newNode;
			}else{
				Node currentNode = this.head;
				while(currentNode!=null){
					if(currentNode.next==null){
						currentNode.next=newNode;
						break;
					}
					currentNode = currentNode.next;
				}
				
			}
		}


		public void print(){
			String result ="";
			Node currentNode = this.head;
			while(currentNode!=null){
				result += currentNode.data +" => ";
				currentNode = currentNode.next;
			}
			result +="NULL";
			System.out.println(result);
		}


	}

	private class Node{
		int data;
		Node next;

		Node(int data){
			super();
			this.data=data;
		}
	}

	public static void main(String[] args) {
		FindingMidOfLinkedList example = new FindingMidOfLinkedList();
		LinkedList ll = example.new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		//ll.print();
		printMiddle(ll);

	}
	
	public static void printMiddle(LinkedList ll) 
	    { 
	        Node slow_ptr = ll.head; 
	        Node fast_ptr = ll.head; 
	        if (ll.head != null) 
	        { 
	            while (fast_ptr != null && fast_ptr.next != null) 
	            { 
	                fast_ptr = fast_ptr.next.next; 
	                slow_ptr = slow_ptr.next; 
	            } 
	            System.out.println("The middle element is [" + 
	                                slow_ptr.data + "] \n"); 
	        } 
	    } 
	
	
	

}
