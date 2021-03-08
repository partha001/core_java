package com.partha.problemSolving.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * @author biswaspa
 *
 */
public class MergeKSortedLists {

	public static void main(String[] args) {

	}



	/**
	 * my solution : brute force approach
	 * @author biswaspa
	 *
	 */
	private static class Solution {
		public ListNode mergeKLists(ListNode[] list) {
			ListNode head = null;
			ListNode current = null;
			while(!allEmpty(list)){
				int smallest = smallestIndex(list);
				if(head==null){
					head = new ListNode(list[smallest].val);
					current = head;
					list[smallest] = list[smallest].next;
				}else{
					current.next = new ListNode(list[smallest].val);
					current = current.next;
					list[smallest] = list[smallest].next;
				}
			}
			return head;
		}


		public int smallestIndex(ListNode[] list){
			Integer smallest = null;
			for(int i=0;i<list.length;i++){
				if(smallest==null && list[i]!=null){
					smallest = i;
					continue;
				}
				if(list[i]!=null && list[i].val<=list[smallest].val){
					smallest = i;
				}           
			}
			return smallest;
		}


		public boolean allEmpty(ListNode[] list){
			boolean result = true;
			for(ListNode node:list){
				if(node!=null){
					result = false;
					break;
				}
			}
			return result;
		} 
	}

	
	private static class Solution2 {
	    public ListNode mergeKLists(ListNode[] lists) {
	        
	        int n = lists.length;
	        if(n == 1){    // case when list is null
	            return lists[0];
	        }
	        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val - b.val);  //min_heap
	        
	        for(int i = 0;i<lists.length;i++){    //Time: O(k) + nlogk space:o(k)
	            ListNode current = lists[i];
	            if(current!=null){
	            pq.add(current);
	            }
	        }
	        
	        ListNode head = new ListNode(0);
	        ListNode current = head;
	        
	        while(!pq.isEmpty()){
	            
	            ListNode top = pq.remove();
	            current.next = top;
	            current = current.next;
	            
	            if(top.next!=null){
	                pq.add(top.next);
	            }
	        }
	        
	        return head.next;
	        
	    }
	}


	private static  class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
