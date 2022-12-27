package com.partha.leetcode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * @author partha
 *
 */
public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution {
	    public ListNode middleNode(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
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
