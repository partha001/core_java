package com.partha.leetcode;

/**
 *  https://leetcode.com/problems/invert-binary-tree
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	//recursive solution
	private static class Solution1 {
		public TreeNode invertTree(TreeNode root) {
			if(root == null) return null;
			TreeNode tmp = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(tmp);
			return root;
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
