package com.partha.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author biswaspa
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(3);
		
		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(4);
		
		ListNode addTwoNumbers = new Solution().addTwoNumbers(list1, list2);
		System.out.println();
	}


	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	static class Solution {	int carry=0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode current = null;
		while(l1!=null || l2!=null){            
			if(l1!=null && l2!=null){ 
				if(result==null){
					result = util(l1.val , l2.val);
					current = result;
				}else{
					current.next = util(l1.val , l2.val);
					current = current.next;
				}                
				l1 = l1.next;
				l2 = l2.next; 
				
			}else if(l1!=null && l2==null){
				if(result==null){
					result = util(l1.val , 0);
					current = result ;
				}else{
					current.next = util(l1.val , 0);
					current = current.next;
				}                
				l1 = l1.next;
			}else if(l2!=null && l1==null){
				if(result==null){
					result = util(0, l2.val);
					current = result ;
				}else{
					current.next = util(0, l2.val);
					current = current.next;
				}              
				l2 = l2.next;
			}			
		}
        
        if(carry!=0) current.next = new ListNode(carry);
		return result;
	}



	private ListNode util(int i,int j ){
		int sum = i + j + carry;
		ListNode node = new ListNode(sum%10);
		carry = sum/10;
		return node;
	}
}

}
