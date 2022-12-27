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
	
	
	//takes less memory and less execution time than the previous solution
	private static class Solution2 {
	     boolean hasCycle(ListNode node) {
	      
			  if(node==null)
				return false;
	        
				boolean flag = false;
				ListNode slowPointer = node;
				ListNode fastPointer = node.next; 
				while(fastPointer!=null && 
						slowPointer!=null && 
						fastPointer.next!=null // this condition avoid null pointer exception
						){
					fastPointer = fastPointer.next.next;
					slowPointer = slowPointer.next;	
					if(slowPointer==fastPointer){
						flag = true;
						break;
					}
				}
				return flag;	        
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
