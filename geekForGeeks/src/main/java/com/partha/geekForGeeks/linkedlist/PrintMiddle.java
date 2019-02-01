package com.partha.geekForGeeks.linkedlist;

import java.util.LinkedList;

public class PrintMiddle {

	public static void main(String[] args) {
		LinkedList<Integer> list= new LinkedList<>();
		list.add(10);
		list.add(26);
		list.add(30);
		list.add(5);

	}

	/**
	 * method1:
	 */
	public static void printMiddle(LinkedList<Integer> list){
		int count=list.size();
		if(count%2==0)
			System.out.println("there are");
	}


	/* Function to print middle of linked list */
	void printMiddle1(LinkedList<Integer> list) 
	{ 
		Integer slow_ptr = list.; 
//		Node fast_ptr = list.getFirst().; 
//		if (head != null) 
//		{ 
//			while (fast_ptr != null && fast_ptr.next != null) 
//			{ 
//				fast_ptr = fast_ptr.next.next; 
//				slow_ptr = slow_ptr.next; 
//			} 
//			System.out.println("The middle element is [" + 
//					slow_ptr.data + "] \n"); 
//		} 


	}

}
