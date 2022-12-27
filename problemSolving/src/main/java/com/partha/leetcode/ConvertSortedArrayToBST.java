package com.partha.leetcode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author biswaspa
 *
 */
public class ConvertSortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	private static class Solution1 {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums.length==0)
	            return null;
	        return buildBST(nums,0,nums.length-1);
	        
	    }
	    
	    
	    public TreeNode buildBST(int[] nums,int start,int end){
	        if(start<=end){
	            int mid=(start + end)/2;
	            TreeNode node = new TreeNode(nums[mid]);
	            node.left = buildBST(nums,start,mid-1);
	            node.right = buildBST(nums,mid+1,end);
	            return node;                
	        }
	        return null;
	    }
	}
	
	
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
