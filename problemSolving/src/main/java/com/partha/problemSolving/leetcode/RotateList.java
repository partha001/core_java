package com.partha.problemSolving.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/rotate-list/
 * @author biswaspa
 *
 */
public class RotateList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		new Solution2().rotateRight(head, 4);
	}
	

	/**
	 * timeComplexity : O(n)
	 * spaceComplexity: O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public ListNode rotateRight(ListNode head, int k) {
	        if(head==null)
	            return null;
	        if(k==0)
	            return head;
	        
	        Stack<ListNode> stack = new Stack();
	        ListNode current = head;
	        int count =0;
	        int rotations = 0;
	        while(current!=null){
	            count++;
	            stack.push(current);
	            current = current.next;
	        }	        

	        if(k>=count){
	            rotations = k % count;
	        }else{
	            rotations = k;
	        }
	        
	        for(int i=0;i<rotations;i++){
	            current = stack.pop();
	            ListNode temp = new ListNode(current.val);
	            temp.next = head;
	            head = temp;
	        }
	        if(!stack.isEmpty()){
	            current = stack.pop();
	            current.next = null;
	        }
	        return head;
	    }
	}
	
	
	/**
	 * timeComplexity : O(n) spaceComplexity: O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
		public ListNode rotateRight(ListNode head, int k) {
			if(head==null)
				return null;
			
			int listLength = 0;
			ListNode current = head;
			while(current!=null) {
				listLength++;
				current = current.next;
			}
			
			int rotations = 0;
			if(k<listLength) 
				rotations = k;
			else 
				rotations =  k % listLength;
			
			if(rotations==0)
				return head;
			
			current = head;
			for(int i=0;i<listLength-rotations;i++) {
				if(i==listLength-rotations-1)
					break;
				current = current.next;
			}
			
			ListNode newHead = current.next;
			current.next = null;
			
			current = newHead;
			while(current.next!=null) {
				current = current.next;
			}
			
			current.next = head;
			return newHead;
				
		}
	}
	
	
	 static public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

}
