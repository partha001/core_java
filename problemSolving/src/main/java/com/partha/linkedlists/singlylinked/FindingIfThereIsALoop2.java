package com.partha.linkedlists.singlylinked;

import java.util.HashSet;
import java.util.Set;

/*
 * this is a more effecient way of checking as it traverses the link 
 * only ones but makes uses of other datastructures
 */
public class FindingIfThereIsALoop2 {

	public static void main(String[] args) {

	}
	
	public static boolean hasLoop(Node node){
		if(node == null)
			return false;
		else{
			Node current = node;
			Set set = new HashSet<Node>();
			while(node!=null){
				if(set.contains(node)){
					return true;
				}else{
					set.add(node);
					node = node.next;
				}
			}
			return false;
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
