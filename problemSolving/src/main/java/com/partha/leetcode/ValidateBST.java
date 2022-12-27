package com.partha.leetcode;

/**
 * problem: https://leetcode.com/problems/validate-binary-search-tree/
 * referrence : https://www.youtube.com/watch?v=MILxfAbIhrE
 */
public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		new Solution1().isValidBST(root);
	}

	
	// this is the official solution
	private static class Solution1 {
		
		public boolean isValidBST(TreeNode root) {
	        return validate(root, null, null);
	    }
		
	    public boolean validate(TreeNode root, Integer low, Integer high) {
	        // Empty trees are valid BSTs.
	        if (root == null) {
	            return true;
	        }
	        // The current node's value must be between low and high.
	        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
	            return false;
	        }
	        // The left and right subtree must also be valid.
	        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
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
