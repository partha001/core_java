package com.partha.leetcode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author biswaspa
 *
 */
public class ConvertSortedListToBST {

	public static void main(String[] args) {

	}
	
	
	//binary search based solution based using no extra space
	private static class Solution1 {
	    public TreeNode sortedListToBST(ListNode head) {
	        return convert(head,0,length(head)-1);
	    }
	    
	    
	    public TreeNode convert(ListNode node,int start,int end){
	        if(start<=end){
	            //int mid= (start+end)/2;
	            ListNode midNode = node;
	            int midIdx = start;
	            for(;midIdx < start + (end-start)/2;midIdx++){
	                    midNode = midNode.next;
	            }
	            TreeNode newNode = new TreeNode(midNode.val);
	            newNode.left = convert(node,start,midIdx-1);
	            newNode.right = convert(midNode.next,midIdx+1,end);
	            return newNode;
	        }else{
	            return null;
	        }
	    }
	    
	    
	    public int length(ListNode node){
	        int count=0;
	        while(node!=null){
	            count++;
	            node = node.next;
	        }
	        return count;
	    }
	}
	
	
	//this is another approach . its the same as above just that here the mid is found using two pointer
	private static class Solution2 {
	    public TreeNode sortedListToBST(ListNode head) {
	        return convert(head,null);
	    }
	    
	    
	    public TreeNode convert(ListNode start,ListNode end){
	        if(start!=end){
	            ListNode midNode = findMid(start,end);            
	            TreeNode newNode = new TreeNode(midNode.val);
	            newNode.left = convert(start,midNode);
	            newNode.right = convert(midNode.next,end);
	            return newNode;
	        }else{
	            return null;
	        }
	    }
	    
	    
	   private ListNode findMid(ListNode start,ListNode end){
	       ListNode slow = start;
	       ListNode fast= start;
	       while(fast!=end && fast.next!=end){
	           slow = slow.next;
	           fast = fast.next.next;
	       }
	       return slow;
	   }
	}
	
	
	

	//Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	//Definition for a binary tree node.
	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

}
