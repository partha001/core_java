package com.partha.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * @author partha
 *
 */
public class LinkedListCycle {

	public static void main(String[] args) {

	}


	//takes less memory and less execution time than the previous solution
	// practice this solution
	private static class Solution2 {
		
		public boolean hasCycle(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			while(fast!=null && fast.next!=null){
				fast = fast.next.next;
				slow = slow.next;

				if(fast==slow)
					return true;
			}
			return false;
		}
	}




	private static class Solution1 {

		boolean hasCycle(ListNode head) {
			Set<ListNode> nodesSeen = new HashSet<>();
			while (head != null) {
				if (nodesSeen.contains(head)) {
					return true;
				} else {
					nodesSeen.add(head);
				}
				head = head.next;
			}
			return false;
		}
	}




	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
