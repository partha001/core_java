package com.partha.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 * @author biswaspa
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * timecomplexity: O(n)
	 * spacecomplexity:O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		public boolean hasCycle(ListNode head) {
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
	
	
	/**
	 * timecomplexity :O(N+K)  here k=cyclic length K
	 * spacecomplexity: O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
		public boolean hasCycle(ListNode head) {
		    if (head == null || head.next == null) {
		        return false;
		    }
		    ListNode slow = head;
		    ListNode fast = head.next;
		    while (slow != fast) {
		        if (fast == null || fast.next == null) {
		            return false;
		        }
		        slow = slow.next;
		        fast = fast.next.next;
		    }
		    return true;
		}
	}
	
	
	

	  //Definition for singly-linked list.
	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }

}
