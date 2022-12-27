package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author partha
 *
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	 
	 
	private static class Solution {
	    public int maxDepth(TreeNode root) {
	        if(root==null)
	            return 0;
	        int leftMax = maxDepth(root.left);
	        int rightMax = maxDepth(root.right);
	        return Math.max(leftMax,rightMax) +1 ;
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
