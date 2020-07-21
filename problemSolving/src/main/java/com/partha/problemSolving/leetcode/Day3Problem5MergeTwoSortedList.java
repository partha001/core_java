package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/merge-two-sorted-lists/
 * @author biswaspa
 *
 */
public class Day3Problem5MergeTwoSortedList {

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
	


	//this is the most intutive solution
	static class Solution1 {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

			if(l1==null && l2==null) {
				return null;
			}else if(l1==null && l2!=null) {
				return l2;
			}else if(l2==null && l1!=null) {
				return l1;
			}else {

				ListNode root = null;
				ListNode current = null;
				while(l1!=null && l2!=null){
					if(l1.val <= l2.val ){

						if(root==null){
							root = new ListNode(l1.val);
							current = root;
						}else{
							current.next = new ListNode(l1.val);
							current = current.next;
						}
						l1 = l1.next;               

					}else{

						if(root==null){
							root = new ListNode(l2.val);
							current = root;
						}else{
							current.next = new ListNode(l2.val);
							current = current.next;

						}
						l2 = l2.next;
					}
				}

				//if list1 is not exhausted
				while(l1!=null){
					current.next = new ListNode(l1.val);
					current = current.next;
					l1 = l1.next;
				}


				//if list2 is not exhausted
				while(l2!=null){
					current.next = new ListNode(l2.val);
					current = current.next;
					l2 = l2.next;
				}
				return root;
			}

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
