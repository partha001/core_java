package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 */
public class Day10Problem2IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(10);
		head1.next = new ListNode(20);
		//head1.next.next = new ListNode(30);
		
		ListNode head2 = new ListNode(30);
		//head2.next = new ListNode(50);
		
		System.out.println(new Solution3().getIntersectionNode(head1, head2));
	}
	
	

	  //Definition for singly-linked list.
	  static  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	/**
	 * naive solution with complexity
	 * timecomplexity O(mxn)
	 * space 
	 * @author biswaspa
	 *
	 */
	  static  class Solution1 {
		    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		       ListNode a=headA,b;
		        while(a!=null){
		            b = headB;
		            while(b!=null){
		              if(a == b) return a;
		              b = b.next;
		            }
		            a = a.next;
		        }
		        return null;
		    }
		}
	  
	  
	  static class Solution2 {
		    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		        ListNode a=headA,b=headB;
		        Set<ListNode> seen  = new HashSet<>();
		        while(a!=null){
		            seen.add(a);
		            a=a.next;
		        }
		     
		        while(b!=null){
		            if(!seen.add(b)) return b;
		            b=b.next;
		        }
		        return null;
		     }
		 }
	  
	  
	  static class  Solution3 {
		    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		        ListNode a=headA, b=headB;
		        while(a!=b){
		            if(a==null) 
		            	a=headB;
		            else  
		            	a=a.next;
		            
		            if(b==null) 
		            	b=headA;
		            else 
		            	b=b.next;
		        }
		        return a;
		    }
		}

}
