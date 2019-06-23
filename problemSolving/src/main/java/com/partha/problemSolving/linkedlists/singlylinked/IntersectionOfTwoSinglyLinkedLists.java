package com.partha.problemSolving.linkedlists.singlylinked;

import java.util.HashSet;

public class IntersectionOfTwoSinglyLinkedLists {

	public static void main(String[] args) {

		// constructing the two lists		
		LinkedList list1 = new IntersectionOfTwoSinglyLinkedLists.LinkedList();
		list1.head = new IntersectionOfTwoSinglyLinkedLists.Node(40);
		list1.head.next = new IntersectionOfTwoSinglyLinkedLists.Node(20);
		list1.head.next.next = new IntersectionOfTwoSinglyLinkedLists.Node(25);
		//list1.head.next.next.next = new IntersectionPointOfTwoSinglyLinkedList.Node(40);
		
		
		LinkedList list2 = new IntersectionOfTwoSinglyLinkedLists.LinkedList();
		list2.head = new IntersectionOfTwoSinglyLinkedLists.Node(110);
		list2.head.next = new IntersectionOfTwoSinglyLinkedLists.Node(330);
		
		 findIntersectionPoint( list1 , list2);
		
	}
	
	
	static class LinkedList{
		Node head;
	}
	
	
	static class Node{
		int value ;
		Node next;
		public Node(int value) {
			super();
			this.value = value;
		}		
	}
	
	
	/**
	 * this is one way of finding the intersection . however this has complexity O(m*n)
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static void findIntersectionPoint(LinkedList list1 ,LinkedList list2){
		
		HashSet<Node> set = new HashSet<>();
		
		IntersectionOfTwoSinglyLinkedLists.Node ptr1 = list1.head;
		IntersectionOfTwoSinglyLinkedLists.Node ptr2 = list2.head;
		
		while(ptr1!=null){
			ptr2 =  list2.head;
			while(ptr2 != null){
				if(ptr1.value == ptr2.value){
					set.add(ptr1);
				}				
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next ;
		}
		
		if(set.size() == 0) System.out.println("no intersection");
		set.stream().forEach(n -> System.out.println(n.value));
		
	}
	

}
