package com.partha.problemSolving.leetcode;

/**
 * @problem : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * @author biswaspa
 *
 */
public class BinarySearchTreeToGreaterSumTree {
	
	public static void main(String[] args) {
		
	}
	
	
	static class Solution {
	    int sum = 0;
	   
	    public TreeNode bstToGst(TreeNode root) {
	        if(root==null)
	            return root;
	        bstToGst(root.right);
	        root.val = sum + root.val;
	        sum = root.val;
	        bstToGst(root.left);
	        return root;
	    }
	}
	
	
	
	 public class TreeNode {
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
