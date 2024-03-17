package com.partha.leetcode;

/**
 * link : https://leetcode.com/problems/merge-two-sorted-lists/
 * @author biswaspa
 *
 */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1 = null;

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		new Solution1().mergeTwoLists(l1, l2);

	}
	
	
	/**
	 * explanation : https://www.youtube.com/watch?v=XIdigk956u0
	 * @author partha
	 * practice this 
	 */
	private static class Solution1 {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	     ListNode dummy = new ListNode();
	     ListNode tail = dummy;

	     while(list1!=null & list2!=null){
	         if(list1.val<list2.val){
	             tail.next = list1;
	             list1 = list1.next;
	         }else{
	             tail.next = list2;
	             list2 = list2.next;
	         }
	         tail = tail.next;
	     }

	    if(list1!=null)
	         tail.next = list1;
	     

	    if(list2!=null)
	        tail.next = list2;


	     return dummy.next;
	    }
	}
	


	/**
	 * same code written in a different way. everything is taken care within the while loop.
	 */
	private static class Solution2 {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode dummy = new ListNode();
	        ListNode current = dummy;
	        while(list1!=null || list2!=null){
	            if(list1!=null && list2!=null){

	                if(list1.val<=list2.val){
	                    current.next = list1;
	                    current = current.next;
	                    list1 = list1.next;
	                }else{
	                    current.next = list2;
	                    current = current.next;
	                    list2 = list2.next;
	                }
	            }else{
	                if(list1!=null){
	                    current.next = list1;
	                    list1 = null; //this is to make the while loop break
	                }
	                if(list2!=null){
	                    current.next = list2;
	                    list2 = null;   //this is to make the while loop break
	                }
	            }
	        }
	        return dummy.next;
	    }
	}



	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


}
