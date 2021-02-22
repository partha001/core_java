package com.partha.problemSolving.leetcode;

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

	static class TreeNode {
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

	static class Solution1 {

		public boolean isValidBST(TreeNode root) {
			return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
		}


		public boolean isValid(TreeNode root ,long min, long max){
			if(root==null){
				return true;
			}
			if(root.val<=min || root.val>=max){
				return false;
			}
			return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
		}

	}

}
