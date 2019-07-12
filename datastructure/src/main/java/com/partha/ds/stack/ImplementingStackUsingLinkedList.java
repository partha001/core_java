package com.partha.ds.stack;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ImplementingStackUsingLinkedList {

	public static void main(String[] args) {
		 MyStack myStack = new ImplementingStackUsingLinkedList().new MyStack();
		 myStack.push(10);
		 myStack.push(20);
		 myStack.push(30);
		 System.out.println("printing initial stack");
		 myStack.printStack();
		 System.out.println("\nvalue popped = "+ myStack.pop());
		 myStack.printStack();
		 System.out.println("pushing 50 to stack");
		 myStack.push(50);
		 myStack.printStack();
		 System.out.println("\nvalue popped = "+ myStack.pop());
		 System.out.println("\nvalue popped = "+ myStack.pop());
		 System.out.println("\nvalue popped = "+ myStack.pop());
		 System.out.println("\nvalue popped = "+ myStack.pop());
	}

	@Getter
	@Setter
	class MyStack {

		private LinkedList ll;

		MyStack(){
			ll = new LinkedList();
		}

		public void push(int data){
			Node node = new Node(data);
			if(ll.head == null){
				ll.head = node;
			}else {
				node.next = ll.head;
				ll.head = node;
			}

		}
		
		public int pop(){
			if(ll.head==null){
				throw new NullPointerException("no data available to pop"); 
			}else{
				int value = ll.head.data;
				ll.head = ll.head.next;
				return value;
			}
		}


		public void printStack(){
			System.out.println("\n");
			Node current = ll.head;
			while(current!= null){
				System.out.print("-> "+current.data);
				current = current.next;
			}
		}

	}

	@NoArgsConstructor
	class LinkedList {

		Node head;

	}

	@NoArgsConstructor
	class Node{
		int data;
		Node next;
		Node previous;

		Node(int data){
			super();
			this.data = data;
		}
	}
	

}
