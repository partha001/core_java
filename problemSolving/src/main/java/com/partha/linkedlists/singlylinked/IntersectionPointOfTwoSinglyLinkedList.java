package com.partha.linkedlists.singlylinked;

public class IntersectionPointOfTwoSinglyLinkedList {

	public static void main(String[] args) {

		// constructing the two lists		
		LinkedList list1 = new IntersectionPointOfTwoSinglyLinkedList.LinkedList();
		list1.head = new IntersectionPointOfTwoSinglyLinkedList.Node(40);
		list1.head.next = new IntersectionPointOfTwoSinglyLinkedList.Node(20);
		list1.head.next.next = new IntersectionPointOfTwoSinglyLinkedList.Node(25);
		//list1.head.next.next.next = new IntersectionPointOfTwoSinglyLinkedList.Node(40);
		
		
		LinkedList list2 = new IntersectionPointOfTwoSinglyLinkedList.LinkedList();
		list2.head = new IntersectionPointOfTwoSinglyLinkedList.Node(30);
		list2.head.next = new IntersectionPointOfTwoSinglyLinkedList.Node(40);
		
		IntersectionPointOfTwoSinglyLinkedList.Node result = findIntersectionPoint( list1 , list2);
		
		System.out.println(result==null ? "no intersection point ": result.value);
			
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
	public static IntersectionPointOfTwoSinglyLinkedList.Node findIntersectionPoint(LinkedList list1 ,LinkedList list2){
		IntersectionPointOfTwoSinglyLinkedList.Node result = null;
		
		IntersectionPointOfTwoSinglyLinkedList.Node ptr1 = list1.head;
		IntersectionPointOfTwoSinglyLinkedList.Node ptr2 = list2.head;
		
		while(ptr1!=null){
			ptr2 =  list2.head;
			while(ptr2 != null){
				if(ptr1.value == ptr2.value){
					result = ptr1;
					break;
				}				
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next ;
		}		
		return result;
	}
	

}
