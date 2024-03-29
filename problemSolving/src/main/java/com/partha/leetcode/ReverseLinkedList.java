package com.partha.leetcode;

/**
 * link : https://leetcode.com/problems/reverse-linked-list/
 * @author biswaspa
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	//  Definition for singly-linked list.
	 private static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
	  /**
	   * iterative approach
	   * @author biswaspa
	   *
	   */
	private static class Solution1 {
	    public ListNode reverseList(ListNode head) {        
	       ListNode previous = null;
	        ListNode current = head;
	        ListNode next = null;
	        while(current!=null){
	            next = current.next ;
	            current.next = previous;
	            previous = current;
	            current = next;
	        }     
	        return previous; //returning previous since during last loop current assigned to null
	    }
	    
	}
	
	
	//there is a tail recursive solution

}
