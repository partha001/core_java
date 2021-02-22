package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * @author biswaspa
 *
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	private static class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        if(head==null || head.next == null)
	            return head;
	        
	        ListNode odd = head , even = odd.next , evenHead = even;
	        while(even!=null && even.next!=null){
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	}
	
	
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
