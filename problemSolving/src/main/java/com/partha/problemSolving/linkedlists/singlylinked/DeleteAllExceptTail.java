package com.partha.problemSolving.linkedlists.singlylinked;

/**
 * @problemDefinition : https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @leetCodeProbNumber : 237
 * @author partha
 *
 */
public class DeleteAllExceptTail {

	public static void main(String[] args) {
		//when non static 
		LinkedList linkedList = (new DeleteAllExceptTail()).new LinkedList();
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(7);
		//LinkedList linkedList = new DeleteAllExceptTail.LinkedList();
		linkedList.removeAllButTail();
		System.out.println("");
		
	}
	
	
	class LinkedList{
		
		private Node head;
		
		public void addNode(int value){
			if(this.head==null){
				this.head=new Node(value);
			}else{
				Node currentNode = this.head;
				while(currentNode.next!=null){
					 currentNode = currentNode.next;
				}
				Node newNode = new Node(value);
				currentNode.setNext(newNode);;
			}
		}	
		
		public void removeAllButTail(){
			Node currentNode = this.head;
			while(currentNode.next!=null){
				currentNode = currentNode.next;
				
			}
			this.head= currentNode;
		}
		
	}
	
	
	  class Node{
		 
		private int value;
		private Node next;
			
		
		public Node(int value) {
			super();
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

}
