package com.partha.problemSolving.linkedlists;

/**
 * this solution is complete
 * @author parbiswa
 *
 */
public class ReverseDoublyLinkedListIterativeApproach01 {

	public static void main(String[] args) {
		LinkedList list = new ReverseDoublyLinkedListIterativeApproach01.LinkedList();
		list.head = new ReverseDoublyLinkedListIterativeApproach01.Node(10);
		list.head.next = new ReverseDoublyLinkedListIterativeApproach01.Node(20);
		list.head.next.next = new ReverseDoublyLinkedListIterativeApproach01.Node(30);
		
		Node reversedHead = reverse(list.head);
		LinkedList reverseList = new ReverseDoublyLinkedListIterativeApproach01.LinkedList(reversedHead);
		printList(reverseList);
		
	}
	
	 /* Function to reverse the linked list */
   static Node reverse(Node node) { 
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 

	public static void printList(LinkedList list){
		System.out.println("printing list");
		Node current = list.head;
		while(current!=null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("");
	}

	static class LinkedList{

		Node head;

		LinkedList(){
			super();
		}
		
		LinkedList(Node node){
			super();
			this.head = node;
		}

	}



	static class Node{

		int data;
		Node next;

		Node(int data){
			super();
			this.data = data;
		}

	}

}
